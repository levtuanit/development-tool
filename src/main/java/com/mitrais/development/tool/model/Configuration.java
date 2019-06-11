package com.mitrais.development.tool.model;

public class Configuration {
	private String tomcatLocation;

	
	
	@Override
	public String toString() {
		return this.tomcatLocation;
	}
	
	

	public Configuration(String tomcatLocation) {
		super();
		this.tomcatLocation = tomcatLocation;
	}



	public String getTomcatLocation() {
		return tomcatLocation;
	}

	public void setTomcatLocation(String tomcatLocation) {
		this.tomcatLocation = tomcatLocation;
	}
	
}
