<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<div align="center">
	<h1 class="mainHeader">LISTADO DE LIGAS</h1>
</div>

<div class="row">
	<div class="col-sm-12" align="center">
		<nav aria-label="Page navigation example">
			<ul class="pagination pagination-sm">
				<c:choose>
					<c:when test="${leagueName eq 'A'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=A" />'>A</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=A" />'>A</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'B'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=B" />'>B</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=B" />'>B</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'C'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=C" />'>C</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=C" />'>C</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'D'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=D" />'>D</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=D" />'>D</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'E'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=E" />'>E</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=E" />'>E</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'F'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=F" />'>F</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=F" />'>F</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'G'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=G" />'>G</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=G" />'>G</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'H'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=H" />'>H</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=H" />'>H</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'I'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=I" />'>I</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=I" />'>I</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'J'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=J" />'>J</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=J" />'>J</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'K'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=K" />'>K</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=K" />'>K</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'L'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=L" />'>L</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=L" />'>L</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'M'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=M" />'>M</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=M" />'>M</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'N'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=N" />'>N</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=N" />'>N</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'O'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=O" />'>O</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=O" />'>O</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'P'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=P" />'>P</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=P" />'>P</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'Q'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=Q" />'>Q</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=Q" />'>Q</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'R'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=R" />'>R</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=R" />'>R</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'S'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=S" />'>S</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=S" />'>S</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'T'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=T" />'>T</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=T" />'>T</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'U'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=U" />'>U</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=U" />'>U</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'V'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=V" />'>V</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=V" />'>V</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'W'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=W" />'>W</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=W" />'>W</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'X'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=X" />'>X</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=X" />'>X</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'Y'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=Y" />'>Y</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=Y" />'>Y</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${leagueName eq 'Z'}">
						<li class="page-item active"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=Z" />'>Z</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href='<spring:url value="/open-league.html?rpLeagueName=Z" />'>Z</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</div>
</div>

<c:if test="${leagueName eq 'A'}">
	<div align="center"><p class="openLeagueIndicator">: A :</p></div>
</c:if>

<c:if test="${leagueName eq 'B'}">
	<div align="center"><p class="openLeagueIndicator">: B :</p></div>
</c:if>

<c:if test="${leagueName eq 'C'}">
	<div align="center"><p class="openLeagueIndicator">: C :</p></div>
</c:if>

<c:if test="${leagueName eq 'D'}">
	<div align="center"><p class="openLeagueIndicator">: D :</p></div>
</c:if>

<c:if test="${leagueName eq 'E'}">
	<div align="center"><p class="openLeagueIndicator">: E :</p></div>
</c:if>

<c:if test="${leagueName eq 'F'}">
	<div align="center"><p class="openLeagueIndicator">: F :</p></div>
</c:if>

<c:if test="${leagueName eq 'G'}">
	<div align="center"><p class="openLeagueIndicator">: G :</p></div>
</c:if>

<c:if test="${leagueName eq 'H'}">
	<div align="center"><p class="openLeagueIndicator">: H :</p></div>
</c:if>

<c:if test="${leagueName eq 'I'}">
	<div align="center"><p class="openLeagueIndicator">: I :</p></div>
</c:if>

<c:if test="${leagueName eq 'J'}">
	<div align="center"><p class="openLeagueIndicator">: J :</p></div>
</c:if>

<c:if test="${leagueName eq 'K'}">
	<div align="center"><p class="openLeagueIndicator">: K :</p></div>
</c:if>

<c:if test="${leagueName eq 'L'}">
	<div align="center"><p class="openLeagueIndicator">: L :</p></div>
</c:if>

<c:if test="${leagueName eq 'M'}">
	<div align="center"><p class="openLeagueIndicator">: M :</p></div>
</c:if>

<c:if test="${leagueName eq 'N'}">
	<div align="center"><p class="openLeagueIndicator">: N :</p></div>
</c:if>

<c:if test="${leagueName eq 'O'}">
	<div align="center"><p class="openLeagueIndicator">: O :</p></div>
</c:if>

<c:if test="${leagueName eq 'P'}">
	<div align="center"><p class="openLeagueIndicator">: P :</p></div>
</c:if>

<c:if test="${leagueName eq 'Q'}">
	<div align="center"><p class="openLeagueIndicator">: Q :</p></div>
</c:if>

<c:if test="${leagueName eq 'R'}">
	<div align="center"><p class="openLeagueIndicator">: R :</p></div>
</c:if>

<c:if test="${leagueName eq 'S'}">
	<div align="center"><p class="openLeagueIndicator">: S :</p></div>
</c:if>

<c:if test="${leagueName eq 'T'}">
	<div align="center"><p class="openLeagueIndicator">: T :</p></div>
</c:if>

<c:if test="${leagueName eq 'U'}">
	<div align="center"><p class="openLeagueIndicator">: U :</p></div>
</c:if>

<c:if test="${leagueName eq 'V'}">
	<div align="center"><p class="openLeagueIndicator">: V :</p></div>
</c:if>

<c:if test="${leagueName eq 'W'}">
	<div align="center"><p class="openLeagueIndicator">: W :</p></div>
</c:if>

<c:if test="${leagueName eq 'X'}">
	<div align="center"><p class="openLeagueIndicator">: X :</p></div>
</c:if>

<c:if test="${leagueName eq 'Y'}">
	<div align="center"><p class="openLeagueIndicator">: Y :</p></div>
</c:if>

<c:if test="${leagueName eq 'Z'}">
	<div align="center"><p class="openLeagueIndicator">: Z :</p></div>
</c:if>

<c:choose>
	<c:when test="${empty(leagues)}">
		<div class="emptyDiv" align="center">
			<strong>Lo sentimos.</strong><br />No hay ligas en este listado
		</div>
	</c:when>
	<c:otherwise>
		<div class="row">
			<c:forEach items="${leagues}" var="league">
				<div class="col-md-3" align="center" style="padding: 20px;">
					<a href='<spring:url value="/result-league.html?rpLeagueId=${league.id}" />' class="generalLink"><c:out value="${league.name}"/> <img src='<c:url value="/resources/images/ball.png"/>' alt="ball"></a>			 		
			 	</div>
			</c:forEach>
		</div>
		
		<br />
		<br />
	</c:otherwise>
</c:choose>