// JavaScript Document
$(function(){
	var width=$(window).width();
	var height=$(window).height();
	$("#background").height(height-2*$("h2").height());
	$(".kind1").css("margin-left",width*0.25);
	$(".img_div").css("margin-left",width*0.25);
	$(".kind2").css("margin-left",width*0.6);
	$(".picture").css("margin-top",height*0.13);
	var img_html;//图片内容
	var objurl;//路径
	$("#myfile").change(function()
	{	
		//鉴定格式及显示预览
		var img_div=$(".img_div");
		var filepath=$("#myfile").val(); 
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
		   
		    return false;
		}
		else
		{
			$(".img_div").html("");
			img_html = "<div class='isImg'><img id='picture' src='" + objurl + "'  style='height: 100%; width: 100%;' /></div>";
			img_div.append(img_html);
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
	//验证店铺名称
	$("#shopName").blur(function()
	{		
	    var $parent = $(this).parent();
        
        if( this.value=="" )
        {
        	$parent.find(".formtips").remove();
             var errorMsg = '店铺名称不能为空.';
             $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
        }
        else
        {
		    if(!/^[a-zA-Z\u4e00-\u9fa5]+$/g.test(this.value))
		    {
		    	$parent.find(".formtips").remove();
			    var errorMsg = '输入非法字符！';
                $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
		    }
		    else
		    {  
			    if(this.value.length>40)
			    {
			    	$parent.find(".formtips").remove();
				    var errorMsg = '长度不合法,应小于40个字母或汉字.';
                    $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			    } 
			    else
			    {
				 $.ajax({  
                      type: "POST",  
                      url:"/CommercialCity/shopperRegister?action=ShopRegister&actionRegister=check",
                      data:{"shopName":this.value},
                      dataType:"json",
                      success: function(data){   
 if(data.status=="false") 
 {
	 $parent.find(".formtips").remove();
	 $parent.append('<span class="formtips onError">'+data.message+'</span>');
 }
 else
 { 
	 $parent.find(".formtips").remove();
 var ok="通过.";
$parent.append('<span class="formtips onSuccess">'+ok+'</span>');
 }
                                             }            
                       });
			    }
           }
      }
	})
    //验证店铺介绍
	$("#introduction").blur(function()
	{		
	    var $parent = $(this).parent();
        $parent.find(".formtips").remove();
        if( this.value=="" )
        {
             var errorMsg = '店铺介绍不能为空.';
             $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
        }
        else
        {
		      
			     if(this.value.length>200)
			     {
				     var errorMsg = '长度不合法,应小于200个字母或汉字.';
                     $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
			     } 
			     else
			     {	 
                      var ok="通过.";
                      $parent.append('<span class="formtips onSuccess">'+ok+'</span>');
                 }
            
        }
   }) 
   //图片删除
	/*$(".removeBtn").on('click',function()
	{
		alert("uyoui");
		$(".img_div").html("");
	})*/
	/*$("#picture").mouseover()(function()
	{
		alert("you");
		$(".removeBtn").css("display","block");
	})*/
    //提交，最终验证。
    $('#send').click(function()
	{
        $("#shopName").trigger('blur');
	    $("#introduction").trigger('blur');
		var filepath=$("#myfile").val();
		var numError = $('form .onError').length;
		if(!filepath)
		{
			alert("店铺头像未设置");
		}
		else
		{
			if(numError)
			{} 
		    else
		    {
                 alert("注册成功.");
			     $("form").submit();
			}
		}             
    });
	 //重置
    $('#res').click(function()
	{
        $(".formtips").remove(); 
        $(".img_div").html("");
    });
}) 
