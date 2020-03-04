package MPP.Project1.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import MPP.Project1.model.IModel;

public interface IController<T> {
	void save(IModel<T> obj);
	IModel create() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
	List<T> findAll();
	T find(int id);
	void delete(IModel<T> obj);
}
