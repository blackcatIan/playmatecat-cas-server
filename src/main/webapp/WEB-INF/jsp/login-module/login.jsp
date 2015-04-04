<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--禁止缩放 --%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>欢迎登录</title>

<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="/static/css/lib/font-awesome-3.2.1/css/font-awesome.min.css" type="text/css" />

<link rel="stylesheet" href="/static/css/commons/commons.css" type="text/css" />
<link rel="stylesheet" href="/static/css/login-module/login.css" type="text/css" />



<style type="text/css">
/* div{
border:1px solid red;
} */
</style>

<!--[if lte IE 9]>
<script type="text/javascript" src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
<script type="text/javascript" src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
<![endif]-->


<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="http://apps.bdimg.com/libs/angular.js/1.3.13/angular.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	//模拟placehold
	$("#un_ph").bind("click",login_module.un_ph_click);
	//模拟placehold
	$("#pw_ph").bind("click",login_module.pw_ph_click);
});

var login_module = {
		/**
		* 处理用户名被focus时的模拟placeholder
		*/
		un_ph_click : function() {
			$("input[name='userDTO.username']").focus();
		},
		/**
		*处理密码被focus时的模拟placeholder
		*/
		pw_ph_click: function() {
			$("input[name='userDTO.password']").focus();
		}
}

</script>

</head>
<body>
	<div ng-app class="container-fluid">
	   <div class="row">
	   </div>


		<div class="row text-center">
			<div class="col-md-1">
				<%--space--%>
			</div>
			<div class="col-md-3">
				<div class="row" style="border:1px solid gray;border-radius:3px;">

					<form:form modelAttribute="casLoginVO" action="/login-params" class=".form-inline" method="post">
						<form:hidden path="service" />
						<form:hidden path="url" />
						<div class="col-md-3">
							<%--space--%>
						</div>
						<div class="col-md-6">
							<div class="row pd5">
								<label class="icon-group" for="userDTO.password" accesskey="u"></label>
							    <span ng-show="username == '' || username == null" id="un_ph" class="placeholder_txt">用 户 名</span>
                                <form:input ng-model="username" path="userDTO.username" type="text" class="w175"/>
							</div>
							<div class="row pd5">
								<label class="icon-key" for="userDTO.password" accesskey="p"></label>
								<span ng-show="password == '' || password == null" id="pw_ph" class="placeholder_txt">登 录 密 码</span>
								<form:input ng-model="password" path="userDTO.password" type="password" class="w175" />
							</div>

							<div class="row pd5">
								<input type="submit" value="登 录" class="btn btn-primary btn-sm pd5_0 w198" />
							</div>
							<div class="row">
							    <div class="col-md-4">
                                    <input type="checkbox" value="true" name="rememberMe"/>
                                </div>
								<div class="col-md-4">
									<a href="javascript:void(0);">免费注册</a>
								</div>
								<div class="col-md-4">
									<a href="javascript:void(0);">忘记密码?</a>
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<%--space--%>
						</div>
					</form:form>

				</div>
				<%--<div class="row text-left"> --%>
			</div>
			<div class="col-md-7">
				<%--space--%>
			</div>
			<div class="col-md-1">
				<%--space--%>
			</div>
		</div>
	</div>
	<%--<div class="container-fluid"> --%>


</body>
</html>