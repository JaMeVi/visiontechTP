package upc.com.visiontech2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.com.visiontech2.entities.TemaForo;
import upc.com.visiontech2.repositories.TemaForoRepository;
import upc.com.visiontech2.serviceinterfaces.ITemaForoService;

import java.util.List;

@Service
public class TemaForoServiceImplement implements ITemaForoService {
    @Autowired
    private TemaForoRepository tR;

    @Override
    public List<TemaForo> list() {
        return tR.findAll();
    }

    @Override
    public void insert(TemaForo a) {
        tR.save(a);
    }

    @Override
    public TemaForo listId(int idTemaForo) {
        return tR.findById(idTemaForo).orElse(new TemaForo());
    }

    @Override
    public void update(TemaForo a) {
        tR.save(a);
    }

    @Override
    public void delete(int idTemaForo) {
        tR.deleteById(idTemaForo);
    }
}
