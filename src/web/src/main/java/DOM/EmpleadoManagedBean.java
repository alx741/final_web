package DOM;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hbm.Empleado;
import util.HibernateUtil;

/**
 * @author onlinetechvision.com
 * @since 3 Oct 2011
 * @version 1.0.0
 *
 */
public class EmpleadoManagedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(EmpleadoManagedBean.class);
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";	
	private String cedula;
	private String nombre;
	
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
	
		
	public String save() {
		String result = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Empleado empleado = new Empleado();
		empleado.setCedula(this.getCedula());
		empleado.setNombre(this.getNombre());

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(empleado);
			tx.commit();
			log.debug("New Record : " + empleado + ", wasCommitted : " + tx.wasCommitted());
			result = SUCCESS;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				result = ERROR;
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
		return result;
	}
	
	public List<Empleado> getEmpleados() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Empleado>  empleadoList = session.createCriteria(Empleado.class).list();
		return empleadoList;
	}
	
	public void reset() {
		this.setCedula("");
		this.setNombre("");
	}	
}