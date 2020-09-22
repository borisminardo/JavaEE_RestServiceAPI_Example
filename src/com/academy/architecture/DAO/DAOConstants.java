package com.academy.architecture.DAO;

public interface DAOConstants {
	String SELECT_PERSONA = "Select id, voce, username from persona";
	String UPDATE_PERSONA = "Update persona set voce = ? , username ? where id = ?";
	String DELETE_PERSONA = "Delete from persona where username = ?";
	String SELECT_BYPK = "Select * from persona where id = ?";

}
