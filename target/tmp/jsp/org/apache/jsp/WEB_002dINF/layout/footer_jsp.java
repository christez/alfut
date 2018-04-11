package org.apache.jsp.WEB_002dINF.layout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/layout/../layout/taglib.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_spring_url_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_spring_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_url_value_nobody.release();
    _jspx_tagPool_spring_url_value_nobody.release();
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
      out.write("<div class=\"myJumbotron jumbotron\">\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t\t<div class=\"col-md-4\" align=\"justify\">\r\n");
      out.write("\t\t\t<p><span class=\"myJumbotronSpan\">ALFUT</span> es una aplicación profesional enfocada en la  creación y administración de torneos de Futbol locales.</p>\r\n");
      out.write("\t \t</div>\r\n");
      out.write("\t \t<div class=\"col-md-4\">\r\n");
      out.write("\t \t\t<p class=\"myJumbotronSpan\">Síguenos en nuestras redes sociales</p>\r\n");
      out.write("\t \t\t<a href=\"https://www.facebook.com/Alfut-154186695230940/\" target=\"_blank\"><img alt=\"facebook\" src='");
      if (_jspx_meth_c_url_0(_jspx_page_context))
        return;
      out.write("' data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Facebook\"></a>\r\n");
      out.write("  \t\t\t<a href=\"https://twitter.com/soccerleagueadm\" target=\"_blank\"><img alt=\"Twitter\" src='");
      if (_jspx_meth_c_url_1(_jspx_page_context))
        return;
      out.write("' data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Twitter\"></a>\r\n");
      out.write("  \t\t\t<a href=\"https://www.youtube.com/channel/UCArcKt3jUDcB9hQ88mCItHA\" target=\"_blank\"><img alt=\"YouTube\" src='");
      if (_jspx_meth_c_url_2(_jspx_page_context))
        return;
      out.write("' data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"YouTube\"></a>\r\n");
      out.write("  \t\t\t<br />\r\n");
      out.write("  \t\t\t<br />\r\n");
      out.write("\t \t</div>\r\n");
      out.write("\t \t<div class=\"col-md-2\">\r\n");
      out.write("\t \t\t<p class=\"myJumbotronHeader\">CATEGORÍAS</p>\r\n");
      out.write("\t \t\t<a class=\"footerLink\" href='");
      if (_jspx_meth_spring_url_0(_jspx_page_context))
        return;
      out.write("'>Nuestras ligas</a>\r\n");
      out.write("\t \t\t<br />\r\n");
      out.write("\t \t\t<a class=\"footerLink\" href='");
      if (_jspx_meth_spring_url_1(_jspx_page_context))
        return;
      out.write("'>Ligas del mundo</a>\r\n");
      out.write("\t \t\t<br />\r\n");
      out.write("\t \t\t<a class=\"footerLink\" href='");
      if (_jspx_meth_spring_url_2(_jspx_page_context))
        return;
      out.write("'>Nuestras noticias</a>\r\n");
      out.write("\t \t\t<br />\r\n");
      out.write("\t \t\t<a class=\"footerLink\" href='");
      if (_jspx_meth_spring_url_3(_jspx_page_context))
        return;
      out.write("'>Noticias del mundo</a>\r\n");
      out.write("\t \t\t<br />\r\n");
      out.write("\t \t\t<br />\r\n");
      out.write("\t \t</div>\r\n");
      out.write("\t \t<div class=\"col-md-2\">\r\n");
      out.write("\t \t\t<p class=\"myJumbotronHeader\">EXTRAS</p>\r\n");
      out.write("\t \t\t<a class=\"footerLink\" href='");
      if (_jspx_meth_spring_url_4(_jspx_page_context))
        return;
      out.write("'>Anúnciate</a>\r\n");
      out.write("\t \t\t<br />\r\n");
      out.write("\t \t\t<a class=\"footerLink\" href=\"#legalInformationModal\" data-toggle=\"modal\">Información legal</a>\r\n");
      out.write("\t \t\t<br />\r\n");
      out.write("\t \t\t<a class=\"footerLink\" href=\"#\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Email de contacto: alfut.contacto@gmail.com\">Contacto</a>\r\n");
      out.write("\t \t\t<br />\r\n");
      out.write("\t \t\t<br />\r\n");
      out.write("\t \t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"copyright\" align=\"left\">\r\n");
      out.write("\t<p>© 2018  CHRISTEZ APP COMPANY. Todos los derechos reservados</p>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"legalInformationModal\" class=\"modal fade legalInformation\">\r\n");
      out.write("\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\">Información legal</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<h3 class=\"legalInformationHeader\">Uno</h3>\r\n");
      out.write("\t\t\t\t<div align=\"justify\">\r\n");
      out.write("\t\t\t\t\tAl acceder a este sitio web, aceptas estar obligado por estos términos y condiciones de uso del sitio web, \r\n");
      out.write("\t\t\t\t\ttodas las leyes y regulaciones aplicables y aceptas ser responsable del cumplimiento de las leyes locales aplicables. \r\n");
      out.write("\t\t\t\t\tSi no estás de acuerdo con alguno de estos términos, queda prohibido utilizar o acceder a este sitio. \r\n");
      out.write("\t\t\t\t\tLos materiales contenidos en este sitio web están protegidos por las leyes aplicables de derechos de autor y marcas.\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<hr class=\"clusterScheduleDivider\"/>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<h3 class=\"legalInformationHeader\">Dos</h3>\r\n");
      out.write("\t\t\t\t<div align=\"justify\">\r\n");
      out.write("\t\t\t\t\tLos términos y condiciones del sitio pueden cambiar en cualquier momento. Las modificaciones a estos términos entrarán en vigor \r\n");
      out.write("\t\t\t\t\tinmediatamente después de su publicación en el sitio web. Aceptas y eres responsable de revisar periódicamente este acuerdo para \r\n");
      out.write("\t\t\t\t\tque tengas familiaridad con su contenido. Al continuar utilizando cualquier parte del sitio, significa que aceptas los términos \r\n");
      out.write("\t\t\t\t\tactualizados o revisados. Debes dejar de usar este sitio si no estás de acuerdo con los términos listados.\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<hr class=\"clusterScheduleDivider\"/>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<h3 class=\"legalInformationHeader\">Tres</h3>\r\n");
      out.write("\t\t\t\t<div align=\"justify\">\r\n");
      out.write("\t\t\t\t\tSolo se puede crear una cuenta. Crear una SEGUNDA cuenta es una VIOLACIÓN de los términos y condiciones y podría resultar en la \r\n");
      out.write("\t\t\t\t\tbaja permanente sin previo aviso.\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<hr class=\"clusterScheduleDivider\"/>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<h3 class=\"legalInformationHeader\">Cuatro</h3>\r\n");
      out.write("\t\t\t\t<div align=\"justify\">\r\n");
      out.write("\t\t\t\t\tEl sitio web ofrece servicios de administración de ligas de fútbol gratuitos a los usuarios registrados así como información general\r\n");
      out.write("\t\t\t\t\trelacionada con el mundo del fútbol para el resto de la audiencia.\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<hr class=\"clusterScheduleDivider\"/>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<h3 class=\"legalInformationHeader\">Cinco</h3>\r\n");
      out.write("\t\t\t\t<div align=\"justify\">\r\n");
      out.write("\t\t\t\t\tProtegeremos la información personal mediante medidas de seguridad razonables contra pérdida o robo, así como el acceso no autorizado, \r\n");
      out.write("\t\t\t\t\tdivulgación, copia, uso o modificación. Si nos proporciona su dirección de correo electrónico, acepta que el sitio web lo contacte por esta vía.\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<hr class=\"clusterScheduleDivider\"/>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<h3 class=\"legalInformationHeader\">Seis</h3>\r\n");
      out.write("\t\t\t\t<div align=\"justify\">\r\n");
      out.write("\t\t\t\t\tEl sitio web se reserva el derecho de interrumpir el servicio de vez en cuando para realizar el mantenimiento, de forma regular o de \r\n");
      out.write("\t\t\t\t\tcualquier otra forma con o sin previo aviso. Usted acepta que el sitio web no será responsable de ninguna interrupción del servicio o \r\n");
      out.write("\t\t\t\t\tretraso o falla en el desempeño que resulte de cualquier causa.\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<hr class=\"clusterScheduleDivider\"/>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<h3 class=\"legalInformationHeader\">Siete</h3>\r\n");
      out.write("\t\t\t\t<div align=\"justify\">\r\n");
      out.write("\t\t\t\t\tEl sitio no será responsables de ningún daño (incluyendo, sin limitación, daños por pédida de datos o ganancias, o debido a la \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<hr class=\"clusterScheduleDivider\"/>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<h3 class=\"legalInformationHeader\">Ocho</h3>\r\n");
      out.write("\t\t\t\t<div align=\"justify\">\r\n");
      out.write("\t\t\t\t\tEsperamos que disfrutes de tu estancia en nuestro sitio web. Recuerde que eres un invitado en el sitio web, no olvides actuar con la \r\n");
      out.write("\t\t\t\t\tmisma cortesía y respeto que esperarías de otros usuarios. El sitio web siempre se reserva el derecho de rechazar o terminar el servicio. \r\n");
      out.write("\t\t\t\t\tGracias nuevamente por visitar el sitio web.\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cerrar</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("    \t$('[data-toggle=\"tooltip\"]').tooltip();   \r\n");
      out.write("\t});\r\n");
      out.write("</script>");
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
    _jspx_th_c_url_0.setValue("/resources/images/facebook.png");
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
    _jspx_th_c_url_1.setValue("/resources/images/twitter.png");
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
    _jspx_th_c_url_2.setValue("/resources/images/youtube.png");
    int _jspx_eval_c_url_2 = _jspx_th_c_url_2.doStartTag();
    if (_jspx_th_c_url_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_2);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_2);
    return false;
  }

  private boolean _jspx_meth_spring_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_0 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_0.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_0.setParent(null);
    _jspx_th_spring_url_0.setValue("/open-league.html");
    int[] _jspx_push_body_count_spring_url_0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_0 = _jspx_th_spring_url_0.doStartTag();
      if (_jspx_th_spring_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_0.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_0);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_1 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_1.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_1.setParent(null);
    _jspx_th_spring_url_1.setValue("/open-world-league.html");
    int[] _jspx_push_body_count_spring_url_1 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_1 = _jspx_th_spring_url_1.doStartTag();
      if (_jspx_th_spring_url_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_1.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_1);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_2 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_2.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_2.setParent(null);
    _jspx_th_spring_url_2.setValue("/open-news.html");
    int[] _jspx_push_body_count_spring_url_2 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_2 = _jspx_th_spring_url_2.doStartTag();
      if (_jspx_th_spring_url_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_2.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_2);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_3 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_3.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_3.setParent(null);
    _jspx_th_spring_url_3.setValue("/open-world-new.html");
    int[] _jspx_push_body_count_spring_url_3 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_3 = _jspx_th_spring_url_3.doStartTag();
      if (_jspx_th_spring_url_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_3.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_3);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_4 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_4.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_4.setParent(null);
    _jspx_th_spring_url_4.setValue("/commercial.html");
    int[] _jspx_push_body_count_spring_url_4 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_4 = _jspx_th_spring_url_4.doStartTag();
      if (_jspx_th_spring_url_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_4.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_4);
    }
    return false;
  }
}
