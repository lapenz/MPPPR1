package MPP.Project1.controller;

import java.util.List;

import MPP.Project1.model.IModel;

public interface IController<T> {
	List<String> save(IModel<T> obj);
	List<String> update(IModel<T> obj);
	IModel create();
	List<T> findAll();
	T find(int id);
	T findFirst(String column, String value);
	void delete(IModel<T> obj);
}
