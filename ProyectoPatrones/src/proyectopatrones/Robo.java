/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones;

import java.sql.Connection;

/**
 *
 * @author Alejandro
 */
public class Robo extends Caso_de_Investigacion{
    public String serial;
    public String tipo_equipo;
    public String marca;
    public String modelo;
    
    Robo(String[] datos, Connection conn){
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
        tipos_de_caso = "Investigación";
    }
}
