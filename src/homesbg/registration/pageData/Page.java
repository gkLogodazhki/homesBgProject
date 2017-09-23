package homesbg.registration.pageData;

public class Page {
	private String name;

	public Page(String name){
		setName(name);
	}

	public void setName(String name) {
		if(name == null || name.trim().length() < 3){
			throw new IllegalArgumentException("Invalid page name");
		}
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
