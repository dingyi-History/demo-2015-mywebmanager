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
			<br>
			<table class="am-table   am-table-hover am-text-center"  style="background:white;">
    <tbody>
        <tr >
            <td >用户ID</td>
            <td>${userinfo.uid}</td>
        </tr>
         <tr>
            <td>用户名</td>
            <td>${userinfo.uname}</td>
        </tr>
         <tr>
            <td>用户昵称</td>
            <td>${userinfo.unickname}</td>
        </tr>
         <tr>
            <td>QQ</td>
            <td>${userinfo.uqq}</td>
        </tr>
         <tr>
            <td>邮箱</td>
            <td>${userinfo.uemail}</td>
        </tr>
    </tbody>
        </table>
  <a href="<%=request.getContextPath() %>/user/upinfo"><button type="button" class="am-btn am-btn-primary am-btn-block" >更改信息</button>
</a>

			
			</div>
			<br> <br> <br>
		</div>


	</div>
</div>





<%@ include file="/pages/frontend/public/footer.jsp"%>