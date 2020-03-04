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
	
	@Override
	public List<String> save(IModel<T> obj) {
		List<String> errors = obj.validate();
		if(errors.isEmpty()) {
			obj.save();
			return null;
		} else {
			return errors;
		}
		
	}
	
	@Override
	public List<String> update(IModel<T> obj) {
		List<String> errors = obj.validate();
		if(errors.isEmpty()) {
			obj.update();
			return null;
		} else {
			return errors;
		}
		
	}
	
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
