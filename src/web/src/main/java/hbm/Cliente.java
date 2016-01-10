package hbm;

import java.util.Set;
import java.util.HashSet;

public class Cliente
{

    private int id;
    private String ruc_empresa;
    private String nombre_empresa;
    private String cedula_representante;
    private String nombre_representante;
    private String telefono;
    private String direccion;
    // TODO: Si alcanza el tiempo, almacenar esto como se debe!
    private String password;
    private Set<Factura> facturas = new HashSet<Factura>();

    public Cliente()
    {}

    public int getId()
    {
        return this.id;
    }

    private void setId(int id)
    {
        this.id = id;
    }


    public String getRuc_empresa()
    {
        return ruc_empresa;
    }

    public void setRuc_empresa(String ruc_empresa)
    {
        this.ruc_empresa = ruc_empresa;
    }

    public String getNombre_empresa()
    {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa)
    {
        this.nombre_empresa = nombre_empresa;
    }

    public String getCedula_representante()
    {
        return cedula_representante;
    }

    public void setCedula_representante(String cedula_representante)
    {
        this.cedula_representante = cedula_representante;
    }

    public String getNombre_representante()
    {
        return nombre_representante;
    }

    public void setNombre_representante(String nombre_representante)
    {
        this.nombre_representante = nombre_representante;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Set getFacturas()
    {
        return facturas;
    }

    public void setFacturas(Set<Factura> facturas)
    {
        this.facturas = facturas;
    }
}
