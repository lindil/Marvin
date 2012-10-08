package controller;

import model.Canvas; 
import model.Server;
import model.Switch;
import model.Workstation;
import model.editpart.CanvasEditpart;
import model.editpart.ServerEditpart;
import model.editpart.SwitchEditpart;
import model.editpart.WorkstationEditpart;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

public class ModelFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart arg0, Object model) {
		
		if (model instanceof Canvas){
			
			return new CanvasEditpart((Canvas) model);
			
		} else if (model instanceof Server){
			
			return new ServerEditpart((Server) model);
			
		} else if (model instanceof Workstation){
			
			return new WorkstationEditpart((Workstation) model);
			
		} else if (model instanceof Switch){
			
			return new SwitchEditpart((Switch) model);
		
		}
		
		return null;
	}

}
