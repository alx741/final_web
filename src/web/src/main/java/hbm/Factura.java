package hbm;


import java.util.Date;

public class Factura
{
    private int id;
    private Cliente cliente;
    private Date fecha;
    private float valor;
    private boolean pagado;

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public Cliente getCliente()
    {
        return this.cliente;
    }

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

    public boolean isPagado()
    {
        return pagado;
    }

    public void setPagado(boolean pagado)
    {
        this.pagado = pagado;
    }
}
