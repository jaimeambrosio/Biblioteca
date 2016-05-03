/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
}
