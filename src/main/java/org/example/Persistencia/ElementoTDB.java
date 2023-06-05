package org.example.Persistencia;

import org.example.Modelo.ElementoTablaPeriodica;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ElementoTDB implements InterfazTabla{

    public ElementoTDB() {

    }
    //no se necesita declarar el try y catch porque ya se esta diciendo que
    //el metodo puede lanzar una excepcion
    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO elementosTablaPeriodica(nomElemento, numAtomico, simbolQuimico, categoria, url) VALUES (?, ?, ?, ?, ?)";
        int rowCount = 0;
        PreparedStatement pstm =Conexion.getInstance("tablaPeriodica.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((ElementoTablaPeriodica) obj).getNomElemento());
        pstm.setInt(2, ((ElementoTablaPeriodica) obj).getNumAtomico());
        pstm.setString(3, ((ElementoTablaPeriodica) obj).getSimbolQuimico());
        pstm.setString(4, ((ElementoTablaPeriodica) obj).getCategoria());
        pstm.setString(5, ((ElementoTablaPeriodica) obj).getUrlElemento());
        rowCount = pstm.executeUpdate();
        return rowCount > 0 ;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE elementosTablaPeriodica SET nomElemento = ?, numAtomico = ?, simbolQuimico = ?, categoria = ?, url = ? WHERE id = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm =Conexion.getInstance("tablaPeriodica.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((ElementoTablaPeriodica) obj).getNomElemento());
        pstm.setInt(2, ((ElementoTablaPeriodica) obj).getNumAtomico());
        pstm.setString(3, ((ElementoTablaPeriodica) obj).getSimbolQuimico());
        pstm.setString(4, ((ElementoTablaPeriodica) obj).getCategoria());
        pstm.setString(5, ((ElementoTablaPeriodica) obj).getUrlElemento());
        pstm.setInt(6, ((ElementoTablaPeriodica) obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0 ;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete ="DELETE FROM elementosTablaPeriodica WHERE id = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm =Conexion.getInstance("tablaPeriodica.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sqlTodo = "SELECT * FROM elementosTablaPeriodica";
        ArrayList<ElementoTablaPeriodica> resultado = new ArrayList<>();
        Statement stm = Conexion.getInstance("tablaPeriodica.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sqlTodo);
        while (rst.next()){
            //puede salir un error por como acomode el rst.get...
            resultado.add(new ElementoTablaPeriodica(rst.getInt(1), rst.getString(2),
                    rst.getInt(3), rst.getString(4), rst.getString(5), rst.getString(6)));
        }
        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM elementosTablaPeriodica WHERE id = ? ; ";
        ElementoTablaPeriodica elemento = null;

        PreparedStatement pstm =Conexion.getInstance("tablaPeriodica").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            elemento =new ElementoTablaPeriodica(rst.getInt(1), rst.getString(2),rst.getInt(3),
                    rst.getString(4), rst.getString(5), rst.getString(6));
            return elemento;
        }
        return null;
    }
}
