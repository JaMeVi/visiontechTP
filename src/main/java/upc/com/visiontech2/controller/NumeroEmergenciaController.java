package upc.com.visiontech2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.NumeroEmergenciaDTO;
import upc.com.visiontech2.entities.NumeroEmergencia;
import upc.com.visiontech2.entities.Users;
import upc.com.visiontech2.serviceinterfaces.INumeroEmergenciaService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/numeroemergencia")
public class NumeroEmergenciaController {
    @Autowired
    private INumeroEmergenciaService nS;
    @GetMapping
    public List<NumeroEmergenciaDTO> listar(){
        return nS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, NumeroEmergenciaDTO.class) ;
        }).collect(Collectors.toList()) ;
    }

    @PostMapping
    public void insertar(@RequestBody NumeroEmergenciaDTO nDto){
        ModelMapper modelMapper = new ModelMapper();
        NumeroEmergencia n = modelMapper.map(nDto, NumeroEmergencia.class);
        nS.insert(n);
    }

    @PutMapping
    public void modificar(@RequestBody NumeroEmergenciaDTO nDto){
        ModelMapper modelMapper = new ModelMapper();
        NumeroEmergencia n = modelMapper.map(nDto, NumeroEmergencia.class);
        nS.update(n);
    }

    @DeleteMapping("/{idNumeroEmergencia}")
    public void eliminar(@PathVariable("idNumeroEmergencia") int idNumeroEmergencia){nS.delete(idNumeroEmergencia);}

    @GetMapping("/distritos")
    public ResponseEntity<List<Map<String, Object>>> cantidadPorDistrito(){
        List<Object[]> resultados = nS.countNumeroEmergenciaPorDistrito();

        List<Map<String, Object>> response = new ArrayList<>();
        for (Object[] fila : resultados) {
            Map<String, Object> item = new HashMap<>();
            item.put("distrito", fila[0]);
            item.put("cantidad", fila[1]);
            response.add(item);
        }

        return ResponseEntity.ok(response);

    }
    @GetMapping("/emergenciaytipo")
    public ResponseEntity<List<NumeroEmergencia>> obtenerEmergenciasPorTipoYDistrito(
            @RequestParam String tipoEmergencia,
            @RequestParam String distrito,
            @RequestParam(required = false) Long usuarioId) {

        Users usuario = null;
        if (usuarioId != null) {
            // Buscar el usuario si se proporciona el usuarioId
            usuario = new Users(); // Aquí debes obtener el usuario de la base de datos
            usuario.setId(usuarioId); // Es solo un ejemplo de cómo obtener el usuario
        }

        List<NumeroEmergencia> emergencias = nS.obtenerEmergenciasPorTipoYDistrito(tipoEmergencia, distrito, usuario);

        if (emergencias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(emergencias);
    }
}
