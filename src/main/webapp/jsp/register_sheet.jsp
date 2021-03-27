<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title><spring:message code='register_sheet.title'/></title>
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
				<h1><spring:message code='register_sheet.head'/></h1>
			</div>
			<div class="w3-container">

				<c:forEach var="faculty" items="${facultiesItems}">
				
				<h3>${faculty.name}</h3>
				<table class="table table-striped">
					<thead>
						<tr style="text-align: center;">
							<th style="width: 2%">Id</th>
							<th style="width: 3%"><spring:message code='register_sheet.admin_id'/></th>
							<th style="width: 10%"><spring:message code='register_sheet.first_name'/></th>
							<th style="width: 10%"><spring:message code='register_sheet.last_name'/></th>
							<th><spring:message code='register_sheet.image'/></th>
							<th style="width: 5%"><spring:message code='register_sheet.faculty'/></th>
							<th style="width: 2%"><spring:message code='register_sheet.total_scores'/></th>
							
							<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
								<th><spring:message code='register_sheet.action'/></th>
							</security:authorize>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="register" items="${registerItems}">						
							<c:if test="${faculty.name == register.entrant.faculty.name}">
								<tr style="text-align: center;">
									<td style="width: 2%">${register.id}</td>
									<td style="width: 3%">${register.user.id}</td>
									<td style="width: 10%">${register.entrant.firstName}</td>
									<td style="width: 10%">${register.entrant.lastName}</td>
									<td><img src="data:image/jpg;base64,${register.entrant.photo}" alt="image" style="width: 10%"></td>
									<td style="width: 5%">${register.entrant.faculty.name}</td>
									<td style="width: 2%">${register.entrant.totalScore}</td>
									
									<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
										<td><a href="register?id=${register.id}"><spring:message code='register_sheet.delete'/></a></td>
									</security:authorize>	
							</tr>
							</c:if>
						</c:forEach>						
					</tbody>
					</table>
				
				</c:forEach>
			</div>
		</div>

	</div>

</body>
</html>