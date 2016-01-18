package hbm;

public class Paquete
{
    private int id;
    private float tarifa;
    private String rawDesc;
    private float desde;
    private float hasta;
    private boolean habilitado;

    public String getDescripcion()
    {
        return new String(this.rawDesc + " [" +
                Float.toString(this.desde) + " - " +
                Float.toString(this.hasta) + " Kg]");
    }

    public String getRawDesc()
    {
        return rawDesc;
    }

    public void setRawDesc(String rawDesc)
    {
        this.rawDesc = rawDesc;
    }

    public float getDesde()
    {
        return desde;
    }

    public void setDesde(float desde)
    {
        this.desde = desde;
    }

    public float getHasta()
    {
        return hasta;
    }

    public void setHasta(float hasta)
    {
        this.hasta = hasta;
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
