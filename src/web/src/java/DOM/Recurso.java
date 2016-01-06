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
public abstract class Recurso
{
    private float tarifa;
    private String id;
    private String descripcion;
    private boolean habilitado;

    public abstract boolean existe(String id);

    public abstract void habilitar(String id);

    public abstract void inhabilitar(String id);

    public abstract void crear(String id, float tarifa, String descripcion);

    public abstract void modificar(String id, float tarifa, String descripcion);
}
