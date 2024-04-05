package rest.EmployeeApi.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
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
    
    @GET
    @Path("/search")
    public Response searchEmployees(
            @QueryParam("name") String name,
            @QueryParam("department.department1.id") Integer department1Id,
            @QueryParam("department.department1.name") String department1Name,
            @QueryParam("department.department2.id") Integer department2Id,
            @QueryParam("department.department2.name") String department2Name,
            @QueryParam("dob") String dob,
            @QueryParam("localAddress.street") String localStreet,
            @QueryParam("localAddress.city") String localCity,
            @QueryParam("localAddress.zipCode") String localZipCode,
            @QueryParam("officeAddress.street") String officeStreet,
            @QueryParam("officeAddress.city") String officeCity,
            @QueryParam("officeAddress.zipCode") String officeZipCode,
            @QueryParam("salary") Double salary,
            @QueryParam("spouse") String spouse,
            @QueryParam("kid") String kid,
            @QueryParam("parent") String parent,
            @QueryParam("parentInLaw") String parentInLaw,
            @QueryParam("otherDependent") String otherDependent) {

        try {
            List<Employee> matchedEmployees = employeeService.searchEmployees(
                    name, department1Id, department1Name, department2Id, department2Name,
                    dob, localStreet, localCity, localZipCode,
                    officeStreet, officeCity, officeZipCode,
                    salary, spouse, kid, parent, parentInLaw, otherDependent);

            if (matchedEmployees.isEmpty()) {
                Map<String, Object> mismatchedCriteria = new LinkedHashMap<>();
                if (name != null) {
                    mismatchedCriteria.put("Name", name);
                }
                if (department1Id != null) {
                    mismatchedCriteria.put("Department 1 ID", department1Id);
                }
                if (department1Name != null) {
                    mismatchedCriteria.put("Department 1 Name", department1Name);
                }
                if (department2Id != null) {
                    mismatchedCriteria.put("Department 2 ID", department2Id);
                }
                if (department2Name != null) {
                    mismatchedCriteria.put("Department 2 Name", department2Name);
                }
                if (dob != null) {
                    mismatchedCriteria.put("DOB", dob);
                }
                if (localStreet != null) {
                    mismatchedCriteria.put("Local Address Street", localStreet);
                }
                if (localCity != null) {
                    mismatchedCriteria.put("Local Address City", localCity);
                }
                if (localZipCode != null) {
                    mismatchedCriteria.put("Local Address Zip Code", localZipCode);
                }
                if (officeStreet != null) {
                    mismatchedCriteria.put("Office Address Street", officeStreet);
                }
                if (officeCity != null) {
                    mismatchedCriteria.put("Office Address City", officeCity);
                }
                if (officeZipCode != null) {
                    mismatchedCriteria.put("Office Address Zip Code", officeZipCode);
                }
                if (salary != null) {
                    mismatchedCriteria.put("Salary", salary);
                }
                if (spouse != null) {
                    mismatchedCriteria.put("Spouse", spouse);
                }
                if (kid != null) {
                    mismatchedCriteria.put("Kid", kid);
                }
                if (parent != null) {
                    mismatchedCriteria.put("Parent", parent);
                }
                if (parentInLaw != null) {
                    mismatchedCriteria.put("Parent In Law", parentInLaw);
                }
                if (otherDependent != null) {
                    mismatchedCriteria.put("Other Dependent", otherDependent);
                }

                // Remove the matched criteria from the mismatched criteria map
                matchedEmployees.forEach(employee -> {
                    if (mismatchedCriteria.containsKey("Name") && mismatchedCriteria.get("Name").equals(employee.getName())) {
                        mismatchedCriteria.remove("Name");
                    }
                });

                if (!mismatchedCriteria.isEmpty()) {
                    JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
                            .add("error", "No employees found matching the criteria");

                    JsonObjectBuilder criteriaBuilder = Json.createObjectBuilder();
                    mismatchedCriteria.forEach((key, value) -> criteriaBuilder.add(key, value.toString()));

                    jsonObjectBuilder.add("criteria", criteriaBuilder);
                    
                    JsonObject errorMessage = jsonObjectBuilder.build();

                    return Response.status(Response.Status.BAD_REQUEST)
                                   .entity(errorMessage.toString())
                                   .type(MediaType.APPLICATION_JSON)
                                   .build();

            }
            }
            return Response.ok(matchedEmployees).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while processing the request.").build();
        }
    }

}
