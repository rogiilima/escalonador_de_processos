import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorDocumentos {
    public static void main(String[] args) {


        // Verifica se o usuário passou o caminho do arquivo
        if (args.length == 0) {
            System.out.println("Uso: java LeitorProcessos <caminho_do_arquivo>");
            return;
        }


        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("Disco"))) {

            //Ler linha por linha

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

    }
}

