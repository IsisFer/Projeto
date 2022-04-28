package SoulCode.Services.Service;

import SoulCode.Services.Repositories.FuncionarioRepository;
import SoulCode.Services.Repositories.ServicoRepository;
import SoulCode.Services.model.Funcionario;
import SoulCode.Services.model.Servico;
import SoulCode.Services.model.StatusServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.spi.ServiceRegistry;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

@Autowired
static
ServicoRepository servicoRepository;

@Autowired
FuncionarioRepository funcionarioRepository;

    // serviço para buscar todos os funcionários cadastrado
    public List<Servico> mostrarTodosServicos(){
        return  servicoRepository.findAll();
    }

    //findById busca um funcionário específico pelo seu id
    public Servico mostrarmServico(Integer idServico){
        Optional<Servico> servico = servicoRepository.findById(idServico);
        return servico.orElseThrow();
    }

    //FindByiD - BUSCA UM REGISTRO PELA SUA CHAVE PRIMARIA
    public static Servico mostrarUmServico(Integer idServico) {
        Optional<Servico> servico = servicoRepository.findById(idServico);
        return servico.orElseThrow();
    }

    //
    //
    public List<Servico> buscarServicosDoFuncionario(Integer idFuncionario) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
        return servicoRepository.findByFuncionario(funcionario);
    }

    public List<Servico> buscarServicoPelaData(Date dataEntrada) {
        return servicoRepository.findByDataEntrada(dataEntrada);
    }

    public List<Servico> buscarServicoPorIntevervaloData(Date data1, Date date2) {
        return servicoRepository.findByIntevaloData(data1, date2);
    }

    public List<Servico> buscarServicoPeloStatus(String status) {
        return servicoRepository.findByStatus(status);
    }

    public List<Servico> buscarServicoSemFuncionario(){
        return servicoRepository.findByIdFuncionarioNull();
    }

    //método para cadastro de um serviço
    //no momento do cadastro do novo serviço o status tem que ficar como recebido
    //no momento do cadastro do novo serviço o idFuncionário tem que ficar como null

    public Servico inserirServico(Servico servico) {
        servico.setIdServico(null);
        servico.setStatus(StatusServico.RECEBIDO);
        servico.setFuncionario(null);
         return servicoRepository.save(servico);
    }

    //método para atribuir um determinado serviço para um determinado funcionário
    //o serviço precisa receber o status de atribuído
    public Servico atribuirFuncionario(Integer idServico, Integer idFuncionario) {
    //buscamos o funcionario para ser atribuido ao serviço através do seu id
        Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
    //buscamos o serviço para o qual esse funcionário vai ser atribuido
        Servico servico = mostrarUmServico(idServico);
        servico.setIdServico(idServico);
        servico.setFuncionario(funcionario.get());
        servico.setStatus(StatusServico.ATRIBUIDO);

        return servicoRepository.save(servico);
    }

    //método para mudar o status do servido para concluido
    public static Servico concluirServico(Integer idServico){
        Servico servico = mostrarUmServico(idServico);
        servico.setIdServico(idServico);
        servico.setStatus(StatusServico.CONCLUIDO);

        return servicoRepository.save(servico);
    }

    //deleteById
    public void deletarUmServico(Integer idServico) {
        servicoRepository.deleteById(idServico);
    }

    //editar os dados de um servico
    public Servico editarServico(Servico servico, Integer idFuncionario) {
        mostrarmServico(servico.getIdServico());
        Funcionario funcionario = funcionarioRepository.getById(idFuncionario);
        servico.setFuncionario(funcionario);
        return servicoRepository.save(servico);
    }


};
