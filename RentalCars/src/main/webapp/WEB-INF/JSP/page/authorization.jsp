<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename='i18n.Messages' />
<form class="languages">
	<button class="language" value="ru_RU" name="language">Ру</button>
	<button class="language" value="en_EN" name="language">En</button>
</form>
<form class="signin" method='post' action="authorization">
<input type="hidden" name="language" value="${language}">
	<div class="border reg">
		<label><fmt:message key='login' />: </label> <input type='text'
			name='login' required>
	</div>
	<div class="border reg">
		<label><fmt:message key='password' />: </label> <input
			type='password' name='password' required>
	</div>
	<div class="border reg">
		<input type="hidden" name="number_one" value="${number_one}">
		<input type="hidden" name="number_two" value="${number_two}">
		<label><fmt:message key='enter.sum.numbers' /> ${number_one}
			<fmt:message key='and' /> ${number_two}: </label> <input type='number'
			name='result' required>
	</div>
	<a href="products?language=${language}"><fmt:message key='enter.as.guest' /></a>
	<a href="sign-in?language=${language}"><fmt:message key='to.register' /></a>
	<div class="batton reg">
		<input type="submit" value='<fmt:message key='sign.in'/>'>
	</div>
</form>