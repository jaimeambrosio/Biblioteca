<%-- 
    Document   : index
    Created on : 03/05/2016, 11:24:19 AM
    Author     : Jaime Ambrosio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.css" />
        <link rel="stylesheet" type="text/css" href="css/styleLogin.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" >

            <form action="usuarioServlet?accion=LOGIN" method="POST" class="form-ini">
                <div class="form-group">
                    <h2 align="center" >Ingreso al Sistema</h2>
                    <img  src="img/usu.jpg" class="img-thumbnail" >
                </div>
                <div class="form-group">
                    <label for="txtCodigo">Codigo de usuario</label>
                    <input type="text" class="form-control" id="txtCodigo" name="txtCodigo" placeholder="ejemplo : D000X">
                </div>
                <div class="form-group">
                    <label for="txtContrasenia">Contraseña</label>
                    <input type="password" class="form-control" id="txtContrasenia" name="txtContrasenia" placeholder="Password">
                </div>
                <div class="form-group" align="center">
                    <input type="submit" value="Ingresar" class="btn btn-primary" >
                </div>
                <% if (request.getAttribute("mensaje") != null) {
                %>
                <div class="alert alert-warning alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>Atención </strong> <%=request.getAttribute("mensaje")%>
                </div>

                <%
                        request.removeAttribute("mensaje");
                    }
                %>

            </form>

        </div> <!-- /container -->
        <script type="text/javascript" src="js/jquery.js" ></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.js" ></script>
    </body>
</html>
