/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones.clases;

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
public abstract class Caso_de_Investigacion {
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
    
    public abstract void RegistrarCaso();
    
    
}
