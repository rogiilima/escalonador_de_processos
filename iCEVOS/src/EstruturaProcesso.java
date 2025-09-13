// classe que gerencia os processos
public class EstruturaProcesso {
    private int id;
    private String nome;
    private int prioridade; // 1 para alta, 2 para média e 3 para baixa
    private int ciclos_necessarios;
    private String recurso_necessario; // CPU, IO, etc
    
    @Override // adicionando toString sobrescrevendo o metódo e retornando o id + nome + prioridade + ciclos necessários
    public String toString(){
        return "P ("+ id +", "+ nome +", "+ prioridade+ ", "+ ciclos_necessarios;
    }
    
    //Construtor
    public EstruturaProcesso(int id, String nome, int prioridade, int ciclos_necessarios, String recurso_necessario) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.ciclos_necessarios = ciclos_necessarios;
        this.recurso_necessario = recurso_necessario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getCiclos_necessarios() {
        return ciclos_necessarios;
    }

    public void setCiclos_necessarios(int ciclos_necessarios) {
        this.ciclos_necessarios = ciclos_necessarios;
    }

    public String getRecurso_necessario() {
        return recurso_necessario;
    }

    public void setRecurso_necessario(String recurso_necessario) {
        this.recurso_necessario = recurso_necessario;
    }    
    
}
