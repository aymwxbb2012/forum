package org.apache.jsp.jsp.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class qtop_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("   <input type=\"hidden\" id=\"ctx\" value=\"");
      out.print(request.getContextPath());
      out.write("\"/>\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("\t<div id=\"header_con\">\r\n");
      out.write("\t\t<div id=\"logo\"></div>\r\n");
      out.write("\t\t<div id=\"main_nav\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><a class=\"main_nav_link\" href=\"\"");
      out.print(request.getContextPath());
      out.write("/index\">home page</a></li>\r\n");
      out.write("\t\t\t\t<li><a class=\"main_nav_link\" href=\"");
      out.print(request.getContextPath());
      out.write("/tindex\">DF Articles</a></li>\r\n");
      out.write("\t\t\t\t<li><a class=\"main_nav_link\" href=\"");
      out.print(request.getContextPath());
      out.write("/login\">login</a></li>\r\n");
      out.write("\t\t\t\t<li><a class=\"main_nav_link\" href=\"");
      out.print(request.getContextPath());
      out.write("/register\">register</a></li>\r\n");
      out.write("\t\t\t\t<li><a class=\"main_nav_link\" href=\"");
      out.print(request.getContextPath());
      out.write("/admin/question/add\">ask question</a></li>\r\n");
      out.write("\t\t\t\t<li><a class=\"main_nav_link\" href=\"mailto:11@gm.com\">contact us</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"search\">\r\n");
      out.write("\t\t\t<input type=\"text\" id=\"search_con\" value=\"Search..\" />\r\n");
      out.write("\t\t\t<div id=\"search_btn\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"nav\">\r\n");
      out.write("\t<div id=\"nav_con\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li><span href=\"");
      out.print(request.getContextPath());
      out.write("/index\">home page</span></li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<span href=\"");
      out.print(request.getContextPath());
      out.write("/qchannel/2\">exam1</span>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<span href=\"");
      out.print(request.getContextPath());
      out.write("/qchannel/4\">exam3</span>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<span href=\"");
      out.print(request.getContextPath());
      out.write("/qchannel/13\">assignment2</span>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<span href=\"");
      out.print(request.getContextPath());
      out.write("/qchannel/18\">activity2</span>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
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
}
