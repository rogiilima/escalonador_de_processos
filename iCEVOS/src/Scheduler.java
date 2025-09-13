public class Scheduler {
    // Três listas encadeadas simples
    private ListasDeProcessos listaAlta = new ListasDeProcessos();
    private ListasDeProcessos listaMedia = new ListasDeProcessos();
    private ListasDeProcessos listaBaixa = new ListasDeProcessos();

    // Lista circular para processos bloqueados, uso apenas para isso
    private ListaCircular listaBloqueados = new ListaCircular();

    private int contadorAlta = 0;
    private int ciclo = 0;

    // Inserir processo na fila correta, geralmente é o padrão
    public void inserirProcesso(EstruturaProcesso p) {
        switch (p.getPrioridade()) {
            case 1 : 
            listaAlta.inserirNoFim(p);
            case 2 :
             listaMedia.inserirNoFim(p);
            case 3 :
             listaBaixa.inserirNoFim(p);
            default :
             System.out.println("Prioridade inválida para " + p);
        }
    }


    public void executarCicloDeCPU() {
        ciclo++;
        System.out.println("\n=== Ciclo " + ciclo + " ===");

        // Desbloqueio - pega o mais antigo da lista circular
        if (!listaBloqueados.listaVazia()) {
            EstruturaProcesso desbloqueado = listaBloqueados.removeCabeca(); 
            System.out.println("Desbloqueando " + desbloqueado.getNome());
            inserirProcesso(desbloqueado);
        }
        EstruturaProcesso atual = null;
        if (contadorAlta == 5) { // se o contadorAlta for igual a 5, remove cabeça de lista media, executando o processo
        atual = listaMedia.removeCabeca();
        
        if (atual == null) { // se não houver lista media tentar de baixa
        atual = listaBaixa.removeCabeca();
        } 
    } 
    if (atual != null) { // faz a anti-inanição do scheduler
                System.out.println("Anti-inanição aplicada! Executando " + atual.getNome());
                contadorAlta = 0;
                return;
            }
    }
}
