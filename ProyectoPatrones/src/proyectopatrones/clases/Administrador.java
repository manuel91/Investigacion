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
    
    public void RegistrarInvestigador(String[] datos){
        try{
            String sql = "insert into investigador (cedula, nombre, apellido, empresa) values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, datos[0]);
            ps.setString(2, datos[1]);
            ps.setString(3, datos[2]);
            ps.setString(4, datos[3]);
            int aux = ps.executeUpdate();
            if(aux>0){
                JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete");
            } 
        } catch(Exception e){ JOptionPane.showMessageDialog(null, "Error" + e.getMessage()); }
    }
    
    public void AsignarInvestigador(String[] datos){
        try{
            String sql = "update casos_de_investigacion set cedula_investigador = ?, investigador = ? where nro_expediente = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, datos[0]);
            ps.setString(2, datos[1]);
            ps.setString(3, datos[2]);
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
    
    
    public void ManejarPersonalAmonestado(String[] datos, String ci){
        try{
            String sql = "update investigador set cedula = ?, nombre = ?, apellido = ?, empresa = ? where cedula = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, datos[0]);
            ps.setString(2, datos[1]);
            ps.setString(3, datos[2]);
            ps.setString(4, datos[3]);
            ps.setString(5, ci);
            int aux1 = ps.executeUpdate();
            
            if(aux1>0){
                sql = "update casos_de_investigacion set cedula_investigador = ?, investigador = ? where cedula_investigador = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, datos[0]);
                ps.setString(2, datos[1]+" "+datos[2]);
                ps.setString(3, ci);
                int aux2 = ps.executeUpdate();
                if(aux2>0) JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete");
            } 
            
        } catch(Exception e){ JOptionPane.showMessageDialog(null, "Error" + e.getMessage()); }
    }
    
    public void ManejarEquiposRobados(String[] datos){
        try{
            String sql = "update equipo_robado set serial = ?, tipo_equipo = ?, marca = ?, modelo = ? where nro_expediente = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, datos[0]);
            ps.setString(2, datos[1]);
            ps.setString(3, datos[2]);
            ps.setString(4, datos[3]);
            ps.setString(5, datos[5]);
            int aux1 = ps.executeUpdate();
            
            if(aux1>0){
                sql = "update casos_de_investigacion set observaciones = ? where nro_expediente = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, datos[4]);
                ps.setString(2, datos[5]);

                int aux2 = ps.executeUpdate();
                if(aux2>0) JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete");
            } 
            
        } catch(Exception e){ JOptionPane.showMessageDialog(null, "Error" + e.getMessage()); }
        
    }
    
    public void EmitirReporte(){}
    
}
