package com.mitrais.development.tool.model;

public class Configuration {
	
	private String environment;
	private String backupPath;
	private String tomcatPath;
	private String hostname;
	private String port;
	private String username;
	private String password;
	private String schema;
	
	public Configuration() {
		
	}

	public Configuration(String environment, String backupPath, String tomcatPath, String hostname, String port,
			String username, String password, String schema) {
		super();
		this.environment = environment;
		this.backupPath = backupPath;
		this.tomcatPath = tomcatPath;
		this.hostname = hostname;
		this.port = port;
		this.username = username;
		this.password = password;
		this.schema = schema;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getBackupPath() {
		return backupPath;
	}

	public void setBackupPath(String backupPath) {
		this.backupPath = backupPath;
	}

	public String getTomcatPath() {
		return tomcatPath;
	}

	public void setTomcatPath(String tomcatPath) {
		this.tomcatPath = tomcatPath;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}
	
}
