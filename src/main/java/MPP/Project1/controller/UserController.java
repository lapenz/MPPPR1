package MPP.Project1.controller;

import MPP.Project1.model.User;

public class UserController extends Controller<User>{

	public String login(String login, String password) {
		User user = new User().findFirst("login", login);
		if(user == null)
			return null;
		
		if(user.getPassword().equals(password))
			return user.getType();
		
		return null;
	}
	

}
