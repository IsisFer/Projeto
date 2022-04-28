package SoulCode.Services.Controllers;

import SoulCode.Services.Service.FuncionarioService;
import SoulCode.Services.model.Funcionario;
import SoulCode.Services.model.Servico;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("servicos")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping("/funcionario")
    public List<Funcionario> mostrarTodosFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.mostrarTodosFuncionarios();
        return funcionarios;
    }

    @GetMapping("/funcionario/{idFuncionario}")
    public ResponseEntity<Funcionario> mostrarUmFuncionario(@PathVariable Integer idFuncionario) {
        Funcionario funcionario = funcionarioService.mostrarUmFuncionario(idFuncionario);
        return ResponseEntity.ok().body(funcionario);
    }

    @GetMapping("/funcionario/{email}")
    public ResponseEntity<Funcionario> mostrarFuncionarioPeloEmail(@PathVariable String email){
        Funcionario funcionario = funcionarioService.mostrarFuncionarioPeloEmail(email);
        return ResponseEntity.ok().body(funcionario);
    }

    @GetMapping("/funcionarioNomeEmail")
    public ResponseEntity<Funcionario> mostrarFuncionarioPeloNomeEEmail(@PathVariable String nome, @PathVariable String email) {
        Funcionario funcionario = funcionarioService.mostrarFuncionarioPeloNomeEEmail(nome, email);
        return ResponseEntity.ok().body(funcionario);
    }

    @PostMapping("/funcionario")
    public ResponseEntity<Funcionario> inserirFuncionario(@RequestBody Funcionario funcionario) {
        funcionario = funcionarioService.inserirFuncionario(funcionario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(funcionario.getIdFuncionario()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/funcionario/{idFuncionario}")
    public ResponseEntity<Funcionario> editarFuncionario(@PathVariable Integer idFuncionario, @RequestBody Funcionario funcionario) {
        funcionario.setIdFuncionario(idFuncionario);
        funcionario = funcionarioService.editarFuncionario(funcionario);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/funcionario/{idFuncionario}")
    public ResponseEntity<Void> excluirFuncionario(@PathVariable Integer idFuncionario) {
        funcionarioService.excluirFuncionario(idFuncionario);
        return ResponseEntity.noContent().build();
    }


}
