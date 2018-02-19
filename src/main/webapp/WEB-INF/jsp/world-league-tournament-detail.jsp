<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">${match.schedule.name}</h1>

<hr />

<a href='<spring:url value="/world-league-tournament.html" />' class="btn btn-lg btn-info" data-toggle="modal">Volver a "Jornadas"</a>

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
		<label for="localGoals" class="col-sm-3 control-label">Goles del equipo local:</label>
		<div class="col-sm-9">
			<form:input path="localGoals" cssClass="form-control" maxlength="5" />
			<form:errors path="localGoals" />
		</div>
	</div>
	<div class="form-group">
		<label for="localName" class="col-sm-3 control-label">Equipo local:</label>
		<div class="col-sm-9">
			<form:input path="localName" cssClass="form-control" maxlength="50"/>
			<form:errors path="localName" />
		</div>
	</div>
	<div class="form-group">
		<label for="visitorName" class="col-sm-3 control-label">Equipo visitante:</label>
		<div class="col-sm-9">
			<form:input path="visitorName" cssClass="form-control" maxlength="50"/>
			<form:errors path="visitorName" />
		</div>
	</div>
	<div class="form-group">
		<label for="visitorGoals" class="col-sm-3 control-label">Goles del equipo local:</label>
		<div class="col-sm-9">
			<form:input path="visitorGoals" cssClass="form-control" maxlength="5" />
			<form:errors path="visitorGoals" />
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
			<form:input path="time" cssClass="form-control" maxlength="20" />
			<form:errors path="time" />
		</div>
	</div>
	<div class="form-group" align="center">
		<input type="submit" value="Actualizar" class="btn btn-lg btn-primary">
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
		
		$(".matchForm").validate({
				rules: {
					localGoals: {
						required: true
					},
					localName: {
						required: true
					},
					visitorGoals: {
						required: true
					},
					visitorName: {
						required: true
					},
					date: {
						required: true,
						date: true
					},
					time: {
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
					localGoals: {
						required: "Campo faltante"
					},
					localName: {
						required: "El nombre debe tener al menos 1 caracterer"
					},
					visitorGoals: {
						required: "Campo faltante"
					},
					visitorName: {
						required: "El nombre debe tener al menos 1 caracterer"
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
	});
</script>