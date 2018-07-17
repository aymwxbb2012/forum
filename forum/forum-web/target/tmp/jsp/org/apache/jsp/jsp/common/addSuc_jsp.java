package org.apache.jsp.jsp.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addSuc_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GB18030\">\r\n");
      out.write("<title>Add record success</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function closewindow(){\r\n");
      out.write("\tif(window.opener){\r\n");
      out.write("\t\twindow.opener.location.reload(true);\r\n");
      out.write("\t\twindow.close();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function clock(){\r\n");
      out.write("\ti = i -1;\r\n");
      out.write("\tif(document.getElementById(\"info\")){\r\n");
      out.write("\t\tdocument.getElementById(\"info\").innerHTML = \"This window will be closed in\"+i+\"seconds\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(i > 0)\r\n");
      out.write("\t\tsetTimeout(\"clock();\",1000);\r\n");
      out.write("\telse\r\n");
      out.write("\t\tclosewindow();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var i = 4;\r\n");
      out.write("clock();\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<center>\r\n");
      out.write("\tAdd record success!<p>\r\n");
      out.write("\t<div id=\"info\">This window will be automatically closed after 3 seconds</div>\r\n");
      out.write("\t<input type=\"button\" value=\"close the window\" onclick=\"closewindow();\">\r\n");
      out.write("</center>\r\n");
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
}
