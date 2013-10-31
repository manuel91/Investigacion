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
public class RegistrarInvestigacion extends CreadorCaso{
    @Override
    public Caso_de_Investigacion FactoryMethod(String[] datos, Connection conn) {
        return new Investigacion(datos, conn);
    }
}
