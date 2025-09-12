public class Node {
    //Atributos
    private Object element;
    private Node nextNode;
    
    //Construtor
    public Node(Processo element) {
        this.element = element;
        this.nextNode = null;
    }
    //Getters e Setters
    public Processo getElement() {
        return element;
    }
    public void setElement(Processo element) {
        this.element = element;
    }
    public Node getNextNode() {
        return nextNode;
    }
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
    
}

