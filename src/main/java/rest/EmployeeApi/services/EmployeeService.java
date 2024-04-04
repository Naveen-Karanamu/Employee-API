package rest.EmployeeApi.services;

import java.util.List;
import rest.EmployeeApi.models.Employee;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(int id, Employee employee);

    Employee deleteEmployee(int id);

    List<Employee> searchEmployees(
    		String name,
            Integer department1Id, 
            String department1Name,
            Integer department2Id, 
            String department2Name,
            String dob,
            String localStreet, 
            String localCity, 
            String localZipCode,
            String officeStreet, 
            String officeCity, 
            String officeZipCode,
            Double salary, 
            String spouse, 
            String kid,
            String parent, 
            String parentInLaw, 
            String otherDependent);
}
