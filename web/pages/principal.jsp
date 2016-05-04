<%-- 
    Document   : principal
    Created on : 03/05/2016, 04:30:35 PM
    Author     : Jaime Ambrosio
--%>

<%@page import="pe.edu.upc.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario u = null;
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
        <title>Sistema de biblioteca - <%=u.getNombre()%> </title>
        <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap-theme.css" />

    </head>
    <body  >
        <div class="container" >
            <nav class="navbar navbar-default" role="navigation" >
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menuPrincipal" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">Sistema de biblioteca</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="menuPrincipal">
                        <ul class="nav navbar-nav">
                            <li><a href="#">Link</a></li>
                            <li class="active" ><a href="#">Link</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">One more separated link</a></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">

                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">
                                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                    <%=u.getNombre()%> 
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Mi perfil</a></li>
                                    <li><a href="#">Cerrar Sesion</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
                                    <div style="width: 150px;">
                <ul class="nav nav-pills nav-stacked">
                    <li role="presentation" class="active"><a href="#">Home</a></li>
                    <li role="presentation"><a href="#">Profile</a></li>
                    <li role="presentation"><a href="#">Messages</a></li>
                </ul>
            </div>

        </div>
        <script type="text/javascript" src="../js/jquery.js" ></script>
        <script type="text/javascript" src="../bootstrap/js/bootstrap.js" ></script>
    </body>
</html>
