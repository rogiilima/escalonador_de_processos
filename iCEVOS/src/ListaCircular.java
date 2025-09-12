public class ListaCircular {
    protected Node tail;
    protected long size = 0;

    //Verifica se a lista está vazia
    public boolean listaVazia(){
        if (tail == null) {
            return false;
        }
        return true; 
    }

    public void percorrerLista(){
        if (listaVazia()) {
            // ---Jogar uma exception de lista vazia ---
            System.out.println("A lista está vazia!");
            return;
        }
        Node auxNode = tail.getNextNode();
        do {
            //IMPLEMENTAR ALGUMA LÓGICA COMO: Pegar o nó atual ou imprimir no console
            auxNode = auxNode.getNextNode();
        } while (auxNode !=tail);
    }

    public void inserirListaVazia(Object objeto){
        Node node = new Node(objeto);
        if (listaVazia()) { //Se a lista estiver vazia
            node.setNextNode(node);// Faz o nó apontar para ele mesmo
            tail.setNextNode(node); // Define a cauda como sendo o nó
            size++;
        }
    }
    public void inserirNoFim(Object objeto){
        //IF guard rail
        if (listaVazia()) {
            inserirListaVazia(objeto);
            return;
        }
        // Logica para inserir no fim(cauda)
        Node node = new Node(objeto);
        
        node.setNextNode(tail);
        tail.setNextNode(node);
        tail = node;
        size++;
    }

    public Node removeListaUnica(){
        //Jogar exception caso a lista estiver vazia
        if (listaVazia()) {
            // -- Implementar exception
            System.out.println("A lista está vazia!");
            return null;
        }
        if (tail.getNextNode() == tail) {
            Node rtnNode = tail;
            tail = null;
            return rtnNode;
        }else{
            //----Jogar exception ----
            System.out.println("A lista não está vazia!");
            return null;
        }
    }
    public Node removeCabeca(){
        if (size == 1) {
            return removeListaUnica();
        }
        Node rtnNode = tail.getNextNode(); // Pega o no para retornar na funcao
        
        tail.setNextNode(tail.getNextNode().getNextNode()); // tira a referencia da cabeca na tail
        size--;
        return rtnNode;
    }

    public Node removeCauda(){
        if (listaVazia()) {
            // -- Implementar exception
            System.out.println("A lista está vazia!");
            return null;
        }
        if (size == 1) {
            return removeListaUnica();
        }

        //Algoritmo ( existe outra maneira sem ser com dois nós, apenas percorrendo a lista!!!)
        //Nós auxiliares
        Node auxNode1 = tail;
        Node auxNode2 = tail.getNextNode();
        do { // Percorre os nós
            auxNode1 = auxNode1.getNextNode();
            auxNode2 = auxNode2.getNextNode();
        } while (auxNode1 != tail);

        //remove a cauda
        auxNode2 = auxNode1.getNextNode();
        tail = auxNode2;

        return auxNode1;// Retorna a cauda;

    }
}
