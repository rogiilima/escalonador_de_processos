public class ListaCircular {
    protected Node tail;
    protected long size = 0;

    //Verifica se a lista está vazia
    public boolean listaVazia(){
        if (tail != null) {
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
            tail = node; //Define a calda
            // Faz o nó apontar para ele mesmo
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
        
        node.setNextNode(tail.getNextNode());
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
            size--;
            return rtnNode;
        }else{
            //----Jogar exception ----
            System.out.println("A lista não é unitaria!");
            return null;
        }
    }
    public Node removeCabeca(){
       if (listaVazia()) {
            // -- Implementar exception
            System.out.println("A lista está vazia!");
            return null;
       }
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

        //Algoritmo ( existe outra maneira com dois nós, apenas percorrendo a lista!!!)

        Node auxNode = tail.getNextNode();//Nós auxiliares, começando pela "head"
        // Percorre até encontrar o penultimo nó
        while (auxNode.getNextNode() != tail);{ 
            auxNode = auxNode.getNextNode();
        }

        Node rtnNode = tail;
        //remove a cauda
        auxNode.setNextNode(tail.getNextNode());//continua a lista

        tail = auxNode;
        
        rtnNode.setNextNode(null);// Garantir que o GC apague ele depois
        size--;
        return rtnNode;// Retorna a cauda;

    }
}
