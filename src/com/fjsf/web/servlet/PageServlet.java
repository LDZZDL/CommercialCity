package com.fjsf.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.ls.LSInput;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fjsf.web.bean.BrowserHistoryBean;
import com.fjsf.web.bean.CommentBean;
import com.fjsf.web.bean.CreditCardBean;
import com.fjsf.web.bean.OrderDetailBean;
import com.fjsf.web.bean.OrderMasterBean;
import com.fjsf.web.bean.ProductBean;
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
import com.fjsf.web.service.impl.ShopperServiceImpl;
import com.fjsf.web.service.inter.ShopperServiceInterface;
import com.fjsf.web.utils.PageShopProduct;
import com.fjsf.web.viewobject.CommentView;
import com.fjsf.web.viewobject.OrderView;
import com.fjsf.web.viewobject.OrderViewWithProduct;


/**
 * Servlet implementation class PageServlet
 */
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ShopperDAO dao = new ShopperDAOImpl();
	CustomerDAO customerDAO = new CustomerDAOImpl();
	ShopperDAO shopperDAO = new ShopperDAOImpl();
	ShopDAO shopDAO = new ShopDAOImpl();
	DeliveryAddressDAO deliveryAddressDAO = new DeliveryAddressDAOImpl();
	ShopperServiceInterface shopperService = new ShopperServiceImpl();
	ProductDAO productDAO = new ProductDAOImpl();
	CreditCardDAO creditCardDAO = new CreditCardDAOImpl();
	ShoppingCartProductDAO shoppingCartProductDAO = new ShoppingCartProductDAOImpl();
	OrderMasterDAO orderMasterDAO = new OrderMasterDAOImpl();
	OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
	BrowserHistoryDAO browserHistoryDAO = new BrowserHistoryDAOImpl();
	CommentDAO commentDAO = new CommentDAOImpl();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	private Double getResultAdd(Double creditCardMoney, Double changeMoney){
		BigDecimal cBigDecimal = new BigDecimal(creditCardMoney);
		BigDecimal mBigDecimal = new BigDecimal(changeMoney);
		cBigDecimal.add(mBigDecimal);
		return cBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	private Double getResultSub(Double creditCardMoney, Double changeMoney){
		BigDecimal cBigDecimal = new BigDecimal(creditCardMoney);
		BigDecimal mBigDecimal = new BigDecimal(changeMoney);
		cBigDecimal.add(mBigDecimal);
		return cBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 商品上架时间：Time ASC(TA)   Time DESC(TD)
		 * 商品价格： Price ASC(PA)	Price DESC(PD)
	     * 商品数量： Quantity ASC(QA) Quantity DESC(QD)
	    
	    */
		
		
		
		Double money = orderMasterDAO.getTodaySaleMoney(1);
		long aInteger = orderMasterDAO.getTodayOrderQuantity(1);
		long bInteger = orderMasterDAO.getTodayProductQuantity(1);
		System.out.println(money);
		System.out.println(aInteger);
		System.out.println(bInteger);
		
		
		/*
		Integer customerId = 1;
		//List<Integer> list1 = browserHistoryDAO.getIndexOfBrowserHistory(customerId);
		List<BrowserHistoryBean> list2 = browserHistoryDAO.getClassOfBrowserHistory(customerId);
		//System.out.println(list1);
		System.out.println(list2);
		*/
		/*
		String message = request.getParameter("sd");
		if(message == null){
			System.out.println("空");
		}
		*/
		/*
		
		Integer shopId = 1;
		String orderMasterStatus = "待付款";
		//long count = orderMasterDAO.countOrderMasterByShopId(shopId, orderMasterStatus);
		//System.out.println(count);
		List<OrderMasterBean> list = orderMasterDAO.getOrderMasterMessageByShopId(shopId, 
				orderMasterStatus, 1, 5);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map.put("message", list);
		System.out.println(list);
		System.out.println(mapper.writeValueAsString(list));
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list));
		*/
		/*
		CommentView commentView = new CommentView();
		List<Integer> listProductId = new ArrayList<>();
		listProductId.add(70);
		listProductId.add(71);
		
		List<Integer> listRate = new ArrayList<>();
		listRate.add(2);
		listRate.add(3);
		
		List<String> listContent = new ArrayList<>();
		listContent.add("这个产品非常好");
		listContent.add("差评，差评");
		commentView.setListContent(listContent);
		commentView.setListRate(listRate);
		commentView.setListProductId(listProductId);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String message = objectMapper.writeValueAsString(commentView);
		System.out.println(message);
		System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(commentView));
		
		CommentView cv = objectMapper.readValue(message, CommentView.class);
		System.out.println(cv);
		*/
		
		//List<CreditCardBean> list = creditCardDAO.getAll();
		//System.out.println(list);
		
		/*
		OrderDetailBean orderDetailBean1 = new OrderDetailBean();
		OrderDetailBean orderDetailBean2 = new OrderDetailBean();
		OrderDetailBean orderDetailBean3 = new OrderDetailBean();
		
		orderDetailBean1.setOrderId(1);
		orderDetailBean1.setProductId(57);
		orderDetailBean1.setQuantity(2);
		
		orderDetailBean2.setOrderId(1);
		orderDetailBean2.setProductId(58);
		orderDetailBean2.setQuantity(3);
		
		orderDetailBean3.setOrderId(1);
		orderDetailBean3.setProductId(59);
		orderDetailBean3.setQuantity(4);
		
		List<OrderDetailBean> list = new ArrayList<>();
		list.add(orderDetailBean1);
		list.add(orderDetailBean2);
		list.add(orderDetailBean3);
		ObjectMapper mapper = new ObjectMapper();
		
		OrderView o1 = new OrderView();
		OrderView o2 = new OrderView();
		o1.setListOrderDetailBean(list);
		o2.setListOrderDetailBean(list);
		List<OrderView> orderViews = new ArrayList<>();
		orderViews.add(o1);
		orderViews.add(o2);
		String message = mapper.writeValueAsString(orderViews);
		System.out.println("华丽的分给线");
		System.out.println(message);
		System.out.println("华丽的分给线");
		List<OrderView> li = mapper.readValue(message, new TypeReference<List<OrderView>>() {});
		for(OrderView ov:li){
			System.out.println(ov);
		}
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		/*
		OrderDetailBean orderDetailBean1 = new OrderDetailBean();
		OrderDetailBean orderDetailBean2 = new OrderDetailBean();
		
		List<OrderDetailBean> listOrderDetailBean = new ArrayList<>();
		orderDetailBean1.setOrderId(1);
		orderDetailBean1.setProductId(20);
		orderDetailBean1.setQuantity(10);
		
		orderDetailBean2.setOrderId(1);
		orderDetailBean2.setProductId(21);
		orderDetailBean2.setQuantity(11);
		listOrderDetailBean.add(orderDetailBean1);
		listOrderDetailBean.add(orderDetailBean2);
		
		List<ProductBean> listProductBean = new ArrayList<>();
		Integer productId = 57;
		ProductBean productBean = new ProductBean();
		productBean.setShopId(1);
		productBean.setShelfTime(new Date());
		productBean.setProductAttribute("中国古典小说");
		productBean.setProductClass("小说");
		productBean.setProductId(productId);
		productBean.setProductIntroduction("中国四大名著之一，许多人喜欢看的书");
		productBean.setProductIntroductionPictureOne("/CommercialCity/commercialcity/lindongze.jpg");
		productBean.setProductIntroductionPictureThree("/CommercialCity/commercialcity/lindongze.jpg");
		productBean.setProductIntroductionPictureTwo("/CommercialCity/commercialcity/lindongze.jpg");
		productBean.setProductName("水浒传");
		productBean.setProductSale(99.99);
		productBean.setProductShowPicture("/CommercialCity/commercialcity/lindongze.jpg");
		productBean.setProductStock(520);
		productBean.setPublishingHouse("清华大学");
		productBean.setWriter("施耐庵");
		listProductBean.add(productBean);
		
		OrderViewWithProduct orderViewWithProduct = new OrderViewWithProduct();
		orderViewWithProduct.setCustomerId(2);
		orderViewWithProduct.setDeliveryAddressId(3);
		orderViewWithProduct.setListOrderDetailBean(listOrderDetailBean);
		orderViewWithProduct.setListProductBean(listProductBean);
		orderViewWithProduct.setOrderId(11);
		orderViewWithProduct.setOrderMasterStatus("未付款");
		orderViewWithProduct.setOrderMasterTime(new Date());
		List<OrderViewWithProduct> list = new ArrayList<>();
		list.add(orderViewWithProduct);
		
		Map<String, List<OrderViewWithProduct>> map = new HashMap<>();
		ObjectMapper objectMapper = new ObjectMapper();
		
		map.put("message", list);
		
		System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map));
		*/
		
		
		/*
		Double priceRangeLeft = 21.00;
		Double priceRangeRight = 100.00;
		Integer pageNo = 8;
		Integer pageSize = 10;
		String searchValue = null;
		String orderType = "TA";
		
		long count = productDAO.countCustomerProductWithCondition(searchValue, orderType, 
			priceRangeLeft, priceRangeRight, pageNo, pageSize);
		
		System.out.println(count);
		*/
		
		/*
		Integer customerId = 1;
		List<OrderMasterBean> lists = orderMasterDAO.getOrderMasterByCustomerId(customerId);
		System.out.println(lists);
		String orderMasterStatus = "订单生成";
		lists = orderMasterDAO.getOrderMasterWithConditon(customerId, orderMasterStatus);
		System.out.println(lists);
		*/
		
		//========================================================//
		/*
		OrderDetailBean orderDetailBean1 = new OrderDetailBean();
		OrderDetailBean orderDetailBean2 = new OrderDetailBean();
		OrderDetailBean orderDetailBean3 = new OrderDetailBean();
		OrderMasterBean orderMasterBean = new OrderMasterBean();
		
		orderMasterBean.setCustomerId(1);
		orderMasterBean.setDeliveryAddressId(1);
		orderMasterBean.setOrderId(1);
		orderMasterBean.setOrderMasterStatus("订单生成");
		orderMasterBean.setOrderMasterTime(new Date());
		
		
		
		orderDetailBean1.setOrderId(1);
		orderDetailBean1.setProductId(20);
		orderDetailBean1.setQuantity(10);
		
		orderDetailBean2.setOrderId(1);
		orderDetailBean2.setProductId(21);
		orderDetailBean2.setQuantity(11);
		
		orderDetailBean3.setOrderId(1);
		orderDetailBean3.setProductId(22);
		orderDetailBean3.setQuantity(18);
		
		List<OrderDetailBean> list = new ArrayList<>();
		list.add(orderDetailBean1);
		list.add(orderDetailBean2);
		list.add(orderDetailBean3);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, List<OrderDetailBean>> map = new HashMap<>();
		map.put("message", list);
		String message = mapper.writeValueAsString(map);
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map));
		
		OrderView o1 = new OrderView();
		OrderView o2 = new OrderView();
		o1.setListOrderDetailBean(list);
		o1.setCustomerId(1);
		o1.setDeliveryAddressId(2);
		o1.setOrderId(2);
		o1.setOrderMasterStatus("sd");
		o2.setListOrderDetailBean(list);
		o2.setCustomerId(21);
		o2.setOrderId(99);
		o2.setDeliveryAddressId(12);
		o2.setOrderMasterStatus("订单生成");
		List<OrderView> orderViews = new ArrayList<>();
		orderViews.add(o1);
		//orderViews.add(o2);
		message = mapper.writeValueAsString(orderViews);
		System.out.println("华丽的分给线");
		System.out.println(message);
		System.out.println("华丽的分给线");
		List<OrderView> li = mapper.readValue(message, new TypeReference<List<OrderView>>() {});
		for(OrderView ov:li){
			System.out.println(ov);
		}
		*/
		/*
		Map<String, List<OrderDetailBean>> listOrderDetailBean = mapper.readValue
				(message, new TypeReference<Map<String, List<Object>>>() {});
		System.out.println(listOrderDetailBean);
		List<OrderDetailBean> list2 = (List<OrderDetailBean>) listOrderDetailBean.get("message");
		for(OrderDetailBean bean:list2){
			System.out.println(bean.getOrderId() + "," +bean.getQuantity() + "," + bean.getProductId());
		}
		*/
		
		
		//========================================================//
		
		
		
		
		
		
		/*
		Integer orderId = 1;
		List<OrderDetailBean> list = orderDetailDAO.getOrderDetailByOrderId(orderId);  
		System.out.println(list);
		*/
		
		
		
		/**
		String orderMasterStatus = "订单生成";
		List<OrderMasterBean > list = orderMasterDAO.getOrderMasterWithConditon(orderMasterStatus);
		System.out.println(list);
		*/
		
		
		
		
		
		
		/*
		Integer orderId = 2;
		orderDetailDAO.deleteOrderDetail(orderId);
		orderMasterDAO.deleteOrderMaster(orderId);
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		Integer customerId = 1;
		List<BrowserHistoryBean> list = browserHistoryDAO.getBrowserHistoryByCustomerId(customerId);
		System.out.println(list);
		*/
		
		/*
		Integer customerId = 1;
		Integer productId = 61;
		browserHistoryDAO.addBrowserHistory(customerId, productId);
		*/
		
		
		
		
		
		
		
		
		
		
		/*
		Integer customerId = 1;
		List<ShoppingCarProduct> list = shoppingCartProductDAO.getShoppingCartProductByCustomerId(customerId);
		
		System.out.println(list);
		*/
		
		
		
		
		
		
		
		
		
		/*
		long orderId = 2;
		Integer productId = 58;
		Integer quantity = 3;
		
		orderDetailDAO.addOrderDetail(orderId, productId, quantity);
		*/
		
		
		
		/*
		Integer customerId = 1;
		Integer deliveryAddressId = 1;
		orderMasterDAO.addOrderMaster(customerId, deliveryAddressId);
		*/
		
		
		
		
		
		
		
		
		
		/*
		Double money = 2300.00;
		Integer customerId = 1;
		boolean flag = creditCardDAO.checkCreditMoney(money, customerId);
		System.out.println(flag);
		*/
		/*
		Integer productId = 61;
		Integer customerId = 1;
		shoppingCartProductDAO.addShoppingCart(productId, customerId);
		*/
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String searchValue = null;
		String orderType = "SVA";
		Double priceRangeLeft = null;
		Double priceRangeRight = null;
		Integer pageNo = 1;
		Integer pageSize = 15;
		List<ProductBean> list = productDAO.customerGetProductWithCondition(searchValue, orderType, priceRangeLeft, priceRangeRight, pageNo, pageSize);
		System.out.println(list);
		System.out.println("============================================");
		System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list));
		*/
		/*
		OrderMasterBean orderMasterBean = new OrderMasterBean();
		orderMasterBean.setCustomerId(1);
		orderMasterBean.setDeliveryAddressId(2);
		orderMasterBean.setOrderId(1);
		orderMasterBean.setOrderMasterStatus("订单运输中");
		orderMasterBean.setOrderMasterTime(new Date());
		
		ObjectMapper mapper = new ObjectMapper();
		String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(orderMasterBean);
		System.out.println(message);
		
		OrderDetailBean orderDetailBean = new OrderDetailBean();
		orderDetailBean.setOrderId(1);
		orderDetailBean.setProductId(1);
		orderDetailBean.setQuantity(2);
		message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(orderDetailBean);
		System.out.println(message);
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		Integer productId = 59;
		Integer quantity = 100;
		productDAO.changeProductStockByProductId(quantity, productId);
		*/
		
		
		/*
		
		Integer productId = 57;
		ProductBean productBean = new ProductBean();
		productBean.setShopId(1);
		productBean.setShelfTime(new Date());
		productBean.setProductAttribute("中国古典小说");
		productBean.setProductClass("小说");
		productBean.setProductId(productId);
		productBean.setProductIntroduction("中国四大名著之一，许多人喜欢看的书");
		productBean.setProductIntroductionPictureOne("/CommercialCity/commercialcity/lindongze.jpg");
		productBean.setProductIntroductionPictureThree("/CommercialCity/commercialcity/lindongze.jpg");
		productBean.setProductIntroductionPictureTwo("/CommercialCity/commercialcity/lindongze.jpg");
		productBean.setProductName("水浒传");
		productBean.setProductSale(99.99);
		productBean.setProductShowPicture("/CommercialCity/commercialcity/lindongze.jpg");
		productBean.setProductStock(520);
		productBean.setPublishingHouse("清华大学");
		productBean.setWriter("施耐庵");
		productDAO.addProductMessage(productBean);
		
		*/
		
		
		
		
		/*
		Integer shopId = 1;
		String searchValue = null;
		String orderType = "TD";
		Double priceRangeLeft = 1.00;
		Double priceRangeRight = null;
		Integer pageNo = 1;
		Integer pageSize = 5;
		List<ProductBean> list =  productDAO.getListsForProductByShopIdAndCondition(shopId, searchValue, orderType, priceRangeLeft, priceRangeRight, pageNo, pageSize);
		System.out.println(list);
		*/
		/*
		System.out.println("enter");
		System.out.println(request.getParameter("name"));
		*/
		/*
		String number = "1234.92;#";
		try {
			Double nu = Double.parseDouble(number);
			System.out.println(nu);
		} catch (Exception e) {
			System.out.println("无法转换");
		}
		Double aDouble = new Double("8.3");
		Double bDouble = new Double("9.0");
		System.out.println(aDouble.compareTo(bDouble));
		System.out.println(bDouble.compareTo(aDouble));
		*/
		
		//CustomerBean customerBean = customerDAO.getCustomerMessageByCustomerId(4);
		//System.out.println(customerBean);
		/*
		List<DeliveryAddressBean> lists = new ArrayList<>();
		lists = deliveryAddressDAO.getDeliveryAddressByCustomerId(1);
		System.out.println(lists);
		lists.get(0).setReceiverAddressFirst("我是爱你的");
		deliveryAddressDAO.changeDeliveryAddressByDeliveryAddressId(lists.get(0));
		*/
		/*
		Integer shopId = 1;
		List<ProductBean> lists = new ArrayList<>();
		//lists = productDAO.getListsForProductByShopIdAndTA(shopId);
		ObjectMapper mapper = new ObjectMapper();
		String temp1 = mapper.writeValueAsString(lists);
		Map<String, List<ProductBean>> map = new HashMap<>();
		map.put("message", lists);
		String temp2 = mapper.writeValueAsString(map);
		System.out.println(temp1);
		System.out.println("华丽的分割线");
		System.out.println(temp2);
		*/
		/*
		Integer shopperId = 1;
		Integer shopId = 1;
		ShopperBean shopperBean = shopperDAO.getShopperByShopperId(shopperId);
		ShopBean shopBean = shopDAO.getShopByShopId(shopId);
		System.out.println(shopperBean);
		System.out.println(shopBean);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(shopBean));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String time = simpleDateFormat.format(shopBean.getOpenDate());
		System.out.println(time);
		*/
		/*
		DeliveryAddressBean bean = new DeliveryAddressBean();
		DeliveryAddressBean bean2 = new DeliveryAddressBean();
		bean.setCustomerId(1);
		bean.setDeliveryAddressId(1);
		bean.setReceiverName("林丹");
		bean.setReceiverTelephone("dsdsdds");
		bean.setReceiverAddress("dsdds");
		
		bean2.setCustomerId(2);
		bean2.setDeliveryAddressId(2);
		bean2.setReceiverName("dsdsxciix");
		bean2.setReceiverTelephone("dsdds");
		bean2.setReceiverAddress("sdlkkl");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, List> map =  new HashMap<String, List>();
		List<Object> lists = new ArrayList<>();
		lists.add(bean);
		lists.add(bean2);
		String goal = mapper.writeValueAsString(lists);
		System.out.println(goal);
		map.put("message", lists);
		String l = mapper.writeValueAsString(map);
		System.out.println(l);
		*/
		//deliveryAddressDAO.changeDeliveryAddressByDeliveryAddressId(bean);
		/*
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 500);
		File tempDirectory = new File("C:\\tempDirectory");
		factory.setRepository(tempDirectory);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(1024 * 1024 * 5);
		String fileName = new String();
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem item:items){
				if(!item.isFormField()){
					fileName = item.getName();
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
					fileName = "C:\\commercialcity\\" + newFileName;
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
		System.out.println(fileName);
		*/
		/*
		Integer customerId = 5;
		String newDisplayPicture = "C:\\commercialcity\\customer.jpg";
		customerDAO.changeDisplayPictureByCustomerId(newDisplayPicture, customerId);
		*/
		/*
		List<DeliveryAddressBean> lists = deliveryAddressDAO.getDeliveryAddressByCustomerId(customerId);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("yes"+mapper.writeValueAsString(lists));
		System.out.println(lists);
		*/
		/*
		 System.out.println("enter");
		Integer shopperId = 1;
		Integer shopId = 1;
		
		ShopperBean shopperBean=shopperDAO.getShopperByShopperId(shopperId);
		CreditCardBean creditCardBean= creditCardDAO.getCreditCardByCreditCardId(shopperBean.getCreditCardId());
		ShopBean shopBean=shopDAO.getShopByShopId(shopId);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String time = simpleDateFormat.format(shopBean.getOpenDate());
		OVB ovb = new OVB(shopBean.getShopId(), shopBean.getShopperId(), shopBean.getShopName(),
				shopBean.getIntroduction(), time,shopBean.getDisplayPicture(), shopBean.getGoodRate());
		ObjectMapper mapper = new ObjectMapper();
		List<Object> lists = new ArrayList<>();
		lists.add(shopperBean);
		lists.add(ovb);
		lists.add(creditCardBean);
		Map<String, List<Object>> map = new HashMap<>();
		map.put("message", lists);
		String message = mapper.writeValueAsString(map);
		System.out.println(message);	
		 */
	}

}
