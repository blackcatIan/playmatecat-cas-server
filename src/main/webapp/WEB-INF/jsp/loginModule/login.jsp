<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
//     document.ready(function(){
//     	var service = getQueryString("service");
//     	if(service != null) {
//     		$("input[name='service']").val(service)
//     	}
//     });
    
    
//     /**
//     * 获取url参数
//     */
// 	function getQueryString(name) {
// 		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
// 		var r = window.location.search.substr(1).match(reg);
// 		if (r != null)
// 			return unescape(r[2]);
// 		return null;
// 	}
</script>

</head>
<body>
    <form:form modelAttribute="loginVO" action="/login-params" method="post" >
        <form:input path="userDTO.username" type="text"/>
        <form:input path="userDTO.password" type="text"/>
        <form:hidden path="service"/>
        <form:hidden path="url"/>
        <input type="submit" value="submit"/>
    </form:form>
    
</body>
</html>