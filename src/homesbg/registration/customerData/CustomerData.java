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
		companyAddNumbers("*Телефон: ");
		companyAddSkype();
		companyAddAdditionalInfo();
		companyAddAccountUsage();
		
	}
	
	private void companyAddAccountUsage() {
		while(accountUsage == null){
			try{
				System.out.println("Този акаунт ще се ползва:");
				System.out.println("1) само като администратор");
				System.out.println("2) като администратор и търговец");
				System.out.println("(Ако използвате този потребител като търговец, въведените данни съставят вашата визитка"
						+ ", която се публикува под вашите оферти)");
				System.out.print("Избери: ");
				String answer = scanner.nextLine();
				if(answer != null && answer.contains("1")){
					setAccountUsage("Администратор");
				}
				else if(answer != null && answer.contains("2")){
					setAccountUsage("Администратор и търговец.");
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
		System.out.println("Искате ли да добавите допълнителна информация?");
		System.out.println("1) Да");
		System.out.println("2) Не");
		System.out.print("Избери: ");
		String answer = scanner.nextLine();
		if(answer != null && answer.contains("1")){
			while(additionalInfo == null){
				try{
					System.out.println("Допълнителна информация: ");
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
		System.out.println("Искате ли да добавите скайп?");
		System.out.println("1) Да");
		System.out.println("2) Не");
		System.out.print("Избери: ");
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
				System.out.println("*Длъжност: ");
				setDuty(scanner.nextLine());
			}catch(IllegalCustomerDataException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void customerDataLName() {
		while(lName == null){
			try{
				System.out.println("*Фамилия: ");
				setlName(scanner.nextLine());
			}catch(IllegalCustomerDataException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void customerDataFName() {
		while(fName == null){
			try{
				System.out.println("*Име: ");
				setfName(scanner.nextLine());
			}catch(IllegalCustomerDataException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void customerDataPassword() {
		while(password == null && repeatedPassword == null){
			try{
				System.out.println("*Парола (Паролата не трябва да е по-малка от 6 символа): ");
				setPassword(scanner.nextLine());
				System.out.println("*Парола (повтори): ");
				setRepeatedPassword(scanner.nextLine());
			}catch(IllegalCustomerDataException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void customerDataEmail() {
		while(email == null){
			try{
				System.out.println("*Email (служи като потребителско име): ");
				setEmail(scanner.nextLine());
			}catch(IllegalCustomerDataException e){
				System.out.println(e.getMessage());
			}
		}
		
	}

	public void setEmail(String email) throws IllegalCustomerDataException {
		if(!emailValidation(email)){
			throw new IllegalCustomerDataException("Невалиден емайл.");
		}
		this.email = email;
	}
	
	public void setPassword(String password) throws IllegalCustomerDataException {
		if(!simplePasswordValidation(password)){
			throw new IllegalCustomerDataException("Паролата трябва да съдържа поне 6 символа.");
		}
		this.password = password;
	}
	
	public void setRepeatedPassword(String repeatedPassword) throws IllegalCustomerDataException {
		if(repeatedPassword == null || !repeatedPassword.equals(password)){
			throw new IllegalCustomerDataException("Разминаване между паролите. Моля опитайте пак.");
		}
		this.repeatedPassword = repeatedPassword;
	}
	
	public void setfName(String fName) throws IllegalCustomerDataException {
		if(!simpleValidation(fName)){
			throw new IllegalCustomerDataException("Моля въведете истинско име.");
		}
		this.fName = fName;
	}
	
	public void setlName(String lName) throws IllegalCustomerDataException {
		if(!simpleValidation(lName)){
			throw new IllegalCustomerDataException("Моля въведете истинска фамилия.");
		}
		this.lName = lName;
	}
	
	public void setDuty(String duty) throws IllegalCustomerDataException {
		if(!simpleValidation(duty)){
			throw new IllegalCustomerDataException("Невалидна длъжност.");
		}
		this.duty = duty;
	}
	
	public void setSkype(String skype) throws IllegalCustomerDataException {
		if(skype == null || skype.trim().isEmpty()){
			throw new IllegalCustomerDataException("Невалидна скайп.");
		}
		this.skype = skype;
	}
	
	public void setAdditionalInfo(String additionalInfo) throws IllegalCustomerDataException {
		if(additionalInfo == null || additionalInfo.trim().isEmpty()){
			throw new IllegalCustomerDataException("Моля въведете допълнителна информация.");
		}
		this.additionalInfo = additionalInfo;
	}
	public void setAccountUsage(String accountUsage) throws IllegalCustomerDataException {
		if(accountUsage == null || accountUsage.trim().isEmpty()){
			throw new IllegalCustomerDataException("Нвалидна опция.");
		}
		this.accountUsage = accountUsage;
	}

}
