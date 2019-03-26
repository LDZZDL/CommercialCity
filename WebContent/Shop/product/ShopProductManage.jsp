<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shopproductmanage.css" type="text/css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/script/shopproductmanage.js" type="text/javascript"></script>

</head>
<body>
	<!-- 商家商品管理 -->
	<h2>商家商品管理</h2>
  <div class="sidebar1">
    <h3 id="sidebar">商家个人管理</h3>
    <div id="line"></div>
    <ul class="nav">
      <li><a href="/CommercialCity/Shop/message/ShopperMessage.jsp">信息管理<span class="jiange">></span></a></li> 
      <li><a href="/CommercialCity/Shop/product/ShopProductManage.jsp" style="background-color:#f00; color:#fff;">商品管理<span class="jiange">></span></a></li>
      <li><a href="/CommercialCity/Shop/ShopperOrderManage.jsp">订单管理<span class="jiange">></span></a></li>
      <li><a href="/CommercialCity/Shop/ShopperSalesRecord.jsp">销售统计<span class="jiange">></span></a></li>
    </ul>
    <div style="height:250px;"></div>
  </div>
  <div id="content">
    <div id="screen">
      <label style="margin-left:10px;">查询</label>
      <input type="text" id="searchValue" placeholder="请输入书名或作者">
      <label>排序</label>
      <select id="orderType">
        <option>价格从低到高</option>
        <option>价格从高到低</option>
        <option>库存从少到多</option>
        <option>库存从多到少</option>
        <option>上架时间从远到近</option>
        <option>上架时间从近到远</option>
      </select>
      <label>价格区间</label>
      <input type="text" id="priceRangeLeft" placeholder="下限">
      —
      <input type="text" id="priceRangeRight" placeholder="上限">
      <input type="button" id="searchButton" class="button" value="搜索" style="margin-left:20px;">
    </div>
    <div>
      <table>
        <tr>
          <th width="100">名称</th>
          <th width="100">作者</th> 
          <th width="60">价格</th>
          <th width="60">库存</th>
          <th width="150">上架时间</th>
          <th width="150">&nbsp;&nbsp;&nbsp;操作&nbsp;&nbsp;&nbsp;<button id="shelf">&nbsp;新书上架&nbsp;</button></th>
        </tr>
      </table>
    </div>
    <div style="margin-top:20px">
      <button id="previousPage" style="margin-left:230px">上一页</button>
        <span id="pageNo" style="margin-left:10px"></span>|
        <span id="totalPageNo" style="margin-right:10px"></span>
      <button id="nextPage">下一页</button>
    </div> 
  </div>
  
  
  
  <!--商品上架、修改盒子-->
  
  
   <div class="box" id="shelfBox">
    <div style="background:#F7F7F7">
      <span id="heading">商品</span><a href="javascript:void(0)" title="关闭窗口" class="close_btn" id="ScloseBtn">×</a>
    </div>
    <div class="kind">
      <div style="float:left">
        <label class="attribute" for="productName">书名</label>
        <input type="text" class="input" id="productName" placeholder="请输入书名">
        
      </div>
      <div>
        <label class="attribute" for="writer">作者</label>
        <input type="text" class="input" id="writer" placeholder="请输入作者名">
      </div>
    </div>
    <div class="kind">
      <label class="attribute" for="productIntroduction" style="line-height:25px">书籍<br>介绍</label>
      <textarea id="productIntroduction" placeholder="请输入书籍介绍"></textarea>
    </div>
    <div class="kind">
      <div style="float:left">
        <label class="attribute" for="productSale">价格</label>
        <input type="text" class="input" id="productSale" placeholder="请输入价格">
      </div>
      <div>
        <label class="attribute" for="productStock">库存</label>
        <input type="text" class="input" id="productStock" placeholder="请输入库存">
      </div>
    </div>
    <div class="kind">
      <div style="float:left">
        <span class="attribute">类别</span> 
        <select id="productClass" class="input">
          <option>教育</option>
          <option>小说</option>
          <option>文艺</option>
          <option>青春文学/动漫-幽默</option>
          <option>生活</option>
          <option>人文社科</option>
          <option>经管</option>
          <option>励志/成功</option>
          <option>科技</option>
        </select>
      </div>
      <div>
        <label class="attribute" for="publishingHouse" style="margin-left:3px">出版社</label>
        <input type="text" class="input" id= "publishingHouse" placeholder="请输入出版社">
      </div>
    </div>
    <div class="kind">
      <label class="attribute" for="productAttribute">参数</label>
      <textarea id="productAttribute" placeholder="请输入参数"></textarea>
    </div>
    <div class="kind" id="pictureDiv">
      <form  method="post" enctype="multipart/form-data">
        <div style="float:left;">
          <label class="attribute">展示图片</label>
          <input type="file" name="productShowPicture" id="productShowPicture" class="file">
          <div class="img_div">
            <div id="img">
            </div>
          </div>
        </div>
        <div style="float:left">
          <label class="attribute" id="pictureError" style="width:290px;">介绍图片(3张)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
          <input type="file" name="productIntroductionPictureOne" id="productIntroductionPicture1" class="file">
          <input type="file" name="productIntroductionPictureTwo" id="productIntroductionPicture2" class="file">
          <input type="file" name="productIntroductionPictureThree" id="productIntroductionPicture3" class="file">
          <div class="img_div">
            <div id="img1">
            </div>
            <div id="img2">
            </div>
            <div id="img3">
            </div>
          </div>
        </div>
      </form>
      
    </div>
    <div class="kind" style="float:left;">
      <input type="button" id="shelfsubmit" value="确 定">
    </div>  
  </div>
  
  <div id="mask"></div>
  <div id="showimg_shade">
    <img id="showimg">
  </div>
  
</body>
</html>
