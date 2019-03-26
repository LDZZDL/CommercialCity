// JavaScript Document
$(function()
{
	var pageNo=1;//评论页码
	var comment_html="";
	
	
	var thisURL =decodeURI(document.URL);    
    var loginStatus=0;
    var productId=0;   
    var getval =thisURL.split('?');  
    if(getval.length>1)
	{
		for(var q=1;q<getval.length;q++)
		{
			var a=getval[q].split('=')[0];
			var b=getval[q].split('=')[1];
			if(a=="loginStatus")
			{
				loginStatus=b;
			}
			else if(a=="id")
			{
				//alert("a");
				productId=b;
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
	
	//搜索
	$("#search").click(function()
	{
		var address="/CommercialCity/Customer/Product/ProductBrowse.jsp?searchValue="+$("#searchValue").val();
		window.open(encodeURI(address));
	})
	//数量input
	$("#quantity").keyup(function()
	{
		//alert("haode");
		if(!/^[0-9]+$/g.test(this.value))
		{
			$(this).val("1");
		}
		else
		{
			var a=$("#productStock").text();
			var b=$(this).val();
			if(eval(b)>eval(a))
			{
				alert("超出库存！");
				$(this).val("1");
			}
		}
	})
	
	//立即购买
	$("#buyNow").click(function()
	{
		if(loginStatus==1)
		{
		    var message='[{"listOrderDetailBean":[{"orderId":"","productId":'+productId+',"quantity":'+$("#quantity").val()+'}]}]';
		    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerMarket?action=ConfirmOrder",
                    data:{message:message},
                    dataType:"json",
					async:false
		          })
	        window.location.href="/CommercialCity/Customer/OrderConfirm.jsp";
		}
		else
		{
			$("#mask").fadeIn("slow");
		    $("#loginBox").fadeIn("slow");
		}
	})
	//加入购物车
	$("#shoppingCart").click(function()
	{
		//alert($("#quantity").val());
		if(loginStatus==1)
		{
		    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerMarket?action=ShoppingCart",
                    data:{productId:productId,quantity:$("#quantity").val()},
                    dataType:"json",
					async:false,
					success: function(data){}
		          })
		    alert("加入成功！");
		}
		else
		{
			$("#mask").fadeIn("slow");
		    $("#loginBox").fadeIn("slow");
		}
	})
	
	
	 //上下翻页
	$(".previousPage").click(function()
	{
		if($(this).parent().find(".pageNo").text()>=1)
		{
			$(".comment").remove();
			pageNo=pageNo-1;
			loadComment();
		}
	})
	$(".nextPage").click(function()
	{
		if($(this).parent().find(".pageNo").text()!=$(this).parent().find(".totalPageNo").text())
		{
			$(".comment").remove();
			pageNo=pageNo+1;
			loadComment();
		}
	})
	
	
	
	
    function loadPage()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerMarket?action=Detail",
                    data:{productId:productId},
                    dataType:"json",
					async:false,
                    success: function(data){
	    var product=data.product;
	    var comment=data.comment;
		var customer=data.customer;
		var page=data.page;
		$(".pageNo").text(page.pageNo);
		$(".totalPageNo").text(page.totalPageNo);
		for(var i=0;i<comment.length;i++)
		{
			comment_html="";
			comment_html="<div class='comment'><span class='commentName'>买家："+customer[i].customerName+"</span><span class='goodRate'>星级："+comment[i].goodRate+"星</span><span class='com'>评论：</span><span class='commentContent'>"+comment[i].commentContent+"</span></div>";
			$("#comment_div").append(comment_html);
		}
	    $("#productName").text(product.productName);
		$("#productIntroduction").text(product.productIntroduction);
		$("#productSale").text(product.productSale);
		$("#productClass").text(product.productClass);
		$("#writer").text(product.writer);
		$("#publishingHouse").text(product.publishingHouse);
		$("#productStock").text(product.productStock);
		$("#productAttribute").text(product.productAttribute);
		$("#productShowPicture").attr("src",product.productShowPicture);
		$("#productShowPicture").click(function()
	    {
		     $("#showimg").attr("src",product.productShowPicture);
		     $("#showimg_shade").fadeIn("slow");
	    })
		$("#productIntroductionPictureOne").attr("src",product.productIntroductionPictureOne);
		$("#productIntroductionPictureTwo").attr("src",product.productIntroductionPictureTwo);
		$("#productIntroductionPictureThree").attr("src",product.productIntroductionPictureThree);
		    
		},
				error: function(XMLHttpRequest, textStatus, errorThrown){
	 							alert(XMLHttpRequest);
	 							alert(textStatus);
	 							alert(errorThrown);
	 		}   
					})
	}
    
	
	function loadComment()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerMarket?action=GR",
                    data:{productId:productId,pageNo:pageNo},
                    dataType:"json",
					async:false,
                    success: function(data)
                    {
						var comment=data.Comment;
						var customer=data.customer;
						var page=data.Page;
						$(".pageNo").text(page.pageNo);
						$(".totalPageNo").text(page.totalPageNo);
						for(var i=0;i<comment.length;i++)
						{
							comment_html="";
							comment_html="<div class='comment'><span class='commentName'>买家："+customer[i].customerName+"</span><span class='goodRate'>星级："+comment[i].goodRate+"星</span><span class='com'>评论：</span><span class='commentContent'>"+comment[i].commentContent+"</span></div>";
							$("#comment_div").append(comment_html);
						}
					},
					error: function()
					{
	 					alert("wrong");
	 		        }   
		      })
	}
					
	
	
	
	
    $("#showimg_shade").click(function()
	{
		$("#showimg_shade").fadeOut("slow");
	})
    //数量增减
	$("#numDecrease").click(function()
	{
		var num=$("#quantity").val();
		if(num>1)
		{
			num--;
			$("#quantity").val(num);
		}
	})
	$("#numIncrease").click(function()
	{
		var num=$("#quantity").val();
		var stock=$("#productStock").text();
		if(eval(num)<eval(stock))
		{
			num++;
			$("#quantity").val(num);
		}
		else
		{
			alert("超出库存！");
		}
	})
    

})