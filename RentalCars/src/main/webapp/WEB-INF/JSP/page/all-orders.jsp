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
				${num.getAccountLogin()}
			</td>
			<td>
				${num.getPrice()}
			</td>
			<td>
				<form action="my-score" method="post">
				<input type="hidden" name="language" value="${language}">
					<input type="hidden" name="id" value="${num.getId()}">
					<input type="hidden" name="id_order" value="${num.getOrderId()}">
					<input type="submit" value="<fmt:message key='paid'/>"/>
				</form>
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
			<td colspan="3" class="q">${num.getMark()}${num.getTitle()}</td>
			<th><fmt:message key='login'/></th>
			<th class="q"><fmt:message key='passport.details'/></th>
			<c:choose>
				<c:when test="${num.isPaid()}">
					<td>
						<div class="tabs">
							<div class="content">
								<form action="return-car" method="post">
								<input type="hidden" name="language" value="${language}">
									<input type="hidden" name="login" value="${num.getAccountLogin()}">
									<input type="hidden" name="id_car" value="${num.getCarsId()}">
									<input type="hidden" name="id" value="${num.getId()}">
									<fmt:message key='damage.bill'/> <input type="radio" id="driver"
										name="score" value="true"> <label for="score"><fmt:message key='yes'/></label>
									<input type="radio" id="score" name="score" value="false"
										checked> <label for="score"><fmt:message key='not'/></label>
									<hr>
									<label><fmt:message key='score'/>: </label><input type='number' name='price'>
									<input type="submit" value="Отправить">
								</form>
							</div>
							<div>
								<button><fmt:message key='return'/></button>
							</div>
						</div>
					</td>
				</c:when>
				<c:when test="${num.isCancel()}">
					<td><fmt:message key='canceled'/></td>
				</c:when>
				<c:otherwise>
					<th>
						<form action="all-orders" method="post">
						<input type="hidden" name="language" value="${language}">
							<input type="hidden" name="id_car" value="${num.getCarsId()}">
							<input type="hidden" name="id" value="${num.getId()}"> <input
								type="hidden" name="action" value="paid"> <input
								type="submit" value="<fmt:message key='confirm'/>" />
						</form>
					</th>
				</c:otherwise>
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
				<c:when test="${num.isPaid()}">
				</c:when>
				<c:when test="${num.isCancel()}">
					<td>${num.getDescription()}</td>
				</c:when>
				<c:otherwise>
					<th>
						<div class="tabs">
							<div class="content">
								<form action="all-orders" method="post">
								<input type="hidden" name="language" value="${language}">
									<input type="hidden" name="id" value="${num.getId()}">
									<input type="hidden" name="action" value="cancel"> <input
										type="text" name="description"> <input type="submit"
										value="<fmt:message key='to.send'/>" />
								</form>
							</div>
							<div>
								<button><fmt:message key='to.cancel'/></button>
							</div>
						</div>
					</th>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
</c:forEach>