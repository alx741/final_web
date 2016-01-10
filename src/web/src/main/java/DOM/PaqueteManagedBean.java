package DOM;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hbm.Paquete;
import util.HibernateUtil;

public class PaqueteManagedBean implements Serializable
{

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(PaqueteManagedBean.class);
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    private float tarifa;
    private String descripcion;
    private float desde;
    private float hasta;
    private boolean habilitado;

    public float getTarifa()
    {
        return tarifa;
    }

    public void setTarifa(float tarifa)
    {
        this.tarifa = tarifa;
    }


    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public float getDesde()
    {
        return desde;
    }

    public void setDesde(float desde)
    {
        this.desde = desde;
    }

    public String getHasta()
    {
        return hasta;
    }

    public void setHasta(float hasta)
    {
        this.hasta = hasta;
    }

    public boolean isHabilitado()
    {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado)
    {
        this.habilitado = habilitado;
    }


    public String save()
    {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Paquete paquete = new Paquete();
        paquete.setTarifa(this.getTarifa());
        paquete.setDescripcion(this.getDescripcion() + " [" +
                Float.toString(this.getDesde()) + " - " +
                Float.toString(this.getHasta()) + " Kg]");
        paquete.setHabilitado(true);

        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
            session.save(paquete);
            tx.commit();
            log.debug("Nuevo registro : " + paquete + ", realizado : " +
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

    public List<Paquete> getPaquetes()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Paquete>  paqueteList = session.createCriteria(Paquete.class).list();
        return paqueteList;
    }

    public void reset()
    {
        this.setTarifa(0);
        this.setOrigen("");
        this.setDestino("");
        this.setTransporte("");
        this.setHabilitado(true);
    }
}
