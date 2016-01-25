package DOM;

import java.io.Serializable;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

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
    private String ruta;


    private Ruta rutaO;

    private List<Ruta> filteredRutas;

    public List<Ruta> getFilteredRutas() {
        return filteredRutas;
    }

    public void setFilteredRutas(List<Ruta> filteredRutas) {
        this.filteredRutas = filteredRutas;
    }

    public Ruta getRutaO()
    {
        return rutaO;
    }

    public void setRutaO(Ruta rutaO)
    {
        this.rutaO = rutaO;
    }




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

    public String getRuta()
    {
        return ruta;
    }

    public void setRuta(String ruta)
    {
        this.ruta = ruta;
    }


    public String save()
    {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Ruta ruta = new Ruta();
        ruta.setTarifa(this.getTarifa());
        ruta.setOrigen(this.getOrigen());
        ruta.setDestino(this.getDestino());
        ruta.setTransporte(this.getTransporte());
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






    public String deshabilitar()
    {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Ruta ruta = (Ruta) session.load(Ruta.class,
                Integer.parseInt(this.getRuta()));

        ruta.setHabilitado(false);

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

    public String habilitar()
    {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Ruta ruta = (Ruta) session.load(Ruta.class,
                Integer.parseInt(this.getRuta()));

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

    public Map<String, String> getRutasHabilitados()
    {
        List<Ruta> rutaList = this.getRutas();
        Map<String, String> descripciones = new  HashMap<String, String>();

        for (Ruta p : rutaList)
        {
            if (p.isHabilitado())
            {
                descripciones.put(p.getDescripcion(),
                        Integer.toString(p.getId()));
            }
        }

        return descripciones;
    }

    public Map<String, String> getRutasDeshabilitados()
    {
        List<Ruta> rutaList = this.getRutas();
        Map<String, String> descripciones = new  HashMap<String, String>();

        for (Ruta p : rutaList)
        {
            if (!p.isHabilitado())
            {
                descripciones.put(p.getDescripcion(),
                        Integer.toString(p.getId()));
            }
        }

        return descripciones;
    }


    public Ruta getRutaByID(String id)
    {
        List<Ruta> rutas = getRutas();

        for (Ruta ruta : rutas)
        {
            if (ruta.getId() == Integer.parseInt(id))
            {
                return ruta;
            }
        }

        return null;
    }

    public Map<String, String> getRutasDescripcion()
    {
        List<Ruta>  rutaList = this.getRutas();
        Map<String, String> descripciones = new  HashMap<String, String>();

        for (Ruta r : rutaList)
        {
            if (r.isHabilitado())
            {
                descripciones.put(r.getDescripcion(), Integer.toString(r.getId()));
            }
        }

        return descripciones;
    }

    public void onRutaChange()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Ruta ruta = (Ruta) session.load(Ruta.class,
                Integer.parseInt(this.getRuta()));

        this.setTarifa(ruta.getTarifa());
        this.setOrigen(ruta.getOrigen());
        this.setDestino(ruta.getDestino());
        this.setTransporte(ruta.getTransporte());
    }

    public void onRutaChangeT()
    {
        this.setRuta(String.valueOf(this.getRutaO().getId()));
        this.onRutaChange();
    }

    public String modificar()
    {
        this.setRuta(String.valueOf(this.getRutaO().getId()));
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Ruta ruta = (Ruta) session.load(Ruta.class,
                Integer.parseInt(this.getRuta()));

        ruta.setTarifa(this.getTarifa());
        ruta.setOrigen(this.getOrigen());
        ruta.setDestino(this.getDestino());
        ruta.setTransporte(this.getTransporte());
        ruta.setHabilitado(true);

        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
            session.update(ruta);
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
}