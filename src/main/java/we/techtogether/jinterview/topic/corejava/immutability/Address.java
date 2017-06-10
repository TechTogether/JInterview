package we.techtogether.jinterview.topic.corejava.immutability;

import java.io.Serializable;

public class Address implements Serializable{

	private int pinCode;
	
	private String city;
	/**
	 * @return the pinCode
	 */
	public int getPinCode() {
		return pinCode;
	}
	
	public Address(Address a) {
		this.pinCode=a.getPinCode();
		this.city=a.getCity();
	}
	
	
	public Address(int pinCode, String city) {
		super();
		this.pinCode = pinCode;
		this.city = city;
	}

	public Address() {
		super();
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [pinCode=" + pinCode + ", city=" + city + "]";
	}
	
}
