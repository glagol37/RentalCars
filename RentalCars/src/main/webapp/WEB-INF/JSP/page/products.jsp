<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value='${language}' />
<fmt:setBundle basename='i18n.Messages' />

<form class="languages">
	<button class="language" value="ru_RU" name="language">Ру</button>
	<button class="language" value="en_EN" name="language">En</button>
</form>
<table class="table_price">
	<caption><fmt:message key='cars'/></caption>
	<tr>
		<th><fmt:message key='mark'/></th>
		<th><fmt:message key='car.name'/></th>
		<th><fmt:message key='quality.class'/></th>
		<th colspan="2"><fmt:message key='price.per.day'/></th>
	</tr>
	<c:forEach var="num" items="${products}">
		<tr>
			<td>${num.getMark()}</td>
			<td>${num.getTitle()}</td>
			<td>${num.getQuality()}</td>
			<td>${num.getPrice()}</td>
			<c:if test="${isSession}">
				<td>
					<div class="select">
						<c:choose>
							<c:when test="${CURRENT_ACCOUNT.getType() == type.get(2)}">
								<form action="delete-car" method='post'>
									<input type="hidden" name="language" value="${language}">
									<input type="hidden" name="id" value="${num.getId()}">
									<input type="submit" value='<fmt:message key='remove'/>'>
								</form>
								<form action="change-car">
									<input type="hidden" name="language" value="${language}">
									<input type="hidden" name="id" value="${num.getId()}">
									<input type="submit" value='<fmt:message key='update'/>'>
								</form>
							</c:when>
							<c:when test="${CURRENT_ACCOUNT.getType() == type.get(1)}">
								<c:choose>
									<c:when test="${num.isBusy()}"><fmt:message key='free'/></c:when>
									<c:otherwise>
										<fmt:message key='busy'/>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<form action="create-order" method='get'>
									<input type="hidden" name="language" value="${language}">
									<input type="hidden" name="mark" value="${num.getMark()}">
									<input type="hidden" name="title" value="${num.getTitle()}">
									<input type="hidden" name="id" value="${num.getId()}">
									<input type="submit" value='<fmt:message key='choose'/>'>
								</form>
							</c:otherwise>
						</c:choose>
					</div>
				</td>
			</c:if>
		</tr>
	</c:forEach>
</table>