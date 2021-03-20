<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entrants Registration</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link type="text/css"  href="account.css" rel="stylesheet">
</head>
<body>
<body>
	<div class="container">

		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>
			<a href="/registers" class="w3-bar-item w3-button">Register</a>
			
			<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
				<a href="/entrants_list" class="w3-bar-item w3-button">Entrants list</a>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_ENTRANT')">
				<a href="/create-entrant" class="w3-bar-item w3-button">Registration form</a>
			</security:authorize>
		</div>


		<!-- Page Content -->
		<div style="margin-left: 10%">
			<div class="w3-container w3-teal">
				<h1>Create new Registration Sheet</h1>
			</div>
			<div class="w3-container">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
					<h2>
						Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
					</h2>
				</c:if>


				<c:forEach var="faculty" items="${facultiesItems}">
				
				<h3>${faculty.name}</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Administrator Id</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Image</th>
							<th>Faculty</th>
							<th>Total Scores</th>
							
							<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
								<th>Action</th>
							</security:authorize>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="register" items="${registerItems}">						
							<c:if test="${faculty.name == register.entrant.faculty.name}">
								<tr>
									<td>${register.id}</td>
									<td>${register.user.id}</td>
									<td>${register.entrant.firstName}</td>
									<td>${register.entrant.lastName}</td>
									<td><img src="data:image/jpg;base64,${register.entrant.photo}" alt="image" style="width: 10%"></td>
									<td>${register.entrant.faculty.name}</td>
									<td>${register.entrant.totalScore}</td>
									
									<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
										<td><a href="register?id=${register.id}">delete</a></td>
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