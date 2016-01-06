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
import java.util.Date;

public class Evento {
    private Date fecha;
    private String descripcion;

    public Evento(String descripcion)
    {
        this.fecha = new Date();
        this.descripcion = descripcion;
    }
}
 
