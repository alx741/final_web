package hbm;

import java.util.Date;

import hbm.Factura;
import hbm.Recurso;
import hbm.Paquete;
import hbm.Ruta;
import hbm.Cliente;
import hbm.Empleado;

public class Guia
{
    private int id;
    private Date fecha_creacion;
    private Date fecha_salida;
    private Date fecha_llegada;
    // private Recurso paquete;
    // private Recurso ruta;
    // private Cliente cliente;
    // private Empleado empleado;
    // private Factura factura;
    // private String descripcion_contenido;
    // private Evento eventos[];

    public Guia()
    {
    }

    public int getId()
    {
        return id;
    }

    private void setId(int id)
    {
        this.id = id;
    }

    public Date getFecha_creacion()
    {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion)
    {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_salida()
    {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida)
    {
        this.fecha_salida = fecha_salida;
    }

    public Date getFecha_llegada()
    {
        return fecha_llegada;
    }

    public void setFecha_llegada(Date fecha_llegada)
    {
        this.fecha_llegada = fecha_llegada;
    }

    // public Recurso getPaquete()
    // {
    //     return paquete;
    // }

    // public void setPaquete(Recurso paquete)
    // {
    //     this.paquete = paquete;
    // }
}
