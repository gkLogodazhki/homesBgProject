package estate;

import java.util.Set;

import ad.Place;

public class Land extends Estate {

	public enum LandKind{
		FIELD, MEADOW, VINEYARD, ORCHARD, PASTURE,
		FOREST, OTHER
	}
	
	private int category;

	public Land(double area, EstateKind estateKind, Set<Extrable> extrables, String extraInfo, Place place,
			int category) {
		super(area, estateKind, extrables, extraInfo, place);
		this.setCategory(category);
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		if (category > 0) {
			this.category = category;
		} else {
			System.out.println("Incorrect category");
		}
	}
	
	
}
