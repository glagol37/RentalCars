<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value='${language}' />
<fmt:setBundle basename='i18n.Messages' />

<form class="languages">
	<button class="language" value="ru_RU" name="language">Ру</button>
	<button class="language" value="en_EN" name="language">En</button>
</form>
<fmt:message key='your.score.is'/>: ${price}.
<form action="order" method="post">
<input type="hidden" name="language" value="${language}">
	<input type="hidden" name="price" value="${price}">
	<input type="hidden" name="id" value="<c:out value="${param.id}"/>">
	<input type="hidden" name="passport_details" value="<c:out value="${param.passport_details}"/>">
	<input type="hidden" name="is_driver" value="<c:out value="${param.is_driver}"/>">
	<input type="hidden" name="days" value="<c:out value="${param.days}"/>">
	<input type="submit" value="<fmt:message key='confirm'/>">
</form>
<form action="products">
	<input type="hidden" name="language" value="${language}">
	<input type="submit" value="<fmt:message key='to.cancel'/>">
</form>
