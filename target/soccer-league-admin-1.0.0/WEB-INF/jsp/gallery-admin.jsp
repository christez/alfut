<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Galería</h1>

<hr />

<a href="#myModal" class="btn btn-lg btnAdministrationPrimary" data-toggle="modal">Crear galería</a>

<hr />

<form:form commandName="gallery" cssClass="form-horizontal galleryForm">
	<div id="myModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Crear galería</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="url" class="col-sm-2 control-label">Url:</label>
						<div class="col-sm-10">
							<form:input path="url" cssClass="form-control" maxlength="250"/>
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
	<c:when test="${empty(galleries)}">
		<div class="emptyDiv" align="center">
			<strong>No existe ninguna galería creada.</strong><br />Da click en el botón "Crear galería" para iniciar
		</div>
	</c:when>
	<c:otherwise>
		<div class="row">
			<div class="table-responsive">
				<table class="table table-bordered table-xs table-condensed teamTable">
					<thead class="teamTableHeader">
						<tr>
							<th>Url</th>
							<th>Eliminar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${galleries}" var="gallery">
							<tr class="teamTableHover">
								<td>
									<c:out value="${gallery.url}" />
								</td>
								<td>
									<a href='<spring:url value="/gallery-admin/remove/${gallery.id}.html" />' class="btn btn-danger btn-xs triggerRemove">Eliminar</a>
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
		
		$(".galleryForm").validate(
				{
					rules: {
						url: {
							required: true,
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
						url: {
							required: "Campo requerido",
							url: "Formato URL"
						}
					}
				}
		);
	});
</script>