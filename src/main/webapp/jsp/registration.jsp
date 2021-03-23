<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    
    <link type="text/css"  href="login.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>

<body>

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="https://cdn4.iconfinder.com/data/icons/education-685/66/22-512.png" id="icon" alt="Login icon" />
    </div>


    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading"><spring:message code='registration.title'/></h2>
                
        <spring:bind path="login">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<spring:message code='registration.login' var="lang_login"/>
                <form:input type="text" path="login" class="form-control fadeIn second" placeholder="${lang_login}" autofocus="true"></form:input>
                <form:errors path="login"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<spring:message code='registration.password' var="lang_password"/>
                <form:input type="password" path="password" class="form-control fadeIn second" placeholder="${lang_password}"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<spring:message code='registration.password_confirm' var="lang_password_confirm"/>
                <form:input type="password" path="passwordConfirm" class="form-control fadeIn second" placeholder="${lang_password_confirm}"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>

        <input class="fadeIn fourth" type="submit" value="<spring:message code='registration.create_account'/>"/>
    </form:form>
</div>
</div>

</body>
</html>