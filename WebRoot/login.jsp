<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp>
<head>
 <meta charset="utf-8">
 <title>登录页面-肉垫网</title>
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
			  <a id="topnav_current" href="login.jsp" target="_blank">登录</a>
			  <a href="register.jsp" target="_blank">注册</a>  
		  </div>
	 </div>
  </header>
  
		 </ul>
	   </div>
	 </div>
  </article>
 <div id="window" style=""> 
   <div class="page page-front"> 
   <form action="LoignServlet" method="post">
    <div class="page-content"> 
     <div class="input-row"> 
      <label class="label fadeIn">手机号</label> 
      <input name="userId" id="username" type="text" data-fyll="用户名" class="input fadeIn delay1" /> 
     </div> 
     <div class="input-row"> 
      <label class="label fadeIn delay2">密码</label> 
      <input name="password" id="password" type="password" data-fyll="密码" class="input fadeIn delay2" /> 
     </div> <br>
     <div class="input-row"> 
      <button id="submit" class="button load-btn fadeIn delay3"> <span class="default"><i class="ion-arrow-right-b"></i>登录</span>
   	 </div>
   	 </form>
 	 <div class="input-row"> 
       <input type="button" value="找回密码" id="submit"  class="button load-btn fadeIn delay4" onclick="window.location='getpassword.jsp'" > <i class="ion-arrow-right-b"></i>
     <div class="load-state"> 
      	</div>
     </div> 
    </div> 
   </div> 
   
</body>
</jsp>
