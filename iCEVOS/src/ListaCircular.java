public class ListaCircular {
    private Node tail;

    public void percorrerLista(){
        if (tail == null) {
            // ---Jogar uma exception de lista vazia ---
            return;
        }
        Node auxNode = tail.getNextNode();
        do {
            //IMPLEMENTAR ALGUMA LÓGICA COMO: Pegar o nó atual ou imprimir no console
            auxNode = auxNode.getNextNode();
        } while (auxNode !=tail);
    }

}
