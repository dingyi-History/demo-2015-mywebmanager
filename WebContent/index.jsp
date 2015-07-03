<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ include file="/pages/frontend/public/header.jsp"%>


<div  id="mainpage">
  <div class="am-g am-g-fixed" >
<div id="text" class="am-u-sm-centered" >
<img src="<%=request.getContextPath()%>/pages/assets/img/wenhao.png" alt="" style="max-height:400px; " class="am-u-sm-centered">
<h1 class="am-text-center" style="margin-top:0;" >你还在为繁杂的网络数据而烦恼吗？</h1>
<h3 class="am-text-center">来，我帮你管理，我是你的网络管家</h3>
<a href="<%=request.getContextPath()%>/user/register"><button type="button" class="am-btn am-btn-success am-round am-u-sm-3 am-u-end am-u-sm-offset-3"> 注册</button>
</a>
<a href="<%=request.getContextPath()%>/user/login"><button type="button" class="am-btn am-btn-warning am-round am-u-sm-3 am-u-end">登录</button></a>
</div>
</div>
</div>

<%@ include file="/pages/frontend/public/footer.jsp"%>

