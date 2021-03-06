/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.upc.dao.UsuarioDao;
import pe.edu.upc.entity.Usuario;

/**
 *
 * @author Jaime Ambrosio
 */
@WebServlet(name = "usuarioServlet", urlPatterns = {"/usuarioServlet"})
public class usuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "LOGIN": {
                login(request, response);
                break;
            }
            case "CERRARSESION": {
                cerrarSesion(request, response);
                break;
            }
            case "REGISTRAR": {
                registrar(request, response);
                break;
            }
            case "ELIMINAR": {
                eliminar(request, response);
                break;
            }

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String codigo = request.getParameter("txtCodigo");
        String pass = request.getParameter("txtContrasenia");
        UsuarioDao dao = new UsuarioDao();
        try {
            Usuario usuario = dao.validar(codigo, pass);
            if (usuario != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("usuario", usuario);
                response.sendRedirect("pages/catalogo.jsp");
            } else {
                request.setAttribute("mensaje", "Codigo o constraseña incorrecto.");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            request.setAttribute("mensaje", e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            try {
                rd.forward(request, response);
            } catch (Exception ex) {

            }
        }

    }

    private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        session.invalidate();
        try {
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
        }

    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {

        try {
            Usuario u = new Usuario();
            u.setCodUsuario(request.getParameter("txtRegCodigoUsuario").trim());
            u.setClave(request.getParameter("txtRegContrasenia").trim());
            u.setNombre(request.getParameter("txtNombre").trim());
            u.setApellido(request.getParameter("txtApellidos").trim());
            u.setCorreo(request.getParameter("txtCorreo").trim());
            u.setIdTipoUsuario(Integer.valueOf(request.getParameter("txtTipoUsuario")));
            UsuarioDao dao = new UsuarioDao();
            dao.registrarUsuario(u);
            response.sendRedirect("pages/usuarios-nuevo.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            UsuarioDao dao=new UsuarioDao();
            dao.eliminarUsuario(request.getParameter("codUsuario"));
            response.sendRedirect("pages/usuarios-edicion.jsp?busq=ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
