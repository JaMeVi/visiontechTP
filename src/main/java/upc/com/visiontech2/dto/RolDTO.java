package upc.com.visiontech2.dto;

import upc.com.visiontech2.entities.Role;
import upc.com.visiontech2.entities.Users;

public class RolDTO {
    private Long id;
    private String rol;
    private UsersDTO user;

    public Long getId() {      return id;    }

    public void setId(Long id) {        this.id = id;    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public UsersDTO getUser() {
        return user;
    }

    public void setUser(UsersDTO user) {
        this.user = user;
    }
}
