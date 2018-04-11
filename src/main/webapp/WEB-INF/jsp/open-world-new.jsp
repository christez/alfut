<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<div align="center">
	<h1 class="mainHeader">NOTICIAS DEL MUNDO</h1>
</div>

<c:choose>
	<c:when test="${empty(news)}">
		<div class="emptyDiv" align="center">
			<strong>Lo sentimos.</strong><br />No hay noticias recientes
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
								<p class="newsDate"><fmt:formatDate value="${currentNew.creationDate}" pattern="yyyy/MM/dd"/></p>
								<div align="justify">
									<p class="newsInfo"><c:out value="${currentNew.information}"/></p>
								</div>
							</div>
							<div class="col-sm-4 openWorldNewIconContainer">
								<img alt="icon" src='<c:url value="${currentNew.url}"/>' class="openWorldNewIcon" data-toggle="tooltip" data-placement="right" title='<c:out value="${currentNew.header}"/>'>
							</div>
						</c:when>
						<c:otherwise>
							<div class="col-sm-4 openWorldNewIconContainer">
								<img alt="icon" src='<c:url value="${currentNew.url}"/>' class="openWorldNewIcon" data-toggle="tooltip" data-placement="left" title='<c:out value="${currentNew.header}"/>'>
							</div>
							<div class="col-sm-4">
								<p class="newsHeader"><c:out value="${currentNew.header}"/></p>
								<p class="newsDate"><fmt:formatDate value="${currentNew.creationDate}" pattern="yyyy/MM/dd"/></p>
								<div align="justify">
									<p class="newsInfo"><c:out value="${currentNew.information}"/></p>
								</div>
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