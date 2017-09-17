package homesbg.ad;

import java.io.File;
import java.util.Set;

import homesbg.estate.Estate;
import homesbg.registration.contactData.ContactData;

public class AdSale extends Ad {
	
	private boolean isPriceByNegotiable;
	
	public AdSale() {
		super(AdType.SALE);
	}

	public AdSale(double price, Currency currency, Estate estate, ContactData contact,
			Set<File> pictures, boolean isPriceByNegotiable) {
		super(price, currency, AdType.SALE, estate, contact, pictures);
		this.isPriceByNegotiable = isPriceByNegotiable;
	}

	public boolean isPriceByNegotiable() {
		return isPriceByNegotiable;
	}

	public void setPriceByNegotiable(boolean isPriceByNegotiable) {
		this.isPriceByNegotiable = isPriceByNegotiable;
	}
	
	
	
}
