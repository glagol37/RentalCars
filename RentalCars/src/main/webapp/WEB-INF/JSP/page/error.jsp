<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value='${language}' />
<fmt:setBundle basename='i18n.Messages' />
<c:choose>
	<c:when test="${statusCode == 400}">
		<div class="error">
			<fmt:message key='invalid.request' />
		</div>
	</c:when>
	<c:when test="${statusCode == 404}">
		<div class="error">
			<fmt:message key='captcha.is.not.correct' />
		</div>
	</c:when>
	<c:when test="${statusCode == 412}">
		<div class="warning">
			<fmt:message key='not.found' />
		</div>
	</c:when>
	<c:otherwise>
		<div class="warning">
			<fmt:message key='process.request' />
		</div>
	</c:otherwise>
</c:choose>