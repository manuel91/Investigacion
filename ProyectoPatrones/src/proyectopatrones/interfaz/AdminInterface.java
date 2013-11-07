/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectopatrones.interfaz;

import java.awt.Color;
import proyectopatrones.clases.Administrador;
import proyectopatrones.interfaz.FormularioCasos;
import java.sql.DriverManager;
import java.sql.Connection;
import java.lang.ClassNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import proyectopatrones.Alarmas;

/**
 *
 * @author Alejandro
 */
public class AdminInterface extends javax.swing.JFrame {
    private Statement stmt;
    private ResultSet res;
    private String[] fila;
    private DefaultTableModel model;
    private FormularioCasos formulario_casos;
    private FormularioCierre formulario_cierre;
    private FormularioAsignacion formulario_asignacion;
    private FormularioSeguimiento formulario_seguimiento;
    private FormularioInvestigador formulario_investigador;
    private FormularioAmonestados formulario_amonestados;
    private TablaAmonestados tabla_amonestados;
    private TablaRobos tabla_robos;
    private DatosRobo datos_robo;
    private Administrador admin;
    private ArrayList ci_inv;
    
    ArrayList AlertY;
    ArrayList AlertO;
    ArrayList AlertR;
    
    
    /**
     * Creates new form AdminInterface
     */
    public AdminInterface(){
        initComponents();
        admin = new Administrador();
        try{
           AlertY = new ArrayList();
           AlertO = new ArrayList();
           AlertR = new ArrayList();
           
           ci_inv = new ArrayList();
           /**** avisamos ****/
           //System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
           //System.out.println( "Si no se hubiera producido, se habría disparado SQLException");
           
           fila = new String[4];
           stmt = admin.con.createStatement();
           RefreshCartelera();
        }
        
        catch ( SQLException e) { e.printStackTrace();  }
    }
    
    public void RefreshCartelera(){
        try{
            res = stmt.executeQuery("select nro_expediente, tipo_de_caso, investigador, estado, duracion, cedula_investigador from casos_de_investigacion");
            String titulos[] = {"Nro Expediente", "Tipo de Caso", "Investigador", "Estado"};
            model = new DefaultTableModel(null, titulos);
            
            int id = 0;
            int nivel;
            
            ci_inv.clear();
            AlertY.clear();
            AlertO.clear();
            AlertR.clear();
            
            while (res.next()){
               //System.out.println(res.getString(1) + " " + res.getString(2) + " " + res.getString(3) + " " + res.getString(4));
               fila[0] = res.getString(1);
               fila[1] = res.getString(2);
               fila[2] = res.getString(3);
               fila[3] = res.getString(4);
               nivel = Integer.parseInt(res.getString(5));
               
               ci_inv.add(res.getString(6));

               if(nivel>30 && nivel<50)
                   AlertY.add(id);
               
               if(nivel>50 && nivel<70)
                   AlertO.add(id);
               
               if(nivel>70)
                   AlertR.add(id);

               id++;
               
               model.addRow(fila);
               
            }
            cartelera.setModel(model);
            cartelera.getColumnModel().getColumn(0).setCellRenderer(new Alarmas(AlertY, AlertO, AlertR));
            // cartelera.setDefaultRenderer(new YourTableCellRenderer());
        }
        catch ( SQLException e) { e.printStackTrace();  }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartelera = new javax.swing.JTable();
        admin_title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        crear = new javax.swing.JMenuItem();
        abrir = new javax.swing.JMenuItem();
        cerrar = new javax.swing.JMenuItem();
        marcar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        salir = new javax.swing.JMenuItem();
        registro = new javax.swing.JMenu();
        registrar = new javax.swing.JMenuItem();
        personal = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        asignar_inv = new javax.swing.JMenuItem();
        asignar_p = new javax.swing.JMenuItem();
        seguimiento = new javax.swing.JMenuItem();
        reportes = new javax.swing.JMenu();
        rep_op1 = new javax.swing.JMenuItem();
        rep_op2 = new javax.swing.JMenuItem();
        rep_op3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        personal_amonestado = new javax.swing.JMenu();
        consultar_amonestados = new javax.swing.JMenuItem();
        amonestar = new javax.swing.JMenuItem();
        info_robo = new javax.swing.JMenu();
        consultar_robados = new javax.swing.JMenuItem();
        equipos_robados = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cartelera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nro Expediente", "Tipo de Caso", "Investigador", "Estado"
            }
        ));
        jScrollPane1.setViewportView(cartelera);
        cartelera.getColumnModel().getColumn(0).setHeaderValue("Nro Expediente");
        cartelera.getColumnModel().getColumn(1).setHeaderValue("Tipo de Caso");
        cartelera.getColumnModel().getColumn(2).setHeaderValue("Investigador");
        cartelera.getColumnModel().getColumn(3).setHeaderValue("Estado");

        admin_title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        admin_title.setText("Bienvenido <Administrador>");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Casos de investigación ");

        refresh.setText("Refrescar");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(admin_title, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(247, 247, 247))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(refresh)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(admin_title, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(refresh)
                .addGap(21, 21, 21))
        );

        jMenu1.setText("Archivo");

        crear.setText("Crear caso");
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });
        jMenu1.add(crear);

        abrir.setText("Abrir caso");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        jMenu1.add(abrir);

        cerrar.setText("Cerrar caso");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        jMenu1.add(cerrar);

        marcar.setText("Marcar caso");
        marcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcarActionPerformed(evt);
            }
        });
        jMenu1.add(marcar);
        jMenu1.add(jSeparator1);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jMenu1.add(salir);

        jMenuBar1.add(jMenu1);

        registro.setText("Registrar");

        registrar.setText("Registrar investigador");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        registro.add(registrar);

        personal.setText("Registrar personal");
        personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalActionPerformed(evt);
            }
        });
        registro.add(personal);

        jMenuBar1.add(registro);

        jMenu2.setText("Acción");

        asignar_inv.setText("Asignar investigador");
        asignar_inv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignar_invActionPerformed(evt);
            }
        });
        jMenu2.add(asignar_inv);

        asignar_p.setText("Asignar personal");
        asignar_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignar_pActionPerformed(evt);
            }
        });
        jMenu2.add(asignar_p);

        seguimiento.setText("Realizar seguimiento");
        seguimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seguimientoActionPerformed(evt);
            }
        });
        jMenu2.add(seguimiento);

        reportes.setText("Emitir reporte");

        rep_op1.setText("Empresas con más casos registrados");
        rep_op1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rep_op1ActionPerformed(evt);
            }
        });
        reportes.add(rep_op1);

        rep_op2.setText("Investigadores con más casos atendidos");
        rep_op2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rep_op2ActionPerformed(evt);
            }
        });
        reportes.add(rep_op2);

        rep_op3.setText("Casos con más de 3 casos relacionados");
        rep_op3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rep_op3ActionPerformed(evt);
            }
        });
        reportes.add(rep_op3);

        jMenu2.add(reportes);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Manejar");

        personal_amonestado.setText("Personal Amonestado");

        consultar_amonestados.setText("Consultar");
        consultar_amonestados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultar_amonestadosActionPerformed(evt);
            }
        });
        personal_amonestado.add(consultar_amonestados);

        amonestar.setText("Amonestar");
        amonestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amonestarActionPerformed(evt);
            }
        });
        personal_amonestado.add(amonestar);

        jMenu3.add(personal_amonestado);

        info_robo.setText("Equipos Robados");

        consultar_robados.setText("Consultar");
        consultar_robados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultar_robadosActionPerformed(evt);
            }
        });
        info_robo.add(consultar_robados);

        equipos_robados.setText("Registrar");
        equipos_robados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipos_robadosActionPerformed(evt);
            }
        });
        info_robo.add(equipos_robados);

        jMenu3.add(info_robo);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
        formulario_casos = new FormularioCasos(admin, 1);
        formulario_casos.setVisible(true);
    }//GEN-LAST:event_crearActionPerformed

    private void marcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcarActionPerformed
        int fila = cartelera.getSelectedRow();
        if(fila != -1){
            String nro_exp = (String) cartelera.getValueAt(fila,0);
            String state = (String) cartelera.getValueAt(fila,3);
            if(!state.equals("Negado")){
                admin.MarcarArchivo(nro_exp);
            }else{
                JOptionPane.showMessageDialog(null, "Error: el caso se encuentra Negado");   
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: no ha sido seleccionado un caso de investigación");
        }
    }//GEN-LAST:event_marcarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.setVisible(false);
        try {
            admin.con.close();
        } catch ( SQLException e) { e.printStackTrace();  }
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        int fila = cartelera.getSelectedRow();
        if(fila != -1){
            String nro_exp = (String) cartelera.getValueAt(fila,0);
            String state = (String) cartelera.getValueAt(fila,3);
            if(state.equals("Cerrado")){
                admin.AbrirCaso(nro_exp);
            }else{
                JOptionPane.showMessageDialog(null, "Error: el caso se encuentra Abierto");   
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: no ha sido seleccionado un caso de investigación");
        }
    }//GEN-LAST:event_abrirActionPerformed

    private void seguimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seguimientoActionPerformed
        int fila = cartelera.getSelectedRow();
        if(fila != -1){
            String nro_exp = (String) cartelera.getValueAt(fila,0);
            String tipo_caso = (String) cartelera.getValueAt(fila,1);
            if(tipo_caso.equals("Fraude")){
                formulario_seguimiento = new FormularioSeguimiento(admin, nro_exp);
                formulario_seguimiento.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Error: el caso seleccionado tiene que ser de tipo Fraude");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: no ha sido seleccionado un caso de investigación");
        }
    }//GEN-LAST:event_seguimientoActionPerformed

    private void asignar_invActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignar_invActionPerformed
        int fila = cartelera.getSelectedRow();
        if(fila != -1){
            String nro_exp = (String) cartelera.getValueAt(fila,0);
            formulario_asignacion = new FormularioAsignacion(admin, nro_exp, true);
            formulario_asignacion.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Error: no ha sido seleccionado un caso de investigación");
        }
    }//GEN-LAST:event_asignar_invActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        RefreshCartelera();
    }//GEN-LAST:event_refreshActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        int fila = cartelera.getSelectedRow();
        if(fila != -1){
            String nro_exp = (String) cartelera.getValueAt(fila,0);
            String state = (String) cartelera.getValueAt(fila,3);
            if(!state.equals("Cerrado")){
                formulario_cierre = new FormularioCierre(admin, nro_exp);
                formulario_cierre.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Error: el caso se encuentra Cerrado");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: no ha sido seleccionado un caso de investigación");
        }
    }//GEN-LAST:event_cerrarActionPerformed

    private void rep_op1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rep_op1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rep_op1ActionPerformed

    private void rep_op2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rep_op2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rep_op2ActionPerformed

    private void rep_op3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rep_op3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rep_op3ActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        formulario_investigador = new FormularioInvestigador(admin, true);
        formulario_investigador.setVisible(true);
    }//GEN-LAST:event_registrarActionPerformed

    private void personalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalActionPerformed
       formulario_investigador = new FormularioInvestigador(admin, false);
       formulario_investigador.setVisible(true);
    }//GEN-LAST:event_personalActionPerformed

    private void asignar_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignar_pActionPerformed
        int fila = cartelera.getSelectedRow();
        if(fila != -1){
            String nro_exp = (String) cartelera.getValueAt(fila,0);
            formulario_asignacion = new FormularioAsignacion(admin, nro_exp, false);
            formulario_asignacion.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Error: no ha sido seleccionado un caso de investigación");
        }
    }//GEN-LAST:event_asignar_pActionPerformed

    private void equipos_robadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipos_robadosActionPerformed
     int fila = cartelera.getSelectedRow();
        if(fila != -1){
            String state = (String) cartelera.getValueAt(fila,3);
            String nro_exp = (String) cartelera.getValueAt(fila,0);
            if(state.equals("Negado")){
                datos_robo = new DatosRobo(admin,nro_exp);
                datos_robo.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Error: el caso no se encuentra Negado");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: no ha sido seleccionado un caso de investigación");
        }
    }//GEN-LAST:event_equipos_robadosActionPerformed

    private void amonestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amonestarActionPerformed
        int fila = cartelera.getSelectedRow();
        if(fila != -1){
            String state = (String) cartelera.getValueAt(fila,3);
            String nro_exp = (String) cartelera.getValueAt(fila,0);
            if(state.equals("Negado")){
                formulario_amonestados= new FormularioAmonestados(admin, nro_exp);
                formulario_amonestados.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Error: el caso no se encuentra Negado");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: no ha sido seleccionado un caso de investigación");
        }
    }//GEN-LAST:event_amonestarActionPerformed

    private void consultar_amonestadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultar_amonestadosActionPerformed
        int fila = cartelera.getSelectedRow();
        if(fila != -1){
            String state = (String) cartelera.getValueAt(fila,3);
            String nro_exp = (String) cartelera.getValueAt(fila,0);
            if(state.equals("Negado")){  
                tabla_amonestados = new TablaAmonestados(admin, nro_exp);
                tabla_amonestados.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Error: el caso no se encuentra Negado");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: no ha sido seleccionado un caso de investigación");
        }
    }//GEN-LAST:event_consultar_amonestadosActionPerformed

    private void consultar_robadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultar_robadosActionPerformed
        int fila = cartelera.getSelectedRow();
        if(fila != -1){
            String state = (String) cartelera.getValueAt(fila,3);
            String nro_exp = (String) cartelera.getValueAt(fila,0);
            if(state.equals("Negado")){  
                tabla_robos = new TablaRobos(admin, nro_exp);
                tabla_robos.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Error: el caso no se encuentra Negado");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: no ha sido seleccionado un caso de investigación");
        }
    }//GEN-LAST:event_consultar_robadosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdminInterface().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrir;
    private javax.swing.JLabel admin_title;
    private javax.swing.JMenuItem amonestar;
    private javax.swing.JMenuItem asignar_inv;
    private javax.swing.JMenuItem asignar_p;
    private javax.swing.JTable cartelera;
    private javax.swing.JMenuItem cerrar;
    private javax.swing.JMenuItem consultar_amonestados;
    private javax.swing.JMenuItem consultar_robados;
    private javax.swing.JMenuItem crear;
    private javax.swing.JMenuItem equipos_robados;
    private javax.swing.JMenu info_robo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem marcar;
    private javax.swing.JMenuItem personal;
    private javax.swing.JMenu personal_amonestado;
    private javax.swing.JButton refresh;
    private javax.swing.JMenuItem registrar;
    private javax.swing.JMenu registro;
    private javax.swing.JMenuItem rep_op1;
    private javax.swing.JMenuItem rep_op2;
    private javax.swing.JMenuItem rep_op3;
    private javax.swing.JMenu reportes;
    private javax.swing.JMenuItem salir;
    private javax.swing.JMenuItem seguimiento;
    // End of variables declaration//GEN-END:variables
}
