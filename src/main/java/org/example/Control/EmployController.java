package org.example.Control;

import jakarta.ws.rs.core.MediaType;
import org.example.dao.EmploysDAO;

import jakarta.ws.rs.*;
import org.example.models.Employs;

import java.util.ArrayList;
@Path("/employees")

public class EmployController {

    EmploysDAO dao = new EmploysDAO();

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ArrayList<Employs> getAllEmployees(
            @QueryParam("employee_id")Integer employee_id ,
            @QueryParam("limit")Integer limit,
            @QueryParam("offset")int offset
    ) {

        try {
            return dao.selectAllEmploys(employee_id,limit,offset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("{employee_id}")
    public Employs getEmploy(@PathParam("employee_id") int employee_id) {

        try {
            return dao.selectEmployees(employee_id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DELETE
    @Path("{employee_id}")
    public void deleteEmployees(@PathParam("employee_id") int employee_id) {

        try {
            dao.deleteEmployees(employee_id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @POST

//    @Consumes(MediaType.APPLICATION_XML)
    public void insertEmploys(Employs employs) {

        try {
            dao.insertEmployees(employs);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("{employee_id}")
    public void updateEmploys(@PathParam("employee_id") int employee_id, Employs employs) {

        try {
            employs.setEmployee_id(employee_id);
            dao.updateEmplyees(employs);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}
