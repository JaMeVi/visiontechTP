package upc.com.visiontech2.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.UserSecurityDTO;
import upc.com.visiontech2.dto.UsersDTO;
import upc.com.visiontech2.entities.Users;
import upc.com.visiontech2.serviceinterfaces.IUsersService;

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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<String> insert (@Valid @RequestBody UserSecurityDTO dtouser){
        ModelMapper m=new ModelMapper();
        Users u = m.map(dtouser, Users.class);
        uS.insert(u);
        String mensaje = "Usuario registrado correctamente: " + dtouser.getNombre();
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}/PorId")
    public UsersDTO listarId(@PathVariable ("id") Integer id){
        ModelMapper m=new ModelMapper();
        UsersDTO dto=m.map(uS.listId(id), UsersDTO.class);
        return dto;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "/username/{username}")
    public UsersDTO buscarPorUsername(@PathVariable("username") String username) {
        ModelMapper m = new ModelMapper();
        return m.map(uS.findOneByUsername(username), UsersDTO.class);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}", params = "type=id")
    public ResponseEntity<String> delete(@PathVariable ("id") Integer id){

        uS.delete(id);
        return ResponseEntity.ok("Usuario eliminado correctamente (ID: " + id + ")");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping
    public ResponseEntity<String> modificar(@Valid @RequestBody UsersDTO dto){
        ModelMapper m=new ModelMapper();
        Users u=m.map(dto, Users.class);
        uS.update(u);
        return ResponseEntity.ok("Usuario actualizado correctamente (ID: " + u.getId() + ")");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/activos-emergencias")
    public ResponseEntity<List<Users>> obtenerUsuariosConMuchosRegistros(@RequestParam long minCantidad) {
        List<Users> usuarios = uS.obtenerUsuariosConMuchosRegistros(minCantidad);

        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

}
