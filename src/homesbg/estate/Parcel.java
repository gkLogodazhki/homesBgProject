package homesbg.estate;

import java.util.Set;

import homesbg.ad.Place;

public class Parcel extends Estate {

	private boolean hasRegulation;
	private boolean isVisaProject;
	private boolean hasPermission;
	
	public Parcel(double area, EstateKind estateKind, Set<Extrable> extrables, String extraInfo, Place place,
			boolean hasRegulation, boolean isVisaProject, boolean hasPermission) {
		super(area, estateKind, extrables, extraInfo, place);
		this.hasRegulation = hasRegulation;
		this.isVisaProject = isVisaProject;
		this.hasPermission = hasPermission;
	}
	
	
}
