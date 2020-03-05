package MPP.Project1;

import MPP.Project1.model.ProjectUser;


/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {

//       List<Author> authors = new ArrayList<Author>();
//       Author author = new Author();
//       author.setFirst_name("Author 2");
//    
//       authors.add(author);
//       
//       
//       
//       Book book = new Book();
//       book.setIsbn("63636363636363666");
//       book.setTitle("Livro podre");
//       
//       book.setAuthors(authors);
//       
//       CopyBook copyBook = new CopyBook(book);
//       copyBook.setAvailability(true);
//       copyBook.setNumber(333333333);
//       List<CopyBook> copys = new ArrayList<CopyBook>();
//       
//       copys.add(copyBook);
//       
//       book.setCopyBooks(copys);
//
//
//       
//       book.save();
    	
    	
//    	Book bk = new BookController().findFirst("isbn", "63636363636363666");
    	
    	ProjectUser us = new ProjectUser();
    	us.setLogin("sdf");
    	us.setPassword("sdf");
    	us.setType("sdfd");
    	
    	us.save();
//    	List<CopyBook> lst = bk.getCopyBooks();
//    	
//		System.out.println(bk.getAuthors());
    	
//
//		System.out.println(lst.get(0));
    	
//		System.out.println(books.toString());
	
    }
    
    
}
