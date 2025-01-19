package bancodedados;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class LeitorDeArquivos {
    public static String carregaArquivo(String caminho) throws FileNotFoundException, IOException {
        InputStream entrada = LeitorDeArquivos.class.getClassLoader().getResourceAsStream(caminho);
        if (entrada == null) {
            throw new FileNotFoundException("file not found: " + caminho);
        }

        StringBuilder arquivo = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(entrada))) {
            String line;
            while ((line = reader.readLine()) != null) {
                arquivo.append(line).append("\n");
            }
        }
        return arquivo.toString();
    }
}
