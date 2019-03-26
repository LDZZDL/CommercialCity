package com.fjsf.web.service.impl;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjsf.web.bean.CustomerBean;
import com.fjsf.web.dao.CreditCardDAO;
import com.fjsf.web.dao.CustomerDAO;
import com.fjsf.web.dao.impl.CreditCardDAOImpl;
import com.fjsf.web.dao.impl.CustomerDAOImpl;
import com.fjsf.web.service.inter.CustomerServiceInterface;
import com.fjsf.web.utils.MyEmail;

public class CustomerServiceImpl implements CustomerServiceInterface{

	private CustomerDAO customerDAO=new CustomerDAOImpl();
	private CreditCardDAO creditCardDAO=new CreditCardDAOImpl();
	
	@Override
	public void loginSaveMessage(HttpServletRequest request) {
		String customerAccount = request.getParameter("account");
		Integer customerId = customerDAO.getCustomerIdByAccount(customerAccount);
		request.getSession().setAttribute("CustomerLoginAccount", customerAccount);
		request.getSession().setAttribute("CustomerLoginCustomerId", customerId);
	}
	
	@Override
	public boolean LoginCustomer(HttpServletRequest request) {
		String customerAccount=request.getParameter("account");
		String customerPassword=request.getParameter("password");
		return customerDAO.loginCustomer(customerAccount, customerPassword);
	}

	
	/**
	 * 验证账号信息是否重复
	 * @param customerAccount 账号信息
	 * @return 判断信息（JSON数据格式）
	 */
	String valiadCustomerAccount(String customerAccount){
		long count =customerDAO.countCustomerAccount(customerAccount);
		String message=null;
		if(count==0){
			message="{\"status\":\"true\",\"message\":\"账号信息无重复\"}";	
		}else{
			message = "{\"status\":\"false\",\"message\":\"该账号已经被占用\"}";
		}
		return message;
	}
	
	/**
	 * 验证邮箱信息是否重复
	 * @param customerMail 邮箱信息
	 * @return 判断信息（JSON数据格式）
	 */
	String valiadCustomerMail(String customerMail){
		long count = customerDAO.countCustomerMail(customerMail);
		String message = null;
		if(count == 0){
			message = "{\"status\":\"true\",\"message\":\"邮箱信息无重复\"}";
		}else{
			message = "{\"status\":\"false\",\"message\":\"该邮箱已经被占用\"}";
		}
		return message;
	}
	
	/**
	 * 验证信用卡账号和信用卡密码是否合法
	 * @param account 信用卡账号
	 * @param password 信用卡密码
	 * @return 判断信息（JSON数据格式）
	 */
	String valiadCustomerCreditCardAccountAndCreditCardPassword(String customerAccount, String customerPassword){
		System.out.println(customerAccount+" "+customerPassword);
		Integer id = creditCardDAO.getCreditIdByAccountAndPassword(customerAccount, customerPassword);
		String message = null;
		if(id == null){
			message = "{\"status\":\"false\",\"message\":\"信用卡信息不存在\"}";
		}else{
			long count = customerDAO.countCreditCardId(id);
			if(count == 0){
				message = "{\"status\":\"true\",\"message\":\"信用卡信息无重复\"}";
			}else{
				message = "{\"status\":\"false\",\"message\":\"该信用卡已经被占用\"}";
			}
		}
		return message;
	}
	
	/**
	 * 验证信用卡账号是否合法
	 * 
	 */
	
	String valiadCustomerCreditCardAccount(String Account){
		Integer id=creditCardDAO.getCreditIdByAccount(Account);
		String message = null;
		if(id == null){
			message = "{\"status\":\"false\",\"message\":\"信用卡信息不存在\"}";
		}else{
			long count = customerDAO.countCreditCardId(id);
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
	String valiadCustomerName(String customerName){
		long count  = 0;
		count = customerDAO.countCustomerName(customerName);
		String message = null;
		if(count == 0){
			message = "{\"status\":\"true\",\"message\":\"名称无重复\"}";
		}else{
			message = "{\"status\":\"false\",\"message\":\"该名称已经被占用\"}";
		}
		return message;
	}
	
	@Override
	public String valiadCustomer(HttpServletRequest request) {
		String type=request.getParameter("type");
		if(type.equals("customerAccount")){
			String value=request.getParameter(type);
			return valiadCustomerAccount(value);
		}else if(type.equals("customerMail")){
			String value=request.getParameter(type);
			return valiadCustomerMail(value);
		}else if(type.equals("accountAndPassword")){
			String valueAccount = request.getParameter("creditAccount");
			String valuePassword = request.getParameter("password");
			return valiadCustomerCreditCardAccountAndCreditCardPassword(valueAccount, valuePassword);
			
		}else if(type.equals("accountAndPassword")){
			String valueAccount=request.getParameter("creditAccount");
			return valiadCustomerAccount(valueAccount);
		}
			
		else if(type.equals("customerName")){
			String value=request.getParameter(type);
			return valiadCustomerName(value);
		}
		return null;
	}


	@Override
	public String sendIdCode(String customerMail) {
		String tempCode = new String();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			tempCode += random.nextInt(9) + "";
		}
		try {
			MyEmail.sendMessage(tempCode, customerMail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempCode;
	}


	@Override
	public void customerRegister(HttpServletRequest request) {
		CustomerBean customerBean=new CustomerBean();
		customerBean.setCustomerAccount(request.getParameter("customerAccount"));
		customerBean.setCustomerPassword(request.getParameter("customerPassword"));
		customerBean.setCustomerSex(request.getParameter("customerSex"));
		String customerMail=new String();
		customerMail=request.getParameter("customerMail")+"@";
		customerMail+= request.getParameter("mailAfter");
		customerMail+=".com";
		customerBean.setCustomerMail(customerMail);
		String creditCardAccount = request.getParameter("creditCardAccount");
		String creditCardPassword = request.getParameter("creditCardPassword");
		Integer id=creditCardDAO.getCreditIdByAccountAndPassword(creditCardAccount, creditCardPassword);
		customerBean.setCreditCardId(id);
		customerBean.setCustomerName(request.getParameter("customerName"));
		String path="/CommercialCity/commercialcity/customer.jpg";
		customerBean.setDisplayPicture(path);
		customerDAO.customerRegist(customerBean);
	}


	@Override
	public boolean countCustomerAccount(String customerAccount) {
		
		long count=customerDAO.countCustomerAccount(customerAccount);
		if(count==0) return false;
		return true;
	}


	@Override
	public void changePasswordByCustomerAccount(String customerAccount, String newPassword) {
		customerDAO.changeCustomerPasswordByCustomerAccount(customerAccount, newPassword);
	}


	@Override
	public String getMailByAccount(String account) {
		return customerDAO.getMailByCustomerAccount(account);
	}

	@Override
	public void cancelLogin(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("CustomerLoginAccount", null);
		request.getSession().setAttribute("CustomerLoginCustomerId", null);
		try {
			System.out.println("取消了");
			response.getWriter().println("{\"status\":\"true\",\"message\":\"取消登录\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
