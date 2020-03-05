package MPP.Project1.controller;

import java.util.Calendar;
import java.util.Date;

import MPP.Project1.model.Book;
import MPP.Project1.model.CopyBook;
import MPP.Project1.model.Lend;
import MPP.Project1.model.Member;

public class LendController extends Controller<Lend> {


	public LendController() {
		// TODO Auto-generated constructor stub
	}

	public void checkout(int memberId, String isbn) throws Exception {
		Member member = new Member().find(memberId);
		if(member == null) throw new Exception("Member not found.");
		
		Book book = new Book().findFirst("isbn", isbn);
		CopyBook copyBook = book.getOneCopy();
		
		if(copyBook == null) throw new Exception("Book not found or not available.");

		
		Lend lend = (Lend) create();
		lend.setBook(copyBook);
		lend.setMember(member);
		lend.setLendDate(new Date());
		
		Calendar c = Calendar.getInstance();
        c.setTime(lend.getLendDate());
        c.add(Calendar.DATE, 21);
        
		lend.setDueDate(c.getTime());
		
		copyBook.setAvailability(false);
		copyBook.save();
		
		save(lend);
	}
	
	
	



}
