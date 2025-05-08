package upc.com.visiontech2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.ContactoEmergenciaDTO;
import upc.com.visiontech2.entities.ContactoEmergencia;
import upc.com.visiontech2.serviceinterfaces.IContactoEmergenciaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contactoemergencia")
public class ContactoEmergenciaController {

    @Autowired
    private IContactoEmergenciaService IContactoEmergenciaService;

    @GetMapping
    public List<ContactoEmergenciaDTO> listar() {
        return IContactoEmergenciaService.list().stream().map(contacto -> {
                    ModelMapper modelMapper = new ModelMapper();
                    return modelMapper.map(contacto, ContactoEmergenciaDTO.class);
                })
                .collect(Collectors.toList());
    }

    @PostMapping
    public void insert(@RequestBody ContactoEmergenciaDTO contactoEmergenciaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        ContactoEmergencia contacto = modelMapper.map(contactoEmergenciaDTO, ContactoEmergencia.class);
        IContactoEmergenciaService.insert(contacto);
    }

    @GetMapping("/{idContactoEmergencia}")
    public ContactoEmergenciaDTO listId(@PathVariable("idContactoEmergencia") int idContactoEmergencia) {
        ModelMapper modelMapper = new ModelMapper();
        ContactoEmergenciaDTO dto = modelMapper.map(IContactoEmergenciaService.listId(idContactoEmergencia), ContactoEmergenciaDTO.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody ContactoEmergenciaDTO contactoEmergenciaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        ContactoEmergencia contacto = modelMapper.map(contactoEmergenciaDTO, ContactoEmergencia.class);
        IContactoEmergenciaService.update(contacto);
    }

    @DeleteMapping("/{idContactoEmergencia}")
    public void delete(@PathVariable("idContactoEmergencia") int idContactoEmergencia) {
        IContactoEmergenciaService.delete(idContactoEmergencia);
    }
}
