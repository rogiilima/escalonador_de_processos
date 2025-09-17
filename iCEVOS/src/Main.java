public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java Main <caminho_do_arquivo>");
            return;
        }

        String caminhoArquivo = args[0];

        Scheduler scheduler = new Scheduler(); // cria um scheduler novo


        LeitorDocumentos.lerArquivo(caminhoArquivo, scheduler); //Ler o documento txt

        // Executa ciclos até todas as listas ficarem vazias
        while (scheduler.temProcessoAtivo()) {
            scheduler.executarCicloDeCPU();
            scheduler.mostrarFilas(); 
        }
        // Quando terminar a execução de todos os processos
        System.out.println("Todos os processos foram executados. Fim da simulação.");
    }
}



