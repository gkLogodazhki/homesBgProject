package homesbg.ad;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import com.google.gson.Gson;

import homesbg.estate.Estate;
import homesbg.registration.contactData.ContactData;

public abstract class Ad {

	public enum AdType{
		LOAN, SALE
	}
	
	public enum Currency{
		EURO, $, LEVA
	}
	
	private static int id;
	private int uid;
	private double price;
	private Currency currency;
	private AdType adType;
	private Estate estate;
	private ContactData contact;
	private Set<File> pictures;
	
	
	public Ad(AdType adType) {
		this.setCurrency(Currency.LEVA);
		this.adType = adType;
		this.pictures = new TreeSet<>();
		this.uid = ++id;
	}

	public Ad(double price, Currency currency, AdType adType, Estate estate, ContactData contact, Set<File> pictures) {
		this.setPrice(price);
		this.setCurrency(currency);
		this.adType = adType;
		this.setEstate(estate);
		this.setContact(contact);
		this.pictures = new TreeSet<>();
		this.setPictures(pictures);
		this.uid = ++id;
	}
	
	public int getID() {
		return this.uid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public AdType getAdType() {
		return adType;
	}

	public String getEstate() {
		return new Gson().toJson(this.estate);
	}

	public void setEstate(Estate estate) {
		this.estate = estate;
	}

	public String getContact() {
		return new Gson().toJson(this.contact);
	}

	public void setContact(ContactData contact) {
		this.contact = contact;
	}

	public Set<File> getPictures() {
		return pictures;
	}

	public void setPictures(Set<File> pictures) {
		this.pictures = pictures;
	}
	
	
	@Override
	public int hashCode() {
		return 31 * uid;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ad other = (Ad) obj;
		if (uid != other.uid)
			return false;
		return true;
	}
	
}
