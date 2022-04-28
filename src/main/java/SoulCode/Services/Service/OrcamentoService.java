package SoulCode.Services.Service;

import SoulCode.Services.Repositories.OrcamentoRepository;
import SoulCode.Services.Repositories.ServicoRepository;
import SoulCode.Services.model.Orcamento;
import SoulCode.Services.model.Servico;
import SoulCode.Services.model.StatusOrcamento;
import SoulCode.Services.model.StatusServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrcamentoService {

    @Autowired
    OrcamentoRepository orcamentoRepository;

    @Autowired
    ServicoRepository servicoRepository;

    //método para trazer todos  os orcamentos cadastrados no db (findAll)
    public List<Orcamento> mostrarTodosOrcamentos() {
        return orcamentoRepository.findAll();
    }

    public Orcamento mostrarUmOrcamento (Integer idOrcamento) {
        Optional<Orcamento> orcamento = orcamentoRepository.findById(idOrcamento);
        return orcamento.orElseThrow();
    }

    //método para trazer os orçamentos de acordo com o status
    public List<Orcamento>mostrarOcamentoPeloStatus(String status){
        return orcamentoRepository.findByStatus(status);
    }

    public Orcamento inserirOrcamento(Orcamento orcamento , Integer idServico) {
        orcamento.setIdOrcamento(idServico);
        orcamento.setStatus(StatusOrcamento.EMITIDO);
        orcamentoRepository.save(orcamento);
        Servico servico = servicoRepository.getById(idServico);
        servico.setStatus(StatusServico.RECEBIDO);
        servico.setOrcamento(orcamento);
        servicoRepository.save(servico);
        return orcamento;
    }

    //servico para pagamento de um orcamento (liquidar um orcamento)- modificar o status do orcamento para Quitado
    public Orcamento quitarOrcamento(Integer idOrcamento) {
        Orcamento orcamento = mostrarUmOrcamento(idOrcamento);
        orcamento.setStatus(StatusOrcamento.QUITADO);
        return orcamentoRepository.save(orcamento);
    }

    //servico para deletar um orcamento
    public void excluirOrcamento(Integer idOrcamento){
        Servico servico = servicoRepository.getById(idOrcamento);
        servico.setOrcamento(null);
        servico.setStatus(StatusServico.ARQUIVADO);
        servicoRepository.save(servico);
        orcamentoRepository.deleteById(idOrcamento);
    }

    //servico para  alteraçao dos  daods de um orcamento
    public Orcamento editarOrcamento(Orcamento orcamento, Integer idOrcamento){
        mostrarUmOrcamento(orcamento.getIdOrcamento());
        return orcamentoRepository.save(orcamento);
    }

}
