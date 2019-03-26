package com.fjsf.web.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fjsf.web.bean.CreditCardBean;
import com.fjsf.web.bean.CustomerBean;
import com.fjsf.web.bean.DeliveryAddressBean;
import com.fjsf.web.dao.CreditCardDAO;
import com.fjsf.web.dao.CustomerDAO;
import com.fjsf.web.dao.DeliveryAddressDAO;
import com.fjsf.web.dao.impl.CreditCardDAOImpl;
import com.fjsf.web.dao.impl.CustomerDAOImpl;
import com.fjsf.web.dao.impl.DeliveryAddressDAOImpl;
import com.fjsf.web.service.inter.CustomerMessageServiceInterface;
import com.fjsf.web.utils.MyEmail;
import com.fjsf.web.viewobject.OVA;

public class CustomerMessageServiceImpl implements CustomerMessageServiceInterface{

	private CustomerDAO customerDAO = new CustomerDAOImpl();
	private CreditCardDAO creditCardDAO = new CreditCardDAOImpl();
	private DeliveryAddressDAO deliveryAddressDAO = new DeliveryAddressDAOImpl();
	
	@Override
	public void showCustomerAssociatedMessage(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("用户显示");
		Integer customerId = (Integer) request.getSession().getAttribute("CustomerLoginCustomerId");
		CustomerBean customerBean = customerDAO.getCustomerMessageByCustomerId(customerId);
		CreditCardBean creditCardBean = creditCardDAO.getCreditCardByCreditCardId(customerBean.getCreditCardId());
		List<DeliveryAddressBean> deliveryAddressBeans = deliveryAddressDAO.getDeliveryAddressByCustomerId(customerId);
		ObjectMapper mapper = new ObjectMapper();
		try {
			int i = 0;
			List<Object> list = new ArrayList<>();
			list.add(customerBean);
			list.add(creditCardBean);
			for(DeliveryAddressBean deliveryAddressBean:deliveryAddressBeans){
				list.add(deliveryAddressBean);
				i ++;
			}
			OVA ova = new OVA();
			ova.setDeliveryAddressNumber(i);
			list.add(ova);
			Map<String, List<Object>> map = new HashMap<>();
			map.put("message", list);
			String message = mapper.writeValueAsString(map);
			System.out.println(message);
			response.getWriter().println(message);
		} catch (Exception e) {}
	}

	private String changeDisplayPicture(HttpServletRequest request){
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 500);
		File tempDirectory = new File("C:\\tempDirectory");
		factory.setRepository(tempDirectory);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(1024 * 1024 * 5);
		String fileName = new String();
		String newFileName = new String();
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem item:items){
				if(!item.isFormField()){
					fileName = item.getName();
					InputStream inputStream = item.getInputStream();
					byte[] buffer = new byte[1024];
					int len = 0;
					Random random = new Random();
					random.nextInt();
					for (int i = 0; i < 20; i++) {
						newFileName += (char) (random.nextInt(26) + 97) + "";
					}
					newFileName += fileName.substring(fileName.lastIndexOf("."));
					fileName = "C:/commercialcity/" + newFileName;
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
		fileName = "/CommercialCity/commercialcity/" + newFileName;
		return fileName;
	}
	
	/* 
	 修改用户姓名 用户性别
	 url:/CommercialCity/customerMessage?action=ChangeCustomerMessage&goal=CustomerNameAndCustomerSex
	 data:{NewCustomerName:value,NewCustomerSex:value}
	 
	 邮箱
	 url:/CommercialCity/customerMessage?action=ChangeCustomerMessage&goal=CustomerMail
	 data:{NewCustomerMail:value}
	 
	 信用卡
	 url:/CommercialCity/customerMessage?action=ChangeCustomerMessage&goal=CreditCard
	 data:{NewCreditCardAccount:value,NewCreditCardPassword:value}
	 
	 密码
	 url:/CommercialCity/customerMessage?action=ChangeCustomerMessage&goal=Password
	 data:{NewCustomerPassword:value}
	 
	 表单提交
	 url:/CommercialCity/customerMessage?action=ChangeCustomerMessage&goal=DisplayPicture
	 
	 收货地址增加
	 url:/CommercialCity/customerMessage?action=ChangeCustomerMessage&goal=DeliveryAddressAdd
	 data:{
	 	ReceiverName:value,
	 	ReceiverTelephone:value,
	 	receiverAddressFirst:value,
	 	receiverAddressSecond:value,
	 	receiverAddressThird:value,
	 	receiverAddressDetail:value
	 }
	 收货地址修改
	 url:/CommercialCity/customerMessage?action=ChangeCustomerMessage&goal=DeliveryAddressChange
	 data:{
	 	DeliveryAddressId:value,
	 	ReceiverName:value,
	 	ReceiverTelephone:value,
	 	receiverAddressFirst:value,
	 	receiverAddressSecond:value,
	 	receiverAddressThird:value,
	 	receiverAddressDetail:value
	 }
	 收货地址删除
	 url:/CommercialCity/customerMessage?action=ChangeCustomerMessage&goal=DeliveryAddressDelete
	 data:{DeliveryAddressId:value}
	*/
	@Override
	public void changeCustomerAssociatedMessage(HttpServletRequest request, HttpServletResponse response) {
		String goal = request.getParameter("goal");
		System.out.println("二级地址 "+ goal);
		Integer customerId = (Integer) request.getSession().getAttribute("CustomerLoginCustomerId");
		if(goal.equals("CustomerNameAndCustomerSex")){
			String newCustomerName = request.getParameter("NewCustomerName");
			String newCustomerSex = request.getParameter("NewCustomerSex");
			System.out.println("NewCustomerName"+newCustomerName);
			System.out.println("NewCutsomerSex"+ newCustomerSex);
			System.out.println("修改用户姓名和性别");
			System.out.println("customerId = "+customerId);
			customerDAO.changeCustomerNameByCustomerId(customerId, newCustomerName);
			customerDAO.changeCustomerSexByCustomerId(newCustomerSex, customerId);
			return;
		}
		if(goal.equals("CustomerMail")){
			String newCustomerMail = request.getParameter("NewCustomerMail");
			customerDAO.changeCustomerMailByCustomerId(newCustomerMail, customerId);
			return ;
		}
		if(goal.equals("CreditCard")){
			String newCreditCardAccount = request.getParameter("NewCreditCardAccount");
			String newCreditCardPassword = request.getParameter("NewCreditCardPassword");
			Integer newCreditCardId = creditCardDAO.getCreditIdByAccountAndPassword(newCreditCardAccount, newCreditCardPassword);
			customerDAO.changeCustomerCreditCardByCustomerId(newCreditCardId, customerId);
		}
		if(goal.equals("Password")){
			String newCustomerPassword = request.getParameter("NewCustomerPassword");
			customerDAO.changeCustomerPasswordByCustomerId(newCustomerPassword, customerId);
		}
		if(goal.equals("DisplayPicture")){
			String newDisplayPicture = changeDisplayPicture(request);
			customerDAO.changeDisplayPictureByCustomerId(newDisplayPicture, customerId);
			try {
				response.sendRedirect("/CommercialCity/Customer/Message/CustomerMessage.jsp");
			} catch (IOException e) {}
		}
		if(goal.equals("DeliveryAddressAdd")){
			DeliveryAddressBean deliveryAddressBean = new DeliveryAddressBean();
			deliveryAddressBean.setCustomerId(customerId);
			deliveryAddressBean.setReceiverName(request.getParameter("ReceiverName"));
			deliveryAddressBean.setReceiverTelephone(request.getParameter("ReceiverTelephone"));
			deliveryAddressBean.setReceiverAddressFirst(request.getParameter("receiverAddressFirst"));
			deliveryAddressBean.setReceiverAddressSecond(request.getParameter("receiverAddressSecond"));
			deliveryAddressBean.setReceiverAddressThird(request.getParameter("receiverAddressThird"));
			deliveryAddressBean.setReceiverAddressDetail(request.getParameter("receiverAddressDetail"));
			deliveryAddressDAO.addDeliveryAddress(deliveryAddressBean);
		}
		if(goal.equals("DeliveryAddressChange")){
			DeliveryAddressBean deliveryAddressBean = new DeliveryAddressBean();
			deliveryAddressBean.setDeliveryAddressId(Integer.parseInt(request.getParameter("DeliveryAddressId")));
			deliveryAddressBean.setReceiverName(request.getParameter("ReceiverName"));
			deliveryAddressBean.setReceiverTelephone(request.getParameter("ReceiverTelephone"));
			deliveryAddressBean.setReceiverAddressFirst(request.getParameter("receiverAddressFirst"));
			deliveryAddressBean.setReceiverAddressSecond(request.getParameter("receiverAddressSecond"));
			deliveryAddressBean.setReceiverAddressThird(request.getParameter("receiverAddressThird"));
			deliveryAddressBean.setReceiverAddressDetail(request.getParameter("receiverAddressDetail"));
			deliveryAddressDAO.changeDeliveryAddressByDeliveryAddressId(deliveryAddressBean);
		}
		if(goal.equals("DeliveryAddressDelete")){
			Integer deliveryAddressId = Integer.parseInt(request.getParameter("DeliveryAddressId"));
			deliveryAddressDAO.deleteDeliveryAddressByDeliveryAddressId(deliveryAddressId);
		}
	}

	/* 
	 校验用户姓名
	 url:/CommercialCity/customerMessage?action=CheckCustomerMessage&goal=CustomerName
	 data:{NewCustomerName:value}
	 校验用户邮箱
	 url:/CommercialCity/customerMessage?action=CheckCustomerMessage&goal=CustomerMail
	 data:{NewCustomerMail:value}
	 校验用户信用卡
	 url:/CommercialCity/customerMessage?action=CheckCustomerMessage&goal=CreditCard
	 data:{NewCreditCardAccount:value,NewCreditCardPassword:value}
	*/
	private boolean valiadCustomerName(String newCustomerName, Integer customerId){
		long count = customerDAO.countCustomerName(newCustomerName, customerId);
		if(count == 0) return true;
		return false;
	}
	
	private boolean valiadCustomerMail(String newCustomerMail, Integer customerId){
		boolean flag = false;
		long count = customerDAO.countCustomerMail(newCustomerMail, customerId);
		if(count == 0) flag = true;
		return flag;
	}
	
	@Override
	public void checkCustomerAssociatedMessage(HttpServletRequest request, HttpServletResponse response) {
		String goal = request.getParameter("goal");
		System.out.println("二级地址 "+ goal);
		Integer customerId = (Integer) request.getSession().getAttribute("CustomerLoginCustomerId");
		String message = new String();
		if(goal.equals("CustomerName")){
			String newCustomerName = request.getParameter("NewCustomerName");
			boolean flag = valiadCustomerName(newCustomerName, customerId);
			if(flag == true){
				message = "{\"status\":\"true\",\"message\":\"名称无重复\"}";
			}else{
				message = "{\"status\":\"false\",\"message\":\"名称重复\"}";
			}
			try {
				response.getWriter().println(message);
			} catch (IOException e) {}
			return ;
		}
		if(goal.equals("CustomerMail")){
			String newCustomerMail = request.getParameter("NewCustomerMail");
			boolean flag = valiadCustomerMail(newCustomerMail, customerId);
			if(flag == true){
				message = "{\"status\":\"true\",\"message\":\"邮箱无重复\"}";
			}else{
				message = "{\"status\":\"false\",\"message\":\"邮箱重复\"}";
			}
			try {
				response.getWriter().println(message);
			} catch (IOException e) {}
			return ;
		}
		if(goal.equals("CreditCard")){
			String newCreditCardAccount = request.getParameter("NewCreditCardAccount");
			String newCreditCardPassword = request.getParameter("NewCreditCardPassword");
			Integer creditCardId = creditCardDAO.getCreditIdByAccount(newCreditCardAccount);
			if(creditCardId == null){
				message = "{\"status\":\"false\",\"message\":\"信用卡信息不存在\"}";
			}else{
				creditCardId = creditCardDAO.getCreditIdByAccountAndPassword(newCreditCardAccount, newCreditCardPassword);
				if(creditCardId == null){
					message = "{\"status\":\"false\",\"message\":\"信用卡信息不正确\"}";
				}else{
					long count = customerDAO.countCreditCard(creditCardId, customerId);
					if(count == 0){
						message = "{\"status\":\"true\",\"message\":\"信用卡不重复\"}";
					}else{
						message = "{\"status\":\"false\",\"message\":\"信用卡重复\"}";
					}
				}
			}
			System.out.println(message);
			try {
				response.getWriter().println(message);
			} catch (IOException e) {}
		}
	}
	/**
	 * url:/CommercialCity/customerMessage?action=SendCode
	 */
	 
	@Override
	public String sendCode(HttpServletRequest request, HttpServletResponse response) {
		Integer customerId = (Integer) request.getSession().getAttribute("CustomerLoginCustomerId");
		String mail = customerDAO.getMailByCustomerId(customerId);
		String code = MyEmail.sendIdCode(mail);
		System.out.println("验证码:"+code);
		try {
			response.getWriter().println(code);
		} catch (IOException e) {}
		return code; 
	}

	/**
	 * url:/CommercialCity/customerMessage?action=SendCodeNewMail
	 * data:{NewMail:value}
	 * 返回验证码
	 */
	
	@Override
	public String sendCodeToNewMail(HttpServletRequest request, HttpServletResponse response) {
		String mail = request.getParameter("NewMail");
		String code = MyEmail.sendIdCode(mail);
		System.out.println("验证码:"+code);
		try {
			response.getWriter().println(code);
		} catch (IOException e) {}
		return code;
	}

	

}
