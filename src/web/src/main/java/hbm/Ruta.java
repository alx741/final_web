package hbm;

public class Ruta
{
    private int id;
    private float tarifa;
    private String origen;
    private String destino;
    private String transporte;
    private boolean habilitado;

    public String getDescripcion()
    {
        return new String(this.origen + " - " + this.destino + " [" +
                this.transporte + "]");
    }

    public String getOrigen()
    {
        return origen;
    }

    public void setOrigen(String origen)
    {
        this.origen = origen;
    }

    public String getDestino()
    {
        return destino;
    }

    public void setDestino(String destino)
    {
        this.destino = destino;
    }

    public String getTransporte()
    {
        return transporte;
    }

    public void setTransporte(String transporte)
    {
        this.transporte = transporte;
    }

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

    public boolean isHabilitado()
    {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado)
    {
        this.habilitado = habilitado;
    }
}
