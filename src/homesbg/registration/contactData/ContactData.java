package homesbg.registration.contactData;

import java.util.Scanner;

import homesbg.registration.commonData.TelephoneNumber;

public abstract class ContactData extends TelephoneNumber implements IContactData{
	protected Scanner scanner = new Scanner(System.in);
	private String country;
	private String area;
	private String livingArea;
	private String address;
	private String webSiteLink;
	
	public void fillTheGaps(){
		contactDataCountry();
		if(country.toLowerCase().equals("българия") || country.toLowerCase().equals("bulgaria")){
			contactDataArea();
			contactDataLivingArea();
		}
		else{
			try {
				setArea("none");
				setLivingArea("none");
			} catch (IllegalContactDataException e) {
				e.printStackTrace();
			}
		}
		contactDataAddress();
		companyAddNumbers("*Телефон: ");
		contactDataWebSiteLink();
		
	}
	
	private void contactDataWebSiteLink() {
		System.out.println("Искате ли да добавите уеб сайт?");
		System.out.println("1) да");
		System.out.println("2) не");
		System.out.print("Избери: ");
		String answer = scanner.nextLine();
		if(answer.contains("1")){
			while(webSiteLink == null){
				try{
					System.out.print("Уеб сайт: ");
					setWebSiteLink(scanner.nextLine());
				}catch(IllegalContactDataException e){
					System.out.println(e.getMessage());
				}
			}
		}
	}

	private void contactDataAddress() {
		while(address == null){
			try{
				System.out.print("*Адрес: ");
				setAddress(scanner.nextLine());
			}catch(IllegalContactDataException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void contactDataLivingArea() {
		while(livingArea == null){
			try{
				System.out.print("*Населено място: ");
				setLivingArea(scanner.nextLine());
			}catch(IllegalContactDataException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void contactDataArea() {
		while(area == null){
			try{
				System.out.print("*Област: ");
				setArea(scanner.nextLine());
			}catch(IllegalContactDataException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void contactDataCountry() {
		while(country == null){
			try{
				System.out.print("*Държава: ");
				setCountry(scanner.nextLine());
			}catch(IllegalContactDataException e){
				System.out.println(e.getMessage());
			}
		}
		
	}

	public void setCountry(String country) throws IllegalContactDataException {
		if(!passSimpleValidation(country)){
			throw new IllegalContactDataException("Невалидна държава.");
		}
		this.country = country;
	}

	public void setArea(String area) throws IllegalContactDataException {
		if(!passSimpleValidation(area)){
			throw new IllegalContactDataException("Невалидна област.");
		}
		this.area = area;
	}

	public void setLivingArea(String livingArea) throws IllegalContactDataException {
		if(!passSimpleValidation(livingArea)){
			throw new IllegalContactDataException("Невалидно населено място.");
		}
		this.livingArea = livingArea;
	}

	public void setAddress(String address) throws IllegalContactDataException {
		if(!passSimpleValidation(address)){
			throw new IllegalContactDataException("Невалиден адрес.");
		}
		this.address = address;
	}

	public void setWebSiteLink(String webSiteLink) throws IllegalContactDataException {
		if(!passSimpleValidation(webSiteLink)){
			throw new IllegalContactDataException("Линкът трябва съдържа поне 3 символа.");
		}
		this.webSiteLink = webSiteLink;
	}
	
	private boolean passSimpleValidation(String text){
		if(text == null || text.trim().length() < 3){
			return false;
		}
		return true;
	}

}
