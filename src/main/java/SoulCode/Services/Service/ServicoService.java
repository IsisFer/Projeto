package SoulCode.Services.Service;

import SoulCode.Services.Repositories.ServicoRepository;
import SoulCode.Services.model.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

@Autowired
ServicoRepository servicoRepository;

    // serviço para buscar todos os funcionários cadastrado
    public List<Servico> mostrarTodosServicos(){
        return  servicoRepository.findAll();
    }

    //findById busca um funcionário específico pelo seu id
    public Servico mostrarumServico(Integer idServico){
        Optional<Servico> servico = servicoRepository.findById(idServico);
        return servico.orElseThrow();
    }
};
