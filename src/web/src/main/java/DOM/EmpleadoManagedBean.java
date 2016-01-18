package DOM;

import java.io.Serializable;
import java.util.List;
import java.io.*;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hbm.Empleado;
import util.HibernateUtil;

public class EmpleadoManagedBean implements Serializable
{

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(EmpleadoManagedBean.class);
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
    private String cedula;
    private String nombre;

    private String adminPass;
    private String isAdminPass;



    public String getCedula()
    {
        return this.cedula;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void setCedula(String cedula)
    {
        this.cedula = cedula;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getAdminPass()
    {
        return adminPass;
    }

    public void setAdminPass(String adminPass)
    {
        this.adminPass = adminPass;
    }

    public String getIsAdminPass()
    {
        return isAdminPass;
    }

    public void setIsAdminPass(String isAdminPass)
    {
        this.isAdminPass = isAdminPass;
    }


    public String save()
    {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Empleado empleado = new Empleado();
        empleado.setCedula(this.getCedula());
        empleado.setNombre(this.getNombre());

        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
            session.save(empleado);
            tx.commit();
            log.debug("Nuevo registro : " + empleado + ", realizado : " +
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

    public List<Empleado> getEmpleados()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Empleado>  empleadoList =
            session.createCriteria(Empleado.class).list();
        return empleadoList;
    }

    public void reset()
    {
        this.setCedula("");
        this.setNombre("");
    }
}
