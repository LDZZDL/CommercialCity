// JavaScript Document
$(function()
{
	var productId=0;
	var searchValue="";
	//var orderType="PA";
	var orderType="ALL";
	var priceRangeLeft="";
	var priceRangeRight="";
	var pageNo=1;
	var product_html="";
	var searchClass="全部分类";
	
	var loginStatus=0;
	var thisURL = decodeURI(document.URL);    
    var getval =thisURL.split('?');
	if(getval.length>1)
	{
		for(var q=1;q<getval.length;q++)
		{
			var a=getval[q].split('=')[0];
			var b=getval[q].split('=')[1];
			if(a=="loginStatus")
			{
				//alert("hao");
				loginStatus=b;
			}
			else if(a=="searchValue")
			{
				searchValue=b;
			}
			else if(a=="searchClass")
			{
				searchClass=b;
			}
		}
	}  
	if(loginStatus==1)
	{
		$("#customerLogin").css("display","none");
		$("#shoppingCart1").css("display","block");
		$("#personalMessage").css("display","block");
		$("#exit").css("display","block");
	}
	$("#customerMarket").click(function()
	{
		if(loginStatus==0)
		{
			window.location.href="/CommercialCity/Customer/CustomerMarket.jsp";
		}
		else
		{
			window.location.href="/CommercialCity/Customer/CustomerMarket.jsp?loginStatus=1";
		}
	})
	$("#customerLogin").click(function()
	{
		$("#mask").fadeIn("slow");
	    $("#loginBox").fadeIn("slow");
	})
	$("#shoppingCart1").click(function()
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
                    url:"/CommercialCity/customerLogin?action=取消登录",
                    data:{},
                    dataType:"json",
					error: function()
					{
						alert("wrong");
					}
			})
            loginStatus=0;
			$("#customerLogin").css("display","block");
            $("#shoppingCart1").css("display","none");
            $("#personalMessage").css("display","none");
            $("#exit").css("display","none");
		}
		return false;
	})
	
	
	//登录
	$("#AcloseBtn").click(function()
	{
		$("#mask").fadeOut("fast");
		$("#loginBox").fadeOut("slow");
	})

	$("#submit").click(function()
	{
		$.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerLogin",
                    data:{"type":"accountandpassword",account:$("#account").val(),password:$("#password").val()},
                    dataType:"json",
					async:false,
                    success: function(data)
                    {
						if(data.status=="false") 
                       {
	                       alert(data.message);
                       }
                       else
                       { 
                           //alert("nihao");
						   loginStatus=1;
                    	   alert(data.message);
						   $("#customerLogin").css("display","none");
		                   $("#shoppingCart1").css("display","block");
		                   $("#personalMessage").css("display","block");
		                   $("#exit").css("display","block");
                    	   $("#mask").fadeOut("fast");
		                   $("#loginBox").fadeOut("slow");
                       }

					}
		      })
	})
	
	
	//页面初始化
	loadPage();
	
	
	//上下翻页、筛选搜索
	$(".previousPage").click(function()
	{
		if($(this).parent().find(".pageNo").text()!=1)
		{
			$("#products").html("");
			pageNo=pageNo-1;
			loadPage();
		}
	})
	$(".nextPage").click(function()
	{
		if($(this).parent().find(".pageNo").text()!=$(this).parent().find(".totalPageNo").text())
		{
			$("#products").html("");
			pageNo=pageNo+1;
			loadPage();
		}
	})
	$("#search").click(function()
	{
		$("#products").html("");
		orderType="ALL";
	    searchValue=$("#searchValue").val();
	    priceRangeLeft="";
	    priceRangeRight="";
	    pageNo=1;
		searchClass="全部分类";
		loadPage();
	})
	$("#priceRangeButton").click(function()
	{
		if(!/^[0-9]+$/g.test($("#priceRangeLeft").val())||!/^[0-9]+$/g.test($("#priceRangeRight").val()))
		{
			alert("价格区间含有非法字符！");
		}
		else
		{
			$("#products").html("");
			priceRangeLeft=$("#priceRangeLeft").val();
			priceRangeRight=$("#priceRangeRight").val();
			pageNo=1;
			loadPage();
		}
	})
	$("#orderType").change(function()
	{
		$("#products").html("");
		orderType=$("#orderType").val();
		pageNo=1;
		loadPage();
	})
	$("#searchClass").change(function()
	{
		$("#products").html("");
		searchClass=$("#searchClass").val();
		pageNo=1;
		loadPage();
	})
	
	
	
	
	function loadPage()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerMarket?action=Search",
                    data:{searchValue:searchValue,orderType:orderType,priceRangeLeft:priceRangeLeft,priceRangeRight:priceRangeRight,pageNo:pageNo,searchClass:searchClass},
                    dataType:"json",
                    success: function(data){
	    var product=data.product;
	    var page=data.page[0];
		$(".pageNo").text(page.pageNo);		    		    
		$(".totalPageNo").text(page.totalPageNo);		    
		$("#searchValue").val(page.searchValue);
        $("#orderType").val(page.orderType);
		$("#searchClass").val(page.searchClass);
		$(".priceRangeLeft").val(page.priceRangeLeft);
		$(".priceRangeRight").val(page.priceRangeRight);
	    for(var i=1;i<product.length;i++)
	    {
			product_html="";
			product_html="<div class='product'><a href='/CommercialCity/Customer/Product/ProductDetail.jsp?id="+product[i].productId+"?loginStatus="+loginStatus+"' target='_blank'><img src='"+product[i].productShowPicture+"'></a><div class='price'><span class='RMB'>¥</span><span class='productSale'>"+product[i].productSale+"</span></div><a href='/CommercialCity/Customer/Product/ProductDetail.jsp?id="+product[i].productId+"?loginStatus="+loginStatus+"' target='_blank'> <span class='productName'>"+product[i].productName+"</span></a></div>";
			$("#products").append(product_html);
		}
				                         },
	 			     error: function(XMLHttpRequest, textStatus, errorThrown)
					 {
	 				     alert(XMLHttpRequest);
	 					 alert(textStatus);
	 					 alert(errorThrown);
	 				 }       
	          });
	}
})