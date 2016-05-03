/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jaime Ambrosio
 */
public class ConectaDB {

    public static Connection getConnection() throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bibliotecadb?zeroDateTimeBehavior=convertToNull";
        String usuario = "root";
        String clave = "root1";
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException e) {
            throw new Exception("No se pudo acceder a la base de datos.");
        } catch (ClassNotFoundException c) {
            throw new Exception("No se encontro el driver de conexion.");
        }
    }

}
