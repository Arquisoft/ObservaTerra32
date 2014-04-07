package controllers;

import models.Country;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }
    
    public static Result noticias() {
        return ok(noticias.render());
    }
    
    public static Result documentos() {
        return ok(documentos.render());
    }
    
    public static Result videos() {
        return ok(videos.render());
    }
    
    public static Result enlaces() {
        return ok(enlaces.render());
    }
    

    public static Result showCountries() {
        return 
          ok(countries.render(Country.find.all()));
    }
 
    public static Result showCountry(String code) {
    	Country c = Country.find.byId(code);
    	return ok(country.render(c));
	}
 
    public static Result addCountry() {
    	Country c = countryForm.bindFromRequest().get();
    	c.save();
        return 
          redirect(routes.Application.showCountries());
    }
 
    public static Result updateCountry(String code) {
    	Country c = Country.find.byId(code);
    	Country updated = countryForm.bindFromRequest().get(); 
    	c.name = updated.name;
    	c.save();
        return 
          redirect(routes.Application.showCountries());
    }
 
    public static Result delCountry(String code) {
    	Country c = Country.find.byId(code);
    	c.delete();
        return 
          redirect(routes.Application.showCountries());
    }
    
    static Form<Country> countryForm = Form.form(Country.class); 
}
