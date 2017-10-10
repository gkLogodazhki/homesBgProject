package homesbg.demoAdAndEstate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import homesbg.ad.Ad;
import homesbg.ad.Ad.AdType;
import homesbg.registration.contactData.ContactData;
import homesbg.registration.contactData.ContactData.ContactDataType;


public class RealEstateCompany {

	private String name;
	private Map<ContactDataType,Set<ContactData>> users;
	private Map<AdType,Set<Ad>> ads;
	
	public RealEstateCompany(String name) {
		this.name = name;
		this.users = new HashMap<>();
		this.ads = new HashMap<>();
	}
		
	public void addUser(ContactData cd) {
		if (!this.users.containsKey(cd.getContactDataType())) {
			this.users.put(cd.getContactDataType(), new HashSet<>());
		}
		if (this.users.get(cd.getContactDataType()).contains(cd)) {
			System.out.println("The ad already exist in our database");
		} else {
			this.users.get(cd.getContactDataType()).add(cd);
		}
	}
	
	public void addAd(Ad ad) {
		if (!this.ads.containsKey(ad.getAdType())) {
			this.ads.put(ad.getAdType(), new HashSet<>());
		}
		if (this.ads.get(ad.getAdType()).contains(ad)) {
			System.out.println("The ad already exist in our database");
		} else {
			this.ads.get(ad.getAdType()).add(ad);
		}
	}

	public String getName() {
		return name;
	}	
	
}
