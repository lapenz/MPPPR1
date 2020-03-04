package MPP.Project1.model;

import java.util.List;

public interface IModel<T> {
	void save();
	void update();
	void delete();
	List<T> findAll();
	List<String> validate(T obj);
	T find(int id);
}
