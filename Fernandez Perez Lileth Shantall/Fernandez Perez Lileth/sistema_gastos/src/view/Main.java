package view;

import controller.GastoController;
import repository.GastoRepository;
import service.GastoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;
import model.Gasto;

public class Main extends javax.swing.JFrame {

    private final GastoController controller;
    private List<Integer> idList = new ArrayList<>();

    public Main() {
        String url = "jdbc:mysql://localhost:3306/sistema_gastos";
        String user = "root";
        String password = "";
        GastoRepository repository = new GastoRepository(url, user, password);
        GastoService service = new GastoService(repository);
        controller = new GastoController(service);

        initComponents();
        this.setLocationRelativeTo(null);
        configurarTabla();
        initListeners();
        btnListarActionPerformed(null);

        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
    }

    private void configurarTabla() {
        tblDatos.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Descripción", "Categoría", "Monto", "Fecha"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // esto es para evitar que las celdas sean editables
            }
        });
    }

    private void initListeners() {
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = tblDatos.getSelectedRow();
                if (selectedRow != -1) {
                    String descripcion = (String) tblDatos.getValueAt(selectedRow, 0);
                    String categoria = (String) tblDatos.getValueAt(selectedRow, 1);
                    String monto = tblDatos.getValueAt(selectedRow, 2).toString();

                    txtDescripcion.setText(descripcion);
                    cbbCategoria.setSelectedItem(categoria);
                    txtMonto.setText(monto);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtMonto = new javax.swing.JTextField();
        cbbCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 90, -1));

        cbbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alimentación", "Transporte", "Entretenimiento", "Salud", "Otros" }));
        jPanel1.add(cbbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 130, -1));

        jLabel5.setText("Categoría:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel4.setText("Descripción:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel3.setText("Monto a gastar:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Gestión de Gastos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 240, 90));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese los datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 280, 210));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 80, -1));

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });
        jPanel1.add(btnListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 80, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 80, -1));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 80, -1));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblDatos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 370, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblDatos.getModel();
        model.setRowCount(0);
        idList.clear();

        List<Gasto> gastos = controller.listarGastos();

        for (Gasto gasto : gastos) {
            idList.add(gasto.getId());

            model.addRow(new Object[]{
                gasto.getDescripcion(),
                gasto.getCategoria(),
                gasto.getMonto(),
                gasto.getFechaGasto()
            });
        }
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String descripcion = txtDescripcion.getText();
        String categoria = (String) cbbCategoria.getSelectedItem();
        String montoTexto = txtMonto.getText();

        if (descripcion.isEmpty() || categoria == null || montoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        double monto;
        try {
            monto = Double.parseDouble(montoTexto);
            if (monto <= 0) {
                JOptionPane.showMessageDialog(this, "El monto debe ser mayor a 0.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El monto debe ser un valor numérico.");
            return;
        }

        double totalMensual = controller.obtenerTotalMensual();
        if (totalMensual + monto > 5000) {
            JOptionPane.showMessageDialog(this, "El gasto total mensual no puede exceder S/5000.");
            return;
        }

        String fecha = java.time.LocalDate.now().toString();
        controller.agregarGasto(descripcion, categoria, monto, fecha);

        JOptionPane.showMessageDialog(this, "Gasto agregado correctamente.");
        limpiarCampos();
        btnListarActionPerformed(null);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int selectedRow = tblDatos.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un gasto para editar.");
            return;
        }

        int id = idList.get(selectedRow);

        String descripcion = txtDescripcion.getText();
        String categoria = (String) cbbCategoria.getSelectedItem();
        String montoTexto = txtMonto.getText();

        if (descripcion.isEmpty() || categoria == null || montoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        double monto;
        try {
            monto = Double.parseDouble(montoTexto);
            if (monto <= 0) {
                JOptionPane.showMessageDialog(this, "El monto debe ser mayor a 0.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El monto debe ser un valor numérico.");
            return;
        }

        double totalMensual = controller.obtenerTotalMensual();
        double montoActual = Double.parseDouble(tblDatos.getValueAt(selectedRow, 2).toString());
        if (totalMensual - montoActual + monto > 5000) {
            JOptionPane.showMessageDialog(this, "El gasto total mensual no puede exceder S/5000.");
            return;
        }

        String fecha = java.time.LocalDate.now().toString();
        controller.editarGasto(id, descripcion, categoria, monto, fecha);

        JOptionPane.showMessageDialog(this, "Gasto editado correctamente.");
        limpiarCampos();
        btnListarActionPerformed(null);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int selectedRow = tblDatos.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un gasto para eliminar.");
            return;
        }

        int id = idList.get(selectedRow);

        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este gasto?");
        if (confirm == JOptionPane.YES_OPTION) {
            controller.eliminarGasto(id);
            JOptionPane.showMessageDialog(this, "Gasto eliminado correctamente.");
            limpiarCampos();
            btnListarActionPerformed(null);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void limpiarCampos() {
        txtDescripcion.setText("");
        cbbCategoria.setSelectedIndex(0);
        txtMonto.setText("");
    }

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JComboBox<String> cbbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
