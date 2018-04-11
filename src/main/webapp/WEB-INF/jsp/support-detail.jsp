<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Detalle del caso</h1>

<hr />

<h3 class="orangeColor"><c:out value="${supportCase.title}"/></h3>
		
<c:if test="${supportCase.type eq 'Baja'}">
	<h4 class="text-muted">Urgencia: <strong><c:out value="${supportCase.type}"/></strong></h4>
</c:if>
<c:if test="${supportCase.type eq 'Media'}">
	<h4 class="text-warning">Urgencia: <strong><c:out value="${supportCase.type}"/></strong></h4>
</c:if>
<c:if test="${supportCase.type eq 'Alta'}">
	<h4 class="text-danger">Urgencia: <strong><c:out value="${supportCase.type}"/></strong></h4>
</c:if>

<a href='<spring:url value="/support-detail/close/${supportCase.id}.html" />' class="btn btn-danger btn-sm triggerRemove">Cerrar</a>

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

<table class="supportTable">
	<tr>
		<td class="supportMessagesContainer">
			<table class="supportInnerTable">
				<tr>
					<td>
						<h4 class="supportTableHeader">Mis mensajes</h4>
					</td>
					<td>
						<h4 class="supportTableHeader">Mis respuestas</h4>
					</td>
				</tr>
				<c:forEach items="${supportCase.conversations}" var="conversation">
					<tr>
						<td>
							<c:if test="${supportCase.type eq 'Baja'}">
								<div class="col-md-5 supportMessage text-muted">
							</c:if>
							<c:if test="${supportCase.type eq 'Media'}">
								<div class="col-md-5 supportMessage text-warning">
							</c:if>
							<c:if test="${supportCase.type eq 'Alta'}">
								<div class="col-md-5 supportMessage text-danger">
							</c:if>
								<p><c:out value="${conversation.messageUser}"/></p>
							</div>
						</td>
						<td>
							<div class="col-md-5 supportMessage">
								<c:choose>
									<c:when test="${empty(conversation.messageAdministrator)}">
										<p>Esperando por respuesta</p>
									</c:when>
									<c:otherwise>
										<p><c:out value="${conversation.messageAdministrator}"/></p>
									</c:otherwise>
								</c:choose>
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</td>
		<td class="supportMessagesSender">
			<c:choose>
				<c:when test="${supportCase.status eq 'Respuesta'}">
					<h4 class="supportTableHeader">Nuevo mensaje</h4>
					<form:form commandName="conversation" cssClass="form-horizontal conversationForm">
						<div class="form-group">
							<div class="col-sm-12">
								<form:textarea path="messageUser" cssClass="form-control supportMessageText" maxlength="200"/>
								<form:errors path="messageUser"/>
							</div>
						</div>
						<div class="form-group" align="center">
							<input type="submit" value="Enviar" class="btn btnAdministrationPrimary" name="conversation">
						</div>
					</form:form>
				</c:when>
				<c:otherwise>
					<h4 class="supportTableHeader">Nuevo mensaje</h4>
					<form:form commandName="conversation" cssClass="form-horizontal conversationForm">
						<div class="form-group">
							<div class="col-sm-12">
								<form:textarea path="messageUser" cssClass="form-control supportMessageText" maxlength="200" disabled="true"/>
								<form:errors path="messageUser"/>
							</div>
						</div>
						<div class="form-group" align="center">
							<input type="submit" value="Enviar" class="btn btnAdministrationPrimary disabled">
						</div>
					</form:form>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>

<br />
<br />

<div id="modalRemove" class="modal fade modalRemove">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Confirmar acción</h4>
			</div>
			<div class="modal-body">
				¿Seguro que deseas cerrar el caso?
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				<a href="" class="btn btn-danger removeBtn">Cerrar</a>
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
		
		$(".conversationForm").validate(
				{
					rules: {
						messageUser: {
							required: true,
							minlength: 1,
							maxlength: 200
						}
					},
					highlight: function(element){
						$(element).closest(".form-group").removeClass("has-success").addClass("has-error");
					},
					unhighlight: function(element){
						$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
					},
					messages: {
						message: "El mensaje debe tener al menos 1 caracterer y máximo 200"
					}
				}
		);
	});
</script>