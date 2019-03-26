// JavaScript Document
$(function()
{
	var order_html="";
	var pageNo=1;
	var orderStatus="WaitSend";
	
	loadPageWaitSend();
	
	//订单状态栏
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
	
	
	
	
	
	
	
	//加载页面函数区
	function loadPageWaitSend()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/shopOrder?action=SSO&goal=WaitSend",
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
							var orderMasterBean=order[i].orderMasterBean;
							var listProductBean=order[i].listProductBean;
							order_html="<div class='order'><div class='orderIdBlock'>订单号：<span class='orderId'>"+orderMasterBean.orderId+"</span><button class='send'>确认发货</button></div>";
							//alert(order[i].orderId);
							for(var j=0;j<listProductBean.length;j++)
							{
								order_html=order_html+"<div class='productMessage'><img src='"+listProductBean[j].productShowPicture+"' class='productImg'><span class='productName'>"+listProductBean[j].productName+"</span><span class='productSale'>¥"+listProductBean[j].productSale+"</span><span class='quantity'>"+listQuantity[j]+"</span><span class='totalPrice'>¥"+(listProductBean[j].productSale*listQuantity[j])+"</span><span class='productStatus'>"+orderMasterBean.orderMasterStatus+"</span><div class='operationBlock'></div></div>";
							}
							order_html=order_html+"</div>";
							$("#orders").append(order_html);
							
						}
						$(".send").click(function()
						{
							if(confirm("确认已发货？"))
						    {
								$.ajax({  
                                           type: "POST",  
                                           url:"/CommercialCity/shopOrder?action=SCO",
                                           data:{pageNo:pageNo,orderId:$(this).parent().find(".orderId").text()},
                                           dataType:"json",
					                       async:false,
										   success: function(data)
										   {
											    pageNo=data.pageNo;
										   },
error: function(XMLHttpRequest, textStatus, errorThrown)
{
     alert("wrong");
 } 
									   })										
								$(".order").remove();
								loadPageWaitSend();
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
	
	
	function loadPageWaitConfirm()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/shopOrder?action=SSO&goal=WaitConfirm",
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
							var orderMasterBean=order[i].orderMasterBean;
							var listProductBean=order[i].listProductBean;
							order_html="<div class='order'><div class='orderIdBlock'>订单号：<span class='orderId'>"+orderMasterBean.orderId+"</span></div>";
							for(var j=0;j<listProductBean.length;j++)
							{
								order_html=order_html+"<div class='productMessage'><img src='"+listProductBean[j].productShowPicture+"' class='productImg'><span class='productName'>"+listProductBean[j].productName+"</span><span class='productSale'>¥"+listProductBean[j].productSale+"</span><span class='quantity'>"+listQuantity[j]+"</span><span class='totalPrice'>¥"+(listProductBean[j].productSale*listQuantity[j])+"</span><span class='productStatus'>"+orderMasterBean.orderMasterStatus+"</span><div class='operationBlock'></div></div>";
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
	
	
	
	function loadPageWaitRate()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/shopOrder?action=SSO&goal=WaitRate",
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
							var orderMasterBean=order[i].orderMasterBean;
							var listProductBean=order[i].listProductBean;
							order_html="<div class='order'><div class='orderIdBlock'>订单号：<span class='orderId'>"+orderMasterBean.orderId+"</span></div>";
							for(var j=0;j<listProductBean.length;j++)
							{
								order_html=order_html+"<div class='productMessage'><img src='"+listProductBean[j].productShowPicture+"' class='productImg'><span class='productName'>"+listProductBean[j].productName+"</span><span class='productSale'>¥"+listProductBean[j].productSale+"</span><span class='quantity'>"+listQuantity[j]+"</span><span class='totalPrice'>¥"+(listProductBean[j].productSale*listQuantity[j])+"</span><span class='productStatus'>"+orderMasterBean.orderMasterStatus+"</span><div class='operationBlock'></div></div>";
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
                    url:"/CommercialCity/shopOrder?action=SSO&goal=End",
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
							var orderMasterBean=order[i].orderMasterBean;
							var listProductBean=order[i].listProductBean;
							order_html="<div class='order'><div class='orderIdBlock'>订单号：<span class='orderId'>"+orderMasterBean.orderId+"</span></div>";
							for(var j=0;j<listProductBean.length;j++)
							{
								order_html=order_html+"<div class='productMessage'><img src='"+listProductBean[j].productShowPicture+"' class='productImg'><span class='productName'>"+listProductBean[j].productName+"</span><span class='productSale'>¥"+listProductBean[j].productSale+"</span><span class='quantity'>"+listQuantity[j]+"</span><span class='totalPrice'>¥"+(listProductBean[j].productSale*listQuantity[j])+"</span><span class='productStatus'>"+orderMasterBean.orderMasterStatus+"</span><div class='operationBlock'></div></div>";
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
	
	
	
	
	
	
	
})