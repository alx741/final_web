/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOM;

/**
 *
 * @author Cristina
 */
public class Empleado {
    private String cedula;
    private String nombre;

    public Empleado(String cedula, String nombre)
    {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getCedula()
    {
        return this.cedula;
    }

    public String getNombre()
    {
        return this.nombre;
    }
}
