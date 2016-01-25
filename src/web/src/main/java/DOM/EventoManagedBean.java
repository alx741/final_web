package DOM;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hbm.Evento;
import hbm.Cliente;
import hbm.Guia;
import hbm.Factura;
import util.HibernateUtil;

public class EventoManagedBean implements Serializable
{

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(EventoManagedBean.class);
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
    private GuiaManagedBean gmb = new GuiaManagedBean();

    private int id;
    private Date fecha;
    private String evento;
    private String descripcion;
    private String guia;



    private Guia guiaO;

    private List<Guia> filteredGuias;

    public List<Guia> getFilteredGuias() {
        return filteredGuias;
    }

    public void setFilteredGuias(List<Guia> filteredGuias) {
        this.filteredGuias = filteredGuias;
    }

    public Guia getGuiaO()
    {
        return guiaO;
    }

    public void setGuiaO(Guia guiaO)
    {
        this.guiaO = guiaO;
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public String getEvento()
    {
        return evento;
    }

    public void setEvento(String evento)
    {
        this.evento = evento;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getGuia()
    {
        return guia;
    }

    public void setGuia(String guia)
    {
        this.guia = guia;
    }


    public String save()
    {
        this.setGuia(String.valueOf(this.getGuiaO().getId()));
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        // // Cliente
        // ClienteManagedBean cmb = new ClienteManagedBean();
        // Cliente cliente = (Cliente) session.load(Cliente.class,
        //         cmb.getIdCliente(this.getRuc_empresa()));

        // Guia
        Guia guia = (Guia) session.load(Guia.class,
                Integer.parseInt(this.getGuia()));


        Evento evento = new Evento();
        evento.setFecha(new Date());
        evento.setDescripcion("[" + this.getEvento() + "] " +
                this.getDescripcion());

        // // Agregar evento al cliente
        // cliente.getEventos().add(evento);

        // Agregar evento a la guia
        guia.getEventos().add(evento);

        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
            session.save(evento);
            tx.commit();
            log.debug("Nuevo registro : " + evento + ", realizado : " +
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

    public List<Evento> getEventos()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Evento>  eventoList = session.createCriteria(Evento.class).list();
        return eventoList;
    }

    public void reset()
    {
        this.setFecha(new Date());
        this.setDescripcion("");
    }








    // Este metodo devuelve una lista de TODAS las guias de TODOS los clientes
    // Usar 2 combobox (quizas?):
    //  - Uno para seleccionar el cliente
    //  - Otro para seleccionar entre las guias de ESE cliente

    // Este ejemplo muestra la idea de una lista
    // que afecta el contenido de la otra:
    // http://www.primefaces.org/showcase/ui/ajax/dropdown.xhtml
    public Map<String, String> getGuiasDescripcion()
    {
        //TODO: El metodo generarDescripcion() en Guia.java puede ser usado?

        List<Guia> guiasList = gmb.getGuias();
        Map<String, String> descripciones = new  HashMap<String, String>();

        for (Guia g : guiasList)
        {
           descripciones.put(g.getCliente().getNombre_empresa() + " | "
                   + g.getDetalle(), String.valueOf(g.getId()));
        }

        return descripciones;
    }
}