<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/pages/frontend/public/header.jsp"%>



<div id="userbg">
<div class="am-g am-g-fixed">
<br>
<div id="baidubg">
<div class="am-u-sm-10 am-u-sm-offset-2">
 <form action="http://www.baidu.com/baidu" target="_blank">
<table bgcolor="#FFFFFF"><tr><td>
<input name=tn type=hidden value=baidu>

<input type=text name=word size=50 style="border-radius:2px;">
<input type="submit" value="百度一下" class="am-btn am-btn-default am-radius" id="baiduyixia">
</td></tr></table>
</form>
</div>
</div>
<br>

<ul id="topbar" class="am-nav am-nav-pills am-nav-justify"  data-am-sticky="{top:80}">
  <li  class="am-active"><a href="<%=request.getContextPath()%>/web/myweb">网址收录</a></li>
			<li ><a href="<%=request.getContextPath()%>/account/myaccount">账号收录</a></li>
			<li><a href="<%=request.getContextPath()%>/user/info">我的信息</a></li>
			<li><a href="<%=request.getContextPath()%>/user/upwd">密码修改</a></li>
</ul>
 <br>

<div id="page" style="min-height:600px;">
<c:forEach items="${weblist}" var="map" varStatus="status"> 
  
  
  <div class="am-u-sm-6 am-u-md-3  am-u-end am-text-center"  data-am-scrollspy="{animation: 'fade', delay: 300}" style="background:white;border-radius:5px;margin:5px;max-width:224px;">
  
  <h3 class="am-text-middle"> ${map.getWname()} </h3>
   <p class="am-text-middle">${map.getWurl()}</p>
 
  </div>
  
</c:forEach>

</div>
</div>
</div>




<%@ include file="/pages/frontend/public/footer.jsp"%>