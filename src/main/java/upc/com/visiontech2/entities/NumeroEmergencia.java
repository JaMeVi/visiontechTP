package upc.com.visiontech2.entities;

import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity
@Table(name="numeroEmergencia")
public class NumeroEmergencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNumeroEmergencia;

    @Column(name="tipoEmergencia",nullable = false,length = 10)
    private String tipoEmergencia;

    @Column(name="distrito",nullable = false,length = 40)
    private String distrito;

    @Column(name="telefonoEmergencia",nullable = false)
    private int telefonoEmergencia;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Users usuario;

    public NumeroEmergencia() {}

    public NumeroEmergencia(int idNumeroEmergencia, String tipoEmergencia, String distrito, int telefonoEmergencia, Users usuario) {
        this.idNumeroEmergencia = idNumeroEmergencia;
        this.tipoEmergencia = tipoEmergencia;
        this.distrito = distrito;
        this.telefonoEmergencia = telefonoEmergencia;
        this.usuario = usuario;
    }

    public int getIdNumeroEmergencia() {
        return idNumeroEmergencia;
    }

    public void setIdNumeroEmergencia(int idNumeroEmergencia) {
        this.idNumeroEmergencia = idNumeroEmergencia;
    }

    public String getTipoEmergencia() {
        return tipoEmergencia;
    }

    public void setTipoEmergencia(String tipoEmergencia) {
        this.tipoEmergencia = tipoEmergencia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public void setTelefonoEmergencia(int telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
}
