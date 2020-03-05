package MPP.Project1.controller;

import MPP.Project1.model.ProjectUser;

public class ProjectUserController extends Controller<ProjectUser>{

	public String login(String login, String password) {
		ProjectUser user = new ProjectUser().findFirst("login", login);
		if(user == null)
			return null;
		
		if(user.getPassword().equals(password))
			return user.getType();
		
		return null;
	}
	

}
