package br.com.agenda.model;

import java.util.Date;

public class Contact {
	private String name;
	private int yearsOld, idUser;
	private Date date;
	
	public void setId(int idUser) {
		this.idUser = idUser;
	}
	
	public int getId() {
		return this.idUser;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}
	
	public int getYearsOld() {
		return this.yearsOld;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return this.date;
	}
}