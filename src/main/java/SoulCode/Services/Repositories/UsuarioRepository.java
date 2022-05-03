package SoulCode.Services.Repositories;

import SoulCode.Services.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

    Usuario findByLogin(String login);
}
