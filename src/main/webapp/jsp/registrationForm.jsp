<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Periodicals</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<body>
	<div class="container">

		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>
			<a href="/home" class="w3-bar-item w3-button">Home</a>
			<a href="/create-periodical" class="w3-bar-item w3-button">Registration form</a>
			<a href="#" class="w3-bar-item w3-button">Bucket</a>
		</div>


		<!-- Page Content -->
		<div style="margin-left: 10%">
			<div class="w3-container w3-teal">
				<h1>Create registration form</h1>
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


				<form:form method="POST" action="${contextPath}/addEntrant" modelAttribute="entrant">
					<table>
						<tr>
							<td><form:label path="firstName">First Name</form:label></td>
							<td><form:input path="firstName" /></td>
						</tr>
						<tr>
							<td><form:label path="lastName">Last Name</form:label></td>
							<td><form:input path="lastName" /></td>
						</tr>
						<tr>
							<td><form:label path="age">Age</form:label></td>
							<td><form:input path="age" type="number" min="0" /></td>
						</tr>
						<tr>
							<td><form:label path="contacts">Contacts</form:label></td>
							<td><form:input path="contacts" /></td>
						</tr>
						<tr>
							<td><form:label path="faculty">Faculty</form:label></td>
							<td>
								<form:select path="faculty" >
									<c:forEach var="faculty" items="${allFaculties}">
										<option value="${faculty}" >${faculty}</option>
									</c:forEach>
								</form:select>
							</td>
						</tr>
						
						<tr>
							<td><form:label path="subjectAndPoints">Subject And Points</form:label></td>
							<td>								
								<c:forEach var="subject" items="${allSubjects}" >
									<form:checkbox path="subjectAndPoints" value="${subject}" /> ${subject} 
									<form:input path="subjectAndPoints" type="number" min="0" />
									<br>
								</c:forEach>
							</td>
						</tr>
						
						<tr>
							<td><input type="submit" value="Submit" /></td>
						</tr>
					</table>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form:form>

			</div>
		</div>

	</div>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>