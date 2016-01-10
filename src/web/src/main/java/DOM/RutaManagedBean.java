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
    private String origen;
    private String destino;
    private String transporte;
    private boolean habilitado;

    public float getTarifa()
    {
        return tarifa;
    }

    public void setTarifa(float tarifa)
    {
        this.tarifa = tarifa;
    }


    public String getOrigen()
    {
        return origen;
    }

    public void setOrigen(String origen)
    {
        this.origen = origen;
    }

    public String getDestino()
    {
        return destino;
    }

    public void setDestino(String destino)
    {
        this.destino = destino;
    }

    public String getTransporte()
    {
        return transporte;
    }

    public void setTransporte(String transporte)
    {
        this.transporte = transporte;
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
        ruta.setTarifa(this.getTarifa());
        ruta.setDescripcion(this.getOrigen() + " - " + this.getDestino() + " ["
                + this.getTransporte() + "]");
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
        this.setOrigen("");
        this.setDestino("");
        this.setTransporte("");
        this.setHabilitado(true);
    }
}
