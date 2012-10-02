package model.editpart;

import model.ModelConstant.ModelEvent;
import model.Server;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;

public class ServerEditpart extends AbstractModelEditpart{
	
	private Figure _figure;
	private  Server _model;
	
	public ServerEditpart(Server model) {
		setModel(model);
		_model = model;
	}

	@Override
	protected IFigure createFigure() {
		
		_figure = new RoundedRectangle();
		_figure.setSize(80, 80);
		_figure.setBackgroundColor(ColorConstants.cyan);
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
