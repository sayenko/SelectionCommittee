<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title><spring:message code="entrants_list.title"/></title>

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
				<h1><spring:message code="entrants_list.head"/></h1>
			</div>

			<div class="w3-container">

				<c:if test="${not empty entrants}">
					<c:forEach items="${entrants}" var="currentEntrant">

						<div class="w3-card-4" style="width: 20%; margin: 2%; float:left">
							<img src="data:image/jpg;base64, ${currentEntrant.photo}" alt="photo" style="width: 100%">
							<div class="w3-container w3-center">
								<h3>${currentEntrant.firstName}</h3>
								<p>${currentEntrant.lastName}</p>
								<p>${currentEntrant.age}</p>
								<p>${currentEntrant.contacts}</p>
								<p>${currentEntrant.faculty.name}</p>
								<c:forEach items="${currentEntrant.subjectsMap}" var="subjectsAndPoints">
									<p>${subjectsAndPoints.key}:  ${subjectsAndPoints.value}</p>
								</c:forEach>
							</div>
							
							<form:form action="${contextPath}/register" method="POST" enctype="multipart/form-data">
								<input type="hidden" value="${currentEntrant.id}" class="form-control"  name="entrantId">
								<input type="hidden" value="${currentEntrant.faculty.name}" class="form-control"  name="facultyName">
								<input type="submit" class="w3-button w3-block w3-dark-grey" value="<spring:message code='entrants_list.add'/>"/>
							</form:form>
						</div>

					</c:forEach>
				</c:if>
			</div>

		</div>


	</div>

</body>
</html>