package Library;

public class Encyclopedias extends Publications{
	
	protected String author;
	
	public Encyclopedias() {
		
	}
	public Encyclopedias(int id, String author, String title, String ISBN) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.ISBN = ISBN;
	}

	public String getAuthor() {
		return author;
	}

	

}
