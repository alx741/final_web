package hbm;

public class Admin
{
    private int id;
    private String password;

    public Admin() {}


    public int getId()
    {
        return this.id;
    }

    private void setId(int id)
    {
        this.id = id;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
}
