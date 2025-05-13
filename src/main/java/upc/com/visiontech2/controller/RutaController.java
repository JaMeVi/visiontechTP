package upc.com.visiontech2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.RutaDTO;
import upc.com.visiontech2.dto.RutaPromedioDTO;
import upc.com.visiontech2.entities.Ruta;
import upc.com.visiontech2.repositories.IncidenteRepository;
import upc.com.visiontech2.repositories.RutaRepository;
import upc.com.visiontech2.serviceinterfaces.IRutaService;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/rutas")
public class RutaController {
    @Autowired
    private IRutaService rS;
    @Autowired
    private IncidenteRepository incidenteRepository;
    @Autowired
    private RutaRepository rutaRepository;

    @GetMapping
    public List<RutaDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RutaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody RutaDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Ruta r = m.map(rDTO, Ruta.class);
        rS.insert(r);
    }

    @GetMapping("/{idRuta}")
    public RutaDTO listarId(@PathVariable("idRuta") int idRuta) {
        ModelMapper m = new ModelMapper();
        RutaDTO dto = m.map(rS.listId(idRuta), RutaDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody RutaDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Ruta r = m.map(rDTO, Ruta.class);
        rS.update(r);
    }

    @DeleteMapping("/{idRuta}")
    public void eliminar(@PathVariable("idRuta") int idRuta) {
        rS.delete(idRuta);
    }


    @PutMapping("/marcarfavorito/{id}/{estado}")
    public void marcarFavorito(@PathVariable("id") int id, @PathVariable("estado") boolean estado) {
        rS.marcarFavorita(id, estado);
    }
    @GetMapping("/favoritas")
    public List<Ruta> listarFavoritas() {
        return rS.listarFavoritas();
    }
    @GetMapping("/busquedas/{nombre}")
    public ResponseEntity<RutaDTO> obtenerRutaPorNombre(@PathVariable String nombre) {
        Ruta ruta = rS.obtenerPorNombre(nombre);
        ModelMapper mapper = new ModelMapper();
        RutaDTO dto = mapper.map(ruta, RutaDTO.class);
        return ResponseEntity.ok(dto);
    }



    @GetMapping("/mas-corta-tiempo")
    public Ruta getRutaMasCortaPorTiempo() {
        return rS.obtenerRutaMasCortaPorTiempo();
    }

    @GetMapping("/mas-corta-distancia")
    public Ruta getRutaMasCortaPorDistancia() {
        return rS.obtenerRutaMasCortaPorDistancia();
    }
    @GetMapping("/promedio-tiempo/{idRuta}")
    public RutaPromedioDTO obtenerPromedioTiempo(@PathVariable int idRuta) {
        return rS.obtenerPromedioTiempoRuta(idRuta);
    }
}
