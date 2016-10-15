//Arham Sikder ans2ur, Homework 0
public class Book {

	private final String title;
	private final String author;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public boolean equals(Object o) {
		if (o instanceof Book) {
			Book b = (Book) o; // cast o to be the type book
			// compare to the actual fields
			return (this.title == b.title && this.author == b.author);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Book [title= " + title + ", author= " + author + "]";
	}

	public static void main(String[] args) {
		Book b = new Book("a", "b");
		Book x = new Book("b", "a");
		Book y = new Book("a", "b");
		System.out.println(b.toString());
		System.out.println(b.equals(x)); // should say false
		System.out.println(b.equals(y)); // should say true

	}

}
