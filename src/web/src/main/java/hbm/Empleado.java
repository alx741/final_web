package hbm;

public class Empleado
{
    private int id;
    private String cedula;
    private String nombre;
    private String password;

    public Empleado() {}


    public int getId()
    {
        return this.id;
    }

    private void setId(int id)
    {
        this.id = id;
    }

    public String getCedula()
    {
        return this.cedula;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void setCedula(String cedula)
    {
        this.cedula = cedula;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
