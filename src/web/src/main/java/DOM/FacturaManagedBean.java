package DOM;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hbm.Factura;
import util.HibernateUtil;

public class FacturaManagedBean implements Serializable
{

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(FacturaManagedBean.class);
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    private Date fecha;
    private float valor;
    private boolean pagado;

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public Date getFecha()
    {
        return this.fecha;
    }

    public void setValor(float valor)
    {
        this.valor = valor;
    }

    public float getValor()
    {
        return this.valor;
    }

    public void setPagado(boolean pagado)
    {
        this.pagado = pagado;
    }

    public boolean getPagado()
    {
        return this.pagado;
    }


    public String save()
    {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Factura factura = new Factura();
        factura.setFecha(this.getFecha());
        factura.setValor(this.getValor());
        factura.setPagado(this.getPagado());

        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
            session.save(factura);
            tx.commit();
            log.debug("Nuevo registro : " + factura + ", realizado : " + tx.wasCommitted());
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

    public List<Factura> getFacturas()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Factura>  facturaList = session.createCriteria(Factura.class).list();
        return facturaList;
    }

    public void reset()
    {
        this.setFecha(0);
        this.setValor(0);
        this.setPagado(false);
    }
}
