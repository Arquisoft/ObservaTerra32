package models;

import java.util.List;

import javax.persistence.Id;

import play.db.ebean.Model;

public class Area extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public String idArea;

	private String name;

	private String totalArea;

	private List<Country> countries;

	public Area(String idArea, String name, String totalArea,
			List<Country> countries) {
		this.idArea = idArea;
		this.name = name;
		this.totalArea = totalArea;
		this.countries = countries;
	}

	public String getIdArea() {
		return idArea;
	}

	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(String totalArea) {
		this.totalArea = totalArea;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

}
