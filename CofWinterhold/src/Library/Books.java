package Library;

public class Books extends Publications {

	protected String author;
	protected String theme;

	public Books() {

	}

	public Books(int id, String title, String author, String theme, String ISBN) {
		super();
		this.author = author;
		this.theme = theme;
		this.title = title;
		this.ISBN = ISBN;
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public String getTheme() {
		return theme;
	}

}
