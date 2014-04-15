package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
public class Provider extends Model {

	@Id
	private String name;

	public Provider(String name) {
		this.name = name; 
	}

	public String getName(){
		return name;
	}
	
	public static Finder<String, Country> find = new Finder(String.class,
			Provider.class);

	public static List<Provider> all() {
		return find.all();
	}

	public static void create(Provider provider) {
		if (Provider.findByName(provider.name) == null) {
			provider.save();
		}
	}

	public static void remove(String name) {
		find.ref(name).delete();
	}

	public static void deleteAll() {
		for (Provider p : all())
			p.delete();
	}

	public static Provider findByName(String name) {
		return find.where().eq("name", name).findUnique();
	}
	
}