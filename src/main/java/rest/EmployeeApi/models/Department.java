package rest.EmployeeApi.models;

import java.util.Objects;

public class Department {
    private String department1;
    private String department2;

    // Getters and Setters
    public String getDepartment1() {
        return department1;
    }

    public void setDepartment1(String department1) {
        this.department1 = department1;
    }

    public String getDepartment2() {
        return department2;
    }

    public void setDepartment2(String department2) {
        this.department2 = department2;
    }

    // equals() and hashCode() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(department1, that.department1) &&
                Objects.equals(department2, that.department2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department1, department2);
    }

    // toString() method
    @Override
    public String toString() {
        return "Department{" +
                "department1='" + department1 + '\'' +
                ", department2='" + department2 + '\'' +
                '}';
    }
}
