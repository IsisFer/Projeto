package SoulCode.Services.Controllers;

import SoulCode.Services.Repositories.UsuarioJWTRepository;
import SoulCode.Services.Service.UsuarioJWTService;
import SoulCode.Services.model.UsuarioJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("servicos")
public class UsuarioJWTController {

    @Autowired
    UsuarioJWTService usuarioJWTService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UsuarioJWTRepository usuarioJWTRepository;

    @GetMapping("/usuarioJWT")
    public ResponseEntity<List<UsuarioJWT>> listarUsuarioJWT(){
        return ResponseEntity.ok(usuarioJWTService.listarUsuarioJWT());
    }

    @PostMapping("/usuarioJWT")
    public ResponseEntity<UsuarioJWT> inserirUsuario(@RequestBody UsuarioJWT usuarioJWT){
        usuarioJWT.setPassword(encoder.encode(usuarioJWT.getPassword()));
        return ResponseEntity.ok().body(usuarioJWTService.inserirUsuario(usuarioJWT));
    }

}
