<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%String warn=(String)session.getAttribute("alteruserinfo-warn");
 session.removeAttribute("alteruserinfo-warn");
 if(warn==null){
 warn="";}
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
<title>肉垫网修改个人资料</title>

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
  <div class="my_info_content_care"> <%=warn %> </div>
  
  <form action="../AlterUserInfo" method="post">
  <table class="my_info_content_care_table">
    <tbody>
      <tr>
        <td width="90" align="right" class="color555">用户名：</td>
          <td class="color555"><input name="username" class="my_info_content_care_table_text" type="text">
          <span class="color959595 margin_left10 font_size12">取一个与众不同的昵称吧！</span></td>
        <!--
        <td class="color555">不科学<span class="colorCA1E37 margin_left10 font_size12">不能修改</span></td>
        -->
      </tr>
      <!--
       <tr>
        <td align="right" class="color555">手机号码：</td>
        <td class="color555">18609515574<span class="color959595 margin_left10 font_size12">友好提示：网站前台不会显示您手机号，用于运营人员替您办理投融资手续</span></td>
      </tr>
      
      <tr>
        <td align="right" class="color555">真实姓名：</td>
        <td class="color555"><input class="my_info_content_care_table_text" name="" type="text">
          <span class="color959595 margin_left10 font_size12">友好提示：网站前台不会显示您手机号，用于运营人员替您办理投融资手续</span></td>
      </tr>
       -->
      <tr>
        <td align="right" class="color555">性别：</td>
        <td class="color555"><label>
            <input type="radio" name="sex" id="" value="不告诉你" checked>
            不告诉你 </label>
          <label>
            <input type="radio" name="sex" id="" value="男">
            男 </label>
          <label class="radio-inline">
            <input type="radio" name="sex" id="" value="女">
            女 </label></td>
      </tr>
      <tr>
        <td align="right" class="color555">个性签名：</td>
        <td class="color555"><input name="sig" class="my_info_content_care_table_text" type="text"></td>
      </tr>
      <tr>
        <td align="right" class="color555">个人简介：</td>
        <td><textarea name="intro" class="form-control" style="resize:vertical" rows="3"></textarea></td>
      </tr>
      <tr>
        <td align="center" class="color555" colspan="2"><input class="my_info_content_care_table_submit" name="" type="submit" value="保    存"></td>
      </tr>
    </tbody>
  </table>
   </form>
</div>

<!-- 结束 --> 
<script src="../js/jquery-2.1.1.min.js"></script>  
<script src="../js/my_info.js"></script>
</body>
</jsp>