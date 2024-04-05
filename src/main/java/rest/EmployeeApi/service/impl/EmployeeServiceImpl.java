package rest.EmployeeApi.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import rest.EmployeeApi.databases.DataBaseClass;
import rest.EmployeeApi.models.Address;
import rest.EmployeeApi.models.Department;
import rest.EmployeeApi.models.Employee;
import rest.EmployeeApi.services.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    private Map<Integer, Employee> employees = DataBaseClass.getEmployees();
    
    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employees.get(id);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setId(employees.size() + 1); 
        employees.put(employee.getId(), employee);
        return employee; 
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        if (employees.containsKey(id)) {
            employees.put(id, employee);
            return employee; 
        }
        return null;
    }

    @Override
    public Employee deleteEmployee(int id) {
        if (employees.containsKey(id)) {
            Employee deletedEmployee = employees.remove(id);
            return deletedEmployee;
        }
        return null;
    }
    
    @Override
    public List<Employee> searchEmployees(
            String name,
            Integer department1Id, String department1Name,
            Integer department2Id, String department2Name,
            String dob,
            String localStreet, String localCity, String localZipCode,
            String officeStreet, String officeCity, String officeZipCode,
            Double salary, String spouse, String kid,
            String parent, String parentInLaw, String otherDependent) {
        List<Employee> matchedEmployees = new ArrayList<>();

        for (Employee employee : employees.values()) {
            Address address = employee.getAddress();
            Department department = employee.getDepartment();
            // Convert arrays to lists
            List<String> kids = Arrays.asList(employee.getFamily().getKids());
            List<String> parents = Arrays.asList(employee.getFamily().getDependents().getParents());
            List<String> parentsInLaw = Arrays.asList(employee.getFamily().getDependents().getParentsInLaw());
            List<String> others = Arrays.asList(employee.getFamily().getDependents().getOthers());

            // Check if the Employee matches the search criteria
            if ((name == null || employee.getName().equals(name)) &&
            		(department1Id == null || department.getDepartment1().getId() == department1Id) &&
            	    (department1Name == null || department.getDepartment1().getName().equals(department1Name)) &&
            	    (department2Id == null || department.getDepartment2().getId() == department2Id) &&
            	    (department2Name == null || department.getDepartment2().getName().equals(department2Name)) &&
                (dob == null || employee.getDob().equals(dob)) &&
                (localStreet == null || address.getLocalAddress().getStreet().equals(localStreet)) &&
                (localCity == null || address.getLocalAddress().getCity().equals(localCity)) &&
                (localZipCode == null || address.getLocalAddress().getZipCode().equals(localZipCode)) &&
                (officeStreet == null || address.getOfficeAddress().getStreet().equals(officeStreet)) &&
                (officeCity == null || address.getOfficeAddress().getCity().equals(officeCity)) &&
                (officeZipCode == null || address.getOfficeAddress().getZipCode().equals(officeZipCode)) &&
                (salary == null || Double.compare(employee.getSalary(), salary) == 0) &&
                (spouse == null || employee.getFamily().getSpouse().equals(spouse)) &&
                (kid == null || kids.contains(kid)) &&
                (parent == null || parents.contains(parent)) &&
                (parentInLaw == null || parentsInLaw.contains(parentInLaw)) &&
                (otherDependent == null || others.contains(otherDependent))) {
                matchedEmployees.add(employee);
            }
        }

        return matchedEmployees;
    }



}
