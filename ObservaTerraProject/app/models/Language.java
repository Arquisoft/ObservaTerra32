package models;

import javax.persistence.Id;

import play.db.ebean.Model;

public class Language extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public String idLanguage;

	public String name;

	public Language(String idLanguage, String name) {
		this.idLanguage = idLanguage;
		this.name = name;
	}

	public String getIdLanguage() {
		return idLanguage;
	}

	public void setIdLanguage(String idLanguage) {
		this.idLanguage = idLanguage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
