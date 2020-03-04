package MPP.Project1.model;

import java.io.Serializable;
import java.util.List;

public class User extends Model<User> implements Serializable {
	

	private String login;
	private String password;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public List<String> validate(User obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
