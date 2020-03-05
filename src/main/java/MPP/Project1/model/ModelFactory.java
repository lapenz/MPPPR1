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
		map.put("MPP.Project1.controller.MemberController", new Member());
		map.put("MPP.Project1.controller.LendController", new Lend());
		map.put("MPP.Project1.controller.BookController", new Book());
		map.put("MPP.Project1.controller.ProjectUserController", new ProjectUser());
		map.put("MPP.Project1.controller.CopyBookController", new CopyBook());
	}
	

}
