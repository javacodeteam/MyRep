package com.lok.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lok.service.DownloadService;
@Controller
public class ContentDownload {
	private static final String DOWNLOAD_FOLDER = "D:/srj bhai";
	@Autowired
	private DownloadService service;
	public ContentDownload() {
		System.out.println("Controller:0 param");
	}
	
	@RequestMapping("home.do")
	public String home(){
		return "home";	
	}
	
	//for show All Files for download
	@RequestMapping(value="download.do")
	public String showFils(Map<String,Object> map){
		System.out.println("Showfiles(--)");
		//use service
		List<String> list=service.getAllFiles();
		System.out.println(list);
		//keep list in model attribute
		map.put("files", list);
		return "downloadd";	
	}
	
	//For download purpose
	@RequestMapping(value="downloadd.do")
	public   String  download(@RequestParam("fname")String fname,
			                  HttpServletRequest req,
			                  HttpServletResponse res)throws Exception{
		System.out.println("filename::"+fname);
		 File file=null;
		 InputStream is=null;
		 OutputStream os=null;
		 try{
		 //make browser to make recived content as downloadable file
		 res.addHeader("Content-Disposition","attachment;fileName="+fname);
		//Locate file
		 file=new File(DOWNLOAD_FOLDER+"/"+fname);
		 //get File MIME type and set it as response content type
		 res.setContentType(req.getServletContext().getMimeType(file.getAbsolutePath()));
		 //take file length as response content legnth
		 res.setContentLength((int)file.length());
		 //create InputStream pointing to the file to be downloaded
		 is=new FileInputStream(file);
		 //create OuputStream pointing to the response objs
		 os=res.getOutputStream();
		 //wrtie File content to response obj
		 IOUtils.copy(is,os);
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 finally {
			try{
				//flush the response
				 res.flushBuffer();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			try{
				is.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			os.close();
		}
		return null;
	}//method

}
