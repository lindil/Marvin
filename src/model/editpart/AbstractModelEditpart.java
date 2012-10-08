package model.editpart;

import model.ModelConstant.ModelEvent;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

public abstract class AbstractModelEditpart extends AbstractGraphicalEditPart {

	@Override
	protected abstract IFigure createFigure();

	@Override
	protected abstract void createEditPolicies();
	
	
	public abstract void fireEvent(ModelEvent event);

}
 