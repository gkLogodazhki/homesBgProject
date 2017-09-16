package estate;

import java.util.Set;

import ad.Place;

public class Estate {

	public enum EstateKind{
		BUILDING, PARCEL, LAND
	}
	
	public interface Extrable{
		enum Parcel implements Extrable{
			ELECTRICITY, WATER, SEWERAGE, ASPHALT, COMPENSATION, BARTER
		}
		enum Land implements Extrable{
			ELECTRICITY, WATER, ASPHALT, BARTER
		}
		enum Building implements Extrable{
			BATHTUB, CLIMATIC, GARAGE, SOT, REHABILITATED, PARKING
		}
		enum BuildingLoan implements Extrable{
			COOKER, NET, FRIDGE, WASHING_MACHINE, DISHWASHER, TV, LISING,
			MORTGAGE
		}
		enum Apartment implements Extrable{
			PORTIER, ELEVATOR, LUXURY, GATED_COMPLEX
		}
		enum House implements Extrable{
			SWIMMING_POOL, GASIFICATION
		}
		
	}
	
	private double area;
	private EstateKind estateKind;
	private Set<Extrable> extrables;
 	private String extraInfo;
	private Place place;
	
	public Estate(double area, EstateKind estateKind, Set<Extrable> extrables, String extraInfo, Place place) {
		this.area = area;
		this.estateKind = estateKind;
		this.extrables = extrables;
		this.extraInfo = extraInfo;
		this.place = place;
	}
	
	
}
