<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<!doctype html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href='<c:url value="/resources/images/icon.png"/>' />
<link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"/>'>
<link rel="stylesheet" href='<c:url value="/resources/css/jquery-ui.css"/>'>
<link rel="stylesheet" href='<c:url value="/resources/css/style.css"/>'>
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Montserrat">
<script type="text/javascript" src='<c:url value="/resources/js/jquery.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery-ui.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/bootstrap.min.js" />'></script>
<title><tiles:getAsString name="title"></tiles:getAsString></title>
</head>
<body>
	<tilesx:useAttribute name="current" />

	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		              	<span class="sr-only">Toggle navigation</span>
		              	<span class="icon-bar"></span>
		              	<span class="icon-bar"></span>
		              	<span class="icon-bar"></span>
		            </button>
					<a class="navbar-brand" href='<spring:url value="/"></spring:url>'>ALFUT</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<security:authorize access="!isAuthenticated()">
							<li class="${current == 'index' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/"></spring:url>'>Inicio</a></li>
						</security:authorize>
						<security:authorize access="!isAuthenticated()">
							<li class="${current == 'open-league' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/open-league.html"></spring:url>'>Nuestras ligas</a></li>
						</security:authorize>
						<security:authorize access="!isAuthenticated()">
							<li class="${current == 'open-news' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/open-news.html"></spring:url>'>Nuestras noticias</a></li>
						</security:authorize>
						<security:authorize access="!isAuthenticated()">
							<li class="${current == 'open-world-league' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/open-world-league.html"></spring:url>'>Ligas del mundo</a></li>
						</security:authorize>
						<security:authorize access="!isAuthenticated()">
							<li class="${current == 'open-world-new' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/open-world-new.html"></spring:url>'>Noticias del mundo</a></li>
						</security:authorize>
						<security:authorize access="hasRole('ROLE_USER')">
							<li class="${current == 'league-admin' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/league-admin.html"></spring:url>'>Administrar ligas</a></li>
				    	</security:authorize>
				    	<security:authorize access="hasRole('ROLE_USER')">
							<li class="${current == 'news-admin' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/news-admin.html"></spring:url>'>Administrar noticias</a></li>
				    	</security:authorize>
				    	<security:authorize access="hasRole('ROLE_USER')">
							<li class="${current == 'account' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/account.html"></spring:url>'>Administrar cuenta</a></li>
				    	</security:authorize>
				    	<security:authorize access="hasRole('ROLE_USER')">
							<li class="${current == 'support' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/support.html"></spring:url>'>Soporte</a></li>
				    	</security:authorize>
				    	<security:authorize access="hasRole('ROLE_USER')">
							<li class="${current == 'wiki' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/wiki.html"></spring:url>'>Wiki</a></li>
				    	</security:authorize>
				    	<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current == 'users' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/users.html"></spring:url>'>Usuarios</a></li>
				    	</security:authorize>
				    	<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current == 'support-admin' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/support-admin.html"></spring:url>'>Casos de soporte</a></li>
				    	</security:authorize>
				    	<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current == 'exceptions' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/exceptions.html"></spring:url>'>Excepciones</a></li>
				    	</security:authorize>
				    	<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current == 'world-league' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/world-league.html"></spring:url>'>Ligas del mundo</a></li>
				    	</security:authorize>
				    	<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current == 'world-news' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/world-news.html"></spring:url>'>Noticias del mundo</a></li>
				    	</security:authorize>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<security:authorize access="!isAuthenticated()">
					    	<li class="${current == 'register' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/register.html"></spring:url>'>Registrarse</a></li>
					    	<li class="${current == 'login' ? 'active' : ''}"><a class="nav-link" href='<spring:url value="/login.html"></spring:url>'>Ingresar</a></li>
				    	</security:authorize>
				    	<security:authorize access="isAuthenticated()">
					    	<li><a class="nav-link" href='<spring:url value="/logout"></spring:url>'>Logout</a></li>
				    	</security:authorize>
					</ul>
				</div>
			</div>
		</nav>

		<tiles:insertAttribute name="body" />

		<hr />

		<div align="center">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>	
</body>
</html>