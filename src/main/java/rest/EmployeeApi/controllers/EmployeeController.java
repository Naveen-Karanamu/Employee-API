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
import rest.EmployeeApi.Exceptions.ErrorResponse;
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
    public Response getEmployeeById(@PathParam("id") int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return Response.ok().entity(employee).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity(new ErrorResponse(Response.Status.NOT_FOUND.getStatusCode(), 
                                                     "Employee not found with id: " + id))
                           .build();
        }
    }

    @POST
    @Path("/add")
    public Response addEmployee(Employee employee) {
        try {
            Employee addedEmployee = employeeService.addEmployee(employee);
            return Response.status(Response.Status.CREATED).entity(addedEmployee).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity(new ErrorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), 
                                                     "Error adding employee: " + e.getMessage()))
                           .build();
        }
    }

    @PUT
    @Path("/update/{id}")
    public Response updateEmployee(@PathParam("id") int id, Employee employee) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(id, employee);
            if (updatedEmployee != null) {
                return Response.ok().entity(updatedEmployee).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                               .entity(new ErrorResponse(Response.Status.NOT_FOUND.getStatusCode(), 
                                                         "Employee not found with id: " + id))
                               .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity(new ErrorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), 
                                                     "Error updating employee: " + e.getMessage()))
                           .build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteEmployee(@PathParam("id") int id) {
        try {
            Employee deletedEmployee = employeeService.deleteEmployee(id);
            if (deletedEmployee != null) {
                return Response.ok().entity(deletedEmployee).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                               .entity(new ErrorResponse(Response.Status.NOT_FOUND.getStatusCode(), 
                                                         "Employee not found with id: " + id))
                               .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity(new ErrorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), 
                                                     "Error deleting employee: " + e.getMessage()))
                           .build();
        }
    }
}
