<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Liga <span class="orangeColor">${league.name}</span></h1>

<hr />

<a href='<spring:url value="/league-admin.html" />' class="btn btn-lg btnAdministrationPrimary" data-toggle="modal">Volver a "Ligas"</a>

<hr />

<form:form commandName="league" cssClass="form-horizontal leagueForm">
	<c:if test="${success eq true}">
		<div class="alert alert-success alert-dismissable">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
		    <strong>Acción completada.</strong> <c:out value="${message}"/>
		</div>
	</c:if>

	<h2 class="form-team-update-heading">Información de la liga</h2>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Nombre:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" maxlength="50"/>
			<form:errors path="name"/>
		</div>
	</div>
	<div class="form-group">
		<label for="additionalInfo" class="col-sm-2 control-label">Información adicional:</label>
		<div class="col-sm-10">
			<form:textarea path="additionalInfo" cssClass="form-control" maxlength="200"/>
			<form:errors path="additionalInfo"/>
		</div>
	</div>
	<div class="form-group">
		<label for="lattitud" class="col-sm-2 control-label">Latitud:</label>
		<div class="col-sm-10">
			<form:input path="lattitud" cssClass="form-control" maxlength="20"/>
			<form:errors path="lattitud"/>
		</div>
	</div>
	<div class="form-group">
		<label for="longitud" class="col-sm-2 control-label">Longitud:</label>
		<div class="col-sm-10">
			<form:input path="longitud" cssClass="form-control" maxlength="20"/>
			<form:errors path="longitud"/>
		</div>
	</div>
	<div class="form-group" align="center">
		<br />
		<input type="submit" value="Actualizar" class="btn btn-lg btn-primary btnRedirect">
		<br />
		<br />
	</div>
</form:form>

<script type="text/javascript">
	$(document).ready(function() {
		$(".leagueForm").validate(
				{
					rules: {
						name: {
							required: true,
							minlength: 1
						},
						additionalInfo: {
							required: true,
							minlength: 1,
							maxlength: 200
						},
						lattitud: {
							required: true,
							number: true,
							range:[-85,85]
						},
						longitud: {
							required: true,
							number: true,
							range:[-180,180]
						}
					},
					highlight: function(element){
						$(element).closest(".form-group").removeClass("has-success").addClass("has-error");
					},
					unhighlight: function(element){
						$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
					},
					messages: {
						name: "El nombre de la liga debe tener al menos 1 caracterer",
						additionalInfo: "El nombre de la liga debe tener al menos 1 caracterer y máximo 200",
						lattitud: {
							required: "Campo faltante",
							number: "Ingresa solo números",
							range: "Ingresa un número entre -85 y 85"
						},
						longitud: {
							required: "Campo faltante",
							number: "Ingresa solo números",
							range: "Ingresa un número entre -180 y 180"
						}
					}
				}
		);
	});
</script>