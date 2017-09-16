package homesbg.registration.pageData;

@SuppressWarnings("unused")
public class Page {
	private String name;

	public Page(String name){
		setName(name);
	}

	public void setName(String name) {
		if(name == null || name.trim().length() < 3){
			throw new IllegalArgumentException("����� ������ �� ������� ������� 3 �������.");
		}
		this.name = name;
	}
	
	
}
