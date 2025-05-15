package upc.com.visiontech2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import upc.com.visiontech2.entities.Users;
import upc.com.visiontech2.repositories.IUserRepository;
import upc.com.visiontech2.serviceinterfaces.IUsersService;

import java.util.List;

@Service
public class UsersServiceImplement implements IUsersService {
    @Autowired
    private IUserRepository uR;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Users u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        uR.save(u);
    }

    @Override
    public void update(Users usuario) {
        uR.save(usuario);
    }

    @Override
    public void delete(long id) {
        uR.deleteById(id);
    }

    @Override
    public Users listId(long id) {
        return uR.findById(id).orElse(new Users());
    }

    @Override
    public Users findById(long id) {
        return uR.findById(id).orElse(new Users());
    }

    @Override
    public List<Users> obtenerUsuariosConMuchosRegistros(long minCantidad) {
        return uR.findUsuariosConMuchosRegistros(minCantidad);
    }

    @Override
    public Users buscarPorUsername(String username) {
        return uR.buscarPorUsername(username);
    }

    @Override
    public Users findOneByUsername(String username) {
        return uR.findOneByUsername(username);
    }

}
