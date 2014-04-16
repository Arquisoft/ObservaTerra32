package models;

import java.util.ArrayList;
import java.util.List;


public class CompositeOrganization extends Organization {

	private static final long serialVersionUID = 1L;
	
	private List<Organization> organizations; 
	
	public CompositeOrganization(String name) {
		super(name);
		setOrganizations(new ArrayList<Organization>());
	}

	public List<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}
	
	public void AddOrganization(Organization organization){
		organizations.add(organization);
	}
	
	public void removeOrganization(Organization organization){
			organizations.remove(organization);
	}

}
