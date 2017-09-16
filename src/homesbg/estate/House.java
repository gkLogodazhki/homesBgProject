package estate;

import java.util.Set;

import ad.Place;

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
		this.hasYard = hasYard;
		this.countBedrooms = countBedrooms;
		this.countBathrooms = countBathrooms;
	}
	
}
