<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value='${language}' />
<fmt:setBundle basename='i18n.Messages' />

<form class="languages">
	<button class="language" value="ru_RU" name="language">Ру</button>
	<button class="language" value="en_EN" name="language">En</button>
</form>
<c:forEach var="num" items="${score }">
	<table class="orders">
		<tr>
			<td>
				<fmt:message key='order.number'/>: ${num.getOrderId()}
			</td>
			<td>
				${num.getPrice()}
			</td>
			<td>
				<fmt:message key='car.damage.invoice'/>
			</td>
		</tr>
	</table>
</c:forEach>
<hr>
<c:forEach var="num" items="${orders }">
	<table class="orders">
		<caption><fmt:message key='order.number'/>: ${num.getId()}</caption>
		<tr class="s">
			<th colspan="3" class="q"><fmt:message key='information.about.order'/></th>
			<th colspan="2" class="q"><fmt:message key='customer.information'/></th>
			<th><fmt:message key='order.status'/></th>
		</tr>
		<tr class="s">
			<td colspan="3" class="q">${num.getMark()}${" "}${num.getTitle()}</td>
			<th><fmt:message key='login'/></th>
			<th class="q"><fmt:message key='passport.details'/></th>
			<c:choose>
				<c:when test="${num.isPaid()}">
					<td><fmt:message key='paid'/></td>
				</c:when>
				<c:when test="${num.isCancel()}">
					<td><fmt:message key='canceled'/></td>
				</c:when>
			</c:choose>
		</tr>
		<tr class="s">
			<td>${num.getPrice()}</td>
			<td>${num.getDays()}</td>
			<td class="q"><c:choose>
					<c:when test="${num.isDriver()}">
						<fmt:message key='with.driver'/>
					</c:when>
					<c:otherwise>
						<fmt:message key='without.driver'/>
					</c:otherwise>
				</c:choose></td>
			<td>${num.getAccountLogin()}</td>
			<td class="q">${num.getPassportDetails()}</td>
			<c:choose>
				<c:when test="${num.isCancel()}">
					<td>${num.getDescription()}</td>
				</c:when>
			</c:choose>
		</tr>
	</table>
</c:forEach>