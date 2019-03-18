<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <meta charset="utf-8">
 <title>找回密码-肉垫网</title>
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
   <form action="RetrievePasswordServlet" method="post">
    <div class="page-content"> 
     <div class="input-row"> 
     <label class="label fadeIn delay5">请输入注册时的手机号码，用以找回密码</label><br>
     <label class="label fadeIn"></label> 
      <input name="userId" id="username" type="text" data-fyll="用户名" class="input fadeIn delay1" /> 
     </div><br><br>
 	 <div class="input-row"> 
      <button id="submit" class="button load-btn fadeIn delay2"> <span class="default"><i class="ion-arrow-right-b"></i>确定找回密码</span>
     <div class="load-state"> 
      	</div>
      </button> 
     </div> 
    </div>
    </form> 
   </div> 
   <div class="page page-back"> 
    <div class="page-content">
    
    </div> 
   </div> 
  </div> 
</body>
</html>
