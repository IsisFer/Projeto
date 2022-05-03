package SoulCode.Services.Service;

import SoulCode.Services.Repositories.UsuarioJWTRepository;
import SoulCode.Services.model.UsuarioJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioJWTService {

    @Autowired
    UsuarioJWTRepository usuarioJWTRepository;

    public List<UsuarioJWT> listarUsuarioJWT(){
        return usuarioJWTRepository.findAll();
    }

    public UsuarioJWT inserirUsuario(UsuarioJWT usuarioJWT){
        return usuarioJWTRepository.save(usuarioJWT);
    }
}
