<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Noticia "${newHeader}"</h1>

<hr />

<a href='<spring:url value="/news-admin.html" />' class="btn btn-lg btn-info" data-toggle="modal">Volver a "Noticias"</a>

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

<form:form commandName="new" cssClass="form-horizontal newDetailForm">
	<h2 class="form-register-heading">Datos del torneo</h2>
	<div class="form-group">
		<label for="header" class="col-sm-2 control-label">Encabezado:</label>
		<div class="col-sm-10">
			<form:input path="header" cssClass="form-control" maxlength="50"/>
			<form:errors path="header"/>
		</div>
	</div>
	<div class="form-group">
		<label for="information" class="col-sm-2 control-label">Información:</label>
		<div class="col-sm-10">
			<form:textarea path="information" cssClass="form-control" maxlength="200"/>
			<form:errors path="information"/>
		</div>
	</div>
	<div class="form-group">
		<label for="type" class="col-sm-2 control-label">Tipo de noticia:</label>
		<div class="col-sm-10">
			<form:select path="type" cssClass="form-control">
				<form:option value="0" label="Opciones" />
				<form:options items="${type}" />
			</form:select>
			<form:errors path="type" />
		</div>
	</div>
	<div class="form-group" align="center">
		<input type="submit" value="Actualizar" class="btn btn-lg btn-primary generalFormButton">
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