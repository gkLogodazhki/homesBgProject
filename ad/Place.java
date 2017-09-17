package ad;

public class Place {

	public enum City{
		SOFIA
	}
	public interface INeighborhood{
		enum Sofia implements INeighborhood{
			LOZENEC, MLADOST, VITOSHA
		}
	}
	
	private City place;
	private INeighborhood neighborhood;
	private String address;
	
	public Place() {
		this.setPlace(City.SOFIA);
	}
	
	public Place(City place, INeighborhood neighborhood, String address) {
		this.setPlace(place);
		this.setNeighborhood(neighborhood);
		this.setAddress(address);
	}

	public City getPlace() {
		return place;
	}

	public void setPlace(City place) {
		this.place = place;
	}

	public INeighborhood getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(INeighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = !"".equals(address)? address : null;
	}
	
	
}
