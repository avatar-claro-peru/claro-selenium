<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" isErrorPage="true" %>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  <title>Fondo Nacional de Financiamiento de la Actividad Empresarial del Estado - FONAFE</title>  
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>  
  <meta name="keywords" content="fonafe, empresa, economia, finanzas, estado"/>
  <meta name="robots" content="index,follow">
  <meta name="description" content="El Fondo Nacional de Financiamiento de la Actividad Empresarial del Estado ? FONAFE es una empresa de Derecho Público adscrita al Sector Economía y Finanzas creada por la Ley No. 27170, encargada de normar y dirigir la actividad empresarial del Estado. Al momento de su creación, FONAFE asumió las funciones de la desaparecida Oficina de Instituciones y Organismos del Estado - OIOE."/>  
  <meta name="Author" content="DICSO S.A.C.">
  <style type="text/css" media="screen,projection">@import url( <%=request.getContextPath()%>/css/stylesfonafe.css );</style>
  </head>

  <body>
  	<div align="center">
    <table align="center" class="graybordertablet" width="99%">
      <!-- Parte Cabecera de la Página -->
      <tr>
        <td>
          <table width="100%">
            <tr>
              <td align="left">
                <div class="detailtl">
                <table>
                  <tr>
                    <td>
                      <img src="<%=request.getContextPath()%>/images/portal/logofonafe.gif">
                    </td>
                  </tr>
                </table>
                </div>
              </td>
              <td align="right" valign="top">
              </td>
            </tr>
          </table>
        </td>
      </tr>
      <!-- Fin Parte Cabecera de la Página-->      
    </table>
    <table class="graybordertableb" width="99%">
      <!-- Parte Central de la Página-->
      <tr>
        <td  class="bottomline">
          <table width="100%">
            <tr>
              <td valign="top" align="center">
                <!-- Cuerpo central de la página 599-->
                <div id="contenidocentral">
                <table id="contenido" width="100%">
                    <tr height="50">
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td align="left"> 
                        <table class="graybordertable" width="100%">
                          <tr>
                            <td class="textcontenidojustify">
                              <p align="center" style="color:red;">
                                <c:if test="${empty  message}">
                                  <b>Página no encontrada ó tiene errores. Verifique el sitio.</b>
                                </c:if>
                                <c:if test="${not empty message}">
                                  <b><c:out value="${message}"/></b>
                                </c:if>
                              </p>
                            </td>
                          </tr> 
                        </table>
                      </td>
                    </tr>
                </table>
                </div>
                <!-- Fin Cuerpo central de la página-->
              </td>
              <td><img width="1" src="images/vide.gif"></td>
            </tr>
          </table>
        </td>        
      </tr>
      <!-- Fin Parte Central de la Página-->
    </table></div>
  </body>
</html>
