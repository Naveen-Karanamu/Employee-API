package rest.EmployeeApi.models;

import java.util.Objects;

public class Address {
    private String localAddress;
    private String officeAddress;

    // Getters and Setters
    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    // equals() and hashCode() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(localAddress, address.localAddress) &&
                Objects.equals(officeAddress, address.officeAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localAddress, officeAddress);
    }

    // toString() method
    @Override
    public String toString() {
        return "Address{" +
                "localAddress='" + localAddress + '\'' +
                ", officeAddress='" + officeAddress + '\'' +
                '}';
    }
}
