// JavaScript Document
$(function()
{
	var picturepath="/CommercialCity/commercialcity/productexample.png";
	var img_html;//生成img，有删除按钮
	var table_html="";
	var test=0;//判断是商品上架还是修改
	var productId=0;
	var totalProductNumber=0;//用于商品删除时传给后台商品总数
	//加载函数data部分变量
	var searchValue="";
	var orderType="TA";
	var priceRangeLeft="";
	var priceRangeRight="";
	var pageNo=1;
	//
	
	
	//页面初始化
	loadPage();
	//图片初始化
	loadPicture();
	
	
	
	

	
	//盒子部分
	//开关
	$("#shelf").click(function()
	{
		test=2;
		$("#mask").fadeIn("slow");
		$("#productName").val("");
		$("#productIntroduction").val("");
		$("#productSale").val("");
		$("#productStock").val("");
		$("#productClass").val("小说");
		$("#writer").val("");
		$("#publishingHouse").val("");
		$("#productAttribute").val("");
		$("#img").html("");
		$("#img1").html("");
		$("#img2").html("");
		$("#img3").html("");
		loadPicture();
		$("#shelfBox").fadeIn("slow");
	})
	$("#ScloseBtn").click(function()
	{
		$("#mask").fadeOut("fast");
		$("#shelfBox").fadeOut("slow");
	})
	
	//上下翻页、筛选搜索
	$("#previousPage").click(function()
	{
		if($("#pageNo").text()!=1)
		{
			$(".productId").parent().remove();
			pageNo=pageNo-1;
			loadPage();
		}
	})
	$("#nextPage").click(function()
	{
		if($("#pageNo").text()!=$("#totalPageNo").text())
		{
			$(".productId").parent().remove();
			pageNo=pageNo+1;
			loadPage();
		}
	})
	$("#searchButton").click(function()
	{
		$(".productId").parent().remove();
		var orderType1=$("#orderType").val();
	    searchValue=$("#searchValue").val();
	    priceRangeLeft=$("#priceRangeLeft").val();
	    priceRangeRight=$("#priceRangeRight").val();
	    pageNo=1;
	    if(orderType1=="价格从低到高")
	    {
		    orderType="PA";
	    }
	    else if(orderType1=="价格从高到低")
	    {
		    orderType="PD";
	    }
	    else if(orderType1=="库存从少到多")
	    {
		    orderType="QA";
	    }
	    else if(orderType1=="库存从多到少")
	    {
		    orderType="QD";
	    }
	    else if(orderType1=="上架时间从远到近")
	    {
		    orderType="TA";
	    }
	    else if(orderType1=="上架时间从近到远")
	    {
		    orderType="TD";
	    }
		loadPage();
	})
	
	
	
	//信息检测
	$("#productName").blur(function()
	{
		var $parent=$(this).parent();
		$("#productName").parent().find(".formtips").remove();
          if( this.value=="" )
		  {
              var errorMsg = '不能为空.';
              $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
          }
		  else
		  {
			  
			      if(this.value.length>40)
			      {
				       var errorMsg = '字数过多.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			       } 
          }
	})
	$("#productIntroduction").blur(function()
	{
		var $parent=$(this).parent();
		$("#productIntroduction").parent().find(".formtips").remove();
          if( this.value=="" )
		  {
              var errorMsg = '不能为空.';
              $parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
          }
		  else
		  {
			      if(this.value.length>200)
			      {
				       var errorMsg = '字数过多.';
                       $parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			       } 
          }
	})
	$("#productSale").blur(function()
	{
		var $parent=$(this).parent();
		$("#productSale").parent().find(".formtips").remove();
          if( this.value=="" )
		  {
              var errorMsg = '不能为空.';
              $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
          }
		  else
		  {
			  if(!/^[0-9.]+$/g.test(this.value))
			  {
					 var errorMsg = '非法字符！';
                     $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			  }
			  else
			  {  
			      if(this.value.length>7)
			      {
				       var errorMsg = '长度太长.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			      } 
               }
          }
	})
	$("#productStock").blur(function()
	{
		var $parent=$(this).parent();
		$("#productStock").parent().find(".formtips").remove();
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
			      if(this.value.length>7)
			      {
				       var errorMsg = '长度太长.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			      } 
               }
          }
	})
	$("#writer").blur(function()
	{
		var $parent=$(this).parent();
		$("#writer").parent().find(".formtips").remove();
          if( this.value=="" )
		  {
              var errorMsg = '不能为空.';
              $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
          }
		  else
		  {
			      if(this.value.length>40)
			      {
				       var errorMsg = '字数过多.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			       } 
          }
	})
	$("#publishingHouse").blur(function()
	{
		var $parent=$(this).parent();
		$("#publishingHouse").parent().find(".formtips").remove();
          if( this.value=="" )
		  {
              var errorMsg = '不能为空.';
              $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
          }
		  else
		  {
			      if(this.value.length>40)
			      {
				       var errorMsg = '字数过多.';
                       $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			       } 
          }
	})
	$("#productAttribute").blur(function()
	{
		var $parent=$(this).parent();
		$("#productAttribute").parent().find(".formtips").remove();
          if( this.value=="" )
		  {
              var errorMsg = '不能为空.';
              $parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
          }
		  else
		  {
			      if(this.value.length>200)
			      {
				       var errorMsg = '字数过多.';
                       $parent.append('<span class="formtips onError error">'+errorMsg+'</span>');
			       } 
          }
	})
	
	
	
	//确定按钮
	$("#shelfsubmit").mousedown(function()
	{
		$("#pictureDiv").find(".onError").remove();
		$("#productName").trigger('blur');
		$("#productIntroduction").trigger('blur');
		$("#productSale").trigger('blur');
		$("#productStock").trigger('blur');
		$("#writer").trigger('blur');
		$("#publishingHouse").trigger('blur');
		$("#productAttribute").trigger('blur');
		var length=$(".removebtn").length;
		if(length!=4)
		{
			alert(length);
			var errorMsg = '(有图片未上传.)';
            $("#pictureError").append('<span class="formtips onError pictureError" >'+errorMsg+'</span>');
		}
	})
	$("#shelfsubmit").mouseup(function()
	{
		var numError=$(".onError").length;
		if(!numError)
		{
			if(test==1)
			{
		        $.ajax({  
                        type: "POST",  
                        url:"/CommercialCity/shopProductManage?action=ChangeProductMessageForm",
                        data:{productId:productId,productName:$("#productName").val(),productIntroduction:$("#productIntroduction").val(),productSale:$("#productSale").val(),productStock:$("#productStock").val(),productClass:$("#productClass").val(),writer:$("#writer").val(),publishingHouse:$("#publishingHouse").val(),productAttribute:$("#productAttribute").val(),searchValue:searchValue,orderType:orderType,priceRangeLeft:priceRangeLeft,priceRangeRight:priceRangeRight,pageNo:pageNo},
                        dataType:"json",
		          })
				  alert("修改成功");
				  $("form").attr("action","/CommercialCity/shopProductManage?action=ChangeProductMessageNotForm");
				  $("form").submit();
			}
			else if(test==2)
			{
				$.ajax({  
                        type: "POST",  
                        url:"/CommercialCity/shopProductManage?action=AddProduct&goal=Form",
                        data:{productName:$("#productName").val(),productIntroduction:$("#productIntroduction").val(),productSale:$("#productSale").val(),productStock:$("#productStock").val(),productClass:$("#productClass").val(),writer:$("#writer").val(),publishingHouse:$("#publishingHouse").val(),productAttribute:$("#productAttribute").val(),searchValue:searchValue,orderType:orderType,priceRangeLeft:priceRangeLeft,priceRangeRight:priceRangeRight,pageNo:pageNo},
                        dataType:"json",
		          })
				  alert("上架成功");
				  $("form").attr("action","/CommercialCity/shopProductManage?action=AddProduct&goal=NotForm");
				  $("form").submit();
			}
		}
	})
	
	
	
	
	
	
	
//图片预览
	$("#productShowPicture").change(function()
	{	
		//鉴定格式及显示预览
		var img_div=$("#img");
		var filepath=$("#productShowPicture").val(); 
		objurl=getObjectURL(this.files[0]);
		var extStart=filepath.lastIndexOf(".");
		//从后向前搜索字符出现位置，正向位置
		var ext=filepath.substring(extStart,filepath.length).toUpperCase();
		//substring() 方法用于提取字符串中介于两个指定下标之间的字符。
		//toUpperCase() 方法用于把字符串转换为大写。
		if(ext!=".JPG"&&ext!=".PNG"&&ext!=".JPEG")
		{
			alert("图片仅限于jpg,jpeg,png格式");
		    this.value="";
		    $("#img").html("");
		    return false;
		}
		else
		{
			$("#img").html("");
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
				$("#img").append("<img id='aimg' class='picture'>");
				$("#aimg").attr("src",picturepath);
				$("#aimg").click(function()
				{
					$("#productShowPicture").click();
				})
				
			})
			return true;
		}
	})
	$("#productIntroductionPicture1").change(function()
	{	
		//鉴定格式及显示预览
		var img_div=$("#img1");
		var filepath=$("#productIntroductionPicture1").val(); 
		objurl=getObjectURL(this.files[0]);
		var extStart=filepath.lastIndexOf(".");
		//从后向前搜索字符出现位置，正向位置
		var ext=filepath.substring(extStart,filepath.length).toUpperCase();
		//substring() 方法用于提取字符串中介于两个指定下标之间的字符。
		//toUpperCase() 方法用于把字符串转换为大写。
		if(ext!=".JPG"&&ext!=".PNG"&&ext!=".JPEG")
		{
			alert("图片仅限于jpg,jpeg,png格式");
		    this.value="";
		    $("#img1").html("");
		    return false;
		}
		else
		{
			$("#img1").html("");
			img_html = "<img src='" + objurl + "' id='bimg1' class='picture' /><button id='removePictureButton1' class='removebtn'>X</button>";
			img_div.append(img_html);
			$("#bimg1").click(function()
			{
				$("#showimg").attr("src",objurl);
				$("#showimg_shade").fadeIn("slow");
			})
			$("#removePictureButton1").click(function()
			{
				$(this).parent().html("");
				$("#img1").append("<img id='aimg1' class='picture'>");
				$("#aimg1").attr("src",picturepath);
				$("#aimg1").click(function()
				{
					$("#productIntroductionPicture1").click();
				})
				
			})
			return true;
		}
	})
	$("#productIntroductionPicture2").change(function()
	{	
		//鉴定格式及显示预览
		var img_div=$("#img2");
		var filepath=$("#productIntroductionPicture2").val(); 
		objurl=getObjectURL(this.files[0]);
		var extStart=filepath.lastIndexOf(".");
		//从后向前搜索字符出现位置，正向位置
		var ext=filepath.substring(extStart,filepath.length).toUpperCase();
		//substring() 方法用于提取字符串中介于两个指定下标之间的字符。
		//toUpperCase() 方法用于把字符串转换为大写。
		if(ext!=".JPG"&&ext!=".PNG"&&ext!=".JPEG")
		{
			alert("图片仅限于jpg,jpeg,png格式");
		    this.value="";
		    $("#img2").html("");
		    return false;
		}
		else
		{
			$("#img2").html("");
			img_html = "<img src='" + objurl + "' id='bimg2' class='picture' /><button id='removePictureButton2' class='removebtn'>X</button>";
			img_div.append(img_html);
			$("#bimg2").click(function()
			{
				$("#showimg").attr("src",objurl);
				$("#showimg_shade").fadeIn("slow");
			})
			$("#removePictureButton2").click(function()
			{
				$(this).parent().html("");
				$("#img2").append("<img id='aimg2' class='picture'>");
				$("#aimg2").attr("src",picturepath);
				$("#aimg2").click(function()
				{
					$("#productIntroductionPicture2").click();
				})
				
			})
			return true;
		}
	})
	$("#productIntroductionPicture3").change(function()
	{	
		//鉴定格式及显示预览
		var img_div=$("#img3");
		var filepath=$("#productIntroductionPicture3").val(); 
		objurl=getObjectURL(this.files[0]);
		var extStart=filepath.lastIndexOf(".");
		//从后向前搜索字符出现位置，正向位置
		var ext=filepath.substring(extStart,filepath.length).toUpperCase();
		//substring() 方法用于提取字符串中介于两个指定下标之间的字符。
		//toUpperCase() 方法用于把字符串转换为大写。
		if(ext!=".JPG"&&ext!=".PNG"&&ext!=".JPEG")
		{
			alert("图片仅限于jpg,jpeg,png格式");
		    this.value="";
		    $("#img3").html("");
		    return false;
		}
		else
		{
			$("#img3").html("");
			img_html = "<img src='" + objurl + "' id='bimg3' class='picture' /><button id='removePictureButton3' class='removebtn'>X</button>";
			img_div.append(img_html);
			$("#bimg3").click(function()
			{
				$("#showimg").attr("src",objurl);
				$("#showimg_shade").fadeIn("slow");
			})
			$("#removePictureButton3").click(function()
			{
				$(this).parent().html("");
				$("#img3").append("<img id='aimg3' class='picture'>");
				$("#aimg3").attr("src",picturepath);
				$("#aimg3").click(function()
				{
					$("#productIntroductionPicture3").click();
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



    function loadPage()
    {
	    $.ajax({  
                    type: "POST",  
                    url:"/CommercialCity/shopProductManage?action=ShowProductMessage",
                    data:{searchValue:searchValue,orderType:orderType,priceRangeLeft:priceRangeLeft,priceRangeRight:priceRangeRight,pageNo:pageNo},
                    dataType:"json",
                    success: function(data){
	    var pageAttribute=data.pageAttribute;
	    var message=data.message;
	    for(var k in pageAttribute[0])
	    {
		    if(k=="pageNo")
		    {
		    	$("#pageNo").text(pageAttribute[0][k]);
		    	pageNo=pageAttribute[0][k];
		    }
		    else if(k=="totalProductNumber")
		    {
			    totalProductNumber=pageAttribute[0][k];
		    }
		    else if(k=="totalPageNo")
		    {
			    $("#totalPageNo").text(pageAttribute[0][k]);
		    }
		    else if(k=="searchValue")
		    {
			    $("#searchValue").val(pageAttribute[0][k]);
			    searchValue=pageAttribute[0][k];
		    }
		    else if(k=="orderType")
		    {
			    orderType=pageAttribute[0][k];
			    if(pageAttribute[0][k]=="TA")
			    {
			    	$("#orderType").val("上架时间从远到近");
			    }
			    else if(pageAttribute[0][k]=="TD")
			    {
				    $("#orderType").val("上架时间从近到远");
			    }
			    else if(pageAttribute[0][k]=="PA")
			    {
				    $("#orderType").val("价格从低到高");
			    }
			    else if(pageAttribute[0][k]=="PD")
			    {
				    $("#orderType").val("价格从高到低");
			    }
			    else if(pageAttribute[0][k]=="QA")
			    {
				    $("#orderType").val("库存从少到多");
			    }
			    else if(pageAttribute[0][k]=="QD")
			    {
				    $("#orderType").val("库存从多到少");
			    }
		    }
		    else if(k=="priceRangeLeft")
		    {
			    $("#priceRangeLeft").val(pageAttribute[0][k]);
			    priceRangeLeft=pageAttribute[0][k];
		    }
		    else if(k=="priceRangeRight")
		    {
			    $("#priceRangeRight").val(pageAttribute[0][k]);
			    priceRangeRight=pageAttribute[0][k];
		    }
	    }
	    for(var i=0;i<message.length;i++)
	    {
		    for(var j in message[i])
		    {
		        if(j=="productName")
		        {
		    	    //alert("receivername");
				    table_html="";
			        table_html="<tr><td class='productName'>"+message[i][j]+"</td>";
		        }
			    else if(j=="writer")
		        {
			        table_html=table_html+"<td class='writer'>"+message[i][j]+"</td>";
		        }
			    else if(j=="productSale")
		        {
			         table_html=table_html+"<td class='productSale'>"+message[i][j]+"</td>";
		        }
			    else if(j=="productStock")
		        {
			        table_html=table_html+"<td class='productStock'>"+message[i][j]+"</td>";
		        }
			    else if(j=="shelfTime")
		        {
			        table_html=table_html+"<td class='shelfTime'>"+message[i][j]+"</td>";
		        }
			    else if(j=="productId")
		        {
			        table_html=table_html+"<td class='productId'>"+message[i][j]+"</td><td><button class='alter'>修改</button>|<button class='remove'>删除</button>|<button class='preview'>预览</button></td></tr>";
				    $("table").append(table_html);
				    
		        }  
		    }
	    }
	  //修改
	    $(".alter").click(function()
	    {
	    	//alert("修改");
		    test=1;
		    $("#mask").fadeIn("slow");
		    var $parent=$(this).parent().parent();
		    productId=$parent.find(".productId").text();
		    $.ajax({  
                                   type: "POST",  
                        url:"/CommercialCity/shopProductManage?action=ShowDetailProductMessage",
                                    data:{productId:productId},
                        dataType:"json",
                                   success: function(data)
    {
		$("#productName").val(data.productName);
		$("#productIntroduction").val(data.productIntroduction);
		$("#productSale").val(data.productSale);
		$("#productStock").val(data.productStock);
		$("#productClass").val(data.productClass);
		$("#writer").val(data.writer);
		$("#publishingHouse").val(data.publishingHouse);
		$("#productAttribute").val(data.productAttribute);
		//图片放入
		$("#img").html("");
        img_html = "<img src='" + data.productShowPicture + "' id='bimg' class='picture' /><button id='removePictureButton' class='removebtn'>X</button>";
        $("#img").append(img_html);
        $("#bimg").click(function()
        {
	        $("#showimg").attr("src",data.productShowPicture);
	        $("#showimg_shade").fadeIn("slow");
        })
        $("#removePictureButton").click(function()
        {
	        $(this).parent().html("");
	        $("#img").append("<img id='aimg' class='picture'>");
	        $("#aimg").attr("src",picturepath);
	        $("#aimg").click(function()
	        {
		        $("#productShowPicture").click();
	        })
	
        })
		$("#img1").html("");
        img_html = "<img src='" + data.productIntroductionPictureOne + "' id='bimg1' class='picture' /><button id='removePictureButton1' class='removebtn'>X</button>";
        $("#img1").append(img_html);
        $("#bimg1").click(function()
        {
	        $("#showimg").attr("src",data.productIntroductionPictureOne);
	        $("#showimg_shade").fadeIn("slow");
        })
        $("#removePictureButton1").click(function()
        {
	        $(this).parent().html("");
	        $("#img1").append("<img id='aimg1' class='picture'>");
	        $("#aimg1").attr("src",picturepath);
	        $("#aimg1").click(function()
	        {
		        $("#productIntroductionPicture1").click();
	        })
	
        })
		$("#img2").html("");
        img_html = "<img src='" + data.productIntroductionPictureTwo + "' id='bimg2' class='picture' /><button id='removePictureButton2' class='removebtn'>X</button>";
        $("#img2").append(img_html);
        $("#bimg2").click(function()
        {
	        $("#showimg").attr("src",data.productIntroductionPictureTwo);
	        $("#showimg_shade").fadeIn("slow");
        })
        $("#removePictureButton2").click(function()
        {
	        $(this).parent().html("");
	        $("#img2").append("<img id='aimg2' class='picture'>");
	        $("#aimg2").attr("src",picturepath);
	        $("#aimg2").click(function()
	        {
		        $("#productIntroductionPicture2").click();
	        })
	
        })
		$("#img3").html("");
        img_html = "<img src='" + data.productIntroductionPictureThree + "' id='bimg3' class='picture' /><button id='removePictureButton3' class='removebtn'>X</button>";
        $("#img3").append(img_html);
        $("#bimg3").click(function()
        {
	        $("#showimg").attr("src",data.productIntroductionPictureThree);
	        $("#showimg_shade").fadeIn("slow");
        })
        $("#removePictureButton3").click(function()
        {
	        $(this).parent().html("");
	        $("#img3").append("<img id='aimg3' class='picture'>");
	        $("#aimg3").attr("src",picturepath);
	        $("#aimg3").click(function()
	        {
		        $("#productIntroductionPicture3").click();
	        })
	
        })
		
	},

	error: function(XMLHttpRequest, textStatus, errorThrown){
						alert(XMLHttpRequest);
						alert(textStatus);
						alert(errorThrown);
	}   
		})
		$("#shelfBox").fadeIn("slow");
	})
	//删除
	$(".remove").click(function()
	{
		//alert("remove");
		if(confirm("确定删除此商品？"))
		{
		     var $parent=$(this).parent().parent();
		     productId=$parent.find(".productId").text();
		     $.ajax({  
                         type: "POST",  
                         url:"/CommercialCity/shopProductManage?action=DeleteProduct",
                         data:{productId:productId,pageNo:pageNo,totalProductNumber:totalProductNumber},
                         dataType:"json",
						 success: function(data)
						 {
							 totalProductNumber=data.totalProductNumber;
							 pageNo=data.pageNo;
							 $("#pageNo").text(data.pageNo);
						 },
						 error: function(XMLHttpRequest, textStatus, errorThrown){
						alert(XMLHttpRequest);
						alert(textStatus);
						alert(errorThrown);
	                            }  
		           })
		           alert("删除成功");
				   $(".productId").parent().remove();
				   loadPage();
		}
	})
	//预览
	    $(".preview").click(function()
	    {
		    var $parent=$(this).parent().parent();
		    var Id=$parent.find(".productId").text();
		    var address1="/CommercialCity/Customer/Product/ProductPreview.jsp?id="+Id;
		    window.open(address1);
	    })
	},
	 			error: function(XMLHttpRequest, textStatus, errorThrown){
	 							alert(XMLHttpRequest);
	 							alert(textStatus);
	 							alert(errorThrown);
	 							}       
	      });
	}
	
	
	//图片框初始化
	function loadPicture()
	{
		$("#img").append("<img id='aimg' class='picture'>");
	    $("#aimg").attr("src",picturepath);
	    $("#aimg").click(function()
	    {
		    $("#productShowPicture").click();
	    })
	    $("#img1").append("<img id='aimg1' class='picture'>");  
	    $("#aimg1").attr("src",picturepath);
	    $("#aimg1").click(function()
	    {
		    $("#productIntroductionPicture1").click();
	    })
	    $("#img2").append("<img id='aimg2' class='picture'>"); 
	    $("#aimg2").attr("src",picturepath);
	    $("#aimg2").click(function()
	    {
		    $("#productIntroductionPicture2").click();
	    })
	    $("#img3").append("<img id='aimg3' class='picture'>");  
	    $("#aimg3").attr("src",picturepath);
	    $("#aimg3").click(function()
	    {
		    $("#productIntroductionPicture3").click();
	    })
	    $("#showimg_shade").click(function()
	    {
		    $("#showimg_shade").fadeOut("slow");
	    })
	}



    






/*function changeScreen()
{
	var orderType1=$("#orderType").val();
	searchValue=$("#searchValue").val();
	priceRangeLeft=$("#priceRangeLeft").val();
	priceRangeRight=$("#priceRangeRight").val();
	pageNo=$("#pageNo").text();
	if(orderType1=="价格从低到高")
	{
		orderType="PA";
	}
	else if(orderType1=="价格从高到低")
	{
		orderType="PD";
	}
	else if(orderType1=="库存从少到多")
	{
		orderType="QA";
	}
	else if(orderType1=="库存从多到少")
	{
		orderType="QD";
	}
	else if(orderType1=="上架时间从远到近")
	{
		orderType="TA";
	}
	else if(orderType1=="上架时间从近到远")
	{
		orderType="TD";
	}
}*/








})