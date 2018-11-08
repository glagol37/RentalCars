<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value='${language}' />
<fmt:setBundle basename='i18n.Messages' />

<form class="languages">
	<button class="language" value="ru_RU" name="language">Ру</button>
	<button class="language" value="en_EN" name="language">En</button>
</form>
<form class="signin" method='post' action="add-manager">
<input type="hidden" name="language" value="${language}">
	<fmt:message key='add.manager'/>:
	<hr>
	<div class="border reg">
		<label><fmt:message key='login'/>: </label> <input type='text' name='login' required>
	</div>
	<div class="border reg">
		<label><fmt:message key='password'/>: </label> <input type='password' name='password'
			required>
	</div>
	<div class="batton reg">
		<input type="submit" value='<fmt:message key='add'/>'>
	</div>
</form>