
package pe.edu.upc.entity;

public class Usuario {
    
    private String codUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private Integer idTipoUsuario;
    private String nombreTUsuario;

    public String getNombreTUsuario() {
        return nombreTUsuario;
    }

    public void setNombreTUsuario(String nombreTUsuario) {
        this.nombreTUsuario = nombreTUsuario;
    }

    public Usuario(String codUsuario, String nombre, String apellido, String correo, String clave, Integer idTipoUsuario, String nombreTUsuario) {
        this.codUsuario = codUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
        this.idTipoUsuario = idTipoUsuario;
        this.nombreTUsuario = nombreTUsuario;
    }

    public Usuario(String codUsuario, String nombre, String apellido, String correo, String clave, Integer idTipoUsuario) {
        this.codUsuario = codUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
        this.idTipoUsuario = idTipoUsuario;
    }

    public Usuario() {
    }

    /**
     * @return the codUsuario
     */
    public String getCodUsuario() {
        return codUsuario;
    }

    /**
     * @param codUsuario the codUsuario to set
     */
    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the idTipoUsuario
     */
    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    /**
     * @param idTipoUsuario the idTipoUsuario to set
     */
    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
}
