// JavaScript Document
$(function(){
	var width=$(window).width();
	var height=$(window).height();
	$("#background").height(height-2*$("h2").height());
	$("table").css("margin-top",height*0.08);
	$("form").css("margin-top",height*0.15);
    $("form").css("margin-left",width*0.36);
	$("#progress2").css("background-color","#1AA9C8");
	var testcode="";
	var interval=null;
	var sleep=30;
	$("#codeButton").mousedown(function()
	{
		
	    $.ajax({
	    					type:"POST",
                           url:"/CommercialCity/customerFindPassword?action=check2",	
                           /* data:{"type":"customerMail",customerMail:customerMail+"@"+$("#select").val()+".com"},*/
                           data:{},
                           dataType:"json",
                           success:function(data){
	 testcode=data; 
 }
			});
	 
		
	});
	$("#codeButton").mouseup(function()
	{
		   $("#testCode").parent().find(".formtips").remove();
		    var btn = document.getElementById('codeButton');
		    if(!interval)
		    {
		    	btn.style.backgroundColor ='#EF9AAF';
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
			if(this.value==testcode)
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
	$(".submit").click(function(){
		var success=$(".onSuccess").length;
		if(success!=1)
		{
			alert("信息未正确输入");
		}
		else
		{
			window.location.href = "CustomerFindPassword3.jsp";
		}
	})
})