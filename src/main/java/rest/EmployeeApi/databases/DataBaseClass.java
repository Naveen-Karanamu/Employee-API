package rest.EmployeeApi.databases;

import java.util.HashMap;
import java.util.Map;

import rest.EmployeeApi.models.Address;
import rest.EmployeeApi.models.Department;
import rest.EmployeeApi.models.Dependents;
import rest.EmployeeApi.models.Employee;
import rest.EmployeeApi.models.Family;

public class DataBaseClass {

    private static Map<Integer, Employee> employees = new HashMap<>();

    static {
        // Sample data for employees
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("John Doe");
        employee1.setDob("1990-01-01");

        // Initialize Address object
        Address address1 = new Address();
        employee1.setAddress(address1);

        Address.LocalAddress localAddress1 = new Address.LocalAddress();
        localAddress1.setStreet("123 Main St");
        localAddress1.setCity("Springfield");
        localAddress1.setZipCode("12345");
        employee1.getAddress().setLocalAddress(localAddress1);

        Address.OfficeAddress officeAddress1 = new Address.OfficeAddress();
        officeAddress1.setStreet("456 Office Ave");
        officeAddress1.setCity("Springfield");
        officeAddress1.setZipCode("54321");
        employee1.getAddress().setOfficeAddress(officeAddress1);

        // Initialize Department object
        Department department1 = new Department();
        employee1.setDepartment(department1);

        Department.DepartmentInfo departmentInfo1 = new Department.DepartmentInfo(1, "IT");
        employee1.getDepartment().setDepartment1(departmentInfo1);
        Department.DepartmentInfo departmentInfo2 = new Department.DepartmentInfo(2, "HR");
        employee1.getDepartment().setDepartment2(departmentInfo2);

        employee1.setSalary(60000.0);

        Family family1 = new Family();
        family1.setSpouse("Jane Doe");
        family1.setKids(new String[]{"Alice", "Bob"});

        Dependents dependents1 = new Dependents();
        dependents1.setParents(new String[]{"Parent 1", "Parent 2"});
        dependents1.setParentsInLaw(new String[]{"Parent in law 1", "Parent in law 2"});
        dependents1.setOthers(new String[]{"Other dependent 1", "Other dependent 2"});
        family1.setDependents(dependents1);

        employee1.setFamily(family1);

        employees.put(1, employee1);

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("Jane Smith");
        employee2.setDob("1995-05-15");

        // Initialize Address object
        Address address2 = new Address();
        employee2.setAddress(address2);

        Address.LocalAddress localAddress2 = new Address.LocalAddress();
        localAddress2.setStreet("789 Elm St");
        localAddress2.setCity("Springfield");
        localAddress2.setZipCode("54321");
        employee2.getAddress().setLocalAddress(localAddress2);

        Address.OfficeAddress officeAddress2 = new Address.OfficeAddress();
        officeAddress2.setStreet("987 Business Blvd");
        officeAddress2.setCity("Springfield");
        officeAddress2.setZipCode("12345");
        employee2.getAddress().setOfficeAddress(officeAddress2);

        // Initialize Department object
        Department department2 = new Department();
        employee2.setDepartment(department2);

        Department.DepartmentInfo departmentInfo3 = new Department.DepartmentInfo(3, "Finance");
        employee2.getDepartment().setDepartment1(departmentInfo3);
        Department.DepartmentInfo departmentInfo4 = new Department.DepartmentInfo(4, "Marketing");
        employee2.getDepartment().setDepartment2(departmentInfo4);

        employee2.setSalary(70000.0);

        Family family2 = new Family();
        family2.setSpouse("John Smith");
        family2.setKids(new String[]{"Mary", "David"});

        Dependents dependents2 = new Dependents();
        dependents2.setParents(new String[]{"Parent 3", "Parent 4"});
        dependents2.setParentsInLaw(new String[]{"Parent in law 3", "Parent in law 4"});
        dependents2.setOthers(new String[]{"Other dependent 3", "Other dependent 4"});
        family2.setDependents(dependents2);

        employee2.setFamily(family2);

        employees.put(2, employee2);
    }

    public static Map<Integer, Employee> getEmployees() {
        return employees;
    }
}
