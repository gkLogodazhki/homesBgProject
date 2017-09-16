package ad;

import java.util.Set;

import estate.Estate;
import registration.contactData.ContactData;

public class adLoan extends Ad {
	
	private boolean hasShortLoan;
	private String period;
	private boolean isPetsAllowed;
	
	public adLoan(double price, String currency, Estate estate, ContactData contact,
			Set<Object> pictures, boolean hasShortLoan, String period, boolean isPetsAllowed) {
		super(price, currency, AdType.LOAN, estate, contact, pictures);
		this.hasShortLoan = hasShortLoan;
		this.period = period;
		this.isPetsAllowed = isPetsAllowed;
	}
	
}
