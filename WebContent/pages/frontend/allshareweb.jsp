<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div id="page" style="min-height:600px;">
<c:forEach items="${allshareweb}" var="map" varStatus="status"> 
  
  
  <div class="am-u-sm-6 am-u-md-3  am-u-end" data-am-scrollspy="{animation: 'fade', delay: 300}">
  
  <h3 class="am-text-middle"> ${map.swid } </h3>
  <div>
   <p class="am-text-middle">${map.suid }</p>
  </div>
 
  </div>
  
</c:forEach>

</div>
</div>
</div>
<%@ include file="/pages/frontend/public/footer.jsp"%>