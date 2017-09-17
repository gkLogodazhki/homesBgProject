package homesbg.ad;

import java.io.File;
import java.util.Set;

import homesbg.estate.Estate;
import homesbg.registration.contactData.ContactData;

public class AdLoan extends Ad {
	
	private boolean hasShortLoan;
	private String period;
	private boolean isPetsAllowed;
	
	public AdLoan(){
		super(AdType.LOAN);
		
	}
	
	public AdLoan(double price, Currency currency, Estate estate, ContactData contact,
			Set<File> pictures, boolean hasShortLoan, String period, boolean isPetsAllowed) {
		super(price, currency, AdType.LOAN, estate, contact, pictures);
		this.setHasShortLoan(hasShortLoan);
		this.setPeriod(period);
		this.setPetsAllowed(isPetsAllowed);
	}

	public boolean isHasShortLoan() {
		return hasShortLoan;
	}

	public void setHasShortLoan(boolean hasShortLoan) {
		this.hasShortLoan = hasShortLoan;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public boolean isPetsAllowed() {
		return isPetsAllowed;
	}

	public void setPetsAllowed(boolean isPetsAllowed) {
		this.isPetsAllowed = isPetsAllowed;
	}
	
	
}
