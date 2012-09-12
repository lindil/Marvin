package model.editpart;

import model.Server;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

public class ServerEditpart extends AbstractGraphicalEditPart{
	
	public ServerEditpart(Server model) {
		setModel(model);
	}

	@Override
	protected IFigure createFigure() {
		
		Figure fig = new RoundedRectangle();
		fig.setSize(80, 80);
		fig.setBackgroundColor(ColorConstants.cyan);
		return fig;
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
	}


}
