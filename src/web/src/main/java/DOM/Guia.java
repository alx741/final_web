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
import hbm.Cliente;
import hbm.Empleado;
import java.util.Date;

public class Guia
{
    private Recurso paquete;
    private Recurso ruta;
    private Cliente cliente;
    private Empleado empleado;
    private Factura factura;
    private String descripcion_contenido;
    private Date fecha_creación;
    private Date fecha_salida;
    private Date fecha_llegada;
    private Evento eventos[];

    public Guia()
    {
    }
}