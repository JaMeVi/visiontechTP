package upc.com.visiontech2.serviceinterfaces;

import upc.com.visiontech2.entities.CondicionAtmosferica;

import java.util.List;

public interface ICondicionAtmosfericaService {

    public List<CondicionAtmosferica> list();
    public void insert(CondicionAtmosferica c);
    public CondicionAtmosferica listId(int idCondicionAtmosferica);
    public void update(CondicionAtmosferica c);
    public void delete(int idCondicionAtmosferica);
}
