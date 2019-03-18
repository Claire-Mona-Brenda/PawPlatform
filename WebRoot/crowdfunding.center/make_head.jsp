<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<title>肉垫网修改头像</title>

<!-- Bootstrap -->
<link href="../css/crowdfunding.center/make_head.css" rel="stylesheet">
<style type="text/css">
.make_head_content{
	height:50px;
	}
.my_info_content_care{
	margin-top: 15px;
	margin-bottom: 15px;
	margin-left: 5px;
	margin-right: 5px;
	}
.my_info_title_3{
	border-top:1px solid #CCC;
	border-bottom:1px solid #CCC;
	width:100%;
	height:50px;
	}
.my_info_title_3 a{
	text-decoration:none;
	color:#666;
	}
.my_info_title_3 ul{
	margin:0px;
	padding:0px;
	list-style-type:none;
	}
.my_info_title_3 ul li{
	width:185px;
	height:50px;
	line-height:50px;
	text-align:center;
	display:block;
	float:left;
	font-size: 18px;
	color: #666;
	border-right:1px solid #CCC;
	cursor:pointer;
	}
.my_info_content_care_table{
	width:100%;
	font-size:14px;
	}
.my_info_content_care_table tr td{
	height:34px;
	line-height:34px;
	vertical-align:middle;
	}
.color555{
	color:#555;
	}
.my_info_content_care_table_submit{
	width: 150px;
	font-size: 16px;
	display: inline-block;
	padding: 6px 12px;
	margin-bottom: 0px;
	font-weight: 400;
	line-height: 1.42857;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	cursor: pointer;
	-moz-user-select: none;
	background-image: none;
	border: 1px solid #DB6D4C;
	border-radius: 4px;
	color: #FFF;
	background-color: #DB6D4C;
	}
</style>
</head>
<body>
<div class="make_head_title">我的资料</div>
<div class="make_head_content">
   <div class="my_info_title_3">
     <ul>
       <li style="width: 100%; color: #DB6D4C;">修改头像</li>
     </ul>
   </div>
   <div class="my_info_content_care"></div>
   <form action="../AlterAvatar" method="post">
   <table class="my_info_content_care_table">
    <tbody>
      <tr>
        <td width="300" align="right" class="color555">上传头像：</td>
          <td class="color555"><input name="avatar" type="file"></td>
      </tr>
      <tr>
        <td align="center" class="color555" colspan="2"><input class="my_info_content_care_table_submit" name="" type="submit" value="上    传"></td>
      </tr>
	</tbody>
	</table>
	</form>
</div>
<script src="../js/jquery-2.1.1.min.js"></script>
</body>
</jsp>