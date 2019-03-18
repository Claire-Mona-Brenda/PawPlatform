<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String userId=(String)session.getAttribute("userId");
 String avatar=(String)session.getAttribute("avatar");
 if(avatar==null||userId==null){
   request.getRequestDispatcher("login.jsp").forward(request, response);
 } 
 String warn=(String)session.getAttribute("settopic-warn");
 session.removeAttribute("settopic-warn");
 %>


<!doctype jsp>
<jsp>
<head>
 <meta charset="utf-8">
 <title>肉垫网话题创建</title>
 <meta name="关键字" content="">
 <link href="css/top.css" rel="stylesheet">
 <link href="css/edit.css" rel="stylesheet">
 <style type="text/css">
#paper_edit{
	color: #56ADA0;
	font-size: 18px;
	font-weight: bold;
	text-align: left;
	font-family: 寰蒋闆呴粦;
	padding-left: 30px;
	padding-top: 20px;
	padding-bottom: 10px;
}
 #warning {
    margin-left:200px;
    font-weight: normal;
    color: #ff7200;
    font-size: 12px;
}
 </style>
</head>
<body>
  <header>
    <div class="logo f_l">
	   <a href="index -login.jsp">
	      <img src="images/logo.png">
	   </a>
	 </div>
	 <div id="topnav" class="f_r">
	     <div id="toptext">
		     <a href="index -login.jsp" target="_blank" >首页</a>
			  <a href="ShowMess" target="_blank">发现</a>
			  <a id="topnav_current" href="InitTopic" target="_blank">话题</a>
			  <a href="publish.jsp" target="_blank">写文章</a>
			  <a href="#" target="_blank"></a>
			  <a href="member_center.jsp" target="_blank">用户中心</a>
			  <a href="LogoffServlet" target="_blank">注销</a>
		  </div>
	 </div>
  </header>
  <article>
  	<div id="paper_edit">
  		肉垫宠物网——创建话题专区
  		 	<%if(warn!=null){%>
  	   <span id="warning"><%=warn %></span>
  	        <%} %>
  	</div>
 
  	<form action="SetTopic" method="post">
  	<div class="messages">
  	    <div class="box2">
  	       <div class="biaoti">
  	    	    <a>话题：</a>
  	       </div>
  		   <div class="text1">
  		        <textarea name="title" placeholder="请输入话题名称..." autocomplete="off" class="input1" style="height: 40px" ></textarea>
  		   </div>
  		</div>
  		<div class="box1">
  		  <br>
  		   <div class="biaoti2">
  	    	   <a>上传图片：</a>
  	       </div>
  		   <div class="">
  		   <input class="my_info_content_care_table_file" name="pic" type="file">
  		   <img id="cardimg" src="images/default_idcard.jpg">
  		   </img>
  		   </div>
  		</div>
  		<div class="box3">
  		   <div class="biaoti2">
  	    	   <a>内容：</a>
  	       </div>
  		   <div class="text1">
  		       <textarea name="content" cols="5" rows="5" placeholder="请输入话题描述..." autocomplete="off" class="input2" style="height: 300px"></textarea>
  		   </div>
  		</div>
  		<div class="box4" style="margin-top: 380px; margin-bottom: 10px">
  			<input class="papersubmit" name="" type="submit" value="取消">
  			<input class="papersubmit2" name="" type="submit" value="提交">
  		</div>
	  </div>
	  </form>
  </article>
</body>
</jsp>
