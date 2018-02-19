<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Jornadas de "${tournament.name}"</h1>

<hr />

<a href='<spring:url value="/tournament-admin.html" />' class="btn btn-lg btn-info" data-toggle="modal">Volver a "Torneos"</a>

<c:if test="${tournament.type eq 'Por puntos'}">
	<c:if test="${tournament.scheduleGenerated eq false}">
		<a href="#pointsModal" class="btn btn-lg btn-primary" data-toggle="modal">Generar enfrentamientos</a>
		
		<form:form commandName="tournament" cssClass="form-horizontal tournamentForm tournamentFormPoints">
			<div id="pointsModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">Generar enfrentamientos por puntos</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label for="schema" class="col-sm-3 control-label">Esquema:</label>
								<div class="col-sm-9">
									<form:select path="schema" cssClass="form-control">
										<form:option value="0" label="Opciones" />
										<form:options items="${schema}" />
									</form:select>
									<form:errors path="schema" />
								</div>
							</div>
							<div class="alert alert-warning scheduleWarningNote" align="center">
								<strong>Una vez generados los enfrentamientos, no podrán realizarse modificaciones</strong>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
							<input type="submit" class="btn btn-primary" value="Generar" name="points">
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</c:if>
</c:if>

<c:if test="${tournament.type eq 'Por puntos más liguilla'}">
	<c:if test="${tournament.scheduleGenerated eq false}">
		<a href="#pointsPlayoffsModal" class="btn btn-lg btn-primary" data-toggle="modal">Generar enfrentamientos</a>
		
		<form:form commandName="tournament" cssClass="form-horizontal tournamentForm tournamentFormPointsPlayoffs">
			<div id="pointsPlayoffsModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">Generar enfrentamientos por puntos más liguilla</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label for="schema" class="col-sm-3 control-label">Esquema:</label>
								<div class="col-sm-9">
									<form:select path="schema" cssClass="form-control">
										<form:option value="0" label="Opciones" />
										<form:options items="${schema}" />
									</form:select>
									<form:errors path="schema" />
								</div>
							</div>
							<div class="form-group">
								<label for="numberClassified" class="col-sm-3 control-label">Número de clasificados:</label>
								<div class="col-sm-9">
									<form:select path="numberClassified" cssClass="form-control">
										<form:option value="0" label="Opciones" />
										<form:options items="${numberClassified}" />
									</form:select>
									<form:errors path="numberClassified" />
								</div>
							</div>
							<div class="alert alert-warning scheduleWarningNote" align="center">
								<strong>Una vez generados los enfrentamientos, no podrán realizarse modificaciones</strong>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
							<input type="submit" class="btn btn-primary" value="Generar" name="pointsPlayoffs">
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</c:if>
</c:if>

<c:if test="${tournament.type eq 'Por grupos más liguilla'}">
	<c:if test="${tournament.scheduleGenerated eq false}">
		<a href="#groupsPlayoffsModal" class="btn btn-lg btn-primary" data-toggle="modal">Generar enfrentamientos</a>
		
		<form:form commandName="tournament" cssClass="form-horizontal tournamentForm tournamentFormGroupsPlayoffs">
			<div id="groupsPlayoffsModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">Generar enfrentamientos por grupos más liguilla</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label for="schema" class="col-sm-3 control-label">Esquema:</label>
								<div class="col-sm-9">
									<form:select path="schema" cssClass="form-control">
										<form:option value="0" label="Opciones" />
										<form:options items="${schema}" />
									</form:select>
									<form:errors path="schema" />
								</div>
							</div>
							<div class="form-group">
								<label for="selection" class="col-sm-3 control-label">Reglas de clasificación:</label>
								<div class="col-sm-9">
									<form:select path="selection" cssClass="form-control">
										<form:option value="0" label="Opciones" />
										<form:options items="${selection}" />
									</form:select>
									<form:errors path="selection" />
								</div>
							</div>
							<div class="alert alert-warning scheduleWarningNote" align="center">
								<strong>Una vez generados los enfrentamientos, no podrán realizarse modificaciones</strong>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
							<input type="submit" class="btn btn-primary" value="Generar" name="groupsPlayoffs">
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</c:if>
</c:if>

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

<div class="row">
	<c:if test="${tournament.type eq 'Por puntos' or tournament.type eq 'Por puntos más liguilla'}">
		<c:choose>
			<c:when test="${empty(tournament.schedules)}">
				<div class="alert alert-warning">
					<strong>No se ha generado el rol de juegos. Da click en el botón "Generar enfrentamientos" para iniciar</strong>
				</div>
				<div align="center">
					<img alt="warningIcon" src='<c:url value="/resources/images/warningIcon.png"/>'>
				</div>
			</c:when>
			<c:otherwise>
				<div class="col-md-12">
					<div class="panel-group" id="accordion">
						<c:set var="scheduleCounter" scope="session" value="${1}"/>
						
						<c:forEach items="${tournament.schedules}" var="schedule">
						    <div class="panel panel-default" style="border: 4px solid rgba(193, 222, 226, 0.25); box-shadow: 3px 3px 3px 3px #417d95; margin-bottom: 15px;">
						        <div class="panel-heading" style="background-color: #dde7dc;">
						            <h4 class="panel-title">
						                <a data-toggle="collapse" data-parent="#accordion" href="#collapse_<c:out value="${schedule.id}"/>" class="btn btn-sm btn-info leagueNameLink">Jornada <c:out value="${scheduleCounter}"/></a>
						                <span class="scheduleHighlightProgrammed">Número de juegos programados: <c:out value="${schedule.gamesProgrammed}"/></span>
						                <span class="scheduleHighlightPlayed">Número de juegos jugados: <c:out value="${schedule.gamesPlayed}"/></span>
						            </h4>
						        </div>
						        <div id="collapse_<c:out value="${schedule.id}"/>" class="panel-collapse collapse">
						            <div class="panel-body">
						            	<div class="col-md-4">
						            		<div class="alert alert-success scheduleDetail">
												Equipo descanzado: <strong><c:out value="${schedule.restingTeam}"/></strong>
											</div>
						            	</div>
						            	<div class="col-md-8">
						            	</div>						            	
						            	<div class="col-md-12">
							            	<div class="table-responsive">
												<table class="table table-bordered table-xs table-condensed scheduleTable">
													<thead class="scheduleTableHeader">
														<tr>
															<th>Goles</th>
															<th>Local</th>
															<th>VS</th>
															<th>Visitante</th>
															<th>Goles</th>
															<th>Fecha</th>
															<th>Hora</th>
															<th>Estatus</th>
															<th>Modificar</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${schedule.matches}" var="match">
															<tr class="scheduleTableHover">
																<td>
																	<c:out value="${match.goalsLocal}" />
																</td>
																<td>
																	<c:out value="${match.teamLocalName}" />
																</td>
																<td>
																	-
																</td>
																<td>
																	<c:out value="${match.teamVisitorName}" />
																</td>
																<td>
																	<c:out value="${match.goalsVisitor}" />
																</td>
																<td>
																	<c:out value="${match.date}" />
																</td>
																<td>
																	<c:out value="${match.time}" />
																</td>
																<td>
																	<c:out value="${match.status}" />
																</td>
																<td>
																	<c:choose>
																		<c:when test="${match.status eq 'No jugado'}">
																			<a href='<spring:url value="/schedule-detail.html?rpMatchId=${match.id}&rpScheduleNumber=${scheduleCounter}" />' class="btn btn-info btn-xs">Modificar</a>
																		</c:when>
																		<c:otherwise>
																			<a class="btn btn-info btn-xs disabled">Modificar</a>
																		</c:otherwise>
																	</c:choose>
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
						            </div>
						        </div>
						    </div>
						    
						    <c:set var="scheduleCounter" scope="session" value="${scheduleCounter + 1}"/>
					    </c:forEach>
					    
					    <c:if test="${tournament.type eq 'Por puntos más liguilla'}">
							<c:set var="playoffCounter" scope="session" value="${1}"/>
									
							<c:forEach items="${tournament.playoffs}" var="playoff">
							    <div class="panel panel-default" style="border: 4px solid rgba(193, 222, 226, 0.25); box-shadow: 3px 3px 3px 3px #417d95; margin-bottom: 15px;">
							        <div class="panel-heading" style="background-color: #dde7dc;">
							            <h4 class="panel-title">
							                <a data-toggle="collapse" data-parent="#accordion" href="#playoff_<c:out value="${playoff.id}"/>" class="btn btn-sm btn-info leagueNameLink">Jornada de eliminación <c:out value="${playoffCounter}"/></a>
							                <span class="scheduleHighlightProgrammed">Número de juegos programados: <c:out value="${playoff.gamesProgrammed}"/></span>
							                <span class="scheduleHighlightPlayed">Número de juegos jugados: <c:out value="${playoff.gamesPlayed}"/></span>
							            </h4>
							        </div>
							        <div id="playoff_<c:out value="${playoff.id}"/>" class="panel-collapse collapse">
							            <div class="panel-body">
							            	<div class="col-md-12">
								            	<div class="table-responsive">
													<table class="table table-bordered table-xs table-condensed scheduleTable">
														<thead class="scheduleTableHeader">
															<tr>
																<th>Goles</th>
																<th>Local</th>
																<th>VS</th>
																<th>Visitante</th>
																<th>Goles</th>
																<th>Fecha</th>
																<th>Hora</th>
																<th>Estatus</th>
																<th>Modificar</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${playoff.matches}" var="match">
																<tr class="scheduleTableHover">
																	<td>
																		<c:out value="${match.goalsLocal}" />
																	</td>
																	<td>
																		<c:out value="${match.teamLocalName}" />
																	</td>
																	<td>
																		-
																	</td>
																	<td>
																		<c:out value="${match.teamVisitorName}" />
																	</td>
																	<td>
																		<c:out value="${match.goalsVisitor}" />
																	</td>
																	<td>
																		<c:out value="${match.date}" />
																	</td>
																	<td>
																		<c:out value="${match.time}" />
																	</td>
																	<td>
																		<c:out value="${match.status}" />
																	</td>
																	<td>
																		<c:choose>
																			<c:when test="${tournament.gamesProgrammed eq tournament.gamesPlayed and playoff.status eq 'Programado' and match.status eq 'No jugado'}">
																				<a href='<spring:url value="/schedule-detail.html?rpMatchId=${match.id}&rpScheduleNumber=${playoffCounter}" />' class="btn btn-info btn-xs">Modificar</a>
																			</c:when>
																			<c:otherwise>
																				<a class="btn btn-info btn-xs disabled">Modificar</a>
																			</c:otherwise>
																		</c:choose>
																	</td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
							            </div>
							        </div>
							    </div>
							    
							    <c:set var="playoffCounter" scope="session" value="${playoffCounter + 1}"/>
						    </c:forEach>
						</c:if>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>

<div class="row">
	<c:if test="${tournament.type eq 'Por grupos más liguilla'}">
		<c:choose>
			<c:when test="${empty(tournament.playoffs)}">
				<div class="alert alert-warning">
					<strong>No se ha generado el rol de juegos. Da click en el botón "Generar enfrentamientos" para iniciar</strong>
				</div>
				<div align="center">
					<img alt="warningIcon" src='<c:url value="/resources/images/warningIcon.png"/>'>
				</div>
			</c:when>
			<c:otherwise>
				<div class="col-md-12">
					<div class="panel-group" id="accordion">
						<c:forEach items="${tournament.clusters}" var="cluster">
						    <div class="panel panel-default" style="border: 4px solid rgba(193, 222, 226, 0.25); box-shadow: 3px 3px 3px 3px #417d95; margin-bottom: 15px;">
						        <div class="panel-heading" style="background-color: #dde7dc;">
						            <h4 class="panel-title">
						                <a data-toggle="collapse" data-parent="#accordion" href="#collapse_<c:out value="${cluster.id}"/>" class="btn btn-sm btn-info leagueNameLink"><c:out value="${cluster.name}"/></a>
						            </h4>
						        </div>
						        <div id="collapse_<c:out value="${cluster.id}"/>" class="panel-collapse collapse">
						            <div class="panel-body">
						            	<c:set var="scheduleCounter" scope="session" value="${1}"/>
						            	
						            	<c:forEach items="${cluster.schedules}" var="schedule">
						            		<div class="col-md-12">
						            			<h1 class="clusterScheduleHeader">Jornada <c:out value="${scheduleCounter}"/></h1>
						            			<p class="scheduleHighlightProgrammed">Número de juegos programados: <c:out value="${schedule.gamesProgrammed}"/></p>
							                	<p class="scheduleHighlightPlayed">Número de juegos jugados: <c:out value="${schedule.gamesPlayed}"/></p>
						            		</div>
						            		<div class="col-md-4">
							            		<div class="alert alert-success scheduleDetail">
													Equipo descanzado: <strong><c:out value="${schedule.restingTeam}"/></strong>
												</div>
							            	</div>
							            	<div class="col-md-8">
							            	</div>
							            	<div class="col-md-12">
								            	<div class="table-responsive">
													<table class="table table-bordered table-xs table-condensed scheduleTable">
														<thead class="scheduleTableHeader">
															<tr>
																<th>Goles</th>
																<th>Local</th>
																<th>VS</th>
																<th>Visitante</th>
																<th>Goles</th>
																<th>Fecha</th>
																<th>Hora</th>
																<th>Estatus</th>
																<th>Modificar</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${schedule.matches}" var="match">
																<tr class="scheduleTableHover">
																	<td>
																		<c:out value="${match.goalsLocal}" />
																	</td>
																	<td>
																		<c:out value="${match.teamLocalName}" />
																	</td>
																	<td>
																		-
																	</td>
																	<td>
																		<c:out value="${match.teamVisitorName}" />
																	</td>
																	<td>
																		<c:out value="${match.goalsVisitor}" />
																	</td>
																	<td>
																		<c:out value="${match.date}" />
																	</td>
																	<td>
																		<c:out value="${match.time}" />
																	</td>
																	<td>
																		<c:out value="${match.status}" />
																	</td>
																	<td>
																		<c:choose>
																			<c:when test="${match.status eq 'No jugado'}">
																				<a href='<spring:url value="/schedule-detail.html?rpMatchId=${match.id}&rpScheduleNumber=${scheduleCounter}" />' class="btn btn-info btn-xs">Modificar</a>
																			</c:when>
																			<c:otherwise>
																				<a class="btn btn-info btn-xs disabled">Modificar</a>
																			</c:otherwise>
																		</c:choose>
																	</td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
											
											<div class="row">
												<div class="col-md-12">
													<hr class="clusterScheduleDivider">
												</div>
											</div>
											
											<c:set var="scheduleCounter" scope="session" value="${scheduleCounter + 1}"/>
						            	</c:forEach>
						            </div>
						        </div>
						    </div>
					    </c:forEach>
					    
					    <c:set var="playoffCounter" scope="session" value="${1}"/>
									
						<c:forEach items="${tournament.playoffs}" var="playoff">
						    <div class="panel panel-default" style="border: 4px solid rgba(193, 222, 226, 0.25); box-shadow: 3px 3px 3px 3px #417d95; margin-bottom: 15px;">
						        <div class="panel-heading" style="background-color: #dde7dc;">
						            <h4 class="panel-title">
						                <a data-toggle="collapse" data-parent="#accordion" href="#playoff_<c:out value="${playoff.id}"/>" class="btn btn-sm btn-info leagueNameLink">Jornada de eliminación <c:out value="${playoffCounter}"/></a>
						                <span class="scheduleHighlightProgrammed">Número de juegos programados: <c:out value="${playoff.gamesProgrammed}"/></span>
						                <span class="scheduleHighlightPlayed">Número de juegos jugados: <c:out value="${playoff.gamesPlayed}"/></span>
						            </h4>
						        </div>
						        <div id="playoff_<c:out value="${playoff.id}"/>" class="panel-collapse collapse">
						            <div class="panel-body">
						            	<div class="col-md-12">
							            	<div class="table-responsive">
												<table class="table table-bordered table-xs table-condensed scheduleTable">
													<thead class="scheduleTableHeader">
														<tr>
															<th>Goles</th>
															<th>Local</th>
															<th>VS</th>
															<th>Visitante</th>
															<th>Goles</th>
															<th>Fecha</th>
															<th>Hora</th>
															<th>Estatus</th>
															<th>Modificar</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${playoff.matches}" var="match">
															<tr class="scheduleTableHover">
																<td>
																	<c:out value="${match.goalsLocal}" />
																</td>
																<td>
																	<c:out value="${match.teamLocalName}" />
																</td>
																<td>
																	-
																</td>
																<td>
																	<c:out value="${match.teamVisitorName}" />
																</td>
																<td>
																	<c:out value="${match.goalsVisitor}" />
																</td>
																<td>
																	<c:out value="${match.date}" />
																</td>
																<td>
																	<c:out value="${match.time}" />
																</td>
																<td>
																	<c:out value="${match.status}" />
																</td>
																<td>
																	<c:choose>
																		<c:when test="${tournament.gamesProgrammed eq tournament.gamesPlayed and playoff.status eq 'Programado' and match.status eq 'No jugado'}">
																			<a href='<spring:url value="/schedule-detail.html?rpMatchId=${match.id}&rpScheduleNumber=${playoffCounter}" />' class="btn btn-info btn-xs">Modificar</a>
																		</c:when>
																		<c:otherwise>
																			<a class="btn btn-info btn-xs disabled">Modificar</a>
																		</c:otherwise>
																	</c:choose>
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
						            </div>
						        </div>
						    </div>
						    
						    <c:set var="playoffCounter" scope="session" value="${playoffCounter + 1}"/>
					    </c:forEach>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
</div>

<div id="modalConclude" class="modal fade modalConclude">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Confirmar acción</h4>
			</div>
			<div class="modal-body">
				¿Seguro que deseas concluir la jornada?
				<div class="alert alert-warning scheduleWarningNote" align="center">
					<strong>Una vez concluida, no podrán realizarse modificaciones</strong>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				<a href="" class="btn btn-warning concludeBtn">Concluir</a>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('.triggerConclude').click(function(e){
			e.preventDefault();
			
			$('#modalConclude .concludeBtn').attr('href', $(this).attr('href'));
			
			$('#modalConclude').modal();;
		});
		
		$(".tournamentFormPoints").validate(
				{
					rules: {
						schema: {
							validSelect: true
						}
					},
					highlight: function(element){
						$(element).closest(".form-group").removeClass("has-success").addClass("has-error");
					},
					unhighlight: function(element){
						$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
					}
				}
		);
		
		$(".tournamentFormPointsPlayoffs").validate(
				{
					rules: {
						schema: {
							validSelect: true
						},
						numberClassified: {
							validSelect: true
						}
					},
					highlight: function(element){
						$(element).closest(".form-group").removeClass("has-success").addClass("has-error");
					},
					unhighlight: function(element){
						$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
					}
				}
		);
		
		$(".tournamentFormGroupsPlayoffs").validate(
				{
					rules: {
						schema: {
							validSelect: true
						},
						selection: {
							validSelect: true
						},
						numberClassified: {
							validSelect: true
						}
					},
					highlight: function(element){
						$(element).closest(".form-group").removeClass("has-success").addClass("has-error");
					},
					unhighlight: function(element){
						$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
					}
				}
		);
		
		jQuery.validator.addMethod('validSelect', function (value) {
			return (value != '0');
	    }, "Opción invalida");
	});
	
	$('[data-toggle="popover"]').popover(); 
</script>