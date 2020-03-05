package MPP.Project1.controller;

import java.util.ArrayList;
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
		List<String> errors= new ArrayList<String>();
		//errors.addAll(obj.validate());
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
	
	@Override
	public void delete(IModel<T> obj) {
		obj.delete();
	};

	@Override
	public List<T> findAll() {
		IModel model = ModelFactory.getModel(this.getClass().getName());
		return model.findAll();
	}

	@Override
	public T find(int id) {
		System.out.println(this.getClass().getName());
		IModel model = ModelFactory.getModel(this.getClass().getName());
		return (T) model.find(id);
	}
	
	@Override
	public T findFirst(String column, String value) {
		IModel model = ModelFactory.getModel(this.getClass().getName());
		return (T) model.findFirst(column, value);

	}

}
