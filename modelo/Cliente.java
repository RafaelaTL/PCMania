package modelo;

public class Cliente {

        private String nome;
        private String cpf;
        private Computador[] computadores;
        private int qtdComputadores;

        public Cliente(String nome, String cpf) {
            this.nome = nome;
            this.cpf = cpf;
            this.computadores = new Computador[10];
            this.qtdComputadores = 0;
        }

        public void addComputador(Computador pc) {
            if (qtdComputadores < computadores.length) {
                computadores[qtdComputadores] = pc;
                qtdComputadores++;
            }
        }

        public Computador[] getComputadores() {
            return computadores;
        }

        public int getQtdComputadores() {
            return qtdComputadores;
        }

        public String getNome() {
            return nome;
        }

        public String getCpf() {
            return cpf;
        }

        public float calculaTotalCompra() {
            float total = 0;
            for (int i = 0; i < qtdComputadores; i++) {
                total += computadores[i].getPreco();
            }
            return total;
        }

}
