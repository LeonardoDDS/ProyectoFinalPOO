package org.example.Modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ElementoTablaPeriodica {
    private int id;
    private String nomElemento; //nombre
    private int numAtomico; //numero atomico
    private String simbolQuimico; //simbolo quimico
    private String categoria; //si es metal, no metal o metaloide
    private String urlElemento; //imagen del elemento

    public ElementoTablaPeriodica() {
    }

    public ElementoTablaPeriodica(int id, String nomElemento, int numAtomico, String simbolQuimico, String categoria, String urlElemento) {
        this.id = id;
        this.nomElemento = nomElemento;
        this.numAtomico = numAtomico;
        this.simbolQuimico = simbolQuimico;
        this.categoria = categoria;
        this.urlElemento = urlElemento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomElemento() {
        return nomElemento;
    }

    public void setNomElemento(String nomElemento) {
        this.nomElemento = nomElemento;
    }

    public int getNumAtomico() {
        return numAtomico;
    }

    public void setNumAtomico(int numAtomico) {
        this.numAtomico = numAtomico;
    }

    public String getSimbolQuimico() {
        return simbolQuimico;
    }

    public void setSimbolQuimico(String simbolQuimico) {
        this.simbolQuimico = simbolQuimico;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUrlElemento() {
        return urlElemento;
    }

    public void setUrlElemento(String urlElemento) {
        this.urlElemento = urlElemento;
    }

    @Override
    public String toString() {
        return "TablaPeriodica{" +
                "id=" + id +
                ", nomElemento='" + nomElemento + '\'' +
                ", numAtomico='" + numAtomico + '\'' +
                ", simbolQuimico='" + simbolQuimico + '\'' +
                ", categoria='" + categoria + '\'' +
                ", urlElemento='" + urlElemento + '\'' +
                '}';
    }
    public ImageIcon IconElemento(){
        ImageIcon elemento= null;
        //preparamos una excepcion en el url de la imagen
        try {
            URL urlImagen = new URL(this.urlElemento);
            elemento = new ImageIcon(urlImagen);
        }catch (MalformedURLException mue){
            System.out.println(mue.toString());
        }
        return elemento;
    }
}
