<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<div align="center">
	<h1 class="mainHeader">INGRESA TUS DATOS</h1>
</div>

<c:if test="${success eq true}">
	<div class="alert alert-success alert-dismissable">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
	    <strong>Acción completada.</strong> Registro exitoso. Ya puedes acceder a tu cuenta
	</div>
</c:if>

<c:if test="${invalid eq true}">
	<div class="alert alert-success alert-dismissable">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
	    <strong>Ocurrió un error.</strong> Usuario no disponible. Intenta con otro
	</div>
</c:if>

<form:form commandName="user" cssClass="form-horizontal registrationForm">
	<div class="form-group">
		<label for="username" class="col-sm-2 control-label">Usuario:</label>
		<div class="col-sm-10">
			<form:input path="username" cssClass="form-control" maxlength="20" />
			<form:errors path="username"/>
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Contraseña:</label>
		<div class="col-sm-10">
			<form:password path="password" cssClass="form-control" maxlength="50" />
			<form:errors path="password"/>
		</div>
	</div>
	<div class="form-group">
		<label for="password_again" class="col-sm-2 control-label">Repetir contraseña:</label>
		<div class="col-sm-10">
			<input type="password" name="password_again" id="password:again" class="form-control" maxlength="50" />
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Nombre:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" maxlength="20" />
			<form:errors path="name"/>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Apellido:</label>
		<div class="col-sm-10">
			<form:input path="lastname" cssClass="form-control" maxlength="20" />
			<form:errors path="lastname"/>
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email:</label>
		<div class="col-sm-10">
			<form:input path="email" cssClass="form-control" maxlength="50"/>
			<form:errors path="email"/>
		</div>
	</div>	
	<div class="form-group">
		<label for="secretQuestion" class="col-sm-2 control-label">Pregunta secreta:</label>
		<div class="col-sm-10">
			<form:select path="secretQuestion" cssClass="form-control">
				<form:option value="0" label="Opciones" />
				<form:options items="${questions}" />
			</form:select>
			<form:errors path="secretQuestion" />
		</div>
	</div>
	<div class="form-group">
		<label for="secretAnswer" class="col-sm-2 control-label">Respuesta:</label>
		<div class="col-sm-10">
			<form:password path="secretAnswer" cssClass="form-control" maxlength="50"/>
			<form:errors path="secretAnswer"/>
		</div>
	</div>
	<div class="form-group" align="center">
		<br />
		<input type="checkbox" name="terms"><a href="#myModal" class="footerLink" data-toggle="modal">Acepto términos y condiciones</a>
	</div>
	<div class="form-group" align="center">
		<input type="submit" value="Registrar" class="btn btn-lg btn-primary btnRedirect">
	</div>
</form:form>

<div id="myModal" class="modal fade termsAndConditions">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">Términos y condiciones</h4>
			</div>
			<div class="modal-body">
				<h3 class="termsAndConditionsHeader">Uno</h3>
				<div align="justify">
					Al acceder a este sitio web, aceptas estar obligado por estos términos y condiciones de uso del sitio web, 
					todas las leyes y regulaciones aplicables y aceptas ser responsable del cumplimiento de las leyes locales aplicables. 
					Si no estás de acuerdo con alguno de estos términos, queda prohibido utilizar o acceder a este sitio. 
					Los materiales contenidos en este sitio web están protegidos por las leyes aplicables de derechos de autor y marcas.
				</div>
				<hr class="clusterScheduleDivider"/>
				
				<h3 class="termsAndConditionsHeader">Dos</h3>
				<div align="justify">
					Los términos y condiciones del sitio pueden cambiar en cualquier momento. Las modificaciones a estos términos entrarán en vigor 
					inmediatamente después de su publicación en el sitio web. Aceptas y eres responsable de revisar periódicamente este acuerdo para 
					que tengas familiaridad con su contenido. Al continuar utilizando cualquier parte del sitio, significa que aceptas los términos 
					actualizados o revisados. Debes dejar de usar este sitio si no estás de acuerdo con los términos listados.
				</div>
				<hr class="clusterScheduleDivider"/>
				
				<h3 class="termsAndConditionsHeader">Tres</h3>
				<div align="justify">
					Solo se puede crear una cuenta. Crear una SEGUNDA cuenta es una VIOLACIÓN de los términos y condiciones y podría resultar en la 
					baja permanente sin previo aviso.
				</div>
				<hr class="clusterScheduleDivider"/>
				
				<h3 class="termsAndConditionsHeader">Cuatro</h3>
				<div align="justify">
					El sitio web ofrece servicios de administración de ligas de fútbol gratuitos a los usuarios registrados así como información general
					relacionada con el mundo del fútbol para el resto de la audiencia.
				</div>
				<hr class="clusterScheduleDivider"/>
				
				<h3 class="termsAndConditionsHeader">Cinco</h3>
				<div align="justify">
					Protegeremos la información personal mediante medidas de seguridad razonables contra pérdida o robo, así como el acceso no autorizado, 
					divulgación, copia, uso o modificación. Si nos proporciona su dirección de correo electrónico, acepta que el sitio web lo contacte por esta vía.
				</div>
				<hr class="clusterScheduleDivider"/>
				
				<h3 class="termsAndConditionsHeader">Seis</h3>
				<div align="justify">
					El sitio web se reserva el derecho de interrumpir el servicio de vez en cuando para realizar el mantenimiento, de forma regular o de 
					cualquier otra forma con o sin previo aviso. Usted acepta que el sitio web no será responsable de ninguna interrupción del servicio o 
					retraso o falla en el desempeño que resulte de cualquier causa.
				</div>
				<hr class="clusterScheduleDivider"/>
				
				<h3 class="termsAndConditionsHeader">Siete</h3>
				<div align="justify">
					El sitio no será responsables de ningún daño (incluyendo, sin limitación, daños por pédida de datos o ganancias, o debido a la 
					
				</div>
				<hr class="clusterScheduleDivider"/>
				
				<h3 class="termsAndConditionsHeader">Ocho</h3>
				<div align="justify">
					Esperamos que disfrutes de tu estancia en nuestro sitio web. Recuerde que eres un invitado en el sitio web, no olvides actuar con la 
					misma cortesía y respeto que esperarías de otros usuarios. El sitio web siempre se reserva el derecho de rechazar o terminar el servicio. 
					Gracias nuevamente por visitar el sitio web.
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		$(".registrationForm").validate(
				{
					rules: {
						username: {
							required: true,
							minlength: 3,
							maxlength: 20,
							remote: {
								url: "<spring:url value='/register/available.html' />",
								type: "get",
								data: {
									username: function(){
										return $("#username").val();
									}
								}
							}
						},
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
						},
						terms: {
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
							maxlength: "El usuario debe tener máximo 20 caracteres",
							remote: "Usuario no disponible. Intenta con otro"
						},
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
						secretAnswer: "La respuesta a la pregunta secreta es requerida",
						terms: "Debes aceptar los términos y condiciones"
					}
				}
		);
		
		jQuery.validator.addMethod('validSelect', function (value) {
			return (value != '0');
	    }, "Opción invalida");
	});
</script>