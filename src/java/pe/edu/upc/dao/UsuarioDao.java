/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.upc.entity.TipoUsuario;
import pe.edu.upc.entity.Usuario;

/**
 *
 * @author Jaime Ambrosio
 */
public class UsuarioDao {

    public Usuario validar(String cod, String pass) throws Exception {
        String sql = "SELECT * FROM usuario WHERE codUsuario=? AND clave=?";
        Usuario u = null;
        Connection cn = ConectaDB.getConnection();
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, cod);
        pst.setString(2, pass);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            u = new Usuario();
            u.setCodUsuario(rs.getString(1));
            u.setNombre(rs.getString(2));
            u.setApellido(rs.getString(3));
            u.setCorreo(rs.getString(4));
            u.setClave(rs.getString(5));
            u.setIdTipoUsuario(rs.getInt(6));
        }
        rs.close();
        pst.close();
        cn.close();
        return u;
    }

    public ArrayList<TipoUsuario> listTipoUsuario() throws Exception {
        ArrayList<TipoUsuario> list = new ArrayList<>();
        String sql = "SELECT * FROM tipousuario";
        Connection cn = ConectaDB.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            TipoUsuario t = new TipoUsuario();
            t.setIdTipoUsuario(rs.getInt(1));
            t.setNombreTUsuario(rs.getString(2));
            t.setObservacion(rs.getString(3));
            list.add(t);
        }
        rs.close();
        ps.close();
        cn.close();
        return list;
    }

    public void registrarUsuario(Usuario u) throws Exception {
        String sql = "INSERT INTO usuario VALUES(?,?,?,?,?,?);";
        Connection cn = ConectaDB.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, u.getCodUsuario());
        ps.setString(2, u.getNombre());
        ps.setString(3, u.getApellido());
        ps.setString(4, u.getCorreo());
        ps.setString(5, u.getClave());
        ps.setInt(6, u.getIdTipoUsuario());
        ps.executeUpdate();
        ps.close();
        cn.close();
    }

    public ArrayList<Usuario> searchUsuarios(Usuario u) throws Exception {
        ArrayList<Usuario> list = new ArrayList<Usuario>();
        String sql = "SELECT u.codUsuario,u.nombre,u.apellido,u.correo,u.TIPOUSUARIO_idTipoUsuario,t.nombreTUsuario FROM usuario u INNER JOIN tipousuario t on t.idTipoUsuario = u.TIPOUSUARIO_idTipoUsuario  ";
        if (u.getCodUsuario() != null) {
            sql += " WHERE u.codUsuario LIKE '%" + u.getCodUsuario() + "%' ";
        }
        if (u.getNombre() != null) {
            sql += " AND u.nombre LIKE '%" + u.getNombre() + "%' ";
        }
        if (u.getApellido() != null) {
            sql += " AND u.apellido LIKE '%" + u.getApellido() + "%' ";
        }

        Connection cn = ConectaDB.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Usuario us = new  Usuario();
            us.setCodUsuario(rs.getString(1));
            us.setNombre(rs.getString(2));
            us.setApellido(rs.getString(3));
            us.setCorreo(rs.getString(4));
            us.setIdTipoUsuario(rs.getInt(5));
            us.setNombreTUsuario(rs.getString(6));
            list.add(us);
        }
        return list;
    }
}
