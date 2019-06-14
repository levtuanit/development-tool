package com.mitrais.development.tool.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FolderHandler {

	private static final String BACKWARD_SPLASH = "\\";

	public String createFolder(String parentFolderPath, String name) {
		File file = new File(parentFolderPath + BACKWARD_SPLASH + name);
		if (!file.exists()) {
			if (file.mkdir()) {
				return file.getPath();
			}
		}
		return null;
	}

	public void copyDirectory(String source, String destination) throws IOException {
		File sourceFile = new File(source);
		File destinationFile = new File(destination);
		FileUtils.copyDirectory(sourceFile, destinationFile);
	}
}
