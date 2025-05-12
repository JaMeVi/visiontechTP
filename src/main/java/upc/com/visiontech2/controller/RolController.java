package upc.com.visiontech2.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.RolDTO;
import upc.com.visiontech2.entities.Role;
import upc.com.visiontech2.serviceinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private IRolService rS;

    @GetMapping
    public List<RolDTO> listar(){
        return rS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insert (@RequestBody RolDTO dtorol){
        ModelMapper m=new ModelMapper();
        Role r = m.map(dtorol, Role.class);
        rS.insert(r);
    }

    @GetMapping("/{id}")
    public RolDTO listarId(@PathVariable ("id") Integer id){
        ModelMapper m=new ModelMapper();
        RolDTO dto=m.map(rS.listId(id), RolDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ("id") Integer id){
        rS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody RolDTO dto){
        ModelMapper m=new ModelMapper();
        Role u=m.map(dto, Role.class);
        rS.update(u);
    }


}
