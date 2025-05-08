package upc.com.visiontech2.dto;

import upc.com.visiontech2.entities.Role;

import java.util.List;

public class UsuarioDTO {
    private long idUsuario;
    private String username;
    private String password;
    private Boolean enabled;
    private String nombre;
    private String correoElectronico;
    private int telefono;
    private List<Role> rol;

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<Role> getRol() {
        return rol;
    }

    public void setRol(List<Role> rol) {
        this.rol = rol;
    }
}