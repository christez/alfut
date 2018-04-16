<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<div align="center">
	<h1 class="mainHeader">NUESTRAS NOTICIAS</h1>
</div>

<c:choose>
	<c:when test="${empty(news)}">
		<div class="emptyDiv" align="center">
			<strong>Lo sentimos.</strong><br />No hay noticias recientes
		</div>
	</c:when>
	<c:otherwise>
		<div class="row newsTabContainer">
			<c:set var="tabNewsCounter" scope="session" value="${1}"/>
		
			<div class="tabNews">
				<c:forEach items="${news}" var="myNew">
					<c:choose>
						<c:when test="${tabNewsCounter eq 1}">
							<button class="tablinks" onclick="openNewsTab('<c:out value="${tabNewsCounter}" />_<c:out value="${myNew.header}" />', this, '#F15A24')" id="defaultOpen">
								<c:if test="${myNew.type eq 'Importante'}">
						 			<img src='<c:url value="/resources/images/newsImportant.png"/>' class="img-rounded newsImageSmall" alt="Important">
						 		</c:if>
						 		
						 		<c:if test="${myNew.type eq 'Informativa'}">
						 			<img src='<c:url value="/resources/images/newsInformation.png"/>' class="img-rounded newsImageSmall" alt="Information">
						 		</c:if>
						 		
						 		<c:if test="${myNew.type eq 'Advertencia'}">
						 			<img src='<c:url value="/resources/images/newsWarning.png"/>' class="img-rounded newsImageSmall" alt="Warning">
						 		</c:if>
						 		
						 		<c:out value="${myNew.header}" />
							</button>
						</c:when>
						<c:otherwise>
							<button class="tablinks" onclick="openNewsTab('<c:out value="${tabNewsCounter}" />_<c:out value="${myNew.header}" />', this, '#F15A24')">
								<c:if test="${myNew.type eq 'Importante'}">
						 			<img src='<c:url value="/resources/images/newsImportant.png"/>' class="img-rounded newsImageSmall" alt="Important">
						 		</c:if>
						 		
						 		<c:if test="${myNew.type eq 'Informativa'}">
						 			<img src='<c:url value="/resources/images/newsInformation.png"/>' class="img-rounded newsImageSmall" alt="Information">
						 		</c:if>
						 		
						 		<c:if test="${myNew.type eq 'Advertencia'}">
						 			<img src='<c:url value="/resources/images/newsWarning.png"/>' class="img-rounded newsImageSmall" alt="Warning">
						 		</c:if>
						 		
								<c:out value="${myNew.header}" />
							</button>
						</c:otherwise>
					</c:choose>
					
					<c:set var="tabNewsCounter" scope="session" value="${tabNewsCounter + 1}"/>
				</c:forEach>
			</div>
			
			<c:set var="tabNewsCounter" scope="session" value="${1}"/>
			
			<c:forEach items="${news}" var="myNew">
				<div id='<c:out value="${tabNewsCounter}" />_<c:out value="${myNew.header}" />' class="tabContentNews">
					<div class="row">
						<div class="col-md-5" align="center">
							<c:if test="${myNew.type eq 'Importante'}">
					 			<img src='<c:url value="/resources/images/newsImportant.png"/>' class="img-rounded newsImage" alt="Important" data-toggle="tooltip" title="Importante" data-placement="bottom">
					 		</c:if>
					 		
					 		<c:if test="${myNew.type eq 'Informativa'}">
					 			<img src='<c:url value="/resources/images/newsInformation.png"/>' class="img-rounded newsImage" alt="Information" data-toggle="tooltip" title="Información" data-placement="bottom">
					 		</c:if>
					 		
					 		<c:if test="${myNew.type eq 'Advertencia'}">
					 			<img src='<c:url value="/resources/images/newsWarning.png"/>' class="img-rounded newsImage" alt="Warning" data-toggle="tooltip" title="Advertencia" data-placement="bottom">
					 		</c:if>
						</div>
						<div class="col-md-7">
							<p class="newsHeader"><c:out value="${myNew.header}" /></p>
							<p class="newsDate"><fmt:formatDate value="${myNew.creationDate}" pattern="yyyy/MM/dd"/></p>
							
							<div align="justify">
								<p><c:out value="${myNew.information}"/></p>
							</div>
						</div>
					</div>
				</div>
				
				<c:set var="tabNewsCounter" scope="session" value="${tabNewsCounter + 1}"/>
			</c:forEach>
		</div>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	function openNewsTab(newsName, element, color) {
	    var i, tabcontent, tablinks;
	    tabcontent = document.getElementsByClassName("tabContentNews");
	    
	    for (i = 0; i < tabcontent.length; i++) {
	        tabcontent[i].style.display = "none";
	    }
	    
	    tablinks = document.getElementsByClassName("tablinks");
	    
	    for (i = 0; i < tablinks.length; i++) {
	    	tablinks[i].style.backgroundColor = "#ffffff";
	    }
	    
	    document.getElementById(newsName).style.display = "block";
	    element.style.backgroundColor = color;
	}
	
	document.getElementById("defaultOpen").onclick();
</script>