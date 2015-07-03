<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/pages/frontend/public/header.jsp"%>


<div id="userbg">
	<div class="am-g am-g-fixed">

	<br>
		<ul id="topbar" class="am-nav am-nav-pills am-nav-justify">
			<li><a href="#">后台管理</a></li>
		</ul>
		<br>
		<ul id="topbar" class="am-nav am-nav-pills am-nav-justify"
			data-am-sticky="{top:80}">
			<li class="am-active"><a href="<%=request.getContextPath()%>/admin/alladmin">管理员信息</a></li>
			<li  ><a href="<%=request.getContextPath()%>/user/info">用户信息</a></li>
		</ul>
		<br>

		<div id="page">
			<div class="am-u-sm-8 am-u-md-10  am-u-sm-centered">
			<br>
		<table class="am-table   am-table-hover am-text-center"  style="background:white;">
		   <thead>
		     <tr>
            <th>用户ID</th>
            <th>用户名</th>
            <th>用户昵称</th>
            <th>QQ</th>
            <th>邮箱</th>
        </tr>
    	</thead>
    <tbody>
    	<c:forEach items="${alladminlist}" var="admin" varStatus="status">
        <tr >
            <td>${admin.getUaid()}</td>
            <td>${admin.getUaname()}</td>
            <td>${admin.getUapwd()}</td>
        </tr>
        </c:forEach>
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