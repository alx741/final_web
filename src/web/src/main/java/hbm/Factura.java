package hbm;


import java.util.Date;

public class Factura
{
    private int id;
    private Date fecha;
    private float valor;
    private boolean estado_pagado;

    public Factura()
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

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public float getValor()
    {
        return valor;
    }

    public void setValor(float valor)
    {
        this.valor = valor;
    }

    public boolean isEstado_pagado()
    {
        return estado_pagado;
    }

    public void setEstado_pagado(boolean estado_pagado)
    {
        this.estado_pagado = estado_pagado;
    }
}
