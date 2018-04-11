<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Anuncios</h1>

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
	<c:when test="${empty(commercials)}">
		<div class="emptyDiv" align="center">
			<strong>No existe ningún mensaje creado.</strong><br />Debes esperar por mensajes nuevos
		</div>
	</c:when>
	<c:otherwise>
		<div class="row">
			<div class="table-responsive">
				<table class="table table-bordered table-xs table-condensed teamTable">
					<thead class="teamTableHeader">
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Email</th>
							<th>Mensaje</th>
							<th>Fecha de creación</th>
							<th>Eliminar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${commercials}" var="commercial">
							<tr class="teamTableHover">
								<td>
									<c:out value="${commercial.id}" />
								</td>
								<td>
									<c:out value="${commercial.name}" />
								</td>
								<td>
									<c:out value="${commercial.email}" />
								</td>
								<td>
									<c:out value="${commercial.message}" />
								</td>
								<td>
									<fmt:formatDate value="${commercial.creationDate}" pattern="yyyy/MM/dd HH:mm:ss"/>
								</td>
								<td>
									<a href='<spring:url value="/commercial-admin/remove/${commercial.id}.html" />' class="btn btn-danger btn-xs triggerRemove">Eliminar</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
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
				¿Seguro que deseas eliminar la galería?
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