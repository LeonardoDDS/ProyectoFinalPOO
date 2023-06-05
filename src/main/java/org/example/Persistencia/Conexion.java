package org.example.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String baseDatos;
    public static Conexion _instance;
    public Connection connection;

    //evita que alguien de fuera cree objetos
    private Conexion (String dataBase){
        this.baseDatos = dataBase;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+this.baseDatos);
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Conexion getInstance(String baseDatos) {
        if(_instance == null){
            _instance = new Conexion(baseDatos);
        }else{
            System.out.println("Ya fué creada.");
        }
        return _instance;
    }
    //metodo de acceso para la conexion
    public Connection getConnection() {
        return connection;
    }
}
