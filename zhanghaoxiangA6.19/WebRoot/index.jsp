<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	
</script>
</head>

<body>




	<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		
		<div>
			<a class="navbar-brand" href="#"><font size="26px" color="#40D2B1" >八维学院</font></a>
			<!--向右对齐-->
			<ul class="nav navbar-nav navbar-right">
			<div class="collapse navbar-collapse" id="example-navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">首页</a></li>
				<li><a href="#">最新课程</a></li>
				<li><a href="#"> 移动app </a></li>
				<li><a href="#"> 联系我们 </a></li>
			
		
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> 八维学院<b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">首页</a></li>
						<li><a href="#">最新课程</a></li>
						<li><a href="#">移动app </a></li>
						<li class="divider"></li>
						<li><a href="#"> 联系我们 </a></li>

					</ul></li>
			</ul>
			
			
		</div>
	</div>
	</nav>


</body>
</html>
