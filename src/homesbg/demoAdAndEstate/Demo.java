package homesbg.demoAdAndEstate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import com.google.gson.Gson;

import homesbg.ad.Ad;
import homesbg.ad.Ad.Currency;
import homesbg.ad.AdLoan;
import homesbg.ad.Place.INeighborhood;
import homesbg.estate.Apartment;
import homesbg.estate.Building.ConstructionKind;
import homesbg.estate.Building.Creation;
import homesbg.estate.Building.Furnishing;
import homesbg.estate.Building.Heating;
import homesbg.estate.Estate.EstateKind;
import homesbg.estate.Estate.Extrable;

public class Demo {

	public static void main(String[] args) {
		
		
		RealEstateCompany rec = new RealEstateCompany("GMRealEstates");
		TreeSet<Extrable> extrables = new TreeSet<>((o1,o2)-> o1.toString().compareTo(o2.toString()));
		do {
			extrables.add(Extrable.Apartment.values()[new Random().nextInt(Extrable.Apartment.values().length)]);
		} while (extrables.size() != Extrable.Apartment.values().length/2);
		for (Extrable e : Extrable.BuildingLoan.values()) {
			extrables.add(e);
		}
		Set<File> pictures = new HashSet<>();

		Ad ad1 = new AdLoan(10001, Currency.LEVA
				, new Apartment(110, EstateKind.BUILDING, extrables, "Some things"
				, new Place(City.SOFIA, INeighborhood.Sofia.LOZENEC, "James Boucher 3")
				, true, 7, Furnishing.FURNISHED, Creation.AFTER_2006, ConstructionKind.BRICK, Heating.LOCAL, 4)
				
//				, new Agency() // error with Agency.class implementation, comment by Georgi L.
				, null
				
				, pictures
				, false, "3", true);
		
		Ad ad2 = new AdLoan(12000, Currency.$
				, new Apartment(150, EstateKind.BUILDING, extrables, "Some things"
				, new Place(City.SOFIA, INeighborhood.Sofia.MLADOST, "James Boucher 3")
				, true, 7, Furnishing.UNFURNISHED, Creation._2000_2006, ConstructionKind.EPK, Heating.ELECTRICAL, 4)
				
//				, new Agency() // error with Agency.class implementation, comment by Georgi L.
				, null
				
				, pictures
				, false, "5", true);
		
		rec.addAd(ad1);
		rec.addAd(ad2);
		
		File f = new File("demoHomesBg.txt");
		
		try {
			f.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		inputJsonToFile(new Gson().toJson(ad1),f);
		inputJsonToFile(new Gson().toJson(ad2),f);
		
	}
	
	public static void inputJsonToFile(String json, File f) {
				
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(f,true))) {
			bw.newLine();
			bw.write(json);
			bw.newLine();
			bw.flush();
			System.out.println("input json to file complite!");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
