package models;

<<<<<<< HEAD
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Entity
public class Country extends Model {
    
  @Id
  public String code;
  public String name;
  
  public Country(String code, String name) {
	  this.code = code;
	  this.name = name;
  }
   
  public static Finder<String,Country> find = new Finder(String.class, Country.class);
  
  public static List<Country> all() {
    return find.all();
  }

  public static void create(Country country) {
	if (Country.findByName(country.name) == null) { 
			country.save();
	}
  }

  public static void remove(String code) {
	find.ref(code).delete();
  }
  
  public static void deleteAll() {
    for (Country c: all()) c.delete();
  }
  
  public static Country findByName(String name) {
	  return find.where().eq("name", name).findUnique();
  }

  public static Country findByCode(String code) {
	  return find.byId(code);
  }
  
  public static JsonNode toJson(Country country) {
	return Json.toJson(country);
  }
}

=======
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.*;

import play.db.ebean.Model;
import play.libs.Json;

@Entity
public class Country extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public String idCountry;

	public String name;

	public Long population;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Finder<String, Country> find = new Finder(String.class,
			Country.class);

	public static List<Country> all() {
		return find.all();
	}

	public static void create(Country country) {
		if (Country.findByName(country.name) == null) {
			country.save();
		}
	}

	public static void remove(String idCountry) {
		find.ref(idCountry).delete();
	}

	public static void deleteAll() {
		for (Country c : all())
			c.delete();
	}

	public static Country findByName(String name) {
		return find.where().eq("name", name).findUnique();
	}

	public static Country findByCode(String idCountry) {
		return find.byId(idCountry);
	}
	
	public static JsonNode toJson(Country country) {
		return Json.toJson(country);
	}
}
>>>>>>> 739636156d161162212bffc6b5a006e55a441257
