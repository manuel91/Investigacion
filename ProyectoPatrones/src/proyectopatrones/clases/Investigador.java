/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones.clases;

import java.sql.DriverManager;
import java.sql.SQLException;
import proyectopatrones.clases.Usuario;
import proyectopatrones.interfaz.InvestigadorInterface;

/**
 *
 * @author Alejandro
 */
public class Investigador extends Usuario{
    private String[] datos;
    
    public String[] getDatos(){
        return datos;
    }
    
    public Investigador( String[] datos){
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
        InvestigadorInterface i = new InvestigadorInterface();
        i.setVisible(true);
        
    }
 
}
