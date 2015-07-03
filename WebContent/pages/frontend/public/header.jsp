<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>我的网络管家</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="stylesheet" href="<%=request.getContextPath()%>/pages/assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/pages/assets/css/gj.css"/>
	<script>
   window.onload=msg;
  
  function msg(){
    var $modal = $('#msg');
    $modal.modal();
  }
  </script>
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header id="header" class="am-topbar" data-am-sticky>
<div class="am-g am-g-fixed">
  <h1 class="am-topbar-brand">
    <a href="<%=request.getContextPath()%>" style="color:white">我的网络管家</a>
  </h1>
    <div class="am-topbar-right">
    <c:choose>
     <c:when test="${empty unickname}">
     <a href="<%=request.getContextPath()%>/user/login"><button class="am-btn am-btn-success am-topbar-btn am-btn-sm">登录</button></a> 
     <a href="<%=request.getContextPath()%>/user/register"> <button class="am-btn am-btn-success am-topbar-btn am-btn-sm">注册</button></a>
     </c:when>
     <c:otherwise>
	<div class="am-dropdown" data-am-dropdown="{boundary: '.am-topbar'}">
        <button class="am-btn am-btn-success am-topbar-btn am-btn-sm am-dropdown-toggle" data-am-dropdown-toggle>${unickname}<small>【点我】</small></button>
        <ul class="am-dropdown-content">
         <li><a href="<%=request.getContextPath()%>/user/info">我的资料</a></li>
          <li><a href="<%=request.getContextPath()%>/web/myweb">我的收藏</a></li>
          <li><a href="<%=request.getContextPath()%>/account/myaccount">账号收录</a></li>
                    <li><a href="<%=request.getContextPath()%>/user/upwd">密码修改</a></li>
          
          <li><hr></li>
          <li><a href="#" data-am-modal="{target: '#wangzhi', closeViaDimmer: 0, width: 400, height: 225}">收藏网址</a></li>
          <li><a href="#" data-am-modal="{target: '#zhanghao', closeViaDimmer: 0, width: 400, height: 225}">存储账号</a></li>
          <li><hr></li>
           <li><a href="<%=request.getContextPath()%>/user/logout">安全退出</a></li>
          
        </ul>
      </div>
	
     </c:otherwise>
     </c:choose>
          <a href="<%=request.getContextPath()%>/shareweb/allshareweb"> <button class="am-btn am-btn-success am-topbar-btn am-btn-sm">发现网站</button></a>
     
     <!-- 按钮触发器， 需要指定 target -->
<button class="am-btn am-btn-success am-topbar-btn am-btn-sm" data-am-offcanvas="{target: '#zonglan', effect: 'push'}">网站总览</button>
    </div>
    
     <div class="am-topbar-right">
      
    </div>
  </div>
  <div id="cb"></div>
</header> 

 <c:if test="${!empty requestScope.msg}">
    <div class="am-modal am-modal-alert" tabindex="-1" id="msg">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">我的网络管家</div>
    <div class="am-modal-bd">
      ${requestScope.msg}
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn">确定</span>
    </div>
  </div>
</div>
</c:if>



<!-- 侧边栏内容 -->
<div id="zonglan" class="am-offcanvas" >
  <div class="am-offcanvas-bar am-offcanvas-bar-flip">
    <div class="am-offcanvas-content am-u-sm-centered">
    <h3>网站总览</h3>
    <hr>
    <a href=""><button type="button" class="am-btn am-btn-default am-round am-btn-block">首页</button></a>
	<a href=""><button type="button" class="am-btn am-btn-secondary am-round am-btn-block">网址共享页</button></a>
	<a href=""><button type="button" class="am-btn am-btn-primary am-round am-btn-block">注册</button></a>
	<a href=""><button type="button" class="am-btn am-btn-success am-round am-btn-block">登录</button></a>
	<a href=""><button type="button" class="am-btn am-btn-warning am-round am-btn-block">我的信息</button></a>
	<a href=""><button type="button" class="am-btn am-btn-danger am-round am-btn-block">密码修改</button></a>
	<a href=""><button type="button" class="am-btn am-btn-danger am-round am-btn-block">我的收藏</button></a>
	<a href=""><button type="button" class="am-btn am-btn-warning am-round am-btn-block">我的分享</button></a>
	<a href=""><button type="button" class="am-btn am-btn-success am-round am-btn-block">我的密码箱</button></a>
	<a href=""><button type="button" class="am-btn am-btn-primary am-round am-btn-block">后台登录</button></a>
	<a href=""><button type="button" class="am-btn am-btn-secondary am-round am-btn-block">后台主页</button></a>
	<a href=""><button type="button" class="am-btn am-btn-default am-round am-btn-block">后台用户管理</button></a>
    <a href=""><button type="button" class="am-btn am-btn-danger am-round am-btn-block">404</button></a>
    
    </div>
    
  </div>
</div>

<!--快速进行网址收录和账号收录  -->
<div class="am-modal am-modal-no-btn" tabindex="-1" id="wangzhi">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">收藏网址
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
    </div>
   <div class="am-g">
  <div class="am-u-md-8 am-u-sm-centered">
    <form class="am-form" action="<%=request.getContextPath() %>/web/addweb" method="post">
      <fieldset class="am-form-set">
        <input type="text" placeholder="网站名" name="wname" required >
        <input type="text" placeholder="网址" name="wurl" required>
      </fieldset>
    <div class="am-btn-group">
  <button type="submit" class="am-btn am-btn-primary am-round" >提交</button>
  <button type="button" class="am-btn am-btn-primary am-round" data-am-modal-close>取消</button>
</div>
    </form>
   </div>
   </div>
  </div>
</div>

<div class="am-modal am-modal-no-btn" tabindex="-1" id="zhanghao">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">收录账号
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
    </div>
<div class="am-g">
  <div class="am-u-md-8 am-u-sm-centered">
    <form class="am-form" action="/account/addaccount" method="post">
      <fieldset class="am-form-set">
        <input type="text" placeholder="账号平台" required name="actitle">
        <input type="text" placeholder="用户名" required name="acname">
        <input type="password" placeholder="密码" required name="acpwd">
      </fieldset>
    <div class="am-btn-group">
  <button type="submit" class="am-btn am-btn-primary am-round">存储</button>
  <button type="button" class="am-btn am-btn-primary am-round" data-am-modal-close>取消</button>
</div>
    </form>
  </div>
</div>
   
    </div>
  </div>


   