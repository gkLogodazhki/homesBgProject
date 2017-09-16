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
		if(country.toLowerCase().equals("��������") || country.toLowerCase().equals("bulgaria")){
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
		companyAddNumbers("*�������: ");
		contactDataWebSiteLink();
		
	}
	
	private void contactDataWebSiteLink() {
		System.out.println("������ �� �� �������� ��� ����?");
		System.out.println("1) ��");
		System.out.println("2) ��");
		System.out.print("������: ");
		String answer = scanner.nextLine();
		if(answer.contains("1")){
			while(webSiteLink == null){
				try{
					System.out.print("��� ����: ");
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
				System.out.print("*�����: ");
				setAddress(scanner.nextLine());
			}catch(IllegalContactDataException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void contactDataLivingArea() {
		while(livingArea == null){
			try{
				System.out.print("*�������� �����: ");
				setLivingArea(scanner.nextLine());
			}catch(IllegalContactDataException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void contactDataArea() {
		while(area == null){
			try{
				System.out.print("*������: ");
				setArea(scanner.nextLine());
			}catch(IllegalContactDataException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void contactDataCountry() {
		while(country == null){
			try{
				System.out.print("*�������: ");
				setCountry(scanner.nextLine());
			}catch(IllegalContactDataException e){
				System.out.println(e.getMessage());
			}
		}
		
	}

	public void setCountry(String country) throws IllegalContactDataException {
		if(!passSimpleValidation(country)){
			throw new IllegalContactDataException("��������� �������.");
		}
		this.country = country;
	}

	public void setArea(String area) throws IllegalContactDataException {
		if(!passSimpleValidation(area)){
			throw new IllegalContactDataException("��������� ������.");
		}
		this.area = area;
	}

	public void setLivingArea(String livingArea) throws IllegalContactDataException {
		if(!passSimpleValidation(livingArea)){
			throw new IllegalContactDataException("��������� �������� �����.");
		}
		this.livingArea = livingArea;
	}

	public void setAddress(String address) throws IllegalContactDataException {
		if(!passSimpleValidation(address)){
			throw new IllegalContactDataException("��������� �����.");
		}
		this.address = address;
	}

	public void setWebSiteLink(String webSiteLink) throws IllegalContactDataException {
		if(!passSimpleValidation(webSiteLink)){
			throw new IllegalContactDataException("������ ������ ������� ���� 3 �������.");
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
