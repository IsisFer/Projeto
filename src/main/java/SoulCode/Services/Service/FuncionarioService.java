package SoulCode.Services.Service;

import SoulCode.Services.Repositories.FuncionarioRepository;
import SoulCode.Services.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

 //injeção de dependência
 @Autowired
 FuncionarioRepository funcionarioRepository;

//serviços para buscar todos os funcionários cadastrados
    public List<Funcionario> mostrarTodosFuncionarios(){
        return funcionarioRepository.findAll();
    }

    //findByid - busca um funcionário específico pelo seu id
    public Funcionario  mostrarUmFuncionario(Integer idFuncionario) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById (idFuncionario);
       return funcionario.orElseThrow();
    }

    //findEmail
    public Funcionario mostrarFuncionarioPeloEmail(String email) {
        Optional<Funcionario> funcionario = funcionarioRepository.findByEmail (email);
        return funcionario.orElseThrow();
    }

    //findByNomeAndEmail
    public Funcionario mostrarFuncionarioPeloNomeEEmail(String nome, String email) {
        Optional<Funcionario> funcionario = funcionarioRepository.findByNomeAndEmail(nome, email);
        return funcionario.orElseThrow();
    }

    //save - insere um novo registro na tabela do nosso db
    public Funcionario inserirFuncionario(Funcionario funcionario) {

        //por precaução vamos limpar o campo de id do funcionario
        funcionario.setIdFuncionario(null);
        return funcionarioRepository.save(funcionario);
    //o método save pega os dados do novo funcionario, salva no database e já gera um id para esse novo funcionario
    }

    //editar um funcionario ja cadastrado
    public Funcionario editarFuncionario (Funcionario funcionario) {
        mostrarUmFuncionario(funcionario.getIdFuncionario());
        return funcionarioRepository.save(funcionario);
    }

    //deleteById - excluir um funcionario  pelo seu id
    public void excluirFuncionario (Integer idFuncionario) {
        mostrarUmFuncionario(idFuncionario);
        funcionarioRepository.deleteById(idFuncionario);
    }

}



