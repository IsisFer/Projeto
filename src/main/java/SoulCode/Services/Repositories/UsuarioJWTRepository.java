package SoulCode.Services.Repositories;

import SoulCode.Services.model.UsuarioJWT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioJWTRepository extends JpaRepository<UsuarioJWT, Integer> {

public Optional<UsuarioJWT> findByLogin(String login);
}
