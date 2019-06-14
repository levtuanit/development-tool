package com.mitrais.development.tool.utils;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipFileHandler {
	public static boolean checkIfZipFile(String path) throws IOException {
		File file = new File(path);
		if (file.isDirectory()) {
			return false;
		}
		if (!file.canRead()) {
			throw new IOException("Cannot read file " + file.getAbsolutePath());
		}
		if (file.length() < 4) {
			return false;
		}
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
		int test = in.readInt();
		in.close();
		return test == 0x504b0304;
	}

	public static boolean checkValid(String zipPath) throws IOException {
		if (!checkIfZipFile(zipPath)) {
			return false;
		}
		List<String> pathsInZip = readFromZipFile(zipPath);
		List<String> correctStructure = getCorrectStructure(zipPath);
		for (String item : correctStructure) {
			boolean isContained = checkItemContainZipPath(item, pathsInZip);
			if (!isContained)
				return false;
		}
		return true;
	}

	private static boolean checkItemContainZipPath(String path, List<String> pathsInZip) {
		for (String item : pathsInZip) {
			if (item.equals(path)) {
				return true;
			}
		}
		return false;
	}

	private static List<String> getCorrectStructure(String zipPath) {
		List<String> correctStructure = new ArrayList<String>();

		int lastSplashIndex = zipPath.lastIndexOf("\\");
		int lastDotIndex = zipPath.lastIndexOf(".");
		String fileName = zipPath.substring(lastSplashIndex + 1, lastDotIndex);
		correctStructure.add(fileName + "/");
		correctStructure.add(fileName + "/common/");
		correctStructure.add(fileName + "/common/backup/");
		correctStructure.add(fileName + "/common/install/");
		correctStructure.add(fileName + "/common/rollback/");
		correctStructure.add(fileName + "/production/");
		correctStructure.add(fileName + "/production/backup/");
		correctStructure.add(fileName + "/production/install/");
		correctStructure.add(fileName + "/production/rollback/");
		correctStructure.add(fileName + "/testing/");
		correctStructure.add(fileName + "/testing/backup/");
		correctStructure.add(fileName + "/testing/install/");
		correctStructure.add(fileName + "/testing/rollback/");
		return correctStructure;
	}

	private static List<String> readFromZipFile(String zipPath) throws IOException {
		List<String> pathsInZip = new ArrayList<String>();

		try (ZipFile file = new ZipFile(zipPath)) {
			final Enumeration<? extends ZipEntry> entries = file.entries();
			while (entries.hasMoreElements()) {
				final ZipEntry entry = entries.nextElement();
				pathsInZip.add(entry.getName());
			}
		}

		return pathsInZip;
	}
}
