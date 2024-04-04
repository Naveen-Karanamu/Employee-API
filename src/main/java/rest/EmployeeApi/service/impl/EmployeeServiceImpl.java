// EmployeeServiceImpl.java
package rest.EmployeeApi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rest.EmployeeApi.databases.DataBaseClass;
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
        return employee; // Return the added employee
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        if (employees.containsKey(id)) {
            employees.put(id, employee);
            return employee; // Return the updated employee
        }
        return null; // Or handle the case when employee is not found
    }

    @Override
    public Employee deleteEmployee(int id) {
        if (employees.containsKey(id)) {
            Employee deletedEmployee = employees.remove(id);
            return deletedEmployee;
        }
        return null;
    }
}
