/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones.clases;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import proyectopatrones.clases.Usuario;
import proyectopatrones.interfaz.AdminInterface;

/**
 *
 * @author Alejandro
 */
public class Administrador extends Usuario {
    
    private String[] datos;
    
    public String[] getDatos(){
        return datos;
    }

    public Administrador(String[] datos){
        creadorI = new RegistrarInvestigacion();
        creadorR = new RegistrarRobo();
        creadorF = new RegistrarFraude();
        this.datos=datos;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/CasosInv", "root", "19441733");
        }
        /**** Excepción que se dispara si falla la carga del driver ****/
        catch( ClassNotFoundException e ) { e.printStackTrace();  }
        
       /**** Excepción que se dispara si falla la conexión *****/
        catch ( SQLException e) { e.printStackTrace();  }
        
        AdminInterface l = new AdminInterface();
        l.setVisible(true);
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
    
    
    public void ManejarPersonalAmonestado(String ci, boolean flag){
        try{
            String sql; 
            
            if(flag)
                sql= "update personal set amonestado=1 where cedula="+ci;
            else
                sql= "update personal set amonestado=0 where cedula="+ci;
            
            PreparedStatement ps = con.prepareStatement(sql);   
            
            int aux = ps.executeUpdate();
            if(aux>0){
                JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete");
            }
            
        } catch(Exception e){ JOptionPane.showMessageDialog(null, "Error" + e.getMessage()); }
        
    }
    
    public void ManejarEquiposRobados(String[] datos, String reg, boolean flag){
       try{
           String sql;
           if(!flag){
                if(reg != null)
                    sql = "update equipo_robado set nro_expediente = ?, serial = ?, tipo_equipo = ?, marca = ?, modelo = ?, observaciones = ? where nro_registro = "+reg;
                else
                    sql = "insert into equipo_robado (nro_expediente, serial, tipo_equipo, marca, modelo, observaciones) values (?,?,?,?,?,?)";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, datos[5]);
                ps.setString(2, datos[0]);
                ps.setString(3, datos[1]);
                ps.setString(4, datos[2]);
                ps.setString(5, datos[3]);
                ps.setString(6, datos[4]);

                int aux = ps.executeUpdate();

                if(aux>0) JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete");
           }else{
               sql = "delete from equipo_robado where nro_registro = "+reg;
               PreparedStatement ps = con.prepareStatement(sql);
               int aux = ps.executeUpdate();
               if(aux>0) JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete");
           }
            
        } catch(Exception e){ JOptionPane.showMessageDialog(null, "Error" + e.getMessage()); }
    }
    
    public void RegistrarPersonal(String[] datos){
        try{
            String sql = "insert into personal (cedula, nombre, apellido, empresa) values (?,?,?,?)";
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
    
    public void AsignarPersonal(String[] datos){
        try{
            String sql = "insert into personal_casos (nro_expediente, cedula) values (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);   
            ps.setString(1, datos[2]);
            ps.setString(2, datos[0]);
            int aux = ps.executeUpdate();
            if(aux>0){
                JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete");
            }
            
        } catch(Exception e){ JOptionPane.showMessageDialog(null, "Error" + e.getMessage()); }
    }
    
    public void GestionarPersonal(String[] datos, String id, boolean flag){
        try{
           String sql;
           int aux1 = 0, aux2 = 0;
           
           if(!flag){
                sql = "update personal set cedula = ? , nombre = ?, apellido = ?, empresa = ? where cedula = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, datos[0]);
                ps.setString(2, datos[1]);
                ps.setString(3, datos[2]);
                ps.setString(4, datos[3]);
                ps.setString(5, id);
                aux1 = ps.executeUpdate();
           }else{
               sql = "delete from personal where cedula = ?";
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setString(1, id);
               aux1 = ps.executeUpdate();
           }
           
           if(aux1>0){
               sql = "delete from personal_casos where cedula = ?";
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setString(1, id);
               aux2 = ps.executeUpdate();
               if(aux2>0) JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete");
           }
           
        } catch(Exception e){ JOptionPane.showMessageDialog(null, "Error" + e.getMessage()); } 
    }
    
    public void GestionarInvestigador(String[] datos, String id, boolean flag){
        try{
           String sql;
           int aux1 = 0, aux2 = 0;
           
           if(!flag){
                sql = "update investigador set cedula = ? , nombre = ?, apellido = ?, empresa = ? where cedula = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, datos[0]);
                ps.setString(2, datos[1]);
                ps.setString(3, datos[2]);
                ps.setString(4, datos[3]);
                ps.setString(5, id);
                aux1 = ps.executeUpdate();
           }else{
               sql = "delete from investigador where cedula = ?";
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setString(1, id);
               aux1 = ps.executeUpdate();
           }
           
           if(aux1>0){
               sql = "update casos_de_investigacion set investigador = ?, cedula_investigador = ?  where cedula_investigador = ?";
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setString(1, "-");
               ps.setString(2, "0");
               ps.setString(3, id);
               aux2 = ps.executeUpdate();
               if(aux2>0) JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamete");
           }
           
        } catch(Exception e){ JOptionPane.showMessageDialog(null, "Error" + e.getMessage()); } 
    }
    
    public void EmitirReporte(){}
    
}
