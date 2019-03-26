package com.fjsf.web.servlet;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FileUpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("fileUpLoad");
		FilterChain chain = (FilterChain) request.getSession().getAttribute("chain");
		ServletRequest req = (ServletRequest) request.getSession().getAttribute("req");
		ServletResponse res = (ServletResponse) request.getSession().getAttribute("res");
		/*
		System.out.println("out2");
		response.getWriter().print("success");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 500);
		File tempDirectory = new File("D:\\tempDirectory");
		factory.setRepository(tempDirectory);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(1024 * 1024 * 5);
		try {
			List<FileItem> items = upload.parseRequest(request);

			for (FileItem item : items) {
				if (item.isFormField()) {
					// 一般的 表单
					String name = item.getFieldName();
					String value = item.getString();
					System.out.println(name + ":" + value);
				} else {
					// 文件域

					String fieldName = item.getFieldName();
					String fileName = item.getName();
					String contentType = item.getContentType();
					long sizeInBytes = item.getSize();
					System.out.println(fieldName);
					System.out.println(fileName);
					System.out.println(contentType);
					System.out.println(sizeInBytes);
					InputStream inputStream = item.getInputStream();
					byte[] buffer = new byte[1024];
					int len = 0;

					String newFileName = "";
					Random random = new Random();
					random.nextInt();
					for (int i = 0; i < 20; i++) {
						newFileName += (char) (random.nextInt(26) + 97) + "";
					}
					newFileName += fileName.substring(fileName.lastIndexOf("."));

					// fileName = "D:\\commercialcity\\"+fileName;
					fileName = "D:\\commercialcity\\" + newFileName;
					System.out.println(fileName);
					OutputStream outputStream = new FileOutputStream(fileName);

					while ((len = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, len);
					}
					outputStream.close();
					inputStream.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}

}
