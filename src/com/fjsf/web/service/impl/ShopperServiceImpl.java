package com.fjsf.web.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fjsf.web.bean.ShopBean;
import com.fjsf.web.bean.ShopperBean;
import com.fjsf.web.dao.CreditCardDAO;
import com.fjsf.web.dao.ShopDAO;
import com.fjsf.web.dao.ShopperDAO;
import com.fjsf.web.dao.impl.CreditCardDAOImpl;
import com.fjsf.web.dao.impl.ShopDAOImpl;
import com.fjsf.web.dao.impl.ShopperDAOImpl;
import com.fjsf.web.service.inter.ShopperServiceInterface;
import com.fjsf.web.utils.FileUpLoad;
import com.fjsf.web.utils.MyEmail;

public class ShopperServiceImpl implements ShopperServiceInterface{
	
	private ShopperDAO shopperDAO = new ShopperDAOImpl();
	private ShopDAO shopDAO = new ShopDAOImpl();
	private CreditCardDAO creditCardDAO = new CreditCardDAOImpl();
	private MyEmail myMail = new MyEmail();
	
	@Override
	public boolean loginShopper(HttpServletRequest request){
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		return shopperDAO.loginShopper(account, password);
	}
	/**
	 * 验证账号信息是否重复
	 * @param account 账号信息
	 * @return 判断信息（JSON数据格式）
	 */
	private String valiadShopperAccount(String account){
		long count = shopperDAO.countAccount(account);
		String message = null;
		if(count == 0){
			message = "{\"status\":\"true\",\"message\":\"账号信息无重复\"}";
		}else{
			message = "{\"status\":\"false\",\"message\":\"该账号已经被占用\"}";
		}
		return message;
	}
	/**
	 * 验证邮箱信息是否重复
	 * @param mail 邮箱信息
	 * @return 判断信息（JSON数据格式）
	 */
	private String valiadShopperMail(String mail){
		long count = shopperDAO.countMail(mail);
		String message = null;
		if(count == 0){
			message = "{\"status\":\"true\",\"message\":\"邮箱信息无重复\"}";
		}else{
			message = "{\"status\":\"false\",\"message\":\"该邮箱已经被占用\"}";
		}
		return message;
	}
	/**
	 * 验证身份证信息是否重复
	 * @param idCard 身份证信息
	 * @return 判断信息（JSON数据格式）
	 */
	private String valiadShopperIdCard(String idCard){
		long count = shopperDAO.countIdCard(idCard);
		String message = null;
		if(count == 0){
			message = "{\"status\":\"true\",\"message\":\"身份证信息无重复\"}";
		}else{
			message = "{\"status\":\"false\",\"message\":\"该身份证已经被占用\"}";
		}
		return message;
	}
	/**
	 * 验证信用卡账号和信用卡密码是否合法
	 * @param account 信用卡账号
	 * @param password 信用卡密码
	 * @return 判断信息（JSON数据格式）
	 */
	private String valiadShopperCreditCardAccountAndCreditCardPassword(String account, String password){
		System.out.println(account+" "+password);
		//Integer id = creditCardDAO.getCreditIdByAccountAndPassword(account, password);
		Integer id = creditCardDAO.getCreditIdByAccount(account);
		String message = null;
		if(id == null){
			message = "{\"status\":\"false\",\"message\":\"信用卡信息不存在\"}";
		}else if((id = creditCardDAO.getCreditIdByAccountAndPassword(account, password)) == null){
			message = "{\"status\":\"false\",\"message\":\"信用卡信息错误\"}";
		}else{
			long count = shopperDAO.countCrditCard(id);
			if(count == 0){
				message = "{\"status\":\"true\",\"message\":\"信用卡信息无重复\"}";
			}else{
				message = "{\"status\":\"false\",\"message\":\"该信用卡已经被占用\"}";
			}
		}
		return message;
	}
	/**
	 * 验证名称是否重复
	 * @param onlineName
	 * @return 判断信息（JSON数据格式）
	 */
	private String valiadShopperOnlineName(String onlineName){
		long count  = 0;
		count = shopperDAO.countOnlineName(onlineName);
		String message = null;
		if(count == 0){
			message = "{\"status\":\"true\",\"message\":\"名称无重复\"}";
		}else{
			message = "{\"status\":\"false\",\"message\":\"该名称已经被占用\"}";
		}
		return message;
	}
	
	@Override
	public String valiadShopper(HttpServletRequest request) {
		String type = request.getParameter("type");
		if(type.equals("account")){
			String value = request.getParameter(type);
			return valiadShopperAccount(value);
		}else if(type.equals("mail")){
			String value = request.getParameter(type);
			return valiadShopperMail(value);
		}else if(type.equals("idCard")){
			String value = request.getParameter(type);
			return valiadShopperIdCard(value);
		}else if(type.equals("accountAndPassword")){
			String valueAccount = request.getParameter("creditAccount");
			String valuePassword = request.getParameter("password");
			return valiadShopperCreditCardAccountAndCreditCardPassword(valueAccount, valuePassword);
		}else if(type.equals("onlineName")){
			String value = request.getParameter(type);
			return valiadShopperOnlineName(value);
		}
		return null;
	}
	
	@Override
	public String sendIdCode(String mail) {
		String tempCode = new String();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			tempCode += random.nextInt(9) + "";
		}
		System.out.println("code");
		try {
			myMail.sendMessage(tempCode, mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempCode;
	}
	@Override
	public void shopperRegister(HttpServletRequest request) {
		
		ShopperBean shopperBean = new ShopperBean();
		shopperBean.setAccount(request.getParameter("account"));
		shopperBean.setPassword(request.getParameter("password"));
		String mail = new String();
		mail = request.getParameter("mail") + "@";
		mail += request.getParameter("mailAfter");
		mail += ".com";
		shopperBean.setMail(mail);
		shopperBean.setIdCard(request.getParameter("idCard"));
		
		String creditCardAccount = request.getParameter("creditCardAccount");
		String creditCardPassword = request.getParameter("creditCardPassword");
		Integer id = creditCardDAO.getCreditIdByAccountAndPassword(creditCardAccount, creditCardPassword);
		shopperBean.setCreditCardId(id);
		shopperBean.setOnlineName(request.getParameter("onlineName"));
		String path = "C:\\commercialcity\\shopper.jpg";
		shopperBean.setDisplayPicture(path);
		shopperDAO.register(shopperBean);
	}
	
	@Override
	public boolean countShopperAccount(String account) {
		
		long count = shopperDAO.countAccount(account);
		if(count == 0) return false;
		return true;
	}
	
	@Override
	public void changePasswordByAccount(String account, String newPassword) {
		shopperDAO.changePasswordByAccount(account, newPassword);
	}
	@Override
	public String getMailByAccount(String account) {
		return shopperDAO.getMailByAccount(account);
	}
	
	@Override
	public boolean valiadShopName(String shopName) {
		long count = shopDAO.countShopName(shopName);
		if(count == 0) return true;
		return false;
	}
	
	private void getData(HttpServletRequest request, ShopBean shopBean){
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 500);
		File tempDirectory = new File("C:\\tempDirectory");
		factory.setRepository(tempDirectory);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(1024 * 1024 * 5);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem item:items){
				if(item.isFormField()){
					//一般的 表单
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					if(name.equals("shopName")){
						shopBean.setShopName(value);
					}
					if(name.equals("introduction")){
						shopBean.setIntroduction(value);
					}
				}else{
					//文件域
					String fileName = item.getName();
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
					OutputStream outputStream = new FileOutputStream(fileName);
					while((len = inputStream.read(buffer)) != -1){
						outputStream.write(buffer, 0, len);
					}
					outputStream.close();
					inputStream.close();
					shopBean.setDisplayPicture(fileName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void shopRegister(HttpServletRequest request) {
		ShopBean shopBean = new ShopBean();
		Integer shopperId = (Integer) request.getSession().getAttribute("LoginShopperId");
		shopBean.setShopperId(shopperId);
		getData(request, shopBean);
		Date openDate = new Date();
		shopBean.setOpenDate(openDate);
		double goodRate = 0;
		shopBean.setGoodRate(goodRate);
		long shopId = shopDAO.register(shopBean);
		request.getSession().setAttribute("LoginShopId", shopId);
	}
	
	@Override
	public void checkShopperRegister(HttpServletRequest request, HttpServletResponse response) {
		
		String loginShopAccount = (String) request.getSession().getAttribute("LoginShopAccount");
		Integer shopperId = shopperDAO.getShopperIdByAccount(loginShopAccount);
		Integer shopId = shopDAO.getShopIdByShopperId(shopperId);
		System.out.println("shopId="+shopId);
		if(shopId == null){
			try {
				request.getSession().setAttribute("LoginShopperId", shopperId);
				response.sendRedirect("/CommercialCity/Shop/message/ShopRegister.jsp");
				return;
			} catch (IOException e) {}
			return ;
		}else{
			request.getSession().setAttribute("LoginShopperId", shopperId);
			request.getSession().setAttribute("LoginShopId", shopId);
			/*
			try {
				response.sendRedirect("/CommercialCity/Shop/ShopManage.jsp");
			} catch (IOException e) {}
			return;
			*/
		}
	}
	@Override
	public void saveLoginMessage(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
