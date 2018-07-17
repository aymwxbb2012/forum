package org.apache.jsp.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class top_005finc_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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

      out.write("\r\n");
      out.write("<input type=\"hidden\" id=\"contextPath\" value=\"");
      out.print(request.getContextPath());
      out.write("\"/>\r\n");
      out.write("<div id=\"top\">\r\n");
      out.write("\t<div id=\"topIntro\">\r\n");
      out.write("\t\t<span id=\"logo\"></span>\r\n");
      out.write("\t\t<span id=\"user_operator\">\r\n");
      out.write("\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/index\"  target=\"_blank\">home page</a>\r\n");
      out.write("\t\t\t|<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/user/showSelf\"  target=\"content\">search user information</a>\r\n");
      out.write("\t\t\t| <a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/user/updateSelf\"  target=\"content\">update user information</a>\r\n");
      out.write("\t\t\t| <a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/user/updatePwd\"  target=\"content\">change password </a>\r\n");
      out.write("\t\t\t| <a href=\"javascript:exitSystem()\">exit system</a>\r\n");
      out.write("\t\t</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"remind\">\r\n");
      out.write("\t\t<span id=\"showDate\">welcome[");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginUser.nickname }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("]to");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${baseInfo.name }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("background management system。\r\n");
      out.write("\t\t</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
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
}
