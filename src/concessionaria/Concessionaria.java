package concessionaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Concessionaria {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList();
        ArrayList<Funcionario> funcionarios = new ArrayList();
        ArrayList<Veiculo> veiculos = new ArrayList();
        ArrayList<Venda> venda = new ArrayList();
        Scanner leitura = new Scanner(System.in);
        int opt;
        opt = -1;
        while (opt != 0)
        System.out.println("|-----Gerenciamento Concessionaria-----|");
        System.out.println("| 1 - Gerenciamento de Clientes:       |");
        System.out.println("| 2 - Gerenciamento de Funcionarios:   |");
        System.out.println("| 3 - Gerenciamento de Veiculos:       |");
        System.out.println("| 4 - Gerenciamento de Venda:          |");
        System.out.println("| 5 - Gerenciamento de Relatorio:      |");
        System.out.println("| 0 - Sair do Programa                 |");
        leitura.nextLine();
        switch(opt) {
            case 1: {
                //Menu_Cliente();
            }
            case 2: {
                //Menu_Funcionario();
            }
            case 3: {
                //Menu_Veiculos();
            }
            case 4: {
                //Menu_Venda();
            }
            case 5: {
                //Menu_Relatorio();
            }
            case 0: {
                System.out.println("Finalizando o programa!");
            }
        }
    }
}