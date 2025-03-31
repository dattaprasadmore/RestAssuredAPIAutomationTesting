package com.api.models.response.workers;

import lombok.EqualsAndHashCode;

public class WorkerResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String aoid;
    private PersonAddress personAddress;
    private PersonCommunication personCommunication;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAoid() {
        return aoid;
    }

    public void setAoid(String aoid) {
        this.aoid = aoid;
    }

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

    @Override
    public String toString() {
        return "WorkerResponse{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", aoid='" + aoid + '\'' +
                ", personAddress=" + personAddress +
                ", personCommunication=" + personCommunication +
                '}';
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof WorkerResponse)) return false;
        final WorkerResponse other = (WorkerResponse) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId())return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        final Object this$aoid = this.getAoid();
        final Object other$aoid = other.getAoid();
        if (this$aoid == null ? other$aoid != null : !this$aoid.equals(other$aoid)) return false;
        final Object this$personAddress = this.getPersonAddress();
        final Object other$personAddress = other.getPersonAddress();
        if (this$personAddress == null ? other$personAddress != null : !this$personAddress.equals(other$personAddress))
            return false;
        final Object this$personCommunication = this.getPersonCommunication();
        final Object other$personCommunication = other.getPersonCommunication();
        if (this$personCommunication == null ? other$personCommunication != null : !this$personCommunication.equals(other$personCommunication))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof WorkerResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $aoid = this.getAoid();
        result = result * PRIME + ($aoid == null ? 43 : $aoid.hashCode());
        final Object $personAddress = this.getPersonAddress();
        result = result * PRIME + ($personAddress == null ? 43 : $personAddress.hashCode());
        final Object $personCommunication = this.getPersonCommunication();
        result = result * PRIME + ($personCommunication == null ? 43 : $personCommunication.hashCode());
        return result;
    }

    // Inner class for PersonAddress
    @EqualsAndHashCode
    public static class PersonAddress {
        private int addressId;
        private String buildingName;
        private String streetName;
        private String cityName;
        private String state;
        private String countryCode;
        private String postalCode;

        public int getAddressId() {
            return addressId;
        }

        public void setAddressId(int addressId) {
            this.addressId = addressId;
        }

        public String getBuildingName() {
            return buildingName;
        }

        public void setBuildingName(String buildingName) {
            this.buildingName = buildingName;
        }

        public String getStreetName() {
            return streetName;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        @Override
        public String toString() {
            return "PersonAddress{" +
                    "addressId=" + addressId +
                    ", buildingName='" + buildingName + '\'' +
                    ", streetName='" + streetName + '\'' +
                    ", cityName='" + cityName + '\'' +
                    ", state='" + state + '\'' +
                    ", countryCode='" + countryCode + '\'' +
                    ", postalCode='" + postalCode + '\'' +
                    '}';
        }
    }
    // Inner class for PersonCommunication
    @EqualsAndHashCode
    public static class PersonCommunication {
        private int personCommId;
        private String emails;
        private String landline;
        private String mobile;

        public int getPersonCommId() {
            return personCommId;
        }

        public void setPersonCommId(int personCommId) {
            this.personCommId = personCommId;
        }

        public String getEmails() {
            return emails;
        }

        public void setEmails(String emails) {
            this.emails = emails;
        }

        public String getLandline() {return landline;}

        public void setLandline(String landline) {this.landline = landline;}

        public String getMobile() {return mobile;}

        public void setMobile(String mobile) {this.mobile = mobile;}

        @Override
        public String toString() {
            return "PersonCommunication{" +
                    "personCommId=" + personCommId +
                    ", emails='" + emails + '\'' +
                    ", landline=" + landline +
                    ", mobile=" + mobile +
                    '}';
        }
    }
}