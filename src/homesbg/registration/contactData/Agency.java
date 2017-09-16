package homesbg.registration.contactData;

@SuppressWarnings("unused")
public class Agency extends ContactData{
	private String agencyName;
	
	public Agency(){
		
	}
	public Agency(String agencyName, String country, String area, String livingArea, String address
			, String webSiteLink){
		super(country,area,livingArea,address,webSiteLink);
		
		try {
			setAgencyName(agencyName);
		} catch (IllegalContactDataException e) {
			e.printStackTrace();
		}
	}
	
	
	public void setAgencyName(String agencyName) throws IllegalContactDataException {
		if(agencyName == null || agencyName.trim().length() < 3){
			throw new IllegalContactDataException("Името на агенцията трябва да съдържа поне 3 символа.");
		}
		this.agencyName = agencyName;
	}
	
}
