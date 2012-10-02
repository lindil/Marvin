package model;

import model.ModelConstant.ModelEvent;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class GraphicalModel extends ModelEventListender {

	private Rectangle _layout = new Rectangle();

	public void setLocation(Point layout) {
		_layout.setLocation(layout);
		fireEvent(ModelEvent.MOVE);
	}

	public void setSize(Dimension size) {
		_layout.setSize(size);
		
	}

	public Point getLocation() {
		return _layout.getLocation();
	}

	public Dimension getSize() {
		return _layout.getSize();
	}

	public Rectangle getBound() {
		return _layout;
	}

	public void setBound(Rectangle bound) {
		_layout = bound;
		fireEvent(ModelEvent.RESIZE);
	}
}
