package SoulCode.Services.Repositories;

import SoulCode.Services.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Integer> {

    Optional<Funcionario> findByEmail(String email);
    //findByNome
    //findByFoto
    Optional<Funcionario> findByNomeAndEmail(String nome, String email);

}

