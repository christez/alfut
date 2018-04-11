<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<div class="myJumbotron jumbotron">
	<div class="row">
		<div class="col-md-4" align="justify">
			<p><span class="myJumbotronSpan">ALFUT</span> es una aplicación profesional enfocada en la  creación y administración de torneos de Futbol locales.</p>
	 	</div>
	 	<div class="col-md-4">
	 		<p class="myJumbotronSpan">Síguenos en nuestras redes sociales</p>
	 		<a href="https://www.facebook.com/Alfut-154186695230940/" target="_blank"><img alt="facebook" src='<c:url value="/resources/images/facebook.png"/>' data-toggle="tooltip" data-placement="bottom" title="Facebook"></a>
  			<a href="https://twitter.com/soccerleagueadm" target="_blank"><img alt="Twitter" src='<c:url value="/resources/images/twitter.png"/>' data-toggle="tooltip" data-placement="bottom" title="Twitter"></a>
  			<a href="https://www.youtube.com/channel/UCArcKt3jUDcB9hQ88mCItHA" target="_blank"><img alt="YouTube" src='<c:url value="/resources/images/youtube.png"/>' data-toggle="tooltip" data-placement="bottom" title="YouTube"></a>
  			<br />
  			<br />
	 	</div>
	 	<div class="col-md-2">
	 		<p class="myJumbotronHeader">CATEGORÍAS</p>
	 		<a class="footerLink" href='<spring:url value="/open-league.html"></spring:url>'>Nuestras ligas</a>
	 		<br />
	 		<a class="footerLink" href='<spring:url value="/open-world-league.html"></spring:url>'>Ligas del mundo</a>
	 		<br />
	 		<a class="footerLink" href='<spring:url value="/open-news.html"></spring:url>'>Nuestras noticias</a>
	 		<br />
	 		<a class="footerLink" href='<spring:url value="/open-world-new.html"></spring:url>'>Noticias del mundo</a>
	 		<br />
	 		<br />
	 	</div>
	 	<div class="col-md-2">
	 		<p class="myJumbotronHeader">EXTRAS</p>
	 		<a class="footerLink" href='<spring:url value="/commercial.html"></spring:url>'>Anúnciate</a>
	 		<br />
	 		<a class="footerLink" href="#legalInformationModal" data-toggle="modal">Información legal</a>
	 		<br />
	 		<a class="footerLink" href="#" data-toggle="tooltip" data-placement="bottom" title="Email de contacto: alfut.contacto@gmail.com">Contacto</a>
	 		<br />
	 		<br />
	 	</div>
	</div>
</div>

<div class="copyright" align="left">
	<p>© 2018  CHRISTEZ APP COMPANY. Todos los derechos reservados</p>
</div>

<div id="legalInformationModal" class="modal fade legalInformation">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">Información legal</h4>
			</div>
			<div class="modal-body">
				<h3 class="legalInformationHeader">Uno</h3>
				<div align="justify">
					Al acceder a este sitio web, aceptas estar obligado por estos términos y condiciones de uso del sitio web, 
					todas las leyes y regulaciones aplicables y aceptas ser responsable del cumplimiento de las leyes locales aplicables. 
					Si no estás de acuerdo con alguno de estos términos, queda prohibido utilizar o acceder a este sitio. 
					Los materiales contenidos en este sitio web están protegidos por las leyes aplicables de derechos de autor y marcas.
				</div>
				<hr class="clusterScheduleDivider"/>
				
				<h3 class="legalInformationHeader">Dos</h3>
				<div align="justify">
					Los términos y condiciones del sitio pueden cambiar en cualquier momento. Las modificaciones a estos términos entrarán en vigor 
					inmediatamente después de su publicación en el sitio web. Aceptas y eres responsable de revisar periódicamente este acuerdo para 
					que tengas familiaridad con su contenido. Al continuar utilizando cualquier parte del sitio, significa que aceptas los términos 
					actualizados o revisados. Debes dejar de usar este sitio si no estás de acuerdo con los términos listados.
				</div>
				<hr class="clusterScheduleDivider"/>
				
				<h3 class="legalInformationHeader">Tres</h3>
				<div align="justify">
					Solo se puede crear una cuenta. Crear una SEGUNDA cuenta es una VIOLACIÓN de los términos y condiciones y podría resultar en la 
					baja permanente sin previo aviso.
				</div>
				<hr class="clusterScheduleDivider"/>
				
				<h3 class="legalInformationHeader">Cuatro</h3>
				<div align="justify">
					El sitio web ofrece servicios de administración de ligas de fútbol gratuitos a los usuarios registrados así como información general
					relacionada con el mundo del fútbol para el resto de la audiencia.
				</div>
				<hr class="clusterScheduleDivider"/>
				
				<h3 class="legalInformationHeader">Cinco</h3>
				<div align="justify">
					Protegeremos la información personal mediante medidas de seguridad razonables contra pérdida o robo, así como el acceso no autorizado, 
					divulgación, copia, uso o modificación. Si nos proporciona su dirección de correo electrónico, acepta que el sitio web lo contacte por esta vía.
				</div>
				<hr class="clusterScheduleDivider"/>
				
				<h3 class="legalInformationHeader">Seis</h3>
				<div align="justify">
					El sitio web se reserva el derecho de interrumpir el servicio de vez en cuando para realizar el mantenimiento, de forma regular o de 
					cualquier otra forma con o sin previo aviso. Usted acepta que el sitio web no será responsable de ninguna interrupción del servicio o 
					retraso o falla en el desempeño que resulte de cualquier causa.
				</div>
				<hr class="clusterScheduleDivider"/>
				
				<h3 class="legalInformationHeader">Siete</h3>
				<div align="justify">
					El sitio no será responsables de ningún daño (incluyendo, sin limitación, daños por pédida de datos o ganancias, o debido a la 
					
				</div>
				<hr class="clusterScheduleDivider"/>
				
				<h3 class="legalInformationHeader">Ocho</h3>
				<div align="justify">
					Esperamos que disfrutes de tu estancia en nuestro sitio web. Recuerde que eres un invitado en el sitio web, no olvides actuar con la 
					misma cortesía y respeto que esperarías de otros usuarios. El sitio web siempre se reserva el derecho de rechazar o terminar el servicio. 
					Gracias nuevamente por visitar el sitio web.
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function(){
    	$('[data-toggle="tooltip"]').tooltip();   
	});
</script>