package com.fjsf.web.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpLoad {
	
	private static FileUpLoad instance = null;

	public static FileUpLoad getInstance() {
		if (instance == null) {
			instance = new FileUpLoad();
		}
		return instance;
	}
	//需要绝对路径
	public String upLoadServer(String srcFile) throws IOException{
		String destFile = new String();
		try {
			FileInputStream fin = new FileInputStream(srcFile);
			String afterName = new String();
			Random random = new Random();
			random.nextInt();
			for(int i = 0;i < 20; i++){
				afterName +=  (char)(random.nextInt(26)+97)+"";
			}
			destFile = "C:\\commercialcity\\" + afterName
					+ srcFile.substring(srcFile.lastIndexOf("."));
			FileOutputStream fout = new FileOutputStream(destFile);
			byte [] buffer = new byte[1024];
			int len = 0;
			while((len = fin.read(buffer)) != -1){
				fout.write(buffer, 0, len);
			}
			fout.close();
			fin.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件路径错误");
		}
		return destFile;
	}
	
	public ServletFileUpload getFileUpLoad(){
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 500);
		File tempDirectory = new File("D:\\tempDirectory");
		factory.setRepository(tempDirectory);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(1024 * 1024 * 5);
		return upload;
	}
	
	public void upLoad(HttpServletRequest request) throws ServletException, IOException{
		ServletFileUpload upload = getFileUpLoad();
		try {
			List<FileItem> items = upload.parseRequest(request);
			
			for(FileItem item:items){
				if(item.isFormField()){
					//一般的 表单
					String name = item.getFieldName();
					String value = item.getString();
					System.out.println(name+ ":" + value);
				}else{
					//文件域
					
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					String contentType = item.getContentType();
					long sizeInBytes = item.getSize();
					System.out.println(fieldName);
					System.out.println(fileName);
					System.out.println(contentType);
					System.out.println(sizeInBytes);
					
					InputStream inputStream = item.getInputStream();
					byte [] buffer = new byte[1024];
					int len = 0;
					String newFileName = "";
					Random random = new Random();
					random.nextInt();
					for(int i = 0;i < 20; i++){
						newFileName +=  (char)(random.nextInt(26)+97)+"";
					}
					newFileName += fileName.substring(fileName.lastIndexOf("."));
					fileName = "C:\\commercialcity\\"+newFileName;
					System.out.println(fileName);
					OutputStream outputStream = new FileOutputStream(fileName);
					while((len = inputStream.read(buffer)) != -1){
						outputStream.write(buffer, 0, len);
					}
					outputStream.close();
					inputStream.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
