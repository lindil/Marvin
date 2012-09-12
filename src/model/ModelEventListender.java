package model;

import java.util.ArrayList;
import java.util.List;

import model.ModelConstant.ModelEvent;
import model.editpart.AbstractModelEditpart;

public class ModelEventListender {
	
	private List<AbstractModelEditpart> _eventListeners = new ArrayList<AbstractModelEditpart>();
	
	public void addListener(AbstractModelEditpart listener){
		_eventListeners.add(listener);
	}
	
	public void removeListener(AbstractModelEditpart listener){
		_eventListeners.remove(listener);
	}
	
	public void fireEvent(ModelEvent event){
		for(AbstractModelEditpart editpart: _eventListeners){
			editpart.fireEvent(event);
		}
	}

}
