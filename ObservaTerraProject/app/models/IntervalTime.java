package models;

import java.sql.Time;

import javax.persistence.Entity;

import play.db.ebean.Model;

@Entity
public class IntervalTime extends Model {

	private static final long serialVersionUID = 1L;
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