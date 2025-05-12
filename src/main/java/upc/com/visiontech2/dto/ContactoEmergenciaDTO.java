package upc.com.visiontech2.dto;

public class ContactoEmergenciaDTO {
    private String nombre;
    private int telefono;
    private String correoElectronico;
    private Long idUsuario;

    public Long getIdUsuario() {  return idUsuario;}

    public void setIdUsuario(Long idUsuario) {this.idUsuario = idUsuario;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
