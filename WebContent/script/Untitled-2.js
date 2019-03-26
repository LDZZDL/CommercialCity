// JavaScript Document
$(function(){
	$.ajax({
		url:"/CommercialCity/page",
		data:{},
		dataType:"json",
		async:false,
		success: function()
		{
			alert("ajax成功");
		}
	})
	alert("ajax执行完弹出");
	
	
	
	
})