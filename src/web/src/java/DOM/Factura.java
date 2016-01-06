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

public class Factura
{
    private Date fecha;
    private float valor;
    private boolean estado_pagado;

    public Factura(float valor)
    {
        this.fecha = new Date();
        this.valor = valor;
        this.estado_pagado = false;
    }

    public void pagar()
    {
        this.estado_pagado = true;
    }
}
