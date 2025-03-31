package com.api.models.requests.workers;

import com.api.utils.RandomDataGenerator;

public class WorkerPayload {
    public static WorkerRequest getCreateWorkerPayloadFromPojo() {
        return WorkerRequest
                .builder()
                .firstName(RandomDataGenerator.getRandomFirstName())
                .lastName(RandomDataGenerator.getRandomLastName())
                .aoid(RandomDataGenerator.getRandomAlphaNumericText(15).toUpperCase())
                .personAddress(new WorkerRequest.PersonAddress())
                .personCommunication(new WorkerRequest.PersonCommunication())
                .build();
    }
}