<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Configuración</h1>

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

<form:form commandName="configuration" cssClass="form-horizontal configurationForm">
	<h2 class="form-register-heading">URLs</h2>
	<div class="form-group">
		<label for="activateUrl" class="col-sm-2 control-label registerLabel">URL de activación:</label>
		<div class="col-sm-10">
			<form:input path="activateUrl" cssClass="form-control" maxlength="100"/>
			<form:errors path="activateUrl"/>
		</div>
	</div>
	<div class="form-group">
		<label for="restoreUrl" class="col-sm-2 control-label registerLabel">URL de recuperación:</label>
		<div class="col-sm-10">
			<form:input path="restoreUrl" cssClass="form-control" maxlength="100"/>
			<form:errors path="restoreUrl"/>
		</div>
	</div>
	<hr />
	<h2 class="form-register-heading">Notificación</h2>
	<div class="form-group">
		<label for="notificationHost" class="col-sm-2 control-label registerLabel">Servidor:</label>
		<div class="col-sm-10">
			<form:input path="notificationHost" cssClass="form-control" maxlength="100" />
			<form:errors path="notificationHost"/>
		</div>
	</div>
	<div class="form-group">
		<label for="notificationPort" class="col-sm-2 control-label registerLabel">Puerto:</label>
		<div class="col-sm-10">
			<form:input path="notificationPort" cssClass="form-control" maxlength="100"/>
			<form:errors path="notificationPort"/>
		</div>
	</div>
	<div class="form-group">
		<label for="notificationFrom" class="col-sm-2 control-label registerLabel">De:</label>
		<div class="col-sm-10">
			<form:input path="notificationFrom" cssClass="form-control" maxlength="100"/>
			<form:errors path="notificationFrom"/>
		</div>
	</div>
	<div class="form-group">
		<label for="notificationUsername" class="col-sm-2 control-label registerLabel">Usuario:</label>
		<div class="col-sm-10">
			<form:input path="notificationUsername" cssClass="form-control" maxlength="100" />
			<form:errors path="notificationUsername"/>
		</div>
	</div>
	<div class="form-group">
		<label for="notificationPassword" class="col-sm-2 control-label registerLabel">Contraseña:</label>
		<div class="col-sm-10">
			<form:input path="notificationPassword" cssClass="form-control" maxlength="100" />
			<form:errors path="notificationPassword"/>
		</div>
	</div>
	<div class="form-group" align="center">
		<input type="submit" value="Modificar" class="btn btn-lg btn-primary">
	</div>
</form:form>

<script type="text/javascript">
	$(document).ready(function(){
		$(".configurationForm").validate(
				{
					rules: {
						activateUrl: {
							required: true
						},
						notificationFrom: {
							required: true
						},
						notificationHost: {
							required: true
						},
						notificationPassword: {
							required: true
						},
						notificationPort: {
							required: true,
							number: true
						},
						notificationUsername: {
							required: true
						},
						restoreUrl: {
							required: true
						}					
					},
					highlight: function(element){
						$(element).closest(".form-group").removeClass("has-success").addClass("has-error");
					},
					unhighlight: function(element){
						$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
					},
					messages: {
						activateUrl: "El campo es requerido",
						notificationFrom: "El campo es requerido",
						notificationHost: "El campo es requerido",
						notificationPassword: "El campo es requerido",
						notificationPort: {
							required: "El campo es requerido",
							number: "El campo es de tipo numérico"
						},
						notificationUsername: "El campo es requerido",
						restoreUrl: "El campo es requerido"
					}
				}
		);
	});
</script>