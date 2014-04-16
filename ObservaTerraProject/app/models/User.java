package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
public class User extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;
	private String surname;
	private String password;
	
	private List<Organization> userOrganizations;
	

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
		if (User.findById(user.name) == null) {
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

	public List<Organization> getUserOrganizations() {
		return userOrganizations;
	}

	public void setUserOrganizations(List<Organization> userOrganizations) {
		this.userOrganizations = userOrganizations;
	}
	
	public void addUserOrganization(Organization organization){
		userOrganizations.add(organization);
	}
	
	public void deleteUserOrganization(Organization organization){
		userOrganizations.remove(organization);
	}

}