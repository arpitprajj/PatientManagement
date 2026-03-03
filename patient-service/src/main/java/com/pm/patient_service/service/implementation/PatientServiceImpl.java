package com.pm.patient_service.service.implementation;

import com.pm.patient_service.dto.PatientDto;
import com.pm.patient_service.dto.PatientMapper;
import com.pm.patient_service.entity.Patient;
import com.pm.patient_service.exception.EmailExistException;
import com.pm.patient_service.exception.PatientNotFoundException;
import com.pm.patient_service.grpc.BillingServiceGrpcClient;
import com.pm.patient_service.kafka.KafkaProducer;
import com.pm.patient_service.repository.PatientRepo;
import com.pm.patient_service.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepo patientRepo;
    private final KafkaProducer kafkaProducer;
    private final BillingServiceGrpcClient billingServiceGrpcClient;
    public PatientServiceImpl(PatientRepo patientRepo,KafkaProducer kafkaProducer,BillingServiceGrpcClient billingServiceGrpcClient){
        this.patientRepo=patientRepo;
        this.kafkaProducer=kafkaProducer;
        this.billingServiceGrpcClient=billingServiceGrpcClient;
    }

    @Override
    public PatientDto findPatientById(String id) {
        Patient patient=patientRepo.findById(UUID.fromString(id)).orElseThrow(()->new PatientNotFoundException("Patient Not Found"));
        return PatientMapper.PatientToDTO(patient);
    }

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        System.out.println(patientDto.getName());
        String mail=patientDto.getEmail();
        if(patientRepo.existsByEmail(mail)==true){
            throw new EmailExistException("This email already exist, try diffrent one");
        }
        Patient patient=PatientMapper.DTOtoPatient(patientDto);


        System.out.println(patient.getName());
        Patient patient1=patientRepo.save(patient);
        System.out.println("okay");
        billingServiceGrpcClient.createBillingAccount(patient1.getId().toString(),patient1.getName(),patient1.getEmail());
        kafkaProducer.sendEvent(patient1);

        return PatientMapper.PatientToDTO(patient1);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient>patientList=patientRepo.findAll();
        List<PatientDto>patientDtos=patientList.stream().map(patient -> PatientMapper.PatientToDTO(patient)).toList();
        return patientDtos;
    }

    @Override
    public PatientDto updatePatient(String id, PatientDto patientDto) {
        Patient patient=patientRepo.findById(UUID.fromString(id)).orElseThrow(()->new PatientNotFoundException("Patient not Found with"+id));
        if(patientRepo.existsByEmail(patientDto.getEmail())==true){
            throw new EmailExistException("This email already exist, try diffrent one");
        }
        patient.setEmail(patientDto.getEmail());
        patient.setName(patientDto.getName());
        patient.setDob(patientDto.getDob());
        patient.setAddress(patientDto.getAddress());
        Patient updatedPatient=patientRepo.save(patient);
        return PatientMapper.PatientToDTO(updatedPatient);
    }

    @Override
    public String deletePatientById(String id) {
        Patient patient=patientRepo.findById(UUID.fromString(id)).orElseThrow(()->new PatientNotFoundException("Patient Not Found with "+id));

        if(patient!=null) {
            patientRepo.deleteById(UUID.fromString(id));
            return "Patient with Id " + id + " deleted Successfully";
        }

        return "Patient not found";
    }
}
