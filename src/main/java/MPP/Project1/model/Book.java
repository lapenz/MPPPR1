package MPP.Project1.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
	@OneToMany( cascade = {CascadeType.ALL})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Author> authors = new ArrayList<Author>();
	
	@OneToMany(cascade = {CascadeType.ALL})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<CopyBook> copyBooks = new ArrayList<CopyBook>();	
	
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
	
	
	public Book findByIsbn(String isbn) {
		return null;
	}
	
	public CopyBook getOneCopy() {
		for (CopyBook copyBook : getCopyBooks()) {
			if(copyBook.isAvailability())
				return copyBook;
		}
		
		return null;
	}
	@Override
	public List<String> validate(Book obj) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", authors=" + authors + ", copyBooks="
				+ copyBooks + "]";
	}
	
}
