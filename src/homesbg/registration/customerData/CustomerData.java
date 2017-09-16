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
	private String accountUsage;
	
	public CustomerData(){
	}
	
	public CustomerData(String email, String password, String repeatedPassword, String fName
			, String lName, String duty, String accountUsage){
		try{
			setEmail(email);
			setPassword(password);
			setRepeatedPassword(repeatedPassword);
			setfName(fName);
			setlName(lName);
			setDuty(duty);
			setAccountUsage(accountUsage);
			
		}catch(IllegalCustomerDataException e){
			System.out.println(e.getMessage());
		}
	}
	
	public CustomerData(String email, String password, String repeatedPassword, String fName
			, String lName, String duty, String skype, String accountUsage){
		this(email,password,repeatedPassword,fName,lName,duty,accountUsage);
		try{
			setSkype(skype);
		}catch(IllegalCustomerDataException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public CustomerData(String email, String password, String repeatedPassword, String fName
			, String lName, String duty,String skype, String additionalInfo, String accountUsage){
		this(email,password,repeatedPassword,fName,lName,duty,skype,accountUsage);
		try{
			setAdditionalInfo(additionalInfo);
		}catch(IllegalCustomerDataException e){
			System.out.println(e.getMessage());
		}
		
	}

	public void setEmail(String email) throws IllegalCustomerDataException {
		if(!emailValidation(email)){
			throw new IllegalCustomerDataException("��������� �����.");
		}
		this.email = email;
	}
	
	public void setPassword(String password) throws IllegalCustomerDataException {
		if(!simplePasswordValidation(password)){
			throw new IllegalCustomerDataException("�������� ������ �� ������� ���� 6 �������.");
		}
		this.password = password;
	}
	
	public void setRepeatedPassword(String repeatedPassword) throws IllegalCustomerDataException {
		if(repeatedPassword == null || !repeatedPassword.equals(password)){
			throw new IllegalCustomerDataException("����������� ����� ��������. ���� �������� ���.");
		}
		this.repeatedPassword = repeatedPassword;
	}
	
	public void setfName(String fName) throws IllegalCustomerDataException {
		if(!simpleValidation(fName)){
			throw new IllegalCustomerDataException("���� �������� �������� ���.");
		}
		this.fName = fName;
	}
	
	public void setlName(String lName) throws IllegalCustomerDataException {
		if(!simpleValidation(lName)){
			throw new IllegalCustomerDataException("���� �������� �������� �������.");
		}
		this.lName = lName;
	}
	
	public void setDuty(String duty) throws IllegalCustomerDataException {
		if(!simpleValidation(duty)){
			throw new IllegalCustomerDataException("��������� ��������.");
		}
		this.duty = duty;
	}
	
	public void setSkype(String skype) throws IllegalCustomerDataException {
		if(skype == null || skype.trim().isEmpty()){
			throw new IllegalCustomerDataException("��������� �����.");
		}
		this.skype = skype;
	}
	
	public void setAdditionalInfo(String additionalInfo) throws IllegalCustomerDataException {
		if(additionalInfo == null || additionalInfo.trim().isEmpty()){
			throw new IllegalCustomerDataException("���� �������� ������������ ����������.");
		}
		this.additionalInfo = additionalInfo;
	}
	public void setAccountUsage(String accountUsage) throws IllegalCustomerDataException {
		if(accountUsage == null || accountUsage.trim().isEmpty()){
			throw new IllegalCustomerDataException("�������� �����.");
		}
		this.accountUsage = accountUsage;
	}

}
