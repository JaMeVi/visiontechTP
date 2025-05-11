package upc.com.visiontech2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.RutaDTO;
import upc.com.visiontech2.entities.Ruta;
import upc.com.visiontech2.serviceinterfaces.IRutaService;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/rutas")
public class RutaController {
    @Autowired
    private IRutaService rS;

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

    @GetMapping("/busquedas")
    public List<RutaDTO> buscar(@RequestParam String n) {
        return rS.buscarPorNombre(n).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RutaDTO.class);
        }).collect(Collectors.toList());
    }
    @PutMapping("/marcarfavorito/{id}/{estado}")
    public void marcarFavorito(@PathVariable("id") int id, @PathVariable("estado") boolean estado) {
        rS.marcarFavorita(id, estado);
    }

    @GetMapping("/favoritas")
    public ResponseEntity<List<Ruta>> listarFavoritas() {
        return ResponseEntity.ok(rS.listarFavoritas());

    }

    @GetMapping("/mas-corta-tiempo")
    public ResponseEntity<Ruta> getRutaMasCortaPorTiempo() {
        Ruta ruta = rS.obtenerRutaMasCortaPorTiempo();
        return ResponseEntity.ok(ruta);
    }

    @GetMapping("/mas-corta-distancia")
    public ResponseEntity<Ruta> getRutaMasCortaPorDistancia() {
        Ruta ruta = rS.obtenerRutaMasCortaPorDistancia();
        return ResponseEntity.ok(ruta);
    }
    @GetMapping("/promedio-tiempo/{idRuta}")
    public RutaPromedioDTO obtenerPromedioTiempo(@PathVariable int idRuta) {
        return rS.obtenerPromedioTiempoRuta(idRuta);
    }
}
