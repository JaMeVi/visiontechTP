package upc.com.visiontech2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.com.visiontech2.entities.Ruta;
import upc.com.visiontech2.repositories.RutaRepository;
import upc.com.visiontech2.serviceinterfaces.IRutaService;

import java.util.List;

@Service
public class RutaServiceImplement implements IRutaService {
    @Autowired
    private RutaRepository rR;

    @Override
    public List<Ruta> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Ruta r) {
        rR.save(r);
    }

    @Override
    public Ruta listId(int idRuta) {
        return rR.findById(idRuta).orElse(new Ruta());
    }

    @Override
    public void update(Ruta r) {
        rR.save(r);
    }

    @Override
    public void delete(int idRuta) {
        rR.deleteById(idRuta);
    }

    @Override
    public List<Ruta> buscarPorNombre(String nombre) {
        return rR.buscarNombre(nombre);
    }
}
