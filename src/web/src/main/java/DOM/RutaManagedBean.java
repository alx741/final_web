package DOM;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hbm.Ruta;
import util.HibernateUtil;

public class RutaManagedBean implements Serializable
{

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(RutaManagedBean.class);
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    private float tarifa;
    private String descripcion;
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

        Ruta ruta = new Ruta();
        ruta.setTarifa(0);
        ruta.setDescripcion("");
        ruta.setHabilitado(true);

        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
            session.save(ruta);
            tx.commit();
            log.debug("Nuevo registro : " + ruta + ", realizado : " +
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

    public List<Ruta> getRutas()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Ruta>  rutaList = session.createCriteria(Ruta.class).list();
        return rutaList;
    }

    public void reset()
    {
        this.setTarifa(0);
        this.setDescripcion("");
        this.setHabilitado(true);
    }
}
