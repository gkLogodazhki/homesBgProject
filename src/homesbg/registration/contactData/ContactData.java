package homesbg.registration.contactData;


import homesbg.registration.commonData.TelephoneNumber;

@SuppressWarnings("unused")
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
			, String webSiteLink){
		try{
			setCountry(country);
			setArea(area);
			setLivingArea(livingArea);
			setAddress(address);
			setWebSiteLink(webSiteLink);
		}catch(IllegalContactDataException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void setCountry(String country) throws IllegalContactDataException {
		if(!passSimpleValidation(country)){
			throw new IllegalContactDataException("��������� �������.");
		}
		this.country = country;
	}

	public void setArea(String area) throws IllegalContactDataException {
		if(!passSimpleValidation(area)){
			throw new IllegalContactDataException("��������� ������.");
		}
		this.area = area;
	}

	public void setLivingArea(String livingArea) throws IllegalContactDataException {
		if(!passSimpleValidation(livingArea)){
			throw new IllegalContactDataException("��������� �������� �����.");
		}
		this.livingArea = livingArea;
	}

	public void setAddress(String address) throws IllegalContactDataException {
		if(!passSimpleValidation(address)){
			throw new IllegalContactDataException("��������� �����.");
		}
		this.address = address;
	}

	public void setWebSiteLink(String webSiteLink) throws IllegalContactDataException {
		if(!passSimpleValidation(webSiteLink)){
			throw new IllegalContactDataException("������ ������ ������� ���� 3 �������.");
		}
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

}
