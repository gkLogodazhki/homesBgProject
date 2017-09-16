package homesbg.registration.contactData;


public class Agency extends ContactData{
	private String agencyName;
	
	@Override
	public void fillTheGaps(){
		setName();
		super.fillTheGaps();
	}

	private void setName() {
		while(agencyName == null){
			try{
				System.out.print("*Име на агенцията: ");
				setAgencyName(scanner.nextLine());
			}catch(IllegalContactDataException e){
				System.out.println(e.getMessage());
			}
		}
		
	}


	public void setAgencyName(String agencyName) throws IllegalContactDataException {
		if(agencyName == null || agencyName.trim().length() < 3){
			throw new IllegalContactDataException("Името на агенцията трябва да съдържа поне 3 символа.");
		}
		this.agencyName = agencyName;
	}
	
}
