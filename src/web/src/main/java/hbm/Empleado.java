/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbm;

/**
 *
 * @author Cristina
 */
public class Empleado {
    private int id;
    private String cedula;
    private String nombre;

    public Empleado(){}


    public int getId()
    {
        return this.id;
    }

    private void setId(int id)
    {
        this.id = id;
    }

    public String getCedula()
    {
        return this.cedula;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void setCedula(String cedula)
    {
        this.cedula = cedula;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
}
