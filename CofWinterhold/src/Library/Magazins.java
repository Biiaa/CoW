package Library;

public class Magazins extends Publications{
	
	protected String number;
	protected String theme;
	
	public Magazins() {
		
	}
	
	public Magazins(int id, String title, String number, String theme, String ISBN) {
		super();
		this.number = number;
		this.theme = theme;
		this.title = title;
		this.ISBN = ISBN;
		this.id = id;
	}


	public String getNumber() {
		return number;
	}


	public String getTheme() {
		return theme;
	}


	
	
}
