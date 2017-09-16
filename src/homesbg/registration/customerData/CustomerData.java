package homesbg.registration.customerData;

import java.util.Scanner;

import homesbg.registration.commonData.CommonValidationsPlusTelephoneNumbers;

public class CustomerData extends CommonValidationsPlusTelephoneNumbers implements ICustomerData{
	private Scanner scanner;
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
		scanner = new Scanner(System.in);
	}
	
	@Override
	public void fillTheGaps() {
		customerDataEmail();
		customerDataPassword();
		customerDataFName();
		customerDataLName();
		customerDataDuty();
		companyAddNumbers("*�������: ");
		companyAddSkype();
		companyAddAdditionalInfo();
		companyAddAccountUsage();
		
	}
	
	private void companyAddAccountUsage() {
		while(accountUsage == null){
			try{
				System.out.println("���� ������ �� �� ������:");
				System.out.println("1) ���� ���� �������������");
				System.out.println("2) ���� ������������� � ��������");
				System.out.println("(��� ���������� ���� ���������� ���� ��������, ���������� ����� �������� ������ �������"
						+ ", ����� �� ��������� ��� ������ ������)");
				System.out.print("������: ");
				String answer = scanner.nextLine();
				if(answer != null && answer.contains("1")){
					setAccountUsage("�������������");
				}
				else if(answer != null && answer.contains("2")){
					setAccountUsage("������������� � ��������.");
				}
				else{
					setAccountUsage(null);
				}
			}catch(IllegalCustomerDataException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void companyAddAdditionalInfo() {
		System.out.println("������ �� �� �������� ������������ ����������?");
		System.out.println("1) ��");
		System.out.println("2) ��");
		System.out.print("������: ");
		String answer = scanner.nextLine();
		if(answer != null && answer.contains("1")){
			while(additionalInfo == null){
				try{
					System.out.println("������������ ����������: ");
					setAdditionalInfo(scanner.nextLine());
				}catch(IllegalCustomerDataException e){
					System.out.println(e.getMessage());
				}
			}
		}
		else{
			try {
				setAdditionalInfo("none");
			} catch (IllegalCustomerDataException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void companyAddSkype() {
		System.out.println("������ �� �� �������� �����?");
		System.out.println("1) ��");
		System.out.println("2) ��");
		System.out.print("������: ");
		String answer = scanner.nextLine();
		if(answer != null && answer.contains("1")){
			while(skype == null){
				try{
					System.out.println("Skype: ");
					setSkype(scanner.nextLine());
				}catch(IllegalCustomerDataException e){
					System.out.println(e.getMessage());
				}
			}
		}
		else{
			try {
				setSkype("none");
			} catch (IllegalCustomerDataException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void customerDataDuty() {
		while(duty == null){
			try{
				System.out.println("*��������: ");
				setDuty(scanner.nextLine());
			}catch(IllegalCustomerDataException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void customerDataLName() {
		while(lName == null){
			try{
				System.out.println("*�������: ");
				setlName(scanner.nextLine());
			}catch(IllegalCustomerDataException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void customerDataFName() {
		while(fName == null){
			try{
				System.out.println("*���: ");
				setfName(scanner.nextLine());
			}catch(IllegalCustomerDataException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void customerDataPassword() {
		while(password == null && repeatedPassword == null){
			try{
				System.out.println("*������ (�������� �� ������ �� � ��-����� �� 6 �������): ");
				setPassword(scanner.nextLine());
				System.out.println("*������ (�������): ");
				setRepeatedPassword(scanner.nextLine());
			}catch(IllegalCustomerDataException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void customerDataEmail() {
		while(email == null){
			try{
				System.out.println("*Email (����� ���� ������������� ���): ");
				setEmail(scanner.nextLine());
			}catch(IllegalCustomerDataException e){
				System.out.println(e.getMessage());
			}
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
