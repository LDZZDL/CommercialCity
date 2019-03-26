// JavaScript Document
$(function(){
	var width=$(window).width();
	var height=$(window).height();
	$("#background").height(height-$("#pageheading").height()-40);
	$("form").css("margin-top",height*0.15);
	$("form").css("margin-left",width*0.45);
	var creditaccount="";
	var creditpassword="";
	var mail="";
	var testcode="";
	var sleep=30;
	var interval=null;
	var count=0;
	$("input").blur(function(){		
	 var $parent = $(this).parent();
     //$parent.find(".formtips").remove();
	 
             //验证用户名
     if( $(this).is('#customerAccount') )
	 {
		 $("#customerAccount").parent().find(".formtips").remove();
          if( this.value=="" )
		  {
              var errorMsg = '账号不能为空.';
              $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
          }
		  else
		  {
			  if(!/^[0-9a-zA-Z]+$/g.test(this.value))
			  {
					 var errorMsg = '输入非法字符！';
                     $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			  }
			  else
			  {  
			      if(this.value.length>14||this.value.length<7)
			      {
				       var errorMsg = '长度不合法,应为7-14位字母或数字.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			       } 
				  else
				  {
					  $.ajax({  
                           type: "POST",  
                           url:"/CommercialCity/customerRegister?action=check",
                           data:{"type":"customerAccount",customerAccount:this.value},
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
	 }  
	 //验证密码
	 if( $(this).is('#customerPassword') )
	 {
		 $("#customerPassword").parent().find(".formtips").remove();
          if( this.value=="" )
		  {
              var errorMsg = '密码不能为空.';
              $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
          }
		  else
		  {
			  if(!/^[0-9a-zA-Z]+$/g.test(this.value))
			  {
					 var errorMsg = '输入非法字符！';
                     $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			  }
			  else
			  {  
			      if(this.value.length>14||this.value.length<7)
			      {
				       var errorMsg = '长度不合法,应为7-14位字母或数字.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			       } 
				  else
				  {
					   var ok="通过.";
$parent.append('<span class="formtips onSuccess">'+ok+'</span>');
				  }
               }
          }
	 }  
	         //验证姓名
     if( $(this).is('#customerName') )
	 {
		 $("#customerName").parent().find(".formtips").remove();
          if( this.value=="" )
		  {
              var errorMsg = '姓名不能为空.';
              $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
          }
		  else
		  {
			  if(!/^[a-zA-Z\u4e00-\u9fa5]+$/g.test(this.value))
			  {
					 var errorMsg = '输入非法字符！';
                     $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			  }
			  else
			  {  
			      if(this.value.length>12)
			      {
				       var errorMsg = '长度不合法,应为12位字母或汉字.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			       } 
				  else
				  {
					  $.ajax({  
                           type: "POST",  
                           url:"/CommercialCity/customerRegister?action=check",
                           data:{"type":"customerName",customerName:this.value},
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
	 }  
	 //验证邮箱
	 if( $(this).is('#customerMail') )
	 {
		 mail="";
		 $("#customerMail").parent().find(".formtips").remove();
          if( this.value=="" )
		  {
              var errorMsg = '邮箱不能为空.';
              $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
          }
		  else
		  {
			  if(!/^[0-9a-zA-Z_]+$/g.test(this.value))
			  {
					 var errorMsg = '输入非法字符！';
                     $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			  }
			  else
			  {  	   
				  mail=this.value;
					  $.ajax({  
                           type: "POST",  
                           url:"/CommercialCity/customerRegister?action=check",
                           data:{"type":"customerMail",customerMail:this.value+"@"+$("#mailselect").val()+".com"},
                           dataType:"json",
                           success: function(data){   
 if(data.status=="false") 
 {
	 mail="";
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
	
	 //验证信用卡号
	 if($(this).is('#creditAccount') )
	 {
		 creditaccount="";
		 
		 if(creditpassword!="")
	     {
			 //alert("you");
		  $("#creditAccount").parent().find(".formtips").remove();
		  $("#creditPassword").parent().find(".formtips").remove();
	     }
		 else
		 {
			 $("#creditAccount").parent().find(".formtips").remove();
		 }
          if( this.value=="" )
		  {
              var errorMsg = '信用卡不能为空.';
              $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
          }
		  else
		  {
			  if(!/^[0-9]+$/g.test(this.value))
			  {
					 var errorMsg = '输入非法字符！';
                     $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			  }
			  else
			  {  
			      if(this.value.length!=10)
			      {
				       var errorMsg = '长度不合法,应为10位数字.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			       } 
				   else
				   {
					   creditaccount=this.value;
					   if(creditpassword!="")
					   {
						   $.ajax({ 
                                       type:"POST",  
                                       url:"/CommercialCity/customerRegister?action=check",
                                       data:{"type":"accountAndPassword",creditAccount:this.value,password:creditpassword},
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
	 }
	 //验证信用卡密码
	 if( $(this).is('#creditPassword') )
	 {
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
              var errorMsg = '密码不能为空.';
              $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
          }
		  else
		  {
			  if(!/^[0-9]+$/g.test(this.value))
			  {
					 var errorMsg = '输入非法字符！';
                     $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			  }
			  else
			  {  
			      if(this.value.length!=10)
			      {
				       var errorMsg = '长度不合法,应为10位数字.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			       } 
				  else
				  {
					  creditpassword=this.value;
					  if(creditaccount=="")
					  {
						  var errorMsg = '信用卡账号未正确输入.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
					   //alert(creditaccount);
					  }
					  else
					  {
					  $.ajax({  
                           type: "POST",  
                           url:"/CommercialCity/customerRegister?action=check",
                           data:{"type":"accountAndPassword",creditAccount:creditaccount,password:this.value},
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
          //验证信用卡号
     	 if( $(this).is('#creditAccount') )
    	 {
    		 creditaccount="";
    		 //alert(creditpassword);
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
                  var errorMsg = '信用卡不能为空.';
                  $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
              }
    		  else
    		  {
    			  if(!/^[0-9]+$/g.test(this.value))
    			  {
    					 var errorMsg = '输入非法字符！';
                         $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
    			  }
    			  else
    			  {  
    			      if(this.value.length!=10)
    			      {
    				       var errorMsg = '长度不合法,应为10位数字.';
                           $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
    			       } 
    				   else
    				   {
    					   creditaccount=this.value;
    					   //alert(creditpassword);
    					   if(creditpassword!="")
    					   {
    						   //alert(creditpassword);
    						   $.ajax({  
                               type: "POST",  
                               url:"/CommercialCity/customerRegister?action=check",
                               data:{"type":"accountAndPassword",creditAccount:this.value,password:creditpassword},
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
    $("#creditPassword").parent.append('<span class="formtips onSuccess">'+ok+'</span>');
     }
                               }            
                               });
    					   }
    				   }
    			  }
    		  }
    	 }
    	 //验证信用卡密码
    	 if( $(this).is('#creditPassword') )
    	 {
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
                  var errorMsg = '密码不能为空.';
                  $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
              }
    		  else
    		  {
    			  if(!/^[0-9]+$/g.test(this.value))
    			  {
    					 var errorMsg = '输入非法字符！';
                         $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
    			  }
    			  else
    			  {  
    			      if(this.value.length!=10)
    			      {
    				       var errorMsg = '长度不合法,应为10位数字.';
                           $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
    			       } 
    				  else
    				  {
    					  creditpassword=this.value;
    					  if(creditaccount=="")
    					  {
    					   var errorMsg = '信用卡账号未正确输入.';
                           $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
    					   //alert(creditaccount);
    					  }
    					  else
    					  {
    						  //alert("kaishi");
    					  $.ajax({  
                               type: "POST",  
                               url:"/CommercialCity/customerRegister?action=check",
                               data:{"type":"accountAndPassword",creditAccount:creditaccount,password:this.value},
                               dataType:"json",
                               success: function(data){   
    	 //alert(data.status);
    	 if(data.status=="false") 
    	 {
    		 //alert("you");
    		 $parent.append('<span class="formtips onError">'+data.message+'</span>');
    	 }
    	 else
    	 { 
    	     var ok="通过.";
    	    //$parent.append('<span class="formtips onSuccess">'+ok+'</span>');
    	    $("#creditAccount").parent.append('<span class="formtips onSuccess">'+ok+'</span>');
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
    	 } 
	 }  
	});
	$("#codeButton").mousedown(function()
			{
				$("#testCode").parent().find(".formtips").remove();
				if(mail=="")
				{
					var wrong="邮箱未正确输入.";
					 $("#testCode").parent().append('<span class="formtips onError">'+wrong+'</span>');
					 count=0; 
				}
				else
				{
					testcode="";
					count=1;
					$.ajax({  
		                           type: "POST",  
		                           url:"/CommercialCity/customerRegister?action=idCode",
		                           data:{"type":"mail",mail:mail+"@"+$("#mailselect").val()+".com"},
		                           dataType:"json",
		                           success: function(data){
			 testcode=data; 
		 }
					});
			 
				}
			
			});
	$("#codeButton").mouseup(function()
			{
		        if(mail!="")
		        {
		        	$("#testCode").parent().find(".formtips").remove();
		        }
				if(count==1)
				{
					//alert(testcode);
		            var btn = document.getElementById ('codeButton');
		            if (!interval)
		            {
		                btn.style.backgroundColor =' #F58E89';
		                btn.disabled = "disabled";
		                btn.style.cursor = "wait";
		                btn.value = "重新发送 (" + sleep-- + ")";
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
		                            btn.value = "发送验证码";
		                            btn.style.backgroundColor = '';
		                        }
		                        return false;
		                    }
		                    btn.value = "重新发送 (" + sleep-- + ")";
		                }, 1000);
		            }	
				}
				/*else
					{
					   alert("haode");
					}*/
			})

			$("#testCode").blur(function()
			{
				$("#testCode").parent().find(".formtips").remove();
				if(testcode=="")
				{
					 var wrong="验证码未发送.";
			     $("#testCode").parent().append('<span class="formtips onError">'+wrong+'</span>');
					
				}
				else
				{
					if($("#testCode").val()==testcode)
			        {
				          var right="验证通过.";
			              $("#testCode").parent().append('<span class="formtips onSuccess">'+right+'</span>'); 
			        }
			        else
			        {
				          var wrong="验证码不正确.";
			              $("#testCode").parent().append('<span class="formtips onError">'+wrong+'</span>');
			        }
				}
			});
			
			 //提交，最终验证。
		        $('#send').click(function(){
		        	//alert(numError);
		                $("form :input").trigger('blur');
		                //alert(numError);
		                var numError = $('form .onError').length;
		                //alert(numError);
		                if(numError){
		                	//alert("wrong");
		                } 
						else
						{
		                    //alert("注册成功.");
							alert("注册成功");
							$("form").submit();
						}
		         });

		        //重置
		         $('#reset').click(function(){
		                $(".formtips").remove(); 
		         });
})
