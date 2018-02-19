<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">${cluster.name}</h1>

<hr />

<a href='<spring:url value="/cluster-admin.html" />' class="btn btn-lg btn-info" data-toggle="modal">Volver a "Grupos"</a>

<c:if test="${cluster.tournament.status eq 'Configuración'}">
	<a href="#pointsModal" class="btn btn-lg btn-primary" data-toggle="modal">Crear equipo</a>
</c:if>

<form:form commandName="team" cssClass="form-horizontal teamForm">
	<div id="pointsModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Nuevo equipo</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-3 control-label">Nombre:</label>
						<div class="col-sm-9">
							<form:input path="name" cssClass="form-control" maxlength="50" />
							<form:errors path="name" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					<input type="submit" class="btn btn-primary" value="Crear">
				</div>
			</div>
		</div>
	</div>
</form:form>

<hr />

<c:if test="${success eq true}">
	<div class="alert alert-success alert-dismissable">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
	    <strong>Acción completada.</strong> <c:out value="${message}"/>
	</div>
</c:if>

<c:choose>
	<c:when test="${empty(cluster.teams)}">
		<div class="alert alert-warning">
			<strong>No cuentas con ningún equipo creado. Da click en el botón "Crear equipo" para iniciar</strong>
		</div>
		<div align="center">
			<img alt="warningIcon" src='<c:url value="/resources/images/warningIcon.png"/>'>
		</div>
	</c:when>
	<c:otherwise>
		<div class="table-responsive">
			<table class="table table-bordered table-xs table-condensed teamTable">
				<thead class="teamTableHeader">
					<tr>
						<th>Posición</th>
						<th>Nombre</th>
						<th>Juegos jugados</th>
						<th>Juegos ganados</th>
						<th>Juegos empatados</th>
						<th>Juegos perdidos</th>
						<th>Goles a favor</th>
						<th>Goles en contra</th>
						<th>Diferencia de goles</th>
						<th>Puntos</th>
						<th>Actualizar</th>
						<th>Borrar</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="positionCounter" scope="session" value="${1}"/>
					
					<c:forEach items="${cluster.teams}" var="team">
						<tr class="teamTableHover">
							<td class="teamTableBolder">
								<c:out value="${positionCounter}" />
							</td>
							<td class="teamTableBolder">
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
								<c:out value="${team.goalsFavor}" />
							</td>
							<td>
								<c:out value="${team.goalsAgainst}" />
							</td>
							<td>
								<c:out value="${team.goalsDifference}" />
							</td>
							<td>
								<c:out value="${team.points}" />
							</td>
							<td>
								<a href='<spring:url value="/cluster-team-detail.html?rpTeamId=${team.id}" />' class="btn btn-info btn-xs">Actualizar</a>
							</td>
							<td>
								<c:choose>
									<c:when test="${cluster.tournament.status eq 'Configuración'}">
										<a href='<spring:url value="/cluster-detail/remove/${team.id}.html" />' class="btn btn-danger btn-xs triggerRemoveTeam">Eliminar</a>
									</c:when>
									<c:otherwise>
										<a class="btn btn-danger btn-xs disabled">Eliminar</a>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						
						<c:set var="positionCounter" scope="session" value="${positionCounter + 1}"/>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:otherwise>
</c:choose>

<div id="modalRemoveTeam" class="modal fade modalRemove">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Confirmar acción</h4>
			</div>
			<div class="modal-body">
				¿Seguro que deseas eliminar el equipo?
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
		$('.triggerRemoveTeam').click(function(e){
			e.preventDefault();
			
			$('#modalRemoveTeam .removeBtn').attr('href', $(this).attr('href'));
			
			$('#modalRemoveTeam').modal();
		});
		
		$(".teamForm").validate(
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

