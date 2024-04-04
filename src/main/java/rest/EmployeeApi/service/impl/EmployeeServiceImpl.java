package rest.EmployeeApi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rest.EmployeeApi.models.Employee;
import rest.EmployeeApi.services.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    private Map<Integer, Employee> employees = new HashMap<>();

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employees.get(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        if (employees.containsKey(id)) {
            employee.setId(id);
            employees.put(id, employee);
        }
    }

    @Override
    public void deleteEmployee(int id) {
        employees.remove(id);
    }
}

