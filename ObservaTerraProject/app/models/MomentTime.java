package models;

import java.sql.Time;

import javax.persistence.Entity;

import play.db.ebean.Model;

@Entity
public class MomentTime extends Model {

	private static final long serialVersionUID = 1L;
	private Time value;

	public MomentTime(Time value) {
		this.value = value; 
	}

	public Time getValue(){
		return value;
	}
}