<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.po.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
ArrayList<Topic>topiclist=(ArrayList<Topic>)session.getAttribute("topiclist");
if(topiclist==null){
request.getRequestDispatcher("InitTopic").forward(request, response);
}
%>
<%!int i;
Topic topic; 
String username,title,content,time,pic,td,contsub;
Integer commcount=0;%>
<!DOCTYPE HTML>
<html>
<head>
 <meta charset="utf-8">
 <title>肉垫网话题专区</title>
 <meta name="关键字" content="">
 <link href="css/buju.css" rel="stylesheet">
 <link href="css/top.css" rel="stylesheet">
  <link href="css/topic.css" rel="stylesheet">
</head>
<body>
  <header>
    <div class="logo f_l">
	   <a href="index.html">
	      <img src="images/logo.png">
	   </a>
	 </div>
	 <div id="topnav" class="f_r">
	     <div id="toptext">
		     <a  href="index.jsp" target="_blank" >首页</a>
			  <a href="ShowMess" target="_blank">发现</a>
			  <a id="topnav_current" href="InitTopic" target="_blank">话题</a>
			  <a href="login.jsp" target="_blank">写文章</a>
			  <a href="#" target="_blank"></a>
			  <a href="#" target="_blank"></a>
			  <a href="login.jsp" target="_blank">登录</a>
			  <a href="register.jsp" target="_blank">注册</a>
		  </div>
	 </div>
  </header>
  <article>
    <div class="l_box2 f_l">
	   <div class="topnews2">
	   <h2>
	   <span>
		 <img id="pan" src="images/pan.png"><a href="login.jsp" target="_blank">创建您的爱宠话题</a>
	   </span>	 
	    话题专区
	   </h2>
    <div class="row">
        <div class="blog-list">
        <% if(topiclist!=null){
        int end;
        if(topiclist.size()<30){
        end=topiclist.size();
        }
        else{
        end=30;
        }
             for(i=0;i<end;i++){
             	topic=topiclist.get(i);
             	title=topic.getTitle();
             	pic=topic.getPic();
             	content=topic.getContent();
             	td=topic.getTd();
             	time=topic.getTime();
             	username=topic.getUsername();
             	commcount=topic.getCommcount();
             	if(content.length()>40){
             	contsub=content.substring(0,35);
             	}
             	else{
             	 contsub=content;
             	}
	   		    
             	%>
             <div class="col-md-3">
                <div class="blog-list-item">
                    <div class="item-Img">
                        <a target="_blank" href="DetailsTopic?td=<%=td%>">
                            <img style="display: block; width:248.75px; height:158.05px;" alt="关于猫狗的那些事"  src="<%=pic%>"></a>
                    </div>
                    <div class="item-des">
                        <a href="DetailsTopic?td=<%=td%>" target="_blank" class="item-title"><%=title%></a>
                        <div class="summary"><%=contsub %>...</div>
                        <span class="join">参与人数 <a><%=commcount%></a></span>
                    </div>
                </div>
            </div>
             <%}%>
             </div>
      </div>
             <%if(topiclist.size()>=30){
             %>
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
            <div class="clearfix"></div>
        <%}
        }
        else{%>
        <p>暂时无话题内容，快来填坑吧！</p>
        <%}%>
 
	        
	   </div>
	 </div>
  </article>
</body>
</html>