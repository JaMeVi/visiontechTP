package upc.com.visiontech2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.NumeroEmergenciaDTO;
import upc.com.visiontech2.entities.NumeroEmergencia;
import upc.com.visiontech2.serviceinterfaces.INumeroEmergenciaService;

import java.util.List;
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
}
