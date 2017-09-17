package estate;

import java.util.Set;

import com.google.gson.Gson;

import ad.Place;

public abstract class Building extends Estate {

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
		this.setIsFinished(isFinished);
		this.setAllFloors(allFloors);
		this.setFurnishing(furnishing);
		this.setCreation(creation);
		this.setConstructionKind(constructionKind);
		this.setHeating(heating);
	}

	public Boolean getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}

	public int getAllFloors() {
		return allFloors;
	}

	public void setAllFloors(int allFloors) {
		this.allFloors = allFloors;
	}

	public Furnishing getFurnishing() {
		return furnishing;
	}

	public void setFurnishing(Furnishing furnishing) {
		this.furnishing = furnishing;
	}

	public Creation getCreation() {
		return creation;
	}

	public void setCreation(Creation creation) {
		this.creation = creation;
	}

	public ConstructionKind getConstructionKind() {
		return constructionKind;
	}

	public void setConstructionKind(ConstructionKind constructionKind) {
		this.constructionKind = constructionKind;
	}

	public Heating getHeating() {
		return heating;
	}

	public void setHeating(Heating heating) {
		this.heating = heating;
	}
	
	public void printJson() {
		Gson json = new Gson();
		json.toJson(this);
	}
	
}
