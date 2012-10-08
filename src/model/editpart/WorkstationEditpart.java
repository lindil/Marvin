package model.editpart;

import model.ModelConstant.ModelEvent;
import model.Workstation;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

public class WorkstationEditpart extends AbstractModelEditpart {

	private Workstation _model;
	private IFigure _figure;
	
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
		_figure = new RoundedRectangle();
		_figure.setMinimumSize(new Dimension(120, 120));
		_figure.setSize(120, 120);
		_figure.setLocation(_model.getLocation());
		_figure.setBackgroundColor(new Color(null, new RGB(92, 172, 238)));
		_figure.setOpaque(true);
		return _figure;
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void refreshVisuals() {
		_figure.setLocation(_model.getLocation());
		_figure.setSize(_model.getSize());
	}
	
	@Override
	public void fireEvent(ModelEvent event) {
		switch (event) {
		
		case MOVE:
		case RESIZE:
			refreshVisuals();
			break;

		default:
			break;
		}

	}

}
