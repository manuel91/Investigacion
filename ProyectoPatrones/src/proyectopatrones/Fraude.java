/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class Fraude extends Caso_de_Investigacion{
    public String actividades;
    public String personas;
    public float monto;
    
    Fraude(String[] datos, Connection conn){
        con = conn;
        
        fecha_inicio = datos[0];
        dias = Integer.parseInt(datos[1]);
        mes  = Integer.parseInt(datos[2]);
        movil_afectado = datos[3];
        objetivo_agraviado = datos[4];
        tipos_de_irregularidad = datos[5];
        subtipos_de_irregularidad = datos[6];
        incidencia = datos[7];
        duracion = Integer.parseInt(datos[8]);
        descripcion = datos[9];
        area_apoyo = datos[10];
        deteccion_procedencia = datos[11];
        diagnostico_detalle = datos[12];
        actuaciones_acciones = datos[13];
        soporte = datos[14];
        estado = datos[15];
        tipos_de_caso = "Fraude";
    }
    
    @Override
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
            
            int aux1 = ps.executeUpdate();
            if(aux1>0){
                Statement stmt = con.createStatement();
                ResultSet res;
                res = stmt.executeQuery("select nro_expediente from casos_de_investigacion order by nro_expediente desc limit 1 ");

                String id = null;
                while (res.next()){
                    id = res.getString(1);
                }

                sql = "insert into seguimiento_fraude (nro_expediente) values (?)";
                ps = con.prepareCall(sql);
                ps.setString(1, id);
                int aux2 = ps.executeUpdate();

                if(aux2>0) JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete"); 
            }
        }
        catch(Exception e){ JOptionPane.showMessageDialog(null, "Error" + e.getMessage()); }
    }
}
