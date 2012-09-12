package controller;

import marvin.Activator;
import marvin.MarvinConstante;
import model.Server;
import model.Switch;
import model.Workstation;

import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.jface.resource.ImageDescriptor;

public class PaletteFactory {

	public static PaletteRoot createPalette() {
		PaletteRoot pr = new PaletteRoot();
		pr.add(createDrawer());
		return pr;
	}

	private static PaletteEntry createDrawer() {
		PaletteDrawer componentsDrawer = new PaletteDrawer("");

		// Workstation part
		SimpleFactory workstation = new SimpleFactory(Workstation.class) {

			@Override
			public Object getNewObject() {
				Workstation ws = new Workstation();
				ws.setIp("127.0.0.1");
				ws.setName("New Workstation");
				ws.setUsername("User 1");
				return ws;
			}

		};

		CombinedTemplateCreationEntry component = new CombinedTemplateCreationEntry(
				"Workstation", "Add a new Workstatoin", workstation,
				ImageDescriptor.createFromImage(Activator.getDefault()
						.getImageRegistry()
						.get(MarvinConstante.IMAGE_BLUE_BALL)), null);
		componentsDrawer.add(component);

		
		// Server part
		SimpleFactory server = new SimpleFactory(Server.class) {

			@Override
			public Object getNewObject() {
				Server serv = new Server();
				serv.setIp("127.0.0.1");
				serv.setName("New Server");
				return serv;
			}

		};

		component = new CombinedTemplateCreationEntry("Server",
				"Add a new Server", server,
				ImageDescriptor.createFromImage(Activator.getDefault()
						.getImageRegistry()
						.get(MarvinConstante.IMAGE_GREEN_BALL)), null);
		componentsDrawer.add(component);

		
	
		// Switch part.
		SimpleFactory switchDeamon = new SimpleFactory(Server.class) {

			@Override
			public Object getNewObject() {
				Switch switchModel = new Switch();
				switchModel.setServiceIp("127.0.0.1");
				return switchModel;
			}

		};

		component = new CombinedTemplateCreationEntry("Switch",
				"Add a new Switch", switchDeamon,
				ImageDescriptor.createFromImage(Activator.getDefault()
						.getImageRegistry()
						.get(MarvinConstante.IMAGE_YELLOW_BALL)), null);
		componentsDrawer.add(component);
		
		return componentsDrawer;
	}

}
