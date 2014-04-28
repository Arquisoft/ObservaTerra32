package models;

import javax.persistence.Entity;

import play.db.ebean.Model;

@Entity
public class Measure extends Model {

	private static final long serialVersionUID = 1L;
	private String name;

	public Measure(String name) {
		this.name = name; 
	}

	public String getName(){
		return name;
	}
}