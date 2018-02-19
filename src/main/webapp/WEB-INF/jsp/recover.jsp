<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<div align="center">
	<img src='<c:url value="/resources/images/recover.png"/>' alt="recover">
</div>

<c:if test="${success eq true}">
	<div class="alert alert-success alert-dismissable">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
	    <strong>Acción completada.</strong> Tu contraseña temporal es: "<c:out value="${message}"/>". Te recomendamos cambiarla lo más pronto posible
	</div>
</c:if>

<c:if test="${redirectedError eq true}">
	<div class="alert alert-danger alert-dismissable">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
	    <strong>Ocurrió un error.</strong> <c:out value="${message}"/>
	</div>
</c:if>

<form:form commandName="user" cssClass="form-horizontal registrationForm">
	<div class="form-group">
		<label for="username" class="col-sm-2 control-label registerLabel">Usuario:</label>
		<div class="col-sm-10">
			<form:input path="username" cssClass="form-control" maxlength="20" />
			<form:errors path="username"/>
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
			<form:password path="secretAnswer" cssClass="form-control" maxlength="50"/>
			<form:errors path="secretAnswer"/>
		</div>
	</div>	
	<div class="form-group" align="center">
		<input type="submit" value="Recuperar" class="btn btn-lg btn-primary generalFormButton">
	</div>
</form:form>

<script type="text/javascript">
	$(document).ready(function(){
		$(".registrationForm").validate(
				{
					rules: {
						username: {
							required: true,
							minlength: 3,
							maxlength: 20
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
						username: {
							required: "El usuario es requerido",
							minlength: "El usuario debe tener mínimo 3 caracteres",
							maxlength: "El usuario debe tener máximo 20 caracteres"
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