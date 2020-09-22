package com.academy.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.academy.architecture.DAO.PersonaDAO;
import com.academy.model.Persona;

@Path("/service")
public class PersonaService {
	
	@GET
	@Path("/persone")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Persona> getPersone() throws SQLException, NamingException {
		PersonaDAO pDAO = new PersonaDAO();
		return pDAO.getPersone();
	}
	
	@GET
	@Path("/utente/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Persona getUtente(@PathParam("id") Long id)
			throws ClassNotFoundException, SQLException, NamingException{
		PersonaDAO pDAO = new PersonaDAO();
		return pDAO.findByPK(id);
	}
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public void createPersona(Persona persona) throws NamingException, SQLException {
		PersonaDAO pDAO = new PersonaDAO();
		pDAO.create(persona);
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public void updatePersona(Persona persona) throws NamingException, SQLException {
		PersonaDAO pDAO = new PersonaDAO();
		pDAO.update(persona);
	}
	
	@DELETE
	@Path("/delete/{username}")
	@Transactional
	public void deletePersona(@PathParam("username") String username) throws NamingException, SQLException {
		PersonaDAO pDAO = new PersonaDAO();
		pDAO.delete(username);
	}	
}
