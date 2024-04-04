package rest.EmployeeApi.models;

//import java.util.Arrays;
import java.util.Objects;

public class Employee {
    private String name;
    private int id;
    private String dob;
    private Address address;
    private Department department;
    private double salary;
    private Family family;

    public Employee() {
    }

    public Employee(String name, int id, String dob, Address address, Department department, double salary, Family family) {
        this.name = name;
        this.id = id;
        this.dob = dob;
        this.address = address;
        this.department = department;
        this.salary = salary;
        this.family = family;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    // equals() and hashCode() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(dob, employee.dob) &&
                Objects.equals(address, employee.address) &&
                Objects.equals(department, employee.department) &&
                Objects.equals(family, employee.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, dob, address, department, salary, family);
    }

    // toString() method
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", dob='" + dob + '\'' +
                ", address=" + address +
                ", department=" + department +
                ", salary=" + salary +
                ", family=" + family +
                '}';
    }
}