<%-- 
    Document   : modalRegistroUsuario
    Created on : 04/05/2016, 02:55:52 PM
    Author     : Jaime Ambrosio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="modal fade" id="modalRegistroAlumno" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="usuarioServlet?accion=REGISTRAR" method="POST" autocomplete="off" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        Registro de usuario
                    </h4>
                </div>
                <div class="modal-body">

                    <div class="row" >
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label>Codigo de usuario</label>
                                <input type="text" class="form-control"  name="txtRegCodigoUsuario" placeholder="Codigo" required="required" >
                            </div>
                        </div>
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label >Contraseña</label>
                                <input type="password" class="form-control" name="txtRegContrasenia" placeholder="Contraseña" required="required" >
                            </div>
                        </div>
                    </div>
                    <div class="row" >
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label>Nombres</label>
                                <input type="text" class="form-control" id="txtNombre" name="txtNombre" placeholder="Nombres" required="required" >
                            </div>
                        </div>
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label>Apellidos</label>
                                <input type="text" class="form-control" id="txtApellidos" name="txtApellidos" placeholder="Apellidos" required="required" >
                            </div> 
                        </div>
                    </div>
                    <div class="row" >
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label>Correo</label>
                                <input type="email" class="form-control" id="txtCorreo" name="txtCorreo" placeholder="Correo" required="required" >
                            </div> 
                        </div>
                        <div class="col-sm-6" >
                            <input type="hidden" name="txtTipoUsuario" value="12" >

                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    <input type="submit" class="btn btn-primary" value="Registrar" >
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
