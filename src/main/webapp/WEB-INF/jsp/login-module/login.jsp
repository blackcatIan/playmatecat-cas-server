<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
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
// 	$("#pw_ph").bind("click",login_module.pw_ph_click);

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
// 		pw_ph_click: function() {
// 			$("input[name='userDTO.password']").focus();
// 		}
}

</script>

</head>
<body>
	<div ng-app class="container-fluid">
	   <div class="row" style="height:200px;">
	   </div>


		<div class="row text-center">
			<div class="col-md-1">
				<%--space--%>
			</div>
			<div class="col-md-3">
                            <%--space--%>
            </div>
			<div class="col-md-3">
				<div class="row">

					<form:form modelAttribute="casLoginVO" action="/login-params" method="post">
						<form:hidden path="service" />
						<form:hidden path="url" />
						<div class="col-md-1 col-lg-2">
							<%--space--%>
						</div>
						<div class="col-md-10 col-lg-8" style="border:1px solid gray;border-radius:3px;">
						    <div class="row pd5" style="background:url(/static/images/logo.png) top center no-repeat;height:100px;"></div>
							<div class="row pd5">
								<label class="icon-group" for="userDTO.password" accesskey="u"></label>
							    <span ng-show="username == '' || username == null" id="un_ph" class="placeholder_txt">用户名</span>
                                <form:input ng-model="username" path="userDTO.username" type="text" class="w175"/>
							</div>
							<div class="row pd5">
								<label class="icon-key" for="userDTO.password" accesskey="p"></label>
								<input name="userDTO.password" type="password" class="w175" value="" placeholder="密码"/>
							</div>

							<div class="row pd5">
								<input type="submit" value="登 录" class="btn btn-primary btn-sm pd5_0 w198" />
							</div>
							<div class="row">
							    <div class="col-md-6">
                                    <input type="checkbox" value="true" name="rememberMe" checked="checked"/>记住我
                                </div>
                                <div class="col-md-6">
                                    <a href="javascript:void(0);">忘记密码?</a>
                                </div> 
							</div>
							<div class="row">
							    <div class="col-md-6">
                                    <a href="javascript:void(0);">立即注册</a>
                                </div>
                                <div class="col-md-6">
                                    <a href="javascript:void(0);">用户协议</a>
                                </div> 
							</div>
						</div>
						<div class="col-md-1 col-lg-2">
							<%--space--%>
						</div>
					</form:form>

				</div>
				<%--<div class="row text-left"> --%>
			</div>
			<div class="col-md-4">
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