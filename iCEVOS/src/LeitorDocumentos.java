import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorDocumentos {

    // Recebe o caminho do arquivo e o Scheduler
    public static void lerArquivo(String caminhoArquivo, Scheduler scheduler) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim(); // remover os espaços
                if (linha.isEmpty() || linha.startsWith("#")) continue;

                // Separar campos: id,nome,prioridade,ciclos_necessarios,recurso_necessario
                String[] campos = linha.split(",", -1);
                if (campos.length < 4) continue;

                int id = Integer.parseInt(campos[0].trim());
                String nome = campos[1].trim();
                int prioridade = Integer.parseInt(campos[2].trim());
                int ciclos = Integer.parseInt(campos[3].trim());
                String recurso = (campos.length >= 5 && !campos[4].trim().isEmpty())
                        ? campos[4].trim() : null;

                EstruturaProcesso lista = new EstruturaProcesso(id, nome, prioridade, ciclos, recurso);
                scheduler.inserirProcesso(lista); // insere direto no Scheduler
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}

