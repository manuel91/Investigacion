/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones.interfaz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import proyectopatrones.clases.Caso_de_Investigacion;
import proyectopatrones.clases.RegistrarFraude;
import proyectopatrones.clases.RegistrarInvestigacion;
import proyectopatrones.clases.RegistrarRobo;
import proyectopatrones.clases.Usuario;

/**
 *
 * @author Alejandro
 */
public class FormularioCasos extends javax.swing.JFrame {
    private Statement stmt;
    private ResultSet res;
    private String id;
    private int typeU;
    private Usuario user;


            
    /**
     * Creates new form FormularioCasos
     */
    public FormularioCasos(){
        initComponents();
    }
    
    public FormularioCasos(Usuario user, int typeU, String id) {
        initComponents();
        this.user = user;
        this.typeU = typeU;
        this.id = id;
        
        if(id != null){
            String[] irr = {"Activación de Servicios", "Detección Brecha en Proceso", "Estafa", "Hurto - Robo", "Inspección Análisis de Crédito",
                            "Irregularidad Administrativa", "Irregularidad Laboral", "Liberación de Serial", "Negación Serial", "Solicitud de Información",
                            "Uso Indebido de Línea", "Indebido de Sistemas"};

            String[] sub_irr = {"Activación de Líneas", "Activación de Servicios", "Aplicación de Ajustes", "Cambio de Datos", "Cambio de Móvil",
                            "Cambio de Plan", "Canjes de Puntos", "Consulta de Datos", "Consulta Detalle de Llamadas", "Desconexión de Línea",
                            "Equipos Celulares", "Facturación de Planes - Promociones", "Fuga de Información", "Suministro de Claves", "Transferencia de Saldos",
                            "Usurpación de Identidad"};
            
            String[] typeC = {"Robo", "Fraude", "Investigación"};
            
            String sql = "select fecha_inicio, dias, mes, movil_afectado, tipo_de_caso, tipo_de_irregularidad, "
                    + "subtipo_de_irregularidad, objetivo_agraviado, incidencia, duracion, descripcion, area_apoyo, deteccion_procedencia, "
                    + "diagnostico_detalle, actuaciones_acciones, soporte from casos_de_investigacion where nro_expediente = "+id;
            
            try{
                stmt = user.con.createStatement();
                res = stmt.executeQuery(sql);    
                while (res.next()){
                    fecha_inicio.setText(res.getString(1));
                    dias.setText(res.getString(2));
                    mes.setText(res.getString(3));
                    movil_afectado.setText(res.getString(4));
                    
                    for(int i = 0; i < 3; i++){
                        if(res.getString(5).equals(typeC[i])){
                            tipo_caso.setSelectedIndex(i);
                            break;
                        }
                    }
                    
                    for(int i = 0; i < 12; i++){
                        if(res.getString(6).equals(irr[i])){
                            tipo_irregularidad.setSelectedIndex(i);
                            break;
                        }
                    }
                    
                    for(int i = 0; i < 16; i++){
                        if(res.getString(7).equals(sub_irr[i])){
                            subtipo_irregularidad.setSelectedIndex(i);
                            break;
                        }
                    }
                    
                    objetivo_agraviado.setText(res.getString(8));
                    incidencia.setText(res.getString(9));
                    duracion.setText(res.getString(10));
                    descripcion.setText(res.getString(11));
                    area_apoyo.setText(res.getString(12));
                    deteccion_procedencia.setText(res.getString(13));
                    diagnostico.setText(res.getString(14));
                    actuaciones_acciones.setText(res.getString(15));
                    soporte.setText(res.getString(16));                
                }
            }catch ( SQLException e) { e.printStackTrace();  }
            send.setText("Modificar");
        }
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
        jLabel1 = new javax.swing.JLabel();
        dias = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fecha_inicio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mes = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        movil_afectado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        objetivo_agraviado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        duracion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tipo_caso = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        tipo_irregularidad = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        subtipo_irregularidad = new javax.swing.JComboBox();
        actuaciones_acciones = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        area_apoyo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        send = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        diagnostico = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        deteccion_procedencia = new javax.swing.JTextField();
        cerrar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        incidencia = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        soporte = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Registrar Caso de Investigación");

        jLabel2.setText("Fecha de inicio");

        jLabel3.setText("Ej: AAAA-MM-DD");

        jLabel4.setText("Días");

        jLabel5.setText("Mes");

        jLabel6.setText("Móvil Afectado");

        jLabel7.setText("Ej: 4161234567");

        jLabel8.setText("Objetivo/Agraviado");

        objetivo_agraviado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objetivo_agraviadoActionPerformed(evt);
            }
        });

        jLabel9.setText("Duración");

        jLabel10.setText("Tipo de Caso");

        tipo_caso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Robo", "Fraude", "Investigación" }));

        jLabel11.setText("Tipo de Irregularidad");

        tipo_irregularidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activación de Servicios", "Detección Brecha en Proceso", "Estafa", "Hurto - Robo", "Inspección Análisis de Crédito", "Irregularidad Administrativa", "Irregularidad Laboral", "Liberación de Serial", "Negación Serial", "Solicitud de Información", "Uso Indebido de Línea", "Uso Indebido de Sistemas" }));

        jLabel12.setText("Subtipo de Irregularidad");

        subtipo_irregularidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activación de Líneas", "Activación de Servicios", "Aplicación de Ajustes", "Cambio de Datos", "Cambio de Móvil", "Cambio de Plan", "Canjes de Puntos", "Consulta de Datos", "Consulta Detalle de Llamadas", "Desconexión de Línea", "Equipos Celulares", "Facturación de Planes - Promociones", "Fuga de Información", "Suministro de Claves", "Transferencia de Saldos", "Usurpación de Identidad" }));

        jLabel13.setText("Actuaciones/Acciones");

        jLabel14.setText("Área de Apoyo a resolver");

        send.setText("Registrar");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        jLabel15.setText("Descripción");

        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane1.setViewportView(descripcion);

        jLabel16.setText("Diagnóstico");

        diagnostico.setColumns(20);
        diagnostico.setRows(5);
        jScrollPane4.setViewportView(diagnostico);

        jLabel18.setText("Detección/Procedencia");

        cerrar.setText("Cancelar");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });

        jLabel17.setText("Incidencia");

        jLabel19.setText("Soporte");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel19))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane4)
                                        .addComponent(jScrollPane1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(cerrar)
                                                .addComponent(soporte, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                            .addComponent(send))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel18))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(area_apoyo, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(deteccion_procedencia)
                                        .addComponent(actuaciones_acciones, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(18, 18, 18))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(34, 34, 34)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addGap(30, 30, 30)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(subtipo_irregularidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tipo_irregularidad, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fecha_inicio, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(movil_afectado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(26, 26, 26)
                                        .addComponent(tipo_caso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(incidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(objetivo_agraviado))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(dias, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo_caso, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objetivo_agraviado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dias, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movil_afectado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(incidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo_irregularidad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subtipo_irregularidad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actuaciones_acciones, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(area_apoyo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deteccion_procedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soporte, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cerrar)
                    .addComponent(send))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cerrarActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        String[] datos= new String[16];
        
        /*String sql = "insert into casos_de_investigacion (fecha_inicio, dias, mes, movil_afectado, tipo_de_caso, tipo_de_irregularidad, "
                    + "subtipo_de_irregularidad, objetivo_agraviado, incidencia, duracion, descripcion, area_apoyo, deteccion_procedencia, "
                    + "diagnostico_detalle, actuaciones_acciones, soporte, estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";*/
        
        datos[0] = fecha_inicio.getText();
        datos[1] = dias.getText();
        datos[2] = mes.getText();
        datos[3] = movil_afectado.getText(); 
        datos[4] = objetivo_agraviado.getText();
        datos[5] = (String) tipo_irregularidad.getSelectedItem();
        datos[6] = (String) subtipo_irregularidad.getSelectedItem();   
        datos[7] = incidencia.getText();
        datos[8] = duracion.getText();
        datos[9] = descripcion.getText();
        datos[10] = area_apoyo.getText();
        datos[11] = deteccion_procedencia.getText();
        datos[12] = diagnostico.getText();
        datos[13] = actuaciones_acciones.getText();
        datos[14] = soporte.getText();
        
        switch(typeU){
            case 0:
                datos[15] = "Abierto";
                 break;
             case 1:
                datos[15] = "Asignado";
                break;
        }
            
        int typeC = tipo_caso.getSelectedIndex();
        
        if(id != null)
            user.GestionarCaso(datos, id, (String) tipo_caso.getSelectedItem(), false);
        else
            user.CrearCaso(datos, typeC);

        this.setVisible(false);
    }//GEN-LAST:event_sendActionPerformed

    private void objetivo_agraviadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objetivo_agraviadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objetivo_agraviadoActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioCasos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioCasos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioCasos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioCasos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FormularioCasos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actuaciones_acciones;
    private javax.swing.JTextField area_apoyo;
    private javax.swing.JButton cerrar;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JTextField deteccion_procedencia;
    private javax.swing.JTextArea diagnostico;
    private javax.swing.JTextField dias;
    private javax.swing.JTextField duracion;
    private javax.swing.JTextField fecha_inicio;
    private javax.swing.JTextField incidencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField mes;
    private javax.swing.JTextField movil_afectado;
    private javax.swing.JTextField objetivo_agraviado;
    private javax.swing.JButton send;
    private javax.swing.JTextField soporte;
    private javax.swing.JComboBox subtipo_irregularidad;
    private javax.swing.JComboBox tipo_caso;
    private javax.swing.JComboBox tipo_irregularidad;
    // End of variables declaration//GEN-END:variables
}
