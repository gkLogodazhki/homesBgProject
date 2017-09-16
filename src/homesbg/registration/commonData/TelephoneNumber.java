package homesbg.registration.commonData;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import homesbg.registration.agencyData.IllegalAgencyDataException;

public abstract class TelephoneNumber {
	private Scanner scanner = new Scanner(System.in);
	private List<String> number;
	
	public TelephoneNumber(){
		number = new ArrayList<String>();
	}
	
	public void companyAddNumbers(String message) {
		boolean flag = true;

		while (flag) {
			try {
				System.out.print(message);
				addNumber(scanner.nextLine());

				try {
					while (true) {
						System.out.println("Добави още?");
						System.out.println("1) Да");
						System.out.println("2) Не");
						System.out.print("Избери: ");
						int n = Integer.parseInt(scanner.nextLine());
						if (n == 1) {
							break;
						} else if (n == 2) {
							flag = false;
							break;
						} else {
							System.out.println("Моля изберете между \"1\" и \"2\"");
						}
					}
				} catch (InputMismatchException e) {
					System.out.println("Моля изберете между 1 и 2");
				}
				
			} catch (IllegalAgencyDataException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	
	private void addNumber(String number) throws IllegalAgencyDataException{
		if(!checkNumber(number)){
			throw new IllegalAgencyDataException("Телефонният номер трябва да започва с 08 и да съдържа 10символа");
		}
		this.number.add(number);
	}
	
	private boolean checkNumber(String number) {
		if(number == null || !number.startsWith("08") || number.trim().length() != 10){
			return false;
		}
		Pattern pattern = Pattern.compile("[^0-9]");
		Matcher matcher = pattern.matcher(number);
		
		return !matcher.find();
	}
	
}
