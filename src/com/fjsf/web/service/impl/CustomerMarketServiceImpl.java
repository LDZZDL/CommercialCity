package com.fjsf.web.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fjsf.web.bean.BrowserHistoryBean;
import com.fjsf.web.bean.CommentBean;
import com.fjsf.web.bean.CreditCardBean;
import com.fjsf.web.bean.CustomerBean;
import com.fjsf.web.bean.DeliveryAddressBean;
import com.fjsf.web.bean.OrderDetailBean;
import com.fjsf.web.bean.ProductBean;
import com.fjsf.web.bean.ShopBean;
import com.fjsf.web.dao.BrowserHistoryDAO;
import com.fjsf.web.dao.CommentDAO;
import com.fjsf.web.dao.CreditCardDAO;
import com.fjsf.web.dao.CustomerDAO;
import com.fjsf.web.dao.DeliveryAddressDAO;
import com.fjsf.web.dao.OrderDetailDAO;
import com.fjsf.web.dao.OrderMasterDAO;
import com.fjsf.web.dao.ProductDAO;
import com.fjsf.web.dao.ShopDAO;
import com.fjsf.web.dao.ShopperDAO;
import com.fjsf.web.dao.ShoppingCartProductDAO;
import com.fjsf.web.dao.impl.BrowserHistoryDAOImpl;
import com.fjsf.web.dao.impl.CommentDAOImpl;
import com.fjsf.web.dao.impl.CreditCardDAOImpl;
import com.fjsf.web.dao.impl.CustomerDAOImpl;
import com.fjsf.web.dao.impl.DeliveryAddressDAOImpl;
import com.fjsf.web.dao.impl.OrderDetailDAOImpl;
import com.fjsf.web.dao.impl.OrderMasterDAOImpl;
import com.fjsf.web.dao.impl.ProductDAOImpl;
import com.fjsf.web.dao.impl.ShopDAOImpl;
import com.fjsf.web.dao.impl.ShopperDAOImpl;
import com.fjsf.web.dao.impl.ShoppingCartProductDAOImpl;
import com.fjsf.web.service.inter.CustomerMarketServiceInterface;
import com.fjsf.web.utils.BigDecimalUtils;
import com.fjsf.web.utils.Page;
import com.fjsf.web.viewobject.CustomerSearchProduct;
import com.fjsf.web.viewobject.OrderView;
import com.fjsf.web.viewobject.OrderViewWithProduct;



public class CustomerMarketServiceImpl implements CustomerMarketServiceInterface {

	private ProductDAO productDAO = new ProductDAOImpl();
	private ShoppingCartProductDAO shoppingCartProductDAO = new ShoppingCartProductDAOImpl();
	private CreditCardDAO creditCardDAO = new CreditCardDAOImpl();
	private CustomerDAO customerDAO = new CustomerDAOImpl();
	private OrderMasterDAO orderMasterDAO = new OrderMasterDAOImpl();
	private OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
	private DeliveryAddressDAO deliveryAddressDAO = new DeliveryAddressDAOImpl();
	private ShopDAO shopDAO = new ShopDAOImpl();
	private ShopperDAO shopperDAO = new ShopperDAOImpl();
	private CommentDAO commentDAO = new CommentDAOImpl();
	private BrowserHistoryDAO browserHistoryDAO = new BrowserHistoryDAOImpl();
	
	private List<ProductBean> getRankingList(){
		List<ProductBean> list = new ArrayList<>();
		String searchValue = null;
		String orderType = "SVD";
		Double priceRangeLeft = null;
		Double priceRangeRight = null;
		Integer pageNo = 1;
		Integer pageSize = 10;
		list = productDAO.customerGetProductWithCondition(searchValue, orderType, priceRangeLeft, priceRangeRight, pageNo, pageSize);
		return list;
	}
	
	private List<ProductBean> getRecentProduct(){
		List<ProductBean> list = new ArrayList<>();
		list = productDAO.getRecentProduct();
		System.out.println("大小"+list.size());
		return list;
	}
	
	private List<ProductBean> getInterestedProduct(Integer customerId){
		List<ProductBean> list = new ArrayList<>();
		List<BrowserHistoryBean> listBrowserHistory = new ArrayList<>();
		List<String> listProductClass = new ArrayList<>();
		if(customerId != null){
			listBrowserHistory = browserHistoryDAO.getClassOfBrowserHistory(customerId);
			if(listBrowserHistory.size() < 3){
				for(BrowserHistoryBean browserHistoryBean : listBrowserHistory){
					listProductClass.add(
							productDAO.getProductDetailMessage(
							browserHistoryBean.getProductId()).getProductClass());
				}
			}else{
				for(int i = 0; i < 3; i ++ ){
					listProductClass.add(
							productDAO.getProductDetailMessage(
							listBrowserHistory.get(i).getProductId()).getProductClass());
				}
			}
		}
		else{
			System.out.println("无状态");
			listProductClass.add("小说");
			//listProductClass.add("文艺");
		}
		list = productDAO.getInterestedProduct(listProductClass);
		return list;
	}
	
	
	
	@Override
	public void getMarketMessage(HttpServletRequest request, HttpServletResponse response) {
		List<ProductBean> listRankingList = new ArrayList<>();
		List<ProductBean> listRecentProduct = new ArrayList<>();
		List<ProductBean> listInterestedProduct = new ArrayList<>();
		Integer customerId = (Integer) request.getSession().getAttribute("CustomerLoginCustomerId");
		Map<String, List<ProductBean>> map = new HashMap<>();
		ObjectMapper objectMapper = new ObjectMapper();
		listRankingList = getRankingList();
		listRecentProduct = getRecentProduct();
		System.out.println(listRecentProduct.size());
		System.out.println(listRecentProduct);
		System.out.println("=================");
		listInterestedProduct = getInterestedProduct(customerId);
		map.put("listRankingList", listRankingList);
		map.put("listRecentProduct", listRecentProduct);
		map.put("listInterestedProduct", listInterestedProduct);
		
		//=================================================//
		List<ProductBean> listShowProduct = new ArrayList<>();
		Integer a = 88;
		Integer b = 100;
		Integer c = 99;
		Integer d = 98;
		listShowProduct.add(productDAO.getProductDetailMessage(a));
		listShowProduct.add(productDAO.getProductDetailMessage(b));
		listShowProduct.add(productDAO.getProductDetailMessage(c));
		listShowProduct.add(productDAO.getProductDetailMessage(d));
		map.put("showproduct", listShowProduct);
		//=====================================================//
		try {
			String message = objectMapper.writeValueAsString(map);
			response.getWriter().println(message);
		} catch (Exception e) {}
	}

	private com.fjsf.web.viewobject.Page getCommentPage(){
		com.fjsf.web.viewobject.Page page = new com.fjsf.web.viewobject.Page();
		return null;
	}
	
	@Override
	public void getDetailProductMessage(HttpServletRequest request, HttpServletResponse response) {
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		
		Integer customerId = (Integer) request.getSession().getAttribute("CustomerLoginCustomerId");
		if(customerId != null){
			browserHistoryDAO.addBrowserHistory(customerId, productId, new Date());
		}
		
		List<CommentBean> listComment = commentDAO.showCommentMessageWithCondition(productId, 1, 5);
		List<CustomerBean> listCustomer = new ArrayList<>();
		for(CommentBean commentBean:listComment){
			listCustomer.add(customerDAO.getCustomerMessageByCustomerId(commentBean.getCustomerId()));
		}
		
		ProductBean productBean = productDAO.getProductDetailMessage(productId);
		Integer shopId = productDAO.getShopIdByProductId(productId);
		ShopBean shopBean = shopDAO.getShopByShopId(shopId);
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map.put("product", productBean);
		map.put("shop", shopBean);
		//================================================//
		map.put("comment", listComment);
		map.put("customer", listCustomer);
		com.fjsf.web.viewobject.Page page = getProductComment(request);
		map.put("page", page);
		//================================================//
		try {
			String message = objectMapper.writeValueAsString(map);
			response.getWriter().println(message);
			System.out.println(message);
			System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map));
		} catch (Exception e) {}
	}
	/*
	private Page getCustomerPageProduct(HttpServletRequest request, HttpServletResponse response){
		Page pageShopProduct = new Page();
		pageShopProduct.setSearchValue(request.getParameter("searchValue"));
		pageShopProduct.setOrderType(request.getParameter("orderType"));
		Double priceRangeLeft = null; 
		Double priceRangeRight = null;
		try{
			priceRangeLeft = Double.parseDouble(request.getParameter("priceRangeLeft"));
		}catch (Exception e) {}
		try {
			priceRangeRight = Double.parseDouble(request.getParameter("priceRangeRight"));
		} catch (Exception e) {}
		pageShopProduct.setPriceRangeLeft(priceRangeLeft);
		pageShopProduct.setPriceRangeRight(priceRangeRight);
		pageShopProduct.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		pageShopProduct.setPageSize(8);
		long totalProductNumber = productDAO.countCustomerProductWithCondition(pageShopProduct.getSearchValue(), 
				pageShopProduct.getOrderType(), 
				pageShopProduct.getPriceRangeLeft(), 
				pageShopProduct.getPriceRangeRight(), 
				pageShopProduct.getPageNo(), 
				pageShopProduct.getPageSize());
		long totalPageNo = (totalProductNumber-1)/pageShopProduct.getPageSize() + 1;
		pageShopProduct.setTotalPageNo(totalPageNo);
		pageShopProduct.setTotalProductNumber(totalProductNumber);
		return pageShopProduct;
	}
	
	
	@Override
	public void getSearchProductMessage(HttpServletRequest request, HttpServletResponse response)  {
		Page pageShopProduct = getCustomerPageProduct(request, response);
		List<Object> listPageShopProduct = new ArrayList<>();
		listPageShopProduct.add(pageShopProduct);
		List<ProductBean> list = new ArrayList<>();
		list = productDAO.customerGetProductWithCondition(pageShopProduct.getSearchValue(), 
				pageShopProduct.getOrderType(), 
				pageShopProduct.getPriceRangeLeft(), 
				pageShopProduct.getPriceRangeRight(), 
				pageShopProduct.getPageNo(), 
				pageShopProduct.getPageSize());
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, List<Object>> map = new HashMap<>();
		map.put("page", listPageShopProduct);
		try {
			List<Object> searchMessage = new ArrayList<>();
			searchMessage.add(pageShopProduct);
			for(ProductBean productBean:list){
				searchMessage.add(productBean);
			}
			map.put("product", searchMessage);
			String message = objectMapper.writeValueAsString(map);
			response.getWriter().println(message);
			System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map));
		} catch (Exception e) {}
	}
	*/
	private CustomerSearchProduct getCustomerPageProduct(HttpServletRequest request, HttpServletResponse response){
		CustomerSearchProduct pageShopProduct = new CustomerSearchProduct();
		pageShopProduct.setSearchValue(request.getParameter("searchValue"));
		pageShopProduct.setOrderType(request.getParameter("orderType"));
		pageShopProduct.setSearchClass(request.getParameter("searchClass"));
		
		Double priceRangeLeft = null; 
		Double priceRangeRight = null;
		try{
			priceRangeLeft = Double.parseDouble(request.getParameter("priceRangeLeft"));
		}catch (Exception e) {}
		try {
			priceRangeRight = Double.parseDouble(request.getParameter("priceRangeRight"));
		} catch (Exception e) {}
		pageShopProduct.setPriceRangeLeft(priceRangeLeft);
		pageShopProduct.setPriceRangeRight(priceRangeRight);
		pageShopProduct.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		pageShopProduct.setPageSize(8);
		long totalProductNumber = productDAO.countCustomerProductWithCondition(
				pageShopProduct.getSearchValue(), 
				pageShopProduct.getOrderType(), 
				pageShopProduct.getSearchClass(), 
				pageShopProduct.getPriceRangeLeft(), 
				pageShopProduct.getPriceRangeRight(), 
				pageShopProduct.getPageNo(), 
				pageShopProduct.getPageSize());
		if(totalProductNumber == 0){
			pageShopProduct.setTotalPageNo(0);
			pageShopProduct.setTotalProductNumber(0);
		}else{
			long totalPageNo = (totalProductNumber-1)/pageShopProduct.getPageSize() + 1;
			pageShopProduct.setTotalPageNo(totalPageNo);
			pageShopProduct.setTotalProductNumber(totalProductNumber);
		}
		return pageShopProduct;
	}
	
	
	@Override
	public void getSearchProductMessage(HttpServletRequest request, HttpServletResponse response)  {
		CustomerSearchProduct pageShopProduct = getCustomerPageProduct(request, response);
		List<Object> listPageShopProduct = new ArrayList<>();
		listPageShopProduct.add(pageShopProduct);
		List<ProductBean> list = new ArrayList<>();
		list = productDAO.customerGetProductWithCondition(pageShopProduct.getSearchValue(), 
				pageShopProduct.getOrderType(), 
				pageShopProduct.getSearchClass(),
				pageShopProduct.getPriceRangeLeft(), 
				pageShopProduct.getPriceRangeRight(), 
				pageShopProduct.getPageNo(), 
				pageShopProduct.getPageSize());
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, List<Object>> map = new HashMap<>();
		map.put("page", listPageShopProduct);
		try {
			List<Object> searchMessage = new ArrayList<>();
			searchMessage.add(pageShopProduct);
			for(ProductBean productBean:list){
				searchMessage.add(productBean);
			}
			map.put("product", searchMessage);
			String message = objectMapper.writeValueAsString(map);
			response.getWriter().println(message);
		} catch (Exception e) {}
	}
	
	
	@Override
	public void addShoppingCart(HttpServletRequest request, HttpServletResponse response) {
		Integer customerId = (Integer) request.getSession().getAttribute("CustomerLoginCustomerId");
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		shoppingCartProductDAO.addShoppingCart(productId, customerId, quantity);
		try {
			response.getWriter().println("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	@Override
	public void confirmOrder(HttpServletRequest request, HttpServletResponse response) {
		Integer customerId = (Integer) request.getSession().getAttribute("CustomerLoginCustomerId");
		String message = request.getParameter("message");
		ObjectMapper mapper = new ObjectMapper();
		List<OrderViewWithProduct> listOrderViewWithProduct = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		try {
			List<OrderView> listOrderView = mapper.readValue(message, new TypeReference<List<OrderView>>() {});
			for(OrderView orderView : listOrderView){
				OrderViewWithProduct orderViewWithProduct = new OrderViewWithProduct();
				OrderDetailBean orderDetail = orderView.getListOrderDetailBean().get(0);
				Integer shopId = productDAO.getShopIdByProductId(orderDetail.getProductId());
				ShopBean shopBean = shopDAO.getShopByShopId(shopId);
				orderViewWithProduct.setShopBean(shopBean);
				orderViewWithProduct.setListOrderDetailBean(orderView.getListOrderDetailBean());
				List<ProductBean> listProduct = new ArrayList<>();
				for(OrderDetailBean orderDetailBean:orderView.getListOrderDetailBean()){
					listProduct.add(productDAO.getProductDetailMessage(orderDetailBean.getProductId()));
				}
				orderViewWithProduct.setListProductBean(listProduct);
				listOrderViewWithProduct.add(orderViewWithProduct);
			}
			map.put("message", listOrderViewWithProduct);
			List<DeliveryAddressBean> listDeliveryAddress = deliveryAddressDAO.getDeliveryAddressByCustomerId(customerId);
			map.put("delivery", listDeliveryAddress);
			request.getSession().setAttribute("OrderConfirm", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getConfirmOrderMessage(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = (Map<String, Object>) request.getSession().getAttribute("OrderConfirm");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String message = objectMapper.writeValueAsString(map);
			response.getWriter().println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void deleteShoppingCartProduct(List<OrderViewWithProduct> orderViewWithProducts, Integer customerId) {
		for(OrderViewWithProduct orderViewWithProduct: orderViewWithProducts){
			List<ProductBean> listProduct = orderViewWithProduct.getListProductBean();
			for(ProductBean productBean:listProduct){
				shoppingCartProductDAO.deleteShoppingCartProductByCustomerIdAndProductId(customerId, 
						productBean.getProductId());
			}
		}
	}
	
	@Override
	public void createOrder(HttpServletRequest request, HttpServletResponse response) {
		Integer customerId = (Integer) request.getSession().getAttribute("CustomerLoginCustomerId");
		Integer deliveryAddressId = Integer.parseInt(request.getParameter("deliveryAddressId"));
		Map<String, Object> map = (Map<String, Object>) request.getSession().getAttribute("OrderConfirm");
		List<OrderViewWithProduct> listsOrderViewWithProduct = (List<OrderViewWithProduct>) map.get("message");
		
		String shoppingcartflag = request.getParameter("shoppingcartflag");
		if(shoppingcartflag != null){
			if(shoppingcartflag.equals("true")){
				deleteShoppingCartProduct(listsOrderViewWithProduct, customerId);
			}
		}
		
		Double allOrderMoney = new Double("0.00");
		int k = 0;
		for(OrderViewWithProduct orderViewWithProduct: listsOrderViewWithProduct){
			orderViewWithProduct.setCustomerId(customerId);
			orderViewWithProduct.setDeliveryAddressId(deliveryAddressId);
			Integer orderId = (int) orderMasterDAO.addOrderMaster(customerId, deliveryAddressId);
			listsOrderViewWithProduct.get(k).setDeliveryAddressId(deliveryAddressId);
			listsOrderViewWithProduct.get(k).setOrderId(orderId);
			k = k + 1;
			orderViewWithProduct.setOrderId(orderId);
			List<Integer> listProduct = new ArrayList<>();
			for(OrderDetailBean orderDetailBean:orderViewWithProduct.getListOrderDetailBean()){
				orderDetailDAO.addOrderDetail(orderId, orderDetailBean.getProductId(), orderDetailBean.getQuantity());
				listProduct.add(orderDetailBean.getQuantity());
			}
			Double orderTotalMoney = new Double("0.00");
			int i = 0;
			for(ProductBean productBean:orderViewWithProduct.getListProductBean()){
				Double money = BigDecimalUtils.getResultMul(productBean.getProductSale(), 
						listProduct.get(i));
				orderTotalMoney = BigDecimalUtils.getResultAdd(orderTotalMoney, money);
				i ++;
			}
			allOrderMoney = BigDecimalUtils.getResultAdd(allOrderMoney, orderTotalMoney);
		}
		map.put("message", listsOrderViewWithProduct);
		request.getSession().setAttribute("OrderConfirm", map);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map));
			System.out.println("需要的金钱="+allOrderMoney);
			response.getWriter().println(allOrderMoney);
		} catch (Exception e) {}
	}

	@Override
	public boolean checkCustomerCreditCardPassword(HttpServletRequest request, HttpServletResponse response) {
		Integer customerId = (Integer) request.getSession().getAttribute("CustomerLoginCustomerId");
		Integer creditCardId = customerDAO.getCreditCardIdByCustomerId(customerId);
		CreditCardBean creditCardBean = creditCardDAO.getCreditCardByCreditCardId(creditCardId);
		String password = request.getParameter("password");
		String message = new String();
		if(creditCardBean.getCreditPassword().equals(password)){
			message = "{\"status\":\"true\",\"message\":\"支付密码正确\"}";
			boolean flag = checkCustomerPay(request, response);
			if(flag == true){
				return true;
			}
			return false;
		}else{
			message = "{\"status\":\"false\",\"message\":\"支付密码错误\"}";
		}
		try {
			System.out.println(message);
			response.getWriter().println(message);
		} catch (Exception e) {}
		return false;
	}
	
	@Override
	public boolean checkCustomerPay(HttpServletRequest request, HttpServletResponse response) {
		Integer customerId = (Integer) request.getSession().getAttribute("CustomerLoginCustomerId");
		Double money = Double.parseDouble(request.getParameter("totalMoney"));
		boolean flag = creditCardDAO.checkCreditMoney(money, customerId);
		String message = new String();
		if(flag == true){
			message = "{\"status\":\"true\",\"message\":\"支付金额足够\"}";
			return true;
		}else{
			message = "{\"status\":\"false\",\"message\":\"支付金额不足\"}";
			try {
				System.out.println(message);
				response.getWriter().println(message);
				return false;
			} catch (Exception e) {}
		}
		return false;
	}
	
	private void payOrder(HttpServletRequest request, HttpServletResponse response){
		Integer customerId = (Integer) request.getSession().getAttribute("CustomerLoginCustomerId");
		Integer payOrderId = Integer.parseInt(request.getParameter("orderId"));
		Integer customerCreditCardId = customerDAO.getCreditCardIdByCustomerId(customerId);
		List<OrderDetailBean> listOrderDetailBean = orderDetailDAO.getOrderDetailByOrderId(payOrderId);
		Integer shopId = productDAO.getShopIdByProductId(listOrderDetailBean.get(0).getProductId());
		Integer shopperId = shopDAO.getShopperIdByShopId(shopId);
		Integer shopCreditCardId = shopperDAO.getCreditCardIdByShopperId(shopperId);
		List<ProductBean> listProductBean = new ArrayList<>();
		for(OrderDetailBean orderDetailBean : listOrderDetailBean){
			ProductBean productBean = productDAO.getProductDetailMessage
					(orderDetailBean.getProductId());
			listProductBean.add(productBean);
			productDAO.changeProductStockByProductId(orderDetailBean.getQuantity(), orderDetailBean.getProductId());

			creditCardDAO.customerPayMoney(
					BigDecimalUtils.getResultMul(productBean.getProductSale(), orderDetailBean.getQuantity()), 
					customerCreditCardId);
	
			creditCardDAO.shopReceiveMoney( 
					BigDecimalUtils.getResultMul(productBean.getProductSale(), orderDetailBean.getQuantity()),
					shopCreditCardId);
		}
		orderMasterDAO.changeorderMasterStatusByOrderId("待发货", payOrderId);
	}
	
	@Override
	public void customerPay(HttpServletRequest request, HttpServletResponse response) {
		boolean flag = checkCustomerCreditCardPassword(request, response);
		if(flag == false){
			return ;
		}
		String payOrderId = request.getParameter("orderId");
		if(payOrderId != null){
			payOrder(request, response);
			return;
		}
		Integer customerId = (Integer) request.getSession().getAttribute("CustomerLoginCustomerId");
		Map<String, Object> map = (Map<String, Object>) request.getSession().getAttribute("OrderConfirm");
		List<OrderViewWithProduct> listsOrderViewWithProduct = (List<OrderViewWithProduct>) map.get("message");
		Integer customerCreditId = customerDAO.getCreditCardIdByCustomerId(customerId);
		List<Integer> listCreditCardId = new ArrayList<>();
		List<Double> listOrderMoney = new ArrayList<>();
		for(OrderViewWithProduct orderViewWithProduct:listsOrderViewWithProduct){
			Integer productId = orderViewWithProduct.getListOrderDetailBean().get(0).getProductId();
			Integer shopId = productDAO.getShopIdByProductId(productId);
			Integer shopperId = shopDAO.getShopperIdByShopId(shopId);
			Integer creditCardId = shopperDAO.getCreditCardIdByShopperId(shopperId);
			listCreditCardId.add(creditCardId);
			Double orderMoney = new Double("0.0");
			List<OrderDetailBean> listOrderDetailBean = orderViewWithProduct.getListOrderDetailBean();
			List<ProductBean> listProductBean = orderViewWithProduct.getListProductBean();
			for(int i = 0; i < listOrderDetailBean.size(); i++){
				Double money = BigDecimalUtils.getResultMul(listProductBean.get(i).getProductSale(), 
						listOrderDetailBean.get(i).getQuantity());
				orderMoney = BigDecimalUtils.getResultAdd(orderMoney, money);
			}
			listOrderMoney.add(orderMoney);
		}
		System.out.println(listOrderMoney);
		System.out.println(listCreditCardId);
		for(int i = 0;i < listCreditCardId.size();i++){
			System.out.println("订单花费的钱数="+listOrderMoney.get(i));
			creditCardDAO.customerPayMoney(listOrderMoney.get(i), customerCreditId);
			creditCardDAO.shopReceiveMoney(listOrderMoney.get(i), listCreditCardId.get(i));
			for(OrderDetailBean orderDetailBean : listsOrderViewWithProduct.get(i).getListOrderDetailBean()){
				productDAO.changeProductStockByProductId(orderDetailBean.getQuantity(), orderDetailBean.getProductId());
			}
			orderMasterDAO.changeorderMasterStatusByOrderId("待发货", listsOrderViewWithProduct.get(i).getOrderId());
		}
		//返回信息
		try {
			response.getWriter().println("{\"status\":\"true\",\"message\":\"购买成功\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private com.fjsf.web.viewobject.Page getProductComment(HttpServletRequest request){
		com.fjsf.web.viewobject.Page page = new com.fjsf.web.viewobject.Page();
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		String pageNo = request.getParameter("pageNo");
		if(pageNo != null){
			page.setPageNo(Integer.parseInt(pageNo));
		}else{
			page.setPageNo(1);
		}
		Integer totalNumber = (int) commentDAO.countCommentByProductId(productId);
		page.setTotalNumber(totalNumber);
		if(page.getTotalNumber() == 0){
			page.setTotalPageNo(0);
			page.setPageNo(0);
		}else{
			page.setTotalPageNo((page.getTotalNumber()-1)/page.getPageSize()+1);
			if(page.getPageNo() > page.getTotalPageNo()){
				page.setPageNo(page.getTotalPageNo());
			}
		}
		return page;
	}
	
	@Override
	public void getProductComment(HttpServletRequest request, HttpServletResponse response) {
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		com.fjsf.web.viewobject.Page page = getProductComment(request);
		List<CommentBean> listComment = commentDAO.showCommentMessageWithCondition
				(productId, page.getPageNo(), page.getPageSize());
		List<CustomerBean> listCustomer = new ArrayList<>();
		for(CommentBean commentBean:listComment){
			listCustomer.add(customerDAO.getCustomerMessageByCustomerId(commentBean.getCustomerId()));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("Page", page);
		map.put("Comment", listComment);
		map.put("customer", listCustomer);
		ObjectMapper objectMapper = new ObjectMapper();
		String message = new String();
		try {
			message = objectMapper.writeValueAsString(map);
			System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		try {
			response.getWriter().println(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
