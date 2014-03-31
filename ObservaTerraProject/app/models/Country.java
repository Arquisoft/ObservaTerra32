package models;
 
import javax.persistence.Entity;
import javax.persistence.Id;
 
import com.avaje.ebean.Ebean;
 
import play.db.ebean.Model;
 
@Entity
public class Country extends Model {
	
	@Id
	public String code;
	
	public String name;
	
	public Country(String code, String name) {
		this.code = code;
		this.name = name;
	}
 
	public static Finder<String,Country> find = new Finder(String.class,Country.class);
	
}