public class Scheduler {
    // Três listas encadeadas simples
    private ListasDeProcessos listaAlta = new ListasDeProcessos();
    private ListasDeProcessos listaMedia = new ListasDeProcessos();
    private ListasDeProcessos listaBaixa = new ListasDeProcessos();

    // Lista circular para processos bloqueados, uso apenas para isso
    private ListaCircular listaBloqueados = new ListaCircular();

    private int contadorAlta = 0;
    private int ciclo = 0;

    // Inserir processo na fila correta
    public void inserirProcesso(EstruturaProcesso p) {
        switch (p.getPrioridade()) {
            case 1 : 
             listaAlta.inserirNoFim(p);
             break;
            case 2 :
             listaMedia.inserirNoFim(p);
             break;
            case 3 :
             listaBaixa.inserirNoFim(p);
             break;
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

        EstruturaProcesso atual = null; // cria um atual, para referenciar as execuções de processos

        if (contadorAlta == 5) { // se o contadorAlta for igual a 5, remove cabeça de lista media, executando o processo
        atual = listaMedia.removeCabeca();
        
        if (atual == null) { // se não houver lista media tentar de baixa
        atual = listaBaixa.removeCabeca();
        } 
    } 
        if (atual != null) { // faz a anti-inanição do scheduler
                System.out.println("Anti-inanição aplicada! Executando " + atual.getNome());
                contadorAlta = 0;
                executarProcesso(atual);
                return;
            }
        
    
        if(atual == null){

            // se lista de alta prioridade diferente de vazia, remova o processo e aumente o contador, vai ser repitido para todas as listas
            if(!listaAlta.listaVazia()){ 
                atual = listaAlta.removeCabeca();
                contadorAlta++;
            }else if(!listaMedia.listaVazia()){
                atual = listaMedia.removeCabeca();
                contadorAlta = 0;
            }else if(!listaBaixa.listaVazia()){
                atual = listaBaixa.removeCabeca();
                contadorAlta = 0;
            }
        }
        
        // se mesmo depois de passar pela execução, não foi encontrado nada, entra no guard rails
        if(atual == null){ 
            System.out.println("Não foi encontrado nenhum processo nesse ciclo!");
            return; // sai do metódo
        }

        if("DISCO".equalsIgnoreCase(atual.getRecurso_necessario()) && !atual.isJaUsouDisco()){ // ao chamar equalsIgnoreCase evitamos null pointer exception, no caso de atual for null, e ignora caixa alta ou baixa
            atual.setJaUsouDisco(true); //  Marca que "usou" na fila de bloqueados
           
            System.out.println("Processo:"+atual.getNome()+"precisa de DISCO, movendo para bloqueados");
            listaBloqueados.inserirNoFim(atual);
            return;
        }

        executarProcesso(atual);

    }

    // faz a execução dos processos, com a aparição de ciclo restantes no terminal e o processo terminou 
    private void executarProcesso (EstruturaProcesso  p){
        p.setCiclos_necessarios(p.getCiclos_necessarios() - 1); // Consome os ciclos necessarios
        System.out.println("Executando "+ p.getNome()  + "(ciclos restantes: " + p.getCiclos_necessarios()+ " )");
        
        if(p.getCiclos_necessarios() <= 0){ // processo terminou
            System.out.println("Processo: " + p.getNome()  + "terminou");
        } else{
            inserirProcesso(p);
        }
    }
    
    void mostrarFilas(){
        System.out.println("Fila alta: "+listaAlta.getSize()+" processos");
        System.out.println("Fila média: "+listaMedia.getSize()+" processos");
        System.out.println("Fila baixa: "+listaBaixa.getSize()+" processos");
        System.out.println("Fila bloqueados: "+listaBloqueados.getSize()+" processos");
    }
  
    //Verifica se tem processos ativos nas listas
    public boolean temProcessoAtivo(){
        return !listaAlta.listaVazia() || 
               !listaMedia.listaVazia() || 
               !listaBaixa.listaVazia() || 
               !listaBloqueados.listaVazia();
    }

}
