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
    private String password;

    private String isPass;



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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getIsPass()
    {
        return isPass;
    }

    public void setIsPass(String isPass)
    {
        this.isPass = isPass;
    }


    public String save()
    {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Empleado empleado = new Empleado();
        empleado.setCedula(this.getCedula());
        empleado.setNombre(this.getNombre());
        empleado.setPassword(this.getPassword());

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
        this.setPassword("");
    }






    public int getIdEmpleado(String cedula)
    {
        List<Empleado> empleados = getEmpleados();

        for (Empleado empleado : empleados)
        {
            if (empleado.getCedula().equals(cedula))
            {
                return empleado.getId();
            }
        }

        return 0;
    }

    public void checkEmpleadoPassword()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Empleado empleado = (Empleado) session.load(Empleado.class,
                getIdEmpleado(this.getCedula()));

        if (this.getPassword().equals(empleado.getPassword()))
        {
            this.isPass = "si";
        }
        else
        {
            this.isPass = "no";
        }
    }
}
