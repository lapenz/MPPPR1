package MPP.Project1.controller;

import java.util.List;

import MPP.Project1.model.IModel;
import MPP.Project1.model.ModelFactory;


public abstract class Controller<T> implements IController<T> {
		
	public Controller() {
		
	} 
	
	
	public IModel create() {
		return ModelFactory.getModel(this.getClass().getName());
    }
	
	public void save(IModel<T> obj) {
//		obj.save();
	};
	
	public void delete(IModel<T> obj) {
		obj.delete();
	};

	public List<T> findAll() {
		return null;
	}

	public T find(int id) {
		// to do
		return null;
	}

}
