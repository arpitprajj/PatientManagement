package com.pm.patient_service.controller;

import com.pm.patient_service.dto.PatientDto;
import com.pm.patient_service.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/patient-service")
@Tag(name = "Patient",description = "API for patient Service")
public class PatientController {
    private PatientService patientService;
    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }
    @GetMapping("get/{id}")
    @Operation(description = "get patient")
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
    public ResponseEntity<PatientDto>updatePatient(@PathVariable String id,@Validated({Default.class}) @RequestBody PatientDto patientDto){
        PatientDto patientDto1=patientService.updatePatient(id,patientDto);
        return ResponseEntity.ok().body(patientDto1);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String>deletePatientById(@PathVariable String id){
        String res=patientService.deletePatientById(id);
        return ResponseEntity.ok().body(res);
    }


}
