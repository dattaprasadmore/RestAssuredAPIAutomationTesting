package com.api.models.requests.workers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import com.api.utils.RandomDataGenerator;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkerRequest {
    private String firstName;
    private String lastName;
    private String aoid;
    private PersonAddress personAddress;
    private PersonCommunication personCommunication;

    public PersonAddress getPersonAddress() {
        return personAddress;
    }
    public void setPersonAddress(PersonAddress personAddress) {
        this.personAddress = personAddress;
    }
    public PersonCommunication getPersonCommunication() {
        return personCommunication;
    }
    public void setPersonCommunication(PersonCommunication personCommunication) {
        this.personCommunication = personCommunication;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Builder(toBuilder = true)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PersonAddress {
        private String buildingName = RandomDataGenerator.getBuildingName();
        private String streetName = RandomDataGenerator.getStreetName();
        private String cityName = RandomDataGenerator.getCityName();
        private String state = RandomDataGenerator.getState();
        private String countryCode = RandomDataGenerator.getCountryCode();
        private String postalCode = RandomDataGenerator.getPostalCode();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Builder(toBuilder = true)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PersonCommunication {
        private String emails = RandomDataGenerator.emails();
        private String landline = RandomDataGenerator.getPhoneNumber();
        private String mobile = RandomDataGenerator.getCellPhoneNumber();
    }
}