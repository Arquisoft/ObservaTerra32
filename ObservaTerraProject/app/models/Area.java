package models;

import java.util.List;

import play.db.ebean.Model;

public class Area extends Model {

	private static final long serialVersionUID = 1L;

	private String name; 
	
	private List<Country> countries;
	
	public Area(String name, List<Country> countries){
		this.name = name;
		this.countries = countries;
	}

	public String getName() {
		return name;
	}

	public List<Country> getCountries() {
		return countries;
	}
	
	
}
