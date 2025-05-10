package upc.com.visiontech2.entities;

import jakarta.persistence.*;

@Entity
@Table(name="rutas")
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRuta;

    @Column(name="nombreRuta",nullable = false,length = 80)
    private String nombreRuta;

    @Column(name="destino",nullable = false,length = 80)
    private String destino;

    @Column(name="inicio",nullable = false,length = 80)
    private String inicio;

    @Column(name="distanciaMetros",nullable = false)
    private int distanciaMinutos;

    @Column(name="tiempoRuta",nullable = false)
    private int tiempoRuta;

    @Column(name="longitud",nullable = false)
    private int longitud;

    @Column(name="latitud",nullable = false)
    private int latitud;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Users usuario;

    public Ruta() {}

    public Ruta(int idRuta, String nombreRuta, String destino, String inicio, String fin, int distanciaMinutos, int tiempoRuta, int longitud, int latitud, Users usuario) {
        this.idRuta = idRuta;
        this.nombreRuta = nombreRuta;
        this.destino = destino;
        this.inicio = inicio;
        this.distanciaMinutos = distanciaMinutos;
        this.tiempoRuta = tiempoRuta;
        this.longitud = longitud;
        this.latitud = latitud;
        this.usuario = usuario;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public int getDistanciaMinutos() {
        return distanciaMinutos;
    }

    public void setDistanciaMinutos(int distanciaMinutos) {
        this.distanciaMinutos = distanciaMinutos;
    }

    public int getTiempoRuta() {
        return tiempoRuta;
    }

    public void setTiempoRuta(int tiempoRuta) {
        this.tiempoRuta = tiempoRuta;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
}
