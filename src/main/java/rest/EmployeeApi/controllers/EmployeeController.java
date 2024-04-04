package rest.EmployeeApi.controllers;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import rest.EmployeeApi.models.Employee;
import rest.EmployeeApi.service.impl.EmployeeServiceImpl;

@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeController {
    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @GET
    public String test() {
    	return "hello";
    }
    
    @GET
    @Path("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    
    @GET
    @Path("/{id}")
    public Employee getEmployeeById(@PathParam("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @POST
    @Path("/add")
    public Response addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/update/{id}")
    public Response updateEmployee(@PathParam("id") int id, Employee employee) {
        employeeService.updateEmployee(id, employee);
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteEmployee(@PathParam("id") int id) {
        employeeService.deleteEmployee(id);
        return Response.noContent().build();
    }
}
