/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones;

import java.util.Date;

import java.sql.DriverManager;
import java.sql.Connection;
import java.lang.ClassNotFoundException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Alejandro
 */
public class Caso_de_Investigacion {
    public int nro_exp;
    public String investigador;
    public String fecha_inicio;
    public int dias;
    public int mes;
    public String movil_afectado;
    public String tipos_de_caso;
    public String tipos_de_irregularidad;
    public String subtipos_de_irregularidad;
    public String objetivo_agraviado;
    public String incidencia;
    public int duracion;
    public String descripcion;
    public String area_apoyo;
    public String deteccion_procedencia;
    public String diagnostico_detalle;
    public String actuaciones_acciones;
    public String concluciones;
    public String recomendaciones;
    public String observaciones;
    public String soporte;
    public String estado;
    
    protected Connection con;
    
    public void RegistrarCaso(){
        try{    
            String sql = "insert into casos_de_investigacion (fecha_inicio, dias, mes, movil_afectado, tipo_de_caso, tipo_de_irregularidad, "
                    + "subtipo_de_irregularidad, objetivo_agraviado, incidencia, duracion, descripcion, area_apoyo, deteccion_procedencia, "
                    + "diagnostico_detalle, actuaciones_acciones, soporte, estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, fecha_inicio);
            ps.setString(2, Integer.toString(dias));
            ps.setString(3, Integer.toString(mes));
            ps.setString(4, movil_afectado);
            ps.setString(5, tipos_de_caso);
            ps.setString(6, tipos_de_irregularidad);
            ps.setString(7, subtipos_de_irregularidad);
            ps.setString(8, objetivo_agraviado);
            ps.setString(9, incidencia);
            ps.setString(10, Integer.toString(duracion));
            ps.setString(11, descripcion);
            ps.setString(12, area_apoyo);
            ps.setString(13, deteccion_procedencia);
            ps.setString(14, diagnostico_detalle);
            ps.setString(15, actuaciones_acciones);
            ps.setString(16, soporte);
            ps.setString(17, estado);
            
            int aux = ps.executeUpdate();
            if(aux>0) JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete"); 
        }
        catch(Exception e){ JOptionPane.showMessageDialog(null, "Error" + e.getMessage());  }
    }
}
