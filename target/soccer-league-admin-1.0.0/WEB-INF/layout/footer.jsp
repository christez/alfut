<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<div class="myJumbotron jumbotron text-right">
	<h2>Síguenos en nuestras redes sociales</h2>
  	<a href="#"><img alt="facebook" src='<c:url value="/resources/images/facebook.png"/>' data-toggle="tooltip" title="Facebook"></a>
  	<a href="#"><img alt="Twitter" src='<c:url value="/resources/images/twitter.png"/>' data-toggle="tooltip" title="Twitter"></a>
  	<a href="#"><img alt="YouTube" src='<c:url value="/resources/images/youtube.png"/>' data-toggle="tooltip" title="YouTube"></a>
</div>

<script>
	$(document).ready(function(){
    	$('[data-toggle="tooltip"]').tooltip();   
	});
</script>