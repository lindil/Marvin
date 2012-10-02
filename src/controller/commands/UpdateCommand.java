package controller.commands;

import model.GraphicalModel;
import model.ModelConstant.ModelEvent;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

public class UpdateCommand extends Command {
	
	private GraphicalModel _model;
	private Object _value;
	private Object _oldValue;
	private ModelEvent _event;

	public UpdateCommand(GraphicalModel model, Object value, ModelEvent event) {
		_model = model;
		_value = value;
		_event = event;
	}
	
	@Override
	public void execute() {
		
		switch (_event) {
		
		case MOVE:
			_oldValue = _model.getLocation();
			Point location = (Point) _value;
			_model.setLocation(location);
			break;
			
		case RESIZE:
			_oldValue = _model.getBound();
			Rectangle bound = (Rectangle) _value;
			_model.setBound(bound);
			break;

		default:
			break;
		}
		
	}
	
	@Override
	public void undo() {
		switch (_event) {
		
		case MOVE:
			_model.setLocation((Point)_oldValue);
			break;
		case RESIZE:
			_model.setBound((Rectangle)_oldValue);
			break;

		default:
			break;
		}
	}
	

}
