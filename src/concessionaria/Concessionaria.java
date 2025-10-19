package concessionaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Concessionaria {
    public static void main(String[] args) {
        ArrayList<Cliente> clients = new ArrayList();
        ArrayList<Funcionario> funcionarios = new ArrayList();
        ArrayList<Veiculo> veiculos = new ArrayList();
        ArrayList<Venda> venda = new ArrayList();
        Scanner leitura = new Scanner(System.in);
        String func;
        String classe;
        System.out.println("Gerenciamento Concessionaria");
        System.out.println("Qual ação, você deseja fazer cadastrar, consultar, alterar ou remover?");
        System.out.println("Use (cad, cons, alt ou rmv) respectivamente para escolher o que fazer");
        func = leitura.nextLine();
        System.out.println("O que? Use (cliente, funcionario, veiculo ou venda)");
        classe = leitura.nextLine();
        switch(func){
            case "cad":
                if (classe == "cliente"){
                    clients.add();
                }
        }
    }
}
