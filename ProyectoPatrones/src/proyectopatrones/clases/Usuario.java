/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class Usuario {
    public Connection con;
    public CreadorCaso creadorI, creadorR, creadorF;
    
    public void CrearCaso(String[] datos, int typeC){
        Caso_de_Investigacion aux;
        switch(typeC){
            case 0:
                aux = creadorR.FactoryMethod(datos, con);
                aux.RegistrarCaso();
                break;
            case 1:
                aux = creadorF.FactoryMethod(datos, con);
                aux.RegistrarCaso();
                break;
            case 2:
                aux = creadorI.FactoryMethod(datos, con);
                aux.RegistrarCaso();
                break;
        }
    }
    
    public void AbrirCaso(String id){
        try{
            String sql = "update casos_de_investigacion set estado = ? where nro_expediente = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "Abierto");
            ps.setString(2, id);
            int aux = ps.executeUpdate();
            if(aux>0){
                JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete");
            } 
        } catch(Exception e){ JOptionPane.showMessageDialog(null, "Error" + e.getMessage()); }
    }

    public void CerrarCaso(String[] datos){
        try{
            String sql = "update casos_de_investigacion set observaciones = ?, conclusiones = ?, recomendaciones = ?, estado = ? where nro_expediente = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, datos[0]);
            ps.setString(2, datos[1]);
            ps.setString(3, datos[2]);
            ps.setString(4, datos[3]);
            ps.setString(5, datos[4]);
            int aux = ps.executeUpdate();
            if(aux>0){
                JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete");
            } 
        } catch(Exception e){ JOptionPane.showMessageDialog(null, "Error" + e.getMessage()); }
    }
    
    public void RealizarSeguimiento(String[] datos){
        try{
            String sql = "update seguimiento_fraude set actividades = ?, personas = ?, monto = ? where nro_expediente = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, datos[0]);
            ps.setString(2, datos[1]);
            ps.setString(3, datos[2]);
            ps.setString(4, datos[4]);

            int aux1 = ps.executeUpdate();
            if(aux1>0){
                sql = "update casos_de_investigacion set estado = ? where nro_expediente = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, datos[3]);
                ps.setString(2, datos[4]);
                
                int aux2 = ps.executeUpdate();
                if(aux2>0) JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete"); 
            } 
        } catch(Exception e){ JOptionPane.showMessageDialog(null, "Error" + e.getMessage()); } 
    }
    
    public void GestionarCaso(String[] datos, String id, String caso, boolean flag){
        try{
           String sql;  
            if(!flag){
                sql = "update casos_de_investigacion set fecha_inicio = ?, dias = ?, mes = ?, movil_afectado = ?, tipo_de_caso = ?, tipo_de_irregularidad = ?, "
                    + "subtipo_de_irregularidad = ?, objetivo_agraviado = ?, incidencia = ?, duracion = ?, descripcion = ?, area_apoyo = ?, deteccion_procedencia = ?, "
                    + "diagnostico_detalle = ?, actuaciones_acciones = ?, soporte = ? where nro_expediente = ?";

                PreparedStatement ps = con.prepareCall(sql);
                ps.setString(1, datos[0]);
                ps.setString(2, datos[1]);
                ps.setString(3, datos[2]);
                ps.setString(4, datos[3]);
                ps.setString(5, caso);
                ps.setString(6, datos[5]);
                ps.setString(7, datos[6]); 
                ps.setString(8, datos[4]);
                ps.setString(9, datos[7]);
                ps.setString(10, datos[8]);
                ps.setString(11, datos[9]);
                ps.setString(12, datos[10]);
                ps.setString(13, datos[11]);
                ps.setString(14, datos[12]);
                ps.setString(15, datos[13]);
                ps.setString(16, datos[14]);
                ps.setString(17, id);
                
                int aux = ps.executeUpdate();
                if(aux>0) JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete"); 
            }else{
                sql = "delete from casos_de_investigacion where nro_expediente = ?";
                PreparedStatement ps = con.prepareCall(sql);
                ps.setString(1, id);
                
                int aux1 = ps.executeUpdate();
                if(aux1>0){
                    sql = "delete from personal_casos where nro_expediente = ?";
                    ps = con.prepareCall(sql);
                    ps.setString(1, id);
                    int aux2 = ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete");
                }
            }       
        } catch(Exception e){ JOptionPane.showMessageDialog(null, "Error" + e.getMessage()); } 
    }
    
    public void CloseCon(){
        try {
            con.close();
        } catch ( SQLException e) { e.printStackTrace();  }
    }
}
