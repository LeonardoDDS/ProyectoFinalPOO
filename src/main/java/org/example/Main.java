package org.example;

import org.example.Controlador.ControladorElementoTP;
import org.example.Modelo.ElementoTablaPeriodica;
import org.example.Persistencia.ElementoTDB;
import org.example.Vista.VentanaTPeriodica;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        VentanaTPeriodica ventana = new VentanaTPeriodica("Tabla periodica");
        ControladorElementoTP controller = new ControladorElementoTP(ventana);
        //try {
          //  ele.insertar("1");
        //}catch (SQLException sqle){

        //}
    }
}