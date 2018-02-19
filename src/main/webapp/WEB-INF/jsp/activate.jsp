<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<c:if test="${success eq true}">
	<div class="alert alert-success text-center">
		Activación exitosa ya puedes ingresar a tu cuenta dando click
	
		<br />
		<br />
		
		<a href='<spring:url value="/login.html"></spring:url>' class="btn btn-xl btn-info">AQUÍ</a>		
	</div>
</c:if>

<c:if test="${success eq false}">
	<div class="alert alert-danger text-center"><c:out value="${message}"/></div>
</c:if>