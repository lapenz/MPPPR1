package MPP.Project1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Author extends Model<Author> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id @GeneratedValue
    private int id;
	private String first_name;
	private String last_name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String credentials;
	private String bio;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="book_author", 
	        joinColumns = { @JoinColumn(name = "author_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "book_id")})
	private List<Book> books = new ArrayList<Book>();
	
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCredentials() {
		return credentials;
	}
	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	@Override
	public List<String> validate(Author obj) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}



	
	
}
