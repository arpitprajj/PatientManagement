package com.pm.patient_service.controller;

import com.pm.patient_service.dto.PatientDto;
import com.pm.patient_service.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/patient-service")
public class PatientController {
    private PatientService patientService;
    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }
    @GetMapping("get/{id}")
    public ResponseEntity<PatientDto> getPatientByID(@PathVariable String id){
        PatientDto patientDto=patientService.findPatientById(id);
        return ResponseEntity.ok(patientDto);

    }
    @PostMapping("create")
    public ResponseEntity<PatientDto>createPatient(@Valid @RequestBody PatientDto patientDto) {
        System.out.println(patientDto.getName());
        PatientDto patientDto1=patientService.createPatient(patientDto);
        return new ResponseEntity(patientDto1, HttpStatus.CREATED);
    }

    @GetMapping("get")
    public ResponseEntity<List<PatientDto>> getAllPatients(){
        List<PatientDto> patientDtos=patientService.getAllPatients();
        return  new ResponseEntity<>(patientDtos,HttpStatus.FOUND);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<PatientDto>updatePatient(@PathVariable String id,@Valid @RequestBody PatientDto patientDto){
        PatientDto patientDto1=patientService.updatePatient(id,patientDto);
        return ResponseEntity.ok().body(patientDto1);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String>deletePatientById(@PathVariable String id){
        String res=patientService.deletePatientById(id);
        return ResponseEntity.ok().body(res);
    }


}
