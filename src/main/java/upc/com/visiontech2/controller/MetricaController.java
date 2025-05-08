package upc.com.visiontech2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.MetricaDTO;
import upc.com.visiontech2.entities.Metrica;
import upc.com.visiontech2.serviceinterfaces.IMetricaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/metricas")
public class MetricaController{

    @Autowired
    private IMetricaService mS;

    @GetMapping
    public List<MetricaDTO> listar(){
        return mS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, MetricaDTO.class) ;
        }).collect(Collectors.toList()) ;
    }

    @PostMapping
    public void insertar(@RequestBody MetricaDTO mDto){
        ModelMapper modelMapper = new ModelMapper();
        Metrica m = modelMapper.map(mDto, Metrica.class);
        mS.insert(m);
    }

    @PutMapping
    public void modificar(@RequestBody MetricaDTO mDto){
        ModelMapper modelMapper = new ModelMapper();
        Metrica m = modelMapper.map(mDto, Metrica.class);
        mS.update(m);
    }

    @DeleteMapping("/{idMetrica}")
    public void eliminar(@PathVariable("idMetrica") int idMetrica){mS.delete(idMetrica);}

}
