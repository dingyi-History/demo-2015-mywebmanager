<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/pages/backend/common/header.jsp"%>

<div id="bg2">
	<div class="am-g am-g-fixed">
		
  <div class="am-u-sm-8 am-u-md-6 am-u-sm-centered">
  <br><br>
  <h2 style="color:white;">后台管理<small>mywebmanager</small></h2>
    <form class="am-form" action="<%=request.getContextPath()%>/adminhandler/isadmin" method="post">
      <fieldset class="am-form-set">
        <input  type="text" placeholder="用户名" required name="aname">
        <input  type="password" placeholder="密码" required name="apwd">
 
      </fieldset>
      <button type="submit" class="am-btn am-btn-success am-btn-block" >登录</button>
      <a href="<%=request.getContextPath()%>" ><button style="margin-top:5px;"type="button" class="am-btn am-btn-primary am-btn-block">回首页</button></a>
    </form>
  </div>
	</div>
</div>





<%@ include file="/pages/backend/common/footer.jsp"%>