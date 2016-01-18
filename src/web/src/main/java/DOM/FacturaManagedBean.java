package DOM;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hbm.Factura;
import hbm.Cliente;
import util.HibernateUtil;

public class FacturaManagedBean implements Serializable
{

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(FacturaManagedBean.class);
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    private String ruc_empresa;
    private int id_cliente;
    private Date fecha;
    private float valor;
    private boolean pagado;
    private String factura;

    public String getRuc_empresa()
    {
        return this.ruc_empresa;
    }

    public void setRuc_empresa(String ruc_empresa)
    {
        this.ruc_empresa = ruc_empresa;
    }

    public int getId_cliente()
    {
        return this.id_cliente;
    }

    public void setId_cliente(int id_cliente)
    {
        this.id_cliente = id_cliente;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setValor(float valor)
    {
        this.valor = valor;
    }

    public float getValor()
    {
        return this.valor;
    }

    public void setPagado(boolean pagado)
    {
        this.pagado = pagado;
    }

    public boolean getPagado()
    {
        return this.pagado;
    }

    public String getFactura()
    {
        return this.factura;
    }

    public void setFactura(String factura)
    {
        this.factura = factura;
    }



    public String save()
    {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Cliente
        ClienteManagedBean cmb = new ClienteManagedBean();
        Cliente cliente = (Cliente) session.load(Cliente.class,
                cmb.getIdCliente(this.getRuc_empresa()));


        Factura factura = new Factura();
        factura.setFecha(new Date());
        factura.setValor(this.getValor());
        factura.setPagado(false);
        factura.setCliente(cliente);

        // Agregar factura al cliente
        cliente.getFacturas().add(factura);

        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
            session.save(factura);
            tx.commit();
            log.debug("Nuevo registro : " + factura + ", realizado : " + tx.wasCommitted());
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

    public List<Factura> getFacturas()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Factura>  facturaList = session.createCriteria(Factura.class).list();
        return facturaList;
    }

public void reset()
    {
        this.setFecha(new Date());
        this.setValor(0);
        this.setPagado(false);
    }









    public String pagar()
    {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Factura factura = (Factura) session.load(Factura.class,
                Integer.parseInt(this.getFactura()));

        factura.setPagado(true);

        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
            session.save(factura);
            tx.commit();
            log.debug("Nuevo registro : " + factura + ", realizado : " +
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

    public Map<String, String> getUnpaidFacturas()
    {
        List<Factura> facturaList = this.getFacturas();
        Map<String, String> descripciones = new  HashMap<String, String>();

        for (Factura f : facturaList)
        {
            if (!f.isPagado())
            {
                descripciones.put(f.getCliente().getNombre_empresa() + " | $" +
                        Float.toString(f.getValor()),
                        Integer.toString(f.getId()));
            }
        }

        return descripciones;
    }
}
