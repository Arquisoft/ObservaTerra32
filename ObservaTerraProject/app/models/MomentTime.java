package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
public class MomentTime extends Model {

	private Time value;

	public MomentTime(Time value) {
		this.value = value; 
	}

	public Time getValue(){
		return value;
	}
}