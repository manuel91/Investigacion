/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones.clases;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import proyectopatrones.clases.Usuario;

/**
 *
 * @author Alejandro
 */
public class Administrador extends Usuario {

    public Administrador(){
        creadorI = new RegistrarInvestigacion();
        creadorR = new RegistrarRobo();
        creadorF = new RegistrarFraude();
    
    }
    
    public void AsignarInvestigador(String[] datos){
        try{
            String sql = "update casos_de_investigacion set investigador = ? where nro_expediente = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, datos[0]);
            ps.setString(2, datos[1]);
            int aux = ps.executeUpdate();
            if(aux>0){
                JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete");
            } 
        } catch(Exception e){ JOptionPane.showMessageDialog(null, "Error" + e.getMessage()); }
    }
    
    
    public void MarcarArchivo(String id){
        try{
            String sql = "update casos_de_investigacion set estado = ? where nro_expediente = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "Negado");
            ps.setString(2, id);
            int aux = ps.executeUpdate();
            if(aux>0){
                JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete");
            } 
        } catch(Exception e){ JOptionPane.showMessageDialog(null, "Error" + e.getMessage()); }
    }
    
    
    public void ManejarPersonalAmonestado(){}
    public void ManejarEquiposRobados(){}
    public void EmitirReporte(){}
    
}
