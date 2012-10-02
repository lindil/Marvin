package policy;

import model.Canvas;
import model.GraphicalModel;
import model.ModelConstant.ModelEvent;
import model.Server;
import model.Workstation;
import model.editpart.AbstractModelEditpart;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import controller.commands.CreateCommand;
import controller.commands.UpdateCommand;

public class CanvasPolicy extends XYLayoutEditPolicy {

	private Canvas _canvas;

	public CanvasPolicy(Canvas canvas) {
		_canvas = canvas;
	}

	@Override
	protected Command getCreateCommand(CreateRequest arg0) {
		Object type = arg0.getNewObjectType();
		Rectangle layout = (Rectangle) getConstraintFor(arg0);

		if (type == Workstation.class) {

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

	@Override
	protected Command createChangeConstraintCommand(
			ChangeBoundsRequest request, EditPart child, Object constraint) {

		if (child instanceof AbstractModelEditpart) {
			GraphicalModel model = (GraphicalModel) child.getModel();
			Rectangle bound = (Rectangle) constraint;
			Rectangle oldBound = model.getBound();

			if(!oldBound.getSize().equals(bound.getSize())){
				return new UpdateCommand(model, bound, ModelEvent.RESIZE);
			}
			
			else if (!oldBound.getLocation().equals(bound.getLocation())) {
				return new UpdateCommand(model, bound.getLocation(), ModelEvent.MOVE);
			}
		}

		return super.createChangeConstraintCommand(request, child, constraint);
	}
}
