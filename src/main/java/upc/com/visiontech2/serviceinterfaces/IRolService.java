package upc.com.visiontech2.serviceinterfaces;

import upc.com.visiontech2.entities.Role;

import java.util.List;

public interface IRolService {
    public List<Role> list();
    public void insert(Role r);
    public Role listId(int idRol);
    public void update(Role r);
    public void delete(int idRol);
}
