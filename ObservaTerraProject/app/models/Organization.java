package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
public class Organization extends Model {

	@Id
	private String name;

	public Organization(String name) {
		this.name = name; 
	}

	public String getName(){
		return name;
	}
	
	public static Finder<String, Organization> find = new Finder(String.class,
			Organization.class);

	public static List<Organization> all() {
		return find.all();
	}

	public static void create(Organization organization) {
		if (Organization.findByName(organization.name) == null) {
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