<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value='${language}' />
<fmt:setBundle basename='i18n.Messages' />

<form class="languages">
	<button class="language" value="ru_RU" name="language">Ру</button>
	<button class="language" value="en_EN" name="language">En</button>
</form>
<form class="signin" method='post' action="create-order">
<input type="hidden" name="language" value="${language}">
	<fmt:message key='you.choosed'/>: <c:out value="${param.mark}"/> <c:out value="${param.title}"/>
	<hr>
	<div class="order">
		<label><fmt:message key='your.passport.details'/>: </label> <input type='text'
			name='passport_details' required>
	</div>
	<div class="order">
		<input type="radio" id="driver" name="is_driver" value="true">
		<label for="driver"><fmt:message key='with.driver'/></label>
	</div>
	<div class="order">
		<input type="radio" id="not_driver" name="is_driver" value="false"
			checked> <label for="not_driver"><fmt:message key='without.driver'/></label>
	</div>
	<div class="order">
		<label><fmt:message key='lease.term'/>: </label><input type='number' name='days'
			required>
	</div>
	<div class="order">
		<input type="hidden" name="id" value="<c:out value="${param.id}"/>">
		<button type="submit"><fmt:message key='place.order'/></button>
	</div>
</form>