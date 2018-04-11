<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Equipo <span class="orangeColor"><c:out value="${team.name}" /></span></h1>

<hr />

<a href='<spring:url value="/world-league-table.html" />' class="btn btn-lg btnAdministrationPrimary" data-toggle="modal">Volver a "Tablas"</a>

<hr />

<form:form commandName="team" cssClass="form-horizontal teamForm">
	<c:if test="${success eq true}">
		<div class="alert alert-success alert-dismissable">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
		    <strong>Acción completada.</strong> <c:out value="${message}"/>
		</div>
	</c:if>

	<h2 class="form-team-update-heading">Información del equipo</h2>
	<div class="form-group">
		<label for="name" class="col-sm-3 control-label">Nombre:</label>
		<div class="col-sm-9">
			<form:input path="name" cssClass="form-control control-name" maxlength="50"/>
			<form:errors path="name" />
		</div>
	</div>
	<div class="form-group">
		<label for="gamesPlayed" class="col-sm-3 control-label">Juegos jugados:</label>
		<div class="col-sm-9">
			<form:input path="gamesPlayed" cssClass="form-control control-games-played" maxlength="5" />
			<form:errors path="gamesPlayed" />
		</div>
	</div>
	<div class="form-group">
		<label for="gamesWon" class="col-sm-3 control-label">Juegos ganados:</label>
		<div class="col-sm-9">
			<form:input path="gamesWon" cssClass="form-control control-games-won" maxlength="5" />
			<form:errors path="gamesWon" />
		</div>
	</div>
	<div class="form-group">
		<label for="gamesDrawed" class="col-sm-3 control-label">Juegos empatados:</label>
		<div class="col-sm-9">
			<form:input path="gamesDrawed" cssClass="form-control control-games-drawed" maxlength="5" />
			<form:errors path="gamesDrawed" />
		</div>
	</div>
	<div class="form-group">
		<label for="gamesLost" class="col-sm-3 control-label">Juegos perdidos:</label>
		<div class="col-sm-9">
			<form:input path="gamesLost" cssClass="form-control control-games-lost" maxlength="5" />
			<form:errors path="gamesLost" />
		</div>
	</div>
	<div class="form-group">
		<label for="goals" class="col-sm-3 control-label">Goles:</label>
		<div class="col-sm-9">
			<form:input path="goals" cssClass="form-control control-goals-favor" maxlength="5" />
			<form:errors path="goals" />
		</div>
	</div>
	<div class="form-group">
		<label for="points" class="col-sm-3 control-label">Puntos:</label>
		<div class="col-sm-9">
			<form:input path="points" cssClass="form-control control-points" maxlength="5" />
			<form:errors path="points" />
		</div>
	</div>
	<div class="form-group">
		<label for="position" class="col-sm-3 control-label">Posición:</label>
		<div class="col-sm-9">
			<form:input path="position" cssClass="form-control control-points" maxlength="5" />
			<form:errors path="position" />
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
		$(".teamForm").validate(
				{
					rules: {
						name: {
							required: true,
							minlength: 1
						},
						gamesPlayed: {
							required: true,
							number: true
						},
						gamesWon: {
							required: true,
							number: true
						},
						gamesDrawed: {
							required: true,
							number: true
						},
						gamesLost: {
							required: true,
							number: true
						},
						goals: {
							required: true
						},
						points: {
							required: true,
							number: true
						},
						position: {
							required: true,
							number: true
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
						gamesPlayed: {
							required: "Campo faltante",
							number: "Ingresa solo números"
						},
						gamesWon: {
							required: "Campo faltante",
							number: "Ingresa solo números"
						},
						gamesDrawed: {
							required: "Campo faltante",
							number: "Ingresa solo números"
						},
						gamesLost: {
							required: "Campo faltante",
							number: "Ingresa solo números"
						},
						goals: {
							required: "Campo faltante"
						},
						points: {
							required: "Campo faltante",
							number: "Ingresa solo números"
						},
						position: {
							required: "Campo faltante",
							number: "Ingresa solo números"
						}
					}
				}
		);
	});
</script>