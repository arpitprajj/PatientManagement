package com.pm.patient_service.dto;

import com.pm.patient_service.entity.Patient;

import java.util.UUID;

public class PatientMapper {
    public static Patient DTOtoPatient(PatientDto patientDto){
        Patient patient=new Patient();

       // patient.setId(UUID.fromString(patientDto.getId()));
        patient.setName(patientDto.getName());
        patient.setAddress(patientDto.getAddress());
        patient.setDob(patientDto.getDob());
        patient.setEmail(patientDto.getEmail());
        return patient;
    }
    public static PatientDto PatientToDTO(Patient patient){
        PatientDto patientDto=new PatientDto();
        patientDto.setId(String.valueOf(patient.getId()));
        patientDto.setName(patient.getName());
        patientDto.setEmail(patient.getEmail());
        patientDto.setAddress(patient.getAddress());
        patientDto.setDob(patient.getDob());
        return patientDto;
    }
}
