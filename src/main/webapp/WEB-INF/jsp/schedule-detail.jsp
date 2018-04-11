<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Jornada <span class="orangeColor">${scheduleNumber}</span></h1>

<hr />

<a href='<spring:url value="/schedule-admin.html" />' class="btn btn-lg btnAdministrationPrimary" data-toggle="modal">Volver a "Jornadas"</a>

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

<form:form commandName="match" cssClass="form-horizontal matchForm">
	<h2 class="form-team-update-heading">Información del enfrentamiento</h2>
	<div class="form-group">
		<label for="teamLocalName" class="col-sm-3 control-label">Equipo local:</label>
		<div class="col-sm-9">
			<form:input path="teamLocalName" cssClass="form-control" maxlength="50" disabled="true"/>
			<form:errors path="teamLocalName" />
		</div>
	</div>
	<div class="form-group">
		<label for="goalsLocal" class="col-sm-3 control-label">Goles del equipo local:</label>
		<div class="col-sm-9">
			<form:input path="goalsLocal" cssClass="form-control" maxlength="5" />
			<form:errors path="goalsLocal" />
		</div>
	</div>
	<div class="form-group">
		<label for="teamVisitorName" class="col-sm-3 control-label">Equipo visitante:</label>
		<div class="col-sm-9">
			<form:input path="teamVisitorName" cssClass="form-control" maxlength="50" disabled="true"/>
			<form:errors path="teamVisitorName" />
		</div>
	</div>
	<div class="form-group">
		<label for="goalsVisitor" class="col-sm-3 control-label">Goles del equipo local:</label>
		<div class="col-sm-9">
			<form:input path="goalsVisitor" cssClass="form-control" maxlength="5" />
			<form:errors path="goalsVisitor" />
		</div>
	</div>
	<div class="form-group">
		<label for="date" class="col-sm-3 control-label">Fecha del juego:</label>
		<div class="col-sm-9">
			<form:input path="date" cssClass="form-control" maxlength="20" />
			<form:errors path="date" />
		</div>
	</div>
	<div class="form-group">
		<label for="time" class="col-sm-3 control-label">Hora del juego:</label>
		<div class="col-sm-9">
			<form:select path="time" cssClass="form-control">
				<form:option value="0" label="Opciones" />
				<form:options items="${time}" />
			</form:select>
			<form:errors path="time" />
		</div>
	</div>
	<div class="form-group">
		<label for="type" class="col-sm-3 control-label">Estatus:</label>
		<div class="col-sm-9">
			<form:select path="status" cssClass="form-control">
				<form:option value="0" label="Opciones" />
				<form:options items="${status}" />
			</form:select>
			<form:errors path="status" />
		</div>
	</div>
	<div class="form-group" align="center">
		<br />
		<input type="submit" value="Actualizar" class="btn btn-success btnRedirect">
		<br />
		<br />
	</div>
</form:form>

<script type="text/javascript">
	$(document).ready(function() {
		$.datepicker.regional['es'] = {
			monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
			monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
			dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
			dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
			dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
			weekHeader: 'Sm',
			dateFormat: 'yy/mm/dd'
		};
		
		$.datepicker.setDefaults($.datepicker.regional['es']);
		$("#date").datepicker();
		
		$(".matchForm").validate(
				{
					rules: {
						teamLocalName: {
							required: true,
							minlength: 1
						},
						goalsLocal: {
							required: true,
							number: true
						},
						teamVisitorName: {
							required: true,
							minlength: 1
						},
						goalsVisitor: {
							required: true,
							number: true
						},
						date: {
							required: true,
							date: true
						},
						time: {
							validSelect: true
						},
						status: {
							validSelect: true
						}
					},
					highlight: function(element){
						$(element).closest(".form-group").removeClass("has-success").addClass("has-error");
					},
					unhighlight: function(element){
						$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
					},
					messages: {
						teamLocalName: "El nombre debe tener al menos 1 caracterer",
						goalsLocal: {
							required: "Campo faltante",
							number: "Ingresa solo números"
						},
						teamVisitorName: "El nombre debe tener al menos 1 caracterer",
						goalsVisitor: {
							required: "Campo faltante",
							number: "Ingresa solo números"
						},
						date: {
							required: "Campo faltante",
							date: "Ingresa una fecha válida: yyyy/mm/dd"
						},
						time: {
							required: "Campo faltante"
						}
					}
				}
		);
		
		jQuery.validator.addMethod('validSelect', function (value) {
			return (value != '0');
	    }, "Opción invalida");
	});
</script>