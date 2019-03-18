<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE jsp>
<jsp>
<head>
 <meta charset="utf-8">
 <title>注册页面-肉垫网</title>
 <meta name="¹Ø¼ü×Ö" content="">

 <link href="css/buju.css" rel="stylesheet">
 <link href="css/top.css" rel="stylesheet">
 <link href="css/powerpoint.css" rel="stylesheet">
 <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" /> 

 <script type="text/javascript" src="js/jquery.min.js"></script>
 <script type="text/javascript" src="js/sliders.js"></script>
<script type="text/javascript" src="js/jquery.js"></script> 
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
  <header>
    <div class="logo f_l">
	   <a href="index.jsp">
	      <img src="images/logo.png">
	   </a>
	 </div>
	 <div id="topnav" class="f_r">
	     <div id="toptext">
		   <a href="index.jsp" target="_blank" >首页</a>
			  <a href="ShowMess" target="_blank">发现</a>
			  <a href="InitTopic" target="_blank">话题</a>
			  <a href="login.jsp" target="_blank">写文章</a>
			  <a href="#" target="_blank"></a>
			  <a href="#" target="_blank"></a>
			  <a href="login.jsp" target="_blank">登录</a>
			  <a id="topnav_current" href="register.jsp" target="_blank">注册</a>  
		  </div>
	 </div>
  </header>
 <div id="window" style="">
 
 
   <div class="page page-front"> 
   <form action="RegisterServlet" method="post">
    <div class="page-content"> 
     <div class="input-row"> 
      <label class="label fadeIn">手机号</label> 
      <input name="userId" id="username" type="text" data-fyll="用户名" class="input fadeIn delay1" /> 
     </div> 
     <div class="input-row"> 
      <label class="label fadeIn">用户名昵称</label> 
      <input name="username" id="username" type="text" data-fyll="用户名" class="input fadeIn delay1" /> 
     </div> 
     <div class="input-row"> 
      <label class="label fadeIn delay2">密码</label> 
      <input name="password" id="password" type="password" data-fyll="密码" class="input fadeIn delay2" /> 
     </div> <br>
     <div class="input-row"> 
      <button id="submit" class="button load-btn fadeIn delay3"> <span class="default"><i class="ion-arrow-right-b"></i>注册</span>
   	 </div>
   	 </form>
 	 <div class="input-row"> 
      <button id="submit" class="button load-btn fadeIn delay4" onClick="location.href='login.jsp';"> <span class="default"><i class="ion-arrow-right-b"></i>已有账户？直接登录</span>
     <div class="load-state"> 
      	</div>
      </button> 
     </div> 
    </div> 
   </div> 
   <div class="page page-back"> 
    <div class="page-content"> 
     <img src="avatar.jpg" class="avatar" /> 
     <p class="welcome">开始探索吧！</p> 
     <div class="perspective"> 
      <button class="button inline trigger-anim-replay" onClick="location.href='index -login.jsp';"><i class=""></i>快速进入主页</button> 
     </div> 
    </div> 
   </div> 
  </div> 
</body>
</jsp>

