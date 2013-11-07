/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones.clases;

import proyectopatrones.clases.Robo;
import java.sql.Connection;

/**
 *
 * @author Alejandro
 */
public class RegistrarRobo extends CreadorCaso{
    @Override
    public Caso_de_Investigacion FactoryMethod(String[] datos, Connection conn) {
        return new Robo(datos, conn);
    }
}
