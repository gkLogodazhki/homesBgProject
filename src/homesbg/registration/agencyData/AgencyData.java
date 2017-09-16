package homesbg.registration.agencyData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import homesbg.registration.commonData.CommonValidationsPlusTelephoneNumbers;

@SuppressWarnings("unused")
public class AgencyData extends CommonValidationsPlusTelephoneNumbers{
	private Type type;
	private String name;
	private String address;
	private String MOL;
	private String EIK;
	private String administrativePersonNames;
	private String duty;
	private String email;
	
	public AgencyData(){
		
	}
	public AgencyData(String name,String address,String MOL,String EIK
			,String administrativePersonNames, String duty, String email){
		try{
			setName(name);
			setAddress(address);
			setMOL(MOL);
			setEIK(EIK);
			setAdministrativePersonNames(administrativePersonNames);
			setDuty(duty);
			setEmail(email);
		}catch(IllegalAgencyDataException e){
			System.out.println(e.getMessage());
		}
	}
	
	
	public Type getType(){
		return type;
	}
	

		
	public void setType(Type type) throws IllegalAgencyDataException {
		if(type == null){
			throw new IllegalAgencyDataException("Невалиден тип на фирмата");
		}
		this.type = type;
	}
	
	public void setName(String name) throws IllegalAgencyDataException {
		if(!simpleValidation(name)){
			throw new IllegalAgencyDataException("Името трябва да бъде поне 3 символа, и не може да съдържа \" \" ");
		}
		this.name = name;
	}
	
	public void setAddress(String address) throws IllegalAgencyDataException {
		if(address == null || address.trim().isEmpty()){
			throw new IllegalAgencyDataException("Невалиден адрес");
		}
		this.address = address;
	}
	
	public void setMOL(String MOL) throws IllegalAgencyDataException {
		if(MOL == null || MOL.trim().isEmpty()){
			throw new IllegalAgencyDataException("Невалиден MOL");
		}
		this.MOL = MOL;
	}
	
	public void setEIK(String EIK) throws IllegalAgencyDataException {
		if(EIK == null || EIK.trim().isEmpty()){
			throw new IllegalAgencyDataException("Невалиден EIK");
		}
		this.EIK = EIK;
	}
	
	public void setAdministrativePersonNames(String administrativePersonNames) throws IllegalAgencyDataException {
		if(administrativePersonNames == null || administrativePersonNames.trim().isEmpty() 
				|| !checkNames(administrativePersonNames)){
			throw new IllegalAgencyDataException("Невалидно лице за административен контакт ");
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
						if((names[0].charAt(i) < 'а' || names[0].charAt(i) > 'я' ) 
								&& (names[0].charAt(i) < 'А' || names[0].charAt(i) > 'Я')){
							return false;
						}
					}
				}
			}
			if(matcher2.find()){
				for (int i = 0; i < names[1].length(); i++) {
					if(names[1].charAt(i) != ' '){
						if((names[1].charAt(i) < 'а' || names[1].charAt(i) > 'я' ) 
								&& (names[1].charAt(i) < 'А' || names[1].charAt(i) > 'Я')){
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
			throw new IllegalAgencyDataException("Невалидна длъжност");
		}
		this.duty = duty;
	}
	
	
	public void setEmail(String email) throws IllegalAgencyDataException {
		if(!emailValidation(email)) {
			throw new IllegalAgencyDataException("Невалиден email адрес");
		}
		this.email = email;
	}

	
}
