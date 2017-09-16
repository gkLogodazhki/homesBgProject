package estate;

import java.util.Set;

import ad.Place;

public class Building extends Estate {

	public enum BuildingKind{
		APARTMENT, HOUSE
	}
	
	public interface IBuildingType{
		
		enum Apartment implements IBuildingType{
			ONE_ROOM,TWO_ROOM, THREE_ROOM, FOUR_ROOM, MULTI_ROOM,MAISONETTE, ATELIER, ROOM,GARAGE;
		}
		enum House implements IBuildingType{
			WHOLE, FLOOR
		}
		
	}
	
	public enum Furnishing{
		FURNISHED, UNFURNISHED, HALF_FURNISHED
	}
	public enum Creation{
		BEFORE_1990, _1990_1999, _2000_2006, AFTER_2006
	}
	public enum ConstructionKind{
		BRICK, BEAMWORK, PANEL, EPK
	}
	public enum Heating{
		HEC, LOCAL, ELECTRICAL, NONE 
	}
	
	private Boolean isFinished = true;
	private int allFloors;
	private Furnishing furnishing;
	private Creation creation;
	private ConstructionKind constructionKind;
	private Heating heating;

	public Building(double area, EstateKind estateKind, Set<Extrable> extrables, String extraInfo, Place place,
			Boolean isFinished, int allFloors, Furnishing furnishing, Creation creation,
			ConstructionKind constructionKind, Heating heating) {
		super(area, estateKind, extrables, extraInfo, place);
		this.isFinished = isFinished;
		this.allFloors = allFloors;
		this.furnishing = furnishing;
		this.creation = creation;
		this.constructionKind = constructionKind;
		this.heating = heating;
	}
	
	
	
}
