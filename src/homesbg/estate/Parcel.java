package estate;

import java.util.Set;

import ad.Place;

public class Parcel extends Estate {

	private boolean hasRegulation;
	private boolean isVisaProject;
	private boolean hasPermission;
	
	public Parcel(double area, EstateKind estateKind, Set<Extrable> extrables, String extraInfo, Place place,
			boolean hasRegulation, boolean isVisaProject, boolean hasPermission) {
		super(area, estateKind, extrables, extraInfo, place);
		this.setHasRegulation(hasRegulation);
		this.setVisaProject(isVisaProject);
		this.setHasPermission(hasPermission);
	}

	public boolean isHasRegulation() {
		return hasRegulation;
	}

	public void setHasRegulation(boolean hasRegulation) {
		this.hasRegulation = hasRegulation;
	}

	public boolean isVisaProject() {
		return isVisaProject;
	}

	public void setVisaProject(boolean isVisaProject) {
		this.isVisaProject = isVisaProject;
	}

	public boolean isHasPermission() {
		return hasPermission;
	}

	public void setHasPermission(boolean hasPermission) {
		this.hasPermission = hasPermission;
	}
	
	
	
	
}
