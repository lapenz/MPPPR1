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

	public void checkout(int memberId, int copyid) throws Exception {
		Member member = new Member().find(memberId);
		if(member == null) throw new Exception("Member not found.");
		
		CopyBook copybook = new CopyBook().find(copyid);
		if(copybook== null)
			throw new Exception("Book not found.");
		if(!copybook.isAvailability())
			throw new Exception("Book not available.");

		
		
		Lend lend = (Lend) create();
		lend.setBook(copybook);
		lend.setMember(member);
		lend.setLendDate(new Date());
		
		Calendar c = Calendar.getInstance();
        c.setTime(lend.getLendDate());
        c.add(Calendar.DATE, 21);
        
		lend.setDueDate(c.getTime());
		
		copybook.setAvailability(false);
		copybook.update();
		save(lend);
	}
	
	
	



}
