package DOM;

import java.io.Serializable;
import java.util.List;
import java.io.*;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hbm.Admin;
import util.HibernateUtil;

public class AdminManagedBean implements Serializable
{

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(AdminManagedBean.class);
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    private String adminPass;
    private String isAdminPass;


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

        Admin admin = new Admin();

        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
            session.save(admin);
            tx.commit();
            log.debug("Nuevo registro : " + admin + ", realizado : " +
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

    public List<Admin> getAdmins()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Admin>  adminList =
            session.createCriteria(Admin.class).list();
        return adminList;
    }

    public void reset()
    {
    }









    public String checkAdminPassword()
    {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Admin admin = (Admin) session.load(Admin.class, 1);

        if (this.getAdminPass().equals(admin.getPassword()))
        {
            this.isAdminPass = "si";
            result = SUCCESS;
        }
        else
        {
             result = ERROR;
            this.isAdminPass = "no";
        }
        return result;
    }
}
