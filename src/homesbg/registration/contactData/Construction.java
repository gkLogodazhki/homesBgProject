package homesbg.registration.contactData;


public class Construction extends ContactData{

	public Construction(){
		
	}
	public Construction(String country, String area, String livingArea, String address
			,String phone, String webSiteLink) throws IllegalContactDataException{
		super(country,area,livingArea,address,phone,webSiteLink);
	}
	
}
