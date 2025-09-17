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

    //Cria um arquivo de exemplo se a flag --exemplo for digitada(ler o README.md) __CRIADO COM AJUDA DE IA__
    public static void criarArquivoExemplo(String nomeArquivo) {
        try {
            // Criar o diretório data/ se não existir
            java.io.File diretorio = new java.io.File("data");
            if (!diretorio.exists()) {
                diretorio.mkdir();
                System.out.println("Diretório 'data/' criado.");
            }
            
            // Criar arquivo dentro do diretório data/
            String caminhoCompleto = "data/" + nomeArquivo;
            java.io.PrintWriter writer = new java.io.PrintWriter(caminhoCompleto);
            
            writer.println("# Arquivo de exemplo - iCEVOS Scheduler");
            writer.println("# Formato: id,nome,prioridade,ciclos_necessarios,recurso_necessario");
            writer.println("1,ProcessoA,1,5,CPU");
            writer.println("2,ProcessoB,2,3,DISCO");
            writer.println("3,ProcessoC,1,4,CPU");
            writer.println("4,ProcessoD,3,6,DISCO");
            writer.println("5,ProcessoE,2,2,CPU");
            writer.println("6,ProcessoF,1,7,DISCO");
            
            writer.close();
            System.out.println("Arquivo criado: " + caminhoCompleto);
            
        } catch (Exception e) {
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length >= 2 && args[0].equals("--exemplo")) {
            criarArquivoExemplo(args[1]);
            return;
        }
        System.out.println("Uso: java LeitorDocumentos --exemplo <nome_arquivo>");
    }



}

