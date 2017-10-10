package homesbg.registration.companyData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import homesbg.registration.commonData.CommonValidationsPlusTelephoneNumbers;

public class CompanyData extends CommonValidationsPlusTelephoneNumbers{
	private Type type;
	private String name;
	private String address;
	private String MOL;
	private String EIK;
	private String administrativePersonNames;
	private String duty;
	private String email;
	
	public CompanyData(){
		
	}
	public CompanyData(Type type,String name,String address,String MOL,String EIK
			,String administrativePersonNames, String duty, String number, String email) throws IllegalAgencyDataException{
		super(number);
		setType(type);
		setName(name);
		setAddress(address);
		setMOL(MOL);
		setEIK(EIK);
		setAdministrativePersonNames(administrativePersonNames);
		setDuty(duty);
		setEmail(email);
		
	}
	
	
	public Type getType(){
		return type;
	}
	

		
	public void setType(Type type) throws IllegalAgencyDataException {
		if(type == null){
			throw new IllegalAgencyDataException("Illegal type");
		}
		this.type = type;
	}
	
	public void setName(String name) throws IllegalAgencyDataException {
		if(name == null || name.trim().length() < 3){
			throw new IllegalAgencyDataException("The name must be bigger than 2 symbols ");
		}
		this.name = name;
	}
	
	public void setAddress(String address) throws IllegalAgencyDataException {
		if(address == null || address.trim().isEmpty()){
			throw new IllegalAgencyDataException("IllegalAddress");
		}
		this.address = address;
	}
	
	public void setMOL(String MOL) throws IllegalAgencyDataException {
		if(MOL == null || MOL.trim().isEmpty()){
			throw new IllegalAgencyDataException("Illegal MOL");
		}
		this.MOL = MOL;
	}
	
	public void setEIK(String EIK) throws IllegalAgencyDataException {
		if(EIK == null || EIK.trim().isEmpty()){
			throw new IllegalAgencyDataException("Illegal EIK");
		}
		this.EIK = EIK;
	}
	
	public void setAdministrativePersonNames(String administrativePersonNames) throws IllegalAgencyDataException {
		if(administrativePersonNames == null || administrativePersonNames.trim().isEmpty() 
				|| !checkNames(administrativePersonNames)){
			throw new IllegalAgencyDataException("Must input two names");
		}
		this.administrativePersonNames = administrativePersonNames;
	}
	private boolean checkNames(String administrativePersonNames) {
		String[] names = administrativePersonNames.trim().split(" ");
		if(names.length != 2){
			return false;
		}
		else{
			Pattern pattern = Pattern.compile("[^a-zA-Z\\ ]");
			Matcher matcher1 = pattern.matcher(names[0]);
			Matcher matcher2 = pattern.matcher(names[1]);
			if(matcher1.find()){
				for (int i = 0; i < names[0].length(); i++) {
					if(names[0].charAt(i) != ' '){
						if((names[0].charAt(i) < '�' || names[0].charAt(i) > '�' ) 
								&& (names[0].charAt(i) < '�' || names[0].charAt(i) > '�')){
							return false;
						}
					}
				}
			}
			if(matcher2.find()){
				for (int i = 0; i < names[1].length(); i++) {
					if(names[1].charAt(i) != ' '){
						if((names[1].charAt(i) < '�' || names[1].charAt(i) > '�' ) 
								&& (names[1].charAt(i) < '�' || names[1].charAt(i) > '�')){
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public void setDuty(String duty) throws IllegalAgencyDataException {
		if(!simpleValidation(duty)) {
			throw new IllegalAgencyDataException("Illegal company duty");
		}
		this.duty = duty;
	}
	
	
	public void setEmail(String email) throws IllegalAgencyDataException {
		if(!emailValidation(email)) {
			throw new IllegalAgencyDataException("illegal company email");
		}
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getMOL() {
		return MOL;
	}
	public String getEIK() {
		return EIK;
	}
	public String getAdministrativePersonNames() {
		return administrativePersonNames;
	}
	public String getDuty() {
		return duty;
	}
	public String getEmail() {
		return email;
	}
	
	
}
