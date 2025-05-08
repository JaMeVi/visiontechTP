package upc.com.visiontech2.entities;


import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity
@Table(name = "contactos_emergencia")
public class ContactoEmergencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContacto;

    @Column(name = "nombre",nullable = false,length = 45)
    private String nombre;

    @Column(name = "telefono",nullable = false)
    private int telefono;

    @Column(name = "correoElectronico",nullable = false,length = 45)
    private String correoElectronico;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Users usuario;

    public ContactoEmergencia() {}
    public ContactoEmergencia(int idContacto, String nombre, int telefono, String correoElectronico, Users usuario) {
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.usuario = usuario;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

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

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
}
