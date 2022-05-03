package SoulCode.Services.Service;

import SoulCode.Services.Data.DetalheUsuarioData;
import SoulCode.Services.Repositories.UsuarioJWTRepository;
import SoulCode.Services.model.UsuarioJWT;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class DetalheUsuarioServiceImpl  implements UserDetailsService {

    private final UsuarioJWTRepository usuarioJWTRepository ;

    public DetalheUsuarioServiceImpl(UsuarioJWTRepository usuarioJWTRepository) {
        this.usuarioJWTRepository = usuarioJWTRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioJWT> usuario = usuarioJWTRepository.findByLogin(username);
        if (usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuário  não cadastrado");
        }
        return new DetalheUsuarioData(usuario);
    }
}
