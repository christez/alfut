<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
	<div class="alert alert-danger alert-dismissable">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
	    <strong><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.</strong>
	</div>
</c:if>

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

<div align="center">
	<img alt="login" src='<c:url value="/resources/images/login.png"/>'>
</div>

<form class="form-signin" action='<spring:url value="/j_spring_security_check"></spring:url>' method="POST">
	<input type="text" name="j_username" class="form-control" placeholder="Usuario" required autofocus maxlength="20">
	<input type="password" name="j_password" class="form-control" placeholder="Contraseña" required autofocus maxlength="50">
	<button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
</form>

<div align="center">
	<a href='<spring:url value="/recover.html" />' class="btn btn-link" data-toggle="modal">¿Olvidaste tu contraseña?</a>
</div>

<!--div align="center">
	<a href="#recoverModal" class="btn btn-link" data-toggle="modal">¿Olvidaste tu contraseña?</a>
</div-->

<!--div class="activateReminder" align="center">
	<h3 data-toggle="tooltip" title="Utiliza el correo de activación recibido" data-placement="bottom">No olvides activar tu cuenta<br /><small class="activateReminder">Es fácil y rápido</small></h3>
</div-->

<form:form commandName="user" cssClass="form-horizontal restoreForm">
	<div id="recoverModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Recuperar contraseña</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="username" class="col-sm-3 control-label">Usuario:</label>
						<div class="col-sm-9">
							<form:input path="username" cssClass="form-control" maxlength="50" />
							<form:errors path="username" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					<input type="submit" class="btn btn-primary" value="Recuperar" name="restore">
				</div>
			</div>
		</div>
	</div>
</form:form>

<script type="text/javascript">
	$(document).ready(function() {
		$(".restoreForm").validate(
				{
					rules: {
						name: {
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
						name: "El nombre debe tener al menos 1 caracterer"
					}
				}
		);
	});
</script>