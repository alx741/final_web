package DOM;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
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
import hbm.Evento;
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

    private Guia guiaO;

    private List<Guia> filteredGuias;
    private List<Evento> eventos = new ArrayList<Evento>();

    public List<Guia> getFilteredGuias() {
        return filteredGuias;
    }

    public void setFilteredGuias(List<Guia> filteredGuias) {
        this.filteredGuias = filteredGuias;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public Guia getGuiaO()
    {
        return guiaO;
    }

    public void setGuiaO(Guia guiaO)
    {
        this.guiaO = guiaO;
    }

    private Cliente clienteO;

    public Cliente getClienteO()
    {
        return clienteO;
    }

    public void setClienteO(Cliente clienteO)
    {
        this.clienteO = clienteO;
    }

    private Ruta rutaO;

    public Ruta getRutaO()
    {
        return rutaO;
    }

    public void setRutaO(Ruta rutaO)
    {
        this.rutaO = rutaO;
    }


    private Paquete paqueteO;

    public Paquete getPaqueteO()
    {
        return paqueteO;
    }

    public void setPaqueteO(Paquete paqueteO)
    {
        this.paqueteO = paqueteO;
    }



    public void getEventosGuia()
    {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Guia guia = (Guia) session.load(Guia.class,
                    this.getGuiaO().getId());

            this.eventos = new ArrayList<Evento>();
            this.eventos.addAll(guia.getEventos());
    }



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
        this.setPaquete(String.valueOf(this.getPaqueteO().getId()));
        this.setRuta(String.valueOf(this.getRutaO().getId()));
        this.setCliente(this.getClienteO().getRuc_empresa());
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();


        // Paquete
        Paquete paquete = pmb.getPaqueteByID(this.getPaquete());
        // Ruta
        Ruta ruta = rmb.getRutaByID(this.getRuta());

        // Factura
        Factura factura =
            cmb.createUnpaidFactura(cmb.getClienteByRuc(this.getCliente()));
        if (factura.getId() == 0)
        {
            factura =
                cmb.createUnpaidFactura(cmb.getClienteByRuc(this.getCliente()));
        }

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
            if (p.isHabilitado())
            {
                descripciones.put(p.getDescripcion(), Integer.toString(p.getId()));
            }
        }

        return descripciones;
    }

    public Map<String, String> getRutasDescripcion()
    {
        List<Ruta>  rutaList = rmb.getRutas();
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
}
