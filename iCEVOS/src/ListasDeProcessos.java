// listas encadeada simples feita para gerenciar os processos manualmente, sem uso de estruturas de dados pré-definidas
public class ListasDeProcessos {
    private Node head;
    private Node tail;
    private int size = 0;

    public boolean listaVazia(){
        return head == null;
    }

    public int getSize(){
        return this.size;
    }

    private void inserirListaVazia(Node node){
        head = node;
        tail = node;
        size++;
    }

    //Algoritmo O(1) para facilitar a inserção de muitos processos
    public void inserirNoFim(EstruturaProcesso processo){
        Node node = new Node(processo);
        if (listaVazia()) {
            inserirListaVazia(node);
            return;
        }
        tail.setNextNode(node);
        tail = node;
        size++;
    }

    // Mostra só o primeiro nó sem remove-lo, mesmo que seja null
    public EstruturaProcesso obterPrimeiro(){
        if (listaVazia()) {
            return null;
        }

        return this.head.getElement();
    }

    // Remove e devolve o primero processo da lista
    public EstruturaProcesso removeCabeca(){
        if (listaVazia()) { // if guardRail
            return null;
        }

        EstruturaProcesso nodeElement = head.getElement(); // Cria para retornar o elemento do nó que será removido

        head = head.getNextNode();
        
        if (listaVazia()) { //Se a cabeca estiver vazia ele vai deixar o tail null (lista Unitaria)
            tail = null;
        } 
        size--;
        return nodeElement;
    }
}
