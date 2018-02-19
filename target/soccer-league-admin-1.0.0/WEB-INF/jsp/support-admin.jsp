<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Casos de soporte</h1>

<hr />

<c:if test="${success eq true}">
	<div class="alert alert-success alert-dismissable">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
	    <strong>Acción completada.</strong> <c:out value="${message}"/>
	</div>
</c:if>

<c:if test="${redirectedError eq true}">
	<div class="alert alert-danger alert-dismissable">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
	    <strong>Ocurrió un error.</strong> <c:out value="${message}"/>
	</div>
</c:if>

<c:choose>
	<c:when test="${empty(supportCases)}">
		<div class="alert alert-success">
			<strong>No existe ningún caso creado.</strong>
		</div>
		<div align="center">
			<img alt="goodIcon" src='<c:url value="/resources/images/checkmark.png"/>'>
		</div>
	</c:when>
	<c:otherwise>
		<table class="table table-bordered table-xs table-condensed teamTable">
			<thead class="teamTableHeader">
				<tr>
					<th>#</th>
					<th>Título</th>
					<th>Tipo</th>
					<th>Estatus</th>
					<th>Fecha de creación</th>
					<th>Usuario</th>
					<th>Detalle</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="caseCounter" scope="session" value="${1}"/>
				
				<c:forEach items="${supportCases}" var="myCase">
					<tr class="teamTableHover">
						<td class="teamTableBolder">
							<c:out value="${caseCounter}" />
						</td>
						<td class="teamTableBolder">
							<c:out value="${myCase.title}" />
						</td>
						<td>
							<c:out value="${myCase.type}" />
						</td>
						<td>
							<c:out value="${myCase.status}" />
						</td>
						<td>
							<fmt:formatDate value="${myCase.creationDate}" pattern="yyyy/MM/dd HH:mm:ss"/>
						</td>
						<td>
							<c:out value="${myCase.user.username}" />
						</td>
						<td>
							<a href='<spring:url value="/support-detail.html?rpSupportCaseId=${myCase.id}" />' class="btn btn-info btn-xs">Detalle</a>
						</td>
					</tr>
					
					<c:set var="caseCounter" scope="session" value="${caseCounter + 1}"/>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>