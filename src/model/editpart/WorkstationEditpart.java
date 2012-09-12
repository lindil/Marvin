package model.editpart;

import model.ModelConstant.ModelEvent;
import model.Workstation;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;

public class WorkstationEditpart extends AbstractModelEditpart {

	private Workstation _model;
	
	public WorkstationEditpart(Workstation model) {
		setModel(model);
		_model = model;
		_model.addListener(this);
	}

	@Override
	public void deactivate() {
		((Workstation) getModel()).removeListener(this);
	}

	@Override
	protected IFigure createFigure() {
		Figure fig = new RoundedRectangle();
		fig.setSize(120, 120);
		fig.setLocation(_model.getLocation());
		fig.setBackgroundColor(ColorConstants.orange);
		return fig;
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void refreshVisuals() {
		getFigure().setSize(_model.getSize());
		getFigure().setLocation(_model.getLocation());
		getFigure().repaint();
	}
	
	@Override
	public void fireEvent(ModelEvent event) {
		switch (event) {
		case RESIZE:
			refreshVisuals();
			break;

		default:
			break;
		}

	}

}
