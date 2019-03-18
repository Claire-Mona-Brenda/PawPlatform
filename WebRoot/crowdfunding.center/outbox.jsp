<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.po.Collection" %>
<% ArrayList<Collection> collectlist=(ArrayList<Collection>)session.getAttribute("collectlist"); 
if(collectlist==null){
request.getRequestDispatcher("../InitCollection?url=crowdfunding.center/outbox.jsp").forward(request, response);
}%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%!int i;
Collection collection;
String md,title,writer,time; %>
<!DOCTYPE jsp>
<jsp lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="revised" content="Ningxia Seasons, 2015/8/13/" />
<!-- 定义页面的最新版本 -->
<meta name="description" content="网站简介" />
<!-- 网站简介 -->
<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />
<!-- 搜索关键字 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>肉垫网文章收藏</title>

<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/crowdfunding.center/outbox.css" rel="stylesheet">

</head>
<body>
<!-- 开始 -->
<div class="my_info_title">我的收藏</div>

      <% if(collectlist!=null){
      if(collectlist.size()==0){%>
       <p style="font-size:14px ">大人，您还没有收藏任何一篇文章(⊙o⊙)哦！快去看看你喜欢的内容，然后收藏起来吧╭(╯^╰)╮</p>
      <%}
      else{
      %>
      <div class="">
         <table class="table table-bordered">
           <tbody>
             <tr class="active">
               <th width="100" class="text-center">序号</th>
               <th class="text-center">标题</th>
               <th class="text-center">作者</th>
               <th class="text-center">收藏时间</th>
               <th class="text-center">操作</th>
            </tr>
      	<% for(i=0;i<collectlist.size();i++){
      		collection=collectlist.get(i);
      	    title=collection.getTitle();
      		md=collection.getMd();
      		writer=collection.getWriter();
      		time=collection.getTime();
      		%>
      <tr class="">
        <td class="text-center"><%=md.substring(0,3) %></td>
        <td class="text-left" ><a class="class" href="../DetailCollection?md=<%=md %>" target="collectarticle.jsp"><%=title %></a></td>
        <td class="text-center"><%=writer %></td>
        <td class="text-center"><%=time.substring(0, 16) %></td>
        <td class="text-center"><a class="xiugai" href="../DeleteCollection?title=<%=title %>&md=<%=md%>">删除</a></td>
      </tr>
      	<%}
        }
      }
      else{%>
      <p style="font-size:14px ">大人，您还没有收藏任何一篇文章(⊙o⊙)哦！快去看看你喜欢的内容，然后收藏起来吧╭(╯^╰)╮</p>
      <% }%>
      </tbody>
  </table>
</div>   
      
        


<!-- 结束 --> 
</body>
</jsp>