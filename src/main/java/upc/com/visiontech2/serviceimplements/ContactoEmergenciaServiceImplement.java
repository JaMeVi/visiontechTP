package upc.com.visiontech2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.com.visiontech2.entities.ContactoEmergencia;
import upc.com.visiontech2.repositories.ContactoEmergenciaRepository;
import upc.com.visiontech2.serviceinterfaces.IContactoEmergenciaService;

import java.util.List;

@Service
public class ContactoEmergenciaServiceImplement implements IContactoEmergenciaService {

    @Autowired
    private ContactoEmergenciaRepository contactoEmergenciaRepository;

    @Override
    public List<ContactoEmergencia> list() {
        return contactoEmergenciaRepository.findAll();
    }

    @Override
    public void insert(ContactoEmergencia contactoEmergencia) {
        contactoEmergenciaRepository.save(contactoEmergencia);
    }

    @Override
    public ContactoEmergencia listId(int idContacto) {
        return contactoEmergenciaRepository.findById(idContacto).orElse(null);
    }

    @Override
    public void update(ContactoEmergencia contactoEmergencia) {
        contactoEmergenciaRepository.save(contactoEmergencia);
    }

    @Override
    public void delete(int idContacto) {
        contactoEmergenciaRepository.deleteById(idContacto);
    }

    @Override
    public List<ContactoEmergencia> buscarPorNombre(String nombre) {
        return contactoEmergenciaRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
