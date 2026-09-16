import modelo.*;
import servico.ProcessarPedido;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float matricula = 146;

        // Promoção 1 - Apple
        SistemaOperacional soMac = new SistemaOperacional("macOS Sequoia", 64);
        Computador promo1 = new Computador("Apple", matricula, soMac);
        promo1.addHardwareBasico(new HardwareBasico("Processador Core i5", 2200));
        promo1.addHardwareBasico(new HardwareBasico("Memória RAM", 8));
        promo1.addHardwareBasico(new HardwareBasico("HD", 500));
        promo1.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));

        // Promoção 2 - Samsung
        SistemaOperacional soWin8 = new SistemaOperacional("Windows 8", 64);
        Computador promo2 = new Computador("Samsung", matricula + 1, soWin8);
        promo2.addHardwareBasico(new HardwareBasico("Processador Core i7", 3370));
        promo2.addHardwareBasico(new HardwareBasico("Memória RAM", 16));
        promo2.addHardwareBasico(new HardwareBasico("HD", 1000));
        promo2.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));

        // Promoção 3 - Dell
        SistemaOperacional soWin10 = new SistemaOperacional("Windows 10", 64);
        Computador promo3 = new Computador("Dell", matricula + 2, soWin10);
        promo3.addHardwareBasico(new HardwareBasico("Processador Core i7", 4500));
        promo3.addHardwareBasico(new HardwareBasico("Memória RAM", 32));
        promo3.addHardwareBasico(new HardwareBasico("HD", 2000));
        promo3.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));

        System.out.println("Digite seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite seu CPF:");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf);

        int codigo;
        do {
            System.out.println("\nDigite o código da promoção (1, 2 ou 3) ou 0 para finalizar:");
            codigo = Integer.parseInt(scanner.nextLine());

            switch (codigo) {
                case 1:
                    cliente.addComputador(promo1);
                    break;
                case 2:
                    cliente.addComputador(promo2);
                    break;
                case 3:
                    cliente.addComputador(promo3);
                    break;
                case 0:
                    System.out.println("Finalizando compra...");
                    break;
                default:
                    System.out.println("Código inválido!");
            }
        } while (codigo != 0);

        System.out.println("\n===== DADOS DO CLIENTE =====");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());

        System.out.println("\n===== PC's ADQUIRIDOS =====");
        Computador[] comprados = cliente.getComputadores();
        for (int i = 0; i < cliente.getQtdComputadores(); i++) {
            comprados[i].mostraPCConfigs();
            System.out.println("---------------------------");
        }

        System.out.println("\nTotal da compra: R$" + cliente.calculaTotalCompra());

        ProcessarPedido.processar(comprados);
    }
}