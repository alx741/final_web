package DOM;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hbm.Guia;
import hbm.Cliente;
import util.HibernateUtil;

public class GuiaManagedBean implements Serializable
{

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(GuiaManagedBean.class);
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    private Date fecha_creacion;
    private Date fecha_salida;
    private Date fecha_llegada;


    public Date getFecha_creacion()
    {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion)
    {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_salida()
    {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida)
    {
        this.fecha_salida = fecha_salida;
    }

    public Date getFecha_llegada()
    {
        return fecha_llegada;
    }

    public void setFecha_llegada(Date fecha_llegada)
    {
        this.fecha_llegada = fecha_llegada;
    }


    public String save()
    {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        // // Cliente
        // ClienteManagedBean cmb = new ClienteManagedBean();
        // Cliente cliente = (Cliente) session.load(Cliente.class,
        //         cmb.getIdCliente(this.getRuc_empresa()));


        Guia guia = new Guia();
        guia.setFecha_creacion(new Date());
        guia.setFecha_salida(null);
        guia.setFecha_llegada(null);

        // // Agregar guia al cliente
        // cliente.getGuias().add(guia);

        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
            session.save(guia);
            tx.commit();
            log.debug("Nuevo registro : " + guia + ", realizado : " + tx.wasCommitted());
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

    public List<Guia> getGuias()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Guia>  guiaList = session.createCriteria(Guia.class).list();
        return guiaList;
    }

public void reset()
    {
        this.setFecha_creacion(new Date());
        this.setFecha_salida(null);
        this.setFecha_llegada(null);
    }
}
