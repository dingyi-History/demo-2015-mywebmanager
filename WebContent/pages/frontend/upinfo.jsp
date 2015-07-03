<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/pages/frontend/public/header.jsp"%>


<div id="userbg">
	<div class="am-g am-g-fixed">

		<br>
		<ul id="topbar" class="am-nav am-nav-pills am-nav-justify"
			data-am-sticky="{top:80}">
			<li><a href="<%=request.getContextPath()%>/web/myweb">网址收录</a></li>
			<li ><a href="<%=request.getContextPath()%>/account/myaccount">账号收录</a></li>
			<li  class="am-active"><a href="<%=request.getContextPath()%>/user/info">我的信息</a></li>
			<li><a href="<%=request.getContextPath()%>/user/upwd">密码修改</a></li>
		</ul>
		<br>

		<div id="page">
			<div class="am-u-sm-8 am-u-md-6  am-u-sm-centered">
			<h2 style="color:black;">更改信息</h2>
    <form class="am-form" action="<%=request.getContextPath()%>/user/updateinfo" method="post">
      <fieldset class="am-form-set">
        <input  type="text" placeholder="昵称" value="${userinfo.unickname}" required name="unickname">
        <input  type="text" placeholder="QQ"  value="${userinfo.uqq }" required name="uqq">
        <input  type="email" placeholder="邮箱" value="${userinfo.uemail }" required name="uemail">
      </fieldset>
      <button type="submit" class="am-btn am-btn-success am-btn-block" >保存</button>
    </form>


			
			</div>
			<br> <br> <br>
		</div>


	</div>
</div>





<%@ include file="/pages/frontend/public/footer.jsp"%>