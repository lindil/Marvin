package model;

import java.util.ArrayList;
import java.util.List;

public class Server extends AComputer {
	private List<String> _services;

	public List<String> getServices() {
		if(_services == null)
			_services = new ArrayList<String>();
		return _services;
	}

	public void addService(String services) {
		getServices().add(services);
	}
	
	public void removeService(String service){
		getServices().remove(service);
	}
}
 