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


    public Date getFecha_creacion()
    {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion)
    {
        this.fecha_creacion = fecha_creacion;
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
    }
}
