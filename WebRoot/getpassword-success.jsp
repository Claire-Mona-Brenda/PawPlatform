<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <meta charset="utf-8">
 <title>成功找回密码-肉垫网</title>
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
    <div class="page-content"> 
     <div class="input-row"> 
     <%String password=(String)session.getAttribute("password"); %>
     <label class="label fadeIn delay5">找回密码成功：<%=password %></label><br><br>
     </div>
 	 <div class="input-row"> 
      <button id="submit" class="button load-btn fadeIn delay2" onClick="location.href='login.jsp'"> <span class="default"><i class="ion-arrow-right-b"></i>立即登录</span>
     <div class="load-state"> 
      	</div>
      </button> 
     </div> 
    </div> 
   </div> 
   <div class="page page-back"> 
    <div class="page-content">
    
    </div> 
   </div> 
  </div> 
</body>
</html>