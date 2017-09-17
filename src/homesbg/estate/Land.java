package homesbg.estate;

import java.util.Set;

import homesbg.ad.Place;


public class Land extends Estate {

	public enum LandKind{
		FIELD, MEADOW, VINEYARD, ORCHARD, PASTURE,
		FOREST, OTHER
	}
	
	private int category;

	public Land(double area, EstateKind estateKind, Set<Extrable> extrables, String extraInfo, Place place,
			int category) {
		super(area, estateKind, extrables, extraInfo, place);
		this.category = category;
	}
	
	
}
