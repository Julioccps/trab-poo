package concessionaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Inter {
    public Inter(){
        super();
    }
    public void menuCliente(Scanner leitura, ArrayList<Cliente> clientes){
        int opt;
        opt = -1;
        while (opt != 0){
            System.out.println("|----- Menu Clientes ------------|");
            System.out.println("|--- 1 Cadastrar cliente --------|");
            System.out.println("|--- 2 Consultar cliente --------|");
            System.out.println("|--- 3 Alterar cliente ----------|");
            System.out.println("|--- 4 Remover cliente ----------|");
            System.out.println("|--- 0 Voltar ao menu principal -|");
            opt = leitura.nextInt();
            leitura.nextLine();
            switch (opt){
                case 1:{
                    System.out.print("Nome do cliente: ");
                    String nome = leitura.nextLine();
                    System.out.print("Telefone do cliente: ");
                    int tel = leitura.nextInt();
                    leitura.nextLine();
                    System.out.print("Email do cliente: ");
                    String email = leitura.nextLine();
                    System.out.print("EG do cliente: ");
                    int rg = leitura.nextInt();
                    leitura.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpf = leitura.nextLine();
                    clientes.add(new Cliente(nome, tel, email, rg, cpf));
                    System.out.println("Cliente adicionado com sucesso");
                    opt = -1;
                }
                case 2:{
                    System.out.println("|---------- Clientes ------------|");
                    for (int i = 0; i < clientes.size(); i++){
                        System.out.println("  " + (i) + clientes.get(i).getNome());
                    }
                    opt = leitura.nextInt();
                    leitura.nextLine();
                    clientes.get(opt).consultar();
                    opt = -1;
                }
                case 3:{
                    
                }
            }
            
        }
    }
}
