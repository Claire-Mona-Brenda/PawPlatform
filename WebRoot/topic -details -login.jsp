<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.po.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%!

Topic topic=new Topic();
Comment comm=new Comment();
String pic,title,content,td,userId,avatar,contwarn,writer,time,username;
String text,ctime,cavatar,cusername;
User user;
int count=0;
Integer scan=0;
String lines[],commlines[];
 %>
<%
userId=(String)session.getAttribute("userId");
username=(String)session.getAttribute("username");
avatar=(String)session.getAttribute("avatar");
td=(String)session.getAttribute("id");
if(application.getAttribute("scan"+td)==null){
	application.setAttribute("scan"+td, new Integer(0));
 }
scan=(Integer)application.getAttribute("scan"+td);
topic=(Topic)session.getAttribute("detailTopic"+td);
if(topic!=null){
		pic=topic.getPic();
		title=topic.getTitle();
		content=topic.getContent();
		time=topic.getTime();
		writer=topic.getUsername();
		lines=content.split("\r?\n");
        td=topic.getTd();
}
else{
		pic="暂无图片";
		content="暂无话题内容";
		title="暂无标题内容";
		td="";
		writer="暂无作者名";
		time="暂无发表时间";
}
if(topic==null&&userId!=null){
request.getRequestDispatcher("topic - login.jsp").forward(request, response);
return;
}
session.setAttribute("id",td);
ArrayList<Comment> commentlist=(ArrayList<Comment>)session.getAttribute("commentlist"+td);
if(commentlist==null){
request.getRequestDispatcher("InitComment?url=topic -details -login.jsp").forward(request, response);
return;
}

if(avatar==null||userId==null){
request.getRequestDispatcher("topic.jsp").forward(request, response);
return;
}
session.setAttribute("url", "topic -details -login.jsp");
 %>
<!doctype jsp>
<jsp>
<head>
 <meta charset="utf-8">
 <title>肉垫宠物网话题专区</title>
 <meta name="关键字" content="">
 <link href="css/top.css" rel="stylesheet">
 <link href="css/detail.css" rel="stylesheet">
 <style type="text/css">
 #cmhead a{
	font-size: 12px;
	color: #db6d4c;
}
 #cmhead a:hover{
	color: #C05232;
}
 .detail-Comments {
	background: #ffffff;
	margin-bottom: 20px;
	padding-bottom: 20px;
}
.detail-Comments .notice {
	margin-top: 0px;
	text-align: center;
	font-size: 15px;
}
.detail-Comments .notice p {
    height: 30px;
    line-height: 30px;
    margin-bottom: 10px;
}
.detail-Comments .comments-num {
    font-size: 14px;
    height: 55px;
    line-height: 55px;
}
#cmhbody{
	margin-top: 10px;	
}
.submitwarning {
    background: #ff7200;
    color: #ffffff;
    display: none;
    font-size: 12px;
    height: 20px;
    line-height: 20px;
    margin-left: 70px;
    padding: 0 4px;
    text-align: center;
}
#postcm, .cmitembody {
	height: auto;
	margin-left: 70px;
	width: auto;
	margin-top: 0px;
}
#postcm .btn-gray1 {
    background-color: #db6d4c;
    border: none;
    color: #ffffff;
}
#touxiang{
	width: 50px;
	height: 50px;
	float: left;
}
.submitbtn {
    float: right;
    font-size: 16px;
    transition: background-color 0.3s ease 0s;
    padding: 31px 28px;
}
#postmbtn:hover {
    background:#E35930
}
.btn{
	padding: 6px 12px;
	display: inline-block;
	font-weight: 400;
	font-size: 14px;
	line-height: 1.4286;
	text-align: center;
	white-space: nowrap;
	border: 1px solid transparent;
	border-radius: 4px;
	vertical-align: middle;
}
.textbg {
    border: 1px solid #dae2e5;
    height: 85px;
    margin-right: 90px;
    padding: 5px;
    width: auto;
}
.inputnone{
	width: 100%;
	border: none;
	height: 100%;
}
#cm-s2 {
    font-size: 14px;
    height: 55px;
    line-height: 55px;
}
.cmitem {
    border-top: 1px solid #dae2e5;
    height: auto;
    padding: 20px 0;
}
.cmitembody p.cm-s6 {
    line-height: 26px;
    margin: 10px 0;
}
.cmitembody p a.cm-s5 {
    color: #ff7800;
    margin: 0 5px;
    visibility: hidden;
}
#cmhead{

}
/*未登录评论*/
.notice a{
	color: #db6d4c;
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
		     <a  href="index -login.jsp" target="_blank" >首页</a>
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
  	<div class="inbox">
	  <div class="inbox2">
	  	<h3 class="huati">话题：<%=title %></h3>
	  	<br>
                <p style="color: #989898">作者：<a style="color: #db6d4c" href="#" target="_blank"><%=writer %></a>
                    &nbsp;&nbsp;发布日期：<a><%=time %></a>
                    &nbsp;&nbsp;浏览数：<a><%=scan %></a>
                </p>
         <br>
	  	<img src="<%=pic %>">
	     <br>
	     <%
            if(lines!=null){
            for(int i=0;i<lines.length;i++){%>
            	<p class="details"><%=lines[i] %><br></p>
            <%}
            }%>
	     </div>
	     </div>
	     <div class="inbox">
	     <div class="detail-Comments">
            <div class="msg-area">
                <div id="cmhead">
                   <br>
                    <p>帐号：<a target="_blank" href="###"><%=username %></a>
                    <%contwarn=(String)session.getAttribute("contwarn");
                    
                    if(contwarn!=null){%>
                    <span class="submitwarning" style="display: inline-block;margin-left: 20px;">内容不能为空</span>
                    <%session.removeAttribute("contwarn");} %>
                        
                    </p>
                    
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
						<% if(commentlist!=null){
						count=commentlist.size();
						%>
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
                                <span style="margin-left: 10px"><%=ctime %></span>
                            </p>
                            <%if(commlines!=null){
                                for(int j=0;j<commlines.length;j++){%>
                                <p class="cm-s6"><%=commlines[j] %></p>
                                <%}
                            }%>
                            
                        </div>
                        </div>
						     <%}
						}else{%>
						<P>暂无评论内容，快来挤占沙发吧！小可爱们</P>
						<%}%>
                        
                     </div>
                </div>
                </div>
        </div>
	  	<br>
	  
	
  </article>
</body>
</jsp>
