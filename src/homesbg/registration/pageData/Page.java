package homesbg.registration.pageData;

import java.util.Scanner;

public class Page {
	private Scanner scanner;
	private String name;

	public Page(){
		
	}

	public void addName(){
		scanner = new Scanner(System.in);
		while(name == null){
			try{
				System.out.println("*�����o ��� �� �������� (���.homes.bg): ");
				setName(scanner.nextLine());
			}catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	private void setName(String name) {
		if(name == null || name.trim().length() < 3){
			throw new IllegalArgumentException("����� ������ �� ������� ������� 3 �������.");
		}
		this.name = name;
	}
	
	
}
