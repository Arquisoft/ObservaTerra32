package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
public class User extends Model {

	@Id
	private String id;

	private String name;
	private String surname;
	private String password;
	

	public User(String id, String name, String surname, String password) {
		this.id = id; 
		this.name = name; 
		this.surname = surname;
		this.password = password; 
	}
	
	public String getName(){
		return name;
	}
	
	public String getId(){
		return id;
	}
	
	public String getSurname(){
		return surname;
	}
	
	public String getPassword(){
		return password;
	}

	public static Finder<String, User> find = new Finder(String.class,
			User.class);

	public static List<User> all() {
		return find.all();
	}

	public static void create(User user) {
		if (User.findByName(user.name) == null) {
			user.save();
		}
	}

	public static void remove(String id) {
		find.ref(id).delete();
	}

	public static void deleteAll() {
		for (User u : all())
			u.delete();
	}

	public static User findById(String id) {
		return find.byId(id);
	}

}