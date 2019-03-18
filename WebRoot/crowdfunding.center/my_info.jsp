<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.po.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%!
String username,sex,sig,intro,avatar;
User user;
 %>
 <%
 user=(User)session.getAttribute("userinfo");
 if(user!=null){
 	username=user.getUserName();
 	sex=user.getSex();
 	sig=user.getSignature();
 	intro=user.getIntro();
 }


  %>
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
<title>肉垫网我的资料</title>

<!-- Bootstrap -->
<link href="../css/crowdfunding.center/my_info.css" rel="stylesheet">

</head>
<body>
<!-- 开始 -->
<div class="my_info_title">我的资料</div>
<div class="my_info_title_3">
  <ul>
    <li id="listClick_1" onClick="listClick(1)" style="width: 100%; color: #DB6D4C;">基本资料</li>
  </ul>
</div>
<div class="my_info_content">
  <table class="my_info_content_care_table">
    <tbody>
      <tr>
        <td width="90" align="right" class="color555">用户名：</td>
          <td class="color555">
          <span class="color555 margin_left10"><%=username %></span></td>
      </tr>
      <tr>
        <td align="right" class="color555">性别：</td>
        <td class="color555"><span class="color555 margin_left10"><%=sex %></span></td>
      </tr>
      <tr>
        <td align="right" class="color555">个性签名：</td>
        <td class="color555"><span class="color555 margin_left10"><%=sig %></span></td>
      </tr>
      <tr>
        <td valign="top" align="right" class="color555">个人简介：</td>
        <td class="color555"><span class="color555 margin_left10"><%=intro %></span></td>
      </tr>
      <tr>
        <td align="center" colspan="2">
           <div>
              <a class="my_info_content_care_table_submit" style="text-decoration:none;" href="my_info2.jsp">修改资料</a>
           </div>
        </td>
      </tr>
    </tbody>
  </table>
</div>
<!-- 结束 --> 
<script src="../js/jquery-2.1.1.min.js"></script>  
<script src="../js/my_info.js"></script>
</body>
</jsp>