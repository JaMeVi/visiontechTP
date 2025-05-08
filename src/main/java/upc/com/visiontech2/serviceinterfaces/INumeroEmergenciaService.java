package upc.com.visiontech2.serviceinterfaces;

import upc.com.visiontech2.entities.NumeroEmergencia;

import java.util.List;

public interface INumeroEmergenciaService {
    public List<NumeroEmergencia> list();
    public void insert(NumeroEmergencia n);
    public NumeroEmergencia listId(int idNumeroEmergencia);
    public void update(NumeroEmergencia n);
    public void delete(int idNumeroEmergencia);

}
