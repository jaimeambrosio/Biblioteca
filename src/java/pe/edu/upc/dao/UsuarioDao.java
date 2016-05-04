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
    
    public Usuario validar(String cod,String pass)throws Exception
    {
        String sql = "SELECT * FROM usuario WHERE codUsuario=? AND clave=?";
        Usuario u = null;
        Connection cn = ConectaDB.getConnection();
        PreparedStatement pst = cn.prepareStatement(sql   );
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
    
    public ArrayList<TipoUsuario> listTipoUsuario()throws Exception
    {
        ArrayList<TipoUsuario> list = new ArrayList<>();
        String sql ="SELECT * FROM tipousuario";
        Connection cn = ConectaDB.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs =ps.executeQuery();
        while (rs.next()) {
            TipoUsuario t= new  TipoUsuario();
            t.setIdTipoUsuario(rs.getInt(1));
            t.setNombreTUsuario(rs.getString(2));
            t.setObservacion(rs.getString(3));
        }
        rs.close();
        ps.close();
        cn.close();
        return list;
    }
    
    public void registrarUsuario(Usuario u)throws Exception
    {
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
}
