package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
public class Measure extends Model {

	private String name;

	public Measure(String name) {
		this.name = name; 
	}

	public String getName(){
		return name;
	}
}