<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Torneo <span class="orangeColor">${tournament.name}</span></h1>

<hr />

<a href='<spring:url value="/tournament-admin.html" />' class="btn btn-lg btnAdministrationPrimary" data-toggle="modal">Volver a "Torneos"</a>

<hr />

<c:if test="${success eq true}">
	<div class="alert alert-success alert-dismissable">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
	    <strong>Acción completada.</strong> <c:out value="${message}"/>
	</div>
</c:if>

<c:if test="${redirectedError eq true}">
	<div class="alert alert-success alert-dismissable">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
	    <strong>Ocurrió un error.</strong> <c:out value="${message}"/>
	</div>
</c:if>

<form:form commandName="tournament" cssClass="form-horizontal tournamentDetailForm">
	<h2 class="form-register-heading">Datos del torneo</h2>
	<div class="form-group">
		<label for="name" class="col-sm-3 control-label">Nombre:</label>
		<div class="col-sm-9">
			<form:input path="name" cssClass="form-control" maxlength="50" />
			<form:errors path="name" />
		</div>
	</div>
	<div class="form-group">
		<label for="description" class="col-sm-3 control-label">Descripción:</label>
		<div class="col-sm-9">
			<form:textarea path="description" cssClass="form-control" maxlength="250" />
			<form:errors path="description" />
		</div>
	</div>
	<div class="form-group">
		<label for="type" class="col-sm-3 control-label">Tipo de torneo:</label>
		<div class="col-sm-9">
			<form:input path="type" cssClass="form-control" maxlength="50" disabled="true"/>
			<form:errors path="type" />
		</div>
	</div>
	<div class="form-group" align="center">
		<br />
		<input type="submit" value="Actualizar" class="btn btn-lg btn-primary btnRedirect">
	</div>
</form:form>

<script type="text/javascript">
	$(document).ready(function() {
		$(".tournamentDetailForm").validate(
				{
					rules: {
						name: {
							required: true,
							minlength: 1
						},
						description: {
							required: true,
							minlength: 1
						},
						type: {
							required: true,
							minlength: 1
						}
					},
					highlight: function(element){
						$(element).closest(".form-group").removeClass("has-success").addClass("has-error");
					},
					unhighlight: function(element){
						$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
					},
					messages: {
						name: "El nombre debe tener al menos 1 caracterer",
						description: "La descripción debe tener al menos 1 caracterer",
						type: "El tipo debe tener al menos 1 caracterer"
					}
				}
		);
		
		jQuery.validator.addMethod('validSelect', function (value) {
			return (value != '0');
	    }, "Opción invalida");
	});
</script>