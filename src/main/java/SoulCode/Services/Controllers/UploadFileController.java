package SoulCode.Services.Controllers;

import SoulCode.Services.Service.FuncionarioService;
import SoulCode.Services.Utils.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RequestMapping("servicos")
@RestController
public class UploadFileController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping("/funcionario/envioFoto/{idFuncionario}")


    public ResponseEntity<Void> enviarDados(@PathVariable Integer idFuncionario, MultipartFile foto, @RequestParam("nome") String nome) {
        String fileName = nome;
        String uploadDir = "D://Isis//dev//trabalho//frontend//src//assets//imagens";
        String nomeMaisCaminho = "/assets/funcionarios/" + nome;


        funcionarioService.salvarFoto(idFuncionario, nomeMaisCaminho);

        try {
            UploadFile.salvarArquivo(uploadDir, fileName, foto);

        } catch (Exception e){
            System.out.println("O arquivo não foi enviado: " + e);
        }
        System.out.println("Arquivo enviado: " + nomeMaisCaminho);
        return ResponseEntity.ok().build();
    }

}



