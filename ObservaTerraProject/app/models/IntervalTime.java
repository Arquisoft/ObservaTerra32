package models;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
public class IntervalTime extends Model {

	private Time begin;
	private Time finish;


	public IntervalTime(Time begin, Time finish) {
		this.begin = begin;
		this.finish = finish;
	}

	public Time getBegin(){
		return begin;
	}
	
	public Time getFinish(){
		return finish;
	}
}