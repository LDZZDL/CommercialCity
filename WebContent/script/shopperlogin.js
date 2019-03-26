// JavaScript Document
$(function(){
$("#submit").click(function()
{
	 $.ajax({ 
         type: "POST",  
         url:"/CommercialCity/shopperLogin",
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
                           //alert(data);
                    	   alert(data.message);
                    	   window.location.href = "/CommercialCity/Shop/message/ShopperMessage.jsp";
                       }
                  }            
            });
});
})
