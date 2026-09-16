package modelo;

public class Computador {

        private String marca;
        private float preco;
        private HardwareBasico[] hardwares;
        private int qtdHardwares;
        private SistemaOperacional so;
        private MemoriaUSB memoriaUSB;

        public Computador(String marca, float preco, SistemaOperacional so) {
            this.marca = marca;
            this.preco = preco;
            this.so = so;
            this.hardwares = new HardwareBasico[10];
            this.qtdHardwares = 0;
        }

        public void addHardwareBasico(HardwareBasico hw) {
            if (qtdHardwares < hardwares.length) {
                hardwares[qtdHardwares] = hw;
                qtdHardwares++;
            }
        }

        public void addMemoriaUSB(MemoriaUSB musb) {
            this.memoriaUSB = musb;
        }

        public float getPreco() {
            return preco;
        }

        public void mostraPCConfigs() {
            System.out.println("Marca: " + marca);
            System.out.println("Preço: R$" + preco);
            for (int i = 0; i < qtdHardwares; i++) {
                System.out.println("- " + hardwares[i].getNome() + ": " + hardwares[i].getCapacidade());
            }
            System.out.println("Sistema Operacional: " + so.getNome() + " (" + so.getTipo() + " bits)");
            if (memoriaUSB != null) {
                System.out.println("Acompanha: " + memoriaUSB.getNome() + " de " + memoriaUSB.getCapacidade() + "Gb");
            }
        }

}
