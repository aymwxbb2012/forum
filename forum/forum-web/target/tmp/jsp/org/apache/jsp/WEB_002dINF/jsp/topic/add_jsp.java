package org.apache.jsp.WEB_002dINF.jsp.topic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_form_modelAttribute_method_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_textarea_rows_path_cols_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_radiobutton_value_path_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_hidden_path_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_input_path_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_errors_path_cssClass_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_input_size_path_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_sf_form_modelAttribute_method_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sf_textarea_rows_path_cols_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sf_radiobutton_value_path_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sf_hidden_path_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sf_input_path_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sf_errors_path_cssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sf_input_size_path_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_sf_form_modelAttribute_method_id.release();
    _jspx_tagPool_sf_textarea_rows_path_cols_nobody.release();
    _jspx_tagPool_sf_radiobutton_value_path_nobody.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_sf_hidden_path_nobody.release();
    _jspx_tagPool_sf_input_path_nobody.release();
    _jspx_tagPool_sf_errors_path_cssClass_nobody.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_c_when_test.release();
    _jspx_tagPool_sf_input_size_path_nobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/css/admin/main.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/base/jquery.ui.all.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/css/admin/article.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/css/validate/main.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/css/zTree/zTreeStyle.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/core/jquery.forum.keywordinput.css\"/>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/core/jquery.forum.keywordinput.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/tree/jquery.ztree.core-3.5.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/core/jquery.forum.core.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/ui/jquery-ui-1.10.0.custom.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/i18n/jquery.ui.datepicker-en-AU.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/admin/main.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/xheditor/xheditor-1.1.14-en.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/uploadify/uploadify.css\"/>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/uploadify/jquery.uploadify.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/jquery.validate.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/core/jquery.forum.validate.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/dwr/engine.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/dwr/interface/dwrService.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/admin/topicAdd.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<input type=\"hidden\" id=\"sid\" value=\"");
      out.print(session.getId());
      out.write("\"/>\r\n");
      out.write("<div id=\"menuContent\" class=\"menuContent\" style=\"display:none; position: absolute;background:#eee;z-index: 999;border:1px solid #999\">\r\n");
      out.write("\t<ul id=\"mytree\" class=\"ztree\" style=\"margin-top:0;\"></ul>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"container\">\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/admin/top_inc.jsp", out, false);
      out.write("\r\n");
      out.write("<div id=\"contents\">\r\n");
      out.write("<input type=\"hidden\" id=\"ctx\" value=\"");
      out.print(request.getContextPath() );
      out.write("\"/>\r\n");
      out.write("\t<h3 class=\"admin_link_bar\" style=\"text-align:center\">\r\n");
      out.write("\t<span>Add topic</span>\r\n");
      out.write("\t</h3>\r\n");
      out.write("\t");
      //  sf:form
      org.springframework.web.servlet.tags.form.FormTag _jspx_th_sf_form_0 = (org.springframework.web.servlet.tags.form.FormTag) _jspx_tagPool_sf_form_modelAttribute_method_id.get(org.springframework.web.servlet.tags.form.FormTag.class);
      _jspx_th_sf_form_0.setPageContext(_jspx_page_context);
      _jspx_th_sf_form_0.setParent(null);
      _jspx_th_sf_form_0.setMethod("post");
      _jspx_th_sf_form_0.setModelAttribute("topicDto");
      _jspx_th_sf_form_0.setId("addForm");
      int[] _jspx_push_body_count_sf_form_0 = new int[] { 0 };
      try {
        int _jspx_eval_sf_form_0 = _jspx_th_sf_form_0.doStartTag();
        if (_jspx_eval_sf_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t<table width=\"980\" cellspacing=\"0\" cellPadding=\"0\" id=\"addTable\">\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td class=\"rightTd\" width=\"120px\">Topic title:</td>\r\n");
            out.write("\t\t\t<td class=\"leftTd\">\r\n");
            out.write("\t\t\t");
            if (_jspx_meth_sf_input_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_sf_form_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
              return;
            //  sf:errors
            org.springframework.web.servlet.tags.form.ErrorsTag _jspx_th_sf_errors_0 = (org.springframework.web.servlet.tags.form.ErrorsTag) _jspx_tagPool_sf_errors_path_cssClass_nobody.get(org.springframework.web.servlet.tags.form.ErrorsTag.class);
            _jspx_th_sf_errors_0.setPageContext(_jspx_page_context);
            _jspx_th_sf_errors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
            _jspx_th_sf_errors_0.setCssClass("errorContainer");
            _jspx_th_sf_errors_0.setPath("title");
            int[] _jspx_push_body_count_sf_errors_0 = new int[] { 0 };
            try {
              int _jspx_eval_sf_errors_0 = _jspx_th_sf_errors_0.doStartTag();
              if (_jspx_th_sf_errors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (Throwable _jspx_exception) {
              while (_jspx_push_body_count_sf_errors_0[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_sf_errors_0.doCatch(_jspx_exception);
            } finally {
              _jspx_th_sf_errors_0.doFinally();
              _jspx_tagPool_sf_errors_path_cssClass_nobody.reuse(_jspx_th_sf_errors_0);
            }
            out.write("</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td class=\"rightTd\">Topic section:</td>\r\n");
            out.write("\t\t\t<td class=\"leftTd\">\r\n");
            out.write("\t\t\t\t<input type=\"text\" readonly=\"readonly\" name=\"cname\" id=\"cname\"/>\r\n");
            out.write("\t\t\t\t<input type=\"text\" readonly=\"readonly\" id=\"cid\" name=\"cid\" value=\"0\"/>");
            //  sf:errors
            org.springframework.web.servlet.tags.form.ErrorsTag _jspx_th_sf_errors_1 = (org.springframework.web.servlet.tags.form.ErrorsTag) _jspx_tagPool_sf_errors_path_cssClass_nobody.get(org.springframework.web.servlet.tags.form.ErrorsTag.class);
            _jspx_th_sf_errors_1.setPageContext(_jspx_page_context);
            _jspx_th_sf_errors_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
            _jspx_th_sf_errors_1.setCssClass("errorContainer");
            _jspx_th_sf_errors_1.setPath("cid");
            int[] _jspx_push_body_count_sf_errors_1 = new int[] { 0 };
            try {
              int _jspx_eval_sf_errors_1 = _jspx_th_sf_errors_1.doStartTag();
              if (_jspx_th_sf_errors_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (Throwable _jspx_exception) {
              while (_jspx_push_body_count_sf_errors_1[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_sf_errors_1.doCatch(_jspx_exception);
            } finally {
              _jspx_th_sf_errors_1.doFinally();
              _jspx_tagPool_sf_errors_path_cssClass_nobody.reuse(_jspx_th_sf_errors_1);
            }
            out.write("\r\n");
            out.write("\t\t\t</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t");
            if (_jspx_meth_c_choose_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_sf_form_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
              return;
            out.write("\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td class=\"rightTd\">Is recommend topic:</td>\r\n");
            out.write("\t\t\t<td class=\"leftTd\">\r\n");
            out.write("\t\t\t\t");
            if (_jspx_meth_sf_radiobutton_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_sf_form_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
              return;
            out.write("Not recommend\r\n");
            out.write("\t\t\t\t");
            if (_jspx_meth_sf_radiobutton_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_sf_form_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
              return;
            out.write("Recommend\r\n");
            out.write("\t\t\t</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td class=\"rightTd\">Publish time:</td>\r\n");
            out.write("\t\t\t<td class=\"leftTd\">\r\n");
            out.write("\t\t\t\t");
            if (_jspx_meth_sf_input_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_sf_form_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
              return;
            out.write("\r\n");
            out.write("\t\t\t</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td class=\"rightTd\">Topic keyword:</td>\r\n");
            out.write("\t\t\t<td class=\"leftTd\">\r\n");
            out.write("\t\t\t\t");
            if (_jspx_meth_sf_input_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_sf_form_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
              return;
            out.write("\r\n");
            out.write("\t\t\t</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td class=\"rightTd\">Topic attachment</td>\r\n");
            out.write("\t\t\t<td class=\"leftTd\">\r\n");
            out.write("\t\t\t\t<div id=\"attachs\"></div>\r\n");
            out.write("\t\t\t\t<input type=\"file\" id=\"attach\" name=\"attach\"/>\r\n");
            out.write("\t\t\t\t<input type=\"button\" id=\"uploadFile\" value=\"Upload attachment\"/>\r\n");
            out.write("\t\t\t</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t<td colspan=\"2\">Has been annexed</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t<td colspan=\"2\">\r\n");
            out.write("\t\t<table id=\"ok_attach\" width=\"890px\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
            out.write("\t\t\t<thead>\r\n");
            out.write("\t\t\t\t<tr>\r\n");
            out.write("\t\t\t\t<Td>File name thumbnail</Td>\r\n");
            out.write("\t\t\t\t<td width=\"180\">file name</td>\r\n");
            out.write("\t\t\t\t<td>File size</td>\r\n");
            out.write("\t\t\t\t<td>Homepage img</td>\r\n");
            out.write("\t\t\t\t<td>Topic img</td>\r\n");
            out.write("\t\t\t\t<td>Attachment info</td>\r\n");
            out.write("\t\t\t\t<td width=\"160\">Operation</td>\r\n");
            out.write("\t\t\t\t</tr>\r\n");
            out.write("\t\t\t</thead>\r\n");
            out.write("\t\t\t<tbody>\r\n");
            out.write("\t\t\t</tbody>\r\n");
            out.write("\t\t</table>\r\n");
            out.write("\t\t</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td colspan=\"2\">Topic content</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td colspan=\"2\">\r\n");
            out.write("\t\t\t");
            if (_jspx_meth_sf_textarea_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_sf_form_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
              return;
            out.write("\r\n");
            out.write("\t\t\t</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td colspan=\"2\">Topic summery</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td colspan=\"2\">\r\n");
            out.write("\t\t\t");
            if (_jspx_meth_sf_textarea_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_sf_form_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
              return;
            out.write("\r\n");
            out.write("\t\t\t\r\n");
            out.write("\t\t\t</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td colspan=\"2\" class=\"centerTd\"><input type=\"button\" id=\"addBtn\" value=\"add topic\"/><input type=\"reset\"/></td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t</table>\r\n");
            out.write("\t");
            int evalDoAfterBody = _jspx_th_sf_form_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_sf_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_sf_form_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_sf_form_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_sf_form_0.doFinally();
        _jspx_tagPool_sf_form_modelAttribute_method_id.reuse(_jspx_th_sf_form_0);
      }
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
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

  private boolean _jspx_meth_sf_input_0(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_sf_input_0 = (org.springframework.web.servlet.tags.form.InputTag) _jspx_tagPool_sf_input_size_path_nobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_sf_input_0.setPageContext(_jspx_page_context);
    _jspx_th_sf_input_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
    _jspx_th_sf_input_0.setPath("title");
    _jspx_th_sf_input_0.setSize("80");
    int[] _jspx_push_body_count_sf_input_0 = new int[] { 0 };
    try {
      int _jspx_eval_sf_input_0 = _jspx_th_sf_input_0.doStartTag();
      if (_jspx_th_sf_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_input_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_input_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_input_0.doFinally();
      _jspx_tagPool_sf_input_size_path_nobody.reuse(_jspx_th_sf_input_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_choose_0(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t");
        if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
          return true;
        out.write("\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${isAudit||isAdmin }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<tr>\r\n");
        out.write("\t\t\t\t<td class=\"rightTd\">Topic status:</td>\r\n");
        out.write("\t\t\t\t<td class=\"leftTd\">\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_sf_radiobutton_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
          return true;
        out.write("Unpublished\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_sf_radiobutton_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
          return true;
        out.write("Publish\r\n");
        out.write("\t\t\t\t</td>\r\n");
        out.write("\t\t\t</tr>\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_sf_radiobutton_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:radiobutton
    org.springframework.web.servlet.tags.form.RadioButtonTag _jspx_th_sf_radiobutton_0 = (org.springframework.web.servlet.tags.form.RadioButtonTag) _jspx_tagPool_sf_radiobutton_value_path_nobody.get(org.springframework.web.servlet.tags.form.RadioButtonTag.class);
    _jspx_th_sf_radiobutton_0.setPageContext(_jspx_page_context);
    _jspx_th_sf_radiobutton_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_sf_radiobutton_0.setPath("status");
    _jspx_th_sf_radiobutton_0.setValue(new String("0"));
    int[] _jspx_push_body_count_sf_radiobutton_0 = new int[] { 0 };
    try {
      int _jspx_eval_sf_radiobutton_0 = _jspx_th_sf_radiobutton_0.doStartTag();
      if (_jspx_th_sf_radiobutton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_radiobutton_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_radiobutton_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_radiobutton_0.doFinally();
      _jspx_tagPool_sf_radiobutton_value_path_nobody.reuse(_jspx_th_sf_radiobutton_0);
    }
    return false;
  }

  private boolean _jspx_meth_sf_radiobutton_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:radiobutton
    org.springframework.web.servlet.tags.form.RadioButtonTag _jspx_th_sf_radiobutton_1 = (org.springframework.web.servlet.tags.form.RadioButtonTag) _jspx_tagPool_sf_radiobutton_value_path_nobody.get(org.springframework.web.servlet.tags.form.RadioButtonTag.class);
    _jspx_th_sf_radiobutton_1.setPageContext(_jspx_page_context);
    _jspx_th_sf_radiobutton_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_sf_radiobutton_1.setPath("status");
    _jspx_th_sf_radiobutton_1.setValue(new String("1"));
    int[] _jspx_push_body_count_sf_radiobutton_1 = new int[] { 0 };
    try {
      int _jspx_eval_sf_radiobutton_1 = _jspx_th_sf_radiobutton_1.doStartTag();
      if (_jspx_th_sf_radiobutton_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_radiobutton_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_radiobutton_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_radiobutton_1.doFinally();
      _jspx_tagPool_sf_radiobutton_value_path_nobody.reuse(_jspx_th_sf_radiobutton_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t");
        if (_jspx_meth_sf_hidden_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_otherwise_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }

  private boolean _jspx_meth_sf_hidden_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_otherwise_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:hidden
    org.springframework.web.servlet.tags.form.HiddenInputTag _jspx_th_sf_hidden_0 = (org.springframework.web.servlet.tags.form.HiddenInputTag) _jspx_tagPool_sf_hidden_path_nobody.get(org.springframework.web.servlet.tags.form.HiddenInputTag.class);
    _jspx_th_sf_hidden_0.setPageContext(_jspx_page_context);
    _jspx_th_sf_hidden_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_0);
    _jspx_th_sf_hidden_0.setPath("status");
    int[] _jspx_push_body_count_sf_hidden_0 = new int[] { 0 };
    try {
      int _jspx_eval_sf_hidden_0 = _jspx_th_sf_hidden_0.doStartTag();
      if (_jspx_th_sf_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_hidden_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_hidden_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_hidden_0.doFinally();
      _jspx_tagPool_sf_hidden_path_nobody.reuse(_jspx_th_sf_hidden_0);
    }
    return false;
  }

  private boolean _jspx_meth_sf_radiobutton_2(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:radiobutton
    org.springframework.web.servlet.tags.form.RadioButtonTag _jspx_th_sf_radiobutton_2 = (org.springframework.web.servlet.tags.form.RadioButtonTag) _jspx_tagPool_sf_radiobutton_value_path_nobody.get(org.springframework.web.servlet.tags.form.RadioButtonTag.class);
    _jspx_th_sf_radiobutton_2.setPageContext(_jspx_page_context);
    _jspx_th_sf_radiobutton_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
    _jspx_th_sf_radiobutton_2.setPath("recommend");
    _jspx_th_sf_radiobutton_2.setValue(new String("0"));
    int[] _jspx_push_body_count_sf_radiobutton_2 = new int[] { 0 };
    try {
      int _jspx_eval_sf_radiobutton_2 = _jspx_th_sf_radiobutton_2.doStartTag();
      if (_jspx_th_sf_radiobutton_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_radiobutton_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_radiobutton_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_radiobutton_2.doFinally();
      _jspx_tagPool_sf_radiobutton_value_path_nobody.reuse(_jspx_th_sf_radiobutton_2);
    }
    return false;
  }

  private boolean _jspx_meth_sf_radiobutton_3(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:radiobutton
    org.springframework.web.servlet.tags.form.RadioButtonTag _jspx_th_sf_radiobutton_3 = (org.springframework.web.servlet.tags.form.RadioButtonTag) _jspx_tagPool_sf_radiobutton_value_path_nobody.get(org.springframework.web.servlet.tags.form.RadioButtonTag.class);
    _jspx_th_sf_radiobutton_3.setPageContext(_jspx_page_context);
    _jspx_th_sf_radiobutton_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
    _jspx_th_sf_radiobutton_3.setPath("recommend");
    _jspx_th_sf_radiobutton_3.setValue(new String("1"));
    int[] _jspx_push_body_count_sf_radiobutton_3 = new int[] { 0 };
    try {
      int _jspx_eval_sf_radiobutton_3 = _jspx_th_sf_radiobutton_3.doStartTag();
      if (_jspx_th_sf_radiobutton_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_radiobutton_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_radiobutton_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_radiobutton_3.doFinally();
      _jspx_tagPool_sf_radiobutton_value_path_nobody.reuse(_jspx_th_sf_radiobutton_3);
    }
    return false;
  }

  private boolean _jspx_meth_sf_input_1(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_sf_input_1 = (org.springframework.web.servlet.tags.form.InputTag) _jspx_tagPool_sf_input_path_nobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_sf_input_1.setPageContext(_jspx_page_context);
    _jspx_th_sf_input_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
    _jspx_th_sf_input_1.setPath("publishDate");
    int[] _jspx_push_body_count_sf_input_1 = new int[] { 0 };
    try {
      int _jspx_eval_sf_input_1 = _jspx_th_sf_input_1.doStartTag();
      if (_jspx_th_sf_input_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_input_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_input_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_input_1.doFinally();
      _jspx_tagPool_sf_input_path_nobody.reuse(_jspx_th_sf_input_1);
    }
    return false;
  }

  private boolean _jspx_meth_sf_input_2(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_sf_input_2 = (org.springframework.web.servlet.tags.form.InputTag) _jspx_tagPool_sf_input_path_nobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_sf_input_2.setPageContext(_jspx_page_context);
    _jspx_th_sf_input_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
    _jspx_th_sf_input_2.setPath("keyword");
    int[] _jspx_push_body_count_sf_input_2 = new int[] { 0 };
    try {
      int _jspx_eval_sf_input_2 = _jspx_th_sf_input_2.doStartTag();
      if (_jspx_th_sf_input_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_input_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_input_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_input_2.doFinally();
      _jspx_tagPool_sf_input_path_nobody.reuse(_jspx_th_sf_input_2);
    }
    return false;
  }

  private boolean _jspx_meth_sf_textarea_0(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:textarea
    org.springframework.web.servlet.tags.form.TextareaTag _jspx_th_sf_textarea_0 = (org.springframework.web.servlet.tags.form.TextareaTag) _jspx_tagPool_sf_textarea_rows_path_cols_nobody.get(org.springframework.web.servlet.tags.form.TextareaTag.class);
    _jspx_th_sf_textarea_0.setPageContext(_jspx_page_context);
    _jspx_th_sf_textarea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
    _jspx_th_sf_textarea_0.setPath("content");
    _jspx_th_sf_textarea_0.setRows("25");
    _jspx_th_sf_textarea_0.setCols("110");
    int[] _jspx_push_body_count_sf_textarea_0 = new int[] { 0 };
    try {
      int _jspx_eval_sf_textarea_0 = _jspx_th_sf_textarea_0.doStartTag();
      if (_jspx_th_sf_textarea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_textarea_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_textarea_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_textarea_0.doFinally();
      _jspx_tagPool_sf_textarea_rows_path_cols_nobody.reuse(_jspx_th_sf_textarea_0);
    }
    return false;
  }

  private boolean _jspx_meth_sf_textarea_1(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:textarea
    org.springframework.web.servlet.tags.form.TextareaTag _jspx_th_sf_textarea_1 = (org.springframework.web.servlet.tags.form.TextareaTag) _jspx_tagPool_sf_textarea_rows_path_cols_nobody.get(org.springframework.web.servlet.tags.form.TextareaTag.class);
    _jspx_th_sf_textarea_1.setPageContext(_jspx_page_context);
    _jspx_th_sf_textarea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
    _jspx_th_sf_textarea_1.setPath("summary");
    _jspx_th_sf_textarea_1.setRows("5");
    _jspx_th_sf_textarea_1.setCols("110");
    int[] _jspx_push_body_count_sf_textarea_1 = new int[] { 0 };
    try {
      int _jspx_eval_sf_textarea_1 = _jspx_th_sf_textarea_1.doStartTag();
      if (_jspx_th_sf_textarea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_textarea_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_textarea_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_textarea_1.doFinally();
      _jspx_tagPool_sf_textarea_rows_path_cols_nobody.reuse(_jspx_th_sf_textarea_1);
    }
    return false;
  }
}
