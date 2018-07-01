package com.lok.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DownloadserviceImpl implements DownloadService {

	private static final String DOWNLOAD_FOLDER = "D:/srj bhai";

	@Override
	public List<String> getAllFiles() {
		File folder = null;
		File files[] = null;
		List<String> list = null;
		folder = new File(DOWNLOAD_FOLDER);
		if (folder.isDirectory()) {
			files = folder.listFiles();
		}
		list = new ArrayList<>();
		for (File fname : files) {
			if (!fname.isDirectory()) {
				list.add(fname.getName());
			}
			System.out.println("service:"+list);
		}
		return list;
	}

}
