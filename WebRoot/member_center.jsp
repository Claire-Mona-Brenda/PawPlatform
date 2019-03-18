<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.po.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%!String avatar,userId,username;
User user; %>
<%
username=(String)session.getAttribute("username");
userId=(String)session.getAttribute("userId");
avatar=(String)session.getAttribute("avatar");
 if(avatar==null||userId==null){
   request.getRequestDispatcher("login.jsp").forward(request, response);
 }
 %>
<!DOCTYPE jsp>
<jsp lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="revised" content="Ningxia Seasons, 2015/8/13/" />
<!-- 定义页面的最新版本 -->
<meta name="description" content="网站简介" />
<!-- 网站简介 -->
<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />
<!-- 搜索关键字 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>肉垫宠物网 - 个人中心</title>


<!-- CSS公共部分 开始 -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/top.css" rel="stylesheet">
<!-- CSS公共部分 结束 -->
<link href="css/crowdfunding.css" rel="stylesheet">
</head>
<body>
 <header>
    <div class="logo f_l">
	   <a href="index -login.jsp">
	      <img src="img/member_center/logo.png">
	   </a>
	 </div>
	 <div id="topnav" class="f_r">
	     <div id="toptext">
		     <a  href="index -login.jsp" target="_blank" >首页</a>
			  <a href="ShowMess" target="_blank">发现</a>
			  <a href="InitTopic" target="_blank">话题</a>
			  <a href="publish.jsp" target="_blank">写文章</a>
			  <a href="#" target="_blank"></a>
			  <a id="topnav_current" href="member_center.jsp" target="_blank">用户中心</a>
			  <a href="LogoffServlet" target="_blank">注销</a>
		  </div>
	 </div>
  </header>
<!-- 核心 开始 -->
<article>
<div class="container border1 nopadding margin10">
  <div id="vertical_navigation" class="col-lg-3 background831312 nopadding">
    <div class="dead_pic"><img src="<%=avatar%>"><br>
      <span class="username">用户名：<%=username %></span></div>
    <div class="menu">
      <div class="menu_title"> 账号信息管理 </div>
      <div class="menu_list">
        <ul class="list-unstyled">
          <li id="listClick1" class="menu_list_on" onClick="listClick(1)">基本资料</li>
          <li id="listClick2" class="" onClick="listClick(2)">修改头像</li>
          <li id="listClick4" class="" onClick="listClick(4)">修改密码</li>
        </ul>
      </div>
    </div>
    <div class="menu">
      <div class="menu_title"> 文章管理中心 </div>
      <div class="menu_list">
        <ul class="list-unstyled">
          <li id="listClick16" class="" onClick="listClick(16)">我的收藏</li>
        </ul>
      </div>
    </div>
  </div>
  <div class="col-lg-9">
  	<iframe name="left" id="crowdfunding_iframe" src="crowdfunding.center/my_info.jsp" frameborder="false" scrolling="no" style="border:none;" width="100%" height="1045" allowtransparency="true"></iframe>
  </div>
</div>
</article> 
<!-- 核心 结束 -->  
<!-- JS公共部分 开始 --> 
<script src="js/jquery-2.1.1.min.js"></script> 
<!-- JS公共部分 结束 --> 
<script src="js/crowdfunding.js"></script>
</body>
</jsp>