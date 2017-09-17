package homesbg.estate;

import java.util.Set;

import homesbg.ad.Place;


public class House extends Building {

	private boolean hasYard;
	private int countBedrooms;
	private int countBathrooms;
	
	public House(double area, EstateKind estateKind, Set<Extrable> extrables, String extraInfo, Place place,
			Boolean isFinished, int allFloors, Furnishing furnishing, Creation creation,
			ConstructionKind constructionKind, Heating heating, boolean hasYard, int countBedrooms,
			int countBathrooms) {
		super(area, estateKind, extrables, extraInfo, place, isFinished, allFloors, furnishing, creation,
				constructionKind, heating);
		this.setHasYard(hasYard);
		this.setCountBedrooms(countBedrooms);
		this.setCountBathrooms(countBathrooms);
	}

	public boolean isHasYard() {
		return hasYard;
	}

	public void setHasYard(boolean hasYard) {
		this.hasYard = hasYard;
	}

	public int getCountBedrooms() {
		return countBedrooms;
	}

	public void setCountBedrooms(int countBedrooms) {
		if (countBedrooms > 0) {
			this.countBedrooms = countBedrooms;
		} else {
			System.out.println("Incorrect count of bedrooms");
		}
	}

	public int getCountBathrooms() {
		return countBathrooms;
	}

	public void setCountBathrooms(int countBathrooms) {
		if (countBathrooms > 0) {
			this.countBathrooms = countBathrooms;
		} else {
			System.out.println("Incorrect count of bathrooms");
		}
	}
	
	
	
}
