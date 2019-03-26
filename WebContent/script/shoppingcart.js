// JavaScript Document
$(function()
{
	var shop=1;
	var product=1;
	var totalMoney=0;
	var order_html="";
	var pageNo=1;
	
	$("#customerMarket").click(function()
			{
				window.location.href="CustomerMarket.jsp?loginStatus=1";
			})
			$("#customerLogin").click(function()
			{
				window.location.href="CustomerLogin.jsp";
			})
			$("#shoppingCart1").click(function()
			{
				window.location.href="ShoppingCart.jsp";
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
		            window.location.href="CustomerMarket.jsp";
				}
				return false;
			})
	
	
	//页面初始化
	loadPage();
	
	
	//复选框及总计及结算按钮样式
	$(".quan").click(function()
	{
		totalMoney=0;
		var a=$(this).prop("checked");
		$(".quan").prop("checked",a);
		$(".product").prop("checked",a);
		$(".shop").prop("checked",a);
	    $(".product:checked").each(function() 
		{
			$(this).parent().css("background","#FFF8E1");
            totalMoney=totalMoney+eval($(this).parent().find(".totalPrice").text());
        });
		$("#totalMoney").text(totalMoney);
		if(totalMoney==0)
		{
			$("#pay").css("background","#B0B0B0");
			$("#pay").css("cursor","not-allowed");
			$(".product").parent().css("background","#FCFCFC");
		}
		else
		{
			$("#pay").css("background","#f40");
		    $("#pay").css("cursor","pointer");
		}
		
	})
	/*$(".shop").click(function()
	{	
		var status=$(this).prop("checked");
		shop=1;
		totalMoney=0;
		if(status==true)
		{   
			$(this).parent().parent().find(".product").each(function()
			{ 
			    //alert("haode");
				$(this).prop("checked",true);       
            });
			
			$(".shop").each(function()
			{
				if($(this).prop("checked")==false)
				{
					shop=0;
				}
            });
			if(shop==1)
			{
				$(".quan").prop("checked",true);
			}
			
		}
		else if(status==false)
		{
			//alert("haode");
			$(this).parent().parent().find(".product").each(function() 
			{
				//alert($(this).val());
                $(this).prop("checked",false);
				$(this).parent().css("background","#FCFCFC");
            });
			$(".quan").prop("checked",false);
		}
		$(".product:checked").each(function() 
		{
			$(this).parent().css("background","#FFF8E1");
            totalMoney=totalMoney+eval($(this).parent().find(".totalPrice").text());
        });
		$("#totalMoney").text(totalMoney);
		if(totalMoney==0)
		{
			$("#pay").css("background","#B0B0B0");
			$("#pay").css("cursor","not-allowed");
			$(".product").parent().css("background","#FCFCFC");
		}
		else
		{
			$("#pay").css("background","#f40");
		    $("#pay").css("cursor","pointer");
		}
	})
	$(".product").click(function()
	{
		//alert("product");
		
		var status=$(this).prop("checked");
		product=1;
		shop=1;
		totalMoney=0;
		if(status==true)
		{
			$(this).parent().parent().find(".product").each(function() 
			{
                if($(this).prop("checked")==false)
				{
					product=0;
				}
            });
			if(product==1)
			{
				$(this).parent().parent().parent().find(".shop").prop("checked",true);
				$(".shop").each(function()
			    {
				    if($(this).prop("checked")==false)
				    {
					    shop=0;
				    }
                });
			    if(shop==1)
			    {
				    $(".quan").prop("checked",true);
			    }
			}
		}
		else if(status==false)
		{
			$(this).parent().parent().parent().find(".shop").prop("checked",false);
			$(".quan").prop("checked",false);
			$(this).parent().css("background","#FCFCFC");
		}
		$(".product:checked").each(function() 
		{
			$(this).parent().css("background","#FFF8E1");
            totalMoney=totalMoney+eval($(this).parent().find(".totalPrice").text());
        });
		$("#totalMoney").text(totalMoney);
		if(totalMoney==0)
		{
			$("#pay").css("background","#B0B0B0");
			$("#pay").css("cursor","not-allowed");
			$(".product").parent().css("background","#FCFCFC");
		}
		else
		{
			$("#pay").css("background","#f40");
		    $("#pay").css("cursor","pointer");
		}
	})*/
	 
	
	
	
	//上下翻页
	$(".previousPage").click(function()
	{
		if($(this).parent().find(".pageNo").text()!=1)
		{
			$(".order").remove();
			pageNo=pageNo-1;
			loadPage();
		}
	})
	$(".nextPage").click(function()
	{
		if($(this).parent().find(".pageNo").text()!=$(this).parent().find(".totalPageNo").text())
		{
			$(".order").remove();
			pageNo=pageNo+1;
			loadPage();
		}
	})
	
	//结算按钮
	$("#pay").click(function()
	{
		if($("#totalMoney").text()!=0)
		{
			var message='[';
			var shopId="";
			var shopId1="";
			var first=0;//检测是否第一个订单
			$(".product:checked").each(function() 
			{
				shopId1=$(this).parent().parent().parent().find(".shop").val();
                if(shopId1!=shopId)
				{
					if(first==0)
					{
						message=message+'{"listOrderDetailBean":[{"orderId":"","productId":'+$(this).val()+',"quantity":'+$(this).parent().find(".quantity").val()+'}';
					}
					else
					{
						message=message+']},{"listOrderDetailBean":[{"orderId":"","productId":'+$(this).val()+',"quantity":'+$(this).parent().find(".quantity").val()+'}';
					}
				}
				else
				{
					message=message+',{"orderId":"","productId":'+$(this).val()+',"quantity":'+$(this).parent().find(".quantity").val()+'}';
				}
				shopId=shopId1;
				first++;
            });
			message=message+']}]';
			$.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerMarket?action=ConfirmOrder",
                    data:{"message":message},
                    dataType:"json",
					async:false
			      })
		    window.location.href="/CommercialCity/Customer/OrderConfirm.jsp?shoppingcartflag=true";
			
		}
	})
	
    function loadPage()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerShoppingCart?action=SM",
                    data:{pageNo:pageNo},
                    dataType:"json",
					async:false,
                    success: function(data){
	    var page=data.page;
	    var product=data.product;
		$(".pageNo").text(page.pageNo);
		$(".totalPageNo").text(page.totalPageNo);
	    for(var i=0;i<product.length;i++)
	    {
			order_html="";
			var shopBean=product[i].shopBean;
			var listProductBean=product[i].listProductBean;
			var listQuantity=product[i].listQuantity;
			order_html="<div class='order'><div class='shopBlock'><input type='checkbox' class='shop' autocomplete='off' value='"+shopBean.shopId+"'><span class='shopName'>店铺："+shopBean.shopName+"</span></div><div class='products'>";
			for(var j=0;j<listProductBean.length;j++)
			{
				//alert(listQuantity[j]);
				order_html=order_html+"<div class='productBlock'><input type='checkbox' class='product' autocomplete='off' value='"+listProductBean[j].productId+"'><a href='/CommercialCity/Customer/Product/ProductDetail.jsp?id="+listProductBean[j].productId+"'><img src='"+listProductBean[j].productShowPicture+"' class='productImg'><span class='productName'>"+listProductBean[j].productName+"</span></a><span class='PRMB'>¥</span><span class='productSale'>"+listProductBean[j].productSale+"</span><button class='numDecrease'>—</button><input type='text' class='quantity' value='"+listQuantity[j]+"' autocomplete='off'><button class='numIncrease'>+</button><div class='productStockBlock'>（库存<span class='productStock'>"+listProductBean[j].productStock+"</span>本）</div><span class='RMB'>¥</span><span class='totalPrice'>"+listQuantity[j]*listProductBean[j].productSale+"</span><a href='#' class='remove'>删除</a></div>";
			}
			order_html=order_html+"</div></div>";
			$("#shoppingCart").append(order_html);
			
			//复选框
			$(".shop").click(function()
	        {	
		        var status=$(this).prop("checked");
		        shop=1;
		        totalMoney=0;
		        if(status==true)
		        {   
			        $(this).parent().parent().find(".product").each(function()
			        { 
			            //alert("haode");
				        $(this).prop("checked",true);       
                    });	
			        $(".shop").each(function()
			        {
				        if($(this).prop("checked")==false)
				        {
					        shop=0;
				        }
                    });
			        if(shop==1)
			        {
				        $(".quan").prop("checked",true);
			        }		
		        }
		        else if(status==false)
		        {
			        //alert("haode");
			        $(this).parent().parent().find(".product").each(function() 
			        {
				       //alert($(this).val());
                        $(this).prop("checked",false);
				        $(this).parent().css("background","#FCFCFC");
                    });
			        $(".quan").prop("checked",false);
		        }
		        $(".product:checked").each(function() 
		        {
			        $(this).parent().css("background","#FFF8E1");
                    totalMoney=totalMoney+eval($(this).parent().find(".totalPrice").text());
                });
		        $("#totalMoney").text(totalMoney);
		        if(totalMoney==0)
		        {
			        $("#pay").css("background","#B0B0B0");
			        $("#pay").css("cursor","not-allowed");
			        $(".product").parent().css("background","#FCFCFC");
	        	}
	        	else
		        {
		        	$("#pay").css("background","#f40");
		            $("#pay").css("cursor","pointer");
		        }
	        })
	        $(".product").click(function()
	        {
		        //alert("product");
		
		        var status=$(this).prop("checked");
		        product=1;
		        shop=1;
	        	totalMoney=0;
	        	if(status==true)
	        	{
		        	$(this).parent().parent().find(".product").each(function() 
		        	{
                        if($(this).prop("checked")==false)
			        	{
			        		product=0;
			        	}
                    });
			         if(product==1)
			         {
				        $(this).parent().parent().parent().find(".shop").prop("checked",true);
				        $(".shop").each(function()
			            {
				            if($(this).prop("checked")==false)
				            {
					            shop=0;
				            }
                        });
			            if(shop==1)
			            {
				           $(".quan").prop("checked",true);
			            }
			        }
		        }
		        else if(status==false)
		        {
			        $(this).parent().parent().parent().find(".shop").prop("checked",false);
			        $(".quan").prop("checked",false);
			        $(this).parent().css("background","#FCFCFC");
		        }
		        $(".product:checked").each(function() 
		        {
			        $(this).parent().css("background","#FFF8E1");
                    totalMoney=totalMoney+eval($(this).parent().find(".totalPrice").text());
                });
		        $("#totalMoney").text(totalMoney);
		        if(totalMoney==0)
		        {
		         	$("#pay").css("background","#B0B0B0");
			        $("#pay").css("cursor","not-allowed");
			        $(".product").parent().css("background","#FCFCFC");
		        }
		        else
	        	{
			        $("#pay").css("background","#f40");
		            $("#pay").css("cursor","pointer");
		        }
	        })
			
			
		}
	  //数量增减及框修改
        $(".quantity").keyup(function()
        {
	        //alert("haode");
	        if(!/^[0-9]+$/g.test(this.value))
	        {
		        $(this).val("1");
	        }
	        else
	        {
		        var a=$(this).parent().find(".productStock").text();
		        var b=$(this).val();
		        if(eval(b)>eval(a))
		        {
			        alert("超出库存！");
			        $(this).val("1");
					var totalPrice=$(this).parent().find(".productSale").text();
			        $(this).parent().find(".totalPrice").text(totalPrice);
			        totalMoney=0;
			        $(".product:checked").each(function() 
	                {
                       totalMoney=totalMoney+eval($(this).parent().find(".totalPrice").text());
                    });
			        $("#totalMoney").text(totalMoney);
		        }
		        else
		        {
			        $.ajax({  
                           type: "POST",  
                        url:"/CommercialCity/customerShoppingCart?action=CQ",
                            data:{productId:$(this).parent().find(".product").val(),quantity:b},
                        dataType:"json",
			        	async:false
			              })
			        var totalPrice=$(this).parent().find(".productSale").text()*b;
			        $(this).parent().find(".totalPrice").text(totalPrice);
			        totalMoney=0;
			        $(".product:checked").each(function() 
	                {
                        totalMoney=totalMoney+eval($(this).parent().find(".totalPrice").text());
                    });
			        $("#totalMoney").text(totalMoney);
		        }
	        }
        })
        //数量增减
        $(".numDecrease").click(function()
        {
	        var $quantity=$(this).parent().find(".quantity");
	        var num=$quantity.val();
	        if(num!=1)
	        {
		        num--;
		        $quantity.val(num);
		        $.ajax({  
                           type: "POST",  
                        url:"/CommercialCity/customerShoppingCart?action=CQ",
                            data:{productId:$(this).parent().find(".product").val(),quantity:num},
                        dataType:"json",
			         	async:false
			          });
	            var totalPrice=$(this).parent().find(".productSale").text()*num;
		        $(this).parent().find(".totalPrice").text(totalPrice);
		        totalMoney=0;
		        $(".product:checked").each(function() 
	            {
                    totalMoney=totalMoney+eval($(this).parent().find(".totalPrice").text());
                });
		        $("#totalMoney").text(totalMoney);
	        }
        })
        $(".numIncrease").click(function()
        {
	        var $quantity=$(this).parent().find(".quantity");
	        var num=$quantity.val();
	        var stock=$(this).parent().find(".productStock").text();
	        if(eval(num)<eval(stock))
	        {
		        num++;
		        $quantity.val(num);
		        $.ajax({  
                           type: "POST",  
                        url:"/CommercialCity/customerShoppingCart?action=CQ",
                            data:{productId:$(this).parent().find(".product").val(),quantity:num},
                        dataType:"json",
				        async:false
			          });
		        var totalPrice=$(this).parent().find(".productSale").text()*num;
		        $(this).parent().find(".totalPrice").text(totalPrice);
		        totalMoney=0;
		        $(".product:checked").each(function() 
	            {
                    totalMoney=totalMoney+eval($(this).parent().find(".totalPrice").text());
                });
		        //alert(totalMoney);
		        $("#totalMoney").text(totalMoney);
	        }
	        else
	        {
		        alert("超出库存！");
	        }
        })
	  //删除按钮
		$(".remove").click(function()
		{
			//alert("1");
			if(confirm("确定删除该书籍？"))
			{
				$.ajax({  
                           type: "POST",  
                        url:"/CommercialCity/customerShoppingCart?action=DP",
                            data:{productId:$(this).parent().find(".product").val(),pageNo:pageNo},
                        dataType:"json",
				        async:false,
                           success: function(data)
                        {
					        pageNo=data.pageNo;
					        $(".pageNo").text(data.pageNo);
					        $(".totalPageNo").text(data.totalPageNo);
				        },
						error: function(XMLHttpRequest, textStatus, errorThrown)
				        {
 				            alert(XMLHttpRequest);
 					        alert(textStatus);
 					        alert(errorThrown);
 				        }  
				       })
				
				$(".order").remove();
			    loadPage();
			    alert("删除成功！");
				//return true;
			}
			return false;
			
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