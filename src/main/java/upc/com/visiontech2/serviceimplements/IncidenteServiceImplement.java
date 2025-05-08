package upc.com.visiontech2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.com.visiontech2.entities.Incidente;
import upc.com.visiontech2.repositories.IncidenteRepository;
import upc.com.visiontech2.serviceinterfaces.IIncidenteService;

import java.util.List;

@Service
public class IncidenteServiceImplement implements IIncidenteService {

    @Autowired
    private IncidenteRepository iR;

    @Override
    public List<Incidente> list() {
        return iR.findAll();
    }

    @Override
    public void insert(Incidente i) {
        iR.save(i);
    }

    @Override
    public Incidente listId(int idIncidente) {
        return iR.findById(idIncidente).orElse(new Incidente());
    }

    @Override
    public void update(Incidente i) {
        iR.save(i);
    }

    @Override
    public void delete(int idIncidente) {
        iR.deleteById(idIncidente);
    }

    @Override
    public List<Incidente> buscarPorTipo(String tipo) {
        return iR.buscarTipo(tipo);
    }
}

