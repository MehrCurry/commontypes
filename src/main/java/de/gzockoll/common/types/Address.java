package de.gzockoll.common.types;

public class Address {
	private String city;
	private String zip;
	private String street;
	private String numner;
	public Address(String zip, String city, String street, String numner) {
		super();
		this.zip = zip;
		this.city = city;
		this.street = street;
		this.numner = numner;
	}
	public String getCity() {
		return city;
	}
	public String getZip() {
		return zip;
	}
	public String getStreet() {
		return street;
	}
	public String getNumner() {
		return numner;
	}
	
	
}
