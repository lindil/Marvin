package model.editpart;

import model.Switch;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

public class SwitchEditpart extends AbstractGraphicalEditPart{
	
	public SwitchEditpart(Switch model) {
		setModel(model);
	}

	@Override
	protected IFigure createFigure() {
		Figure fig = new RoundedRectangle();
		fig.setSize( 200, 50);
		fig.setBackgroundColor(ColorConstants.lightBlue);
		return fig;
	} 

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
		
	}

}
