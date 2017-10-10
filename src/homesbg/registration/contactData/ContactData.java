package homesbg.registration.contactData;


import homesbg.registration.commonData.TelephoneNumber;

public abstract class ContactData extends TelephoneNumber{
	
	public enum ContactDataType{
		AGENCY, CONSTRUCTION, CUSTOMER
	}
	
	private String country;
	private String area;
	private String livingArea;
	private String address;
	private String webSiteLink;
	private ContactDataType contactDataType;

	public ContactData(){
		
	}
	public ContactData(String country, String area, String livingArea, String address
			, String phone, String webSiteLink) throws IllegalContactDataException{
		super(phone);
		setCountry(country);
		if (country.equals("1")) {
			setArea(area);
			setLivingArea(livingArea);
		}
		setAddress(address);
		setWebSiteLink(webSiteLink);
		
	}
	
	public void setCountry(String country) throws IllegalContactDataException {
		switch(country){
		case "1": this.country = "България";break;
		case "2": this.country = "Сърбия";break;
		case "3": this.country = "Румъния";break;
		case "4": this.country = "Гърция";break;
		case "5": this.country = "Македония";break;
		default : this.country = "";
		}
	}

	public void setArea(String area) throws IllegalContactDataException {
		if(!passSimpleValidation(area)){
			throw new IllegalContactDataException("Invalid area");
		}
		this.area = area;
	}

	public void setLivingArea(String livingArea) throws IllegalContactDataException {
		if(!passSimpleValidation(livingArea)){
			throw new IllegalContactDataException("invalid living area");
		}
		this.livingArea = livingArea;
	}

	public void setAddress(String address) throws IllegalContactDataException {
		if(!passSimpleValidation(address)){
			throw new IllegalContactDataException("Invalid address");
		}
		this.address = address;
	}

	public void setWebSiteLink(String webSiteLink) {
		this.webSiteLink = webSiteLink;
	}
	
	private boolean passSimpleValidation(String text){
		if(text == null || text.trim().length() < 3){
			return false;
		}
		return true;
	}
	
	public ContactDataType getContactDataType() {
		return this.contactDataType;
	}
	public String getCountry() {
		return country;
	}
	public String getArea() {
		return area;
	}
	public String getLivingArea() {
		return livingArea;
	}
	public String getAddress() {
		return address;
	}
	public String getWebSiteLink() {
		return webSiteLink;
	}
	
}
