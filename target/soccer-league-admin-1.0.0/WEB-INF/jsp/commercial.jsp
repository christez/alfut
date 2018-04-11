<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<div align="center">
	<h1 class="mainHeader">ANÚNCIATE</h1>
	
	<div class="commercialDetail">
		<p>Envíanos tus datos y nos pondremos en contacto contigo a la brevedad</p>
	</div>
</div>

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

<form:form commandName="commercial" cssClass="form-horizontal commercialForm">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Nombre:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" maxlength="25" />
			<form:errors path="name"/>
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email:</label>
		<div class="col-sm-10">
			<form:input path="email" cssClass="form-control" maxlength="50" />
			<form:errors path="email"/>
		</div>
	</div>
	<div class="form-group">
		<label for="message" class="col-sm-2 control-label">Mensaje:</label>
		<div class="col-sm-10">
			<form:textarea path="message" cssClass="form-control" maxlength="500"/>
			<form:errors path="message"/>
		</div>
	</div>
	<div class="form-group" align="center">
		<input type="submit" value="Enviar" class="btn btn-lg btn-success btnRedirect">
	</div>
</form:form>

<script type="text/javascript">
	$(document).ready(function(){
		$(".commercialForm").validate(
				{
					rules: {
						name: {
							required: true,
							minlength: 1
						},
						email: {
							required: true,
							email: true
						},
						message: {
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
						name: {
							required: "El nombre es requerido",
							minlength: "El nombre debe tener mínimo 1 caracter"
						},
						email: {
							required: "El email es requerido",
							email: "Email inválido"
						},
						message: {
							required: "El mensaje es requerido",
							minlength: "El mensaje debe tener mínimo 1 caracter"
						}
					}
				}
		);
	});
</script>