// JavaScript Document
$(function()
{
	var history_html="";
	var pageNo=1;
	
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
					type:"POST",
					url:"/CommercialCity/customerLogin?action=取消登录",
					data:{},
					dataType:"json",
					error: function()
					{
						alert("wrong");
					}
			})
			window.location.href="/CommercialCity/Customer/CustomerMarket.jsp";
		}
		return false;
	})
	
	
	
	//上下翻页
	$(".previousPage").click(function()
	{
		if($(this).parent().find(".pageNo").text()>1)
		{
			$("#history").html("");
			pageNo=pageNo-1;
			loadPage();
		}
	})
	$(".nextPage").click(function()
	{
		if($(this).parent().find(".pageNo").text()!=$(this).parent().find(".totalPageNo").text())
		{
			$("#history").html("");
			pageNo=pageNo+1;
			loadPage();
		}
	})
	
	
	
	
	
	//页面初始化
	loadPage();
	
	
	
	
	function loadPage()
	{
		$.ajax({
					type:"POST",
					url:"/CommercialCity/customerBrowserHistory?action=SBH",
					data:{pageNo:pageNo},
					dataType:"json",
					async:false,
					success:function(data)
					{
						var page=data.page;
						var history=data.BrowserHistory;
						var product=data.Product;
						$(".pageNo").text(page.pageNo);
						$(".totalPageNo").text(page.totalPageNo);
						for(var i=0;i<history.length;i++)
						{
							history_html="";
							history_html="<div class='history'><a href='/CommercialCity/Customer/Product/ProductDetail.jsp?loginStatus=1?id="+product[i].productId+"' target='_blank'><img src='"+product[i].productShowPicture+"' class='historyImg'><span class='productName'>书名："+product[i].productName+"</span></a><span class='productSale'>价格：¥"+product[i].productSale+"</span><span class='time'>浏览时间："+history[i].time+"</span></div>";
							$("#history").append(history_html);
						}
					},
					error: function()
					{
						alert("wrong");
					}
			 })
	}
})