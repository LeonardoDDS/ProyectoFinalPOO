package org.example.Controlador;

import org.example.Modelo.ElementoTablaPeriodica;
import org.example.Modelo.ModeloTablaPeriodica;
import org.example.Vista.VentanaTPeriodica;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControladorElementoTP extends MouseAdapter {
    //creamos una vista y un modelo para controlar
    private VentanaTPeriodica view;
    private ModeloTablaPeriodica modelo;

    public ControladorElementoTP(VentanaTPeriodica view) {
        this.view = view;
        modelo = new ModeloTablaPeriodica();
        this.view.getTabla().setModel(modelo);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnCambiar().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);
        this.view.getTabla().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //boton de actualizar tabla
        if (e.getSource() == this.view.getBtnActualizar()) {
            modelo.cargarDatos();
            this.view.getTabla().setModel(modelo);
            this.view.getTabla().updateUI();
        }
        //boton agregar a la tabla
        if (e.getSource() == this.view.getBtnAgregar()) {
            try {
                modelo.cargarDatos();
                this.view.getTabla().setModel(modelo);
                this.view.getTabla().updateUI();
                ElementoTablaPeriodica etp = new ElementoTablaPeriodica();
                etp.setId(0);
                etp.setNomElemento(this.view.getTxtNomElemento().getText());
                etp.setNumAtomico(Integer.parseInt(this.view.getTxtNumAtomico().getText()));
                etp.setSimbolQuimico(this.view.getTxtSQuimico().getText());
                etp.setCategoria(this.view.getTxtCategoria().getText());
                etp.setUrlElemento(this.view.getTxtURL().getText());
                //esto me lo duplica
                //modelo.agregarElemento(etp);
                //this.view.getTabla().updateUI();
                //this.view.limpiar();
                if (modelo.agregarElemento(etp)) {
                    JOptionPane.showMessageDialog(view, "Elemento agregado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    this.view.limpiar();
                    modelo.cargarDatos();
                    this.view.getTabla().setModel(modelo);
                    this.view.getTabla().updateUI();
                } else {
                    JOptionPane.showMessageDialog(view, "Error al agregar el elemento", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException nfe) {
                this.view.limpiar();
                JOptionPane.showMessageDialog(view, "La celda \"num atomico\" solo permite numeros enteros",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        //accion en la tabla para mostrar la imagen
        if (e.getSource() == this.view.getTabla()) {
            System.out.println("clic tabla");
            //el indice que se va a seleccionar
            int rowIndex = view.getTabla().getSelectedRow();
            ElementoTablaPeriodica etp = modelo.obtenerElementoTP(rowIndex);
            view.getLblImagen().setText("");
            view.getLblImagen().setIcon(etp.IconElemento());
        }
        //para el boton eliminar
        if (e.getSource() == this.view.getBtnEliminar()) {
            try {
                if (modelo.buscarPorId(Integer.parseInt(this.view.getTxtEliminar().getText())) == null) {
                    JOptionPane.showMessageDialog(view, "No existe el id", "Aviso", JOptionPane.ERROR_MESSAGE);
                    this.view.getTxtEliminar().setText("");
                } else {
                    int result = JOptionPane.showConfirmDialog(view, "Eliminar fila? " + this.view.getTxtEliminar().getText() +
                            "\nBorrar fila", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (result == JOptionPane.YES_OPTION) {
                        if (modelo.eliminarFila(Integer.parseInt(this.view.getTxtEliminar().getText()))) {
                            JOptionPane.showMessageDialog(view, "Elemento eliminado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                            this.view.getTxtEliminar().setText("");
                            modelo.cargarDatos();
                            this.view.getTabla().setModel(modelo);
                            this.view.getTabla().updateUI();
                        }
                    } else {
                        JOptionPane.showMessageDialog(view, "Accion cancelada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        this.view.getTxtEliminar().setText("");
                        modelo.cargarDatos();
                        this.view.getTabla().setModel(modelo);
                        this.view.getTabla().updateUI();
                    }
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(view, "El ID debe ser un numero entero", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        //para el boton cambiar datos de un elemento
        if (e.getSource() == this.view.getBtnCambiar()) {
            try {
                ElementoTablaPeriodica etp = new ElementoTablaPeriodica();
                etp.setId(Integer.parseInt(this.view.getTxtId().getText()));
                etp = modelo.buscarPorId(Integer.parseInt(this.view.getTxtId2().getText()));

                if (view.getTxtNomElemento2().getText().equals("")) {

                } else {
                    etp.setNomElemento(view.getTxtNomElemento2().getText());
                }
                if (view.getTxtNumAtomico2().getText().equals("")) {

                } else {
                    etp.setNumAtomico(Integer.parseInt(view.getTxtNumAtomico2().getText()));
                }
                if (view.getTxtSQuimico2().getText().equals("")) {

                } else {
                    etp.setSimbolQuimico(view.getTxtSQuimico2().getText());
                }
                if (view.getTxtCategoria2().getText().equals("")) {

                } else {
                    etp.setCategoria(view.getTxtCategoria2().getText());
                }
                if (view.getTxtURL2().getText().equals("")) {

                } else {
                    etp.setUrlElemento(view.getTxtURL2().getText());

                }
                //actualizacion podria salir mal
                if (etp == null) {
                    JOptionPane.showMessageDialog(view, "No existe el ID", "Aviso", JOptionPane.ERROR_MESSAGE);
                    this.view.getTxtEliminar().setText("");
                } else {
                    if (modelo.actualizarElemento(etp)) {
                        JOptionPane.showMessageDialog(view, "Se actualizo correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        modelo.cargarDatos();
                        this.view.getTabla().setModel(modelo);
                        this.view.getTabla().updateUI();
                        this.view.limpiar2();
                    } else {
                        JOptionPane.showMessageDialog(view, "No se pudo actualizar", "Aviso", JOptionPane.ERROR_MESSAGE);
                        modelo.cargarDatos();
                        this.view.getTabla().setModel(modelo);
                        this.view.getTabla().updateUI();
                        this.view.limpiar2();
                    }
                }

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(view, "El ID debe ser un numero entero", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }catch (NullPointerException npe){
                System.out.println(npe.getMessage());
            }
        }
    }
}
