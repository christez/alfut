<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<div align="center">
	<img src='<c:url value="/resources/images/news.png"/>' alt="news">
</div>

<c:choose>
	<c:when test="${empty(news)}">
		<div class="alert alert-info">
			<strong>Lo sentimos.</strong> No hay noticias recientes
		</div>
		<div align="center">
			<img alt="sadFace" src='<c:url value="/resources/images/sadFace.png"/>'>
		</div>
	</c:when>
	<c:otherwise>
		<c:forEach items="${news}" var="myNew">
			<div class="row newsContainer">
				<div class="col-md-3"></div>
				<div class="col-md-4">
					<p class="newsHeader"><c:out value="${myNew.header}"/> | <c:out value="${myNew.user.username}"/></p>
					<p class="newsInfo"><c:out value="${myNew.information}"/></p>
			 	</div>
			 	<div class="col-md-3 newsDate">
			 		<c:if test="${myNew.type eq 'Importante'}">
			 			<img src='<c:url value="/resources/images/newsImportant.png"/>' class="img-rounded newsImage" alt="Important" data-toggle="tooltip" title="Importante" data-placement="right">
			 		</c:if>
			 		
			 		<c:if test="${myNew.type eq 'Informativa'}">
			 			<img src='<c:url value="/resources/images/newsInformation.png"/>' class="img-rounded newsImage" alt="Information" data-toggle="tooltip" title="Información" data-placement="right">
			 		</c:if>
			 		
			 		<c:if test="${myNew.type eq 'Advertencia'}">
			 			<img src='<c:url value="/resources/images/newsWarning.png"/>' class="img-rounded newsImage" alt="Warning" data-toggle="tooltip" title="Advertencia" data-placement="right">
			 		</c:if>
			 		
			 		<br />			 		
			 		<p><fmt:formatDate value="${myNew.creationDate}" pattern="yyyy/MM/dd"/></p>	 
			 	</div>
			 	<div class="col-md-1"></div>
		 	</div>
		</c:forEach>
		
		<div align="center" class="openLeagueLogo">
			<img src='<c:url value="/resources/images/openNews.png"/>' alt="openNews">
		</div>
	</c:otherwise>
</c:choose>