// classe que gerencia os processos
public class EstruturaProcesso {
    public int id;
    public String nome;
    public int prioridade; // 1 para alta, 2 para média e 3 para baixa
    public int ciclos_necessarios;
    public String recurso_necessario; // CPU, IO, etc
}
