<%-- 
    Document   : principal
    Created on : 03/05/2016, 04:30:35 PM
    Author     : Jaime Ambrosio
--%>

<%@page import="pe.edu.upc.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario u = new Usuario();
    if (request.getSession().getAttribute("usuario") == null) {
        response.sendRedirect("../index.jsp");
    } else {
        u = (Usuario) request.getSession().getAttribute("usuario");

    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sistema de biblioteca - <%=u.getNombre()%> </title>
        <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap-theme.css" />
        <link rel="stylesheet" type="text/css" href="../css/styleMain.css" />

    </head>
    <body  >
        <div class="container" >
            <div class="row" ><%-- menu superior --%>
                <div class="col-xs-12" >
                    <%@include file="comun/menuSuperior.jsp" %>
                </div>
            </div>
            <div class="row" >
                <div class="col-sm-3">
                    <div ><%-- menu costado --%>
                        <ul class="nav nav-pills nav-stacked">
                            <li role="presentation" class="active"><a href="#">Home</a></li>
                            <li role="presentation"><a href="#">Profile</a></li>
                            <li role="presentation"><a href="#">Messages</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-9">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Panel title</h3>
                        </div>
                        <div class="panel-body">
                            Panel content
                        </div></div>
                </div>
            </div>
                        
        </div>
        <script type="text/javascript" src="../js/jquery.js" ></script>
        <script type="text/javascript" src="../bootstrap/js/bootstrap.js" ></script>
        <script>
            $().ready(function () {
                $("#liReserva").addClass("active");
            });

        </script>
    </body>
</html>
