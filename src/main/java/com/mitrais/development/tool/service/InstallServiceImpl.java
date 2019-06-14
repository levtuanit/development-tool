package com.mitrais.development.tool.service;

import java.io.IOException;

import com.mitrais.development.tool.utils.ZipFileHandler;

public class InstallServiceImpl implements InstallService {

	@Override
	public boolean checkValidFile(String zipPath) {
		try {
			return ZipFileHandler.checkValid(zipPath);
		} catch (IOException e) {
			return false;
		}
	}

	@Override
	public boolean install(String filePath) {
		// TODO
		
		return false;
	}

}
