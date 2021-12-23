package Model;

public class Address {
	
	private String street;
	private String streetnum;
	private String city;
	private String country;
	
	
	public Address(String street, String streetnum, String city, String country) {
		super();
		this.street = street;
		this.streetnum = streetnum;
		this.city = city;
		this.country = country;
	}
	
	


	@Override
	public String toString() {
		return "Address [street=" + street + ", streetnum=" + streetnum + ", city=" + city + ", country=" + country
				+ "]";
	}




	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getStreetnum() {
		return streetnum;
	}


	public void setStreetnum(String streetnum) {
		this.streetnum = streetnum;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

}
