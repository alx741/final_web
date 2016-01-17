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
import hbm.Factura;
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
    private RutaManagedBean rmb = new RutaManagedBean();
    private ClienteManagedBean cmb = new ClienteManagedBean();

    private Date fecha_creacion;
    private String detalle;
    private String paquete;
    private String ruta;
    private String cliente;
    // private Empleado empleado;
    private String factura;


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

    public String getRuta()
    {
        return ruta;
    }

    public void setRuta(String ruta)
    {
        this.ruta = ruta;
    }

    public String getCliente()
    {
        return cliente;
    }

    public void setCliente(String cliente)
    {
        this.cliente = cliente;
    }

    public String getDetalle()
    {
        return detalle;
    }

    public void setDetalle(String detalle)
    {
        this.detalle = detalle;
    }

    public String getFactura()
    {
        return factura;
    }

    public void setFactura(String factura)
    {
        this.factura = factura;
    }






    public String save()
    {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();


        // Paquete
        Recurso paquete = pmb.getPaqueteByID(this.getPaquete());
        // Ruta
        Recurso ruta = rmb.getRutaByID(this.getRuta());

        // Factura
        Factura factura =
            cmb.createUnpaidFactura(cmb.getClienteByRuc(this.getCliente()));

        Factura factura_h = (Factura) session.load(Factura.class,
                factura.getId());

        float nuevoValor = paquete.getTarifa() + ruta.getTarifa();
        factura_h.setValor(factura.getValor() + nuevoValor);

        Guia guia = new Guia();
        guia.setFecha_creacion(new Date());
        guia.setDetalle(this.getDetalle());
        guia.setPaquete(paquete);
        guia.setRuta(ruta);
        guia.setCliente(cmb.getClienteByRuc(this.getCliente()));
        guia.setFactura(factura);

        // Agregar guia a la factura
        factura_h.getGuias().add(guia);


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

    public Map<String, String> getRutasDescripcion()
    {
        List<Ruta>  rutaList = rmb.getRutas();
        Map<String, String> descripciones = new  HashMap<String, String>();

        for (Ruta r : rutaList)
        {
           descripciones.put(r.getDescripcion(), Integer.toString(r.getId()));
        }

        return descripciones;
    }
}
