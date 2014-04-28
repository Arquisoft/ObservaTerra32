<<<<<<< HEAD
package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;


@Entity
public class Observation extends Model {
    
  @Id
  public Long id;
  
  @Required
  public Double obsValue;
  
  @ManyToOne
  public Country country;

  @ManyToOne
  public Indicator indicator;
  
  public static Finder<Long,Observation> find = new Finder(Long.class, Observation.class);

  public Observation(Country country, Indicator indicator, Double value) {
	  this.country = country;
	  this.indicator=indicator;
	  this.obsValue = value ;
  }
  
  public Observation(String countryCode, String indicatorCode, Double value) {
	  this.country  = Country.find.ref(countryCode);
	  this.indicator= Indicator.find.ref(indicatorCode);
	  this.obsValue = value ;
  }

  public static List<Observation> all() {
    return find.all();
  }

  public static Observation create(String code, String indicator, Double value) {
	  Observation observation = new Observation(code,indicator,value);
	  observation.save();
	  return observation;
  }
  
  public static void delete(Long id) {
	find.ref(id).delete();
  }
  
  public static void deleteAll() {
	for (Observation obs: all()) {
		obs.delete();
	}
  }
  
  public static Double average(List<Observation> observations) {
	  Double sum = 0.0;
		for (Observation obs : observations) {
			sum += obs.obsValue;
		}
		return sum / observations.size() ;
  }

  public static List<Observation> filterByIndicatorName(String indicatorName, List<Observation> observations) {
	List<Observation> result = new ArrayList<Observation>();
	for (Observation obs : observations) {
		if (obs.indicator.name == indicatorName) result.add(obs);
	}
	return result;
  }


  public static List<Observation> findByIndicatorName(String indicatorCode) {
	Indicator ind = Indicator.findByCode(indicatorCode);
	List<Observation> result = find.where().eq("indicator", ind).findList();
	return result;
  }

  public static List<Observation> findByCountryCode(String countryCode) {
	Country c = Country.find.byId(countryCode);
	List<Observation> result = find.where().eq("country", c).findList();
	return result;
  }

=======
package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Observation extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long idOservation;

	@Required
	public Double obsValue;

	@ManyToOne
	public Country country;

	@ManyToOne
	public Indicator indicator;

	public String area;

	public String measure;

	public String provider;

	public String time;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Finder<Long, Observation> find = new Finder(Long.class,
			Observation.class);

	public Observation(Country country, Indicator indicator, Double value) {
		this.country = country;
		this.indicator = indicator;
		this.obsValue = value;
	}

	public Observation(String countryCode, String indicatorCode, Double value) {
		this.country = Country.find.ref(countryCode);
		this.indicator = Indicator.find.ref(indicatorCode);
		this.obsValue = value;
	}

	public static List<Observation> all() {
		return find.all();
	}

	public static Observation create(String code, String indicator, Double value) {
		Observation observation = new Observation(code, indicator, value);
		observation.save();
		return observation;
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

	public static void deleteAll() {
		for (Observation obs : all()) {
			obs.delete();
		}
	}

	public static Double average(List<Observation> observations) {
		Double sum = 0.0;
		for (Observation obs : observations) {
			sum += obs.obsValue;
		}
		return sum / observations.size();
	}

	public static List<Observation> filterByIndicatorName(String indicatorName,
			List<Observation> observations) {
		List<Observation> result = new ArrayList<Observation>();
		for (Observation obs : observations) {
			if (obs.indicator.name == indicatorName)
				result.add(obs);
		}
		return result;
	}

	public static List<Observation> findByIndicatorName(String indicatorCode) {
		Indicator ind = Indicator.findByCode(indicatorCode);
		List<Observation> result = find.where().eq("indicator", ind).findList();
		return result;
	}

	public static List<Observation> findByCountryCode(String countryCode) {
		Country c = Country.find.byId(countryCode);
		List<Observation> result = find.where().eq("country", c).findList();
		return result;
	}

	public Long getIdOservation() {
		return idOservation;
	}

	public void setIdOservation(Long idOservation) {
		this.idOservation = idOservation;
	}

	public Double getObsValue() {
		return obsValue;
	}

	public void setObsValue(Double obsValue) {
		this.obsValue = obsValue;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Indicator getIndicator() {
		return indicator;
	}

	public void setIndicator(Indicator indicator) {
		this.indicator = indicator;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

>>>>>>> 739636156d161162212bffc6b5a006e55a441257
}