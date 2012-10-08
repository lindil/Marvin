package model;

import java.util.ArrayList;
import java.util.List;

import model.ModelConstant.ModelEvent;

public class Canvas extends ModelEventListender{
	
	private List<Object> _children;
	
	public Canvas() {
		_children = new ArrayList<Object>();
	}
	
	public List<Object> getChildren(){
		return _children;
	}
 
	public void addChild(Object child){
		_children.add(child);
		fireEvent(ModelEvent.ADD_COMPUTER);
	}
	
	public void remove(Object child){
		_children.remove(child);
	}
}
