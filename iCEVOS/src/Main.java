public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java Main <caminho_do_arquivo>");
            return;
        }

        String caminhoArquivo = args[0];

        Scheduler scheduler = new Scheduler(); // sua classe Scheduler já implementada


        LeitorDocumentos.lerArquivo(caminhoArquivo, scheduler);

        // Executa ciclos até todas as listas ficarem vazias
        while (true) {
            scheduler.mostrarFilas(); // usa o método da classe Scheduler
            scheduler.executarCicloDeCPU();

            // Verifica se todas as listas estão vazias
            if (scheduler.listaAltaVazia() && scheduler.listaMediaVazia() &&
                    scheduler.listaBaixaVazia() && scheduler.listaBloqueadosVazio()) {
                System.out.println("Todos os processos foram executados. Fim da simulação.");
                break;
            }
        }
    }
}



