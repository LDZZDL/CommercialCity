package com.fjsf.web.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fjsf.web.bean.ProductBean;
import com.fjsf.web.dao.ProductDAO;
import com.fjsf.web.dao.impl.ProductDAOImpl;
import com.fjsf.web.service.inter.ShopProductManageServiceInterface;
import com.fjsf.web.utils.PageShopProduct;

public class ShopProductManageServiceImpl implements ShopProductManageServiceInterface{

	
	private ProductDAO productDAO = new ProductDAOImpl();
	
	private PageShopProduct getPageShopProduct(HttpServletRequest request){
		
		PageShopProduct pageShopProduct = new PageShopProduct();
		String falg = new String();
		falg = (String) request.getSession().getAttribute("PageProductAttributeState");
		if(falg != null){
			if(falg.equals("true")){
				pageShopProduct = (PageShopProduct) request.getSession().getAttribute("PageProductAttribute");
				request.getSession().setAttribute("PageProductAttributeState", "false");
				return pageShopProduct;
			}
		}
		Integer shopId = (Integer) request.getSession().getAttribute("LoginShopId");
		String searchValue = request.getParameter("searchValue");
		String orderType = request.getParameter("orderType");
		Integer pageNo = Integer.parseInt(request.getParameter("pageNo"));
		Double priceRangeLeft = null;
		Double priceRangeRight = null; 
		try{
			priceRangeLeft = Double.parseDouble(request.getParameter("priceRangeLeft"));
		}catch (NumberFormatException e) {}
		try{
			priceRangeRight = Double.parseDouble(request.getParameter("priceRangeRight"));
		}catch (Exception e) {}
		long totalProductNumber = productDAO.countProductWithShopIdAndCondition(shopId, searchValue, orderType, 
				priceRangeLeft, priceRangeRight);
		long totalPageNo = (totalProductNumber-1)/pageShopProduct.getPageSize() + 1;
		pageShopProduct.setOrderType(orderType);
		pageShopProduct.setSearchValue(searchValue);
		pageShopProduct.setPageNo(pageNo);
		pageShopProduct.setPriceRangeLeft(priceRangeLeft);
		pageShopProduct.setPriceRangeRight(priceRangeRight);
		pageShopProduct.setTotalProductNumber(totalProductNumber);
		pageShopProduct.setTotalPageNo(totalPageNo);
		return pageShopProduct;
	}
	
	@Override
	public void getListsForProduct(HttpServletRequest request, HttpServletResponse response) {
		//Integer shopperId = (Integer) request.getSession().getAttribute("LoginShopperId");
		Integer shopId = (Integer) request.getSession().getAttribute("LoginShopId");
		PageShopProduct pageShopProduct = getPageShopProduct(request);
		List<ProductBean> lists = productDAO.getListsForProductByShopIdAndCondition(shopId, pageShopProduct.getSearchValue(), 
				pageShopProduct.getOrderType(), pageShopProduct.getPriceRangeLeft(), 
				pageShopProduct.getPriceRangeRight(), pageShopProduct.getPageNo(), 
				pageShopProduct.getPageSize());
		List<Object> pageProduct = new ArrayList<>();
		List<Object> pageAttribute = new ArrayList<>();
		pageAttribute.add(pageShopProduct);
		for(ProductBean productBean:lists){
			pageProduct.add(productBean);
		}
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map.put("message", pageProduct);
		map.put("pageAttribute", pageAttribute);
		try {
			String message = mapper.writeValueAsString(map);
			response.getWriter().println(message);
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map));
		} catch (Exception e) {}
	}

	@Override
	public void deleteProductByProductId(HttpServletRequest request, HttpServletResponse response) {
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		PageShopProduct pageShopProduct = new PageShopProduct();
		productDAO.deleteProductByProductId(productId);
		Integer shopId = (Integer) request.getSession().getAttribute("LoginShopId");
		Integer pageNo = Integer.parseInt(request.getParameter("pageNo"));
		Integer totalProductNumber = Integer.parseInt(request.getParameter("totalProductNumber"));
		Boolean flag = (((pageNo-1)*pageShopProduct.getPageSize()+1) == totalProductNumber);
		if(flag){
			pageNo = pageNo -1;
		}
		pageShopProduct.setPageNo(pageNo);
		pageShopProduct.setTotalProductNumber(totalProductNumber-1);
		pageShopProduct.setTotalPageNo(pageNo);
		ObjectMapper mapper = new ObjectMapper();
		try {
			String message = mapper.writeValueAsString(pageShopProduct);
			response.getWriter().println(message);
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pageShopProduct));
		} catch (Exception e) {}
	}

	@Override
	public void getDetailProductMessage(HttpServletRequest request, HttpServletResponse response) {
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		ProductBean productBean = productDAO.getProductDetailMessage(productId);
		ObjectMapper mapper = new ObjectMapper();
		try {
			String message = mapper.writeValueAsString(productBean);
			response.getWriter().println(message);
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(productBean));
		} catch (Exception e) {}
	}

	@Override
	public void changeProductMessageForm(HttpServletRequest request, HttpServletResponse response) {
		Integer shopId = (Integer) request.getSession().getAttribute("LoginShopId");
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		String productName = request.getParameter("productName");
		String productIntroduction = request.getParameter("productIntroduction");
		Double productSale = Double.parseDouble(request.getParameter("productSale"));
		Integer productStock = Integer.parseInt(request.getParameter("productStock"));
		String productClass = request.getParameter("productClass");
		String productAttribute = request.getParameter("productAttribute");
		String writer = request.getParameter("writer");
		String publishingHouse = request.getParameter("publishingHouse");
		Date shelfTime = null;
		ProductBean productBean = new ProductBean(productId, shopId, productName, productIntroduction, productSale, 
				productStock, productClass, null, 
				productAttribute, writer, publishingHouse, shelfTime, 
				null, null, null);
		productDAO.changeProductForMessageByProductId(productBean);
		//记录状态
		PageShopProduct pageShopProduct = getPageShopProduct(request);
		request.getSession().setAttribute("PageProductAttribute", pageShopProduct);
		request.getSession().setAttribute("PageProductId", productId);
		request.getSession().setAttribute("PageProductAttributeState", "true");
	}

	
	private void changeDisplayPicture(HttpServletRequest request, ProductBean productBean){
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 500);
		File tempDirectory = new File("C:\\tempDirectory");
		factory.setRepository(tempDirectory);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(1024 * 1024 * 5);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem item:items){
				if(!item.isFormField()){
					String fileName = item.getName();
					String fieldName = item.getFieldName();
					String newFileName = new String();
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
					if(fieldName.equals("productShowPicture")){
						productBean.setProductShowPicture("/CommercialCity/commercialcity/"+newFileName);
					}
					if(fieldName.equals("productIntroductionPictureOne")){
						productBean.setProductIntroductionPictureOne("/CommercialCity/commercialcity/"+newFileName);
					}
					if(fieldName.equals("productIntroductionPictureTwo")){
						productBean.setProductIntroductionPictureTwo("/CommercialCity/commercialcity/"+newFileName);
					}
					if(fieldName.equals("productIntroductionPictureThree")){
						productBean.setProductIntroductionPictureThree("/CommercialCity/commercialcity/"+newFileName);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void changeProductPicture(HttpServletRequest request, HttpServletResponse response) {
		//PageShopProduct pageShopProduct = (PageShopProduct) request.getSession().getAttribute("PageProductAttribute");
		Integer productId = (Integer) request.getSession().getAttribute("PageProductId");
		ProductBean productBean = new ProductBean();
		changeDisplayPicture(request, productBean);
		productBean.setProductId(productId);
		productDAO.changeProductForPictureByProductId(productBean);
		try {
			response.sendRedirect("/CommercialCity/Shop/product/ShopProductManage.jsp");
		} catch (Exception e) {}
	}

	private void addProductForm(HttpServletRequest request){
		Integer shopId = (Integer) request.getSession().getAttribute("LoginShopId");
		//Integer productId = Integer.parseInt(request.getParameter("productId"));
		Integer productId = null;
		String productName = request.getParameter("productName");
		String productIntroduction = request.getParameter("productIntroduction");
		System.out.println("productIntroduction="+productIntroduction);
		Double productSale = Double.parseDouble(request.getParameter("productSale"));
		Integer productStock = Integer.parseInt(request.getParameter("productStock"));
		String productClass = request.getParameter("productClass");
		String productAttribute = request.getParameter("productAttribute");
		String writer = request.getParameter("writer");
		String publishingHouse = request.getParameter("publishingHouse");
		Date shelfTime = new Date();
		ProductBean productBean = new ProductBean(1, shopId, productName, productIntroduction, productSale, 
				productStock, productClass, null, 
				productAttribute, writer, publishingHouse, shelfTime, 
				null, null, null);
		productId = (int) productDAO.addProductMessage(productBean);
		//记录状态
		PageShopProduct pageShopProduct = getPageShopProduct(request);
		request.getSession().setAttribute("PageProductAttribute", pageShopProduct);
		request.getSession().setAttribute("PageProductId", productId);
		request.getSession().setAttribute("PageProductAttributeState", "true");
	}
	
	private void addProductNotForm(HttpServletRequest request){
		Integer productId = (Integer) request.getSession().getAttribute("PageProductId");
		ProductBean productBean = new ProductBean();
		changeDisplayPicture(request, productBean);
		productBean.setProductId(productId);
		productDAO.changeProductForPictureByProductId(productBean);
	}
	
	@Override
	public void addProduct(HttpServletRequest request, HttpServletResponse response) {
		String goal = request.getParameter("goal");
		System.out.println("goal="+goal);
		if(goal.equals("Form")){
			addProductForm(request);
		}
		if(goal.equals("NotForm")){
			addProductNotForm(request);
			try {
				response.sendRedirect("/CommercialCity/Shop/product/ShopProductManage.jsp");
			} catch (Exception e) {}
		}
	}		
}
