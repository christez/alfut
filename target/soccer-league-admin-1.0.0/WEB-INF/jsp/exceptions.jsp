<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Excepciones</h1>

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

<c:choose>
	<c:when test="${empty(exceptions)}">
		<div class="alert alert-success">
			<strong>No existe ninguna excepción.</strong>
		</div>
		<div align="center">
			<img alt="goodIcon" src='<c:url value="/resources/images/checkmark.png"/>'>
		</div>
	</c:when>
	<c:otherwise>
		<table class="table table-bordered table-xs table-condensed teamTable">
			<thead class="teamTableHeader">
				<tr>
					<th>Método</th>
					<th>Detalles</th>
					<th>Información adicional</th>
					<th>Eliminar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${exceptions}" var="exception">
					<tr class="teamTableHover">
						<td class="teamTableBolder">
							<c:out value="${exception.method}" />
						</td>
						<td>
							<c:out value="${exception.details}" />
						</td>
						<td>
							<c:out value="${exception.additional}" />
						</td>
						<td>
							<a href='<spring:url value="/exceptions/remove/${exception.id}.html" />' class="btn btn-danger btn-sm triggerRemove">Eliminar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div aria-label="Page navigation" align="center">
			<ul class="pagination">
				<c:choose>
		            <c:when test="${currentPage == 1}">
		                <li class="disabled"><a href="#">&lt;&lt;</a></li>
		                <li class="disabled"><a href="#">&lt;</a></li>
		            </c:when>
		            <c:otherwise>
		                <li><a href='<spring:url value="/exceptions.html?rpPageNumber=1" />'>&lt;&lt;</a></li>
		                <li><a href='<spring:url value="/exceptions.html?rpPageNumber=${currentPage - 1}" />'>&lt;</a></li>
		            </c:otherwise>
		        </c:choose>
		        <c:forEach var="counter" begin="${begin}" end="${end}">
		            <c:choose>
		                <c:when test="${counter == currentPage}">
		                    <li class="active"><a href='<spring:url value="/exceptions.html?rpPageNumber=${counter}" />'><c:out value="${counter}" /></a></li>
		                </c:when>
		                <c:otherwise>
		                    <li><a href='<spring:url value="/exceptions.html?rpPageNumber=${counter}" />'><c:out value="${counter}" /></a></li>
		                </c:otherwise>
		            </c:choose>
		        </c:forEach>
		        <c:choose>
		            <c:when test="${currentPage == totalPages}">
		                <li class="disabled"><a href="#">&gt;</a></li>
		                <li class="disabled"><a href="#">&gt;&gt;</a></li>
		            </c:when>
		            <c:otherwise>
		                <li><a href='<spring:url value="/exceptions.html?rpPageNumber=${currentPage + 1}" />'>&gt;</a></li>
		                <li><a href='<spring:url value="/exceptions.html?rpPageNumber=${totalPages}" />'>&gt;&gt;</a></li>
		            </c:otherwise>
		        </c:choose>
		  	</ul>
		</div>
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
				¿Seguro que deseas eliminar la excepción?
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
			
			$('#modalRemove').modal();;
		});
	});
</script>