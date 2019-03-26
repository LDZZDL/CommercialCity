// JavaScript Document
$(function()
{
	var width=$(window).width();
	var height=$(window).height();
	$("#background").height(height-2*$("h2").height());
	$("table").css("margin-top",height*0.08);
	$("form").css("margin-top",height*0.15);
    $("form").css("margin-left",width*0.36);
	$("#progress3").css("background-color","#1AA9C8");
	var password="";
	var password1="";
	$("input").blur(function()
	{
		var $parent=$(this).parent();
		//验证密码 
        if( $(this).is('#password') )
	    {
		    password="";
		    if(password1!="")
	        {
		       $("#password").parent().find(".formtips").remove();
		       $("#password1").parent().find(".formtips").remove();
	        }
		    else
		   {
			   $("#password").parent().find(".formtips").remove();
		   }
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
				       var errorMsg = '长度不合法,应为7-14位数字或字母.';
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
                               $("#password1").parent().append('<span class="formtips onSuccess">'+ok+'</span>');
						   }
						   else
						   {
							   var wrong="两次密码不一致.";
							   $("#password1").parent().append('<span class="formtips onError">'+wrong+'</span>');
						   }
					   }
				  }
			  }
		   }
		}
    
	 //验证二次输入密码
	 if( $(this).is('#password1') )
	 {
		 password1="";
		 $("#password1").parent().find(".formtips").remove();
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
				       var errorMsg = '长度不合法,应为7-14位数字或字母.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			       } 
				  else
				  {
					  password1=this.value;
					  if(password=="")
					  {
					   var errorMsg = '新密码未正确输入.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
					   //alert(creditaccount);
					  }
					  else
					  {
						  if(password==password1)
						  {
							   var ok="通过.";
	                           $parent.append('<span class="formtips onSuccess">'+ok+'</span>');
	                          // $("#password").parent().append('<span class="formtips onSuccess">'+ok+'</span>');
						  }
						  else
						  {
							  var wrong="两次密码不一致.";
							  $parent.append('<span class="formtips onError">'+wrong+'</span>');
						  }
					  }
				  }
               }
          }
	 }  
	})
	//提交时验证
	   $(".submit").click(function()
       {
        	
                $("form :input").trigger('blur');
                var numError = $('form .onError').length;
                if(numError){
                } 
                else
                {      
                   alert("密码重置成功");
                   $("form").submit();
                }
         });
	/*
      //跳转页面
	  $("form").ajaxSuccess(function()
	  {
		  alert("重置密码成功！")
		  window.location.href = "/CommercialCity/Customer/CustomerLogin.jsp";
	  })
    */
})