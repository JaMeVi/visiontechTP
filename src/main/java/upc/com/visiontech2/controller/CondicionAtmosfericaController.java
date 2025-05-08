package upc.com.visiontech2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.CondicionAtmosfericaDTO;
import upc.com.visiontech2.entities.CondicionAtmosferica;
import upc.com.visiontech2.serviceinterfaces.ICondicionAtmosfericaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catmosferica")
public class CondicionAtmosfericaController {

    @Autowired
    private ICondicionAtmosfericaService cA;

    @GetMapping
    public List<CondicionAtmosfericaDTO> listar(){
        return cA.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, CondicionAtmosfericaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody CondicionAtmosfericaDTO cAtmosfericasDTO){
        ModelMapper modelMapper = new ModelMapper();
        CondicionAtmosferica ca = modelMapper.map(cAtmosfericasDTO, CondicionAtmosferica.class);
        cA.insert(ca);
    }


    @GetMapping("/{idCAtmosferica}")
    public CondicionAtmosfericaDTO listarId(@PathVariable("idCAtmosferica") int idCAtmosferica){
        ModelMapper modelMapper = new ModelMapper();
        CondicionAtmosfericaDTO dto = modelMapper.map(cA.listId(idCAtmosferica), CondicionAtmosfericaDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody CondicionAtmosfericaDTO cAtmosfericasDTO){
        ModelMapper modelMapper = new ModelMapper();
        CondicionAtmosferica ca = modelMapper.map(cAtmosfericasDTO, CondicionAtmosferica.class);
        cA.update(ca);
    }

    @DeleteMapping( "/{idCAtmosferica}")
    public void eliminar(@PathVariable("idCAtmosferica") int idCAtmosferica){cA.delete(idCAtmosferica);}

}
