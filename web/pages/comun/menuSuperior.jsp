<%-- 
    Document   : menuSuperior
    Created on : 04/05/2016, 11:10:03 AM
    Author     : Jaime Ambrosio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default" role="navigation" >
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menuPrincipal" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Sistema de biblioteca</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="menuPrincipal">
            <ul class="nav navbar-nav">
                <li class="" id="liCatalogo" ><a href="catalogo.jsp">Catalogo</a></li>
                <li class="" id="liReserva" ><a href="reserva.jsp">Reserva</a></li>
                <li class="" id="liUsuarios" ><a href="usuarios-nuevo.jsp">Usuarios</a></li>
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
                        <li><a href="../usuarioServlet?accion=CERRARSESION">Cerrar Sesion</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
