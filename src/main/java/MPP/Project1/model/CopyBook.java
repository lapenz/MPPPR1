package MPP.Project1.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CopyBook extends Model<CopyBook> {
	
	@Id @GeneratedValue
    private int id;
	private int number;
	private boolean availability;
	
	@ManyToOne
    private Book book;
	
	public CopyBook() {
		availability =true;
	}
	
	public CopyBook( Book book) {
		this.book = book;
		availability =true;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public List<String> validate() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
