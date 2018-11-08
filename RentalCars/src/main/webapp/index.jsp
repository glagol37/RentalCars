<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>JSTL fmt:message Tag</title>
<fmt:setLocale value='ru' />
<fmt:setBundle basename='i18n.Messages' />
</head>

<body>
<fmt:message key='helloworld'/>
</body>
</html>