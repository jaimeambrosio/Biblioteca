/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.test;

import pe.edu.upc.dao.ConectaDB;

/**
 *
 * @author Jaime Ambrosio
 */
public class test1 {
    public static void main(String[] args) {
        try {
            ConectaDB.getConnection().close();
            System.out.println("Correcto");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
