package ad;

import java.util.Set;

import estate.Estate;
import registration.contactData.ContactData;

public class adSale extends Ad {

	public adSale(double price, String currency, Estate estate, ContactData contact,
			Set<Object> pictures, boolean isPriceByNegotiable) {
		super(price, currency, AdType.SALE, estate, contact, pictures);
		this.isPriceByNegotiable = isPriceByNegotiable;
	}

	private boolean isPriceByNegotiable;
	
}