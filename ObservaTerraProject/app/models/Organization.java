package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;

@Entity
public class Organization extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	private String nameOrg;

	private String area;

	private String password;

	public Organization(String name) {
		this.nameOrg = name;
	}

	public String getName() {
		return nameOrg;
	}

	public void setName(String name) {
		this.nameOrg = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getNameOrg() {
		return nameOrg;
	}

	public void setNameOrg(String nameOrg) {
		this.nameOrg = nameOrg;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Finder<String, Organization> find = new Finder(String.class,
			Organization.class);

	public static List<Organization> all() {
		return find.all();
	}

	public static void create(Organization organization) {
		if (Organization.findByName(organization.nameOrg) == null) {
			organization.save();
		}
	}

	public static void remove(String name) {
		find.ref(name).delete();
	}

	public static void deleteAll() {
		for (Organization o : all())
			o.delete();
	}

	public static Organization findByName(String name) {
		return find.where().eq("name", name).findUnique();
	}

}