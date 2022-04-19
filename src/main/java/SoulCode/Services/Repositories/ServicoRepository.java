package SoulCode.Services.Repositories;

import SoulCode.Services.model.Servico;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}