<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>Access Denied</title>
  </head>
  
  <body>
  	<div class="container">
		<div class="row" style="padding-top: 30px;">
  			<div class="span12">
				<div class="hero-unit">
					<h3>会话超时，系统自动超时退出！</h3>
					<a class="btn btn-primary btn-large" href="<%=path %>">点击这里重新登录</a>
				</div>
			</div>
		</div>
  	</div>
  
  </body>
  
<script type="text/javascript">

if (self != top){
	window.top.location = window.location;
}

</script>
</html>
