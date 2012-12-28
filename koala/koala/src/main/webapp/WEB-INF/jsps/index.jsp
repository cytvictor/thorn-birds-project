<%@page import="org.thorn.user.entity.User"%>
<%@page import="org.thorn.security.SecurityUserUtils"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//判断是否处于登录状态
User user = SecurityUserUtils.getCurrentUser();
if(user != null && StringUtils.isNotBlank(user.getUserId())) {
	response.sendRedirect("/home.jhtml");
}

// 判断是否有cookie
Cookie[] cookies = request.getCookies();
for(Cookie ck : cookies) {
	if(StringUtils.equals(ck.getName(), "SPRING_SECURITY_REMEMBER_ME_COOKIE")) {
		if(StringUtils.isNotBlank(ck.getValue())) {
			response.sendRedirect("/home.jhtml");
		}
	}
}

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Login</title>
	
	<link type="text/css" rel="stylesheet" href="<%=path %>/plugins/rcarousel/css/rcarousel.css" />
	<link type="text/css" rel="stylesheet" href="<%=path %>/plugins/rlightbox/css/lightbox.css" />
	
	<script type="text/javascript" src="<%=path %>/plugins/rcarousel/jquery.ui.rcarousel.min.js"></script>
	<script type="text/javascript" src="<%=path %>/plugins/rlightbox/jquery.ui.rlightbox.min.js"></script>
	
	<style type="text/css">
	#pages {
		width: 150px;
		margin: 0 auto;
		padding-top: 20px;
	}
	</style>
	
	<script type="text/javascript">
	$(function(){
		
		$(".lb_gallery").rlightbox();
		
		$("#carousel").rcarousel({
			visible: 1,
			step: 1,
			speed: 700,
			margin: 10,
			auto: {
				enabled: true
			},
			width: 200,
			height: 200,
			start: generatePages,
			pageLoaded: pageLoaded
		});
		
		function generatePages() {
			var _total, i, _link;
			
			_total = $("#carousel").rcarousel("getTotalPages");
			
			for ( i = 0; i < _total; i++ ) {
				_link = $("<a href='#'></a>");
				
				$(_link).bind("click", {page: i},
						function( event ) {
							$("#carousel").rcarousel("goToPage", event.data.page);
							event.preventDefault();
						}
					).addClass("ui-carousel-bullet-off").appendTo("#pages");
			}
			
			// mark first page as active
			$("a:eq(0)", "#pages").removeClass("ui-carousel-bullet-off")
				.addClass("ui-carousel-bullet-on");
		}
		
		function pageLoaded(event, data) {
			$("a.ui-carousel-bullet-on", "#pages")
				.removeClass("ui-carousel-bullet-on")
				.addClass("ui-carousel-bullet-off");

			$("a", "#pages").eq(data.page)
				.removeClass("ui-carousel-bullet-off")
				.addClass("ui-carousel-bullet-on");
		}
		
		// 记住账户名
		var username = $.cookie.get("LOGIN_USERNAME");
		if(!$.utils.isEmpty(username) && $.utils.isEmpty($("#username").val())) {
			$("#username").val(username);
		}
		
	    $("#login").validationEngine({ 
	    	promptPosition: "bottomLeft",
	    	autoHideDelay : 4000,
	    	autoHidePrompt : true,
	    	failure :  false,
        	success : function() { 
        		$.cookie.add("LOGIN_USERNAME", $("#username").val());
        	} 
        });
	    
	    <c:if test="${param.error eq true}">
	    	$("#ValidateCode").validationEngine("showPrompt" , "${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}", "error");
		</c:if>
		
		$(".ui-carousel-next-r").add(".ui-carousel-prev-l")
			.add(".bullet").hover(
			function() {
				$(this).css( "opacity", 0.7);
			},
			function() {
				$(this).css("opacity", 1.0);
			}
		);
	});
	
	function refresh() {
		$("#authImage").attr("src","<%=path %>/resources/ImageValidateCodeServlet?radom=" + Math.random());
	};
	
	var user = {
		userId 		: "<sec:authentication property="principal.username" />",
		userName 	: "<sec:authentication property="principal.user.userName" />",
		org			: "<sec:authentication property="principal.user.orgCode" />",
		cumail 		: "<sec:authentication property="principal.user.cumail" />",
		phone 		: "<sec:authentication property="principal.user.phone" />",
		role		: new Array()
	};
	
	</script>
  </head>
  
  <body>
  	<div class="container">
		<c:import url="ref/header_1.jsp"></c:import>
		<div class="row">
			<div class="span10 offset1">
				<div class="page-header">
			    	<h2>欢迎来到我们的网站</h2>
			    </div>
			</div>
		</div>
		
		<div class="row">
			<div class="span5 offset1" style="margin-top: 20px;">
				<div style="position: relative;width: 450px;">
					<a href="#" class="ui-carousel-prev-l" id="ui-carousel-prev"></a>
					<div id="carousel" style="width: 340px;margin: 0 auto;">
						<a href="<%=path %>/plugins/rcarousel/images/lightbox/01.jpg" class="lb_gallery"><img src="<%=path %>/plugins/rcarousel/images/lightbox/01_thumb.jpg" /></a>
						<a href="<%=path %>/plugins/rcarousel/images/lightbox/02.jpg" class="lb_gallery"><img src="<%=path %>/plugins/rcarousel/images/lightbox/02_thumb.jpg" /></a>
						<a href="<%=path %>/plugins/rcarousel/images/lightbox/03.jpg" class="lb_gallery"><img src="<%=path %>/plugins/rcarousel/images/lightbox/03_thumb.jpg" /></a>
						<a href="<%=path %>/plugins/rcarousel/images/lightbox/04.jpg" class="lb_gallery"><img src="<%=path %>/plugins/rcarousel/images/lightbox/04_thumb.jpg" /></a>
					</div>
					<a href="#" class="ui-carousel-next-r" id="ui-carousel-next"></a>
					<div id="pages"></div>
				</div>
			</div>
			<div class="span5">
			    <form class="form-horizontal" id="login" method="post" action="<%=path%>/j_spring_security_check">
			    <fieldset>
			    	<div class="control-group">
				    	<label class="control-label" for="input01">账户名</label>
				    	<div class="controls">
				    		<input type="text" class="span2" data-validation-engine="validate[required]"
				    			data-errormessage-value-missing="请输入账户名"
				    			id="username" name="j_username" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}">
				   	 	</div>
				    </div>
				    <div class="control-group">
				    	<label class="control-label" for="input01">密码</label>
				    	<div class="controls">
				    		<input type="password" class="span2" data-validation-engine="validate[required]" 
				    			data-errormessage-value-missing="请输入密码"
				    			name="j_password" id="password">
				    		<span class="help-inline">
				    			<a href="">忘记密码</a>
				    		</span>
				    	</div>
				    </div>
				    <div class="control-group">
				    	<label class="control-label" for="input01">验证码</label>
				    	<div class="controls">
				    		<input type="text" class="span1" data-validation-engine="validate[required,minSize[4],maxSize[4],custom[integer]]" 
				    			data-errormessage-value-missing="请输入四位数字验证码"
				    			name="ValidateCode" id="ValidateCode">
				    		<span class="help-inline">
				    			<img alt="验证码" id="authImage" src="<%=path %>/resources/ImageValidateCodeServlet" align="middle" width="80" height="24">
				    		</span>
				    		<span class="help-inline">
				    			<a href="javascript:refresh();" title="点击刷新">看不清</a>
				    		</span>
				    	</div>
				    </div>
				    <div class="control-group">
				    	<div class="controls">
				    		<label class="checkbox inline">
				    			<input type="checkbox" name="_spring_security_remember_me">
				    			<abbr title="2周内访问我们的网站不需要登录">两周内自动登录</abbr>	
				    		</label>
				    	</div>
				    </div>
				    <div class="form-actions">
				    	<button class="btn btn-primary" type="submit">登录</button>
				    	<span class="help-inline">
				    		&nbsp;&nbsp;&nbsp;&nbsp;
				    		还没有账户？<a href="">立即注册！</a>
				    	</span>
				    </div>
			    </fieldset>
			    </form>
			</div>
		</div>
	</div>
	
	<c:import url="ref/footer_1.jsp"></c:import>	
</body>
</html>
