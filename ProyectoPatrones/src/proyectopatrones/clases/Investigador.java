/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones.clases;

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
    }
}
