/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong.rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.o7planning.restfulcrud.dao.EmployeeDAO;
import org.o7planning.restfulcrud.model.Employee;
import org.o7planning.restfulcrud.model.Equipo;

/**
 *
 * @author brown
 */
@Path("/equipo")
public class EquipoService {
    
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Equipo> getEquio_JSON() {
        List<Equipo> equipos = new ArrayList();
        equipos.add(new Equipo(1,"Oscar"));
        equipos.add(new Equipo(2,"Andres"));
        equipos.add(new Equipo(3,"Gibran"));
        return equipos;
    }
 
    // URI:
    // /contextPath/servletPath/employees/{empNo}
    @GET
    @Path("/{empNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Equipo getEmployee(@PathParam("id") int id) {
        List<Equipo> equipos = new ArrayList();
        equipos.add(new Equipo(1,"Oscar"));
        equipos.add(new Equipo(2,"Andres"));
        equipos.add(new Equipo(3,"Gibran"));
        for(Equipo e:equipos){
            if (e.getId()==id){
                return e;
            }
        }
        return null;
    }
 
    // URI:
    // /contextPath/servletPath/employees
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Employee addEmployee(Employee emp) {
        return EmployeeDAO.addEmployee(emp);
    }
 
    // URI:
    // /contextPath/servletPath/employees
    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Employee updateEmployee(Employee emp) {
        return EmployeeDAO.updateEmployee(emp);
    }
 
    @DELETE
    @Path("/{empNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteEmployee(@PathParam("empNo") String empNo) {
        EmployeeDAO.deleteEmployee(empNo);
    }
    
}
