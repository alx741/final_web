public class Empleado
{
    private String cedula;
    private String nombre;

    public Empleado(String cedula, String nombre)
    {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getCedula()
    {
        return this.cedula;
    }

    public String getNombre()
    {
        return this.nombre;
    }
}
