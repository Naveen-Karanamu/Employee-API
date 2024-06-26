package rest.EmployeeApi.models;

public class Address {
    private LocalAddress localAddress;
    private OfficeAddress officeAddress;

    public LocalAddress getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(LocalAddress localAddress) {
        this.localAddress = localAddress;
    }

    public OfficeAddress getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(OfficeAddress officeAddress) {
        this.officeAddress = officeAddress;
    }

    public static class LocalAddress {
        private String street;
        private String city;
        private String zipCode;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }

    public static class OfficeAddress {
        private String street;
        private String city;
        private String zipCode;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }
}