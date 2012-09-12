package policy;

import model.Canvas;
import model.Server;
import model.Workstation;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import controller.commands.CreateCommand;

public class CanvasPolicy extends XYLayoutEditPolicy {

	private Canvas _canvas;

	public CanvasPolicy(Canvas canvas) {
		_canvas = canvas;
	}

	@Override
	protected Command getCreateCommand(CreateRequest arg0) {
		Object type = arg0.getNewObjectType();
		Rectangle layout = (Rectangle) getConstraintFor(arg0);

		if (type ==  Workstation.class) {
			
			Workstation workstation = (Workstation) arg0.getNewObject();
			workstation.setLocation(layout.getLocation());
			return new CreateCommand(_canvas, workstation);
			
		} else if (type == Server.class) {
			
			Server server = (Server) arg0.getNewObject();
			server.setLocation(layout.getLocation());
			return new CreateCommand(_canvas, server);
		
		} 

		return null;
	}

}
