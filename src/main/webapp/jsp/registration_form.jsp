<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title><spring:message code='registration_form.title'/></title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link type="text/css"  href="account.css" rel="stylesheet">
</head>

<body>
	<div class="container">

		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item"><spring:message code='menu.menu'/></h3>
			<a href="/registers" class="w3-bar-item w3-button"><spring:message code='menu.register'/></a>
			
			<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
				<a href="/entrants_list" class="w3-bar-item w3-button"><spring:message code='menu.entrants_list'/></a>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_ENTRANT')">
				<a href="/create-entrant" class="w3-bar-item w3-button"><spring:message code='menu.registration_form'/></a>
			</security:authorize>
		</div>


		<!-- Page Content -->
		<div style="margin-left: 10%">
			<div class="w3-container w3-teal">
				<h1><spring:message code='registration_form.head'/></h1>
			</div>
			<div class="w3-container">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
					<h2>
						<spring:message code='main.welcome'/> ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()"><spring:message code='main.logout'/></a>
					</h2>
				</c:if>


				<form:form method="POST" action="${contextPath}/addEntrant" enctype="multipart/form-data">
					<table>
						<tr>
							<td><spring:message code='registration_form.first_name'/></td>
							<td><input type="text" name="firstName" class="fadeIn second"/></td>
						</tr>
						<tr>
							<td><spring:message code='registration_form.last_name'/></td>
							<td><input type="text" name="lastName" class="fadeIn second" /></td>
						</tr>
						<tr>
							<td><spring:message code='registration_form.age'/></td>
							<td><input type="number" min="0" name="age" class="fadeIn second"/></td>
						</tr>
						<tr>
							<td><spring:message code='registration_form.contacts'/></td>
							<td><input name="contacts" class="fadeIn second"/></td>
						</tr>
						<tr>
							<td><spring:message code='registration_form.faculty'/></td>
							<td>
								<select name="faculty" >
									<c:forEach var="faculty" items="${allFaculties}">
										<option value="${faculty}" >${faculty}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						
						<tr>
							<td><spring:message code='registration_form.subject_and_points'/></td>
							<td>								
								<c:forEach var="subject" items="${allSubjects}" >
									<input type="checkbox" name="subjectAndPoints" value="${subject}" /> ${subject} 
									<input name="subjectAndPoints" type="number" min="0" />
									<br>
								</c:forEach>
							</td>
						</tr>
						
						<tr>
							<td><spring:message code='registration_form.image'/></td>
							<td><input type="file" name="image" /></td>
						</tr>
						
						<tr>
							<td><input type="submit" value="<spring:message code='registration_form.register'/>" /></td>
						</tr>
					</table>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form:form>

			</div>
		</div>

	</div>
	
</body>
</html>