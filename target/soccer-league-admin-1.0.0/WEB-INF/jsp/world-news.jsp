<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Noticias del mundo</h1>

<hr />

<a href="#myModal" class="btn btn-lg btnAdministrationPrimary" data-toggle="modal">Crear noticia</a>

<hr />

<form:form commandName="worldNew" cssClass="form-horizontal newForm">
	<div id="myModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Nueva noticia</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="header" class="col-sm-2 control-label">Encabezado:</label>
						<div class="col-sm-10">
							<form:input path="header" cssClass="form-control" maxlength="50"/>
							<form:errors path="header"/>
						</div>
					</div>
					<div class="form-group">
						<label for="information" class="col-sm-2 control-label">Información:</label>
						<div class="col-sm-10">
							<form:textarea path="information" cssClass="form-control" maxlength="200"/>
							<form:errors path="information"/>
						</div>
					</div>
					<div class="form-group">
						<label for="url" class="col-sm-2 control-label">Url de imagen:</label>
						<div class="col-sm-10">
							<form:input path="url" cssClass="form-control" maxlength="100"/>
							<form:errors path="url"/>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					<input type="submit" class="btn btnAdministrationPrimary" value="Crear">
				</div>
			</div>
		</div>
	</div>
</form:form>

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
	<c:when test="${empty(news)}">
		<div class="emptyDiv" align="center">
			<strong>No hay noticias creadas.</strong><br />Da click en el botón "Crear noticia" para iniciar
		</div>
	</c:when>
	<c:otherwise>
		<div class="table-responsive">
			<table class="table table-bordered table-xs table-condensed newTable">
				<thead class="newTableHeader">
					<tr>
						<th>Encabezado</th>
						<th>Información</th>
						<th>URL</th>
						<th>Borrar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${news}" var="currentNew">
						<tr class="newTableHover">
							<td>
								<strong><c:out value="${currentNew.header}" /></strong>
								<br />
								<br />
								<p class="newCreationDate"><fmt:formatDate value="${currentNew.creationDate}" pattern="yyyy/MM/dd"/></p>
								<p class="newCreationDate"><fmt:formatDate value="${currentNew.creationDate}" type="time"/></p>
							</td>
							<td>
								<c:out value="${currentNew.information}" />
							</td>
							<td class="newTableCenterColumn">
								<c:out value="${currentNew.url}" />
							</td>
							<td class="newTableCenterColumn">
								<a href='<spring:url value="/world-news/remove/${currentNew.id}.html" />' class="btn btn-danger btn-xs triggerRemove">Eliminar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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
				¿Seguro que deseas eliminar la noticia?
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
		
		$(".newForm").validate(
				{
					rules: {
						header: {
							required: true,
							minlength: 1
						},
						information: {
							required: true,
							minlength: 1,
							maxlength: 200
						},
						url: {
							required: true,
							minlength: 1,
							maxlength: 100,
							url: true
						}
					},
					highlight: function(element){
						$(element).closest(".form-group").removeClass("has-success").addClass("has-error");
					},
					unhighlight: function(element){
						$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
					},
					messages: {
						header: "El encabezado debe tener al menos 1 caracterer",
						information: "La información debe tener al menos 1 caracterer y máximo 200",
						url: {
							required: "Campo requerido",
							url: "Formato URL"
						}
					}
				}
		);
	});
</script>