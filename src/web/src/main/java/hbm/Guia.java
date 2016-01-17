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
    private Recurso paquete;
    private Recurso ruta;
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

    public Recurso getPaquete()
    {
        return paquete;
    }

    public void setPaquete(Recurso paquete)
    {
        this.paquete = paquete;
    }

    public Recurso getRuta()
    {
        return ruta;
    }

    public void setRuta(Recurso ruta)
    {
        this.ruta = ruta;
    }
}
