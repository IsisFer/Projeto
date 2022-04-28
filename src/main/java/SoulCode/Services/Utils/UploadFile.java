package SoulCode.Services.Utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class UploadFile {

    public static void salvarArquivo(String uploadDir, String filename, MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
        if(!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // stream - fluxo de dados
        // InputStream - possibilita a leitura de algum dado em byte (byte por byte)
        try(InputStream inputStream = file.getInputStream()){
            Path filePath = uploadPath.resolve(filename);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }
        catch(IOException e) {
            throw new IOException("Não foi possivel enviar o seu arquivo");
        }
    }
}
