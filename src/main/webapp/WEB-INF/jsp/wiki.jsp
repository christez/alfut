<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader" id="wikiHeader">Wiki</h1>

<hr />

<h2 class="contentHeader">Tabla de contenido</h2>

<ol class="contentMenu">
	<li>
        <h3>Ligas</h3>
        <ul>
            <li><a href="#leagueCreate" class="wikiLink">Crear liga</a></li>
            <li><a href="#leagueModify" class="wikiLink">Modificar liga</a></li>
            <li><a href="#leagueDelete" class="wikiLink">Eliminar liga</a></li>
            <li><a href="#leagueTournaments" class="wikiLink">Administrar torneos</a></li>
        </ul>
    </li>
    <li>
        <h3>Torneos</h3>
        <ul>
            <li><a href="#tournamentCreate" class="wikiLink">Crear torneo</a></li>
            <li><a href="#tournamentModify" class="wikiLink">Modificar torneo</a></li>
            <li><a href="#tournamentDelete" class="wikiLink">Eliminar torneo</a></li>
            <li><a href="#tournamentTeams" class="wikiLink">Administrar equipos</a></li>
            <li><a href="#tournamentClusters" class="wikiLink">Administrar grupos</a></li>
            <li><a href="#tournamentSchedules" class="wikiLink">Administrar Jornadas</a></li>
        </ul>
    </li>
    <li>
        <h3>Equipos</h3>
        <ul>
            <li><a href="#teamCreate" class="wikiLink">Crear equipo</a></li>
            <li><a href="#teamModify" class="wikiLink">Modificar equipo</a></li>
            <li><a href="#teamDelete" class="wikiLink">Eliminar equipo</a></li>
        </ul>
    </li>
    <li>
        <h3>Grupos</h3>
        <ul>
            <li><a href="#clusterCreate" class="wikiLink">Crear grupo</a></li>
            <li><a href="#clusterModify" class="wikiLink">Modificar grupo</a></li>
            <li><a href="#clusterDelete" class="wikiLink">Eliminar grupo</a></li>
        </ul>
    </li>
    <li>
        <h3>Jornadas</h3>
        <ul>
            <li><a href="#scheduleGenerate" class="wikiLink">Generar jornadas</a></li>
            <li><a href="#schedulePlayoffs" class="wikiLink">Rondas de eliminación directa</a></li>
        </ul>
    </li>
    <li>
        <h3>Enfrentamientos</h3>
        <ul>
            <li><a href="#matchModify" class="wikiLink">Modificar enfrentamientos</a></li>
        </ul>
    </li>
    <li>
        <h3>Noticias</h3>
        <ul>
            <li><a href="#newsCreate" class="wikiLink">Crear noticia</a></li>
            <li><a href="#newsModify" class="wikiLink">Modificar noticia</a></li>
            <li><a href="#newsDelete" class="wikiLink">Eliminar noticia</a></li>
        </ul>
    </li>
    <li>
        <h3>Cuenta</h3>
        <ul>
            <li><a href="#accountModify" class="wikiLink">Modificar cuenta</a></li>
        </ul>
    </li>
    <li>
        <h3>Soporte</h3>
        <ul>
            <li><a href="#supportGenerate" class="wikiLink">Levantar caso de soporte</a></li>
            <li><a href="#supportClose" class="wikiLink">Cerrar caso de soporte</a></li>
        </ul>
    </li>
</ol>

<hr />

<h2 class="contentHeader">1) Ligas</h2>

<div id="leagueCreate" class="wikiContainer">
	<h4 class="wikiHeader">Crear liga</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para crear una liga presiona el botón "Crear liga" que se encuentra dentro del menú "Administrar ligas". Esto despliega 
	un cuadro de diálogo que permite ingresar el nombre de la liga así como información adicional que permita hacer tu liga fácil de reconocer:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/leagueCreate.png"/>' class="wikiImage">
	</div>
	<p class="wikiDescription">Al crearse la liga, se mostrará un mensaje de confirmación y podrás comenzar a crear torneos o, en caso de ser 
	necesario, modificar la información o eliminar la liga:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/leagueInfo.png"/>' class="wikiImage">
	</div>
</div>

<div id="leagueModify" class="wikiContainer">
	<h4 class="wikiHeader">Modificar liga</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para modificar una liga presiona el botón "Modificar" que se encuentra dentro del menú "Administrar ligas". Esto 
	te enviará a una nueva ventana que te permitirá modificar la información de tu liga:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/leagueModify.png"/>' class="wikiImage">
	</div>
	<p class="wikiDescription">En esta ventana podrás modificar la información de la liga. Los campos "Latitud" y "Longitud" podrán ser obtenidos 
	de la página <a href="https://www.google.com.mx/maps" class="btn btn-link wikiLink text-danger" target="_blank">Google Maps</a>, específicamente de la barra 
	de dirección:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/leagueDetail.png"/>' class="wikiImage">
	</div>
</div>

<div id="leagueDelete" class="wikiContainer">
	<h4 class="wikiHeader">Eliminar liga</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para eliminar una liga presiona el botón "Eliminar" que se encuentra dentro del menú "Administrar ligas". Esto 
	abrirá un diálogo de confirmación para proceder:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/leagueModify.png"/>' class="wikiImage">
		<p class="text-danger">NOTA: Esto eliminará todos los datos asociados a la liga y no podrán revertirse los cambios</p>
	</div>
</div>

<div id="leagueTournaments" class="wikiContainer">
	<h4 class="wikiHeader">Administrar torneos</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para poder administrar torneos dentro de la liga presiona el botón "Torneos" que se encuentra dentro del menú "Administrar ligas". 
	Esto te enviará a una nueva ventana que te permitirá crear, modificar y eliminar torneos así como administrar la información relacionada con cado uno de 
	ellos:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/leagueModify.png"/>' class="wikiImage">
	</div>
</div>

<h2 class="contentHeader">2) Torneos</h2>

<div id="tournamentCreate" class="wikiContainer">
	<h4 class="wikiHeader">Crear torneo</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para crear un torneo presiona el botón "Crear torneo". Esto despliega un cuadro de diálogo que permite ingresar el nombre del
	torneo, su descripción y modelo de juego:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/tournamentCreate.png"/>' class="wikiImage">
	</div>
	<p class="wikiDescription">Las diferentes modalidades de juego son:</p>
	<div class="wikiDescription">
		<ol>
			<li><strong>Por puntos.</strong> Tipo de torneo sencillo. Puedes definir tantos equipos como desees, estos se enfrentarán en una o dos rondas 
			en la modalidad "Round Robin", es decir, todos contra todos. Al finalizar los enfrentamientos, el que mayor puntos haya conseguido, será el campeón</li>
			<li><strong>Por puntos más liguilla.</strong> Tipo de torneo compuesto. Puedes definir tantos equipos como desees y cuantos clasifican a la 
			siguiente etapa. Estos se enfrenterán en una o dos rondas en la modalidad "Round Robin", es decir, todos contra todos. Al finalizar los 
			enfrentamientos, los equipos que hayan clasificado se enfrentaran en rondas eliminatorias para definir al campeón</li>
			<li><strong>Por grupos más liguilla.</strong> Tipo de torneo compuesto. En este torneo debes generar una cierta cantidad de grupos, dependiendo 
			de la modalidad en que avanzarán a la ronda de eliminación directa. Dentro de cada grupo puedes definir tantos equipos como desees, los cuales 
			se enfrentarán en una o dos rondas en la modalidad "Round Robin", es decir, todos contra todos dentro de su grupo. Al finalizar los enfrentamientos, 
			los equipos que hayan clasificado se enfrentaran en rondas eliminatorias para definir al campeón. Por ejemplo, puedes crear dos grupos con ocho 
			equipos cada uno y seleccionar si avanzan los mejores de cada grupo, los dos mejores de cada grupos o los cuatro mejores de cada grupo. Dependiendo 
			de cuantos equipos avancen, será el número de enfrentamientos de eliminación directa generados</li>
			<li><strong>Por liguilla.</strong> Tipo de torneo sencillo. En este torneo debes generar cierta cantidad de equipos los cuales se enfrentarán
			en rondas eliminatorias para definir al campeón</li>
		</ol>
	</div>
	<div align="center">
		<p class="text-warning">NOTA: En esta sección solo se selecciona la modalidad del torneo, el número de rondas y/o de clasificados serán cubiertos en 
		la sección <a href="#scheduleGenerate">Jornadas</a></p>
	</div>
	<p class="wikiDescription">Al crearse el torneo, se mostrará un mensaje de confirmación y podrás comenzar a crear equipos y generar las jornadas o, en caso 
	de ser necesario, modificar la información o eliminar el torneo:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/tournamentInfo.png"/>' class="wikiImage">
	</div>
</div>

<div id="tournamentModify" class="wikiContainer">
	<h4 class="wikiHeader">Modificar torneo</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para modificar un torneo presiona el botón "Modificar". Esto te enviará a una nueva ventana que te permitirá modificar la 
	información del torneo:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/tournamentModify.png"/>' class="wikiImage">
	</div>
	<p class="wikiDescription">En esta ventana podrás modificar el nombre y la descripción del torneo. El campo "Tipo de torneo" se encuentra deshabilitado 
	ya que podría afectar la funcionalidad del sistema:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/tournamentDetail.png"/>' class="wikiImage">
	</div>
</div>

<div id="tournamentDelete" class="wikiContainer">
	<h4 class="wikiHeader">Eliminar torneo</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para eliminar un torneo presiona el botón "Eliminar". Esto abrirá un diálogo de confirmación para proceder:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/tournamentModify.png"/>' class="wikiImage">
		<p class="text-danger">NOTA: Esto eliminará todos los datos asociados al torneo y no podrán revertirse los cambios</p>
	</div>
</div>

<div id="tournamentTeams" class="wikiContainer">
	<h4 class="wikiHeader">Administrar equipos</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para poder administrar equipos dentro del torneo presiona el botón "Equipos". Esto te enviará a una nueva ventana que te 
	permitirá crear, modificar y eliminar equipos así como administrar la información relacionada con cado uno de ellos:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/tournamentModify.png"/>' class="wikiImage">
	</div>
</div>

<div id="tournamentClusters" class="wikiContainer">
	<h4 class="wikiHeader">Administrar grupos</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para poder administrar grupos dentro del torneo presiona el botón "Grupos". Esto te enviará a una nueva ventana que te 
	permitirá crear, modificar y eliminar grupos así como administrar la información relacionada con cado uno de ellos:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/tournamentModifyCluster.png"/>' class="wikiImage">
	</div>
</div>

<div id="tournamentSchedules" class="wikiContainer">
	<h4 class="wikiHeader">Administrar jornadas</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para poder administrar jornadas dentro del torneo presiona el botón "Jornadas". Esto te enviará a una nueva ventana que te 
	permitirá crear y modificar jornadas así como administrar la información relacionada con cado uno de ellas:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/tournamentModify.png"/>' class="wikiImage">
	</div>
</div>

<h2 class="contentHeader">3) Equipos</h2>

<div id="teamCreate" class="wikiContainer">
	<h4 class="wikiHeader">Crear equipo</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para crear un equipo presiona el botón "Crear equipo". Esto despliega un cuadro de diálogo que permite ingresar el nombre del
	equipo:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/teamCreate.png"/>' class="wikiImage">
	</div>
	<p class="wikiDescription">Al crearse el equipo, se mostrará un mensaje de confirmación y, en caso de ser necesario, se podrá modificar la información o 
	eliminar el equipo:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/teamInfo.png"/>' class="wikiImage">
	</div>
</div>

<div id="teamModify" class="wikiContainer">
	<h4 class="wikiHeader">Modificar equipo</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para modificar un equipo presiona el botón "Modificar". Esto te enviará a una nueva ventana que te permitirá modificar la 
	información del equipo:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/teamModify.png"/>' class="wikiImage">
	</div>
	<p class="wikiDescription">En esta ventana podrás modificar el nombre, juegos jugados, juegos ganados, juegos empatados, juegos perdidos, goles a favor, 
	goles en contra, goles de diferencia y puntos del equipo:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/teamDetail.png"/>' class="wikiImage">
		<p class="text-warning">NOTA: Se recomienda no modificar la información a menos que sea absolutamente necesario, el sistema se encarga de actualizar los atributos 
		del equipo al momento de actualizar los enfrentamientos en el torneo</p>
	</div>
</div>

<div id="teamDelete" class="wikiContainer">
	<h4 class="wikiHeader">Eliminar equipo</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para eliminar un equipo presiona el botón "Eliminar". Esto abrirá un diálogo de confirmación para proceder:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/teamModify.png"/>' class="wikiImage">
		<p class="text-danger">NOTA: Esto eliminará todos los datos asociados al equipo y no podrán revertirse los cambios. Solo se podrán eliminar equipos 
		antes de generar las jornadas de enfrentamientos, una vez generadas no será posible eliminar equipos</p>
	</div>
</div>

<h2 class="contentHeader">4) Grupos</h2>

<div id="clusterCreate" class="wikiContainer">
	<h4 class="wikiHeader">Crear grupo</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para crear un grupo presiona el botón "Crear grupo". Esto despliega un cuadro de diálogo que permite ingresar el nombre del
	grupo:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/clusterCreate.png"/>' class="wikiImage">
	</div>
	<p class="wikiDescription">Al crearse el grupo, se mostrará un mensaje de confirmación y se podrán administrar sus equipos o, en caso de ser 
	necesario, modificar su información o eliminarse</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/clusterInfo.png"/>' class="wikiImage">
	</div>
</div>

<div id="clusterModify" class="wikiContainer">
	<h4 class="wikiHeader">Modificar grupos</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Los grupos no se pueden modificar ya que solo cuentan con un único atributo llamado "nombre"</p></div>

<div id="clusterDelete" class="wikiContainer">
	<h4 class="wikiHeader">Eliminar grupos</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para eliminar un grupo presiona el botón "Eliminar". Esto abrirá un diálogo de confirmación para proceder:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/clusterInfo.png"/>' class="wikiImage">
		<p class="text-danger">NOTA: Esto eliminará todos los datos asociados al grupo y no podrán revertirse los cambios. Solo se podrán eliminar grupos 
		antes de generar las jornadas de enfrentamientos, una vez generadas no será posible eliminarlos</p>
	</div>
</div>

<h2 class="contentHeader">5) Jornadas</h2>

<div id="scheduleGenerate" class="wikiContainer">
	<h4 class="wikiHeader">Generar jornadas</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para generar las jornadas presiona el botón "Generar enfrentamientos". Esto despliega un cuadro de diálogo que permite 
	seleccionar el modelo de juego del torneo. Dependiendo del tipo de torneo, serán las opciones que mostrará el cuadro de dialogo:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/scheduleGeneratePoints.png"/>' class="wikiImage">
		<br />
		<img alt="wikiInfo" src='<c:url value="/resources/images/scheduleGeneratePlayoffs.png"/>' class="wikiImage">
		<br />
		<img alt="wikiInfo" src='<c:url value="/resources/images/scheduleGenerateClusters.png"/>' class="wikiImage">
		<br />
		<img alt="wikiInfo" src='<c:url value="/resources/images/scheduleGeneratePlayoffsOnly.png"/>' class="wikiImage">
	</div>
	<div class="wikiDescription">
		<ol>
			<li>
				<p><strong>Por puntos</strong></p>
				<ul>
					<li>Esquema: opción que permite definir si el torneo se jugará a una o dos rondas, es decir, si los equipos se enfrentarán 
					una o dos ocaciones en todo el torneo para definir al campeón</li>
				</ul>
			</li>
			<li>
				<p><strong>Por puntos más liguilla</strong></p>
				<ul>
					<li>Esquema: opción que permite definir si el torneo se jugará a una o dos rondas, es decir, si los equipos se enfrentarán 
					una o dos ocaciones en todo el torneo</li>
					<li>Número de clasificados: opción que permite definir el número de equipos clasificados a la ronda de eliminación directa, 
					es decir, si habrá ronda dieciseisavos de final, octavos de final, cuartos de final, semifinales o solo final para definir 
					al campeón</li>
				</ul>
			</li>
			<li>
				<p><strong>Por grupos más liguilla</strong></p>
				<ul>
					<li>Esquema: opción que permite definir si el torneo se jugará a una o dos rondas, es decir, si los equipos se enfrentarán 
					una o dos ocaciones en todo el torneo</li>
					<li>Reglas de clasificación: opción que permite definir el número de equipos clasificados a la ronda de eliminación directa, 
					es decir, si habrá ronda dieciseisavos de final, octavos de final, cuartos de final, semifinales o solo final para definir 
					al campeón. En este tipo de torneo se deben generar previamente los grupos necesarios para cumplir con las reglas, es decir, 
					no puede haber dieciséis clasificados si solo hay dos grupos con solo cuatro equipos por grupos</li>
				</ul>
			</li>
			<li>
				<p><strong>Por liguilla</strong></p>
				<ul>
					<li>En esta modalidad se deben haber creado 2, 4, 8, 16 ó 32 equipos para poder generar las rondas eliminatorias.</li>
				</ul>
			</li>
		</ol>
	</div>
	<p class="wikiDescription">Al generarse las jornadas, se mostrará un mensaje de confirmación y se podrán administrar los horarios y marcadores 
	de cada uno de los enfrentamientos:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/scheduleInfo.png"/>' class="wikiImage">
		<p class="text-success">NOTA: Una vez que se han jugado todos los enfrentamientos de la ronda "Round Robin", el sistema actualizará automáticamente 
		el estatus del torneo, es decir, si el tipo de torneo es "Por puntos", el sistema definirá al campeón en base a los puntos obtenidos, y en caso de 
		haber empate, utilizará como criterios los goles de cada equipo. Para el caso de los torneos con liguillas, el sistema seleccionará automáticamente 
		a los clasificados en base a los puntos obtenidos y los goles de cada equipo</p>
	</div>
</div>

<div id="schedulePlayoffs" class="wikiContainer">
	<h4 class="wikiHeader">Rondas de eliminación directa</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Las rondas de eliminación directa solo pueden ser modificadas hasta que se han concluido los enfrentamientos de la ronda 
	"Round Robin". Al modificar los enfrentamientos de eliminación directa, el sistema valida los resultados y avanza al ganador, en caso de haber empate, 
	el sistema valida la posición en la tabla y clasifica al mejor ubicado durante el torneo:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/schedulePlayoffs.png"/>' class="wikiImage">
	</div>
</div>

<h2 class="contentHeader">6) Enfrentamientos</h2>

<div id="matchModify" class="wikiContainer">
	<h4 class="wikiHeader">Modificar enfrentamientos</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para modificar un enfrentamiento presiona el botón "Modificar". Esto te enviará a una nueva ventana que te permitirá 
	modificar el horario, el marcador y el estatus del enfrentamiento:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/matchModify.png"/>' class="wikiImage">
		<p class="text-warning">NOTA: El horario y el marcador del juego pueden ser modificados tantas veces como sea necesario mientras el estatus 
		del juego sea "No jugado". Una vez que el estatus es modificado a "Jugado", el enfrentamiento queda deshabilitado para su modificación</p>
	</div>
</div>

<h2 class="contentHeader">7) Noticias</h2>

<div id="newsCreate" class="wikiContainer">
	<h4 class="wikiHeader">Crear noticia</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para crear una noticia presiona el botón "Crear noticia". Esto despliega un cuadro de diálogo que permite ingresar el encabezado, 
	la información y el tipo de noticia:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/newsCreate.png"/>' class="wikiImage">
	</div>
	<p class="wikiDescription">Los diferentes tipos de noticia son:</p>
	<div class="wikiDescription">
		<ol>
			<li><strong>Informativa.</strong> Tipo de notica diseñada para notificar a los usuarios algún tema no crítico referente a tus ligas y torneos</li>
			<li><strong>Advertencia.</strong> Tipo de noticia diseñada para prevenir a los usuarios de algún tema moderadamente crítico referente a tus ligas 
			y torneos</li>
			<li><strong>Importante.</strong> Tipo de noticia diseñada para indicar a los usuarios alguna situación crítica referente a tus ligas y torneos</li>
		</ol>
	</div>
	<p class="wikiDescription">Al crearse la noticia, se mostrará un mensaje de confirmación, y en caso de ser necesario, podrás modificar la información o 
	eliminar la noticia:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/newsInfo.png"/>' class="wikiImage">
	</div>
</div>

<div id="newsModify" class="wikiContainer">
	<h4 class="wikiHeader">Modificar noticia</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para modificar una noticia presiona el botón "Modificar". Esto te enviará a una nueva ventana que te permitirá modificar la 
	noticia:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/newsInfo.png"/>' class="wikiImage">
	</div>
	<p class="wikiDescription">En esta ventana podrás modificar la información de la noticia:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/newsDetail.png"/>' class="wikiImage">
	</div>
</div>

<div id="newsDelete" class="wikiContainer">
	<h4 class="wikiHeader">Eliminar noticia</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para eliminar una noticia presiona el botón "Eliminar". Esto abrirá un diálogo de confirmación para proceder:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/newsInfo.png"/>' class="wikiImage">
		<p class="text-danger">NOTA: Esto eliminará todos los datos asociados a la noticia y no podrán revertirse los cambios</p>
	</div>
</div>

<h2 class="contentHeader">8) Modificar cuenta</h2>

<div id="accountModify" class="wikiContainer">
	<h4 class="wikiHeader">Modificar cuenta</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Ventana que permite modificar la cuenta de usuario:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/accountModify.png"/>' class="wikiImage">
	</div>
</div>

<h2 class="contentHeader">9) Soporte</h2>

<div id="supportGenerate" class="wikiContainer">
	<h4 class="wikiHeader">Levantar caso de soporte</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Para levantar un caso de soporte presiona el botón "Levantar caso". Esto despliega un cuadro de diálogo que permite ingresar 
	el título, el mensaje y la urgencia del caso:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/supportGenerate.png"/>' class="wikiImage">
	</div>
	<p class="wikiDescription">Al levantarse el caso se mostrará un mensaje de confirmación. El caso será revisado y contestado lo más pronto posible, cuando se 
	cuenta con información respecto a la solución, se enviará un mensaje que se mostrará en la sección "Mis respuestas". Si la solución presentada no resuleve 
	del todo la problemática presentada, es posible enviar nuevamente un mensaje con un nivel mayor de detalle:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/supportInfo.png"/>' class="wikiImage">
	</div>
</div>

<div id="supportClose" class="wikiContainer">
	<h4 class="wikiHeader">Cerrar caso de soporte</h4>
	<a href="#wikiHeader" class="wikiLink">Inicio</a>
	<p class="wikiDescription">Una vez resuelto el problema se podrá cerrar el caso presionando el botón "Cerrar". Esto abrirá un diálogo de confirmación para 
	proceder:</p>
	<div align="center">
		<img alt="wikiInfo" src='<c:url value="/resources/images/supportInfo.png"/>' class="wikiImage">
	</div>
</div>