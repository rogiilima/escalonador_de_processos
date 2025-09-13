public class Node {
    //Atributos
    private EstruturaProcesso element;
    private Node nextNode;
    
    //Construtor
    public Node(EstruturaProcesso element) {
        this.element = element;
        this.nextNode = null;
    }
    //Getters e Setters
    public EstruturaProcesso getElement() {
        return element;
    }
    public void setElement(EstruturaProcesso element) {
        this.element = element;
    }
    public Node getNextNode() {
        return nextNode;
    }
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
    
}

