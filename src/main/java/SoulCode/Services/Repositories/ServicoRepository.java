package SoulCode.Services.Repositories;

import SoulCode.Services.model.Funcionario;
import SoulCode.Services.model.Servico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    //esse métodovai trazer todos os serviços de  um determinado funcionário,
    // como na teabela de serviço, nós temso o atributo funcionário, devemos fazer uso do findBy
    //o nome do método será findByFuncionário e recebe como parametro um optinal de funcionario
    List<Servico> findByFuncionario(Optional<Funcionario> funcionario);

    List<Servico> findByDataEntrada(Date data);

    @Query(value = "SELECT * FROM servico WHERE data_entrada BETWEEN :data1 AND :data2", nativeQuery = true)
    List<Servico> findByIntevaloData(Date data1, Date data2);

    @Query(value = "SELECT * FROM servico WHERE status = :status", nativeQuery = true)
    List<Servico> findByStatus(String status);

    @Query(value = "SELECT * FROM servico WHERE id_funcionario is null", nativeQuery = true)
    List<Servico> findByIdFuncionarioNull();
}