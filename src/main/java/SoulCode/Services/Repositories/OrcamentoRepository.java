package SoulCode.Services.Repositories;

import SoulCode.Services.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento,Integer>{

    @Query(value = "SELECT * FROM orcamento WHERE status = :status", nativeQuery = true)
    List<Orcamento> findByStatus(String status);
}