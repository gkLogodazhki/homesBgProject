package homesbg.registration.agencyData;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import homesbg.registration.commonData.CommonValidationsPlusTelephoneNumbers;

public class AgencyData extends CommonValidationsPlusTelephoneNumbers{
	private Scanner scanner = new Scanner(System.in);
	private Type type;
	private String name;
	private String address;
	private String MOL;
	private String EIK;
	private String administrativePersonNames;
	private String duty;
	private String email;
	
	public AgencyData(){
		companyType();
		if(type.equals("Агенция_за_недвижими_имоти")){
			System.out.println("Тези данни служат за административен контакт и не се публикуват в офертите на "
					+ "агенцията");
		}else{
			System.out.println("Тези данни служат за административен контакт и не се публикуват в офертите на "
					+ "строителната фирма");
		}
		companyName();
		companyAddress();
		companyMOL();
		companyEIK();
		companyAdministrativePersonNames();
		companyDuty();
		companyAddNumbers("*Телефони за административен контакт: ");
		companyEmail();
		
	}
	
	public Type getType(){
		return type;
	}
	
	private void companyEmail() {
		while (email == null) {
			try {
				System.out.print("*Email за административен контакт: ");
				setEmail(scanner.nextLine());
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}
		}
	}


	private void companyDuty() {
		while (duty == null) {
			try {
				System.out.print("*Длъжност: ");
				setDuty(scanner.nextLine());
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}
		}
	}



	private void companyAdministrativePersonNames() {
		while (administrativePersonNames == null) {
			try {
				System.out.print("*Лице за административен контакт (име и фамилия): ");
				setAdministrativePersonNames(scanner.nextLine());
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}
		}
	}



	private void companyEIK() {
		while (EIK == null) {
			try {
				System.out.print("*ЕИК/Булстат: ");
				setEIK(scanner.nextLine());
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}



	private void companyMOL() {
		while (MOL == null) {
			try {
				System.out.print("*МОЛ: ");
				setMOL(scanner.nextLine());
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}
		}
	}



	private void companyAddress() {
		while (address == null) {
			try {
				System.out.print("*Адрес по регистрация: ");
				setAddress(scanner.nextLine());
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	private void companyName() {
		while (name == null) {
			try {
				System.out.print("*Име на фирмата (по данъчна регистрация.): ");
				setName(scanner.nextLine());
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	private void companyType() {
		while (type == null) {
			try {
				System.out.println("*Фирмата е: ");
				System.out.println("1) Агенция за недвижими имоти");
				System.out.println("2) Строителна фирма");
				System.out.print("Избери: ");
				int n = Integer.parseInt(scanner.nextLine());
				if (n == 1) {
					setType(Type.Агенция_за_недвижими_имоти);
				} else if (n == 2) {
					setType(Type.Строителна_фирма);
				} else {
					System.out.println("Изберете една от двете опции.");
				}
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}catch(InputMismatchException e){
				System.out.println("Моля изберете между \"1\" и \"2\"");
			}
		}
		
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
