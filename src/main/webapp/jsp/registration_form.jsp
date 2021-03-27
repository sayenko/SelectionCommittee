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
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
<link type="text/css"  href="account.css" rel="stylesheet">
</head>

<body>
	<div class="container-fluid" >

		<!-- Sidebar -->
		
		<div class="w3-sidebar" style="width: 11%">

			<div class="list-group" style="margin-top: 40px">

				<div class="list-group-item active">
					<div>
						<h3><spring:message code='login.title'/></h3>
					</div>
					<div>${pageContext.request.userPrincipal.name}</div>
				</div>

				<a href="/registers" class="list-group-item">
				<i class="fa fa-comment-o"></i>
				<spring:message code='menu.entrants_list'/>
				</a>

				<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
					<a href="/entrants_list" class="list-group-item">
					<i class="fa fa-search"></i><spring:message code='menu.entrants_list'/>
					</a>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_ENTRANT')">
					<a href="/create-entrant" class="list-group-item">
					<i class="fa fa-search"></i> <spring:message code='menu.registration_form'/>
					</a>
				</security:authorize>


				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>

					<a class="list-group-item" onclick="document.forms['logoutForm'].submit()" style="cursor: pointer">
						<i class="fa fa-search"></i>
						<spring:message code='menu.logout'/>
					</a>

				</c:if>

			</div>
		</div>


		<!-- Page Content -->
		<div style="margin-left: 11%">
			<div class="w3-container w3-teal">
				<h1><spring:message code='registration_form.head'/></h1>
			</div>
			<div class="w3-container" style="margin-top: 15px; display: inline-block;">

				<form:form method="POST" action="${contextPath}/addEntrant" enctype="multipart/form-data">
					<div class="form-group">
							<spring:message code='registration_form.first_name'/>
							<input class="form-control" type="text" name="firstName"/>
					</div>
					<div class="form-group">
							<spring:message code='registration_form.last_name'/>
							<input class="form-control" type="text" name="lastName"/>
					</div>
					<div class="form-group">
							<spring:message code='registration_form.age'/>
							<input class="form-control" type="number" min="0" name="age"/>
					</div>
					<div class="form-group">
							<spring:message code='registration_form.contacts'/>
							<input name="contacts" class="form-control"/>
					</div>
					<div class="form-group">
							<spring:message code='registration_form.faculty'/></td>
							<select class="form-control" name="faculty" >
								<c:forEach var="faculty" items="${allFaculties}">
									<option value="${faculty}" >${faculty}</option>
								</c:forEach>
							</select>
					</div>
						
					<div class="form-group">
					<table>
						<tr>
							<td><spring:message code='registration_form.subject_and_points'/></td>
							<td>								
								<c:forEach var="subject" items="${allSubjects}" >
									<input type="checkbox" name="subjectAndPoints" value="${subject}" /> ${subject} 
									<input class="form-control" name="subjectAndPoints" type="number" min="0" />
									<br>
								</c:forEach>
							</td>
						</tr>
					</table>	
					</div>
						
					<div class="form-group">
							<spring:message code='registration_form.image'/></td>
							<input class="form-control" type="file" name="image" /></td>
					</div>
						
					<div class="form-group">
							<input type="submit" value="<spring:message code='registration_form.register'/>" />
					</div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form:form>

			</div>
		</div>

	</div>
	
</body>
</html>