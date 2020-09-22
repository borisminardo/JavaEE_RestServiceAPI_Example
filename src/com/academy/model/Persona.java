package com.academy.model;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ViewScoped
@Named
@XmlRootElement(name="utente")
public class Persona implements Serializable {

	private static final long serialVersionUID = 6540605854291946614L;
	private long id;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	private String voce;
	private String username;

	public String getUsername() {
		return username;
	}
	@XmlElement
	public void setUsername(String username) {
		this.username = username;
	}
	public String getVoce() {
		return voce;
	}
	@XmlElement
	public void setVoce(String voce) {
		this.voce = voce;
	}
}
