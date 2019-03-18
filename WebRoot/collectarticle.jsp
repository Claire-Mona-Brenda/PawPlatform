<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.po.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%!
Mess mess;
 Evaluate evaluate;
 String title,writer,time,pic,content,md,contwarn;
 String lines[];
 int i; 
 String userId,avatar,url,username;
 String ctime,cavatar,cusername,text;
 Comment comm=new Comment();

 %>

<%
username=(String)session.getAttribute("username");
userId=(String)session.getAttribute("userId");
avatar=(String)session.getAttribute("avatar");
if(avatar==null||userId==null){
   request.getRequestDispatcher("login.jsp").forward(request, response);
   return;
 }


 mess=(Mess)session.getAttribute("detailCollect");
 evaluate=(Evaluate)session.getAttribute("evaluate");
 if(mess!=null){
 	title=mess.getTitle();
 	writer=mess.getWriter();
 	time=mess.getTime();
 	pic=mess.getPic();
 	content=mess.getContent();
 	md=mess.getMd();
 	lines=content.split("\r?\n");
 }
 else{
 	md="";
 	title="";
 	time="";
 	pic="";
 	content="";
 	writer="";
 }
 
ArrayList<Comment> commentlist=(ArrayList<Comment>)session.getAttribute("commentlist"+md);
if(mess==null&&userId!=null){
 request.getRequestDispatcher("crowdfunding.center/outbox.jsp").forward(request, response);
 return;
 }
 if(commentlist==null){
request.getRequestDispatcher("InitComment?url=collectarticle.jsp").forward(request, response);
return;
}


 if(application.getAttribute("scan"+md)==null){
	application.setAttribute("scan"+md, new Integer(0));
 }
 Integer scan=(Integer)application.getAttribute("scan"+md);
 application.setAttribute("scan"+md,new Integer(scan.intValue()+1));
 scan=(Integer)application.getAttribute("scan"+md);
 session.setAttribute("url", "collectarticle.jsp");
 session.setAttribute("id", md);
 %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <meta charset="utf-8">
 <title>文章详情</title>
 <meta name="关键字" content="">
 <link href="css/top.css" rel="stylesheet">
  <link href="css/article.css" rel="stylesheet">
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
            for(i=0;i<lines.length;i++){%>
            	<p class="font2"><%=lines[i] %><br></p>
            <%}}
             %>
        </div>
        </div>
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
                    <p>帐号：<a target="_blank" href="###"><%=username %></a>
                   <%contwarn=(String)session.getAttribute("contwarn");
                    
                    if(contwarn!=null){%>
                    <span class="submitwarning" style="display: inline-block;margin-left: 20px;">内容不能为空</span>
                    <%session.removeAttribute("contwarn");} %>
                    
                    <form action="AddComment" method="post">
                    <div id="cmhbody">
                        <div id="touxiang"><a title="李良莹" target="_blank" href="###">
                            <img width="50" height="50" src="<%=avatar%>">
                        </a>
                        </div>
                        <div id="postcm">
                            <input class="btn btn-gray1 submitbtn" id="postmbtn" name="" type="submit" value="我要评论">
                            <div class="textbg">
                                <textarea name="content" autocomplete="off" class="inputnone"></textarea>
                            </div>
                            <div class="clear"></div>

                        </div>
                    </div>
                    </form>
                    
                    <% if(commentlist!=null){%>
						<p id="cm-s2">全部评论：<span><%=commentlist.size() %></span>条</p>
                    
                        
						     <%for(i=0;i<commentlist.size();i++){
						        comm=commentlist.get(i);
						        if(md.equals(comm.getId())){
						        text=comm.getContent();
						        ctime=comm.getTime();
						        cusername=comm.getUsername();
						        cavatar=comm.getA();
						       
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
                            <p class="cm-s6">
                               <%=text %>
                            </p>
                        </div>
                        </div>
						     <%
						       }
						     }
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