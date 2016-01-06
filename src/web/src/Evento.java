import java.util.Date;

public class Evento
{
    private Date fecha;
    private String descripcion;

    public Evento(String descripcion)
    {
        this.fecha = new Date();
        this.descripcion = descripcion;
    }
}
