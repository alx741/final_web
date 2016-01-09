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
public abstract class Recurso
{
    private int id;
    private float tarifa;
    private String descripcion;
    private boolean habilitado;
    
    public Recurso(){}
    
    /*
    public abstract boolean existe(String id);

    public abstract void habilitar(String id);

    public abstract void inhabilitar(String id);

    public abstract void crear(String id, float tarifa, String descripcion);

    public abstract void modificar(String id, float tarifa, String descripcion);
    */

    public int getId()
    {
        return id;
    }

    private void setId(int id)
    {
        this.id = id;
    }

    public float getTarifa()
    {
        return tarifa;
    }

    public void setTarifa(float tarifa)
    {
        this.tarifa = tarifa;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public boolean isHabilitado()
    {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado)
    {
        this.habilitado = habilitado;
    }
}
