// JavaScript Document
$(function()
{
	var orderId="";
	var totalMoney=0;
	var thisURL = document.URL;    
    var getval =thisURL.split('?');  
    for(var i=1;i<getval.length;i++)
	{
        var showval= getval[i].split("=")[0];
        var showval1=getval[i].split("=")[1];
		if(showval=="orderId")
		{
			orderId=showval1;
		} 
		else if(showval=="totalPrice")
		{
			totalMoney=showval1;
		}

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
	
	
	
	
	
	$("#submit").click(function()
	{
		if(orderId=="")
		{
		    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerMarket?action=Pay",
                    data:{password:$("#payPassword").val(),totalMoney:totalMoney},
                    dataType:"json",
					async:false,
                    success: function(data)
                    {
						if(data.status=="true")
						{
							alert("支付成功！");
							window.location.href="/CommercialCity/Customer/CustomerOrderManage.jsp";
						}
						else if(data.status=="false")
						{
							alert(data.message);
						}
					},
					error: function(XMLHttpRequest, textStatus, errorThrown)
					{
						alert("b1");
	 				     alert(XMLHttpRequest);
	 					 alert(textStatus);
	 					 alert(errorThrown);
	 				} 
			      })
         }
		 else
		 {
			 $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerMarket?action=Pay",
                    data:{orderId:orderId,password:$("#payPassword").val(),totalMoney:totalMoney},
                    dataType:"json",
					async:false,
                    success: function(data)
                    {
						if(data.status=="true")
						{
							alert("支付成功！");
							window.location.href="/CommercialCity/Customer/CustomerOrderManage.jsp";
						}
						else if(data.status=="false")
						{
							alert(data.message);
						}
					},
					error: function(XMLHttpRequest, textStatus, errorThrown)
					{
						alert("b2");
	 				     alert(XMLHttpRequest);
	 					 alert(textStatus);
	 					 alert(errorThrown);
	 				} 
			      })
		 }
	})
	
	
})