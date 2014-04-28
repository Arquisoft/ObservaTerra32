package models;

import play.db.ebean.Model;

public class Speech extends Model {

	private static final long serialVersionUID = 1L;

	public String idCountry;

	public String idLanguage;

	public Speech(String idCountry, String idLanguage) {
		this.idCountry = idCountry;
		this.idLanguage = idLanguage;
	}

	public String getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
	}

	public String getIdLanguage() {
		return idLanguage;
	}

	public void setIdLanguage(String idLanguage) {
		this.idLanguage = idLanguage;
	}

}
