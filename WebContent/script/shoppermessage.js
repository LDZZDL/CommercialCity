 // JavaScript Document
$(function(){
	var width=$(window).width();
	var height=$(window).height();
	var picturepath="/CommercialCity/commercialcity/productexample.png";
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
	var test=0;
	var img_html;//图片内容
	var objurl;//路径
	
	$.ajax({  
                type: "POST",  
                url:"/CommercialCity/shopMessage?action=showShopMessage",
                data:{},
                dataType:"json",
                success: function(data){
	var data1=data.message;
	for(var i=0;i<data1.length;i++)
	{
		for(var j in data1[i])
		{
		    if(j=="onlineName")
		    {
			    $("#shopperName").text(data1[i][j]);
				$("#shoppername").val(data1[i][j]);
		    }
			else if(j=="shopName")
		    {
			    $("#shopName").text(data1[i][j]);
				$("#shopname").val(data1[i][j]);
		    }
		    else if(j=="idCard")
		    {
			    $("#idCard").text(data1[i][j]);		
		    }
			else if(j=="introduction")
		    {
			    $("#shopIntroduction").text(data1[i][j]);
				$("#shopintroduction").text(data1[i][j]);
		    }
			else if(j=="openDate")
		    {
			    $("#openDate").text(data1[i][j]);
		    }
			/*else if(j=="goodRate")
		    {
			    $("#goodRate").text(data1[i][j]);
		    }*/
		    else if(j=="mail")
		    {
			    $("#shopperMail").text(data1[i][j]);
		    }
			else if(j=="shopperDisplayPicture")
		    {
		    	//alert(data1[i][j]);
			    $(".shopperDisplayPicture").attr("src",data1[i][j]);
		    }
			else if(j=="shopDisplayPicture")
		    {
		    	//alert(data1[i][j]);
			    $(".shopDisplayPicture").attr("src",data1[i][j]);
		    }
		    else if(j=="creditAccount")
		    {
			    $("#credit").text(data1[i][j]);
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
	//个人头像
	$("#shopperDisplayPictureAlter").click(function()
	{
		$(".img_div").html("");
		$(".img_div").append("<img id='aimg' class='picture'>");
	    $("#aimg").attr("src",picturepath);
	    $("#aimg").click(function()
	    {
		    $("#myfile").click();
	    })
		$("#mask").fadeIn("slow");
		$("#shopperDisplayPictureBox").fadeIn("slow");
	})
	//店铺头像
	$("#shopDisplayPictureAlter").click(function()
	{
		$(".img_div1").html("");
		$(".img_div1").append("<img id='aimg1' class='picture'>");
	    $("#aimg1").attr("src",picturepath);
	    $("#aimg1").click(function()
	    {
		    $("#myfile1").click();
	    })
		$("#mask").fadeIn("slow");
		$("#shopDisplayPictureBox").fadeIn("slow");
	})
	//基本信息
	$("#basicMessageAlter").click(function()
	{
		$("#shoppername").parent().find(".formtips").remove();
		$("#shoppname").parent().find(".formtips").remove();
		$("#shopintroduction").parent().find(".formtips").remove();
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
	
	
		
	
	
	
	//关闭盒子按钮区
	//个人头像
	$("#DPcloseBtn").click(function()
	{
		$("#mask").fadeOut("fast");
		$("#shopperDisplayPictureBox").fadeOut("slow");
	})
	//店铺头像
	$("#DPcloseBtn1").click(function()
	{
		$("#mask").fadeOut("fast");
		$("#shopDisplayPictureBox").fadeOut("slow");
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
	
	
	
	//检验格式区
	//基本信息
	$("#shoppername").blur(function()
	{//卖家名
		var $parent=$(this).parent();
		$("#shoppername").parent().find(".formtips").remove();
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
				       var errorMsg = '字数超限.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			       } 
				  else
				  {
					  $.ajax({  
                           type: "POST",  
                           url:"/CommercialCity/shopMessage?action=checkShopMessage&goal=onlineName",
                           data:{newOnlineName:this.value},
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
          }
	})
	$("#shopname").blur(function()
	{//店铺名
		var $parent=$(this).parent();
		$("#shopname").parent().find(".formtips").remove();
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
				       var errorMsg = '字数超限';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			       } 
				  else
				  {
					  $.ajax({  
                           type: "POST",  
                           url:"/CommercialCity/shopMessage?action=checkShopMessage&goal=shopName",
                           data:{newShopName:this.value},
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
	$("#shopintroduction").blur(function()
	{//店铺介绍
		var $parent=$(this).parent();
		$("#shopintroduction").parent().find(".formtips").remove();
          if( this.value=="" )
		  {
              var errorMsg = '不能为空.';
              $parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
          }
		  else
		  {
			  if(this.value.length>200)
			  {
				   var errorMsg = '长度超限.';
                   $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
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
                   url:"/CommercialCity/shopMessage?action=sendCodeMail",
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
                   url:"/CommercialCity/shopMessage?action=sendCodeMail",
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
                           url:"/CommercialCity/shopMessage?action=checkShopMessage&goal=mail",
                           data:{newMail:this.value+"@"+$("#mailselect").val()+".com"},
                           dataType:"json",
                           success: function(data){   
 if(data.status=="false") 
 {
	 $parent.append('<span class="formtips onError">'+data.message+'</span>');
 }
 else
 { 
 var ok="通过.";
$parent.append('<span class="formtips onSuccess onSuccess1">'+ok+'</span>');
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
                           url:"/CommercialCity/shopMessage?action=sendCodeNewMail",
                           data:{newMail:mail+"@"+$("#mailselect").val()+".com"},
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
        	  //alert("haode");
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
                           url:"/CommercialCity/shopMessage?action=checkShopMessage&goal=creditCard",
                           data:{newCreditCardAccount:this.value,newCreditCardPassword:creditpassword},
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
                           },
 error: function(XMLHttpRequest, textStatus, errorThrown){
        alert(XMLHttpRequest);
        alert(textStatus);
        alert(errorThrown);
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
                           url:"/CommercialCity/shopMessage?action=checkShopMessage&goal=creditCard",
                           data:{newCreditCardAccount:creditaccount,newCreditCardPassword:this.value},
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
                           },
 error: function(XMLHttpRequest, textStatus, errorThrown){
        alert(XMLHttpRequest);
        alert(textStatus);
        alert(errorThrown);
                                          }             
                           });
					  }
				  }
               }
          }
	 })
	 





	
	//提交按钮代码
	//个人头像
	$("#shopperdisplaypicturesubmit").click(function()
	{
		$("#shopperDisplayPictureForm").submit();
	})
	//店铺头像
	$("#shopdisplaypicturesubmit").click(function()
	{
		$("#shopDisplayPictureForm").submit();
	})
	//基本信息
	$("#basicmessagesubmit").mousedown(function()
	{
		$("#shoppername").trigger('blur');
		$("#shopname").trigger('blur');
		$("#shopintroduction").trigger('blur');
	})
	$("#basicmessagesubmit").mouseup(function()
	{
		var numError=$(".onError").length;
		if(!numError)
		{
		    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/shopMessage?action=ChangeshopMessage&goal=onlineNameAndShopNameAndShopIntrodusction",
                    data:{newOnlineName:$("#shoppername").val(),newShopName:$("#shopname").val(),newShopIntroduction:$("#shopintroduction").text()},
                    dataType:"json",
		          })
		          alert("修改成功");
		          location.reload();
		}
	})
	//密码
	$("#passwordsubmit").mousedown(function()
	{
		$("#passwordTestCode").trigger('blur');
		$("#newPassword").trigger('blur');
		$("#newPassword1").trigger('blur');
	})
	$("#passwordsubmit").mouseup(function()
	{
		var numSuccess=$(".onSuccess").length;
		if(numSuccess==3)
		{
		    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/shopMessage?action=ChangeshopMessage&goal=password",
                    data:{newPassword:$("#newPassword1").val()},
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
                    url:"/CommercialCity/shopMessage?action=ChangeshopMessage&goal=mail",
                    data:{newMail:mail+"@"+$("#mailselect").val()+".com"},
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
		//alert("siccess");
		var numSuccess=$(".onSuccess").length;
		if(numSuccess==2)
		{
		    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/shopMessage?action=ChangeshopMessage&goal=creditCard",
                    data:{newCreditCardAccount:$("#creditAccount").val(),newCreditCardPassword:$("#creditPassword").val()},
                    dataType:"json",
		          })
				  alert("信用卡修改成功");
				  location.reload();
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
	$("#myfile1").change(function()
	{	
		//鉴定格式及显示预览
		var img_div=$(".img_div1");
		var filepath=$("#myfile1").val(); 
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
		    $(".img_div1").html("");
		    return false;
		}
		else
		{
			$(".img_div1").html("");
			img_html = "<img src='" + objurl + "' id='bimg1' class='picture' /><button id='removePictureButton1' class='removebtn'>X</button>";
			img_div.append(img_html);
			$("#bimg1").click(function()
			{
				$("#showimg").attr("src",objurl);
				$("#showimg_shade").fadeIn("slow");
			})
			$("#removePictureButton1").click(function()
			{
				$("#myfile1").val("");
				$(this).parent().html("");
				$(".img_div1").append("<img id='aimg1' class='picture'>");
				$("#aimg1").attr("src",picturepath);
				$("#aimg1").click(function()
				{
					$("#myfile1").click();
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
		$(".img_div1").append("<img id='aimg1' class='picture'>");
	    $("#aimg1").attr("src",picturepath);
	    $("#aimg1").click(function()
	    {
		    $("#myfile1").click();
	    })
	}
	//图片放大
	$("#showimg_shade").click(function()
	{
		$("#showimg_shade").fadeOut("slow");
	})
	
})

 