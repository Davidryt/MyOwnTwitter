/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.44
 * Generated at: 2021-05-18 16:23:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import twitter.Tweet;
import java.util.List;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("twitter.Tweet");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Profile</title>\n");
      out.write("\t\t<meta charset=\"UTF-8\">\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"styles/general.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/style.css\">\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"styles/main.css\">\n");
      out.write("\t\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("\t\t<script src=\"./js/sidenav.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
 String usuario = (String) request.getAttribute("usuario"); 	
      out.write("\t\n");
      out.write("<header>\n");
      out.write("            <div class=\"header\">  <!-- Header part: Will be the ssame in each file-->\n");
      out.write("\t\t\t\t<div id=\"block_container\">\n");
      out.write("                <div class=\"dropdown\" id=\"bloc1\"> <!-- Hamburger menu (only used in phone mode) -->\n");
      out.write("                    <img src=\"images/menu.png\" class=\"menu-img\" alt=\"Menu\" onclick=\"openNav()\" >\n");
      out.write("                </div>\t\n");
      out.write("\t\t\t\t<div id=\"bloc2\">\n");
      out.write("\t\t\t\t\t <img class=\"profpic\" src=\"images/logo2.png\" alt=\"logo\"> <!-- cOURSE MAIN IMAGE-->\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div id=\"bloc3\">\n");
      out.write("\t\t\t\t\t<h1 style=\"color: white\">PERFIL</h1>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div id=\"bloc5\"> \n");
      out.write("\t\t\t\t");
 if(usuario != null ) { 	
      out.write("\n");
      out.write("           \t\t\t<form action=\"logout\">\n");
      out.write("\t\t        \t\t<input type=\"submit\" value=\"Cerrar Sesi??n\" class=\"logout\" id=\"logout\">\n");
      out.write("\t\t   \t\t\t</form>\n");
      out.write("\t\t\t\t");
 } 
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("\t\t<div id=\"mySidenav\" class=\"sidenav\">\n");
      out.write("  \t\t\t<a href=\"javascript:void(0)\" class=\"closebtn\" onclick=\"closeNav()\">&times;</a>\n");
      out.write("\t\t\t");
 if(usuario != null ) { 	
      out.write(" \t\t\t\n");
      out.write("\t\t\t\t<form action=\"timeline\">\n");
      out.write("\t\t        <input type=\"submit\" value=\"Ir a Vista Principal\" class=\"input_nav\">\n");
      out.write("\t\t    \t</form>\n");
      out.write("\t\t\t");
 } 
      out.write("\n");
      out.write(" \t\t\t<a href=\"#\">About</a>\n");
      out.write("  \t\t\t<a href=\"#\">Help</a>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("<div class=\"publicar col-12 col-t-12\">\t\n");
      out.write("\n");
 int followers = (int) request.getAttribute("followers"); 
      out.write('\n');
 List<String> info = (List<String>) request.getAttribute("info"); 
      out.write("\n");
      out.write("        <h1>");
      out.print( info.get(1) );
      out.write("</h1>\n");
      out.write("\t\t<h1>");
      out.print( info.get(2) );
      out.write("</h1>\n");
      out.write("\t\t<h1>");
      out.print( info.get(3) );
      out.write("</h1>\n");
      out.write("\t\t<h3>");
      out.print( followers );
      out.write(" seguidores</h3>\n");
      out.write("\n");
      out.write("\n");
 if(usuario != null ) { 	
      out.write('\n');
      out.write(' ');
      out.write(' ');
 if(!(usuario.equals(info.get(1))) ) { 	
      out.write('\n');
      out.write('	');
 if((boolean) request.getAttribute("followed")) { 	
      out.write("\n");
      out.write("\t\t<form action=\"unfollow\" method=\"post\">\n");
      out.write("            <div>\n");
      out.write("                <label>\n");
      out.write("                    <input type=\"hidden\" name=\"seguido\" value=\"");
      out.print( info.get(1) );
      out.write("\">\n");
      out.write("                </label>\n");
      out.write("\t\t\t</div>\n");
      out.write("            <input type=\"submit\" value=\"Dejar de seguir\">\n");
      out.write("        </form>\n");
      out.write("\t");
 }else{ 
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<form action=\"follow\" method=\"post\">\n");
      out.write("\t\t        <div>\n");
      out.write("\t\t            <label>\n");
      out.write("\t\t                <input type=\"hidden\" name=\"seguido\" value=\"");
      out.print( info.get(1) );
      out.write("\">\n");
      out.write("\t\t            </label>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t        <input type=\"submit\" value=\"Seguir\">\n");
      out.write("\t\t    </form>\n");
      out.write("\n");
      out.write("\t");
 } 
      out.write('\n');
      out.write(' ');
      out.write(' ');
 } 
      out.write('\n');
 } 
      out.write("\n");
      out.write("</div>\n");
      out.write("<div class=\"big\">\n");
      out.write("<div class=\"todo\">\n");
 List<Tweet> tweets = (List<Tweet>) request.getAttribute("tweets"); 
      out.write('\n');
 List<Integer> rts = (List<Integer>) request.getAttribute("rts"); 
      out.write('\n');
 for (int i=0; i<tweets.size(); i++) { 
      out.write("\n");
      out.write("        ");
 if (tweets.get(i).getEs_retweet() != 0) { 
      out.write("\n");
      out.write("        <table class=\"tweets\" id=\"backgr_rt\">\n");
      out.write("\t\t");
 }else{ 
      out.write("\n");
      out.write("\t\t<table class=\"tweets\" id=\"backgr\">\n");
      out.write("\t\t");
 } 
      out.write("\n");
      out.write("\t\t\t<tr class=\"fila\">\n");
      out.write("\t\t\t\t<th class=\"columna1\"> \t\t\t\n");
      out.write("                \t<a href=\"profile?profile=");
      out.print(tweets.get(i).getAutor_name() );
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print( tweets.get(i).getAutor_name() );
      out.write(" </a>\n");
      out.write("\t\t\t\t</th>\n");
      out.write("\t\t\t\t<th class=\"columna2\"></th><th class=\"columna3\"></th>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr class=\"fila\"><th class=\"columna1\">\n");
      out.write("\t\t\t\t\t<a href=\"conversacion?id_msg=");
      out.print(tweets.get(i).getId() );
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print( tweets.get(i).getMensaje() );
      out.write("</a>\n");
      out.write("\t\t\t\t</th>\n");
      out.write("\t\t\t\t<th class=\"columna2\">\t\n");
      out.write("\t\t\t\t</th><th class=\"columna3\"><label> ");
      out.print( tweets.get(i).datetime() );
      out.write("</label></th>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr class=\"fila\"><th class=\"columna1\">\n");
      out.write("\t\t\t\t");
 if(usuario != null ) { 	
      out.write("\n");
      out.write("                \t<form action=\"retransmision\" method=\"post\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"idMensaje\" value=\"");
      out.print( tweets.get(i).getId() );
      out.write("\">\n");
      out.write("\t\t\t\t    \t<input type=\"submit\" value=\"RTx\" class=\"RT\">\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t");
 } 
      out.write("\n");
      out.write("\t\t\t\t</th><th class=\"columna2\">\n");
      out.write("\t\t\t\t\t<label> ");
      out.print( rts.get(i) );
      out.write(" retransmisiones</label>\n");
      out.write("\t\t\t\t</th>\n");
      out.write("\t\t\t\t<th class=\"columna3\">\n");
      out.write("\t\t\t\t\t");
 if (tweets.get(i).getEs_retweet() != 0) { 
      out.write("\n");
      out.write("\t\t\t\t\t <a href=\"conversacion?id_msg=");
      out.print(tweets.get(i).getEs_retweet() );
      out.write("\"> Ver tweet original </a>\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\n");
      out.write("\t\t\t\t</th></tr>\n");
      out.write("        </table>\n");
 } 
      out.write("\n");
      out.write("\t</div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
