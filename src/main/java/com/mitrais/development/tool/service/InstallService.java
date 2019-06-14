package com.mitrais.development.tool.service;

public interface InstallService {
	public boolean checkValidFile(String zipPath);

	public boolean install(String filePath);

}
