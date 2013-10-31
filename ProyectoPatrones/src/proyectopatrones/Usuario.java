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
public class Usuario {
    public Connection con;
    public CreadorCaso creadorI, creadorR, creadorF;
    
    public void RegistrarCaso(){}
    public void AbrirCaso(){}
    public void CerrarCaso(){}
    public void RealizarSeguimiento(){}
}
