package org.apache.jsp.WEB_002dINF.layout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class template_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/layout/../layout/taglib.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_security_authorize_access;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_spring_url_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_security_authorize_access = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_spring_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_security_authorize_access.release();
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
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"shortcut icon\" href='");
      if (_jspx_meth_c_url_0(_jspx_page_context))
        return;
      out.write("' />\r\n");
      out.write("<link rel=\"stylesheet\" href='");
      if (_jspx_meth_c_url_1(_jspx_page_context))
        return;
      out.write("'>\r\n");
      out.write("<link rel=\"stylesheet\" href='");
      if (_jspx_meth_c_url_2(_jspx_page_context))
        return;
      out.write("'>\r\n");
      out.write("<link rel=\"stylesheet\" href='");
      if (_jspx_meth_c_url_3(_jspx_page_context))
        return;
      out.write("'>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://fonts.googleapis.com/css?family=Comfortaa\">\r\n");
      out.write("<script type=\"text/javascript\" src='");
      if (_jspx_meth_c_url_4(_jspx_page_context))
        return;
      out.write("'></script>\r\n");
      out.write("<script type=\"text/javascript\" src='");
      if (_jspx_meth_c_url_5(_jspx_page_context))
        return;
      out.write("'></script>\r\n");
      out.write("<script type=\"text/javascript\" src='");
      if (_jspx_meth_c_url_6(_jspx_page_context))
        return;
      out.write("'></script>\r\n");
      out.write("<script type=\"text/javascript\" src='");
      if (_jspx_meth_c_url_7(_jspx_page_context))
        return;
      out.write("'></script>\r\n");
      out.write("<title>");
      if (_jspx_meth_tiles_getAsString_0(_jspx_page_context))
        return;
      out.write("</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      //  tilesx:useAttribute
      org.apache.tiles.jsp.taglib.UseAttributeTag _jspx_th_tilesx_useAttribute_0 = (_jspx_resourceInjector != null)? _jspx_resourceInjector.createTagHandlerInstance(org.apache.tiles.jsp.taglib.UseAttributeTag.class) : new org.apache.tiles.jsp.taglib.UseAttributeTag();
      _jspx_th_tilesx_useAttribute_0.setJspContext(_jspx_page_context);
      _jspx_th_tilesx_useAttribute_0.setName("current");
      _jspx_th_tilesx_useAttribute_0.doTag();
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_tilesx_useAttribute_0);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<nav class=\"navbar navbar-default\">\r\n");
      out.write("\t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\r\n");
      out.write("\t\t              \t<span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("\t\t              \t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t              \t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t              \t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t            </button>\r\n");
      out.write("\t\t\t\t\t<a class=\"navbar-brand\" href='");
      if (_jspx_meth_spring_url_0(_jspx_page_context))
        return;
      out.write("'>ALFUT</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"navbar\" class=\"navbar-collapse collapse\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_security_authorize_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_security_authorize_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_security_authorize_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_security_authorize_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_security_authorize_4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_security_authorize_5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t    \t");
      if (_jspx_meth_security_authorize_6(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t    \t");
      if (_jspx_meth_security_authorize_7(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t    \t");
      if (_jspx_meth_security_authorize_8(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t    \t");
      if (_jspx_meth_security_authorize_9(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t    \t");
      if (_jspx_meth_security_authorize_10(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t    \t");
      if (_jspx_meth_security_authorize_11(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t    \t");
      if (_jspx_meth_security_authorize_12(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t    \t");
      if (_jspx_meth_security_authorize_13(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t    \t");
      if (_jspx_meth_security_authorize_14(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t    \t");
      if (_jspx_meth_security_authorize_15(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_security_authorize_16(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t    \t");
      if (_jspx_meth_security_authorize_17(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_tiles_insertAttribute_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<hr />\r\n");
      out.write("\r\n");
      out.write("\t\t<div align=\"center\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_tiles_insertAttribute_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
    _jspx_th_c_url_0.setValue("/resources/images/icon.png");
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
    _jspx_th_c_url_1.setValue("/resources/css/bootstrap.min.css");
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
    _jspx_th_c_url_2.setValue("/resources/css/jquery-ui.css");
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
    _jspx_th_c_url_3.setValue("/resources/css/style.css");
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
    _jspx_th_c_url_4.setValue("/resources/js/jquery.min.js");
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
    _jspx_th_c_url_5.setValue("/resources/js/jquery-ui.js");
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
    _jspx_th_c_url_6.setValue("/resources/js/jquery.validate.min.js");
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
    _jspx_th_c_url_7.setValue("/resources/js/bootstrap.min.js");
    int _jspx_eval_c_url_7 = _jspx_th_c_url_7.doStartTag();
    if (_jspx_th_c_url_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_7);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_7);
    return false;
  }

  private boolean _jspx_meth_tiles_getAsString_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:getAsString
    org.apache.tiles.jsp.taglib.GetAsStringTag _jspx_th_tiles_getAsString_0 = (_jspx_resourceInjector != null)? _jspx_resourceInjector.createTagHandlerInstance(org.apache.tiles.jsp.taglib.GetAsStringTag.class) : new org.apache.tiles.jsp.taglib.GetAsStringTag();
    _jspx_th_tiles_getAsString_0.setJspContext(_jspx_page_context);
    _jspx_th_tiles_getAsString_0.setName("title");
    _jspx_th_tiles_getAsString_0.doTag();
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_tiles_getAsString_0);
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
    _jspx_th_spring_url_0.setValue("/");
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

  private boolean _jspx_meth_security_authorize_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_0 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_0.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_0.setParent(null);
    _jspx_th_security_authorize_0.setAccess("!isAuthenticated()");
    int _jspx_eval_security_authorize_0 = _jspx_th_security_authorize_0.doStartTag();
    if (_jspx_eval_security_authorize_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'index' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_0, _jspx_page_context))
        return true;
      out.write("'>Inicio</a></li>\r\n");
      out.write("\t\t\t\t\t\t");
    }
    if (_jspx_th_security_authorize_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_0);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_0);
    return false;
  }

  private boolean _jspx_meth_spring_url_1(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_1 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_1.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_0);
    _jspx_th_spring_url_1.setValue("/");
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

  private boolean _jspx_meth_security_authorize_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_1 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_1.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_1.setParent(null);
    _jspx_th_security_authorize_1.setAccess("!isAuthenticated()");
    int _jspx_eval_security_authorize_1 = _jspx_th_security_authorize_1.doStartTag();
    if (_jspx_eval_security_authorize_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'open-league' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_1, _jspx_page_context))
        return true;
      out.write("'>Nuestras ligas</a></li>\r\n");
      out.write("\t\t\t\t\t\t");
    }
    if (_jspx_th_security_authorize_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_1);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_1);
    return false;
  }

  private boolean _jspx_meth_spring_url_2(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_2 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_2.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_1);
    _jspx_th_spring_url_2.setValue("/open-league.html");
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

  private boolean _jspx_meth_security_authorize_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_2 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_2.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_2.setParent(null);
    _jspx_th_security_authorize_2.setAccess("!isAuthenticated()");
    int _jspx_eval_security_authorize_2 = _jspx_th_security_authorize_2.doStartTag();
    if (_jspx_eval_security_authorize_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'open-news' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_2, _jspx_page_context))
        return true;
      out.write("'>Nuestras noticias</a></li>\r\n");
      out.write("\t\t\t\t\t\t");
    }
    if (_jspx_th_security_authorize_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_2);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_2);
    return false;
  }

  private boolean _jspx_meth_spring_url_3(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_3 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_3.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_2);
    _jspx_th_spring_url_3.setValue("/open-news.html");
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

  private boolean _jspx_meth_security_authorize_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_3 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_3.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_3.setParent(null);
    _jspx_th_security_authorize_3.setAccess("!isAuthenticated()");
    int _jspx_eval_security_authorize_3 = _jspx_th_security_authorize_3.doStartTag();
    if (_jspx_eval_security_authorize_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'open-world-league' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_3, _jspx_page_context))
        return true;
      out.write("'>Ligas del mundo</a></li>\r\n");
      out.write("\t\t\t\t\t\t");
    }
    if (_jspx_th_security_authorize_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_3);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_3);
    return false;
  }

  private boolean _jspx_meth_spring_url_4(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_4 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_4.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_3);
    _jspx_th_spring_url_4.setValue("/open-world-league.html");
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

  private boolean _jspx_meth_security_authorize_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_4 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_4.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_4.setParent(null);
    _jspx_th_security_authorize_4.setAccess("!isAuthenticated()");
    int _jspx_eval_security_authorize_4 = _jspx_th_security_authorize_4.doStartTag();
    if (_jspx_eval_security_authorize_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'open-world-new' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_4, _jspx_page_context))
        return true;
      out.write("'>Noticias del mundo</a></li>\r\n");
      out.write("\t\t\t\t\t\t");
    }
    if (_jspx_th_security_authorize_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_4);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_4);
    return false;
  }

  private boolean _jspx_meth_spring_url_5(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_5 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_5.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_4);
    _jspx_th_spring_url_5.setValue("/open-world-new.html");
    int[] _jspx_push_body_count_spring_url_5 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_5 = _jspx_th_spring_url_5.doStartTag();
      if (_jspx_th_spring_url_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_5[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_5.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_5.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_5);
    }
    return false;
  }

  private boolean _jspx_meth_security_authorize_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_5 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_5.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_5.setParent(null);
    _jspx_th_security_authorize_5.setAccess("hasRole('ROLE_USER')");
    int _jspx_eval_security_authorize_5 = _jspx_th_security_authorize_5.doStartTag();
    if (_jspx_eval_security_authorize_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'league-admin' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_5, _jspx_page_context))
        return true;
      out.write("'>Administrar ligas</a></li>\r\n");
      out.write("\t\t\t\t    \t");
    }
    if (_jspx_th_security_authorize_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_5);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_5);
    return false;
  }

  private boolean _jspx_meth_spring_url_6(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_6 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_6.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_5);
    _jspx_th_spring_url_6.setValue("/league-admin.html");
    int[] _jspx_push_body_count_spring_url_6 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_6 = _jspx_th_spring_url_6.doStartTag();
      if (_jspx_th_spring_url_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_6[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_6.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_6.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_6);
    }
    return false;
  }

  private boolean _jspx_meth_security_authorize_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_6 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_6.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_6.setParent(null);
    _jspx_th_security_authorize_6.setAccess("hasRole('ROLE_USER')");
    int _jspx_eval_security_authorize_6 = _jspx_th_security_authorize_6.doStartTag();
    if (_jspx_eval_security_authorize_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'news-admin' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_6, _jspx_page_context))
        return true;
      out.write("'>Administrar noticias</a></li>\r\n");
      out.write("\t\t\t\t    \t");
    }
    if (_jspx_th_security_authorize_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_6);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_6);
    return false;
  }

  private boolean _jspx_meth_spring_url_7(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_7 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_7.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_6);
    _jspx_th_spring_url_7.setValue("/news-admin.html");
    int[] _jspx_push_body_count_spring_url_7 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_7 = _jspx_th_spring_url_7.doStartTag();
      if (_jspx_th_spring_url_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_7[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_7.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_7.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_7);
    }
    return false;
  }

  private boolean _jspx_meth_security_authorize_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_7 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_7.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_7.setParent(null);
    _jspx_th_security_authorize_7.setAccess("hasRole('ROLE_USER')");
    int _jspx_eval_security_authorize_7 = _jspx_th_security_authorize_7.doStartTag();
    if (_jspx_eval_security_authorize_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'account' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_8((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_7, _jspx_page_context))
        return true;
      out.write("'>Administrar cuenta</a></li>\r\n");
      out.write("\t\t\t\t    \t");
    }
    if (_jspx_th_security_authorize_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_7);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_7);
    return false;
  }

  private boolean _jspx_meth_spring_url_8(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_8 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_8.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_7);
    _jspx_th_spring_url_8.setValue("/account.html");
    int[] _jspx_push_body_count_spring_url_8 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_8 = _jspx_th_spring_url_8.doStartTag();
      if (_jspx_th_spring_url_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_8[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_8.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_8.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_8);
    }
    return false;
  }

  private boolean _jspx_meth_security_authorize_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_8 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_8.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_8.setParent(null);
    _jspx_th_security_authorize_8.setAccess("hasRole('ROLE_USER')");
    int _jspx_eval_security_authorize_8 = _jspx_th_security_authorize_8.doStartTag();
    if (_jspx_eval_security_authorize_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'support' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_9((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_8, _jspx_page_context))
        return true;
      out.write("'>Soporte</a></li>\r\n");
      out.write("\t\t\t\t    \t");
    }
    if (_jspx_th_security_authorize_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_8);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_8);
    return false;
  }

  private boolean _jspx_meth_spring_url_9(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_8, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_9 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_9.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_8);
    _jspx_th_spring_url_9.setValue("/support.html");
    int[] _jspx_push_body_count_spring_url_9 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_9 = _jspx_th_spring_url_9.doStartTag();
      if (_jspx_th_spring_url_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_9[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_9.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_9.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_9);
    }
    return false;
  }

  private boolean _jspx_meth_security_authorize_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_9 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_9.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_9.setParent(null);
    _jspx_th_security_authorize_9.setAccess("hasRole('ROLE_USER')");
    int _jspx_eval_security_authorize_9 = _jspx_th_security_authorize_9.doStartTag();
    if (_jspx_eval_security_authorize_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'wiki' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_10((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_9, _jspx_page_context))
        return true;
      out.write("'>Wiki</a></li>\r\n");
      out.write("\t\t\t\t    \t");
    }
    if (_jspx_th_security_authorize_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_9);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_9);
    return false;
  }

  private boolean _jspx_meth_spring_url_10(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_9, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_10 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_10.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_9);
    _jspx_th_spring_url_10.setValue("/wiki.html");
    int[] _jspx_push_body_count_spring_url_10 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_10 = _jspx_th_spring_url_10.doStartTag();
      if (_jspx_th_spring_url_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_10[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_10.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_10.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_10);
    }
    return false;
  }

  private boolean _jspx_meth_security_authorize_10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_10 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_10.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_10.setParent(null);
    _jspx_th_security_authorize_10.setAccess("hasRole('ROLE_ADMIN')");
    int _jspx_eval_security_authorize_10 = _jspx_th_security_authorize_10.doStartTag();
    if (_jspx_eval_security_authorize_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'users' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_11((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_10, _jspx_page_context))
        return true;
      out.write("'>Usuarios</a></li>\r\n");
      out.write("\t\t\t\t    \t");
    }
    if (_jspx_th_security_authorize_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_10);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_10);
    return false;
  }

  private boolean _jspx_meth_spring_url_11(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_10, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_11 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_11.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_10);
    _jspx_th_spring_url_11.setValue("/users.html");
    int[] _jspx_push_body_count_spring_url_11 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_11 = _jspx_th_spring_url_11.doStartTag();
      if (_jspx_th_spring_url_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_11[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_11.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_11.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_11);
    }
    return false;
  }

  private boolean _jspx_meth_security_authorize_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_11 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_11.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_11.setParent(null);
    _jspx_th_security_authorize_11.setAccess("hasRole('ROLE_ADMIN')");
    int _jspx_eval_security_authorize_11 = _jspx_th_security_authorize_11.doStartTag();
    if (_jspx_eval_security_authorize_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'support-admin' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_12((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_11, _jspx_page_context))
        return true;
      out.write("'>Casos de soporte</a></li>\r\n");
      out.write("\t\t\t\t    \t");
    }
    if (_jspx_th_security_authorize_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_11);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_11);
    return false;
  }

  private boolean _jspx_meth_spring_url_12(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_11, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_12 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_12.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_11);
    _jspx_th_spring_url_12.setValue("/support-admin.html");
    int[] _jspx_push_body_count_spring_url_12 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_12 = _jspx_th_spring_url_12.doStartTag();
      if (_jspx_th_spring_url_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_12[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_12.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_12.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_12);
    }
    return false;
  }

  private boolean _jspx_meth_security_authorize_12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_12 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_12.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_12.setParent(null);
    _jspx_th_security_authorize_12.setAccess("hasRole('ROLE_ADMIN')");
    int _jspx_eval_security_authorize_12 = _jspx_th_security_authorize_12.doStartTag();
    if (_jspx_eval_security_authorize_12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'exceptions' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_13((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_12, _jspx_page_context))
        return true;
      out.write("'>Excepciones</a></li>\r\n");
      out.write("\t\t\t\t    \t");
    }
    if (_jspx_th_security_authorize_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_12);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_12);
    return false;
  }

  private boolean _jspx_meth_spring_url_13(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_12, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_13 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_13.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_12);
    _jspx_th_spring_url_13.setValue("/exceptions.html");
    int[] _jspx_push_body_count_spring_url_13 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_13 = _jspx_th_spring_url_13.doStartTag();
      if (_jspx_th_spring_url_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_13[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_13.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_13.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_13);
    }
    return false;
  }

  private boolean _jspx_meth_security_authorize_13(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_13 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_13.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_13.setParent(null);
    _jspx_th_security_authorize_13.setAccess("hasRole('ROLE_ADMIN')");
    int _jspx_eval_security_authorize_13 = _jspx_th_security_authorize_13.doStartTag();
    if (_jspx_eval_security_authorize_13 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'world-league' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_14((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_13, _jspx_page_context))
        return true;
      out.write("'>Ligas del mundo</a></li>\r\n");
      out.write("\t\t\t\t    \t");
    }
    if (_jspx_th_security_authorize_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_13);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_13);
    return false;
  }

  private boolean _jspx_meth_spring_url_14(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_13, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_14 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_14.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_13);
    _jspx_th_spring_url_14.setValue("/world-league.html");
    int[] _jspx_push_body_count_spring_url_14 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_14 = _jspx_th_spring_url_14.doStartTag();
      if (_jspx_th_spring_url_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_14[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_14.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_14.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_14);
    }
    return false;
  }

  private boolean _jspx_meth_security_authorize_14(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_14 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_14.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_14.setParent(null);
    _jspx_th_security_authorize_14.setAccess("hasRole('ROLE_ADMIN')");
    int _jspx_eval_security_authorize_14 = _jspx_th_security_authorize_14.doStartTag();
    if (_jspx_eval_security_authorize_14 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'world-news' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_15((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_14, _jspx_page_context))
        return true;
      out.write("'>Noticias del mundo</a></li>\r\n");
      out.write("\t\t\t\t    \t");
    }
    if (_jspx_th_security_authorize_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_14);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_14);
    return false;
  }

  private boolean _jspx_meth_spring_url_15(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_14, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_15 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_15.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_14);
    _jspx_th_spring_url_15.setValue("/world-news.html");
    int[] _jspx_push_body_count_spring_url_15 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_15 = _jspx_th_spring_url_15.doStartTag();
      if (_jspx_th_spring_url_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_15[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_15.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_15.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_15);
    }
    return false;
  }

  private boolean _jspx_meth_security_authorize_15(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_15 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_15.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_15.setParent(null);
    _jspx_th_security_authorize_15.setAccess("hasRole('ROLE_ADMIN')");
    int _jspx_eval_security_authorize_15 = _jspx_th_security_authorize_15.doStartTag();
    if (_jspx_eval_security_authorize_15 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'gallery-admin' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_16((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_15, _jspx_page_context))
        return true;
      out.write("'>Galería</a></li>\r\n");
      out.write("\t\t\t\t    \t");
    }
    if (_jspx_th_security_authorize_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_15);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_15);
    return false;
  }

  private boolean _jspx_meth_spring_url_16(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_15, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_16 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_16.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_15);
    _jspx_th_spring_url_16.setValue("/gallery-admin.html");
    int[] _jspx_push_body_count_spring_url_16 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_16 = _jspx_th_spring_url_16.doStartTag();
      if (_jspx_th_spring_url_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_16[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_16.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_16.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_16);
    }
    return false;
  }

  private boolean _jspx_meth_security_authorize_16(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_16 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_16.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_16.setParent(null);
    _jspx_th_security_authorize_16.setAccess("!isAuthenticated()");
    int _jspx_eval_security_authorize_16 = _jspx_th_security_authorize_16.doStartTag();
    if (_jspx_eval_security_authorize_16 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t    \t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'register' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_17((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_16, _jspx_page_context))
        return true;
      out.write("'>Registrarse</a></li>\r\n");
      out.write("\t\t\t\t\t    \t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${current == 'login' ? 'active' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_18((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_16, _jspx_page_context))
        return true;
      out.write("'>Ingresar</a></li>\r\n");
      out.write("\t\t\t\t    \t");
    }
    if (_jspx_th_security_authorize_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_16);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_16);
    return false;
  }

  private boolean _jspx_meth_spring_url_17(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_16, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_17 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_17.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_16);
    _jspx_th_spring_url_17.setValue("/register.html");
    int[] _jspx_push_body_count_spring_url_17 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_17 = _jspx_th_spring_url_17.doStartTag();
      if (_jspx_th_spring_url_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_17[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_17.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_17.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_17);
    }
    return false;
  }

  private boolean _jspx_meth_spring_url_18(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_16, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_18 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_18.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_16);
    _jspx_th_spring_url_18.setValue("/login.html");
    int[] _jspx_push_body_count_spring_url_18 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_18 = _jspx_th_spring_url_18.doStartTag();
      if (_jspx_th_spring_url_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_18[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_18.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_18.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_18);
    }
    return false;
  }

  private boolean _jspx_meth_security_authorize_17(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_security_authorize_17 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_security_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    _jspx_th_security_authorize_17.setPageContext(_jspx_page_context);
    _jspx_th_security_authorize_17.setParent(null);
    _jspx_th_security_authorize_17.setAccess("isAuthenticated()");
    int _jspx_eval_security_authorize_17 = _jspx_th_security_authorize_17.doStartTag();
    if (_jspx_eval_security_authorize_17 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t\t\t\t\t    \t<li><a class=\"nav-link\" href='");
      if (_jspx_meth_spring_url_19((javax.servlet.jsp.tagext.JspTag) _jspx_th_security_authorize_17, _jspx_page_context))
        return true;
      out.write("'>Logout</a></li>\r\n");
      out.write("\t\t\t\t    \t");
    }
    if (_jspx_th_security_authorize_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_17);
      return true;
    }
    _jspx_tagPool_security_authorize_access.reuse(_jspx_th_security_authorize_17);
    return false;
  }

  private boolean _jspx_meth_spring_url_19(javax.servlet.jsp.tagext.JspTag _jspx_th_security_authorize_17, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_url_19 = (org.springframework.web.servlet.tags.UrlTag) _jspx_tagPool_spring_url_value_nobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_url_19.setPageContext(_jspx_page_context);
    _jspx_th_spring_url_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_security_authorize_17);
    _jspx_th_spring_url_19.setValue("/logout");
    int[] _jspx_push_body_count_spring_url_19 = new int[] { 0 };
    try {
      int _jspx_eval_spring_url_19 = _jspx_th_spring_url_19.doStartTag();
      if (_jspx_th_spring_url_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_url_19[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_url_19.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_url_19.doFinally();
      _jspx_tagPool_spring_url_value_nobody.reuse(_jspx_th_spring_url_19);
    }
    return false;
  }

  private boolean _jspx_meth_tiles_insertAttribute_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_insertAttribute_0 = (_jspx_resourceInjector != null)? _jspx_resourceInjector.createTagHandlerInstance(org.apache.tiles.jsp.taglib.InsertAttributeTag.class) : new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    _jspx_th_tiles_insertAttribute_0.setJspContext(_jspx_page_context);
    _jspx_th_tiles_insertAttribute_0.setName("body");
    _jspx_th_tiles_insertAttribute_0.doTag();
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_tiles_insertAttribute_0);
    return false;
  }

  private boolean _jspx_meth_tiles_insertAttribute_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_insertAttribute_1 = (_jspx_resourceInjector != null)? _jspx_resourceInjector.createTagHandlerInstance(org.apache.tiles.jsp.taglib.InsertAttributeTag.class) : new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    _jspx_th_tiles_insertAttribute_1.setJspContext(_jspx_page_context);
    _jspx_th_tiles_insertAttribute_1.setName("footer");
    _jspx_th_tiles_insertAttribute_1.doTag();
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_tiles_insertAttribute_1);
    return false;
  }
}
