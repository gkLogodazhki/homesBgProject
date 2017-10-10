package homesbg.registration.customerData;


import homesbg.registration.commonData.CommonValidationsPlusTelephoneNumbers;

@SuppressWarnings("unused")
public class CustomerData extends CommonValidationsPlusTelephoneNumbers {
	private String email;
	private String password;
	private String repeatedPassword;
	private String fName;
	private String lName;
	private String duty;
	private String skype;
	private String additionalInfo;
	private AccountUsage accountUsage;
	
	public CustomerData(){
	}
	
	public CustomerData(String email, String password, String repeatedPassword, String fName
			, String lName, String duty,String phone, String skype, String addInfo,
			String accountUsage) throws IllegalCustomerDataException{
		super(phone);
		setEmail(email);
		setPassword(password);
		setRepeatedPassword(repeatedPassword);
		setfName(fName);
		setlName(lName);
		setDuty(duty);
		setSkype(skype);
		setAdditionalInfo(addInfo);
		setAccountUsage(accountUsage);
	}
	

	public void setEmail(String email) throws IllegalCustomerDataException {
		if(!emailValidation(email)){
			throw new IllegalCustomerDataException("Invalid email");
		}
		this.email = email;
	}
	
	public void setPassword(String password) throws IllegalCustomerDataException {
		if(password == null || password.trim().length() < 6){
			throw new IllegalCustomerDataException("invalid password");
		}
		this.password = password;
	}
	
	public void setRepeatedPassword(String repeatedPassword) throws IllegalCustomerDataException {
		if(repeatedPassword == null || !repeatedPassword.equals(password)){
			throw new IllegalCustomerDataException("invalid second password");
		}
		this.repeatedPassword = repeatedPassword;
	}
	
	public void setfName(String fName) throws IllegalCustomerDataException {
		if(!simpleValidation(fName)){
			throw new IllegalCustomerDataException("invalid first name");
		}
		this.fName = fName;
	}
	
	public void setlName(String lName) throws IllegalCustomerDataException {
		if(!simpleValidation(lName)){
			throw new IllegalCustomerDataException("invalid second name");
		}
		this.lName = lName;
	}
	
	public void setDuty(String duty) throws IllegalCustomerDataException {
		if(!simpleValidation(duty)){
			throw new IllegalCustomerDataException("invalid duty");
		}
		this.duty = duty;
	}
	
	public void setSkype(String skype) {
		this.skype = skype;
	}
	
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public void setAccountUsage(String accountUsage) throws IllegalCustomerDataException {
		switch(accountUsage){
		case "1": this.accountUsage = AccountUsage.само_като_администратор;break;
		case "2": this.accountUsage = AccountUsage.като_администратор_и_брокер;
		}
	}

	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getDuty() {
		return duty;
	}

	public String getSkype() {
		return skype;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public AccountUsage getAccountUsage() {
		return accountUsage;
	}
	
	enum AccountUsage{
		само_като_администратор, като_администратор_и_брокер
	}
	
	
	
}
