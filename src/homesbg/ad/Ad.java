package ad;

import java.util.Set;

import estate.Estate;
import registration.contactData.ContactData;

public class Ad {

	public enum AdType{
		LOAN, SALE
	}
	
	private double price;
	private String currency;
	private AdType adType;
	private Estate estate;
	private ContactData contact;
	private Set<Object> pictures;
	
	public Ad(double price, String currency, AdType adType, Estate estate, ContactData contact, Set<Object> pictures) {
		this.price = price;
		this.currency = currency;
		this.adType = adType;
		this.estate = estate;
		this.contact = contact;
		this.pictures = pictures;
	}
	
}
