package upc.com.visiontech2.controller;


import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.RolDTO;
import upc.com.visiontech2.dto.RolInsertDTO;
import upc.com.visiontech2.entities.Role;
import upc.com.visiontech2.entities.Users;
import upc.com.visiontech2.serviceinterfaces.IRolService;
import upc.com.visiontech2.serviceinterfaces.IUsersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private IRolService rS;
    @Autowired
    private IUsersService uS;
    @GetMapping
    public List<RolDTO> listar(){
        return rS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> insert(@Valid @RequestBody RolInsertDTO dtorol){
        Role r = new Role();
        r.setRol(dtorol.getRol());

        
        Users usuario = uS.findById(dtorol.getUserId());
        if (usuario == null) {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }

        r.setUser(usuario);

        rS.insert(r);

        String mensaje = "Rol registrado correctamente: " + dtorol.getRol();
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public RolDTO listarId(@PathVariable ("id") long id){
        ModelMapper m=new ModelMapper();
        RolDTO dto=m.map(rS.listId(id), RolDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable ("id") long id){

        rS.delete(id);
        return ResponseEntity.ok("Rol eliminado correctamente (ID: " + id + ")");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RolDTO dto){
        ModelMapper m=new ModelMapper();
        Role u=m.map(dto, Role.class);
        rS.update(u);
        return ResponseEntity.ok("Rol actualizado correctamente (ID: " + u.getId() + ")");
    }


}
