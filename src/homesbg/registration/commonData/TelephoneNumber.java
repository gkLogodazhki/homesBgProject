package homesbg.registration.commonData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class TelephoneNumber {
	private String number;
	
	public TelephoneNumber(){
	}
	
	public TelephoneNumber(String number){
		if(checkNumber(number)){
			this.number = number;
		}
		else{
			throw new IllegalArgumentException("Illegal phone number.");
		}
	}
	
	private boolean checkNumber(String number) {
		if(number == null || !number.startsWith("08") || number.trim().length() != 10){
			return false;
		}
		Pattern pattern = Pattern.compile("[^0-9]");
		Matcher matcher = pattern.matcher(number);
		
		return !matcher.find();
	}
	
	public String getNumber(){
		return number;
	}
	
}
