<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>访问的页面不存在</title>
</head>
<body>
	<div class="center_info">
		<div class="title1">
			<e>页面不存在</e>
			&nbsp;>&nbsp;提示信息
		</div>
		<div class="operate_kuang">
			<h1 id="mesageId">访问的页面不存在，请检查访问地址是否正确！</h1>
		</div>
	</div>
</body>
</html>
