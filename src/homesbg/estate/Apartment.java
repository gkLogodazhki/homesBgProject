package estate;

import java.util.Set;

import ad.Place;

public class Apartment extends Building {

	private int floor;

	public Apartment(double area, EstateKind estateKind, Set<Extrable> extrables, String extraInfo, Place place,
			Boolean isFinished, int allFloors, Furnishing furnishing, Creation creation,
			ConstructionKind constructionKind, Heating heating, int floor) {
		super(area, estateKind, extrables, extraInfo, place, isFinished, allFloors, furnishing, creation,
				constructionKind, heating);
		this.floor = floor;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		if (floor > 0 && floor <= this.getAllFloors()) {
			this.floor = floor;
		} else {
			System.out.println("Incorrect floor");
		}
	}
	
	
	
}
