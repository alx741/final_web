package DOM;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import hbm.Cliente;
import hbm.Factura;
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

    private String cliente;
    private String isPass;

    private Cliente clienteO;

    private List<Cliente> filteredClientes;

    public List<Cliente> getFilteredClientes() {
        return filteredClientes;
    }

    public void setFilteredClientes(List<Cliente> filteredClientes) {
        this.filteredClientes = filteredClientes;
    }

    public Cliente getClienteO()
    {
        return clienteO;
    }

    public void setClienteO(Cliente clienteO)
    {
        this.clienteO = clienteO;
    }

    public String getCliente()
    {
        return cliente;
    }

    public void setCliente(String cliente)
    {
        this.cliente = cliente;
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

    public String getIsPass()
    {
        return isPass;
    }

    public void setIsPass(String isPass)
    {
        this.isPass = isPass;
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








    public int getIdCliente(String ruc_empresa)
    {
        List<Cliente> clientes = getClientes();

        for (Cliente cliente : clientes)
        {
            if (cliente.getRuc_empresa().equals(ruc_empresa))
            {
                return cliente.getId();
            }
        }

        return 0;
    }

    public Cliente getClienteByID(String id)
    {
        List<Cliente> clientes = getClientes();

        for (Cliente cliente : clientes)
        {
            if (cliente.getId() == Integer.parseInt(id))
            {
                return cliente;
            }
        }

        return null;
    }

    public Cliente getClienteByRuc(String ruc)
    {
        return getClienteByID(String.valueOf(getIdCliente(ruc)));
    }

    public Factura createUnpaidFactura(Cliente cliente)
    {
        Set<Factura> facturasCliente = cliente.getFacturas();

        // Obtener factura no pagada
        Iterator<Factura> itr = facturasCliente.iterator();
        Factura factura = null;
        while (itr.hasNext())
        {
            factura = itr.next();

            if (!factura.isPagado())
            {
                return factura;
            }
        }

        // Crear nueva factura
        Session session = HibernateUtil.getSessionFactory().openSession();
        factura = new Factura();
        factura.setFecha(new Date());
        factura.setValor(0);
        factura.setPagado(false);
        factura.setCliente(cliente);

        ClienteManagedBean cmb = new ClienteManagedBean();
        Cliente cliente_h = (Cliente) session.load(Cliente.class,
                cliente.getId());
        cliente_h.getFacturas().add(factura);

        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
            session.save(factura);
            tx.commit();
            log.debug("Nuevo registro : " + factura + ", realizado : " + tx.wasCommitted());
        }
        catch (Exception e)
        {
            if (tx != null)
            {
                tx.rollback();
            }
        }
        finally
        {
            session.close();
        }

        return factura;
    }

    public void checkClientePassword()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cliente cliente = (Cliente) session.load(Cliente.class,
                getIdCliente(this.getRuc_empresa()));

        if (this.getPassword().equals(cliente.getPassword()))
        {
            this.isPass = "si";
        }
        else
        {
            this.isPass = "no";
        }
    }

    public void onClienteChange()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cliente cliente = (Cliente) session.load(Cliente.class,
                this.getIdCliente(this.getCliente()));

        this.setRuc_empresa(cliente.getRuc_empresa());
        this.setNombre_empresa(cliente.getNombre_empresa());
        this.setCedula_representante(cliente.getCedula_representante());
        this.setNombre_representante(cliente.getNombre_representante());
        this.setTelefono(cliente.getTelefono());
        this.setDireccion(cliente.getDireccion());
        this.setPassword(cliente.getPassword());
    }

    public void onClienteChangeT()
    {
        this.setCliente(this.getClienteO().getRuc_empresa());
        this.onClienteChange();
    }

    public String modificar()
    {
        this.setCliente(this.getClienteO().getRuc_empresa());
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cliente cliente = (Cliente) session.load(Cliente.class,
                this.getIdCliente(this.getCliente()));

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
            session.update(cliente);
            tx.commit();
            log.debug("Nuevo registro : " + cliente + ", realizado : " +
                      tx.wasCommitted());
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
}

  