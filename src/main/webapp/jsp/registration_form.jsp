<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entrants Registration</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<body>
	<div class="container">

		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>
			<a href="/home" class="w3-bar-item w3-button">Home</a>
			<a href="/create-entrant" class="w3-bar-item w3-button">Registration form</a>
			<a href="/registers" class="w3-bar-item w3-button">Register</a>
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


				<form:form method="POST" action="${contextPath}/addEntrant" enctype="multipart/form-data">
					<table>
						<tr>
							<td>First Name</td>
							<td><input type="text" name="firstName" /></td>
						</tr>
						<tr>
							<td>Last Name</td>
							<td><input type="text" name="lastName" /></td>
						</tr>
						<tr>
							<td>Age</td>
							<td><input type="number" min="0" name="age" /></td>
						</tr>
						<tr>
							<td>Contacts</td>
							<td><input name="contacts" /></td>
						</tr>
						<tr>
							<td>Faculty</td>
							<td>
								<select name="faculty" >
									<c:forEach var="faculty" items="${allFaculties}">
										<option value="${faculty}" >${faculty}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						
						<tr>
							<td>Subject And Points</td>
							<td>								
								<c:forEach var="subject" items="${allSubjects}" >
									<input type="checkbox" name="subjectAndPoints" value="${subject}" /> ${subject} 
									<input name="subjectAndPoints" type="number" min="0" />
									<br>
								</c:forEach>
							</td>
						</tr>
						
						<tr>
							<td>Select an image to upload</td>
							<td><input type="file" name="image" /></td>
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
	
</body>
</html>