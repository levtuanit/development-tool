package com.mitrais.development.tool.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class ServiceImpl implements Service {

	public static final String EXTRA_SUCCESS = "Extra Successfully";
	public static final String EXTRA_FALSE = "Extra false";

//	public static final String READ_FILE_FALSE = "Extra false";
	public static final String FALSE = "FALSE";
	public static final String TRUE = "TRUE";

	@Override
	public String unzip(String zipFilePath, String destDir) {

		try {
			ZipFile zipFile = new ZipFile(zipFilePath);
//	         if (zipFile.isEncrypted()) {
//	         }
			zipFile.extractAll(destDir);
			return EXTRA_SUCCESS;
		} catch (ZipException e) {
			e.printStackTrace();
			return EXTRA_FALSE;
		}
	}

	@Override
	public String copyFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readFile(String filePath) {
		List<String> list = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
			list = stream.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
			return FALSE;
		}

		list.forEach(System.out::println);
		return TRUE;
	}

}
