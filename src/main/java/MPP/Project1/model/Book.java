package MPP.Project1.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;	

@Entity
public class Book extends Model<Book> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
 	private int id;
	private String title;
	private String isbn;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinTable(name="book_author", 
    joinColumns = { @JoinColumn(name = "book_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "author_id")})
	private List<Author> authors = new ArrayList<Author>();
	
	@OneToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(nullable = false)
	private List<CopyBook> copyBooks = new ArrayList<CopyBook>();	
	
	public Book() {
		
	}

	public Book(int id, String title, String isbn, List<Author> authors, List<CopyBook> copyBooks) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
		this.copyBooks = copyBooks;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}	
	public List<CopyBook> getCopyBooks() {
		return copyBooks;
	}
	public void setCopyBooks(List<CopyBook> copyBooks) {
		this.copyBooks = copyBooks;
	}
	public void setOneAuthor(Author author) {
		author.setOneBook(this);
		authors.add(author);
	}
	public void setOneCopy() {
		copyBooks.add(new CopyBook(this));
	}
	
	public CopyBook getOneCopy() {
		for (CopyBook copyBook : getCopyBooks()) {
			if(copyBook.isAvailability())
				return copyBook;
		}
		
		return null;
	}
	@Override
	public List<String> validate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + "]";
	}
	
}
