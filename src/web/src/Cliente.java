public class Cliente
{
    private String ruc_empresa;
    private String nombre_empresa;
    private String cedula_representante;
    private String nombre_representante;
    private String telefono;
    private String direccion;
    private String password;

    public Cliente(String ruc_empresa)
    {}

    public void registrar(String ruc_empresa, String nombre_empresa, String
            cedula_representante, String nombre_representante, String telefono,
            String direccion, String password)
    {
        this.ruc_empresa = ruc_empresa;
        this.nombre_empresa = nombre_empresa;
        this.cedula_representante = cedula_representante;
        this.nombre_representante = nombre_representante;
        this.telefono = telefono;
        this.direccion = direccion;
        this.password = password;
    }

    public void habilitar(String ruc_empresa)
    {}

    public void inhabiliar(String ruc_empresa)
    {}
}
