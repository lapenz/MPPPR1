package MPP.Project1;

import java.util.List;

import MPP.Project1.model.Book;


/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {

       
       
       
//       mb.findAll();
//       List<Author> authors = new ArrayList<Author>();
//       Author author = new Author();
//       author.setFirst_name("Author gay");
//    
////       author.save();
//       authors.add(author);
//       book.setAuthors(authors);
//       book.setIsbn("s23423423423");
//       
//       CopyBook copyBook = new CopyBook();
//       copyBook.setAvailability(true);
//       copyBook.setNumber(23423);
////       copyBook.save();
//       List<CopyBook> copys = new ArrayList<CopyBook>();
//       
//       copys.add(copyBook);
//       book.setCopyBooks(copys);
//       
//       
//       book.save();
//		System.out.println("Testtttt");
    	Book books = new Book().find(29);
    	books.setTitle("New title");
    	books.delete();
//		System.out.println(books.toString());
	
    }
    
    
}
