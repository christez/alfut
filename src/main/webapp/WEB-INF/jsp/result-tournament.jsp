<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<div align="center">
	<img src='<c:url value="/resources/images/resultTournament.png"/>' alt="Tournament">
</div>

<div align="center">
	<h1 class="resultTournamentHeader">|<c:out value="${tournamentSchedules.name}"></c:out>|</h1>
</div>

<c:choose>
	<c:when test="${tournamentSchedules.status eq 'Configuración'}">
		<div class="alert alert-info">
			<strong>Torneo en construcción.</strong> En breve estará listo
		</div>			
		<div align="center">
			<img alt="bulding" src='<c:url value="/resources/images/building.gif"/>'>
		</div>
	</c:when>
	<c:otherwise>
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation"><a href="#schedules" aria-controls="schedules" role="tab" data-toggle="tab">Jornadas</a></li>
			<li role="presentation"><a href="#positions" aria-controls="positions" role="tab" data-toggle="tab">Posiciones</a></li>
			
			<c:if test="${tournamentSchedules.type eq 'Por puntos más liguilla' or tournamentSchedules.type eq 'Por grupos más liguilla'}">
				<li role="presentation"><a href="#playoffs" aria-controls="playoffs" role="tab" data-toggle="tab">Liguilla</a></li>
			</c:if>
			
			<c:if test="${tournamentSchedules.status eq 'Finalizado'}">
				<li role="presentation"><a href="#champion" aria-controls="champion" role="tab" data-toggle="tab">Campeón</a></li>
			</c:if>
		</ul>
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane" id="schedules">
				<c:if test="${tournamentSchedules.type eq 'Por puntos' or tournamentSchedules.type eq 'Por puntos más liguilla'}">
					<c:set var="scheduleCounter" scope="session" value="${1}"/>
		
					<c:forEach items="${tournamentSchedules.schedules}" var="schedule">
						<p class="openLeagueScheduleHeader">Jornada <c:out value="${scheduleCounter}"/></p>
						<div id="scheduleCarousel_<c:out value="${schedule.id}"/>" class="carousel slide scheduleCarousel" data-ride="carousel">
							<ol class="carousel-indicators">
								<c:set var="matchCounter" scope="session" value="${0}"/>
							
								<c:forEach items="${schedule.matches}" var="matches">
									<c:choose>
										<c:when test="${matchCounter eq 0}">
											<li data-target="#scheduleCarousel_<c:out value="${schedule.id}"/>" data-slide-to="<c:out value="${matchCounter}" />" class="active"></li>
										</c:when>
										<c:otherwise>
											<li data-target="#scheduleCarousel_<c:out value="${schedule.id}"/>" data-slide-to="<c:out value="${matchCounter}" />"></li>
										</c:otherwise>
									</c:choose>
									
									<c:set var="matchCounter" scope="session" value="${matchCounter + 1}"/>
								</c:forEach>
							</ol>
						
							<div class="carousel-inner">
								<c:set var="matchCounter" scope="session" value="${0}"/>
							
								<c:forEach items="${schedule.matches}" var="match">
									<c:choose>
										<c:when test="${matchCounter eq 0}">
											<div class="item active">
												<img src='<c:url value="/resources/images/indexCarouselBackground.png"/>' alt="image<c:out value="${matchCounter}" />" class="scheduleCarouselImage">
												<div class="carousel-caption scheduleCarouselText">
											        <h2>Juego <c:out value="${matchCounter + 1}" /></h2>
											        <h3><c:out value="${match.teamLocalName}" /> vs <c:out value="${match.teamVisitorName}" /></h3>
											        <c:choose>
											        	<c:when test="${match.status eq 'Jugado'}">
											        		<h4><c:out value="${match.goalsLocal}" /> - <c:out value="${match.goalsVisitor}" /></h4>
											        	</c:when>
											        	<c:otherwise>
											        		<h4>Juego pendiente</h4>
											        	</c:otherwise>
											        </c:choose>
											        <p><c:out value="${match.date}" /> - <c:out value="${match.time}" /></p>
												</div>
											</div>
										</c:when>
										<c:otherwise>
											<div class="item">
												<img src='<c:url value="/resources/images/indexCarouselBackground.png"/>' alt="image<c:out value="${matchCounter}" />" class="scheduleCarouselImage">
												<div class="carousel-caption scheduleCarouselText">
											        <h2>Juego <c:out value="${matchCounter + 1}" /></h2>
											        <h3><c:out value="${match.teamLocalName}" /> vs <c:out value="${match.teamVisitorName}" /></h3>
											        <c:choose>
											        	<c:when test="${match.status eq 'Jugado'}">
											        		<h4><c:out value="${match.goalsLocal}" /> - <c:out value="${match.goalsVisitor}" /></h4>
											        	</c:when>
											        	<c:otherwise>
											        		<h4>Juego pendiente</h4>
											        	</c:otherwise>
											        </c:choose>
											        <p><c:out value="${match.date}" /> - <c:out value="${match.time}" /></p>
												</div>
											</div>
										</c:otherwise>
									</c:choose>
									
									<c:set var="matchCounter" scope="session" value="${matchCounter + 1}"/>
								</c:forEach>
							</div>
						
							<a class="left carousel-control" href="#scheduleCarousel_<c:out value="${schedule.id}"/>" data-slide="prev">
								<img class="carouselControlImage" alt="Left" src='<c:url value="/resources/images/leftArrow.png"/>' >
							</a>
							<a class="right carousel-control" href="#scheduleCarousel_<c:out value="${schedule.id}"/>" data-slide="next">
								<img class="carouselControlImage" alt="Right" src='<c:url value="/resources/images/rightArrow.png"/>' >
							</a>
						</div>
						
						<c:set var="scheduleCounter" scope="session" value="${scheduleCounter + 1}"/>
						
						<div class="col-md-12">
							<hr class="clusterScheduleDivider">
						</div>
					</c:forEach>
					
					<br />
				</c:if>
				
				<c:if test="${tournamentSchedules.type eq 'Por grupos más liguilla'}">
					<div class="resultTournamnetClusterContainer">
						<c:forEach items="${tournamentSchedules.clusters}" var="cluster">
							<a href="#" class="btn btn-link resultTournamnetClusterToggler" data-toggle="collapse" data-target="#cluster_<c:out value="${cluster.id}" />"><c:out value="${cluster.name}" /></a>
							<br />
							<div id="cluster_<c:out value="${cluster.id}" />" class="collapse">
								<div class="resultTournamnetClusterInnerContainer">
									<c:set var="scheduleCounter" scope="session" value="${1}"/>
									
									<c:forEach items="${cluster.schedules}" var="schedule">
										<p class="openLeagueScheduleHeader">Jornada <c:out value="${scheduleCounter}"/></p>
										<div id="scheduleCarousel_<c:out value="${schedule.id}"/>" class="carousel slide scheduleCarousel" data-ride="carousel">
											<ol class="carousel-indicators">
												<c:set var="matchCounter" scope="session" value="${0}"/>
											
												<c:forEach items="${schedule.matches}" var="matches">
													<c:choose>
														<c:when test="${matchCounter eq 0}">
															<li data-target="#scheduleCarousel_<c:out value="${schedule.id}"/>" data-slide-to="<c:out value="${matchCounter}" />" class="active"></li>
														</c:when>
														<c:otherwise>
															<li data-target="#scheduleCarousel_<c:out value="${schedule.id}"/>" data-slide-to="<c:out value="${matchCounter}" />"></li>
														</c:otherwise>
													</c:choose>
													
													<c:set var="matchCounter" scope="session" value="${matchCounter + 1}"/>
												</c:forEach>
											</ol>
										
											<div class="carousel-inner">
												<c:set var="matchCounter" scope="session" value="${0}"/>
											
												<c:forEach items="${schedule.matches}" var="match">
													<c:choose>
														<c:when test="${matchCounter eq 0}">
															<div class="item active">
																<img src='<c:url value="/resources/images/indexCarouselBackground.png"/>' alt="image<c:out value="${matchCounter}" />" class="scheduleCarouselImage">
																<div class="carousel-caption scheduleCarouselText">
															        <h2>Juego <c:out value="${matchCounter + 1}" /></h2>
															        <h3><c:out value="${match.teamLocalName}" /> vs <c:out value="${match.teamVisitorName}" /></h3>
															        <c:choose>
															        	<c:when test="${match.status eq 'Jugado'}">
															        		<h4><c:out value="${match.goalsLocal}" /> - <c:out value="${match.goalsVisitor}" /></h4>
															        	</c:when>
															        	<c:otherwise>
															        		<h4>Juego pendiente</h4>
															        	</c:otherwise>
															        </c:choose>
															        <p><c:out value="${match.date}" /> - <c:out value="${match.time}" /></p>
																</div>
															</div>
														</c:when>
														<c:otherwise>
															<div class="item">
																<img src='<c:url value="/resources/images/indexCarouselBackground.png"/>' alt="image<c:out value="${matchCounter}" />" class="scheduleCarouselImage">
																<div class="carousel-caption scheduleCarouselText">
															        <h2>Juego <c:out value="${matchCounter + 1}" /></h2>
															        <h3><c:out value="${match.teamLocalName}" /> vs <c:out value="${match.teamVisitorName}" /></h3>
															        <c:choose>
															        	<c:when test="${match.status eq 'Jugado'}">
															        		<h4><c:out value="${match.goalsLocal}" /> - <c:out value="${match.goalsVisitor}" /></h4>
															        	</c:when>
															        	<c:otherwise>
															        		<h4>Juego pendiente</h4>
															        	</c:otherwise>
															        </c:choose>
															        <p><c:out value="${match.date}" /> - <c:out value="${match.time}" /></p>
																</div>
															</div>
														</c:otherwise>
													</c:choose>
													
													<c:set var="matchCounter" scope="session" value="${matchCounter + 1}"/>
												</c:forEach>
											</div>
										
											<a class="left carousel-control" href="#scheduleCarousel_<c:out value="${schedule.id}"/>" data-slide="prev">
												<img class="carouselControlImage" alt="Left" src='<c:url value="/resources/images/leftArrow.png"/>' >
											</a>
											<a class="right carousel-control" href="#scheduleCarousel_<c:out value="${schedule.id}"/>" data-slide="next">
												<img class="carouselControlImage" alt="Right" src='<c:url value="/resources/images/rightArrow.png"/>' >
											</a>
										</div>
										
										<c:set var="scheduleCounter" scope="session" value="${scheduleCounter + 1}"/>
										
										<div class="col-md-12">
											<hr class="clusterScheduleDivider">
										</div>
									</c:forEach>
									
									<br />
								</div>
							</div>
						</c:forEach>
					</div>
				</c:if>
			</div>
			<div role="tabpanel" class="tab-pane" id="positions">
				<c:if test="${tournamentSchedules.type eq 'Por puntos' or tournamentSchedules.type eq 'Por puntos más liguilla'}">
					<div class="table-responsive resultTournamentTable">
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
								</tr>
							</thead>
							<tbody>
								<c:set var="positionCounter" scope="session" value="${1}"/>
								
								<c:forEach items="${tournamentPositions.teams}" var="team">
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
									</tr>
									
									<c:set var="positionCounter" scope="session" value="${positionCounter + 1}"/>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:if>
				
				<c:if test="${tournamentSchedules.type eq 'Por grupos más liguilla'}">
					<c:set var="clusterColorCounter" scope="session" value="${0}"/>
			
					<div class="row">			
						<c:forEach items="${tournamentClusters.clusters}" var="cluster">
							<div class="col-md-12">
								<c:if test="${clusterColorCounter % 5 == 0}">
									<div class="panel panel-primary resultTournamentClusterPanel">
								</c:if>
								<c:if test="${clusterColorCounter % 5 == 1}">
									<div class="panel panel-success resultTournamentClusterPanel">
								</c:if>
								<c:if test="${clusterColorCounter % 5 == 2}">
									<div class="panel panel-info resultTournamentClusterPanel">
								</c:if>
								<c:if test="${clusterColorCounter % 5 == 3}">
									<div class="panel panel-warning resultTournamentClusterPanel">
								</c:if>
								<c:if test="${clusterColorCounter % 5 == 4}">
									<div class="panel panel-danger resultTournamentClusterPanel">
								</c:if>
									<div class="panel-heading">
										<h3 class="panel-title"><c:out value="${cluster.name}"/></h3>
									</div>
									<div class="panel-body">
								    	<c:choose>
											<c:when test="${empty(cluster.teams)}">
												<div class="alert alert-warning clusterWarningText">
													<strong>No cuentas con ningún equipo creado. Da click en el botón "Detalle del equipo" para iniciar</strong>
												</div>
												<div align="center">
													<img alt="warningIcon" src='<c:url value="/resources/images/warningIcon.png"/>' class="clusterWarningIcon">
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
																</tr>
																
																<c:set var="positionCounter" scope="session" value="${positionCounter + 1}"/>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</c:otherwise>
										</c:choose>
								  	</div>
								</div>
							</div>
							
							<c:set var="clusterColorCounter" scope="session" value="${clusterColorCounter + 1}"/>
						</c:forEach>
					</div>
				</c:if>
			</div>
			<c:if test="${tournamentSchedules.type eq 'Por puntos más liguilla' or tournamentSchedules.type eq 'Por grupos más liguilla'}">
				<div role="tabpanel" class="tab-pane resultTournamentPlayoffs" id="playoffs">
					<div class="row">
						<div class="col-md-12">
							<div class="panel-body">
				            	<div class="playofssTree">
				            		<c:forEach items="${tournamentSchedules.playoffs}" var="playoff">
				            			<ul>
				            				<c:forEach items="${playoff.matches}" var="match">
				            					<c:choose>
				            						<c:when test="${match.status eq 'Jugado'}">
				            							<c:choose>
				            								<c:when test="${match.winner eq match.teamLocalName}">
				            									<li>&nbsp;</li>								    	
														        <li class="game game-top winner"><c:out value="${match.teamLocalName}" /> <span><c:out value="${match.goalsLocal}" /></span></li>
														        <li>&nbsp;</li>
														        <li class="game game-bottom "><c:out value="${match.teamVisitorName}" /> <span><c:out value="${match.goalsVisitor}" /></span></li>
				            								</c:when>
				            								<c:otherwise>
				            									<li>&nbsp;</li>								    	
														        <li class="game game-top"><c:out value="${match.teamLocalName}" /> <span><c:out value="${match.goalsLocal}" /></span></li>
														        <li>&nbsp;</li>
														        <li class="game game-bottom winner"><c:out value="${match.teamVisitorName}" /> <span><c:out value="${match.goalsVisitor}" /></span></li>
				            								</c:otherwise>
				            							</c:choose>
				            						</c:when>
				            						<c:otherwise>
				            							<c:choose>
				            								<c:when test="${playoff.status eq 'Programado'}">
				            									<li>&nbsp;</li>								    	
														        <li class="game game-top"><strong><c:out value="${match.teamLocalName}" /></strong><span><c:out value="${match.date}" /> - <c:out value="${match.time}" /></span></li>
														        <li>&nbsp;</li>
														        <li class="game game-bottom"><strong><c:out value="${match.teamVisitorName}" /></strong><span></span></li>
				            								</c:when>
				            								<c:otherwise>
				            									<li>&nbsp;</li>								    	
														        <li class="game game-top"><c:out value="${match.teamLocalName}" /><span>-</span></li>
														        <li>&nbsp;</li>
														        <li class="game game-bottom"><c:out value="${match.teamVisitorName}" /><span>-</span></li>
				            								</c:otherwise>
				            							</c:choose>
				            							
				            						</c:otherwise>
				            					</c:choose>
				            				</c:forEach>
				            			</ul>
				            		</c:forEach>
								</div>
				            </div>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${tournamentSchedules.status eq 'Finalizado'}">
				<div role="tabpanel" class="tab-pane resultTournamantChampionContainer" id="champion">
					<div align="center">
						<h1>Felicidades <strong class="resultTournamantChampion"><c:out value="${tournamentSchedules.winner}"></c:out>!!!</strong></h1>
						<img alt="trophy" src='<c:url value="/resources/images/trophy.png"/>'>
						<h3 class="resultTournamantChampionInfo">Por el título obtenido</h3>
					</div>
				</div>
			</c:if>
		</div>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	$(document).ready(function() {
		$('.nav-tabs a:first').tab('show');
		
		<c:forEach items="${tournamentSchedules.schedules}" var="schedule">
			$("#scheduleCarousel_<c:out value="${schedule.id}"/>").carousel({
				interval: false
			});
		</c:forEach>
	});
</script>