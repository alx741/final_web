package DOM;

import java.io.Serializable;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

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
    private String paquete;

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

    public float getHasta()
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

    public String getPaquete()
    {
        return paquete;
    }

    public void setPaquete(String paquete)
    {
        this.paquete = paquete;
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
        this.setDescripcion("");
        this.setDesde(0);
        this.setHasta(0);
        this.setHabilitado(true);
    }







    public String deshabilitar()
    {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Paquete paquete = (Paquete) session.load(Paquete.class,
                Integer.parseInt(this.getPaquete()));

        paquete.setHabilitado(false);

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

    public String habilitar()
    {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Paquete paquete = (Paquete) session.load(Paquete.class,
                Integer.parseInt(this.getPaquete()));

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

    public Map<String, String> getPaquetesHabilitados()
    {
        List<Paquete> paqueteList = this.getPaquetes();
        Map<String, String> descripciones = new  HashMap<String, String>();

        for (Paquete p : paqueteList)
        {
            if (p.isHabilitado())
            {
                descripciones.put(p.getDescripcion(),
                        Integer.toString(p.getId()));
            }
        }

        return descripciones;
    }

    public Map<String, String> getPaquetesDeshabilitados()
    {
        List<Paquete> paqueteList = this.getPaquetes();
        Map<String, String> descripciones = new  HashMap<String, String>();

        for (Paquete p : paqueteList)
        {
            if (!p.isHabilitado())
            {
                descripciones.put(p.getDescripcion(),
                        Integer.toString(p.getId()));
            }
        }

        return descripciones;
    }

    public Paquete getPaqueteByID(String id)
    {
        List<Paquete> paquetes = getPaquetes();

        for (Paquete paquete : paquetes)
        {
            if (paquete.getId() == Integer.parseInt(id))
            {
                return paquete;
            }
        }

        return null;
    }
}
