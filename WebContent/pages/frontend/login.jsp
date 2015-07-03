<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/pages/frontend/public/header.jsp"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div id="bg">
	<div class="am-g am-g-fixed">
		  <br><br>
  <div  id="loginpage"  class="am-u-sm-8 am-u-md-6 am-u-sm-centered">

  <h2 style="color:white;">欢迎您的到来！<small>GOGOGO</small></h2>
    <form class="am-form"  action="<%=request.getContextPath()%>/user/islogin" method="post">
      <fieldset class="am-form-set">
        <input  type="text" placeholder="用户名" required name="uname">
        <input  type="password" placeholder="密码" required name="upwd">
 
      </fieldset>
      <button type="submit" class="am-btn am-btn-success am-btn-block" >登录</button>
      <a href="<%=request.getContextPath()%>/user/register" ><button style="margin-top:5px;"type="button" class="am-btn am-btn-primary am-btn-block">没账号去注册</button></a>
    </form>
    
  
  </div>


		
	</div>



</div>





<%@ include file="/pages/frontend/public/footer.jsp"%>