<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.po.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%!
Mess mess;
 Evaluate evaluate;
 String title,writer,time,pic,content,md,userId,avatar;
 String lines[],commlines[];
 Topic topic=new Topic();
User user;
int count=0;
String text,ctime,cusername,cavatar;
Comment comm=new Comment();
ArrayList<Comment> commentlist;
%>

<%
userId=(String)session.getAttribute("userId");
avatar=(String)session.getAttribute("avatar");
md=(String)session.getAttribute("id");
commentlist=(ArrayList<Comment>)session.getAttribute("commentlist"+md);
session.setAttribute("url", "article -nologin.jsp");
 mess=(Mess)session.getAttribute("detailMess"+md);
 evaluate=(Evaluate)session.getAttribute("evaluate"+md);
 if(mess!=null){
 	title=mess.getTitle();
 	writer=mess.getWriter();
 	time=mess.getTime();
 	pic=mess.getPic();
 	content=mess.getContent();
 	md=mess.getMd();
 	lines=content.split("\r?\n");
 }
 if(mess==null&&userId!=null){
 request.getRequestDispatcher("finding -login.jsp").forward(request, response);
 return;
 }
 session.setAttribute("id", md);

if(commentlist==null){
request.getRequestDispatcher("InitComment?url=article -nologin.jsp").forward(request, response);
return;
}
 

 if(application.getAttribute("scan"+md)==null){
	application.setAttribute("scan"+md, new Integer(0));
 }
 Integer scan=(Integer)application.getAttribute("scan"+md);
 
 %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <meta charset="gb2312">
 <title>文章详情</title>
 <meta name="关键字" content="">
 <link href="css/top.css" rel="stylesheet">
  <link href="css/article.css" rel="stylesheet">
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
		     <a id="topnav_current" href="index.jsp" target="_blank" >首页</a>
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
  <article>
    <div class="blog-detail">
        <div id="puinfo">
            <div id="puinfobody">
                <h3><%=title %></h3>
                <br>
                <p id="font1">作者：<a id="author" href="#" target="_blank"><%=writer %></a>
                    &nbsp;&nbsp;发布日期：<a><%=time %></a>
                    &nbsp;&nbsp;浏览数：<a><%=scan %></a>
                </p>
            </div>
       </div>
        <div class="content">
            <div>
                <p style="text-align: left; margin-top: 0px; margin-bottom: 0px;  font-size: 14px; white-space: normal;"><img width="300" height="448" style="margin-right: auto; margin-left: auto; height: auto;" src=<%=pic %>><br><br></p>
            <%
            if(lines!=null){
            for(int i=0;i<lines.length;i++){%>
            	<p class="font2"><%=lines[i] %><br></p>
            <%}}
             %>
        </div>
        <div>
                            <!--
            <div class="blog-footer">
                 <div id="ptags">
                        <span>标签&nbsp;&nbsp;</span>
                        <a target="_blank" href="###">填色</a>&nbsp;
                        <a target="_blank" href="###">插画</a>&nbsp;
                        <a target="_blank" href="###">秘密花园</a>&nbsp;
                 </div>
                <div class="ilike">
                    <a class="text-center" href="###">&nbsp;喜欢(<span class="likecount">3</span>)</a>
                </div>
            </div>
                             -->
        </div>
    </div>
    <div class="detail-Comments">
            <div class="msg-area">
                <div id="cmhead">
                   <br>
                    <div class="notice">
                      <p>只有登录之后才可以评论，请点击<a style="font-size:15px" target="_top" href="login.jsp">这里</a>进行登录</p>
                    </div>
                    <% if(commentlist!=null){
                    count=commentlist.size();
                    session.setAttribute("commcount"+md, count);%>
						<p id="cm-s2">全部评论：<span><%=count %></span>条</p>
                    
						     <%for(int i=0;i<commentlist.size();i++){
						        comm=commentlist.get(i);
						        text=comm.getContent();
						        commlines=text.split("\r?\n");
						        ctime=comm.getTime();
						        cavatar=comm.getA();
						        cusername=comm.getUsername();
						       %>
						       <div class="cmitem">
						       <div id="touxiang">
                           <a target="_blank" class="m-logo" title="廖晓音" href="###">
                            <img width="50" height="50" src="<%=cavatar%>">
                        </a>
						</div>
						        <div class="cmitembody">
                            <p class="cm-s4">
                                <a target="_blank" href="###"><%=cusername %></a>
                                <span><%=ctime %></span>
                            </p>
                            <%if(commlines!=null){
                                 for(int j=0;j<commlines.length;j++){%>
                                 <p class="cm-s6"><%=commlines[j] %></p>
                                 <%}
                              }%>
                        </div>
                        </div>
						  <%}
						  }
						  else{%>
						<P>暂无评论内容，快来挤占沙发吧！小可爱们</P>
						<%}%>
                    
                </div>
        </div>
    </div>
  </div>
  </article>
</body>
</html>