package SoulCode.Services.Controllers;

import SoulCode.Services.Service.FuncionarioService;
import SoulCode.Services.Utils.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin
@RequestMapping("servicos")
@RestController
public class UploadFileController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping("/funcionario/envioFoto/{idFuncionario}")
    public ResponseEntity<String> enviarDados(@PathVariable Integer idFuncionario, MultipartFile foto, @RequestParam("nome") String nome) throws IOException {
        String fileName = nome;
        String uploadDir = "D:/Isis/dev/trabalho/frontend/src/assets/imagens";
        String nomeMaisCaminho = "assets/imagens/" + nome;

        funcionarioService.salvarFoto(idFuncionario, nomeMaisCaminho);

        try {
            UploadFile.salvarArquivo(uploadDir, fileName, foto);
        } catch(Exception e){
            System.out.println("O arquivo não foi enviado: " + e);
        }
        System.out.println("Arquivo enviado: " + nomeMaisCaminho);
        return ResponseEntity.ok("Arquivo enviado");
    }

}
