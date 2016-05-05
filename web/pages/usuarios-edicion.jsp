<%-- 
    Document   : principal
    Created on : 03/05/2016, 04:30:35 PM
    Author     : Jaime Ambrosio
--%>

<%@page import="pe.edu.upc.dao.UsuarioDao"%>
<%@page import="java.util.ArrayList"%>
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
        <link rel="stylesheet" type="text/css" href="../bootstrap/css/datatable.min.css" />

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
                            <li role="presentation" class=""><a href="usuarios-nuevo.jsp">Nuevo usuario</a></li>
                            <li role="presentation" class="active"><a href="usuarios-edicion.jsp">Edicion de usuario</a></li>
                        </ul>
                    </div>
                </div>
                <label></label>
                <div class="col-sm-9">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Busqueda</h3>
                        </div>
                        <div class="panel-body">
                            <form action="" method="POST" >
                                <div class="row" >
                                    <div class="col-sm-6" >
                                        <div class="form-group">
                                            <label>Codigo de usuario</label>
                                            <input type="text" class="form-control"  name="txtCodigo" placeholder="Codigo"  >
                                        </div>
                                    </div>
                                    <div class="col-sm-6" >
                                        <div class="form-group">
                                            <label>Nombres</label>
                                            <input type="text" class="form-control"  name="txtNombre" placeholder="Nombres" >
                                        </div>
                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="col-sm-6" >
                                        <div class="form-group">
                                            <label>Apellido</label>
                                            <input type="text" class="form-control"  name="txtApellido" placeholder="Apellido"  >
                                        </div>
                                    </div>
                                    <div class="col-sm-3" ></div>
                                    <div class="col-sm-3" >
                                        <div class="form-group">
                                            <label></label>
                                            <input type="submit" class="form-control btn btn-primary" value="Buscar"   >
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <table id="tbUsuariosEdicion" class="display nowrap" cellspacing="0" width="100%">
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Correo</th>
                                <th>...</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                Usuario usuBus = new Usuario(request.getParameter("txtCodigo"), request.getParameter("txtNombre"), request.getParameter("txtApellido"), null, null, null, null);
                                UsuarioDao dao = new UsuarioDao();
                                ArrayList<Usuario> listUsu = dao.searchUsuarios(usuBus);
                                if (listUsu != null)
                                    for (Usuario item : listUsu) {
                            %>
                            <tr>
                                <td><%=item.getCodUsuario()%></td>
                                <td><%=item.getNombre()%></td>
                                <td><%=item.getApellido()%></td>
                                <td><%=item.getCorreo()%></td>
                                <td>
                                    <a href="#" title="Editar"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a> &nbsp;&nbsp;&nbsp;
                                    <a href="#" title="Eliminar"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                            <%}%>

                        </tbody>
                    </table>

                </div>
            </div>

        </div>
        <script type="text/javascript" src="../js/jquery.js" ></script>
        <script type="text/javascript" src="../bootstrap/js/bootstrap.js" ></script>
        <script type="text/javascript" src="../bootstrap/js/datatable.min.js" ></script>
        <script>
            $().ready(function () {
                $("#liUsuarios").addClass("active");
                $("#tbUsuariosEdicion").DataTable({
                    "scrollX": true
                });
            });

        </script>
    </body>
</html>
