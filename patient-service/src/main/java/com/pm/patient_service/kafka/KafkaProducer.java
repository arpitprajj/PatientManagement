package com.pm.patient_service.kafka;

import com.pm.patient_service.entity.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Slf4j
@Service
public class KafkaProducer {

    private final KafkaTemplate<String,byte[]>kafkaTemplate;
    public KafkaProducer(KafkaTemplate<String,byte[]>kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }
    public void sendEvent(Patient patient) {
        PatientEvent event = PatientEvent.newBuilder()
                .setPatientId(patient.getId().toString())
                .setEmail(patient.getEmail())
                .setName(patient.getName())
                .setEventType("Patient_Created")
                .build();

        try {
            kafkaTemplate.send("patient", event.toByteArray());
            log.info("Sucessfully sent event>>>>>>>>"+patient.getEmail());
        } catch (Exception e) {
            log.info("Error in creating patient info {}"+e,event);
        }
    }
}
