package rest.EmployeeApi.databases;

import java.util.HashMap;
import java.util.Map;

import rest.EmployeeApi.models.Address;
import rest.EmployeeApi.models.Department;
import rest.EmployeeApi.models.Employee;
import rest.EmployeeApi.models.Family;


public class DataBaseClass {

	private static Map<Integer, Employee> employees= new HashMap<>();
	
	static {
        // Adding some sample data
        Employee employee1 = new Employee("John Doe", 1, "1990-01-01", new Address(), new Department(), 50000.0, new Family());
        Employee employee2 = new Employee("Jane Smith", 2, "1995-05-15", new Address(), new Department(), 60000.0, new Family());
        employees.put(1, employee1);
        employees.put(2, employee2);
    }
	public static Map<Integer, Employee> getMessages(){
		return employees;
	}
}
