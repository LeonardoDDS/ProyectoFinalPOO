package org.example.Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaTPeriodica extends JFrame {
    private JLabel lblId, lblId2;
    private JLabel lblNomElemento, lblNomElemento2;
    private JLabel lblSQuimico, lblSQuimico2;
    private JLabel lblCategoria, lblCategoria2;
    private JLabel lblNumAtomico, lblNumAtomico2;
    private JLabel lblURL, lblURL2;
    private JLabel lblImagen, lblEliminar;
    private JTextField txtId, txtId2, txtEliminar;
    private JTextField txtNomElemento, txtNomElemento2;
    private JTextField txtSQuimico, txtSQuimico2;
    private JTextField txtCategoria, txtCategoria2;
    private JTextField txtNumAtomico, txtNumAtomico2;
    private JTextField txtURL, txtURL2;
    private JButton btnAgregar, btnCambiar, btnEliminar;
    private JTable tabla;
    private JScrollPane scroll;
    private JButton btnActualizar;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    public VentanaTPeriodica(String title) throws HeadlessException {
        super(title);
        this.setSize(950, 700);
        //layout
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);
        //panel 1
        panel1 = new JPanel(new GridLayout(12, 2));
        panel1.setBackground(new Color(217, 108, 199));
        this.getContentPane().add(panel1, 0);
        //etiquetas panel1
        lblId = new JLabel("Id");
        lblNomElemento = new JLabel("Nombre del elemento");
        lblNumAtomico = new JLabel("Número atómico");
        lblSQuimico = new JLabel("Simbolo químico");
        lblCategoria = new JLabel("Categoria (3)");
        lblURL = new JLabel("URL de la imagen");
        //texto panel1
        txtId = new JTextField(3);
        //para qwue no se pueda editar el ID
        txtId.setText("0");
        txtId.setEnabled(false);
        txtNomElemento = new JTextField(10);
        txtNumAtomico = new JTextField(5);
        txtSQuimico = new JTextField(5);
        txtCategoria = new JTextField(10);
        txtURL = new JTextField(30);
        //boton agregar
        btnAgregar = new JButton("Agregar");
        //agrego al panel
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblNomElemento);
        panel1.add(txtNomElemento);
        panel1.add(lblNumAtomico);
        panel1.add(txtNumAtomico);
        panel1.add(lblSQuimico);
        panel1.add(txtSQuimico);
        panel1.add(lblCategoria);
        panel1.add(txtCategoria);
        panel1.add(lblURL);
        panel1.add(txtURL);
        //boton agregar a la derecha
        panel1.add(new JLabel());
        panel1.add(btnAgregar);

        //panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(120, 69, 191));
        this.getContentPane().add(panel2, 1);
        //tabla
        tabla = new JTable();
        //el scroll de la tabla
        scroll = new JScrollPane(tabla);
        //boton de actualizar
        btnActualizar = new JButton("Actualizar");
        panel2.add(btnActualizar);
        panel2.add(scroll);


        //panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(2, 62, 115));
        this.getContentPane().add(panel3, 2);
        lblImagen = new JLabel("Imagen del elemento");
        panel3.add(lblImagen);

        //panel 4
        panel4 = new JPanel(new GridLayout(12, 2));
        panel4.setBackground(new Color(4, 135, 217));
        this.getContentPane().add(panel4, 3);
        //etiquetas panel4
        lblId2 = new JLabel("Id: ");
        lblNomElemento2 = new JLabel("Nombre del elemento: ");
        lblNumAtomico2 = new JLabel("Numero atomico: ");
        lblSQuimico2 = new JLabel("Simbolo quimico: ");
        lblCategoria2 = new JLabel("Categoria: ");
        lblURL2 = new JLabel("URL: ");
        txtId2 = new JTextField(3);
        txtNomElemento2 = new JTextField(10);
        txtNumAtomico2 = new JTextField(5);
        txtSQuimico2 = new JTextField(5);
        txtCategoria2 = new JTextField(10);
        txtURL2 = new JTextField(30);
        btnEliminar = new JButton("Eliminar");
        lblEliminar = new JLabel("Id de la fila a eliminar");
        txtEliminar = new JTextField(3);
        btnCambiar = new JButton("Cambiar");
        //añadimos etiquetas
        panel4.add(lblId2);
        panel4.add(txtId2);
        panel4.add(lblNomElemento2);
        panel4.add(txtNomElemento2);
        panel4.add(lblNumAtomico2);
        panel4.add(txtNumAtomico2);
        panel4.add(lblSQuimico2);
        panel4.add(txtSQuimico2);
        panel4.add(lblCategoria2);
        panel4.add(txtCategoria2);
        panel4.add(lblURL2);
        panel4.add(txtURL2);
        //para qwue el boton cambiar este a la derecha
        panel4.add(new JLabel());
        panel4.add(btnCambiar);
        panel4.add(lblEliminar);
        panel4.add(txtEliminar);
        //para poner el boton eliminar a la derecha
        panel4.add(new JLabel());
        panel4.add(btnEliminar);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //para centrar la ventana
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblId2() {
        return lblId2;
    }

    public void setLblId2(JLabel lblId2) {
        this.lblId2 = lblId2;
    }

    public JLabel getLblNomElemento() {
        return lblNomElemento;
    }

    public void setLblNomElemento(JLabel lblNomElemento) {
        this.lblNomElemento = lblNomElemento;
    }

    public JLabel getLblNomElemento2() {
        return lblNomElemento2;
    }

    public void setLblNomElemento2(JLabel lblNomElemento2) {
        this.lblNomElemento2 = lblNomElemento2;
    }

    public JLabel getLblSQuimico() {
        return lblSQuimico;
    }

    public void setLblSQuimico(JLabel lblSQuimico) {
        this.lblSQuimico = lblSQuimico;
    }

    public JLabel getLblSQuimico2() {
        return lblSQuimico2;
    }

    public void setLblSQuimico2(JLabel lblSQuimico2) {
        this.lblSQuimico2 = lblSQuimico2;
    }

    public JLabel getLblCategoria() {
        return lblCategoria;
    }

    public void setLblCategoria(JLabel lblCategoria) {
        this.lblCategoria = lblCategoria;
    }

    public JLabel getLblCategoria2() {
        return lblCategoria2;
    }

    public void setLblCategoria2(JLabel lblCategoria2) {
        this.lblCategoria2 = lblCategoria2;
    }

    public JLabel getLblNumAtomico() {
        return lblNumAtomico;
    }

    public void setLblNumAtomico(JLabel lblNumAtomico) {
        this.lblNumAtomico = lblNumAtomico;
    }

    public JLabel getLblNumAtomico2() {
        return lblNumAtomico2;
    }

    public void setLblNumAtomico2(JLabel lblNumAtomico2) {
        this.lblNumAtomico2 = lblNumAtomico2;
    }

    public JLabel getLblURL() {
        return lblURL;
    }

    public void setLblURL(JLabel lblURL) {
        this.lblURL = lblURL;
    }

    public JLabel getLblURL2() {
        return lblURL2;
    }

    public void setLblURL2(JLabel lblURL2) {
        this.lblURL2 = lblURL2;
    }

    public JLabel getLblImagen() {
        return lblImagen;
    }

    public void setLblImagen(JLabel lblImagen) {
        this.lblImagen = lblImagen;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtId2() {
        return txtId2;
    }

    public void setTxtId2(JTextField txtId2) {
        this.txtId2 = txtId2;
    }

    public JTextField getTxtNomElemento() {
        return txtNomElemento;
    }

    public void setTxtNomElemento(JTextField txtNomElemento) {
        this.txtNomElemento = txtNomElemento;
    }

    public JTextField getTxtNomElemento2() {
        return txtNomElemento2;
    }

    public void setTxtNomElemento2(JTextField txtNomElemento2) {
        this.txtNomElemento2 = txtNomElemento2;
    }

    public JTextField getTxtSQuimico() {
        return txtSQuimico;
    }

    public void setTxtSQuimico(JTextField txtSQuimico) {
        this.txtSQuimico = txtSQuimico;
    }

    public JTextField getTxtSQuimico2() {
        return txtSQuimico2;
    }

    public void setTxtSQuimico2(JTextField txtSQuimico2) {
        this.txtSQuimico2 = txtSQuimico2;
    }

    public JTextField getTxtCategoria() {
        return txtCategoria;
    }

    public void setTxtCategoria(JTextField txtCategoria) {
        this.txtCategoria = txtCategoria;
    }

    public JTextField getTxtCategoria2() {
        return txtCategoria2;
    }

    public void setTxtCategoria2(JTextField txtCategoria2) {
        this.txtCategoria2 = txtCategoria2;
    }

    public JTextField getTxtNumAtomico() {
        return txtNumAtomico;
    }

    public void setTxtNumAtomico(JTextField txtNumAtomico) {
        this.txtNumAtomico = txtNumAtomico;
    }

    public JTextField getTxtNumAtomico2() {
        return txtNumAtomico2;
    }

    public void setTxtNumAtomico2(JTextField txtNumAtomico2) {
        this.txtNumAtomico2 = txtNumAtomico2;
    }

    public JTextField getTxtURL() {
        return txtURL;
    }

    public void setTxtURL(JTextField txtURL) {
        this.txtURL = txtURL;
    }

    public JTextField getTxtURL2() {
        return txtURL2;
    }

    public void setTxtURL2(JTextField txtURL2) {
        this.txtURL2 = txtURL2;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCambiar() {
        return btnCambiar;
    }

    public void setBtnCambiar(JButton btnCambiar) {
        this.btnCambiar = btnCambiar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JTextField getTxtEliminar() {
        return txtEliminar;
    }

    public JLabel getLblEliminar() {
        return lblEliminar;
    }

    public void setLblEliminar(JLabel lblEliminar) {
        this.lblEliminar = lblEliminar;
    }

    public void setTxtEliminar(JTextField txtEliminar) {
        this.txtEliminar = txtEliminar;
    }

    public void limpiar() {
        txtNomElemento.setText("");
        txtNumAtomico.setText("");
        txtSQuimico.setText("");
        txtCategoria.setText("");
        txtURL.setText("");
    }
    public void limpiar2(){
        txtId2.setText("");
        txtNomElemento2.setText("");
        txtNumAtomico2.setText("");
        txtSQuimico2.setText("");
        txtCategoria2.setText("");
        txtURL2.setText("");
    }
}
