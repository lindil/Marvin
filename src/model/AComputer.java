package model;

public abstract class AComputer extends GraphicalModel{
	
	private String _name;
	private String _ip;
	
	public String getName() {
		return _name;
	}
	 
	public void setName(String name) {
		_name = name;
	}
	
	public String getIp() {
		return _ip;
	}
	
	public void setIp(String ip) {
		_ip = ip;
	}

}
