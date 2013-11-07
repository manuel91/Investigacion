/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones.clases;

import java.sql.DriverManager;
import java.sql.SQLException;
import proyectopatrones.clases.Usuario;

/**
 *
 * @author Alejandro
 */
public class Investigador extends Usuario{
    public Investigador(){
        creadorI = new RegistrarInvestigacion();
        creadorR = new RegistrarRobo();
        creadorF = new RegistrarFraude();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/CasosInv", "root", "");
        }
        /**** Excepción que se dispara si falla la carga del driver ****/
        catch( ClassNotFoundException e ) { e.printStackTrace();  }
        
       /**** Excepción que se dispara si falla la conexión *****/
        catch ( SQLException e) { e.printStackTrace();  }
    }
}
