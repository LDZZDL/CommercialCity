package com.fjsf.web.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
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
import com.fjsf.web.bean.ShopBean;
import com.fjsf.web.bean.ShopperBean;
import com.fjsf.web.dao.CreditCardDAO;
import com.fjsf.web.dao.ShopDAO;
import com.fjsf.web.dao.ShopperDAO;
import com.fjsf.web.dao.impl.CreditCardDAOImpl;
import com.fjsf.web.dao.impl.ShopDAOImpl;
import com.fjsf.web.dao.impl.ShopperDAOImpl;
import com.fjsf.web.service.inter.ShopMessageServiceInterface;
import com.fjsf.web.utils.MyEmail;
import com.fjsf.web.viewobject.OVB;
import com.fjsf.web.viewobject.OVC;

/**
 * @author 黄宁
 */
public class ShopMessageServiceImpl implements ShopMessageServiceInterface{

	private ShopDAO shopDAO=new ShopDAOImpl();
	private ShopperDAO shopperDAO=new ShopperDAOImpl();
	private CreditCardDAO creditCardDAO=new CreditCardDAOImpl();
	
	@Override
	public void getListsForCustomerMessage(HttpServletRequest request, HttpServletResponse response) {
		Integer shopperId = (Integer) request.getSession().getAttribute("LoginShopperId");
		Integer shopId = (Integer) request.getSession().getAttribute("LoginShopId");
	}
	
	@Override
	public void showShopAssociatedMessage(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("商家显示");
		Integer shopperId = (Integer) request.getSession().getAttribute("LoginShopperId");
		//Integer shopId = (Integer) request.getSession().getAttribute("LoginShopId");
		Integer shopId=shopDAO.getShopIdByShopperId(shopperId);
		ShopperBean shopperBean=shopperDAO.getShopperByShopperId(shopperId);
		CreditCardBean creditCardBean= creditCardDAO.getCreditCardByCreditCardId(shopperBean.getCreditCardId());
		ShopBean shopBean=shopDAO.getShopByShopId(shopId);
		// ============== 5.25 林
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String time = simpleDateFormat.format(shopBean.getOpenDate());
		OVB ovb = new OVB(shopBean.getShopId(), shopBean.getShopperId(), shopBean.getShopName(),
				shopBean.getIntroduction(), time, shopBean.getDisplayPicture(), shopBean.getGoodRate());
		OVC ovc = new OVC(shopperBean.getShopperId(), shopperBean.getAccount(), shopperBean.getPassword(),
				shopperBean.getMail(), shopperBean.getIdCard(), shopperBean.getCreditCardId(),
				shopperBean.getOnlineName(), shopperBean.getDisplayPicture());
		// ============== 5.25 林
		ObjectMapper mapper = new ObjectMapper();
		try{
			List<Object> list=new ArrayList<>();
			//list.add(shopBean);
			// ============== 5.25 林
			list.add(ovb);
			list.add(ovc);
			// ============== 5.25 林
			list.add(creditCardBean);
			Map<String, List<Object>> map = new HashMap<>();
			map.put("message", list);
			String message = mapper.writeValueAsString(map);
			response.getWriter().println(message);
			System.out.println(message);
		}catch (Exception e) {}
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
			System.out.println("size"+items.size());
			for(FileItem item:items){
				System.out.println("enter");
				if(!item.isFormField()){
					System.out.println("文件");
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
				}else{
					System.out.println("非文件");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		fileName = "/CommercialCity/commercialcity/" + newFileName;
		return fileName;
	}
	
	private boolean valiadShopperName(String newOnlineName,Integer shopperId) {
		long count=shopperDAO.countOnlineName(newOnlineName, shopperId);
		if(count==0)
			return true;
		return false;
	}
	private boolean valiadShopName(String newShopName,Integer shopId){
		long count=shopDAO.countShopName(newShopName, shopId);
		if(count==0)
			return true;
		return false;
	}
	private boolean valiadMail(String newMail,Integer shopperId){
		boolean flag=false;
		long count=shopperDAO.countMail(newMail);
		if(count==0)
			flag=true;
		return flag;
	}
	@Override
	public void checkShopAssociateMessage(HttpServletRequest request, HttpServletResponse response) {
		String goal=request.getParameter("goal");
		System.out.println("二级地址"+goal);
		Integer shopperId = (Integer) request.getSession().getAttribute("LoginShopperId");
		Integer shopId=shopDAO.getShopIdByShopperId(shopperId);
		String message=new String();
		if(goal.equals("onlineName")){
			String newOnlineName=request.getParameter("newOnlineName");
			boolean flag=valiadShopperName(newOnlineName, shopperId);
			if(flag == true){
				message = "{\"status\":\"true\",\"message\":\"卖家名称无重复\"}";
			}else{
				message = "{\"status\":\"false\",\"message\":\"卖家名称重复\"}";
			}
			try {
				System.out.println(message);
				response.getWriter().println(message);
			} catch (IOException e) {}
			return ;
		}
		if(goal.equals("shopName")){
			String newShopName=request.getParameter("newShopName");
			boolean flag=valiadShopName(newShopName, shopId);
			if(flag == true){
				message = "{\"status\":\"true\",\"message\":\"店铺名称无重复\"}";
			}else{
				message = "{\"status\":\"false\",\"message\":\"店铺名称重复\"}";
			}
			try {
				System.out.println(message);
				response.getWriter().println(message);
			} catch (IOException e) {}
			return ;
		}
		if(goal.equals("mail")){
			String newMail=request.getParameter("newMail");
			boolean flag=valiadMail(newMail, shopperId);
			if(flag == true){
				message = "{\"status\":\"true\",\"message\":\"邮箱无重复\"}";
			}else{
				message = "{\"status\":\"false\",\"message\":\"邮箱重复\"}";
			}
			try {
				System.out.println(message);
				response.getWriter().println(message);
			} catch (IOException e) {}
			return ;
		}
		if(goal.equals("creditCard")){
			String newCreditCardAccount = request.getParameter("newCreditCardAccount");
			String newCreditCardPassword = request.getParameter("newCreditCardPassword");
			Integer creditCardId = creditCardDAO.getCreditIdByAccount(newCreditCardAccount);
			if(creditCardId == null){
				message = "{\"status\":\"false\",\"message\":\"信用卡信息不存在\"}";
			}else{
				creditCardId = creditCardDAO.getCreditIdByAccountAndPassword(newCreditCardAccount, newCreditCardPassword);
				if(creditCardId == null){
					message = "{\"status\":\"false\",\"message\":\"信用卡信息不正确\"}";
				}else{
					long count = shopperDAO.countCrditCard(creditCardId);
					if(count == 0){
						message = "{\"status\":\"true\",\"message\":\"信用卡不重复\"}";
					}else{
						message = "{\"status\":\"false\",\"message\":\"信用卡重复\"}";
					}
				}
			}
			try {
				System.out.println(message);
				response.getWriter().println(message);
			} catch (IOException e) {}
		}
	}

	@Override
	public void changeShopAssociatedMessage(HttpServletRequest request, HttpServletResponse response) {
		String goal = request.getParameter("goal");
		System.out.println("二级地址 "+ goal);
		Integer shopperId = (Integer) request.getSession().getAttribute("LoginShopperId");
		Integer shopId=shopDAO.getShopIdByShopperId(shopperId);
		System.out.println("跳到哪里了");
		if(goal.equals("onlineNameAndShopNameAndShopIntrodusction")){
			
			String newOnlineName=request.getParameter("newOnlineName");
			String newShopName=request.getParameter("newShopName");
			String newShopIntroduction=request.getParameter("newShopIntroduction");
			shopperDAO.changeShopperNameByShopperId(newOnlineName, shopperId);
		    shopDAO.changeShopNameByShopId(newShopName, shopId);
		    shopDAO.changeShopIntruducionByShopId(newShopIntroduction, shopId);
		    
		    return;
		}
		if(goal.equals("mail")){
			String newMail=request.getParameter("newMail");
			shopperDAO.changeMailByShopperId(newMail, shopperId);
			return;
		}
		if(goal.equals("creditCard")){
			String newCreditCardAccount = request.getParameter("newCreditCardAccount");
			String newCreditCardPassword = request.getParameter("newCreditCardPassword");
			Integer newCreditCard=creditCardDAO.getCreditIdByAccountAndPassword(newCreditCardAccount, newCreditCardPassword);
			shopperDAO.changeCreditCardIdByShopperId(newCreditCard, shopperId);
		}
		if(goal.equals("password")){
			String newPassword=request.getParameter("newPassword");
			shopperDAO.changeShopperPasswordByShopperId(newPassword, shopperId);
		}
		if(goal.equals("shopperDisplayPicture")){
			String newShopperDisplayPicture=changeDisplayPicture(request);
			System.out.println("新地址="+newShopperDisplayPicture);
			shopperDAO.changeDisplayPictureByShopperId(newShopperDisplayPicture, shopperId);
			try {
				response.sendRedirect("/CommercialCity/Shop/message/ShopperMessage.jsp");
			} catch (IOException e) {}
		}
		if(goal.equals("shopDisplayPicture")){
			String newShopDisplayPicture=changeDisplayPicture(request);
			System.out.println("新地址="+newShopDisplayPicture);
			shopDAO.changeDisplayPictureByShopId(newShopDisplayPicture, shopId);
			try {
				response.sendRedirect("/CommercialCity/Shop/message/ShopperMessage.jsp");
			} catch (IOException e) {}
		}
	}

	@Override
	public String sendCode(HttpServletRequest request, HttpServletResponse response) {
		Integer shopperId = (Integer) request.getSession().getAttribute("LoginShopperId");
		String mail=shopperDAO.getMailByShopperId(shopperId);
		String code= MyEmail.sendIdCode(mail);
		System.out.println("验证码"+code);
		try {
			response.getWriter().print(code);
		} catch (IOException e) {}
		return code; 

	}

	@Override
	public String sendNewCode(HttpServletRequest request, HttpServletResponse response) {
		String newMail = request.getParameter("NewMail");
		String code = MyEmail.sendIdCode(newMail);
		System.out.println("验证码:"+code);
		try {
			response.getWriter().println(code);
		} catch (IOException e) {}
		return code;

	}
	
}
