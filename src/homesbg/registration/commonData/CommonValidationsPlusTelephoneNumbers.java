package homesbg.registration.commonData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class CommonValidationsPlusTelephoneNumbers extends TelephoneNumber{
	public CommonValidationsPlusTelephoneNumbers() {
	}
	public CommonValidationsPlusTelephoneNumbers(String number) {
		super(number);
	}

	public boolean simpleValidation(String text){
		if(text == null || text.trim().length() < 3){
			return false;
		}
		return true;
	}
	
	public boolean emailValidation(String email){
		if(email == null){
			return false;
		}
		Pattern pattern = Pattern.compile("^.+@.+\\..+$");
		Matcher matcher = pattern.matcher(email);
		
		return matcher.find();
	}
	
	// at least 6 symbols
	public boolean simplePasswordValidation(String password){
		if(password == null || password.trim().length() < 6){
			return false;
		}
		return true;
	}
	
}
