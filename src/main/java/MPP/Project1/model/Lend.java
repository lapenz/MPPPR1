package MPP.Project1.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lend extends Model<Lend> {
	private Member member;
	private CopyBook book;
	private Date lendDate;
	private Date dueDate;
	private Date returnDate;
	private BigDecimal fine;
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public CopyBook getBook() {
		return book;
	}
	public void setBook(CopyBook book) {
		this.book = book;
	}
	public Date getLendDate() {
		return lendDate;
	}
	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public BigDecimal getFine() {
		return fine;
	}
	public void setFine(BigDecimal fine) {
		this.fine = fine;
	}
	@Override
	public List<String> validate() {
		List<String> errorMessagesList = new ArrayList<String>();
		// TODO Auto-generated method stub
		if(this.member == null) errorMessagesList.add("Member is empty");
		if(this.book == null) errorMessagesList.add("book is empty");
		return errorMessagesList;
	}

	
	

}
