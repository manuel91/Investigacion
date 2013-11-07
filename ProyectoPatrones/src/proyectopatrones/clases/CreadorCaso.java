/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones.clases;

import java.sql.Connection;

/**
 *
 * @author Alejandro
 */
abstract public class CreadorCaso {
    public abstract Caso_de_Investigacion FactoryMethod(String[] datos, Connection conn);
}
