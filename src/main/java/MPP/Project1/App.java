package MPP.Project1;

import MPP.Project1.view.Login;


public class App 
{
	
    public static void main( String[] args )
    {

		try {
			Login window = new Login();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
    }
    
    
}
