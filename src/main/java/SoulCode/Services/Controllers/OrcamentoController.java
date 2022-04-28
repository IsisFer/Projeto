package SoulCode.Services.Controllers;

import SoulCode.Services.Service.OrcamentoService;
import SoulCode.Services.model.Orcamento;
import SoulCode.Services.model.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("servicos")
public class OrcamentoController {

    @Autowired
    OrcamentoService orcamentoService;

    @GetMapping("/orcamento")
    public List<Orcamento> mostrarTodosOrcamentos(){
        List<Orcamento> orcamentos = orcamentoService.mostrarTodosOrcamentos();
        return orcamentos;
    }

    @GetMapping("/orcamento/{idOrcamento}")
    public ResponseEntity<Orcamento> mostrarUmOrcamento (@PathVariable Integer idOrcamento) {
        Orcamento orcamento = orcamentoService.mostrarUmOrcamento(idOrcamento);
        return ResponseEntity.ok().body(orcamento);
    }

    @GetMapping("/orcamentoStatus")
    public List<Orcamento> mostrarOrcamentoPeloStatus(@RequestParam("status") String status){
        List<Orcamento> orcamentos = orcamentoService.mostrarOcamentoPeloStatus(status);
        return orcamentos;
    }

    @PostMapping("/orcamento/{idServico}")
    public ResponseEntity<Orcamento> InserirOrcamento(@PathVariable Integer idServico, @RequestBody Orcamento orcamento){
        orcamento = orcamentoService.inserirOrcamento(orcamento, idServico);
        URI uriNova = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(orcamento.getIdOrcamento()).toUri();
        return ResponseEntity.created(uriNova).build();
    }

    @PostMapping("/orcamentoQuitacao/{idOrcamento}")
    public ResponseEntity<Void> quitarOrcamento(@PathVariable Integer idOrcamento) {
        Orcamento orcamento = orcamentoService.quitarOrcamento(idOrcamento);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/orcamento/{idOrcamento}")
    public ResponseEntity<Void> excluirOrcamento(@PathVariable Integer idOrcamento) {
        orcamentoService.excluirOrcamento(idOrcamento);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/orcamento/{idOrcamento}")
    public ResponseEntity<Orcamento> editarOrcamento(@PathVariable Integer idOrcamento, @RequestBody Orcamento orcamento) {
        orcamento.setIdOrcamento(idOrcamento);
        orcamentoService.editarOrcamento(orcamento, idOrcamento);
        return ResponseEntity.noContent().build();
    }

}
