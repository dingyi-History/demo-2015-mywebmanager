<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/pages/frontend/public/header.jsp"%>

<div id="userbg">
	<div class="am-g am-g-fixed">
	<br>

<%@ include file="/pages/frontend/public/topbar.jsp"%>
 <br>
 	<div id="page">
  <div class="am-u-sm-8 am-u-md-6  am-u-sm-centered">
 
 
   
  <h2 style="color:black;">密码修改</h2>
    <form class="am-form" action="<%=request.getContextPath()%>/user/updatepwd" method="post">
      <fieldset class="am-form-set">
        <input  type="password" placeholder="旧密码" required name="oldpwd">
        <input  type="password" placeholder="新的密码" required name="upwd1">
        <input  type="password" placeholder="确认密码" required name="upwd2">
      </fieldset>
      <button type="submit" class="am-btn am-btn-primary am-btn-block" >修改密码</button>
    </form>
  </div>
   <br>
    <br>
      <br>  
      <br>
       <br>
</div>
 
      
</div>
</div>
<%@ include file="/pages/frontend/public/footer.jsp"%>