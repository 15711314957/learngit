<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="javax.servlet.http.HttpServletResponse"     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="js/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-2.1.4.js" ></script>
<script type="text/javascript" src="js/bootstrap.min.js" ></script>
<title>Insert title here</title>
<%
HttpServletRequest request2;
 %>
<script type="text/javascript">
function exportUser(){
			window.open('export.action');
		}
function exportUser2(){
			window.open('export2.action');
		}
function importUser(){
	$("#dlg").show();
	
}
</script>
</head>
<body>
 
 <button class="btn btn-primary btn-lg" onclick="exportUser()">导出用户</button>
 <button class="btn btn-primary btn-lg" onclick="exportUser2()">模板导出用户</button>
  <button  onclick="importUser()">导入用户</button>
 <!-- <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
 导入用户</button><br> -->
<table border="1" style="margin-left: 50px;margin-top: 50px;">
<tr>
<th>编号</th>
<th>姓名</th>
<th>性别</th>
</tr>

<c:forEach items="${teachers}" var="e">
<tr>
<td>${e.id}</td>
<td>${e.name}</td>
<td>${e.sex}</td>
</tr>
</c:forEach>
</table>

<!-- <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="uploadUser.action" method="post" enctype="multipart/form-data">
        		<div class="modal-body">
        			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
					上传文件
					</h4>
				</div>
        			<input type="file" name="user" class="modal-body">
        			
        		<div class="modal-footer">
        			<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
        			<input type="submit" value="上传" class="btn btn-primary" data-dismiss="modal"/>
				</div>
        	</form>
		</div>
	</div>
</div> -->

	<div id="dlg" style="display: none;">
        <form action="uploadUser.action" method="post" enctype="multipart/form-data">
        	上传文件：
        	<input type="file" name="user">
        	<input type="submit" value="上传"/>
        </form>
     </div>
</body>
</html>