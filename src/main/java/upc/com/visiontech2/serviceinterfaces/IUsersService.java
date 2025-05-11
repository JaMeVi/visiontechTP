package upc.com.visiontech2.serviceinterfaces;
import org.springframework.data.repository.query.Param;
import upc.com.visiontech2.entities.Users;
import java.util.List;

public interface IUsersService {
    public List<Users> list();
    public void insert(Users u);
    public void update (Users usuario);
    public void delete (long id);
    public Users listId(long id);
    public List<Users> obtenerUsuariosConMuchosRegistros(long minCantidad);
}
