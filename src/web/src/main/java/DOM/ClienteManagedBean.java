package DOM;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hbm.Cliente;
import util.HibernateUtil;

public class ClienteManagedBean implements Serializable
{

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(ClienteManagedBean.class);
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    private String ruc_empresa;
    private String nombre_empresa;
    private String cedula_representante;
    private String nombre_representante;
    private String telefono;
    private String direccion;
    private String password;

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



    public String save()
    {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Cliente cliente = new Cliente();
        cliente.setRuc_empresa(this.getRuc_empresa());
        cliente.setNombre_empresa(this.getNombre_empresa());
        cliente.setCedula_representante(this.getCedula_representante());
        cliente.setNombre_representante(this.getNombre_representante());
        cliente.setTelefono(this.getTelefono());
        cliente.setDireccion(this.getDireccion());
        cliente.setPassword(this.getPassword());

        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
            session.save(cliente);
            tx.commit();
            log.debug("Nuevo registro : " + cliente + ", realizado : " + tx.wasCommitted());
            result = SUCCESS;
        }
        catch (Exception e)
        {
            if (tx != null)
            {
                tx.rollback();
                result = ERROR;
                e.printStackTrace();
            }
        }
        finally
        {
            session.close();
        }
        return result;
    }

    public List<Cliente> getClientes()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Cliente>  clienteList = session.createCriteria(Cliente.class).list();
        return clienteList;
    }

    public void reset()
    {
        this.setRuc_empresa("");
        this.setNombre_empresa("");
        this.setCedula_representante("");
        this.setNombre_representante("");
        this.setTelefono("");
        this.setDireccion("");
        this.setPassword("");
    }
}
