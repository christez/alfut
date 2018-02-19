<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Mi cuenta</h1>

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

<form:form commandName="user" cssClass="form-horizontal accountForm">
	<h2 class="form-register-heading">Tus datos</h2>
	<div class="form-group">
		<label for="username" class="col-sm-2 control-label registerLabel">Usuario:</label>
		<div class="col-sm-10">
			<form:input path="username" cssClass="form-control" maxlength="20" disabled="true"/>
			<form:errors path="username"/>
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label registerLabel">Contraseña:</label>
		<div class="col-sm-10">
			<form:password path="password" cssClass="form-control" maxlength="50" />
			<form:errors path="password"/>
		</div>
	</div>
	<div class="form-group">
		<label for="password_again" class="col-sm-2 control-label registerLabel">Repetir contraseña:</label>
		<div class="col-sm-10">
			<input type="password" name="password_again" id="password:again" class="form-control" maxlength="50" />
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label registerLabel">Nombre:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" maxlength="20" />
			<form:errors path="name"/>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label registerLabel">Apellido:</label>
		<div class="col-sm-10">
			<form:input path="lastname" cssClass="form-control" maxlength="20" />
			<form:errors path="lastname"/>
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label registerLabel">Email:</label>
		<div class="col-sm-10">
			<form:input path="email" cssClass="form-control" maxlength="50"/>
			<form:errors path="email"/>
		</div>
	</div>
	<div class="form-group">
		<label for="secretQuestion" class="col-sm-2 control-label registerLabel">Pregunta secreta:</label>
		<div class="col-sm-10">
			<form:select path="secretQuestion" cssClass="form-control">
				<form:option value="0" label="Opciones" />
				<form:options items="${questions}" />
			</form:select>
			<form:errors path="secretQuestion" />
		</div>
	</div>
	<div class="form-group">
		<label for="secretAnswer" class="col-sm-2 control-label registerLabel">Respuesta:</label>
		<div class="col-sm-10">
			<form:input path="secretAnswer" cssClass="form-control" maxlength="50"/>
			<form:errors path="secretAnswer"/>
		</div>
	</div>		
	<div class="form-group" align="center">
		<input type="submit" value="Modificar" class="btn btn-lg btn-primary generalFormButton">
	</div>
</form:form>

<script type="text/javascript">
	$(document).ready(function(){
		$(".accountForm").validate(
				{
					rules: {
						password: {
							required: true,
							minlength: 5
						},
						password_again: {
							required: true,
							minlength: 5,
							equalTo: "#password"
						},
						name: {
							required: true,
							minlength: 1
						},
						lastname: {
							required: true,
							minlength: 1
						},
						email: {
							required: true,
							email: true
						},
						secretQuestion: {
							validSelect: true
						},
						secretAnswer: {
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
						password: "La contraseña debe tener al menos 5 caracteres",
						password_again: {
							required: "La contraseña debe tener al menos 5 caracteres",
							equalTo: "Las contraseñas no coinciden"
						},
						name: "El nombre es requerido",
						lastname: "El apellido es requerido",
						email: {
							required: "El email es requerido",
							email: "Email inválido"
						},
						secretAnswer: "La respuesta a la pregunta secreta es requerida"
					}
				}
		);
		
		jQuery.validator.addMethod('validSelect', function (value) {
			return (value != '0');
	    }, "Opción invalida");
	});
</script>