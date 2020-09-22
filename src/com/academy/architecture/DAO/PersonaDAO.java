package com.academy.architecture.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;
import com.academy.model.Persona;

public class PersonaDAO implements DAOConstants {
	private static final String SELECT_BYPK = null;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	public PersonaDAO() throws NamingException, SQLException {
		conn = DBAccess.getConnection();
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(SELECT_PERSONA);
	}

	public String create(Persona persona) throws SQLException {
		if (persona != null) {
			rs.moveToInsertRow();
			rs.updateString(2, persona.getVoce());
			rs.updateString(3, persona.getUsername());
			rs.insertRow();
		}
		return "report?faces-redirect=true";
	}

	public ArrayList<Persona> getPersone() throws SQLException {
		ArrayList<Persona> persone = new ArrayList<Persona>();
		rs.beforeFirst();
		while (rs.next()) {
			Persona persona = new Persona();
			persona.setId(rs.getLong(1));
			persona.setVoce(rs.getString(2));
			persona.setUsername(rs.getString(3));
		}
		return persone;
	}

	public void update(Persona persona) throws SQLException {
		if (persona != null) {
			PreparedStatement stmt = conn.prepareStatement(UPDATE_PERSONA);
			stmt.setString(1, persona.getVoce());
			stmt.setString(2, persona.getUsername());
			stmt.setLong(3, persona.getId());
			stmt.execute();
		}
	}

	public void delete(String username) throws SQLException {
		if (username != null) {
			PreparedStatement stmt = conn.prepareStatement(DELETE_PERSONA);
			stmt.setString(1, username);
			stmt.execute();
		}
	}

	public Persona findByPK(Long id) throws SQLException {
		if (id != null) {
			PreparedStatement stmt = conn.prepareStatement(SELECT_BYPK);
			stmt.setLong(1, id);
			Persona persona = new Persona();
			ResultSet rs = stmt.executeQuery();
			rs.next();
			persona.setId(rs.getLong(2));
			persona.setVoce(rs.getString(3));
			persona.setUsername(rs.getString(4));
			return persona;
		}
		return null;
	}

}
