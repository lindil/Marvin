package model.editpart;

import java.util.List;

import model.Canvas;
import model.ModelConstant.ModelEvent;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;

import policy.CanvasPolicy;

public class CanvasEditpart extends AbstractModelEditpart {
	
	public CanvasEditpart(Canvas model) {
		setModel(model);
		model.addListener(this);
	}

	@Override
	protected IFigure createFigure() {
		FreeformLayer ffl = new FreeformLayer();
		ffl.setLayoutManager(new FreeformLayout());
		return ffl;
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new CanvasPolicy((Canvas) getModel()));
	}

	@Override
	protected List getModelChildren() {
		return ((Canvas) getModel()).getChildren();
	}

	
	@Override
	protected void refreshVisuals() {
	}
	
	@Override
	public void fireEvent(ModelEvent event) {

		switch (event) {
		case ADD_COMPUTER:
			refreshChildren();
			refreshVisuals();
			break;
			
		case MOVE:
			refreshVisuals();
			break;
		
		default:
			break;
		}
	}
	
	
	
}
