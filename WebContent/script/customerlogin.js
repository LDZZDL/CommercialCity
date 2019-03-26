// JavaScript Document
$(function(){
	
$("#submit").click(function()
{
	//alert("login");
	 $.ajax({ 
         type:"POST",  
         url:"/CommercialCity/customerLogin",
         data:{"type":"accountandpassword",account:$("#account").val(),password:$("#password").val()},
         dataType:"json",
         success: function(data)
                  {  
                       if(data.status=="false") 
                       {
	                       alert(data.message);
                       }
                       else
                       { 
                           //alert("nihao");
                    	   alert(data.message);
                    	   window.location.href = "/CommercialCity/Customer/CustomerMarket.jsp?loginStatus=1";
                       }
                  }            
            });
});
})
