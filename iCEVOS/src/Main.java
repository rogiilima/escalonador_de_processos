public class Main {
    public static void main(String[] args) {
        
        Scheduler sh = new Scheduler();
        
        EstruturaProcesso[] processos = {
                    new EstruturaProcesso(1, "Processo_A", 1, 5, "CPU"),
                    new EstruturaProcesso(2, "Processo_B", 2, 3, "DISCO"),
                    new EstruturaProcesso(3, "Processo_C", 3, 8, "CPU"),
                    new EstruturaProcesso(4, "Processo_D", 1, 4, "DISCO"),
                    new EstruturaProcesso(5, "Processo_E", 2, 6, "CPU"),
                    new EstruturaProcesso(6, "Processo_F", 3, 7, "DISCO"),
                    new EstruturaProcesso(7, "Processo_G", 1, 2, "CPU"),
                    new EstruturaProcesso(8, "Processo_H", 2, 5, "DISCO"),
                    new EstruturaProcesso(9, "Processo_I", 3, 9, "CPU"),
                    new EstruturaProcesso(10, "Processo_J", 1, 3, "DISCO"),
                    new EstruturaProcesso(11, "Processo_K", 2, 4, "CPU"),
                    new EstruturaProcesso(12, "Processo_L", 3, 6, "DISCO"),
                    new EstruturaProcesso(13, "Processo_M", 1, 8, "CPU"),
                    new EstruturaProcesso(14, "Processo_N", 2, 7, "DISCO"),
                    new EstruturaProcesso(15, "Processo_O", 3, 10, "CPU")
    };

// Inserindo todos os processos em loop

            for (EstruturaProcesso p : processos) {
                sh.inserirProcesso(p);
            }

        
        while (sh.temProcessoAtivo()) {
            sh.executarCicloDeCPU();
            sh.mostrarFilas();
        }
        
        System.out.println("A execução terminou");
    }
}
