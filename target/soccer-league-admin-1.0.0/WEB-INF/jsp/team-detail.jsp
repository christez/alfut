<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">${team.name}</h1>

<hr />

<a href='<spring:url value="/team-admin.html" />' class="btn btn-lg btn-info" data-toggle="modal">Volver a "Equipos"</a>

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
		<label for="goalsFavor" class="col-sm-3 control-label">Goles a favor:</label>
		<div class="col-sm-9">
			<form:input path="goalsFavor" cssClass="form-control control-goals-favor" maxlength="5" />
			<form:errors path="goalsFavor" />
		</div>
	</div>
	<div class="form-group">
		<label for="goalsAgainst" class="col-sm-3 control-label">Goles en contra:</label>
		<div class="col-sm-9">
			<form:input path="goalsAgainst" cssClass="form-control control-goals-against" maxlength="5" />
			<form:errors path="goalsAgainst" />
		</div>
	</div>
	<div class="form-group">
		<label for="goalsDifference" class="col-sm-3 control-label">Goles de diferencia:</label>
		<div class="col-sm-9">
			<form:input path="goalsDifference" cssClass="form-control control-goals-against" maxlength="5" />
			<form:errors path="goalsDifference" />
		</div>
	</div>
	<div class="form-group">
		<label for="points" class="col-sm-3 control-label">Puntos:</label>
		<div class="col-sm-9">
			<form:input path="points" cssClass="form-control control-points" maxlength="5" />
			<form:errors path="points" />
		</div>
	</div>
	<div class="form-group" align="center">
		<input type="submit" value="Actualizar" class="btn btn-lg btn-primary">
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
						goalsFavor: {
							required: true,
							number: true
						},
						goalsAgainst: {
							required: true,
							number: true
						},
						goalsDifference: {
							required: true,
							number: true
						},
						points: {
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
						goalsFavor: {
							required: "Campo faltante",
							number: "Ingresa solo números"
						},
						goalsAgainst: {
							required: "Campo faltante",
							number: "Ingresa solo números"
						},
						goalsDifference: {
							required: "Campo faltante",
							number: "Ingresa solo números"
						},
						points: {
							required: "Campo faltante",
							number: "Ingresa solo números"
						}
					}
				}
		);
	});
</script>