package models;

import play.db.ebean.Model;

public class BelongTo extends Model {

	private static final long serialVersionUID = 1L;

	private String nameOrg;

	private String idUser;

	public BelongTo(String nameOrg, String idUser) {
		this.nameOrg = nameOrg;
		this.idUser = idUser;
	}

	public String getNameOrg() {
		return nameOrg;
	}

	public void setNameOrg(String nameOrg) {
		this.nameOrg = nameOrg;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

}
