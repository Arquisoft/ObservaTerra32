package models;

import play.db.ebean.Model;

public class AreaMap extends Model{

	private static final long serialVersionUID = 1L;

	public String idArea;

	public String idCountry;

	public AreaMap(String idArea, String idCountry) {
		super();
		this.idArea = idArea;
		this.idCountry = idCountry;
	}

	public String getIdArea() {
		return idArea;
	}

	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}

	public String getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
	}

}
