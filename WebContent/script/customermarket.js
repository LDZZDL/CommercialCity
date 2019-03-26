// JavaScript Document
$(function()
{
	var product_html="";
	
	
	var loginStatus=0;
	var thisURL = document.URL;   
	//alert(thisURL); 
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
		}
	}
	if(loginStatus==1)
	{
		$("#customerLogin").css("display","none");
		$("#shoppingCart").css("display","block");
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
		window.open("CustomerLogin.jsp");
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
	
	//分类栏
	$(".nav a").click(function()
	{
		var address="/CommercialCity/Customer/Product/ProductBrowse.jsp?searchClass="+$(this).text()+"?loginStatus="+loginStatus;
		window.open(encodeURI(address));
	})
	
	
	
	
	
	
	//页面初始化
	loadPage();
	
	
	//搜索
	$("#search").click(function()
	{
		var address="/CommercialCity/Customer/Product/ProductBrowse.jsp?searchValue="+$("#searchValue").val()+"?loginStatus="+loginStatus;
		window.open(encodeURI(address));
	})
	
	
	function loadPage()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerMarket?action=All",
                    data:{},
                    dataType:"json",
                    success: function(data){
	    var listInterestedProduct=data.listInterestedProduct;
	    var listRankingList=data.listRankingList;
		var listRecentProduct=data.listRecentProduct;
		var showproduct=data.showproduct;
		for(var i=0;i<showproduct.length;i++)
	    {
			product_html="";
			product_html="<a href='/CommercialCity/Customer/Product/ProductDetail.jsp?id="+showproduct[i].productId+"?loginStatus="+loginStatus+"' target='_blank'><img src='"+showproduct[i].productIntroductionPictureOne+"' id='section"+i+"' class='section'></img></a>";
			$(".sections").append(product_html);
		}
	    for(var i=0;i<listInterestedProduct.length;i++)
	    {
			product_html="";
			product_html="<div class='interestProduct'><a href='/CommercialCity/Customer/Product/ProductDetail.jsp?id="+listInterestedProduct[i].productId+"?loginStatus="+loginStatus+"' target='_blank'><img src='"+listInterestedProduct[i].productShowPicture+"' class='interestImg'></a><a href='/CommercialCity/Customer/Product/ProductDetail.jsp?id="+listInterestedProduct[i].productId+"?loginStatus="+loginStatus+"' target='_blank'> <span class='interestName'>"+listInterestedProduct[i].productName+"</span><span class='interestIntroduction'>"+listInterestedProduct[i].productIntroduction+"</span></a></div>";
			$("#listInterestedProduct").append(product_html);
		}
		for(var j=0;j<listRankingList.length;j++)
	    {
			product_html="";
			product_html="<li><a href='/CommercialCity/Customer/Product/ProductDetail.jsp?id="+listRankingList[j].productId+"?loginStatus="+loginStatus+"' target='_blank'>"+(j+1)+" "+listRankingList[j].productName+"</a></li>";
			$(".nav1").append(product_html);
		}
		for(var k=0;k<listRecentProduct.length;k++)
	    {
			product_html="";
			product_html="<div class='newProduct'><a href='/CommercialCity/Customer/Product/ProductDetail.jsp?id="+listRecentProduct[k].productId+"?loginStatus="+loginStatus+"' target='_blank'><img src='"+listRecentProduct[k].productShowPicture+"' class='newImg'></a><a href='/CommercialCity/Customer/Product/ProductDetail.jsp?id="+listRecentProduct[k].productId+"?loginStatus="+loginStatus+"' target='_blank'><span class='newName'>"+listRecentProduct[k].productName+"</span></a></div>";
			$("#listRecentProduct").append(product_html);
		}
		//轮播图
		$("#container").PageSwitch({
			direction:'horizontal',
			easing:'ease-in',
			duration:1000,
			autoPlay:true,
			loop:'false'
		})
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