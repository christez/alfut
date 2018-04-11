<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Torneo <span class="orangeColor"><c:out value="${tournament.name}" /></span></h1>

<hr />

<a href='<spring:url value="/world-league-detail.html" />' class="btn btn-lg btn-info" data-toggle="modal">Volver a "Torneo"</a>
<a href="#myModal" class="btn btn-lg btnAdministrationPrimary" data-toggle="modal">Crear tabla</a>

<hr />

<form:form commandName="ranking" cssClass="form-horizontal rankingForm">
	<div id="myModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Crear tabla</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Nombre:</label>
						<div class="col-sm-10">
							<form:input path="name" cssClass="form-control" maxlength="50"/>
							<form:errors path="name"/>
						</div>
					</div>
					<div class="form-group">
						<label for="textForTeams" class="col-sm-2 control-label">Equipos:</label>
						<div class="col-sm-10">
							<form:textarea path="textForTeams" cssClass="form-control" maxlength="1024" />
							<form:errors path="textForTeams"/>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					<input type="submit" class="btn btnAdministrationPrimary" value="Crear">
				</div>
			</div>
		</div>
	</div>
</form:form>

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

<c:choose>
	<c:when test="${empty(tournament.rankings)}">
		<div class="emptyDiv" align="center">
			<strong>No existe ninguna tabla creada.</strong><br />Da click en el botón "Crear jornada" para iniciar
		</div>
	</c:when>
	<c:otherwise>
		<c:forEach items="${tournament.rankings}" var="ranking">
			<h3 class="worldScheduleHeader"><c:out value="${ranking.name}" /></h3>
			<a href='<spring:url value="/world-league-table/remove/${ranking.id}.html" />' class="btn btn-danger btn-xs triggerRemove worldMatchButtonRemove">Eliminar</a>
			
			<div class="table-responsive">
				<table class="table table-bordered table-xs table-condensed teamTable">
					<thead class="teamTableHeader">
						<tr>
							<th>Posición</th>
							<th>Equipo</th>
							<th>Juegos jugados</th>
							<th>Ganados</th>
							<th>Empatados</th>
							<th>Perdidos</th>
							<th>GF:GC</th>
							<th>Puntos</th>
							<th>Modificar</th>
							<th>Eliminar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ranking.teams}" var="team">
							<tr class="teamTableHover">
								<td>
									<c:out value="${team.position}" />
								</td>
								<td>
									<c:out value="${team.name}" />
								</td>
								<td>
									<c:out value="${team.gamesPlayed}" />
								</td>
								<td>
									<c:out value="${team.gamesWon}" />
								</td>
								<td>
									<c:out value="${team.gamesDrawed}" />
								</td>
								<td>
									<c:out value="${team.gamesLost}" />
								</td>
								<td>
									<c:out value="${team.goals}" />
								</td>
								<td>
									<c:out value="${team.points}" />
								</td>
								<td>
									<a href='<spring:url value="/world-league-table-detail.html?rpTeamId=${team.id}" />' class="btn btn-info btn-xs">Modificar</a>
								</td>
								<td>
									<a href='<spring:url value="/world-league-table/remove/team/${team.id}.html" />' class="btn btn-danger btn-xs triggerRemove">Eliminar</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:forEach>
	</c:otherwise>
</c:choose>

<div id="modalRemove" class="modal fade modalRemove">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Confirmar acción</h4>
			</div>
			<div class="modal-body">
				¿Seguro que deseas eliminar el registro?
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				<a href="" class="btn btn-danger removeBtn">Eliminar</a>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('.triggerRemove').click(function(e){
			e.preventDefault();
			
			$('#modalRemove .removeBtn').attr('href', $(this).attr('href'));
			
			$('#modalRemove').modal();
		});
		
		$(".rankingForm").validate({
				rules: {
					name: {
						required: true,
						minlength: 1
					},
					textForTeams: {
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
					name: "El nombre debe tener al menos 1 caracterer",
					textForTeams: "Los equipos deben tener al menos un caracter"
				}
			}
		);
	});
</script>