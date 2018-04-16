<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<div align="center">
	<h1 class="mainHeader">LIGAS DEL MUNDO</h1>
</div>

<c:choose>
	<c:when test="${empty(leagues)}">
		<div class="emptyDiv" align="center">
			<strong>Sitio en construcción.</strong><br />En breve estará listo
		</div>
	</c:when>
	<c:otherwise>
		<div class="row">
			<div class="col-md-2 openWorldLeagueMenu">
				<c:forEach items="${leagues}" var="league">
					<img alt="flag" src='<c:url value="${league.flagUrl}"/>' class="openWorldLeagueFlag">
					<a href='<spring:url value="/open-world-league.html?rpLeagueId=${league.id}" />' class="openWorldLeagueLink"><c:out value="${league.name}" /></a>
					<br />
				</c:forEach>
			</div>			
			<div class="col-md-10 openWorldLeagueDisplay">
				<c:choose>
					<c:when test="${welcomePage eq true}">
						<div align="center">
							<img alt="pickLeague" src='<c:url value="/resources/images/leagueBundesliga.png"/>' class="openWorldLeagueImages">
							<img alt="pickLeague" src='<c:url value="/resources/images/leagueEredivisie.png"/>' class="openWorldLeagueImages">
							<img alt="pickLeague" src='<c:url value="/resources/images/leagueLaLiga.png"/>' class="openWorldLeagueImages">
							<img alt="pickLeague" src='<c:url value="/resources/images/leagueLaLigaPortugal.png"/>' class="openWorldLeagueImages">
							<img alt="pickLeague" src='<c:url value="/resources/images/leagueLeague1.png"/>' class="openWorldLeagueImages">
							<img alt="pickLeague" src='<c:url value="/resources/images/leagueMls.png"/>' class="openWorldLeagueImages">
							<img alt="pickLeague" src='<c:url value="/resources/images/leaguePremierLeague.png"/>' class="openWorldLeagueImages">
							<img alt="pickLeague" src='<c:url value="/resources/images/leagueSerieA.png"/>'>
						</div>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${empty(selectedLeague.tournaments)}">
								<div class="emptyDiv" align="center">
									<strong>Lo sentimos.</strong><br />No hay torneos recientes
								</div>
							</c:when>
							<c:otherwise>
								<div align="center">
									<h1 class="openWorldLeagueHeader"><c:out value="${selectedLeague.name}" /></h1>
								</div>
								<c:forEach items="${selectedLeague.tournaments}" var="tournament">
									<ul class="nav nav-tabs" role="tablist">
										<c:forEach items="${selectedLeague.tournaments}" var="tournament">
											<li role="presentation"><a href="#tournament_<c:out value="${tournament.id}"/>" aria-controls="tournament_<c:out value="${tournament.id}"/>" role="tab" data-toggle="tab"><c:out value="${tournament.name}"/></a></li>
										</c:forEach>
									</ul>
									<div class="tab-content">
										<c:forEach items="${selectedLeague.tournaments}" var="tournament">
											<div role="tabpanel" class="tab-pane" id="tournament_<c:out value="${tournament.id}"/>">
												<div class="row">
													<c:choose>
														<c:when test="${empty(tournament.rankings) and empty(tournament.schedules)}">
															<div class="alert alert-info">
																<strong>Sitio en construcción.</strong> En breve estará listo
															</div>			
															<div align="center">
																<img alt="bulding" src='<c:url value="/resources/images/building.gif"/>'>
															</div>
														</c:when>
														<c:otherwise>
															<c:choose>
																<c:when test="${not empty(tournament.rankings) and not empty(tournament.schedules)}">
																	<div class="col-md-6">
																		<c:forEach items="${tournament.rankings}" var="ranking">
																			<h3 class="worldScheduleHeader"><c:out value="${ranking.name}" /></h3>
																			<div class="table-responsive">
																				<table class="table table-bordered table-xs table-condensed teamTable miniTable">
																					<thead class="teamTableHeader">
																						<tr>
																							<th>#</th>
																							<th>Equipo</th>
																							<th>JJ</th>
																							<th>JG</th>
																							<th>JE</th>
																							<th>JP</th>
																							<th>GF:GC</th>
																							<th>Puntos</th>
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
																							</tr>
																						</c:forEach>
																					</tbody>
																				</table>
																			</div>
																		</c:forEach>
																	</div>
																	<div class="col-md-6">
																		<c:forEach items="${tournament.schedules}" var="schedule">
																			<h3 class="worldScheduleHeader"><c:out value="${schedule.name}" /></h3>
																			
																			<div class="table-responsive">
																				<table class="table table-bordered table-xs table-condensed teamTable miniTable">
																					<thead class="teamTableHeader">
																						<tr>
																							<th>Fecha</th>
																							<th>Hora</th>
																							<th>Local</th>
																							<th>Visitante</th>
																							<th>Resultado</th>
																						</tr>
																					</thead>
																					<tbody>
																						<c:forEach items="${schedule.matches}" var="match">
																							<tr class="teamTableHover">
																								<td>
																									<c:out value="${match.date}" />
																								</td>
																								<td>
																									<c:out value="${match.time}" />
																								</td>
																								<td>
																									<c:out value="${match.localName}" />
																								</td>
																								<td>
																									<c:out value="${match.visitorName}" />
																								</td>
																								<td>
																									<c:out value="${match.result}" />
																								</td>
																							</tr>
																						</c:forEach>
																					</tbody>
																				</table>
																			</div>
																		</c:forEach>
																	</div>
																</c:when>
																<c:otherwise>
																	<c:choose>
																		<c:when test="${empty(tournament.rankings)}">
																			<c:forEach items="${tournament.schedules}" var="schedule">
																				<h3 class="worldScheduleHeader"><c:out value="${schedule.name}" /></h3>
																				
																				<div class="table-responsive">
																					<table class="table table-bordered table-xs table-condensed teamTable">
																						<thead class="teamTableHeader">
																						<tr>
																							<th>Fecha</th>
																							<th>Hora</th>
																							<th>Local</th>
																							<th>Visitante</th>
																							<th>Resultado</th>
																						</tr>
																					</thead>
																					<tbody>
																						<c:forEach items="${schedule.matches}" var="match">
																							<tr class="teamTableHover">
																								<td>
																									<c:out value="${match.date}" />
																								</td>
																								<td>
																									<c:out value="${match.time}" />
																								</td>
																								<td>
																									<c:out value="${match.localName}" />
																								</td>
																								<td>
																									<c:out value="${match.visitorName}" />
																								</td>
																								<td>
																									<c:out value="${match.result}" />
																								</td>
																							</tr>
																						</c:forEach>
																					</tbody>
																					</table>
																				</div>
																			</c:forEach>
																		</c:when>
																		<c:otherwise>
																			<c:forEach items="${tournament.rankings}" var="ranking">
																				<h3 class="worldScheduleHeader"><c:out value="${ranking.name}" /></h3>
																				<div class="table-responsive">
																					<table class="table table-bordered table-xs table-condensed teamTable">
																						<thead class="teamTableHeader">
																							<tr>
																								<th>#</th>
																								<th>Equipo</th>
																								<th>JJ</th>
																								<th>JG</th>
																								<th>JE</th>
																								<th>JP</th>
																								<th>GF:GC</th>
																								<th>Puntos</th>
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
																								</tr>
																							</c:forEach>
																						</tbody>
																					</table>
																				</div>
																			</c:forEach>
																		</c:otherwise>
																	</c:choose>
																</c:otherwise>
															</c:choose>
														</c:otherwise>
													</c:choose>
												</div>
											</div>
										</c:forEach>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	$(document).ready(function() {
		$('.nav-tabs a:first').tab('show');
	});
</script>