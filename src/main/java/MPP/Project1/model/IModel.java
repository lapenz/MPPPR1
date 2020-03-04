package MPP.Project1.model;

import java.util.List;

public interface IModel<T> {
	void save();
	void update();
	void delete();
	List<T> findAll();
	List<String> validate();
	T find(int id);
	T findFirst(String column, String value);

}
