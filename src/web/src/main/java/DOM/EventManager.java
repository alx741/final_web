package DOM;

import hbm.Empleado;
import java.util.*;
import org.hibernate.Session;

public class EventManager
{
    public static void main(String[] args)
    {
        EventManager mgr = new EventManager();

        if(args[0].equals("store"))
        {
            mgr.createAndStoreEmpleado("0106584139", "daniel campoverde");
        }

        HibernateUtil.getSessionFactory().close();
    }

    private void createAndStoreEmpleado(String cedula, String nombre)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Empleado theEmpleado = new Empleado();
        theEmpleado.setCedula(cedula);
        theEmpleado.setNombre(nombre);
        session.save(theEmpleado);

        session.getTransaction().commit();
    }
}
