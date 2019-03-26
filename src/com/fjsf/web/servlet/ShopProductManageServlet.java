package com.fjsf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjsf.web.service.impl.ShopProductManageServiceImpl;
import com.fjsf.web.service.inter.ShopProductManageServiceInterface;

/**
 * Servlet implementation class ShopProductManageServlet
 */
public class ShopProductManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopProductManageServiceInterface shopProductManageService = new ShopProductManageServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * 显示产品信息
		 * url: /CommercialCity/shopProductManage?action=ShowProductMessage
		 * 商品上架时间：Time ASC(TA)   Time DESC(TD)
		 * 商品价格： Price ASC(PA)	Price DESC(PD)
		 * 商品数量： Quantity ASC(QA) Quantity DESC(QD)
		 * data:{
		 *  	searchValue:value,
		 * 		orderType:value,
		 *  	priceRangeLeft:value,
		 *  	priceRangeRight:value,
		 *  	pageNo:value
		 *  }
		 *  success:{
		 *  	{
  					"pageAttribute" : [{
    				"pageNo" : 1,
    				"pageSize" : 5,
    				"totalProductNumber" : 2,
    				"totalPageNo" : 1,
    				"searchValue" : "吴",
    				"orderType" : "QA",
    				"priceRangeLeft" : null,
    				"priceRangeRight" : null
  				}],
  					"message" : [ {
    				"productId" : 55,
    				"shopId" : 1,
    				"productName" : "吴承恩传",
    				"productIntroduction" : "文学",
    				"productSale" : 32.0,
    				"productStock" : 110,
    				"productClass" : "2",
    				"productShowPicture" : "/CommercialCity/commercialcity/e.jpg",
    				"productAttribute" : "四大名著之一",
    				"writer" : "吴承恩",
    				"publishingHouse" : "华中出版社",
    				"shelfTime" : "2017年05月26日",
    				"productIntroductionPictureOne" : "/CommercialCity/commercialcity/e.jpg",
    				"productIntroductionPictureTwo" : "/CommercialCity/commercialcity/e.jpg",
    				"productIntroductionPictureThree" : "/CommercialCity/commercialcity/e.jpg"
  				}]
			}
			
		 *  }
		 *  
		 *  删除商品信息
		 *  url: /CommercialCity/shopProductManage?action=DeleteProduct
		 *  data:{
		 *  	productId:value,
		 *  	pageNO:value
		 *  	totalProductNumber:value
		 *  }
		 *  success:{
    				"pageNo" : 1,
    				"pageSize" : 5,
    				"totalProductNumber" : 2,
    				"totalPageNo" : 1,
    				"searchValue" : "吴",
    				"orderType" : "QA",
    				"priceRangeLeft" : null,
    				"priceRangeRight" : null
    		}
		 *  
		 *  获取商品的详细信息
		 *  url:/CommercialCity/shopProductManage?action=ShowDetailProductMessage
		 *  data:{
		 *  	productId:value
		 *  }
		 *  success:{
		 *  	"productId" : 55,
    			"shopId" : 1,
    			"productName" : "吴承恩传",
    			"productIntroduction" : "文学",
    			"productSale" : 32.0,
    			"productStock" : 110,
    			"productClass" : "2",
    			"productShowPicture" : "/CommercialCity/commercialcity/e.jpg",
    			"productAttribute" : "四大名著之一",
    			"writer" : "吴承恩",
    			"publishingHouse" : "华中出版社",
    			"shelfTime" : "2017年05月26日",
    			"productIntroductionPictureOne" : "/CommercialCity/commercialcity/e.jpg",
    			"productIntroductionPictureTwo" : "/CommercialCity/commercialcity/e.jpg",
    			"productIntroductionPictureThree" : "/CommercialCity/commercialcity/e.jpg"
		 *  	
		 *  }
		 *  
		 *  修改商品的详细信息(非头像)
		 *  url:/CommercialCity/shopProductManage?action=ChangeProductMessageForm
		 *  data:{
		 *  	productId:value,
		 *  	productName:value,
		 *  	productIntroduction:value,
		 *  	productSale:value,
		 *  	productStock:value,
		 *  	productClass:value,
		 *  	productAttribute:value,
		 *  	writer:value,
		 *  	publishingHouse:value,
		 *  
		 *  	searchValue:value,
		 * 		orderType:value,
		 *  	priceRangeLeft:value,
		 *  	priceRangeRight:value,
		 *  	pageNo:value
		 *  }
		 *  
		 *  修改头像
		 *  f
		 *  url:/CommercialCity/shopProductManage?action=ChangeProductMessageNotForm
		 *  file控件名称
		 *  	productShowPicture
		 *  	productIntroductionPictureOne
		 *  	productIntroductionPictureTwo
		 *  	productIntroductionPictureThree
		 *  
		 *  商品上架()
		 *  url:/CommercialCity/shopProductManage?action=AddProduct&goal=Form 非图片
		 *  data:{
		 *  	productId:value,
		 *  	productName:value,
		 *  	productIntroduction:value,
		 *  	productSale:value,
		 *  	productStock:value,
		 *  	productClass:value,
		 *  	productAttribute:value,
		 *  	writer:value,
		 *  	publishingHouse:value,
		 *  
		 *  	searchValue:value,
		 * 		orderType:value,
		 *  	priceRangeLeft:value,
		 *  	priceRangeRight:value,
		 *  	pageNo:value
		 *  }
		 *  
		 *  url:/CommercialCity/shopProductManage?action=AddProduct&goal=NotForm 图片
		 *  data:{
		 *  	productShowPicture
		 *  	productIntroductionPictureOne
		 *  	productIntroductionPictureTwo
		 *  	productIntroductionPictureThree
		 *  }
		 */
		String action = request.getParameter("action");
		System.out.println("action="+action);
		if(action.equals("ShowProductMessage")){
			shopProductManageService.getListsForProduct(request, response);
		}
		if(action.equals("DeleteProduct")){
			shopProductManageService.deleteProductByProductId(request, response);
		}
		if(action.equals("ShowDetailProductMessage")){
			shopProductManageService.getDetailProductMessage(request, response);
		}
		if(action.equals("ChangeProductMessageForm")){
			shopProductManageService.changeProductMessageForm(request, response);
		}
		if(action.equals("ChangeProductMessageNotForm")){
			shopProductManageService.changeProductPicture(request, response);
		}
		if(action.equals("AddProduct")){
			shopProductManageService.addProduct(request, response);
		}
	}

}
