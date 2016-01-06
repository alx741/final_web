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
