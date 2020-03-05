package MPP.Project1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member extends Model<Member> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int id;

	@Column
	private String first_name;
	@Column
	private String last_name;
	@Column
	private String street;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zip;
	@Column
	private String phone;
	

	public Member(String first_name, String last_name, String street, String city, String state, String zip,
			String phone) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}
	public Member() {
		
	}
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public List<String> validate() {
		// TODO Auto-generated method stub
		List<String> errorMessagesList = new ArrayList<String>();
		if(this.first_name.isEmpty()) {
			errorMessagesList.add("First name can't be blank");
		}
		if(this.last_name.isEmpty()) {
			errorMessagesList.add("Last name can't be blank");
		}
		
		return errorMessagesList;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone
				+ "]";
	}
	
	
	
	
}
