package DOM;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hbm.Guia;
import hbm.Recurso;
import hbm.Paquete;
import hbm.Ruta;
import hbm.Cliente;
import util.HibernateUtil;

public class GuiaManagedBean implements Serializable
{

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(GuiaManagedBean.class);
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
    private PaqueteManagedBean pmb = new PaqueteManagedBean();

    private Date fecha_creacion;
    private String paquete;


    public Date getFecha_creacion()
    {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion)
    {
        this.fecha_creacion = fecha_creacion;
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

        // // Cliente
        // ClienteManagedBean cmb = new ClienteManagedBean();
        // Cliente cliente = (Cliente) session.load(Cliente.class,
        //         cmb.getIdCliente(this.getRuc_empresa()));


        Guia guia = new Guia();
        guia.setFecha_creacion(new Date());
        guia.setPaquete(pmb.getPaqueteByID(this.getPaquete()));

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







    public Map<String, String> getPaquetesDescripcion()
    {
        List<Paquete> paqueteList = pmb.getPaquetes();
        Map<String, String> descripciones = new  HashMap<String, String>();

        for (Paquete p : paqueteList)
        {
           descripciones.put(p.getDescripcion(), Integer.toString(p.getId()));
        }

        return descripciones;
    }
}
