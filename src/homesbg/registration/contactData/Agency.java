package homesbg.registration.contactData;

public class Agency extends ContactData{
	private String agencyName;
	
	public Agency(){
		
	}
	public Agency(String agencyName, String country, String area, String livingArea, String address
			,String phone, String webSiteLink) throws IllegalContactDataException{
		super(country,area,livingArea,address,phone,webSiteLink);
		setAgencyName(agencyName);
	}
	
	
	public void setAgencyName(String agencyName) throws IllegalContactDataException {
		if(agencyName == null || agencyName.trim().length() < 3){
			throw new IllegalContactDataException("Illegal agency name");
		}
		this.agencyName = agencyName;
	}
	public String getAgencyName(){
		return agencyName;
		
	}
}
