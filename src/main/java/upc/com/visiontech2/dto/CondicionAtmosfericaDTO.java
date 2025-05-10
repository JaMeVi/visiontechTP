package upc.com.visiontech2.dto;

import upc.com.visiontech2.entities.Ruta;

import java.time.LocalDate;

public class CondicionAtmosfericaDTO {

    private int idCondicionAtmosferica;
    private int humedad;
    private double temperatura;
    private int velocidadViento;
    private LocalDate fechaHora;

    public int getIdCondicionAtmosferica() {
        return idCondicionAtmosferica;
    }

    public void setIdCondicionAtmosferica(int idCondicionAtmosferica) {
        this.idCondicionAtmosferica = idCondicionAtmosferica;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getVelocidadViento() {
        return velocidadViento;
    }

    public void setVelocidadViento(int velocidadViento) {
        this.velocidadViento = velocidadViento;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }


}
