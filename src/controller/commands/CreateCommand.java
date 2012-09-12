package controller.commands;

import model.AComputer;
import model.Canvas;

import org.eclipse.gef.commands.Command;

public class CreateCommand extends Command {
	
	Object _item;
	Canvas _canvas;
	
	public CreateCommand(Canvas canvas, Object item) {
		_item = item;
		_canvas = canvas;
	}
	
	@Override
	public void execute() {
		redo();
	}
	 
	@Override
	public void undo() {
		if( _item instanceof AComputer){
				_canvas.remove(_item);
		}
	}
	 
	@Override
	public void redo() {
		 
		 if( _item instanceof AComputer){
				_canvas.addChild(_item);
		}
	}

}
