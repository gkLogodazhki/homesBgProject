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
	
	public Place(City place, INeighborhood neighborhood, String address) {
		this.place = place;
		this.neighborhood = neighborhood;
		this.address = address;
	}
	
}
