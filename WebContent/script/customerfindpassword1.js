// JavaScript Document
$(function(){
	var width=$(window).width();
	var height=$(window).height();
	$("#background").height(height-2*$("h2").height());
	$("table").css("margin-top",height*0.08);
	$("form").css("margin-top",height*0.15);
    $("form").css("margin-left",width*0.36);
	$("#progress1").css("background-color","#1AA9C8");
	$("#customerAccount").blur(function()
	{
		var $parent=$(this).parent();
		$parent.find(".formtips").remove();
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
						   type:"POST",
                           url:"/CommercialCity/customerFindPassword?action=check1",
                           data:{"type":"customerAccount",customerAccount:this.value},
                           dataType:"json",
                           success:function(data)
                           {
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
	$(".submit").click(function(){
		var success=$(".onSuccess").length;
		if(!success)
		{
			alert("账号未正确输入");
		}
		else
		{
			window.location.href = "CustomerFindPassword2.jsp";
		}
	})
	
})