package homesbg.estate;

import java.util.Set;
import java.util.TreeSet;

import homesbg.ad.Place;


public abstract class Estate {

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
		this.setArea(area);
		this.setEstateKind(estateKind);
		this.extrables = new TreeSet<>((o1,o2)->o1.toString().compareTo(o2.toString()));
		this.setExtrables(extrables);
		this.setExtraInfo(extraInfo);
		this.setPlace(place);
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		if (area > 0) {
			this.area = area;
		} else {
			System.out.println("area size must be greater than 0");
		}
	}

	public EstateKind getEstateKind() {
		return estateKind;
	}

	public void setEstateKind(EstateKind estateKind) {
		this.estateKind = estateKind;
	}

	public Set<Extrable> getExtrables() {
		return java.util.Collections.unmodifiableSet(this.extrables);
	}

	public void setExtrables(Set<Extrable> extrables) {
		this.extrables = extrables;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = !"".equals(extraInfo) ? extraInfo : "";
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
	
	
}
