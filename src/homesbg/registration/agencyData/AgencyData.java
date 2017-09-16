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
		if(type.equals("�������_��_���������_�����")){
			System.out.println("���� ����� ������ �� ��������������� ������� � �� �� ���������� � �������� �� "
					+ "���������");
		}else{
			System.out.println("���� ����� ������ �� ��������������� ������� � �� �� ���������� � �������� �� "
					+ "������������ �����");
		}
		companyName();
		companyAddress();
		companyMOL();
		companyEIK();
		companyAdministrativePersonNames();
		companyDuty();
		companyAddNumbers("*�������� �� ��������������� �������: ");
		companyEmail();
		
	}
	
	public Type getType(){
		return type;
	}
	
	private void companyEmail() {
		while (email == null) {
			try {
				System.out.print("*Email �� ��������������� �������: ");
				setEmail(scanner.nextLine());
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}
		}
	}


	private void companyDuty() {
		while (duty == null) {
			try {
				System.out.print("*��������: ");
				setDuty(scanner.nextLine());
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}
		}
	}



	private void companyAdministrativePersonNames() {
		while (administrativePersonNames == null) {
			try {
				System.out.print("*���� �� ��������������� ������� (��� � �������): ");
				setAdministrativePersonNames(scanner.nextLine());
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}
		}
	}



	private void companyEIK() {
		while (EIK == null) {
			try {
				System.out.print("*���/�������: ");
				setEIK(scanner.nextLine());
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}



	private void companyMOL() {
		while (MOL == null) {
			try {
				System.out.print("*���: ");
				setMOL(scanner.nextLine());
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}
		}
	}



	private void companyAddress() {
		while (address == null) {
			try {
				System.out.print("*����� �� �����������: ");
				setAddress(scanner.nextLine());
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	private void companyName() {
		while (name == null) {
			try {
				System.out.print("*��� �� ������� (�� ������� �����������.): ");
				setName(scanner.nextLine());
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	private void companyType() {
		while (type == null) {
			try {
				System.out.println("*������� �: ");
				System.out.println("1) ������� �� ��������� �����");
				System.out.println("2) ���������� �����");
				System.out.print("������: ");
				int n = Integer.parseInt(scanner.nextLine());
				if (n == 1) {
					setType(Type.�������_��_���������_�����);
				} else if (n == 2) {
					setType(Type.����������_�����);
				} else {
					System.out.println("�������� ���� �� ����� �����.");
				}
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}catch(InputMismatchException e){
				System.out.println("���� �������� ����� \"1\" � \"2\"");
			}
		}
		
	}

	public void setType(Type type) throws IllegalAgencyDataException {
		if(type == null){
			throw new IllegalAgencyDataException("��������� ��� �� �������");
		}
		this.type = type;
	}
	
	public void setName(String name) throws IllegalAgencyDataException {
		if(!simpleValidation(name)){
			throw new IllegalAgencyDataException("����� ������ �� ���� ���� 3 �������, � �� ���� �� ������� \" \" ");
		}
		this.name = name;
	}
	
	public void setAddress(String address) throws IllegalAgencyDataException {
		if(address == null || address.trim().isEmpty()){
			throw new IllegalAgencyDataException("��������� �����");
		}
		this.address = address;
	}
	
	public void setMOL(String MOL) throws IllegalAgencyDataException {
		if(MOL == null || MOL.trim().isEmpty()){
			throw new IllegalAgencyDataException("��������� MOL");
		}
		this.MOL = MOL;
	}
	
	public void setEIK(String EIK) throws IllegalAgencyDataException {
		if(EIK == null || EIK.trim().isEmpty()){
			throw new IllegalAgencyDataException("��������� EIK");
		}
		this.EIK = EIK;
	}
	
	public void setAdministrativePersonNames(String administrativePersonNames) throws IllegalAgencyDataException {
		if(administrativePersonNames == null || administrativePersonNames.trim().isEmpty() 
				|| !checkNames(administrativePersonNames)){
			throw new IllegalAgencyDataException("��������� ���� �� ��������������� ������� ");
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
						if((names[0].charAt(i) < '�' || names[0].charAt(i) > '�' ) 
								&& (names[0].charAt(i) < '�' || names[0].charAt(i) > '�')){
							return false;
						}
					}
				}
			}
			if(matcher2.find()){
				for (int i = 0; i < names[1].length(); i++) {
					if(names[1].charAt(i) != ' '){
						if((names[1].charAt(i) < '�' || names[1].charAt(i) > '�' ) 
								&& (names[1].charAt(i) < '�' || names[1].charAt(i) > '�')){
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
			throw new IllegalAgencyDataException("��������� ��������");
		}
		this.duty = duty;
	}
	
	
	public void setEmail(String email) throws IllegalAgencyDataException {
		if(!emailValidation(email)) {
			throw new IllegalAgencyDataException("��������� email �����");
		}
		this.email = email;
	}

	
}
