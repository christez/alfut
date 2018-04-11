package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class wiki_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/jsp/../layout/taglib.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_url_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<h1 class=\"mainHeader\" id=\"wikiHeader\">Wiki</h1>\r\n");
      out.write("\r\n");
      out.write("<hr />\r\n");
      out.write("\r\n");
      out.write("<h2 class=\"contentHeader\">Tabla de contenido</h2>\r\n");
      out.write("\r\n");
      out.write("<ol class=\"contentMenu\">\r\n");
      out.write("\t<li>\r\n");
      out.write("        <h3>Ligas</h3>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"#leagueCreate\" class=\"wikiLink\">Crear liga</a></li>\r\n");
      out.write("            <li><a href=\"#leagueModify\" class=\"wikiLink\">Modificar liga</a></li>\r\n");
      out.write("            <li><a href=\"#leagueDelete\" class=\"wikiLink\">Eliminar liga</a></li>\r\n");
      out.write("            <li><a href=\"#leagueTournaments\" class=\"wikiLink\">Administrar torneos</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li>\r\n");
      out.write("        <h3>Torneos</h3>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"#tournamentCreate\" class=\"wikiLink\">Crear torneo</a></li>\r\n");
      out.write("            <li><a href=\"#tournamentModify\" class=\"wikiLink\">Modificar torneo</a></li>\r\n");
      out.write("            <li><a href=\"#tournamentDelete\" class=\"wikiLink\">Eliminar torneo</a></li>\r\n");
      out.write("            <li><a href=\"#tournamentTeams\" class=\"wikiLink\">Administrar equipos</a></li>\r\n");
      out.write("            <li><a href=\"#tournamentClusters\" class=\"wikiLink\">Administrar grupos</a></li>\r\n");
      out.write("            <li><a href=\"#tournamentSchedules\" class=\"wikiLink\">Administrar Jornadas</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li>\r\n");
      out.write("        <h3>Equipos</h3>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"#teamCreate\" class=\"wikiLink\">Crear equipo</a></li>\r\n");
      out.write("            <li><a href=\"#teamModify\" class=\"wikiLink\">Modificar equipo</a></li>\r\n");
      out.write("            <li><a href=\"#teamDelete\" class=\"wikiLink\">Eliminar equipo</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li>\r\n");
      out.write("        <h3>Grupos</h3>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"#clusterCreate\" class=\"wikiLink\">Crear grupo</a></li>\r\n");
      out.write("            <li><a href=\"#clusterModify\" class=\"wikiLink\">Modificar grupo</a></li>\r\n");
      out.write("            <li><a href=\"#clusterDelete\" class=\"wikiLink\">Eliminar grupo</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li>\r\n");
      out.write("        <h3>Jornadas</h3>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"#scheduleGenerate\" class=\"wikiLink\">Generar jornadas</a></li>\r\n");
      out.write("            <li><a href=\"#schedulePlayoffs\" class=\"wikiLink\">Rondas de eliminación directa</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li>\r\n");
      out.write("        <h3>Enfrentamientos</h3>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"#matchModify\" class=\"wikiLink\">Modificar enfrentamientos</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li>\r\n");
      out.write("        <h3>Noticias</h3>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"#newsCreate\" class=\"wikiLink\">Crear noticia</a></li>\r\n");
      out.write("            <li><a href=\"#newsModify\" class=\"wikiLink\">Modificar noticia</a></li>\r\n");
      out.write("            <li><a href=\"#newsDelete\" class=\"wikiLink\">Eliminar noticia</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li>\r\n");
      out.write("        <h3>Cuenta</h3>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"#accountModify\" class=\"wikiLink\">Modificar cuenta</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li>\r\n");
      out.write("        <h3>Soporte</h3>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"#supportGenerate\" class=\"wikiLink\">Levantar caso de soporte</a></li>\r\n");
      out.write("            <li><a href=\"#supportClose\" class=\"wikiLink\">Cerrar caso de soporte</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("</ol>\r\n");
      out.write("\r\n");
      out.write("<hr />\r\n");
      out.write("\r\n");
      out.write("<h2 class=\"contentHeader\">1) Ligas</h2>\r\n");
      out.write("\r\n");
      out.write("<div id=\"leagueCreate\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Crear liga</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para crear una liga presiona el botón \"Crear liga\" que se encuentra dentro del menú \"Administrar ligas\". Esto despliega \r\n");
      out.write("\tun cuadro de diálogo que permite ingresar el nombre de la liga así como información adicional que permita hacer tu liga fácil de reconocer:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_0(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<p class=\"wikiDescription\">Al crearse la liga, se mostrará un mensaje de confirmación y podrás comenzar a crear torneos o, en caso de ser \r\n");
      out.write("\tnecesario, modificar la información o eliminar la liga:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_1(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"leagueModify\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Modificar liga</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para modificar una liga presiona el botón \"Modificar\" que se encuentra dentro del menú \"Administrar ligas\". Esto \r\n");
      out.write("\tte enviará a una nueva ventana que te permitirá modificar la información de tu liga:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_2(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<p class=\"wikiDescription\">En esta ventana podrás modificar la información de la liga. Los campos \"Latitud\" y \"Longitud\" podrán ser obtenidos \r\n");
      out.write("\tde la página <a href=\"https://www.google.com.mx/maps\" class=\"btn btn-link wikiLink text-danger\" target=\"_blank\">Google Maps</a>, específicamente de la barra \r\n");
      out.write("\tde dirección:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_3(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"leagueDelete\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Eliminar liga</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para eliminar una liga presiona el botón \"Eliminar\" que se encuentra dentro del menú \"Administrar ligas\". Esto \r\n");
      out.write("\tabrirá un diálogo de confirmación para proceder:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_4(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t\t<p class=\"text-danger\">NOTA: Esto eliminará todos los datos asociados a la liga y no podrán revertirse los cambios</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"leagueTournaments\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Administrar torneos</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para poder administrar torneos dentro de la liga presiona el botón \"Torneos\" que se encuentra dentro del menú \"Administrar ligas\". \r\n");
      out.write("\tEsto te enviará a una nueva ventana que te permitirá crear, modificar y eliminar torneos así como administrar la información relacionada con cado uno de \r\n");
      out.write("\tellos:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_5(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<h2 class=\"contentHeader\">2) Torneos</h2>\r\n");
      out.write("\r\n");
      out.write("<div id=\"tournamentCreate\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Crear torneo</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para crear un torneo presiona el botón \"Crear torneo\". Esto despliega un cuadro de diálogo que permite ingresar el nombre del\r\n");
      out.write("\ttorneo, su descripción y modelo de juego:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_6(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<p class=\"wikiDescription\">Las diferentes modalidades de juego son:</p>\r\n");
      out.write("\t<div class=\"wikiDescription\">\r\n");
      out.write("\t\t<ol>\r\n");
      out.write("\t\t\t<li><strong>Por puntos.</strong> Tipo de torneo sencillo. Puedes definir tantos equipos como desees, estos se enfrentarán en una o dos rondas \r\n");
      out.write("\t\t\ten la modalidad \"Round Robin\", es decir, todos contra todos. Al finalizar los enfrentamientos, el que mayor puntos haya conseguido, será el campeón</li>\r\n");
      out.write("\t\t\t<li><strong>Por puntos más liguilla.</strong> Tipo de torneo compuesto. Puedes definir tantos equipos como desees y cuantos clasifican a la \r\n");
      out.write("\t\t\tsiguiente etapa. Estos se enfrenterán en una o dos rondas en la modalidad \"Round Robin\", es decir, todos contra todos. Al finalizar los \r\n");
      out.write("\t\t\tenfrentamientos, los equipos que hayan clasificado se enfrentaran en rondas eliminatorias para definir al campeón</li>\r\n");
      out.write("\t\t\t<li><strong>Por grupos más liguilla.</strong> Tipo de torneo compuesto. En este torneo debes generar una cierta cantidad de grupos, dependiendo \r\n");
      out.write("\t\t\tde la modalidad en que avanzarán a la ronda de eliminación directa. Dentro de cada grupo puedes definir tantos equipos como desees, los cuales \r\n");
      out.write("\t\t\tse enfrentarán en una o dos rondas en la modalidad \"Round Robin\", es decir, todos contra todos dentro de su grupo. Al finalizar los enfrentamientos, \r\n");
      out.write("\t\t\tlos equipos que hayan clasificado se enfrentaran en rondas eliminatorias para definir al campeón. Por ejemplo, puedes crear dos grupos con ocho \r\n");
      out.write("\t\t\tequipos cada uno y seleccionar si avanzan los mejores de cada grupo, los dos mejores de cada grupos o los cuatro mejores de cada grupo. Dependiendo \r\n");
      out.write("\t\t\tde cuantos equipos avancen, será el número de enfrentamientos de eliminación directa generados</li>\r\n");
      out.write("\t\t\t<li><strong>Por liguilla.</strong> Tipo de torneo sencillo. En este torneo debes generar cierta cantidad de equipos los cuales se enfrentarán\r\n");
      out.write("\t\t\ten rondas eliminatorias para definir al campeón</li>\r\n");
      out.write("\t\t</ol>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<p class=\"text-warning\">NOTA: En esta sección solo se selecciona la modalidad del torneo, el número de rondas y/o de clasificados serán cubiertos en \r\n");
      out.write("\t\tla sección <a href=\"#scheduleGenerate\">Jornadas</a></p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<p class=\"wikiDescription\">Al crearse el torneo, se mostrará un mensaje de confirmación y podrás comenzar a crear equipos y generar las jornadas o, en caso \r\n");
      out.write("\tde ser necesario, modificar la información o eliminar el torneo:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_7(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"tournamentModify\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Modificar torneo</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para modificar un torneo presiona el botón \"Modificar\". Esto te enviará a una nueva ventana que te permitirá modificar la \r\n");
      out.write("\tinformación del torneo:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_8(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<p class=\"wikiDescription\">En esta ventana podrás modificar el nombre y la descripción del torneo. El campo \"Tipo de torneo\" se encuentra deshabilitado \r\n");
      out.write("\tya que podría afectar la funcionalidad del sistema:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_9(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"tournamentDelete\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Eliminar torneo</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para eliminar un torneo presiona el botón \"Eliminar\". Esto abrirá un diálogo de confirmación para proceder:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_10(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t\t<p class=\"text-danger\">NOTA: Esto eliminará todos los datos asociados al torneo y no podrán revertirse los cambios</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"tournamentTeams\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Administrar equipos</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para poder administrar equipos dentro del torneo presiona el botón \"Equipos\". Esto te enviará a una nueva ventana que te \r\n");
      out.write("\tpermitirá crear, modificar y eliminar equipos así como administrar la información relacionada con cado uno de ellos:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_11(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"tournamentClusters\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Administrar grupos</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para poder administrar grupos dentro del torneo presiona el botón \"Grupos\". Esto te enviará a una nueva ventana que te \r\n");
      out.write("\tpermitirá crear, modificar y eliminar grupos así como administrar la información relacionada con cado uno de ellos:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_12(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"tournamentSchedules\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Administrar jornadas</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para poder administrar jornadas dentro del torneo presiona el botón \"Jornadas\". Esto te enviará a una nueva ventana que te \r\n");
      out.write("\tpermitirá crear y modificar jornadas así como administrar la información relacionada con cado uno de ellas:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_13(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<h2 class=\"contentHeader\">3) Equipos</h2>\r\n");
      out.write("\r\n");
      out.write("<div id=\"teamCreate\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Crear equipo</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para crear un equipo presiona el botón \"Crear equipo\". Esto despliega un cuadro de diálogo que permite ingresar el nombre del\r\n");
      out.write("\tequipo:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_14(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<p class=\"wikiDescription\">Al crearse el equipo, se mostrará un mensaje de confirmación y, en caso de ser necesario, se podrá modificar la información o \r\n");
      out.write("\teliminar el equipo:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_15(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"teamModify\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Modificar equipo</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para modificar un equipo presiona el botón \"Modificar\". Esto te enviará a una nueva ventana que te permitirá modificar la \r\n");
      out.write("\tinformación del equipo:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_16(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<p class=\"wikiDescription\">En esta ventana podrás modificar el nombre, juegos jugados, juegos ganados, juegos empatados, juegos perdidos, goles a favor, \r\n");
      out.write("\tgoles en contra, goles de diferencia y puntos del equipo:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_17(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t\t<p class=\"text-warning\">NOTA: Se recomienda no modificar la información a menos que sea absolutamente necesario, el sistema se encarga de actualizar los atributos \r\n");
      out.write("\t\tdel equipo al momento de actualizar los enfrentamientos en el torneo</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"teamDelete\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Eliminar equipo</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para eliminar un equipo presiona el botón \"Eliminar\". Esto abrirá un diálogo de confirmación para proceder:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_18(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t\t<p class=\"text-danger\">NOTA: Esto eliminará todos los datos asociados al equipo y no podrán revertirse los cambios. Solo se podrán eliminar equipos \r\n");
      out.write("\t\tantes de generar las jornadas de enfrentamientos, una vez generadas no será posible eliminar equipos</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<h2 class=\"contentHeader\">4) Grupos</h2>\r\n");
      out.write("\r\n");
      out.write("<div id=\"clusterCreate\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Crear grupo</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para crear un grupo presiona el botón \"Crear grupo\". Esto despliega un cuadro de diálogo que permite ingresar el nombre del\r\n");
      out.write("\tgrupo:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_19(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<p class=\"wikiDescription\">Al crearse el grupo, se mostrará un mensaje de confirmación y se podrán administrar sus equipos o, en caso de ser \r\n");
      out.write("\tnecesario, modificar su información o eliminarse</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_20(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"clusterModify\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Modificar grupos</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Los grupos no se pueden modificar ya que solo cuentan con un único atributo llamado \"nombre\"</p></div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"clusterDelete\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Eliminar grupos</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para eliminar un grupo presiona el botón \"Eliminar\". Esto abrirá un diálogo de confirmación para proceder:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_21(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t\t<p class=\"text-danger\">NOTA: Esto eliminará todos los datos asociados al grupo y no podrán revertirse los cambios. Solo se podrán eliminar grupos \r\n");
      out.write("\t\tantes de generar las jornadas de enfrentamientos, una vez generadas no será posible eliminarlos</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<h2 class=\"contentHeader\">5) Jornadas</h2>\r\n");
      out.write("\r\n");
      out.write("<div id=\"scheduleGenerate\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Generar jornadas</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para generar las jornadas presiona el botón \"Generar enfrentamientos\". Esto despliega un cuadro de diálogo que permite \r\n");
      out.write("\tseleccionar el modelo de juego del torneo. Dependiendo del tipo de torneo, serán las opciones que mostrará el cuadro de dialogo:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_22(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_23(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_24(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_25(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"wikiDescription\">\r\n");
      out.write("\t\t<ol>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<p><strong>Por puntos</strong></p>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>Esquema: opción que permite definir si el torneo se jugará a una o dos rondas, es decir, si los equipos se enfrentarán \r\n");
      out.write("\t\t\t\t\tuna o dos ocaciones en todo el torneo para definir al campeón</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<p><strong>Por puntos más liguilla</strong></p>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>Esquema: opción que permite definir si el torneo se jugará a una o dos rondas, es decir, si los equipos se enfrentarán \r\n");
      out.write("\t\t\t\t\tuna o dos ocaciones en todo el torneo</li>\r\n");
      out.write("\t\t\t\t\t<li>Número de clasificados: opción que permite definir el número de equipos clasificados a la ronda de eliminación directa, \r\n");
      out.write("\t\t\t\t\tes decir, si habrá ronda dieciseisavos de final, octavos de final, cuartos de final, semifinales o solo final para definir \r\n");
      out.write("\t\t\t\t\tal campeón</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<p><strong>Por grupos más liguilla</strong></p>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>Esquema: opción que permite definir si el torneo se jugará a una o dos rondas, es decir, si los equipos se enfrentarán \r\n");
      out.write("\t\t\t\t\tuna o dos ocaciones en todo el torneo</li>\r\n");
      out.write("\t\t\t\t\t<li>Reglas de clasificación: opción que permite definir el número de equipos clasificados a la ronda de eliminación directa, \r\n");
      out.write("\t\t\t\t\tes decir, si habrá ronda dieciseisavos de final, octavos de final, cuartos de final, semifinales o solo final para definir \r\n");
      out.write("\t\t\t\t\tal campeón. En este tipo de torneo se deben generar previamente los grupos necesarios para cumplir con las reglas, es decir, \r\n");
      out.write("\t\t\t\t\tno puede haber dieciséis clasificados si solo hay dos grupos con solo cuatro equipos por grupos</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<p><strong>Por liguilla</strong></p>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>En esta modalidad se deben haber creado 2, 4, 8, 16 ó 32 equipos para poder generar las rondas eliminatorias.</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ol>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<p class=\"wikiDescription\">Al generarse las jornadas, se mostrará un mensaje de confirmación y se podrán administrar los horarios y marcadores \r\n");
      out.write("\tde cada uno de los enfrentamientos:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_26(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t\t<p class=\"text-success\">NOTA: Una vez que se han jugado todos los enfrentamientos de la ronda \"Round Robin\", el sistema actualizará automáticamente \r\n");
      out.write("\t\tel estatus del torneo, es decir, si el tipo de torneo es \"Por puntos\", el sistema definirá al campeón en base a los puntos obtenidos, y en caso de \r\n");
      out.write("\t\thaber empate, utilizará como criterios los goles de cada equipo. Para el caso de los torneos con liguillas, el sistema seleccionará automáticamente \r\n");
      out.write("\t\ta los clasificados en base a los puntos obtenidos y los goles de cada equipo</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"schedulePlayoffs\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Rondas de eliminación directa</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Las rondas de eliminación directa solo pueden ser modificadas hasta que se han concluido los enfrentamientos de la ronda \r\n");
      out.write("\t\"Round Robin\". Al modificar los enfrentamientos de eliminación directa, el sistema valida los resultados y avanza al ganador, en caso de haber empate, \r\n");
      out.write("\tel sistema valida la posición en la tabla y clasifica al mejor ubicado durante el torneo:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_27(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<h2 class=\"contentHeader\">6) Enfrentamientos</h2>\r\n");
      out.write("\r\n");
      out.write("<div id=\"matchModify\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Modificar enfrentamientos</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para modificar un enfrentamiento presiona el botón \"Modificar\". Esto te enviará a una nueva ventana que te permitirá \r\n");
      out.write("\tmodificar el horario, el marcador y el estatus del enfrentamiento:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_28(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t\t<p class=\"text-warning\">NOTA: El horario y el marcador del juego pueden ser modificados tantas veces como sea necesario mientras el estatus \r\n");
      out.write("\t\tdel juego sea \"No jugado\". Una vez que el estatus es modificado a \"Jugado\", el enfrentamiento queda deshabilitado para su modificación</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<h2 class=\"contentHeader\">7) Noticias</h2>\r\n");
      out.write("\r\n");
      out.write("<div id=\"newsCreate\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Crear noticia</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para crear una noticia presiona el botón \"Crear noticia\". Esto despliega un cuadro de diálogo que permite ingresar el encabezado, \r\n");
      out.write("\tla información y el tipo de noticia:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_29(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<p class=\"wikiDescription\">Los diferentes tipos de noticia son:</p>\r\n");
      out.write("\t<div class=\"wikiDescription\">\r\n");
      out.write("\t\t<ol>\r\n");
      out.write("\t\t\t<li><strong>Informativa.</strong> Tipo de notica diseñada para notificar a los usuarios algún tema no crítico referente a tus ligas y torneos</li>\r\n");
      out.write("\t\t\t<li><strong>Advertencia.</strong> Tipo de noticia diseñada para prevenir a los usuarios de algún tema moderadamente crítico referente a tus ligas \r\n");
      out.write("\t\t\ty torneos</li>\r\n");
      out.write("\t\t\t<li><strong>Importante.</strong> Tipo de noticia diseñada para indicar a los usuarios alguna situación crítica referente a tus ligas y torneos</li>\r\n");
      out.write("\t\t</ol>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<p class=\"wikiDescription\">Al crearse la noticia, se mostrará un mensaje de confirmación, y en caso de ser necesario, podrás modificar la información o \r\n");
      out.write("\teliminar la noticia:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_30(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"newsModify\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Modificar noticia</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para modificar una noticia presiona el botón \"Modificar\". Esto te enviará a una nueva ventana que te permitirá modificar la \r\n");
      out.write("\tnoticia:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_31(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<p class=\"wikiDescription\">En esta ventana podrás modificar la información de la noticia:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_32(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"newsDelete\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Eliminar noticia</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para eliminar una noticia presiona el botón \"Eliminar\". Esto abrirá un diálogo de confirmación para proceder:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_33(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t\t<p class=\"text-danger\">NOTA: Esto eliminará todos los datos asociados a la noticia y no podrán revertirse los cambios</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<h2 class=\"contentHeader\">8) Modificar cuenta</h2>\r\n");
      out.write("\r\n");
      out.write("<div id=\"accountModify\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Modificar cuenta</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Ventana que permite modificar la cuenta de usuario:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_34(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<h2 class=\"contentHeader\">9) Soporte</h2>\r\n");
      out.write("\r\n");
      out.write("<div id=\"supportGenerate\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Levantar caso de soporte</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Para levantar un caso de soporte presiona el botón \"Levantar caso\". Esto despliega un cuadro de diálogo que permite ingresar \r\n");
      out.write("\tel título, el mensaje y la urgencia del caso:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_35(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<p class=\"wikiDescription\">Al levantarse el caso se mostrará un mensaje de confirmación. El caso será revisado y contestado lo más pronto posible, cuando se \r\n");
      out.write("\tcuenta con información respecto a la solución, se enviará un mensaje que se mostrará en la sección \"Mis respuestas\". Si la solución presentada no resuleve \r\n");
      out.write("\tdel todo la problemática presentada, es posible enviar nuevamente un mensaje con un nivel mayor de detalle:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_36(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"supportClose\" class=\"wikiContainer\">\r\n");
      out.write("\t<h4 class=\"wikiHeader\">Cerrar caso de soporte</h4>\r\n");
      out.write("\t<a href=\"#wikiHeader\" class=\"wikiLink\">Inicio</a>\r\n");
      out.write("\t<p class=\"wikiDescription\">Una vez resuelto el problema se podrá cerrar el caso presionando el botón \"Cerrar\". Esto abrirá un diálogo de confirmación para \r\n");
      out.write("\tproceder:</p>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<img alt=\"wikiInfo\" src='");
      if (_jspx_meth_c_url_37(_jspx_page_context))
        return;
      out.write("' class=\"wikiImage\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent(null);
    _jspx_th_c_url_0.setValue("/resources/images/leagueCreate.png");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
    return false;
  }

  private boolean _jspx_meth_c_url_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_1.setPageContext(_jspx_page_context);
    _jspx_th_c_url_1.setParent(null);
    _jspx_th_c_url_1.setValue("/resources/images/leagueInfo.png");
    int _jspx_eval_c_url_1 = _jspx_th_c_url_1.doStartTag();
    if (_jspx_th_c_url_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_1);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_1);
    return false;
  }

  private boolean _jspx_meth_c_url_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_2.setPageContext(_jspx_page_context);
    _jspx_th_c_url_2.setParent(null);
    _jspx_th_c_url_2.setValue("/resources/images/leagueModify.png");
    int _jspx_eval_c_url_2 = _jspx_th_c_url_2.doStartTag();
    if (_jspx_th_c_url_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_2);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_2);
    return false;
  }

  private boolean _jspx_meth_c_url_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_3.setPageContext(_jspx_page_context);
    _jspx_th_c_url_3.setParent(null);
    _jspx_th_c_url_3.setValue("/resources/images/leagueDetail.png");
    int _jspx_eval_c_url_3 = _jspx_th_c_url_3.doStartTag();
    if (_jspx_th_c_url_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_3);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_3);
    return false;
  }

  private boolean _jspx_meth_c_url_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_4.setPageContext(_jspx_page_context);
    _jspx_th_c_url_4.setParent(null);
    _jspx_th_c_url_4.setValue("/resources/images/leagueModify.png");
    int _jspx_eval_c_url_4 = _jspx_th_c_url_4.doStartTag();
    if (_jspx_th_c_url_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_4);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_4);
    return false;
  }

  private boolean _jspx_meth_c_url_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_5 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_5.setPageContext(_jspx_page_context);
    _jspx_th_c_url_5.setParent(null);
    _jspx_th_c_url_5.setValue("/resources/images/leagueModify.png");
    int _jspx_eval_c_url_5 = _jspx_th_c_url_5.doStartTag();
    if (_jspx_th_c_url_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_5);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_5);
    return false;
  }

  private boolean _jspx_meth_c_url_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_6 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_6.setPageContext(_jspx_page_context);
    _jspx_th_c_url_6.setParent(null);
    _jspx_th_c_url_6.setValue("/resources/images/tournamentCreate.png");
    int _jspx_eval_c_url_6 = _jspx_th_c_url_6.doStartTag();
    if (_jspx_th_c_url_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_6);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_6);
    return false;
  }

  private boolean _jspx_meth_c_url_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_7 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_7.setPageContext(_jspx_page_context);
    _jspx_th_c_url_7.setParent(null);
    _jspx_th_c_url_7.setValue("/resources/images/tournamentInfo.png");
    int _jspx_eval_c_url_7 = _jspx_th_c_url_7.doStartTag();
    if (_jspx_th_c_url_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_7);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_7);
    return false;
  }

  private boolean _jspx_meth_c_url_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_8 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_8.setPageContext(_jspx_page_context);
    _jspx_th_c_url_8.setParent(null);
    _jspx_th_c_url_8.setValue("/resources/images/tournamentModify.png");
    int _jspx_eval_c_url_8 = _jspx_th_c_url_8.doStartTag();
    if (_jspx_th_c_url_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_8);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_8);
    return false;
  }

  private boolean _jspx_meth_c_url_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_9 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_9.setPageContext(_jspx_page_context);
    _jspx_th_c_url_9.setParent(null);
    _jspx_th_c_url_9.setValue("/resources/images/tournamentDetail.png");
    int _jspx_eval_c_url_9 = _jspx_th_c_url_9.doStartTag();
    if (_jspx_th_c_url_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_9);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_9);
    return false;
  }

  private boolean _jspx_meth_c_url_10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_10 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_10.setPageContext(_jspx_page_context);
    _jspx_th_c_url_10.setParent(null);
    _jspx_th_c_url_10.setValue("/resources/images/tournamentModify.png");
    int _jspx_eval_c_url_10 = _jspx_th_c_url_10.doStartTag();
    if (_jspx_th_c_url_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_10);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_10);
    return false;
  }

  private boolean _jspx_meth_c_url_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_11 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_11.setPageContext(_jspx_page_context);
    _jspx_th_c_url_11.setParent(null);
    _jspx_th_c_url_11.setValue("/resources/images/tournamentModify.png");
    int _jspx_eval_c_url_11 = _jspx_th_c_url_11.doStartTag();
    if (_jspx_th_c_url_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_11);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_11);
    return false;
  }

  private boolean _jspx_meth_c_url_12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_12 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_12.setPageContext(_jspx_page_context);
    _jspx_th_c_url_12.setParent(null);
    _jspx_th_c_url_12.setValue("/resources/images/tournamentModifyCluster.png");
    int _jspx_eval_c_url_12 = _jspx_th_c_url_12.doStartTag();
    if (_jspx_th_c_url_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_12);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_12);
    return false;
  }

  private boolean _jspx_meth_c_url_13(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_13 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_13.setPageContext(_jspx_page_context);
    _jspx_th_c_url_13.setParent(null);
    _jspx_th_c_url_13.setValue("/resources/images/tournamentModify.png");
    int _jspx_eval_c_url_13 = _jspx_th_c_url_13.doStartTag();
    if (_jspx_th_c_url_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_13);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_13);
    return false;
  }

  private boolean _jspx_meth_c_url_14(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_14 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_14.setPageContext(_jspx_page_context);
    _jspx_th_c_url_14.setParent(null);
    _jspx_th_c_url_14.setValue("/resources/images/teamCreate.png");
    int _jspx_eval_c_url_14 = _jspx_th_c_url_14.doStartTag();
    if (_jspx_th_c_url_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_14);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_14);
    return false;
  }

  private boolean _jspx_meth_c_url_15(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_15 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_15.setPageContext(_jspx_page_context);
    _jspx_th_c_url_15.setParent(null);
    _jspx_th_c_url_15.setValue("/resources/images/teamInfo.png");
    int _jspx_eval_c_url_15 = _jspx_th_c_url_15.doStartTag();
    if (_jspx_th_c_url_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_15);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_15);
    return false;
  }

  private boolean _jspx_meth_c_url_16(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_16 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_16.setPageContext(_jspx_page_context);
    _jspx_th_c_url_16.setParent(null);
    _jspx_th_c_url_16.setValue("/resources/images/teamModify.png");
    int _jspx_eval_c_url_16 = _jspx_th_c_url_16.doStartTag();
    if (_jspx_th_c_url_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_16);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_16);
    return false;
  }

  private boolean _jspx_meth_c_url_17(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_17 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_17.setPageContext(_jspx_page_context);
    _jspx_th_c_url_17.setParent(null);
    _jspx_th_c_url_17.setValue("/resources/images/teamDetail.png");
    int _jspx_eval_c_url_17 = _jspx_th_c_url_17.doStartTag();
    if (_jspx_th_c_url_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_17);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_17);
    return false;
  }

  private boolean _jspx_meth_c_url_18(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_18 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_18.setPageContext(_jspx_page_context);
    _jspx_th_c_url_18.setParent(null);
    _jspx_th_c_url_18.setValue("/resources/images/teamModify.png");
    int _jspx_eval_c_url_18 = _jspx_th_c_url_18.doStartTag();
    if (_jspx_th_c_url_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_18);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_18);
    return false;
  }

  private boolean _jspx_meth_c_url_19(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_19 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_19.setPageContext(_jspx_page_context);
    _jspx_th_c_url_19.setParent(null);
    _jspx_th_c_url_19.setValue("/resources/images/clusterCreate.png");
    int _jspx_eval_c_url_19 = _jspx_th_c_url_19.doStartTag();
    if (_jspx_th_c_url_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_19);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_19);
    return false;
  }

  private boolean _jspx_meth_c_url_20(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_20 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_20.setPageContext(_jspx_page_context);
    _jspx_th_c_url_20.setParent(null);
    _jspx_th_c_url_20.setValue("/resources/images/clusterInfo.png");
    int _jspx_eval_c_url_20 = _jspx_th_c_url_20.doStartTag();
    if (_jspx_th_c_url_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_20);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_20);
    return false;
  }

  private boolean _jspx_meth_c_url_21(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_21 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_21.setPageContext(_jspx_page_context);
    _jspx_th_c_url_21.setParent(null);
    _jspx_th_c_url_21.setValue("/resources/images/clusterInfo.png");
    int _jspx_eval_c_url_21 = _jspx_th_c_url_21.doStartTag();
    if (_jspx_th_c_url_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_21);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_21);
    return false;
  }

  private boolean _jspx_meth_c_url_22(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_22 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_22.setPageContext(_jspx_page_context);
    _jspx_th_c_url_22.setParent(null);
    _jspx_th_c_url_22.setValue("/resources/images/scheduleGeneratePoints.png");
    int _jspx_eval_c_url_22 = _jspx_th_c_url_22.doStartTag();
    if (_jspx_th_c_url_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_22);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_22);
    return false;
  }

  private boolean _jspx_meth_c_url_23(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_23 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_23.setPageContext(_jspx_page_context);
    _jspx_th_c_url_23.setParent(null);
    _jspx_th_c_url_23.setValue("/resources/images/scheduleGeneratePlayoffs.png");
    int _jspx_eval_c_url_23 = _jspx_th_c_url_23.doStartTag();
    if (_jspx_th_c_url_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_23);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_23);
    return false;
  }

  private boolean _jspx_meth_c_url_24(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_24 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_24.setPageContext(_jspx_page_context);
    _jspx_th_c_url_24.setParent(null);
    _jspx_th_c_url_24.setValue("/resources/images/scheduleGenerateClusters.png");
    int _jspx_eval_c_url_24 = _jspx_th_c_url_24.doStartTag();
    if (_jspx_th_c_url_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_24);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_24);
    return false;
  }

  private boolean _jspx_meth_c_url_25(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_25 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_25.setPageContext(_jspx_page_context);
    _jspx_th_c_url_25.setParent(null);
    _jspx_th_c_url_25.setValue("/resources/images/scheduleGeneratePlayoffsOnly.png");
    int _jspx_eval_c_url_25 = _jspx_th_c_url_25.doStartTag();
    if (_jspx_th_c_url_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_25);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_25);
    return false;
  }

  private boolean _jspx_meth_c_url_26(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_26 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_26.setPageContext(_jspx_page_context);
    _jspx_th_c_url_26.setParent(null);
    _jspx_th_c_url_26.setValue("/resources/images/scheduleInfo.png");
    int _jspx_eval_c_url_26 = _jspx_th_c_url_26.doStartTag();
    if (_jspx_th_c_url_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_26);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_26);
    return false;
  }

  private boolean _jspx_meth_c_url_27(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_27 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_27.setPageContext(_jspx_page_context);
    _jspx_th_c_url_27.setParent(null);
    _jspx_th_c_url_27.setValue("/resources/images/schedulePlayoffs.png");
    int _jspx_eval_c_url_27 = _jspx_th_c_url_27.doStartTag();
    if (_jspx_th_c_url_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_27);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_27);
    return false;
  }

  private boolean _jspx_meth_c_url_28(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_28 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_28.setPageContext(_jspx_page_context);
    _jspx_th_c_url_28.setParent(null);
    _jspx_th_c_url_28.setValue("/resources/images/matchModify.png");
    int _jspx_eval_c_url_28 = _jspx_th_c_url_28.doStartTag();
    if (_jspx_th_c_url_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_28);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_28);
    return false;
  }

  private boolean _jspx_meth_c_url_29(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_29 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_29.setPageContext(_jspx_page_context);
    _jspx_th_c_url_29.setParent(null);
    _jspx_th_c_url_29.setValue("/resources/images/newsCreate.png");
    int _jspx_eval_c_url_29 = _jspx_th_c_url_29.doStartTag();
    if (_jspx_th_c_url_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_29);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_29);
    return false;
  }

  private boolean _jspx_meth_c_url_30(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_30 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_30.setPageContext(_jspx_page_context);
    _jspx_th_c_url_30.setParent(null);
    _jspx_th_c_url_30.setValue("/resources/images/newsInfo.png");
    int _jspx_eval_c_url_30 = _jspx_th_c_url_30.doStartTag();
    if (_jspx_th_c_url_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_30);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_30);
    return false;
  }

  private boolean _jspx_meth_c_url_31(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_31 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_31.setPageContext(_jspx_page_context);
    _jspx_th_c_url_31.setParent(null);
    _jspx_th_c_url_31.setValue("/resources/images/newsInfo.png");
    int _jspx_eval_c_url_31 = _jspx_th_c_url_31.doStartTag();
    if (_jspx_th_c_url_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_31);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_31);
    return false;
  }

  private boolean _jspx_meth_c_url_32(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_32 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_32.setPageContext(_jspx_page_context);
    _jspx_th_c_url_32.setParent(null);
    _jspx_th_c_url_32.setValue("/resources/images/newsDetail.png");
    int _jspx_eval_c_url_32 = _jspx_th_c_url_32.doStartTag();
    if (_jspx_th_c_url_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_32);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_32);
    return false;
  }

  private boolean _jspx_meth_c_url_33(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_33 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_33.setPageContext(_jspx_page_context);
    _jspx_th_c_url_33.setParent(null);
    _jspx_th_c_url_33.setValue("/resources/images/newsInfo.png");
    int _jspx_eval_c_url_33 = _jspx_th_c_url_33.doStartTag();
    if (_jspx_th_c_url_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_33);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_33);
    return false;
  }

  private boolean _jspx_meth_c_url_34(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_34 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_34.setPageContext(_jspx_page_context);
    _jspx_th_c_url_34.setParent(null);
    _jspx_th_c_url_34.setValue("/resources/images/accountModify.png");
    int _jspx_eval_c_url_34 = _jspx_th_c_url_34.doStartTag();
    if (_jspx_th_c_url_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_34);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_34);
    return false;
  }

  private boolean _jspx_meth_c_url_35(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_35 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_35.setPageContext(_jspx_page_context);
    _jspx_th_c_url_35.setParent(null);
    _jspx_th_c_url_35.setValue("/resources/images/supportGenerate.png");
    int _jspx_eval_c_url_35 = _jspx_th_c_url_35.doStartTag();
    if (_jspx_th_c_url_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_35);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_35);
    return false;
  }

  private boolean _jspx_meth_c_url_36(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_36 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_36.setPageContext(_jspx_page_context);
    _jspx_th_c_url_36.setParent(null);
    _jspx_th_c_url_36.setValue("/resources/images/supportInfo.png");
    int _jspx_eval_c_url_36 = _jspx_th_c_url_36.doStartTag();
    if (_jspx_th_c_url_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_36);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_36);
    return false;
  }

  private boolean _jspx_meth_c_url_37(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_37 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_37.setPageContext(_jspx_page_context);
    _jspx_th_c_url_37.setParent(null);
    _jspx_th_c_url_37.setValue("/resources/images/supportInfo.png");
    int _jspx_eval_c_url_37 = _jspx_th_c_url_37.doStartTag();
    if (_jspx_th_c_url_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_37);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_37);
    return false;
  }
}
