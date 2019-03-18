<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.po.*" %>
<% ArrayList<Mess> messlist=(ArrayList<Mess>)session.getAttribute("messlist");
   ArrayList<Mess> recomm_messlist=(ArrayList<Mess>)session.getAttribute("recomm_messlist");
   ArrayList<Mess> scan_messlist=(ArrayList<Mess>)session.getAttribute("scan_messlist");
    %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%!int i,favor=0,nouse=0;
  Mess mess,rmess,smess;
  Evaluate evaluate;
  String title,writer,time,pic,content,md,userId,avatar,contsub,rtitle,rmd,stitle,smd;
  Integer scan,collcount=0,commcount=0; %>
<%
if(messlist==null){
request.getRequestDispatcher("InitMess?url=index -login.jsp").forward(request, response);
return;
}
userId=(String)session.getAttribute("userId");
 avatar=(String)session.getAttribute("avatar");
 if(avatar==null||userId==null){
   request.getRequestDispatcher("index.jsp").forward(request, response);
   return;
 }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp>
<head>
 <meta charset="utf-8">
 <title>肉垫网</title>
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
	   <a href="index -login.jsp">
	      <img src="images/logo.png">
	   </a>
	 </div>
	 <div id="topnav" class="f_r">
	     <div id="toptext">
		     <a id="topnav_current" href="index -login.jsp" target="_blank" >首页</a>
			  <a href="ShowMess" target="_blank">发现</a>
			  <a href="InitTopic" target="_blank">话题</a>
			  <a href="publish.jsp" target="_blank">写文章</a>
			  <a href="#" target="_blank"></a>
			  <a href="member_center.jsp" target="_blank">用户中心</a>
			  <a href="LogoffServlet" target="_blank">注销</a>
		  </div>
	 </div>
  </header>
  <article>
    <div class="l_box f_l">
	  <div class="banner">
	    <div id="slide-holder">
		   <div id="slide-runner">

			  <a href="/" target="_blank">
			     <img id="slide-img-4" src="images/a2.jpg" alt style>
			  </a>
			  <div id="slide-controls" style="display:block;">
			    <p id="slide-client" class="text">
				    <strong></strong>
					 <span></span>
				 </p>
              <p id="slide-desc" class="text"></p> 	
              <p id="slide-nav"></p>		     			  
			  </div>
		   </div> 
		 </div>
	  </div>
	  <script>
	     if(!window.slider){
		     var slider={};
		 }
		 slider.data=[
		 {
		     "id":"slide-img-1", //与slide-runner中的img标签id对应
			 "client":"狗",
			 "desc":"狗狗为什么老是舔嘴？"     //这里描述图片内容
		 },
		 {
		     "id":"slide-img-2", 
			 "client":"猫",
			 "desc":"猫凭什么征服了人类"
		 },
		 {
		     "id":"slide-img-3", 
			 "client":"狗",
			 "desc":"拆家神犬之四大拆家神犬"
		 },
		 {
		     "id":"slide-img-4", 
			 "client":"猫之成长",
			 "desc":"幼猫养成记"
		 }
		 ];
	   </script>
	   <div class="topnews">
	   <h2>
	   <span>
		 <img id="pan" src="images/pan.png"><a href="publish.jsp" target="_blank">编写您的爱宠日常</a>
	   </span>	 
	    文章推荐
	   </h2>
	   <%
	   if(messlist!=null){
	   int end=messlist.size(); 
	   if(messlist.size()>=20){
		  end=20;
	   }
	   for(i=0;i<end;i++){
	   		mess=messlist.get(i);
	   		title=mess.getTitle();
	   		writer=mess.getWriter();
	   		time=mess.getTime();
	   		md=mess.getMd();
	   		pic=mess.getPic();
	   		content=mess.getContent();
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
				  <p><%=contsub %>..."</p>
			     <p class="autor">
				    <!--
				    <span class="lm f_l">
					    <a href="/">标签1</a>
					     <a href="/">标签2</a>
					 </span>
					 -->
					 <span class="dislike f_r"><a href="EDetailMess?value=nouse&md=<%=md%>&url=<%="index -login.jsp"%>">踩（<%=nouse%>）</a></span>
					 <span class="like f_r"><a href="EDetailMess?value=favor&md=<%=md%>&url=<%="index -login.jsp"%>">喜欢（<%=favor%>）</a></span>
					 <span class="collect f_r"><a href="Collect?title=<%=title %>&writer=<%=writer %>&md=<%=md %>&url=<%="index -login.jsp" %>">收藏（<%=collcount %>）</a></span>
					 <span class="pingl f_r"><a href="DetailMess?md=<%=md%>">评论（<%=commcount %>）</a></span>
				  </p>
			   </ul>
	       </div>
	   <% }
	   } %>
	     
		  
		  
	     
		  
		  
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
	   <div class="tab" id="lp_right_select">
	     <script>
		     window.onload=function()
			 {
			     var oLi=document.getElementById("tb").getElementsByTagName("li");
				 var oUl=document.getElementById("tb-main").getElementsByTagName("div");
				 for(var i=0;i<oLi.length;i++)
				 {
				     oLi[i].index=i;
					 oLi[i].onmouseover=function()
					 {
					    for(var n=0;n<oLi.length;n++)
						    oLi[n].className="";
							this.className="cur";
						for(var n=0;n<oUl.length;n++)
                            oUl[n].style.display="none";
                            oUl[this.index].style.display="block";							
					 }
				 }
			 }
		  </script>
	     <div class="tab-top">
		      <ul class="hd" id="tb">
			       <li class="cur"><a href="/">点击排行</a></li>
				   <li><a href="/">最新文章</a></li>
				   <li><a href="/">站长推荐</a></li>
			  </ul>
		  </div>
		  <div class="tab-main" id="tb-main">
		      <div class="bd bd-news" style="display:block;"><ul>
			      <%if(scan_messlist!=null){
		            int end=0; 
		          	if(scan_messlist.size()>=7){
		          	end=scan_messlist.size()-7;
		          	}
		          	for(int s=scan_messlist.size()-1;s>end;s--){
		          	smess=scan_messlist.get(s);
		          	stitle=smess.getTitle();
		          	smd=smess.getMd();%>
		          	<li><a href="DetailMess?md=<%=smd%>"><%=stitle %></a><a href="/" target="_blank"></a></li>
		          	<%}
		          }
		           %>
			  </ul></div>
			   <div class="bd bd-news" ><ul>
			      <%if(messlist!=null){
			        int end=messlist.size(); 
		          	if(messlist.size()>=6){
		          	end=6;
		          	}
		          	for(i=0;i<end;i++){
		          	mess=messlist.get(i);
		          	title=mess.getTitle();
		          	md=mess.getMd();%>
		          	<li><a href="DetailMess?md=<%=md%>"><%=title %></a><a href="/" target="_blank"></a></li>
		          	<%}
		          }
		           %>
			  </ul></div>
			   <div class="bd bd-news" ><ul>
			      <%if(recomm_messlist!=null){
			        int end=0; 
		          	if(recomm_messlist.size()>=7){
		          	end=scan_messlist.size()-7;
		          	}
		          	for(int r=recomm_messlist.size()-1;r>end;r--){
		          	rmess=recomm_messlist.get(r);
		          	rtitle=rmess.getTitle();
		          	rmd=rmess.getMd();%>
		          	<li><a href="DetailMess?md=<%=rmd%>"><%=rtitle %></a><a href="/" target="_blank"></a></li>
		          	<%}
		          }
		           %>
			  </ul></div>
		  </div>
	   </div>
	   <!--
     <div class="cloud">
	     <h3>标签云</h3>
		  <ul>
		    <li><a href="/">萌宠宝宝</a></li>
			 <li><a href="/">喵星日常</a></li>
			 <li><a href="/">治愈系</a></li>
			 <li><a href="/">汪星人</a></li>
			 <li><a href="/">身边的小可爱</a></li>
			 <li><a href="/">宠物摄影</a></li>
			 <li><a href="/">喂一波狗粮</a></li>
			 <li><a href="/">吾汪万睡</a></li>
			 <li><a href="/">圆滚仓鼠</a></li>
			 <li><a href="/">吸猫日常</a></li>
			 <li><a href="/">猫狗大作战</a></li>
			 <li><a href="/">土狗</a></li>
			 <li><a href="/">二傻哈士奇</a></li>
		  </ul>
	   </div>
	   -->
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
</jsp>