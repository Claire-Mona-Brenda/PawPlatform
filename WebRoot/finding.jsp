<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.po.*" %>
<% ArrayList<Mess> messlist=(ArrayList<Mess>)session.getAttribute("messlist"); %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%!
  int i,nouse=0,favor=0;
  Mess mess;
  Evaluate evaluate;
  String title,writer,time,pic,content,md,contsub;
  Integer scan,collcount=0,commcount=0;  %>
<%if(messlist==null){
request.getRequestDispatcher("InitMess?url=finding.jsp").forward(request, response);
}  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <meta charset="utf-8">
 <title>肉垫网发现有趣</title>
 <meta name="关键字" content="">
 <link href="css/buju.css" rel="stylesheet">
 <link href="css/top.css" rel="stylesheet">
 <link href="css/powerpoint.css" rel="stylesheet">
 <script type="text/javascript" src="js/jquery.min.js"></script>
 <script type="text/javascript" src="js/sliders.js"></script>
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
		     <a  href="index.jsp" target="_blank" >首页</a>
			  <a id="topnav_current" href="ShowMess" target="_blank">发现</a>
			  <a href="InitTopic" target="_blank">话题</a>
			  <a href="login.jsp" target="_blank">写文章</a>
			  <a href="#" target="_blank"></a>
			  <a href="#" target="_blank"></a>
			  <a href="login.jsp" target="_blank">登录</a>
			  <a href="register.jsp" target="_blank">注册</a>
		  </div>
	 </div>
  </header>
  <article>
    <div class="l_box f_l">
	   <div class="topnews2">
	   <h2>
	   <span>
		 <img id="pan" src="images/pan.png"><a href="login.jsp" target="_blank">编写您的爱宠日常</a>
	   </span>	 
	    全部文章
	   </h2>
	   <%
	   if(messlist!=null){ 
	       if(messlist.size()==0){%>
	   	      <p>暂无用户上传文章</p>
	   	      <%}
	   	  int end=messlist.size(); 
	      if(messlist.size()>=20){
		     end=20;
	       }
	       for(i=0;i<end;i++){ 
	   	      mess=messlist.get(i);
	   	      	 title=mess.getTitle();
	   	         writer=mess.getWriter();
	   	         time=mess.getTime();
	   	         content=mess.getContent();
	   	         md=mess.getMd();
	   	         pic=mess.getPic();
	   	         scan=mess.getScan();
	   		     favor=mess.getFavor();
	   		     nouse=mess.getNouse();
	   	         commcount=mess.getCommcount();
	   	         collcount=mess.getCollcount();
	   	        if(content.length()>88){
	   	    	contsub=content.substring(0, 87);
	   	         }
	   	        else{
	   	     	contsub=content;
	   	        }
	   	
	   	      %>
	   	      <div class="blogs">
		      <figure>
			     <img width="175" height="180" src=<%=pic %>>
			   </figure>
			   <ul>
			     <h3><a href="DetailMess?md=<%=md%>"><%=title %></a></h3>
			     <p class="autor2">
				    <span class="admin f_l">
					    <a href="/"><%=writer %></a>
					 </span>
					 <span class="dtime f_l"><%=time %></span>
					 <span class="viewnum f_l">浏览 <a><%=scan %></a></span>
				  </p>
				  <p><%=contsub %>...</p>
			     <p class="autor">
				    <!--
				    <span class="lm f_l">
					    <a href="/">标签1</a>
					     <a href="/">标签2</a>
					 </span>
					 -->
					 <span class="dislike f_r"><a href="EDetailMess?value=nouse&md=<%=md%>&url=<%="finding.jsp"%>">踩（<%=nouse %>）</a></span>
					 <span class="like f_r"><a href="EDetailMess?value=favor&md=<%=md%>&url=<%="finding.jsp"%>">喜欢（<%=favor %>）</a></span>
					 <span class="collect f_r"><a href="Collect?title=<%=title %>&writer=<%=writer %>&md=<%=md %>&url=<%="finding.jsp" %>">收藏（<%=collcount %>）</a></span>
					 <span class="pingl f_r"><a href="DetailMess?md=<%=md%>">评论（<%=commcount %>）</a></span>
				  </p>
			   </ul>
	       </div>
	   <% }}%>
	     

	        <div id="pages">
                <a href="#" aria-label="Previous"> <span  aria-hidden="true">&laquo;</span> </a>
                <a id="pageactive" href="#">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#">4</a>
                <a href="#">5</a>
                <span>...</span>
                <a href="#">29</a>
                <a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a>
            </div>
	   </div>
	 </div>  
    <div class="r_box f_r">
	   <div class="tit01">
         <h3>联系我们</h3>
		  <div class="gzwm">
	        <br>
		    <strong>地址：</strong>广西壮族自治区桂林市七星区
            <br>
            <strong>邮政编号：</strong>541004
            <br>
            <strong title="Phone">电话：</strong> (123) 456-7890
            <br>
            <strong>邮箱：</strong><p href="mailto:#">88888888@example.com</p>
		    <ul>
			   <li><a class="xlwb" href="https://weibo.com/mengchongwu?refer_flag=1001030201_&is_hot=1" target="_blank">新浪微博</a></li>
			   <li><a class="txwb" href="http://t.qq.com/zijincheng" target="_blank">腾讯微博</a></li>
			   <li><a class="qq" href="http://www.boqii.com/" target="_blank">QQ</a></li>
			   <li><a class="wx" href="http://www.boqii.com/" target="_blank">微信</a></li>
			</ul>
		  </div>
       </div> 
	   <div class="ad300x100">
	       <img src="images/wh.jpg">
	   </div>
	   <div class="ad"><img src="images/07.jpg"></div>
	   <div class="links">
	     <h3><span><a href="/">申请友情链接</a></span>友情链接</h3>
		 <ul>
		   <li><a href="http://www.chinapet.com/" target="_blank">宠物中国</a></li>
		    <li><a href="http://www.goumin.com/" target="_blank">狗民网</a></li>
			 <li><a href="http://bj.58.com/pets.sjsp" target="_blank">58同城宠物</a></li>
			  <li><a href="http://www.dog126.com/" target="_blank">淘狗网</a></li>
			   <li><a href="http://www.epet.com/" target="_blank">E宠网</a></li>
			    <li><a href="https://www.pethr.com/" target="_blank">宠才网</a></li>
				 <li><a href="http://www.mypethome.com/" target="_blank">宠物之家</a></li>
		 </ul>
	   </div>
	 </div>
  </article>
</body>
</html>