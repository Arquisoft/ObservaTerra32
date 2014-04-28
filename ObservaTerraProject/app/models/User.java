package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class User extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	private String idUser;

	private String name;

	private String surname;

	private String mail;

	private String username;

	private String password;

	private List<Organization> userOrganizations;

	public User(String idUser, String name, String surname, String mail,
			String username, String password,
			List<Organization> userOrganizations) {
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.userOrganizations = userOrganizations;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
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

	public static void remove(String idUser) {
		find.ref(idUser).delete();
	}

	public static void deleteAll() {
		for (User u : all())
			u.delete();
	}

	public static User findById(String idUser) {
		return find.byId(idUser);
	}

	public List<Organization> getUserOrganizations() {
		return userOrganizations;
	}

	public void setUserOrganizations(List<Organization> userOrganizations) {
		this.userOrganizations = userOrganizations;
	}

	public void addUserOrganization(Organization organization) {
		userOrganizations.add(organization);
	}

	public void deleteUserOrganization(Organization organization) {
		userOrganizations.remove(organization);
	}

}