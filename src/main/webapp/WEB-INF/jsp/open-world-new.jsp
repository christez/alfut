<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<div align="center">
	<img alt="worldLeagues" src='<c:url value="/resources/images/worldNews.png"/>'>
</div>

<c:choose>
	<c:when test="${empty(news)}">
		<div class="alert alert-info">
			<strong>Sitio en construcción.</strong> En breve estará listo
		</div>			
		<div align="center">
			<img alt="bulding" src='<c:url value="/resources/images/building.gif"/>'>
		</div>
	</c:when>
	<c:otherwise>
		<c:set var="moduleFlag" scope="session" value="${1}"/>
			
		<c:forEach items="${news}" var="currentNew">
			<div class="row openWorldNewContainer">
				<div class="col-sm-2">				
					</div>
					<c:choose>
						<c:when test="${moduleFlag % 2 eq 1}">
							<div class="col-sm-4">
								<p class="newsHeader"><c:out value="${currentNew.header}"/></p>
								<p class="newsInfo"><c:out value="${currentNew.information}"/></p>
							</div>
							<div class="col-sm-4 openWorldNewIconContainer">
								<img alt="icon" src='<c:url value="${currentNew.url}"/>' class="openWorldNewIcon">
							</div>
						</c:when>
						<c:otherwise>
							<div class="col-sm-4 openWorldNewIconContainer">
								<img alt="icon" src='<c:url value="${currentNew.url}"/>' class="openWorldNewIcon">
							</div>
							<div class="col-sm-4">
								<p class="newsHeader"><c:out value="${currentNew.header}"/></p>
								<p class="newsInfo"><c:out value="${currentNew.information}"/></p>
							</div>
						</c:otherwise>
					</c:choose>
					<div class="col-sm-2">
				</div>
			</div>
			
			<c:set var="moduleFlag" scope="session" value="${moduleFlag + 1}"/>
		</c:forEach>
		
		<div aria-label="Page navigation" align="center">
			<ul class="pagination">
				<c:choose>
		            <c:when test="${currentPage == 1}">
		                <li class="disabled"><a href="#">&lt;&lt;</a></li>
		                <li class="disabled"><a href="#">&lt;</a></li>
		            </c:when>
		            <c:otherwise>
		                <li><a href='<spring:url value="/open-world-new.html?rpPageNumber=1" />'>&lt;&lt;</a></li>
		                <li><a href='<spring:url value="/open-world-new.html?rpPageNumber=${currentPage - 1}" />'>&lt;</a></li>
		            </c:otherwise>
		        </c:choose>
		        <c:forEach var="counter" begin="${begin}" end="${end}">
		            <c:choose>
		                <c:when test="${counter == currentPage}">
		                    <li class="active"><a href='<spring:url value="/open-world-new.html?rpPageNumber=${counter}" />'><c:out value="${counter}" /></a></li>
		                </c:when>
		                <c:otherwise>
		                    <li><a href='<spring:url value="/open-world-new.html?rpPageNumber=${counter}" />'><c:out value="${counter}" /></a></li>
		                </c:otherwise>
		            </c:choose>
		        </c:forEach>
		        <c:choose>
		            <c:when test="${currentPage == totalPages}">
		                <li class="disabled"><a href="#">&gt;</a></li>
		                <li class="disabled"><a href="#">&gt;&gt;</a></li>
		            </c:when>
		            <c:otherwise>
		                <li><a href='<spring:url value="/open-world-new.html?rpPageNumber=${currentPage + 1}" />'>&gt;</a></li>
		                <li><a href='<spring:url value="/open-world-new.html?rpPageNumber=${totalPages}" />'>&gt;&gt;</a></li>
		            </c:otherwise>
		        </c:choose>
		  	</ul>
		</div>
	</c:otherwise>
</c:choose>