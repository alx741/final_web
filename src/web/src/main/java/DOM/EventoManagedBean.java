package DOM;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hbm.Evento;
import hbm.Cliente;
import util.HibernateUtil;

public class EventoManagedBean implements Serializable
{

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(EventoManagedBean.class);
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    private int id;
    private Date fecha;
    private String evento;
    private String descripcion;

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


    public String save()
    {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        // // Cliente
        // ClienteManagedBean cmb = new ClienteManagedBean();
        // Cliente cliente = (Cliente) session.load(Cliente.class,
        //         cmb.getIdCliente(this.getRuc_empresa()));


        Evento evento = new Evento();
        evento.setFecha(new Date());
        evento.setDescripcion("[" + this.getEvento() + "] " +
                this.getDescripcion());

        // // Agregar evento al cliente
        // cliente.getEventos().add(evento);

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
}
