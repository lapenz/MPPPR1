package MPP.Project1.model;

import java.util.HashMap;
public class ModelFactory {
	
	
	private static HashMap<String, IModel> map = new HashMap<>();
	
	
	public static IModel getModel(String classname) {
		setMap();
		if(map.containsKey(classname))
			return map.get(classname);
		return null;
	}
	
	private static void setMap() {
		map.put("controller.MemberController", new Member());
		map.put("controller.LendController", new Lend());
		map.put("controller.BookController", new Book());
		map.put("controller.UserController", new User());
	}
	

}
