package com.pm.patient_service.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BillingServiceGrpcClient {

    public final BillingServiceGrpc.BillingServiceBlockingStub blockingStub;

    public BillingServiceGrpcClient(
            @Value("${billing.service.address:localhost}") String serverAddress,
            @Value("${billing.service.grpc.port:9001}") int serverPort
    ){
        log.info("Connecting to Billing Service GRPC at {}:{}",serverAddress,serverPort);
        ManagedChannel channel= ManagedChannelBuilder.forAddress(serverAddress,serverPort)
                .usePlaintext().build();
        blockingStub=BillingServiceGrpc.newBlockingStub(channel);
    }
    public BillingResponse createBillingAccount(String patientId,String name,String email){
        System.out.println("we are here");
        BillingRequest billingRequest=BillingRequest.newBuilder()
                .setPatientId(patientId)
                .setEmail(email)
                .setName(name)
                .build();
        BillingResponse response=blockingStub.createBillingAccount(billingRequest);
        log.info("Recieved the response {}",response);
        return response;
    }
}
