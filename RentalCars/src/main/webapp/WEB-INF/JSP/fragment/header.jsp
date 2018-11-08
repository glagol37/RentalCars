<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value='${language}' />
<fmt:setBundle basename='i18n.Messages' />

<c:choose>
	<c:when test="${CURRENT_ACCOUNT != null}">
		<c:choose>
			<c:when test="${CURRENT_ACCOUNT.getType() == type.get(2)}">
				<form action="change-status-account">
					<input type="hidden" name="language" value="${language}">
					<input type="hidden" name="is_block" value="true"> <label>
						<fmt:message key='block.user'/>: </label> <input type='text' name='login'>
					<input type="submit" value="<fmt:message key='confirm'/>">
				</form>
				<form action="change-status-account">
					<input type="hidden" name="language" value="${language}">
					<input type="hidden" name="is_block" value="false"> <label>
						<fmt:message key='unlock.user'/>: </label> <input type='text' name='login'>
					<input type="submit" value="<fmt:message key='confirm'/>">
				</form>
				<form action="add-car">
					<input type="hidden" name="language" value="${language}">
					<input type="submit" value="<fmt:message key='add.car'/>">
				</form>
				<form action="add-manager">
					<input type="hidden" name="language" value="${language}">
					<input type="submit" value="<fmt:message key='add.manager'/>">
				</form>
			</c:when>
			<c:when test="${CURRENT_ACCOUNT.getType() == type.get(1)}">
				<form action="all-orders">
					<input type="hidden" name="language" value="${language}">
					<input type="submit" value="<fmt:message key='all.orders'/>">
				</form>
			</c:when>
			<c:otherwise>
				<a href="my-score?language=${language}"><fmt:message key='my.bills.and.orders'/></a>
			</c:otherwise>
		</c:choose>
		<a href="sign-out?language=${language}"><fmt:message key='sign.out'/></a>
	</c:when>
</c:choose>
