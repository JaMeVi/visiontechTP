package upc.com.visiontech2.serviceinterfaces;

import upc.com.visiontech2.entities.Users;

import java.util.List;

public interface IUsuarioService {
    public List<Users> list();
    public void insert(Users u);
    public Users listId(long idUsuario);
    public void update(Users u);
    public void delete(long idUsuario);
    public List<Users> buscarPorNombre(String nombre);
}
