<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/pages/frontend/public/header.jsp"%>

<div id="bg">
	<div class="am-g am-g-fixed">
	  <br>	
  <div id="loginpage"  class="am-u-sm-8 am-u-md-6 am-u-sm-centered">

  <h2 style="color:white;">加入我们吧！<small>Let's go</small></h2>
    <form class="am-form" action="<%=request.getContextPath()%>/user/isregister" method="post">
      <fieldset class="am-form-set">
        <input  type="text" placeholder="取个名字" required name="uname">
        <input  type="text" placeholder="设个密码" required name="upwd1">
        <input  type="text" placeholder="确认密码" required name="upwd2">
        <input  type="text" placeholder="取个昵称" required name="unickname">
      </fieldset>
      <button type="submit" class="am-btn am-btn-success am-btn-block" >注册个账号</button>
      <a href="<%=request.getContextPath()%>/user/login" ><button style="margin-top:5px;"type="button" class="am-btn am-btn-primary am-btn-block">有账号去登录</button></a>
    </form>
  </div>


		
	</div>



</div>






<%@ include file="/pages/frontend/public/footer.jsp"%>