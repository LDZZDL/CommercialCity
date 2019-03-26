// JavaScript Document
$(function(){
	//地址三级联动
	initComplexArea('seachprov', 'seachcity', 'seachdistrict', area_array, sub_array,'35', '0', '0');
	var width=$(window).width();
	var height=$(window).height();
	var picturepath="/CommercialCity/commercialcity/productexample.png";
	var table_html="";
	var interval=null;
	var sleep=30;
	var interval1=null;
	var sleep1=30;
	var testcode="";
	var testcode1="";
	var password="";
	var password1="";
	var mail="";
	var count=0;
	var creditaccount="";
	var creditpassword="";
	var index1="";
	var test=0;
	var DeliveryAddressId=0;
	var deliveryAddressNumber=0;
	var img_html;//图片内容
	var objurl;//路径
	
	
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
	
	
	$.ajax({  
                type: "POST",  
                url:"/CommercialCity/customerMessage?action=ShowCustomerMessage",
                data:{},
                dataType:"json",
                success: function(data){
	var data1=data.message;
	for(var i=0;i<data1.length;i++)
	{
		for(var j in data1[i])
		{
		    if(j=="customerName")
		    {
			    $("#customerName").text(data1[i][j]);
				$("#customername").val(data1[i][j]);
		    }
		    else if(j=="customerSex")
		    {
			    $("#customerSex").text(data1[i][j]);
				$("#customersex").val(data1[i][j]);
		    }
			else if(j=="deliveryAddressNumber")
		    {
			    deliveryAddressNumber=data1[i][j];
		    }
		    else if(j=="customerMail")
		    {
			    $("#customerMail").text(data1[i][j]);
		    }
			else if(j=="displayPicture")
		    {
		    	//alert(data1[i][j]);
			    $(".displayPicture").attr("src",data1[i][j]);
		    }
		    else if(j=="creditAccount")
		    {
			    $("#credit").text(data1[i][j]);
		    }
		    else if(j=="receiverName")
		    {
		    	//alert("receivername");
				table_html="";
			    table_html="<tr><td class='na'>"+data1[i][j]+"</td>";
		    }
		    else if(j=="receiverTelephone")
		    {
			    table_html=table_html+"<td class='te'>"+data1[i][j]+"</td>";
		    }
		    else if(j=="receiverAddressFirst")
		    {
			    table_html=table_html+"<td><span class='ad1' num='"+data1[i][j]+"'>"+area_array[data1[i][j]]+"</span>";
		    }
			else if(j=="receiverAddressSecond")
		    {
				
				index1=data1[i][j].substring(0, 2);
			    table_html=table_html+"<span class='ad2' num='"+data1[i][j]+"'>"+sub_array[index1][data1[i][j]]+"</span>";
		    }
			else if(j=="receiverAddressThird")
		    {
				
				index1=data1[i][j].substring(0, 4);
			    table_html=table_html+"<span class='ad3' num='"+data1[i][j]+"'>"+sub_arr[index1][data1[i][j]]+"</span>";
		    }
			else if(j=="receiverAddressDetail")
		    {
			    table_html=table_html+"<span class='ad4'>"+data1[i][j]+"</span></td>";
		    }
		    else if(j=="deliveryAddressId")
		    {
			    table_html=table_html+"<td class='id'>"+data1[i][j]+"</td><td><button class='alter'>修改</button>|<button class='remove'>删除</button></td></tr>";
			    $("table").append(table_html);
			  //修改
				$(".alter").click(function()
				{
					//alert("修改");
					$("#receiverName").parent().find(".formtips").remove();
					$("#receiverTelephone").parent().find(".formtips").remove();
					$("#receiverAddress").parent().find(".formtips").remove();
					test=2;
					var $parent=$(this).parent().parent();
					$("#mask").fadeIn("slow");
					DeliveryAddressId=$parent.find(".id").text();
					$("#receiverName").val($parent.find(".na").text());
					$("#receiverTelephone").val($parent.find(".te").text());
					$("#receiverAddress").val($parent.find(".ad4").text());
					initComplexArea('seachprov', 'seachcity', 'seachdistrict', area_array, sub_array,$parent.find(".ad1").attr("num"), '0','0');
					$("#deliveryAddressBox").fadeIn("slow");
				})
				//删除
				$(".remove").click(function()
				{
					//alert("remove");
					var $parent=$(this).parent().parent();
					var id=$parent.find(".id").text();
					$.ajax({  
			                    type: "POST",  
			                    url:"/CommercialCity/customerMessage?action=ChangeCustomerMessage&goal=DeliveryAddressDelete",
			                    data:{DeliveryAddressId:id},
			                    dataType:"json",
					      })
				   alert("收货地址删除成功");
				   location.reload();
					
					
				})
		    }
		}
	}
	 
	                           },
	 			error: function(XMLHttpRequest, textStatus, errorThrown){
	 							alert(XMLHttpRequest);
	 							alert(textStatus);
	 							alert(errorThrown);
	 							}       
	      });
	
	loadPicture();
	
	
	
	//修改按钮区
	//头像
	$("#displayPictureAlter").click(function()
	{
		$(".img_div").html("");
		$(".img_div").append("<img id='aimg' class='picture'>");
	    $("#aimg").attr("src",picturepath);
	    $("#aimg").click(function()
	    {
		    $("#myfile").click();
	    })
		$("#mask").fadeIn("slow");
		$("#displayPictureBox").fadeIn("slow");
	})
	//基本信息
	$("#basicMessageAlter").click(function()
	{
		$("#customername").parent().find(".formtips").remove();
		$("#mask").fadeIn("slow");
		$("#basicMessageBox").fadeIn("slow");
	})
	//密码
	$("#passwordAlter").click(function()
	{
		$("#passwordTestCode").parent().find(".formtips").remove();
		$("#newPassword").parent().find(".formtips").remove();
		$("#newPassword1").parent().find(".formtips").remove();
		$("#passwordTestCode").val("");
		$("#newPassword").val("");
		$("#newPassword1").val("");
		$("#mask").fadeIn("slow");
		$("#passwordBox").fadeIn("slow");
	})
	//邮箱
	$("#mailAlter").click(function()
	{
		$("#mailTestCode").parent().find(".formtips").remove();
		$("#newMail").parent().find(".formtips").remove();
		$("#mailTestCode1").parent().find(".formtips").remove();
		$("#mailTestCode").val("");
		$("#newMail").val("");
		$("#mailTestCode1").val("");
		$("#mask").fadeIn("slow");
		$("#mailBox").fadeIn("slow");
	})
	//信用卡
	$("#creditAlter").click(function()
	{
		$("#creditAccount").parent().find(".formtips").remove();
		$("#creditPassword").parent().find(".formtips").remove();
		$("#mask").fadeIn("slow");
		$("#creditBox").fadeIn("slow");
	})
	//收货地址
	//新增
	$("#addDeliveryAddress").click(function()
	{
		$("#receiverName").parent().find(".formtips").remove();
		$("#receiverTelephone").parent().find(".formtips").remove();
		$("#receiverAddress").parent().find(".formtips").remove();
		initComplexArea('seachprov', 'seachcity', 'seachdistrict', area_array, sub_array, '44', '0', '0');
		if(deliveryAddressNumber<3)
		{
		   test=1;
		   $("#mask").fadeIn("slow");
		   $("#receiverName").val("");
		   $("#receiverTelephone").val("");
		   $("#receiverAddress").val("");
		   $("#deliveryAddressBox").fadeIn("slow");
		}
		else
		{
			alert("收货地址数已达上限");
		}
	})
	
		
	
	
	
	
	//关闭盒子按钮区
	//头像
	$("#DPcloseBtn").click(function()
	{
		$("#mask").fadeOut("fast");
		$("#displayPictureBox").fadeOut("slow");
	})
	//基本信息
	$("#BMcloseBtn").click(function()
	{
		$("#mask").fadeOut("fast");
		$("#basicMessageBox").fadeOut("slow");
	})
	//密码
	$("#PcloseBtn").click(function()
	{
		$("#mask").fadeOut("fast");
		$("#passwordBox").fadeOut("slow");
	})
	//邮箱
	$("#McloseBtn").click(function()
	{
		$("#mask").fadeOut("fast");
		$("#mailBox").fadeOut("slow");
	})
	//信用卡
	$("#CcloseBtn").click(function()
	{
		$("#mask").fadeOut("fast");
		$("#creditBox").fadeOut("slow");
	})
	//收货地址
	$("#DcloseBtn").click(function()
	{
		$("#mask").fadeOut("fast");
		$("#deliveryAddressBox").fadeOut("slow");
	})
	
	
	
	//检验格式区
	//基本信息
	$("#customername").blur(function()
	{
		var $parent=$(this).parent();
		$("#customername").parent().find(".formtips").remove();
          if( this.value=="" )
		  {
              var errorMsg = '不能为空.';
              $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
          }
		  else
		  {
			  if(!/^[a-zA-Z\u4e00-\u9fa5]+$/g.test(this.value))
			  {
					 var errorMsg = '非法字符！';
                     $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			  }
			  else
			  {  
			      if(this.value.length>12)
			      {
				       var errorMsg = '长度超限.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			       } 
				  else
				  {
					  $.ajax({  
                           type: "POST",  
                           url:"/CommercialCity/customerMessage?action=CheckCustomerMessage&goal=CustomerName",
                           data:{NewCustomerName:this.value},
                           dataType:"json",
                           success: function(data){   
 if(data.status=="false") 
 {
	 $parent.append('<span class="formtips onError">'+data.message+'</span>');
 }
 else
 { 
 var ok="通过.";
$parent.append('<span class="formtips onSuccess">'+ok+'</span>');
 }
                           }            
                           });
				  }
               }
          }
	})
	
	
	
	//密码
	$("#passwordTestCodeButton").mousedown(function()
	{
		testcode="";
		$("#passwordTestCode").parent().find(".formtips").remove();
		$.ajax({  
                   type: "POST",  
                   url:"/CommercialCity/customerMessage?action=SendCode",
                   data:{},
                   dataType:"json",
                   success: function(data){
	 testcode=data; 
 }
			});
	});
	
	$("#passwordTestCodeButton").mouseup(function()
	{
		interval=null;
		sleep=30;
        var btn = document.getElementById ('passwordTestCodeButton');
        if (!interval)
        {
            btn.style.backgroundColor ='#F58E89';
            btn.disabled = "disabled";
            btn.style.cursor = "wait";
            btn.value = "重发(" + sleep-- + ")";
            interval = setInterval (function ()
            {
                if (sleep == 0)
                {
                    if (!!interval)
                    {
                        clearInterval (interval);
                        interval = null;
                        sleep = 30;
                        btn.style.cursor = "pointer";
                        btn.removeAttribute ('disabled');
                        btn.value = "点击发送";
                        btn.style.backgroundColor = '';
                    }
                    return false;
                }
                btn.value = "重发(" + sleep-- + ")";
            }, 1000);
        }	
	})
	$("#passwordTestCode").blur(function()
	{
		$("#passwordTestCode").parent().find(".formtips").remove();
		if(testcode=="")
		{
			 var wrong="验证码未发送.";
	         $("#passwordTestCode").parent().append('<span class="formtips onError onError1">'+wrong+'</span>');
			
		}
		else
		{
			if($("#passwordTestCode").val()==testcode)
	        {
		          var right="验证通过.";
	              $("#passwordTestCode").parent().append('<span class="formtips onSuccess onSuccess1">'+right+'</span>'); 
				  $("#newpassword").css("display","block");
	        }
	        else
	        {
		          var wrong="验证码不正确.";
	              $("#passwordTestCode").parent().append('<span class="formtips onError onError1">'+wrong+'</span>');
				  $("#newpassword").css("display","none");
	        }
		}
	});
	$("#newPassword").blur(function()
	{
		var $parent=$(this).parent();
		//验证第一次密码 
		password="";
		if(password1!="")
	    {
		   $("#newPassword").parent().find(".formtips").remove();
		   $("#newPassword1").parent().find(".formtips").remove();
	    }
		else
	    {
		    $("#newPassword").parent().find(".formtips").remove();
	    }
        if( this.value=="" )
		{
             var errorMsg = '不能为空.';
             $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
        }
		else
		{
		    if(!/^[0-9a-zA-Z]+$/g.test(this.value))
			{
			    var errorMsg = '非法字符！';
                $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			}
			else
			{  
			    if(this.value.length>14||this.value.length<7)
			    {
				     var errorMsg = '长度超限.';
                     $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			    } 
				else
				{
					 password=this.value;
					 if(password1!="")
					 {
						 if(password==password1)
						 {
							 var ok="通过.";
                             $parent.append('<span class="formtips onSuccess">'+ok+'</span>');
                             $("#newPassword1").parent().append('<span class="formtips onSuccess">'+ok+'</span>');
						 }
						 else
						 {
							 var wrong="密码不一致.";
							 $("#newPassword1").parent().append('<span class="formtips onError">'+wrong+'</span>');
						 }
					 }
				}
		   }
	   }
	})
	 $("#newPassword1").blur(function()
	 {
		 var $parent=$(this).parent();
		  //验证二次输入密码
		 password1="";
		 $("#newPassword1").parent().find(".formtips").remove();
		 $("#newPassword").parent().find(".formtips").remove();
          if( this.value=="" )
		  {
              var errorMsg = '不能为空.';
              $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
          }
		  else
		  {
			  if(!/^[0-9a-zA-Z]+$/g.test(this.value))
			  {
					 var errorMsg = '非法字符！';
                     $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			  }
			  else
			  {  
			      if(this.value.length>14||this.value.length<7)
			      {
				       var errorMsg = '长度超限.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			      } 
				  else
				  {
					  password1=this.value;
					  if(password=="")
					  {
					       var errorMsg = '新密码错误.';
                           $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
					   //alert(creditaccount);
					  }
					  else
					  {
						  if(password==password1)
						  {
							   var ok="通过.";
	                           $parent.append('<span class="formtips onSuccess">'+ok+'</span>');
	                           $("#newPassword").parent().append('<span class="formtips onSuccess">'+ok+'</span>');
						  }
						  else
						  {
							  var wrong="密码不一致.";
							  $parent.append('<span class="formtips onError">'+wrong+'</span>');
						  }
					  }
				  }
               }
          }
	 })
	 
	 
	 //邮箱 
	 $("#mailTestCodeButton").mousedown(function()
	{
		testcode="";
		$("#mailTestCode").parent().find(".formtips").remove();
		$.ajax({  
                   type: "POST",  
                   url:"/CommercialCity/customerMessage?action=SendCode",
                   data:{},
                   dataType:"json",
                   success: function(data){testcode=data;},
                   error: function(XMLHttpRequest, textStatus, errorThrown){
		                             alert(XMLHttpRequest);
		                             alert(textStatus);
		                             alert(errorThrown);
		                                                                   }   
			});
	});
	
	$("#mailTestCodeButton").mouseup(function()
	{
		$("#mailTestCode").parent().find(".formtips").remove();
		interval=null;
		sleep=30;
        var btn = document.getElementById ('mailTestCodeButton');
        if (!interval)
        {
            btn.style.backgroundColor ='#F58E89';
            btn.disabled = "disabled";
            btn.style.cursor = "wait";
            btn.value = "重发(" + sleep-- + ")";
            interval = setInterval (function ()
            {
                if (sleep == 0)
                {
                    if (!!interval)
                    {
                        clearInterval (interval);
                        interval = null;
                        sleep = 30;
                        btn.style.cursor = "pointer";
                        btn.removeAttribute ('disabled');
                        btn.value = "点击发送";
                        btn.style.backgroundColor = '';
                    }
                    return false;
                }
                btn.value = "重发(" + sleep-- + ")";
            }, 1000);
        }	
	})
	$("#mailTestCode").blur(function()
	{
		//alert(testcode);
		if(testcode=="")
		{
			$("#mailTestCode").parent().find(".formtips").remove();
			 var wrong="验证码未发送.";
	         $("#mailTestCode").parent().append('<span class="formtips onError onError1">'+wrong+'</span>');
			
		}
		else
		{
			$("#mailTestCode").parent().find(".formtips").remove();
			if($("#mailTestCode").val()==testcode)
	        {
		          var right="验证通过.";
	              $("#mailTestCode").parent().append('<span class="formtips onSuccess onSuccess1">'+right+'</span>'); 
				  $("#newmail").css("display","block");
	        }
	        else
	        {
		          var wrong="验证码不正确.";
	              $("#mailTestCode").parent().append('<span class="formtips onError onError1">'+wrong+'</span>');
				  $("#newmail").css("display","none");
	        }
		}
	});
	 $("#newMail").blur(function()
	 {
		 //验证邮箱
		 mail="";
		 var $parent=$(this).parent();
          if(this.value=="" )
		  {
        	  $("#newMail").parent().find(".formtips").remove();
              var errorMsg = '不能为空.';
              $parent.append('<span class="formtips onError onError1">'+errorMsg+'</span>');
          }
		  else
		  {
			  if(!/^[0-9a-zA-Z_]+$/g.test(this.value))
			  {
				  $("#newMail").parent().find(".formtips").remove();
					 var errorMsg = '非法字符！';
                     $parent.append('<span class="formtips onError onError1">'+errorMsg+'</span>');
			  }
			  else
			  {  	  
				  $("#newMail").parent().find(".formtips").remove();
			          mail=this.value;
					  $.ajax({  
                           type: "POST",  
                           url:"/CommercialCity/customerMessage?action=CheckCustomerMessage&goal=CustomerMail",
                           data:{NewCustomerMail:this.value+"@"+$("#mailselect").val()+".com"},
                           dataType:"json",
                           success: function(data){   
 if(data.status=="false") 
 {
	 $parent.append('<span class="formtips onError">'+data.message+'</span>');
 }
 else
 { 
 var ok="通过.";
$parent.append('<span class="formtips onSuccess">'+ok+'</span>');
 }
                                                },
                           error: function(XMLHttpRequest, textStatus, errorThrown){
               		                             alert(XMLHttpRequest);
               		                             alert(textStatus);
               		                             alert(errorThrown);
               		                                                               } 
                           });			  
               }
          }
	 })
	 $("#mailTestCodeButton1").mousedown(function()
	{
		$("#mailTestCode1").parent().find(".formtips").remove();
		var numError=$("#newMail").parent().find(".onError").length;
		if(numError)
		{
			testcode1="";
			var wrong="邮箱未正确输入.";
			 $("#mailTestCode1").parent().append('<span class="formtips onError onError1">'+wrong+'</span>');
			 count=0;
		}
		else
		{
		    if(mail=="")
		    {
			    testcode1="";
			    var wrong="邮箱未正确输入.";
			    $("#mailTestCode1").parent().append('<span class="formtips onError onError1">'+wrong+'</span>');
			    count=0;
		    }
		    else
		    {
			    count=1;
			    $.ajax({  
                           type: "POST",  
                           url:"/CommercialCity/customerMessage?action=SendCodeNewMail",
                           data:{NewMail:mail+"@"+$("#mailselect").val()+".com"},
                           dataType:"json",
                           success: function(data){testcode1=data; }
			         });
		    }
		}
	});
	$("#mailTestCodeButton1").mouseup(function()
	{
		if(mail!="")
		{
			$("#mailTestCode1").parent().find(".formtips").remove();
		}
		if(count==1)
		{
            var btn = document.getElementById ('mailTestCodeButton1');
            if (!interval1)
            {
                btn.style.backgroundColor ='#F58E89';
                btn.disabled = "disabled";
                btn.style.cursor = "wait";
                btn.value = "重发(" + sleep1-- + ")";
                interval1 = setInterval (function ()
                {
                    if (sleep1 == 0)
                    {
                        if (!!interval1)
                        {
                            clearInterval (interval1);
                            interval1 = null;
                            sleep1 = 30;
                            btn.style.cursor = "pointer";
                            btn.removeAttribute ('disabled');
                            btn.value = "点击发送";
                            btn.style.backgroundColor = '';
                        }
                        return false;
                    }
                    btn.value = "重发(" + sleep1-- + ")";
                }, 1000);
            }	
		}
	})
	$("#mailTestCode1").blur(function()
	{
		//alert(testcode1);
		if(testcode1=="")
		{
			$("#mailTestCode1").parent().find(".formtips").remove();
			 var wrong="验证码未发送.";
	         $("#mailTestCode1").parent().append('<span class="formtips onError onError1">'+wrong+'</span>');
			
		}
		else
		{
			$("#mailTestCode1").parent().find(".formtips").remove();
			if($("#mailTestCode1").val()==testcode1)
	        {
		          var right="验证通过.";
	              $("#mailTestCode1").parent().append('<span class="formtips onSuccess onSuccess1">'+right+'</span>'); 
	        }
	        else
	        {
		          var wrong="验证码不正确.";
	              $("#mailTestCode1").parent().append('<span class="formtips onError onError1">'+wrong+'</span>');
	        }
		}
	});
    
	
	//信用卡
	//验证信用卡号
	 $("#creditAccount").blur(function()
	 {
		 var $parent=$(this).parent();
		  creditaccount="";
		 if(creditpassword!="")
	     {
		  $("#creditAccount").parent().find(".formtips").remove();
		  $("#creditPassword").parent().find(".formtips").remove();
	     }
		 else
		 {
			 $("#creditAccount").parent().find(".formtips").remove();
		 }
          if( this.value=="" )
		  {
              var errorMsg = '不能为空.';
              $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
          }
		  else
		  {
			  if(!/^[0-9]+$/g.test(this.value))
			  {
					 var errorMsg = '非法字符！';
                     $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			  }
			  else
			  {  
			      if(this.value.length!=10)
			      {
				       var errorMsg = '长度超限.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			       } 
				   else
				   {
					   creditaccount=this.value;
					   if(creditpassword!="")
					   {
						   $.ajax({  
                           type: "POST",  
                           url:"/CommercialCity/customerMessage?action=CheckCustomerMessage&goal=CreditCard",
                           data:{NewCreditCardAccount:this.value,NewCreditCardPassword:creditpassword},
                           dataType:"json",
                           success: function(data){   
 if(data.status=="false") 
 {
	 $("#creditPassword").parent().append('<span class="formtips onError">'+data.message+'</span>');
 }
 else
 { 
 var ok="通过.";
$parent.append('<span class="formtips onSuccess">'+ok+'</span>');
$("#creditPassword").parent().append('<span class="formtips onSuccess">'+ok+'</span>');
 }
                           }            
                           });
					   }
				   }
			  }
		  }
	 })
	 //验证信用卡密码
	 $("#creditPassword").blur(function()
	 {
		 var $parent=$(this).parent();
		 creditpassword="";
		 if(creditaccount!="")
		 {
		  $("#creditAccount").parent().find(".formtips").remove();
		   $("#creditPassword").parent().find(".formtips").remove();
		 }
		 else
		{
			 $("#creditPassword").parent().find(".formtips").remove();
		}
          if( this.value=="" )
		  {
              var errorMsg = '不能为空.';
              $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
          }
		  else
		  {
			  if(!/^[0-9]+$/g.test(this.value))
			  {
					 var errorMsg = '非法字符！';
                     $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			  }
			  else
			  {  
			      if(this.value.length!=10)
			      {
				       var errorMsg = '长度超限.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			       } 
				  else
				  {
					  creditpassword=this.value;
					  if(creditaccount=="")
					  {
						  var errorMsg = '账号错误.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
					   //alert(creditaccount);
					  }
					  else
					  {
					  $.ajax({  
                           type: "POST",  
                           url:"/CommercialCity/customerMessage?action=CheckCustomerMessage&goal=CreditCard",
                           data:{NewCreditCardAccount:creditaccount,NewCreditCardPassword:this.value},
                           dataType:"json",
                           success: function(data){   
 if(data.status=="false") 
 {
	 $parent.append('<span class="formtips onError">'+data.message+'</span>');
 }
 else
 { 
 var ok="通过.";
$parent.append('<span class="formtips onSuccess">'+ok+'</span>');
$("#creditAccount").parent().append('<span class="formtips onSuccess">'+ok+'</span>');
 }
                           }            
                           });
					  }
				  }
               }
          }
	 })
	 
	 //收货地址
	 $("#receiverName").blur(function()
	 {
		 //收货人姓名
		var $parent=$(this).parent();
		$("#receiverName").parent().find(".formtips").remove();
          if( this.value=="" )
		  {
              var errorMsg = '不能为空.';
              $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
          }
		  else
		  {
			  if(!/^[a-zA-Z\u4e00-\u9fa5]+$/g.test(this.value))
			  {
					 var errorMsg = '非法字符！';
                     $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			  }
			  else
			  {  
			      if(this.value.length>12)
			      {
				       var errorMsg = '长度超限.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			       } 
				   else
				   {
					    var ok = '通过.';
                       $parent.append('<span class="formtips onSuccess">'+ok+'</span>'); 
				   }
               }
          }
	})
	$("#receiverTelephone").blur(function()
	 {
		 //收货人电话
		var $parent=$(this).parent();
		$("#receiverTelephone").parent().find(".formtips").remove();
          if( this.value=="" )
		  {
              var errorMsg = '不能为空.';
              $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
          }
		  else
		  {
			  if(!/^[0-9]+$/g.test(this.value))
			  {
					 var errorMsg = '非法字符！';
                     $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			  }
			  else
			  {  
			      if(this.value.length!=11)
			      {
				       var errorMsg = '长度超限.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			       } 
				   else
				   {
					    var ok = '通过.';
                       $parent.append('<span class="formtips onSuccess">'+ok+'</span>'); 
				   }
               }
          }
	})
	$("#receiverAddress").blur(function()
	 {
		 //收货详细地址
		var $parent=$(this).parent();
		$("#receiverAddress").parent().find(".formtips").remove();
          if( this.value=="" )
		  {
              var errorMsg = '详细地址不能为空.';
              $parent.append('<span class="formtips onError onError1">'+errorMsg+'</span>');
          }
		  else
		  {
			  if(!/^[0-9a-zA-Z\u4e00-\u9fa5-]+$/g.test(this.value))
			  {
					 var errorMsg = '非法字符！';
                     $parent.append('<span class="formtips onError onError1">'+errorMsg+'</span>');
			  }
			  else
			  {  
			      if(this.value.length>30)
			      {
				       var errorMsg = '长度超限.';
                       $parent.append('<span class="formtips onError onError1">'+errorMsg+'</span>');
			       } 
				   else
				   {
					    var ok = '通过.';
                       $parent.append('<span class="formtips onSuccess onSuccess1">'+ok+'</span>'); 
				   }
               }
          }
	})
	$("#seachcity").blur(function()
	{
		if($(this).val()=="0")
		{
			$("#receiverAddress").parent().find(".formtips").remove();
			var errorMsg = '市级地址错误.';
			$("#receiverAddress").parent().append('<span class="formtips onError onError1">'+errorMsg+'</span>');
		}
	})
	$("#seachdistrict").blur(function()
	{
		if($(this).val()=="0")
		{
			if($("#seachprov").val()!="11"&&$("#seachprov").val()!="12"&&$("#seachprov").val()!="31"&&$("#seachprov").val()!="50"&&$("#seachprov").val()!="71"&&$("#seachprov").val()!="81"&&$("#seachprov").val()!="82")
			{
			    $("#receiverAddress").parent().find(".formtips").remove();
			    var errorMsg = '区级地址错误.';
			    $("#receiverAddress").parent().append('<span class="formtips onError onError1">'+errorMsg+'</span>');
			}
		}
	})


	
	//提交按钮代码
	//头像
	$("#displaypicturesubmit").click(function()
	{
		$("#displayPictureForm").submit();
	})
	//基本信息
	$("#basicmessagesubmit").mousedown(function()
	{
		$("#customername").trigger('blur');
	})
	$("#basicmessagesubmit").mouseup(function()
	{
		//alert("开始修改");
		var numError=$(".onError").length;
		if(!numError)
		{
		    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerMessage?action=ChangeCustomerMessage&goal=CustomerNameAndCustomerSex",
                    data:{NewCustomerName:$("#customername").val(),NewCustomerSex:$("#customersex").val()},
                    dataType:"json",
		          })
		          alert("修改成功");
		          location.reload();
		}
	})
	//密码
	$("#passwordsubmit").click(function()
	{
		$("#passwordTestCode").trigger('blur');
		$("#newPassword").trigger('blur');
		$("#newPassword1").trigger('blur');
		var numSuccess=$(".onSuccess").length;
		if(numSuccess==3)
		{
		    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerMessage?action=ChangeCustomerMessage&goal=Password",
                    data:{NewCustomerPassword:$("#newPassword1").val()},
                    dataType:"json",
		          })
				  alert("密码修改成功");
				  location.reload();
		}
	})
	//邮箱
	$("#mailsubmit").mousedown(function()
	{
		$("#mailTestCode").trigger('blur');
		$("#newMail").trigger('blur');
		$("#mailTestCode1").trigger('blur');
	})
	$("#mailsubmit").mouseup(function()
	{
		var numSuccess=$(".onSuccess").length;
		if(numSuccess==3)
		{
		    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerMessage?action=ChangeCustomerMessage&goal=CustomerMail",
                    data:{NewCustomerMail:mail+"@"+$("#mailselect").val()+".com"},
                    dataType:"json",
		          })
				  alert("邮箱修改成功");
				  location.reload();
		}
	})
	//信用卡
	$("#creditsubmit").mousedown(function()
	{
		$("#creditAccount").trigger('blur');
	})
	$("#creditsubmit").mouseup(function()
	{
		var numSuccess=$(".onSuccess").length;
		if(numSuccess==2)
		{
		    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerMessage?action=ChangeCustomerMessage&goal=CreditCard",
                    data:{NewCreditCardAccount:$("#creditAccount").val(),NewCreditCardPassword:$("#creditPassword").val()},
                    dataType:"json",
		          })
				  alert("信用卡修改成功");
				  location.reload();
		}
	})
	//收货地址
	$("#deliveryaddresssubmit").mousedown(function()
	{
		$("#receiverName").trigger('blur');
		$("#receiverTelephone").trigger('blur');
		$("#receiverAddress").trigger('blur');
		$("#seachcity").trigger('blur');
		$("#seachdistrict").trigger('blur');
	})
	$("#deliveryaddresssubmit").mouseup(function()
	{
		var numError=$(".onError").length;
		if(!numError)
		{
			if(test==1)
			{
		        $.ajax({  
                        type: "POST",  
                        url:"/CommercialCity/customerMessage?action=ChangeCustomerMessage&goal=DeliveryAddressAdd",
                        data:{ReceiverName:$("#receiverName").val(),ReceiverTelephone:$("#receiverTelephone").val(),receiverAddressFirst:$("#seachprov").val(),receiverAddressSecond:$("#seachcity").val(),receiverAddressThird:$("#seachdistrict").val(),receiverAddressDetail:$("#receiverAddress").val()},
                        dataType:"json",
		          })
				  alert("收货地址新增成功");
				  location.reload();
			}
			else if(test==2)
			{
				$.ajax({  
                        type: "POST",  
                        url:"/CommercialCity/customerMessage?action=ChangeCustomerMessage&goal=DeliveryAddressChange",
                        data:{DeliveryAddressId:DeliveryAddressId,ReceiverName:$("#receiverName").val(),ReceiverTelephone:$("#receiverTelephone").val(),receiverAddressFirst:$("#seachprov").val(),receiverAddressSecond:$("#seachcity").val(),receiverAddressThird:$("#seachdistrict").val(),receiverAddressDetail:$("#receiverAddress").val()},
                        dataType:"json",
		          })
				  alert("收货地址修改成功");
				  location.reload();
			}
		}
	})
	
	
	
	
	
	
	
	
	//图片预览
	$("#myfile").change(function()
	{	
		//鉴定格式及显示预览
		var img_div=$(".img_div");
		var filepath=$("#myfile").val(); 
		objurl=getObjectURL(this.files[0]);
		//alert(objurl);
		var extStart=filepath.lastIndexOf(".");
		//从后向前搜索字符出现位置，正向位置
		var ext=filepath.substring(extStart,filepath.length).toUpperCase();
		//substring() 方法用于提取字符串中介于两个指定下标之间的字符。
		//toUpperCase() 方法用于把字符串转换为大写。
		if(ext!=".JPG"&&ext!=".PNG"&&ext!=".JPEG")
		{
			alert("图片仅限于jpg,jpeg,png格式");
		    this.value="";
		    $(".img_div").html("");
		    return false;
		}
		else
		{
			$(".img_div").html("");
			img_html = "<img src='" + objurl + "' id='bimg' class='picture' /><button id='removePictureButton' class='removebtn'>X</button>";
			img_div.append(img_html);
			$("#bimg").click(function()
			{
				$("#showimg").attr("src",objurl);
				$("#showimg_shade").fadeIn("slow");
			})
			$("#removePictureButton").click(function()
			{
				$(this).parent().html("");
				$("#myfile").val("");
				$(".img_div").append("<img id='aimg' class='picture'>");
				$("#aimg").attr("src",picturepath);
				$("#aimg").click(function()
				{
					$("#myfile").click();
				})
				
			})
			return true;
		}
	})
	function getObjectURL(file)
	{
	    var url = null;
		if(window.createObjectURL != undefined) 
		{ // basic
		    url = window.createObjectURL(file);
		} 
		else if(window.URL != undefined) 
		{ // mozilla(firefox)
			url = window.URL.createObjectURL(file);
		} 
		else if(window.webkitURL != undefined) 
		{ // webkit or chrome
			url = window.webkitURL.createObjectURL(file);
		}
			//console.log(url);
			return url;
	}
	function loadPicture()
	{
		$(".img_div").append("<img id='aimg' class='picture'>");
	    $("#aimg").attr("src",picturepath);
	    $("#aimg").click(function()
	    {
		    $("#myfile").click();
	    })
	}
	//图片放大
	$("#showimg_shade").click(function()
	{
		$("#showimg_shade").fadeOut("slow");
	})
	
	
})


//得到地区码
function getAreaID(){
	var area = 0;          
	if($("#seachdistrict").val() != "0"){
		area = $("#seachdistrict").val();                
	}else if ($("#seachcity").val() != "0"){
		area = $("#seachcity").val();
	}else{
		area = $("#seachprov").val();
	}
	return area;
}

function showAreaID() {
	//地区码
	var areaID = getAreaID();
	//地区名
	var areaName = getAreaNamebyID(areaID) ;
	alert("您选择的地区码：" + areaID + "      地区名：" + areaName);   
	alert(areaID.length); 
	alert($("#seachdistrict_div").value) ;       
}

//根据地区码查询地区名
function getAreaNamebyID(areaID){
	var areaName = "";
	if(areaID.length == 2){
		areaName = area_array[areaID];
	}else if(areaID.length == 4){
		var index1 = areaID.substring(0, 2);
		areaName = area_array[index1] + " " + sub_array[index1][areaID];
	}else if(areaID.length == 6){
		var index1 = areaID.substring(0, 2);
		var index2 = areaID.substring(0, 4);
		areaName = area_array[index1] + " " + sub_array[index1][index2] + " " + sub_arr[index2][areaID];
	}
	return areaName;
}
