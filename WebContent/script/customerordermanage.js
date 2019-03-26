// JavaScript Document
$(function()
{
	var order_html="";
	var pageNo=1;
	var orderStatus="WaitPay";
	var orderIdtest=0;//评价传订单编号用
	var productIdtest=0;//评价传产品编号用
	
	$("#customerMarket").click(function()
			{
				window.location.href="/CommercialCity/Customer/CustomerMarket.jsp?loginStatus=1";
			})
			$("#shoppingCart").click(function()
			{
				window.location.href="/CommercialCity/Customer/ShoppingCart.jsp";
			})
			$("#personalMessage").click(function()
			{
				window.location.href="/CommercialCity/Customer/Message/CustomerMessage.jsp";
			})
			$("#shopperLogin").click(function()
			{
				window.open("/CommercialCity/Shop/ShopperLogin.jsp");
			})
			$("#exit").click(function()
			{
				if(confirm("确定退出登录？"))
				{
					$.ajax({  
		                    type: "POST",  
		                    url:"/CommercialCity/customerLogin?action=cancel",
		                    data:{},
		                    dataType:"json",
		                    success:function(data){},
							error: function()
							{
								alert("wrong1");
							}
					})
		            window.location.href="/CommercialCity/Customer/CustomerMarket.jsp";
				}
				return false;
			})
	
	
	loadPageWaitPay();
	
	//订单状态栏
	$("#waitPay").click(function()
	{
		pageNo=1;
		$("#orderStatusBlock li").css("color","#000");
		$("#orderStatusBlock li").css("border-bottom-color","#e8e8e8");
		$("#waitPay").css("color","#FF0000");
		$("#waitPay").css("border-bottom-color","#FF0000");
		orderStatus="WaitPay";
		$(".order").remove();
		loadPageWaitPay();
	})
	$("#waitSend").click(function()
	{
		pageNo=1;
		$("#orderStatusBlock li").css("color","#000");
		$("#orderStatusBlock li").css("border-bottom-color","#e8e8e8");
		$("#waitSend").css("color","#FF0000");
		$("#waitSend").css("border-bottom-color","#FF0000");
		orderStatus="WaitSend";
		$(".order").remove();
		loadPageWaitSend();
	})
	$("#waitConfirm").click(function()
	{
		pageNo=1;
		$("#orderStatusBlock li").css("color","#000");
		$("#orderStatusBlock li").css("border-bottom-color","#e8e8e8");
		$("#waitConfirm").css("color","#FF0000");
		$("#waitConfirm").css("border-bottom-color","#FF0000");
		orderStatus="WaitConfirm";
		$(".order").remove();
		loadPageWaitConfirm();
	})
	$("#waitRate").click(function()
	{
		pageNo=1;
		$("#orderStatusBlock li").css("color","#000");
		$("#orderStatusBlock li").css("border-bottom-color","#e8e8e8");
		$("#waitRate").css("color","#FF0000");
		$("#waitRate").css("border-bottom-color","#FF0000");
		orderStatus="WaitRate";
		$(".order").remove();
		loadPageWaitRate();
	})
	$("#and").click(function()
	{
		pageNo=1;
		$("#orderStatusBlock li").css("color","#000");
		$("#orderStatusBlock li").css("border-bottom-color","#e8e8e8");
		$("#and").css("color","#FF0000");
		$("#and").css("border-bottom-color","#FF0000");
		orderStatus="And";
		$(".order").remove();
		loadPageAnd();
	})
	
	
	//上下翻页
	$(".previousPage").click(function()
	{
		if($(this).parent().find(".pageNo").text()!=1)
		{
			$(".order").remove();
			pageNo=pageNo-1;
			if(orderStatus=="WaitPay")
			{
				loadPageWaitPay();
			}
			else if(orderStatus=="WaitSend")
			{
				loadPageWaitSend();
			}
			else if(orderStatus=="WaitConfirm")
			{
				loadPageWaitConfirm();
			}
			else if(orderStatus=="WaitRate")
			{
				loadPageWaitRate();
			}
			else if(orderStatus=="And")
			{
				loadPageAnd();
			}
		}
	})
	$(".nextPage").click(function()
	{
		if($(this).parent().find(".pageNo").text()!=$(this).parent().find(".totalPageNo").text())
		{
			$(".order").remove();
			pageNo=pageNo+1;
			if(orderStatus=="WaitPay")
			{
				loadPageWaitPay();
			}
			else if(orderStatus=="WaitSend")
			{
				loadPageWaitSend();
			}
			else if(orderStatus=="WaitConfirm")
			{
				loadPageWaitConfirm();
			}
			else if(orderStatus=="WaitRate")
			{
				loadPageWaitRate();
			}
			else if(orderStatus=="And")
			{
				loadPageAnd();
			}
		}
	})
	
	
	
	//评价盒子区
	$("#RcloseBtn").click(function()
	{
		$("#mask").fadeOut("fast");
		$("#rateBox").fadeOut("slow");
	})
	//格式检验
	$("#comment").blur(function()
	{
		var $parent=$(this).parent();
		$("#comment").parent().find(".formtips").remove();
		if(this.value.length>100)
		{
			var errorMsg = '长度超限.';
            $parent.append('<span class="formtips onError">'+errorMsg+'</span>');    
        }
	})
	$("#ratesubmit").click(function()
	{
		$("#comment").trigger('blur');
		var numError=$(".onError").length;
		if(!numError)
		{
			$.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerOrder?action=Rate",
                    data:{pageNo:pageNo,orderId:orderIdtest,productId:productIdtest,content:$("#comment").val(),rate:$("#rateGrade").val()},
                    dataType:"json",
					async:false,
                    success: function(data)
                    {
						pageNo=data.pageNo;
					},
					error: function(XMLHttpRequest, textStatus, errorThrown)
					 {
						//alert("wrong");
	 				 } 
			      })
		    $("#mask").fadeOut("fast");
		    $("#rateBox").fadeOut("slow");
			alert("评论成功！");
			$(".order").remove();
			loadPageWaitRate();
		}
	})
	
	
	
	//加载页面函数区
	function loadPageWaitPay()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerOrder?action=WaitPay",
                    data:{pageNo:pageNo},
                    dataType:"json",
					async:false,
                    success: function(data)
                    {
						var page=data.page;
						$(".pageNo").text(page.pageNo);
						$(".totalPageNo").text(page.totalPageNo);
						var order=data.order;
						for(var i=0;i<order.length;i++)
						{
							order_html="";
							var listQuantity=order[i].listQuantity;
							var shopBean=order[i].shopBean;
							var totalMoney=0;
							var listProductBean=order[i].listProductBean;
							order_html="<div class='order'><div class='orderIdBlock'>订单号：<span class='orderId'>"+order[i].orderId+"</span>店铺：<span class='shopName'>"+shopBean.shopName+"</span><button class='removeOrder'>删除</button><button class='pay'>付款</button></div>";
							for(var j=0;j<listProductBean.length;j++)
							{
								order_html=order_html+"<div class='productMessage'><img src='"+listProductBean[j].productShowPicture+"' class='productImg'><span class='productName'>"+listProductBean[j].productName+"</span><span class='productSale'>¥"+listProductBean[j].productSale+"</span><span class='quantity'>"+listQuantity[j]+"</span><span class='totalPrice'>¥"+(listProductBean[j].productSale*listQuantity[j])+"</span><span class='productStatus'>"+order[i].orderMasterStatus+"</span><div class='operationBlock'></div></div>";
							    totalMoney=totalMoney+(listProductBean[j].productSale*listQuantity[j]);
							}
							order_html=order_html+"</div>";
							$("#orders").append(order_html);
							$(".pay:last").val(totalMoney);
							$(".pay").click(function()
							{
								var address="/CommercialCity/Customer/OrderPay.jsp?orderId="+$(this).parent().find(".orderId").text()+"?totalMoney="+$(this).val();
								window.location.href=address;
							})
						}
						$(".removeOrder").click(function()
						{
							if(confirm("删除订单？"))
							{
								$.ajax({  
	                                       type: "POST",  
	                                       url:"/CommercialCity/customerOrder?action=DO",
	                                       data:{pageNo:pageNo,orderId:$(this).parent().find(".orderId").text()},
	                                       dataType:"json",
						                   async:false,
									       success: function(data)
										   {
											    pageNo=data.pageNo;
												   }
									  })
								alert("删除成功！");
								$(".order").remove();
								loadPageWaitPay();
								return true;
							 }
							 return false;
						})
					},
					error: function(XMLHttpRequest, textStatus, errorThrown)
					 {
						$(".pageNo").text("");
	 					$(".totalPageNo").text("");
	 				 }  
		   })
	}
	
	
	function loadPageWaitSend()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerOrder?action=WaitSend",
                    data:{pageNo:pageNo},
                    dataType:"json",
					async:false,
                    success: function(data)
                    {
						var page=data.page;
						$(".pageNo").text(page.pageNo);
						$(".totalPageNo").text(page.totalPageNo);
						var order=data.order;
						for(var i=0;i<order.length;i++)
						{
							order_html="";
							var listQuantity=order[i].listQuantity;
							var shopBean=order[i].shopBean;
							var listProductBean=order[i].listProductBean;
							order_html="<div class='order'><div class='orderIdBlock'>订单号：<span class='orderId'>"+order[i].orderId+"</span>店铺：<span class='shopName'>"+shopBean.shopName+"</span></div>";
							for(var j=0;j<listProductBean.length;j++)
							{
								order_html=order_html+"<div class='productMessage'><img src='"+listProductBean[j].productShowPicture+"' class='productImg'><span class='productName'>"+listProductBean[j].productName+"</span><span class='productSale'>¥"+listProductBean[j].productSale+"</span><span class='quantity'>"+listQuantity[j]+"</span><span class='totalPrice'>¥"+(listProductBean[j].productSale*listQuantity[j])+"</span><span class='productStatus'>"+order[i].orderMasterStatus+"</span><div class='operationBlock'></div></div>";
							}
							order_html=order_html+"</div>";
							$("#orders").append(order_html);
							
						}
					},
					error: function(XMLHttpRequest, textStatus, errorThrown)
					 {
						$(".pageNo").text("");
	 					$(".totalPageNo").text("");
	 				 }  
		   })
	}
	
	
	function loadPageWaitConfirm()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerOrder?action=WaitConfirm",
                    data:{pageNo:pageNo},
                    dataType:"json",
					async:false,
                    success: function(data)
                    {
						var page=data.page;
						$(".pageNo").text(page.pageNo);
						$(".totalPageNo").text(page.totalPageNo);
						var order=data.order;
						for(var i=0;i<order.length;i++)
						{
							order_html="";
							var listQuantity=order[i].listQuantity;
							var shopBean=order[i].shopBean;
							var listProductBean=order[i].listProductBean;
							order_html="<div class='order'><div class='orderIdBlock'>订单号：<span class='orderId'>"+order[i].orderId+"</span>店铺：<span class='shopName'>"+shopBean.shopName+"</span><button class='confirm'>确认收货</button></div>";
							for(var j=0;j<listProductBean.length;j++)
							{
								order_html=order_html+"<div class='productMessage'><img src='"+listProductBean[j].productShowPicture+"' class='productImg'><span class='productName'>"+listProductBean[j].productName+"</span><span class='productSale'>¥"+listProductBean[j].productSale+"</span><span class='quantity'>"+listQuantity[j]+"</span><span class='totalPrice'>¥"+(listProductBean[j].productSale*listQuantity[j])+"</span><span class='productStatus'>"+order[i].orderMasterStatus+"</span><div class='operationBlock'></div></div>";
							}
							order_html=order_html+"</div>";
							$("#orders").append(order_html);
						}
						$(".confirm").click(function()
						{
							if(confirm("确认收货？"))
							{
								$.ajax({  
	                                         type: "POST",  
	                                         url:"/CommercialCity/customerOrder?action=CO",
	                                         data:{pageNo:pageNo,orderId:$(this).parent().find(".orderId").text()},
	                                         dataType:"json",
						                     async:false,
											 success: function(data)
											 {
												  pageNo=data.pageNo;
											 }
									  })										
								$(".order").remove();
								loadPageWaitConfirm();
							}
							return false;
						})
					},
					error: function(XMLHttpRequest, textStatus, errorThrown)
					 {
						$(".pageNo").text("");
	 					$(".totalPageNo").text("");
	 				 }  
		   })
	}
	
	
	
	function loadPageWaitRate()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerOrder?action=WaitRate",
                    data:{pageNo:pageNo},
                    dataType:"json",
					async:false,
                    success: function(data)
                    {
						var page=data.page;
						$(".pageNo").text(page.pageNo);
						$(".totalPageNo").text(page.totalPageNo);
						var order=data.order;
						for(var i=0;i<order.length;i++)
						{
							order_html="";
							var listQuantity=order[i].listQuantity;
							var shopBean=order[i].shopBean;
							var listProductBean=order[i].listProductBean;
							order_html="<div class='order'><div class='orderIdBlock'>订单号：<span class='orderId'>"+order[i].orderId+"</span>店铺：<span class='shopName'>"+shopBean.shopName+"</span></div>";
							for(var j=0;j<listProductBean.length;j++)
							{
								order_html=order_html+"<div class='productMessage'><img src='"+listProductBean[j].productShowPicture+"' class='productImg'><span class='productName'>"+listProductBean[j].productName+"</span><span class='productSale'>¥"+listProductBean[j].productSale+"</span><span class='quantity'>"+listQuantity[j]+"</span><span class='totalPrice'>¥"+(listProductBean[j].productSale*listQuantity[j])+"</span><span class='productStatus'>"+order[i].orderMasterStatus+"</span><div class='operationBlock'><button class='rate' value='"+listProductBean[j].productId+"'>评价</button></div></div>";
							}
							order_html=order_html+"</div>";
							$("#orders").append(order_html);
						}
						$(".rate").click(function()
						{
							$("#mask").fadeIn("slow");
			                $("#rateBox").fadeIn("slow");
							productIdtest=$(this).val();
							orderIdtest=$(this).parent().parent().parent().find(".orderId").text();
						})
					},
					error: function(XMLHttpRequest, textStatus, errorThrown)
					 {
						$(".pageNo").text("");
	 					$(".totalPageNo").text("");
	 				 }  
		   })
	}
	
	
	function loadPageAnd()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerOrder?action=End",
                    data:{pageNo:pageNo},
                    dataType:"json",
					async:false,
                    success: function(data)
                    {
	                   
						var page=data.page;
						$(".pageNo").text(page.pageNo);
						$(".totalPageNo").text(page.totalPageNo);
						var order=data.order;
						for(var i=0;i<order.length;i++)
						{
							order_html="";
							var listQuantity=order[i].listQuantity;
							var shopBean=order[i].shopBean;
							var listProductBean=order[i].listProductBean;
							order_html="<div class='order'><div class='orderIdBlock'>订单号：<span class='orderId'>"+order[i].orderId+"</span>店铺：<span class='shopName'>"+shopBean.shopName+"</span></div>";
							for(var j=0;j<listProductBean.length;j++)
							{
								order_html=order_html+"<div class='productMessage'><img src='"+listProductBean[j].productShowPicture+"' class='productImg'><span class='productName'>"+listProductBean[j].productName+"</span><span class='productSale'>¥"+listProductBean[j].productSale+"</span><span class='quantity'>"+listQuantity[j]+"</span><span class='totalPrice'>¥"+(listProductBean[j].productSale*listQuantity[j])+"</span><span class='productStatus'>"+order[i].orderMasterStatus+"</span><div class='operationBlock'></div></div>";
							}
							order_html=order_html+"</div>";
							$("#orders").append(order_html);
						}
					},
					error: function(XMLHttpRequest, textStatus, errorThrown)
					 {
						alert("end1");
	 					 $(".pageNo").text("");
	 					 $(".totalPageNo").text("");
	 				 }  
		   })
	}
	
	
	
	
	
	
	
})