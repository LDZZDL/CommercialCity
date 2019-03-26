$(function()
{
	var record_html="";
	var today_html="";
	var pageNo=1;
	var orderType="SVA";
	var time="所有";
	
	
	//页面初始化
	loadPage();
	
	
	
	
	//上下翻页
	$(".previousPage").click(function()
	{
		if($(this).parent().find(".pageNo").text()>1)
		{
			$("#record").html("");
			$("#todayProductQuantity").remove();
			$("#todayOrderQuantity").remove();
			$("#todaySaleMoney").remove();
			pageNo=pageNo-1;
			loadPage();
		}
	})
	$(".nextPage").click(function()
	{
		if($(this).parent().find(".pageNo").text()!=$(this).parent().find(".totalPageNo").text())
		{
			$("#record").html("");
			$("#todayProductQuantity").remove();
			$("#todayOrderQuantity").remove();
			$("#todaySaleMoney").remove();
			pageNo=pageNo+1;
			loadPage();
		}
	})
	
	//筛选
	$("#orderType").change(function()
	{
		$("#record").html("");
		$("#todayProductQuantity").remove();
		$("#todayOrderQuantity").remove();
		$("#todaySaleMoney").remove();
		orderType=$(this).val();
		pageNo=1;
		loadPage();
	})
	$("#time").change(function()
	{
		$("#record").html("");
		$("#todayProductQuantity").remove();
		$("#todayOrderQuantity").remove();
		$("#todaySaleMoney").remove();
		time=$(this).val();
		pageNo=1;
		loadPage();
	})
	
	
	function loadPage()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/shopSaleDate?action=PS",
                    data:{"orderType":orderType,"pageNo":pageNo,"day":time},
                    dataType:"json",
                    async:false,
                    success: function(data)
                    {
						var page=data.page;
						var product=data.product;
						var quantity=data.quantity;
						var today=data.today;
						$(".pageNo").text(page.pageNo);
						$(".totalPageNo").text(page.totalPageNo);
						today_html="";
						today_html="<span id='todayProductQuantity'>今日销量："+data.todayproductquantity+"</span><span id='todayOrderQuantity'>今日订单量："+data.todayorderquantity+"</span><span id='todaySaleMoney'>今日销售额：¥"+data.todaysalemoney+"</span>";
						$("#screen").append(today_html);
						for(var i=0;i<product.length;i++)
						{
							record_html="";
							record_html="<div class='record'><img src='"+product[i].productShowPicture+"' class='recordImg'><span class='productName'>书名："+product[i].productName+"</span><span class='productSale'>价格：¥"+product[i].productSale+"</span><span class='productStock'>库存："+product[i].productStock+"</span><span class='sale'>销量："+quantity[i]+"</span></div>";
							$("#record").append(record_html);
						}
						
					},
					error:function(XMLHttpRequest, textStatus, errorThrown) {
						//这个error函数调试时非常有用，如果解析不正确，将会弹出错误框
						　　　　alert(XMLHttpRequest.responseText); 
						alert(XMLHttpRequest.status);
						alert(XMLHttpRequest.readyState);
						alert(textStatus); // parser error;
						}
					
		     })
	}
})