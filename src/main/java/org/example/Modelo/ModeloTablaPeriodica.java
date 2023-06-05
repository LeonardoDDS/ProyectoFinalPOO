package org.example.Modelo;

import org.example.Persistencia.ElementoTDB;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaPeriodica implements TableModel {
    private ArrayList<ElementoTablaPeriodica> datos;
    public static final int COLUMS = 6;
    private ElementoTDB elementoTDB;

    public ModeloTablaPeriodica() {
        datos = new ArrayList<>();
        elementoTDB = new ElementoTDB();
    }

    public ModeloTablaPeriodica(ArrayList<ElementoTablaPeriodica> datos, ElementoTDB elementoTDB) {
        this.datos = datos;
        this.elementoTDB = elementoTDB;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return "Nombre del elemento";
            case 2:
                return "Numero atomico";
            case 3:
                return "Simbolo Quimico";
            case 4:
                return "Categoria";
            case 5:
                return "URL";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;

        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ElementoTablaPeriodica tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getNomElemento();
            case 2:
                return tmp.getNumAtomico();
            case 3:
                return tmp.getSimbolQuimico();
            case 4:
                return tmp.getCategoria();
            case 5:
                return tmp.getUrlElemento();

        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                break;
            case 1:
                datos.get(rowIndex).setNomElemento((String) o);
                break;
            case 2:
                datos.get(rowIndex).setNumAtomico((Integer) o);
                break;
            case 3:
                datos.get(rowIndex).setSimbolQuimico((String) o);
                break;
            case 4:
                datos.get(rowIndex).setCategoria((String) o);
                break;
            case 5:
                datos.get(rowIndex).setUrlElemento((String) o);
                break;
            default:
                System.out.println("No se modifico");
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void cargarDatos() {
        try {
            ArrayList<ElementoTablaPeriodica> ele = elementoTDB.obtenerTodo();
            System.out.println(ele);
            datos = elementoTDB.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }

    }

    public boolean agregarElemento(ElementoTablaPeriodica etp) {
        boolean resultado = false;
        try {
            if (elementoTDB.insertar(etp)) {
                datos.add(etp);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public ElementoTablaPeriodica obtenerElementoTP(int rowIndex) throws IndexOutOfBoundsException{
        return datos.get(rowIndex);
    }
    public boolean actualizarElemento(ElementoTablaPeriodica etp){
        boolean result = false;
        try {
            if (elementoTDB.update(etp)){
                result = true;
            }else {
                result = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return result;
    }
    public boolean eliminarFila(int id){
        boolean result = false;
        try {
            if (elementoTDB.delete(Integer.toString(id))){
                result = true;
            }else {
                result = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return result;
    }
    public  ElementoTablaPeriodica buscarPorId(int id){
        ElementoTablaPeriodica result = null;
        try {
            result = (ElementoTablaPeriodica) elementoTDB.buscarPorId(Integer.toString(id));
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return result;
    }
}
