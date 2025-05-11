package upc.com.visiontech2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.UserSecurityDTO;
import upc.com.visiontech2.dto.UsersDTO;
import upc.com.visiontech2.entities.Users;
import upc.com.visiontech2.serviceinterfaces.IUsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsersController {
    @Autowired
    private IUsersService uS;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<UsersDTO> listar(){
        return uS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insert (@RequestBody UserSecurityDTO dtouser){
        ModelMapper m=new ModelMapper();
        Users u = m.map(dtouser, Users.class);
        uS.insert(u);
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{id}")
    public UsersDTO listarId(@PathVariable ("id") Integer id){
        ModelMapper m=new ModelMapper();
        UsersDTO dto=m.map(uS.listId(id), UsersDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ("id") Integer id){
        uS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody UsersDTO dto){
        ModelMapper m=new ModelMapper();
        Users u=m.map(dto, Users.class);
        uS.update(u);
    }
    @GetMapping("/activos-emergencias")
    public ResponseEntity<List<Users>> obtenerUsuariosConMuchosRegistros(@RequestParam long minCantidad) {
        List<Users> usuarios = uS.obtenerUsuariosConMuchosRegistros(minCantidad);

        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(usuarios);
    }

}
