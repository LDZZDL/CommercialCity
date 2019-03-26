// JavaScript Document
$(function()
{
	
	
	var thisURL =decodeURI(document.URL);    
    var productId=0;   
    var getval =thisURL.split('?');  
    if(getval.length>1)
	{
		for(var q=1;q<getval.length;q++)
		{
			var a=getval[q].split('=')[0];
			var b=getval[q].split('=')[1];
			if(a=="id")
			{
				//alert("a");
				productId=b;
			}
		}
	}
	
	
	
	
	
	//页面初始化
	loadPage();
	
	//数量input
	$("#quantity").keyup(function()
	{
		//alert("haode");
		if(!/^[0-9]+$/g.test(this.value))
		{
			$(this).val("1");
		}
		else
		{
			var a=$("#productStock").text();
			var b=$(this).val();
			if(eval(b)>eval(a))
			{
				alert("超出库存！");
				$(this).val("1");
			}
		}
	})
		
    function loadPage()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/customerMarket?action=Detail",
                    data:{productId:productId},
                    dataType:"json",
					async:false,
                    success: function(data){
	    var product=data.product;
		var customer=data.customer;
	    $("#productName").text(product.productName);
		$("#productIntroduction").text(product.productIntroduction);
		$("#productSale").text(product.productSale);
		$("#productClass").text(product.productClass);
		$("#writer").text(product.writer);
		$("#publishingHouse").text(product.publishingHouse);
		$("#productStock").text(product.productStock);
		$("#productAttribute").text(product.productAttribute);
		$("#productShowPicture").attr("src",product.productShowPicture);
		$("#productShowPicture").click(function()
	    {
		     $("#showimg").attr("src",product.productShowPicture);
		     $("#showimg_shade").fadeIn("slow");
	    })
		$("#productIntroductionPictureOne").attr("src",product.productIntroductionPictureOne);
		$("#productIntroductionPictureTwo").attr("src",product.productIntroductionPictureTwo);
		$("#productIntroductionPictureThree").attr("src",product.productIntroductionPictureThree);
		    
		},
				error: function(XMLHttpRequest, textStatus, errorThrown){
	 							alert(XMLHttpRequest);
	 							alert(textStatus);
	 							alert(errorThrown);
	 		}   
					})
	}
    
	
	
					
	
	
	
	
    $("#showimg_shade").click(function()
	{
		$("#showimg_shade").fadeOut("slow");
	})
    //数量增减
	$("#numDecrease").click(function()
	{
		var num=$("#quantity").val();
		if(num>1)
		{
			num--;
			$("#quantity").val(num);
		}
	})
	$("#numIncrease").click(function()
	{
		var num=$("#quantity").val();
		var stock=$("#productStock").text();
		if(eval(num)<eval(stock))
		{
			num++;
			$("#quantity").val(num);
		}
		else
		{
			alert("超出库存！");
		}
	})
    

})