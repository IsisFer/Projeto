package SoulCode.Services.Controllers;

import SoulCode.Services.Service.ServicoService;
import SoulCode.Services.model.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("servicos")
@CrossOrigin
public class ServicoController {

    @Autowired
    ServicoService servicoService;

    //mapeamento para mostrar todos os servicos
    @GetMapping("/servico")
    public List<Servico> mostrarTodoServicos() {
        List<Servico> servicos = servicoService.mostrarTodosServicos();
        return servicos;
    }

    @GetMapping("/servico/{idServico}")
    public ResponseEntity<Servico>  mostrarUmServico(@PathVariable Integer idServico){
        Servico servico = servicoService.mostrarumServico(idServico);
        return ResponseEntity.ok().body(servico);
    }
}