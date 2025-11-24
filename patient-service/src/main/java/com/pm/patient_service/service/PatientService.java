package com.pm.patient_service.service;

import com.pm.patient_service.dto.PatientDto;

import java.util.List;

public interface PatientService {
  PatientDto findPatientById(String id);
  PatientDto createPatient(PatientDto patientDto);
  List<PatientDto>getAllPatients();
  PatientDto updatePatient(String id,PatientDto patientDto);
  String deletePatientById(String id);

}
