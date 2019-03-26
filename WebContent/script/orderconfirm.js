// JavaScript Document
$(function()
{
	var order_html="";
	var address_html="";
	var shopTotalPrice=0;
	var totalPrice=0;
	var address="/CommercialCity/Customer/OrderPay.jsp";
	var url="/CommercialCity/customerMarket?action=CreateOrder&shoppingcartflag=";
	
	var thisURL = document.URL;    
    var getval =thisURL.split('?'); 
    if(getval.length==2)
	{
		var shoppingcartflag=getval[1].split('=')[1];
		url=url+shoppingcartflag;
	}
	
	
	
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
	
	
	//单选框效果
	$(".radio").click(function()
	{
		$(".address").css("font-weight","100");
		$(".address").css("background","#fff");
		$(".address").css("border-color","#fff");
		$(this).parent().css("font-weight","700");
		$(this).parent().css("background","#FFF0E8");
		$(this).parent().css("border-color","#FF4400");
	})
	
	//页面初始化
	loadPage();
	
	
	//提交订单
	$("#submitOrder").click(function()
	{
		if(!$("input:radio:checked").val())
		{
			alert("收货地址未选择！");
		}
		else
		{
		    $.ajax({  
                        type: "POST",  
                        url:url,
                        data:{deliveryAddressId:$("input:radio:checked").val()},
                        dataType:"json",
					    async:false,
                  })
		    address=address+"?totalPrice="+totalPrice;
		    window.location.href=address;
		}
	})
	
	
	function loadPage()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerMarket?action=ConfirmOrderGet",
                    data:{},
                    dataType:"json",
					async:false,
                    success: function(data){
	    var address=data.delivery;
	    var message=data.message;
	    for(var i=0;i<address.length;i++)
	    {
			address_html="";
			address_html="<div class='address'><input type='radio' name='address' class='radio' value='"+address[i].deliveryAddressId+"'><span>"+area_array[address[i].receiverAddressFirst]+" "+sub_array[address[i].receiverAddressFirst][address[i].receiverAddressSecond]+" ";
			if(address[i].receiverAddressThird!="")
			{
				address_html=address_html+sub_arr[address[i].receiverAddressSecond][address[i].receiverAddressThird]+" ";
			}
			address_html=address_html+address[i].receiverAddressDetail+" ("+address[i].receiverName+" 收) "+address[i].receiverTelephone+"</span></div>";
			$("#deliveryAddress").append(address_html);
		}
		for(var j=0;j<message.length;j++)
	    {
			var simple=message[j].listOrderDetailBean;
			address=address+"?orderId="+simple[0].orderId;
			var detail=message[j].listProductBean;
			var shop=message[j].shopBean;
			order_html="";
			shopTotalPrice=0;
			order_html="<div class='order'><div class='shopName'>店铺："+shop.shopName+"</div>";
			for(var k=0;k<simple.length;k++)
			{
				shopTotalPrice=shopTotalPrice+(detail[k].productSale*simple[k].quantity);
			    order_html=order_html+"<div class='product'><a href='ProductDetail.jsp?id="+simple[k].productId+"'><img class='productImg' src='"+detail[k].productShowPicture+"'><span class='productName'>"+detail[k].productName+"</span></a><span class='productSale'>¥"+detail[k].productSale+"</span><span class='quantity'>"+simple[k].quantity+"</span><span class='total'>¥"+(detail[k].productSale*simple[k].quantity)+"</span></div>";
			}
			order_html=order_html+"<div class='shopTotalPriceBlock'><span class='RMBP'>店铺合计</span><span class='RMB'>¥</span><span class='shopTotalPrice'>"+shopTotalPrice+"</span></div></div>";
			totalPrice=totalPrice+shopTotalPrice;
			$("#orderMessage").append(order_html);
		}
		$("#totalPrice").text(totalPrice);
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