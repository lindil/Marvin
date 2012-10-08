package marvin;

import model.Canvas;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;

import controller.ModelFactory;
import controller.PaletteFactory;

public class MarvinEditor extends GraphicalEditorWithFlyoutPalette {
	
	public MarvinEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}
	 
	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new ModelFactory());
		viewer.setContents(new Canvas());
		viewer.addDropTargetListener(new TemplateTransferDropTargetListener(viewer));
		
	}
	
	
	/**
	 * Create a Drag and Drop ability for the palette.
	 */
	@Override
	protected PaletteViewerProvider createPaletteViewerProvider() {
		return new PaletteViewerProvider(getEditDomain()) {
			@Override
			protected void configurePaletteViewer(PaletteViewer viewer) {
				super.configurePaletteViewer(viewer);
				viewer.addDragSourceListener(new TemplateTransferDragSourceListener(viewer));
			}
		};
	}

	@Override
	protected PaletteRoot getPaletteRoot() {
		return PaletteFactory.createPalette();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}
	
}
