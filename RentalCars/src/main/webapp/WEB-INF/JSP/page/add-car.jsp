<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value='${language}' />
<fmt:setBundle basename='i18n.Messages' />

<form class="languages">
	<button class="language" value="ru_RU" name="language">Ру</button>
	<button class="language" value="en_EN" name="language">En</button>
</form>
<div class="tabs">
	<div class="content">
		<form action="add-mark" method="post">
		<input type="hidden" name="language" value="${language}">
			<input name="mark" type="text" />
			<input type="submit" value="<fmt:message key='add'/>" />
		</form>
	</div>
	<div>
		<button><fmt:message key='add.brand'/></button>
	</div>
</div>
<form class="signin" method='post' action="add-manager">
<input type="hidden" name="language" value="${language}">
	<div class="order">
		<select name='mark'>
			<c:forEach var="num" items="${marks}">
				<option>${num.getName()}</option>
			</c:forEach>
		</select>
	</div>
	<div class="order">
		<label><fmt:message key='car.name'/>: </label><input type="text" name='title'
			required>
	</div>
	<div class="order">
		<label><fmt:message key='price'/>: </label><input type="number" name='price' required>
	</div>
	<div class="order">
		<label><fmt:message key='quality.class'/>: </label><input type="number" name='quality'
			required>
	</div>
	<div class="order">
		<button type="submit"><fmt:message key='update'/></button>
	</div>
</form>