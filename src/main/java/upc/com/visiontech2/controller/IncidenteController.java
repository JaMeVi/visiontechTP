package upc.com.visiontech2.controller;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.IncidenteDTO;
import upc.com.visiontech2.entities.Incidente;
import upc.com.visiontech2.entities.Ruta;
import upc.com.visiontech2.repositories.RutaRepository;
import upc.com.visiontech2.serviceinterfaces.IIncidenteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/incidentes")
public class IncidenteController {
    @Autowired
    private IIncidenteService iR;
    @Autowired
    private RutaRepository rR;
    @GetMapping
    public List<IncidenteDTO> listar() {
        return iR.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, IncidenteDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody IncidenteDTO iDTO) {
        ModelMapper m = new ModelMapper();
        Incidente i = m.map(iDTO, Incidente.class);

        Ruta ruta = rR.findById(iDTO.getIdRuta())
                .orElseThrow(() -> new EntityNotFoundException("Ruta no encontrada con ID: " + iDTO.getIdRuta()));
        i.setRuta(ruta);
        iR.insert(i);
    }

    @GetMapping("/{idIncidente}")
    public IncidenteDTO listarId(@PathVariable("idIncidente") int idIncidente) {
        ModelMapper m = new ModelMapper();
        IncidenteDTO dto = m.map(iR.listId(idIncidente), IncidenteDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody IncidenteDTO iDTO) {
        ModelMapper m = new ModelMapper();
        Incidente i = m.map(iDTO, Incidente.class);
        iR.update(i);
    }

    @DeleteMapping("/{idIncidente}")
    public void eliminar(@PathVariable("idIncidente") int idIncidente) {
        iR.delete(idIncidente);
    }
    @GetMapping("/tipos/{tipo}")
    public List<Incidente> buscarPorTipo(@PathVariable String tipo) {
        return iR.buscarPorTipo(tipo);

    }
}
