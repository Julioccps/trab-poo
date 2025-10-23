package concessionaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Concessionaria {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList();
        ArrayList<Funcionario> funcionarios = new ArrayList();
        ArrayList<Veiculo> veiculos = new ArrayList();
        ArrayList<Venda> vendas = new ArrayList();
        Scanner leitura = new Scanner(System.in);
        int opt;
        opt = -1;
        while (opt != 0) {
            System.out.println("|-----Gerenciamento Concessionaria-----|");
            System.out.println("| 1 - Gerenciamento de Clientes:       |");
            System.out.println("| 2 - Gerenciamento de Funcionarios:   |");
            System.out.println("| 3 - Gerenciamento de Veiculos:       |");
            System.out.println("| 4 - Gerenciamento de Venda:          |");
            System.out.println("| 5 - Gerenciamento de Relatorio:      |");
            System.out.println("| 0 - Sair do Programa                 |");
            System.out.print("Escolha uma das opcoes: ");
            if (leitura.hasNextInt()) {
                opt = leitura.nextInt();
            } else {
                opt = -1; 
            }
            leitura.nextLine();
            
            switch(opt) {
                case 1: {
                    menuCliente(leitura, clientes);
                    break;
                }
                case 2: {
                    menuFuncionario(leitura, funcionarios);
                    break;
                }
                case 3: {
                    menuVeiculo(leitura, veiculos);
                    break;
                }
                case 4: {
                    menuVenda(leitura, vendas, clientes, funcionarios, veiculos);
                    break;
                }
                case 5: {
                    menuRelatorio(leitura, clientes, funcionarios, vendas, veiculos);
                    break;
                }
                case 0: {
                    System.out.println("Finalizando o programa!");
                    break;
                }
                default: {
                    System.out.println("Opcao invalida! Tente de novo!");
                }
            }
        }   
    }
    public static void menuCliente(Scanner leitura, ArrayList<Cliente> clientes) {
        int opt;
        opt = -1;
        while (opt != 0) {
            System.out.println("|----- Menu Clientes ------------|");
            System.out.println("|--- 1 Cadastrar cliente --------|");
            System.out.println("|--- 2 Consultar cliente --------|");
            System.out.println("|--- 3 Alterar cliente ----------|");
            System.out.println("|--- 4 Remover cliente ----------|");
            System.out.println("|--- 0 Voltar ao menu principal -|");
            opt = leitura.nextInt();
            leitura.nextLine(); 
            switch (opt) {
                case 1: {
                    System.out.print("Nome do cliente: ");
                    String nome = leitura.nextLine();
                    System.out.print("Telefone do cliente: ");
                    String tel = leitura.nextLine(); 
                    System.out.print("Email do cliente: ");
                    String email = leitura.nextLine();
                    System.out.print("RG do cliente: ");
                    int rg = leitura.nextInt();
                    leitura.nextLine(); 
                    System.out.print("CPF do cliente: ");
                    String cpf = leitura.nextLine();
                    clientes.add(new Cliente(nome, tel, email, rg, cpf));
                    System.out.println("Cliente adicionado com sucesso");
                    opt = -1; 
                    break; 
                }
                case 2: {
                    System.out.println("|---------- Clientes ------------|");
                    for (int i = 0; i < clientes.size(); i++){
                        System.out.println("  " + (i) + " - " + clientes.get(i).getNome());
                    }
                    System.out.println("Escolha qual cliente consultar (pelo indice):");
                    opt = leitura.nextInt();
                    leitura.nextLine(); 
                    clientes.get(opt).consultar();
                    opt = -1;
                    break; 
                }
                case 3: {
                    System.out.println("|---------- Clientes ------------|");
                    for (int i = 0; i < clientes.size(); i++){
                        System.out.println("  " + (i) + " - " + clientes.get(i).getNome());
                    }
                    System.out.println("Escolha qual cliente alterar (pelo indice):");
                    opt = leitura.nextInt();
                    leitura.nextLine(); 
                    
                    System.out.print("Novo nome do cliente: ");
                    String nome = leitura.nextLine();
                    System.out.print("Novo telefone do cliente: ");
                    String tel = leitura.nextLine(); 
                    System.out.print("Novo email do cliente: ");
                    String email = leitura.nextLine();
                    System.out.print("Novo RG do cliente: ");
                    int rg = leitura.nextInt();
                    leitura.nextLine(); 
                    System.out.print("Novo CPF do cliente: ");
                    String cpf = leitura.nextLine();
                    
                    clientes.get(opt).alterar(nome, tel, email, rg, cpf);
                    System.out.println("Cliente alterado com sucesso");
                    opt = -1; 
                    break; 
                }
                case 4: {
                    System.out.println("|---------- Clientes ------------|");
                    for (int i = 0; i < clientes.size(); i++){
                        System.out.println("  " + (i) + " - " + clientes.get(i).getNome());
                    }
                    System.out.println("Escolha qual cliente remover (pelo indice):");
                    opt = leitura.nextInt();
                    leitura.nextLine(); 
                    
                    Cliente removido = clientes.remove(opt);
                    System.out.println("Cliente " + removido.getNome() + " removido com sucesso.");
                    opt = -1; 
                    break; 
                }
                case 0: {
                    System.out.println("Voltando ao menu principal");
                    break; 
                }
                default: { 
                    System.out.println("Opção inválida!");
                    opt = -1;
                    break;
                }
            }
        }
    }
    
    public static void menuFuncionario(Scanner leitura, ArrayList<Funcionario> funcionarios) {
        int opt;
        opt = -1;
        while (opt != 0){
            System.out.println("|----- Menu Funcionarios ------------|");
            System.out.println("|--- 1 Cadastrar Funcionario --------|");
            System.out.println("|--- 2 Consultar Funcionario --------|");
            System.out.println("|--- 3 Alterar Funcionario ----------|");
            System.out.println("|--- 4 Remover Funcionario ----------|");
            System.out.println("|--- 0 Voltar ao menu principal -----|");
            opt = leitura.nextInt();
            leitura.nextLine(); 
            switch (opt) {
                case 1: {
                    System.out.print("Nome do funcionario: ");
                    String nome = leitura.nextLine();
                    System.out.print("Numero da matricula: ");
                    int mat = leitura.nextInt();
                    leitura.nextLine(); 
                    System.out.print("Qualificacao: ");
                    String qual = leitura.nextLine();
                    System.out.print("Descricao da qualificacao: ");
                    String desc = leitura.nextLine();
                    System.out.print("Carga horaria semanal: ");
                    float carga = leitura.nextFloat();
                    leitura.nextLine(); 
                    
                    funcionarios.add(new Funcionario(nome, mat, qual, desc, carga));
                    System.out.println("Funcionario adicionado com sucesso");
                    opt = -1;
                    break;
                }
                case 2: {
                    System.out.println("|---------- Funcionarios ------------|");
                    for (int i = 0; i < funcionarios.size(); i++){
                        System.out.println("  " + (i) + " - " + funcionarios.get(i).getNome());
                    }
                    System.out.println("Escolha qual funcionario consultar (pelo indice):");
                    opt = leitura.nextInt();
                    leitura.nextLine(); 
                    
                    funcionarios.get(opt).consultar();
                    opt = -1;
                    break;
                }
                case 3: {
                    System.out.println("|---------- Funcionarios ------------|");
                    for (int i = 0; i < funcionarios.size(); i++){
                        System.out.println("  " + (i) + " - " + funcionarios.get(i).getNome());
                    }
                    System.out.println("Escolha qual funcionario alterar (pelo indice):");
                    opt = leitura.nextInt();
                    leitura.nextLine(); 
                    
                    System.out.print("Novo nome do funcionario: ");
                    String nome = leitura.nextLine();
                    System.out.print("Novo numero da matricula: ");
                    int mat = leitura.nextInt();
                    leitura.nextLine(); 
                    System.out.print("Nova qualificacao: ");
                    String qual = leitura.nextLine();
                    System.out.print("Nova descricao da qualificacao: ");
                    String desc = leitura.nextLine();
                    System.out.print("Nova carga horaria semanal: ");
                    float carga = leitura.nextFloat();
                    leitura.nextLine(); 
                    
                    funcionarios.get(opt).alterar(nome, mat, qual, desc, carga);
                    System.out.println("Funcionario alterado com sucesso");
                    opt = -1;
                    break;
                }
                case 4: {
                    System.out.println("|---------- Funcionarios ------------|");
                    for (int i = 0; i < funcionarios.size(); i++){
                        System.out.println("  " + (i) + " - " + funcionarios.get(i).getNome());
                    }
                    System.out.println("Escolha qual funcionario remover (pelo indice):");
                    opt = leitura.nextInt();
                    leitura.nextLine(); 
                    
                    Funcionario removido = funcionarios.remove(opt);
                    System.out.println("Funcionario " + removido.getNome() + " removido com sucesso.");
                    opt = -1;
                    break;
                }
                case 0: {
                    System.out.println("Voltando ao menu principal");
                    break;
                }
                default: {
                    System.out.println("Opção inválida!");
                    opt = -1;
                    break;
                }
            }    
        }
    }
    
    public static void menuVeiculo(Scanner leitura, ArrayList<Veiculo> veiculos) {
        int opt;
        opt = -1;
        while (opt != 0){
            System.out.println("|----- Menu Veiculos ------------|");
            System.out.println("|--- 1 Cadastrar Veiculo --------|");
            System.out.println("|--- 2 Consultar Veiculo --------|");
            System.out.println("|--- 3 Alterar Veiculo ----------|");
            System.out.println("|--- 4 Remover Veiculo ----------|");
            System.out.println("|--- 0 Voltar ao menu principal -|");
            opt = leitura.nextInt();
            leitura.nextLine(); 
            switch (opt) {
                case 1: {
                    System.out.print("Nome do veiculo: ");
                    String nome = leitura.nextLine();
                    System.out.print("Cor do veiculo: ");
                    String cor = leitura.nextLine();
                    System.out.print("Numero de marchas do veiculo: ");
                    int num_marchas = leitura.nextInt();
                    leitura.nextLine();
                    System.out.print("Numero de portas do veiculo: ");
                    int num_portas = leitura.nextInt();
                    leitura.nextLine();
                    System.out.print("Marca do veiculo: ");
                    String marca = leitura.nextLine();
                    System.out.print("Ano do veiculo: ");
                    int ano = leitura.nextInt();
                    leitura.nextLine();
                    veiculos.add(new Veiculo(nome, cor, num_marchas, num_portas, marca, ano));
                    opt = -1;
                    break;
                }
                case 2: {
                    System.out.println("|---------- Veiculos ------------|");
                    for (int i = 0; i < veiculos.size(); i++){
                        System.out.println("  " + (i) + " - " + veiculos.get(i).getNome());
                    }
                    System.out.println("Escolha qual veiculo consultar (pelo indice):");
                    opt = leitura.nextInt();
                    leitura.nextLine();
                    
                    veiculos.get(opt).consultar();
                    opt = -1;
                    break;
                }
                case 3: {
                    System.out.println("|---------- Veiculos ------------|");
                    for (int i = 0; i < veiculos.size(); i++){
                        System.out.println("  " + (i) + " - " + veiculos.get(i).getNome());
                    }
                    System.out.println("Escolha qual veiculo alterar (pelo indice):");
                    opt = leitura.nextInt();
                    leitura.nextLine(); 
                    
                    System.out.print("Novo nome do veiculo: ");
                    String nome = leitura.nextLine();
                    System.out.print("Nova cor: ");
                    String cor = leitura.nextLine();
                    System.out.print("Novo numero de marchas: ");
                    int marchas = leitura.nextInt();
                    leitura.nextLine();
                    System.out.print("Novo numero de portas: ");
                    int portas = leitura.nextInt();
                    leitura.nextLine();
                    System.out.print("Nova marca: ");
                    String marca = leitura.nextLine();
                    System.out.print("Novo ano: ");
                    int ano = leitura.nextInt();
                    leitura.nextLine();
                    
                    veiculos.get(opt).alterar(nome, cor, marchas, portas, marca, ano);
                    System.out.println("Veiculo alterado com sucesso");
                    opt = -1;
                    break;
                }
                case 4: {
                    System.out.println("|---------- Veiculos ------------|");
                    for (int i = 0; i < veiculos.size(); i++){
                        System.out.println("  " + (i) + " - " + veiculos.get(i).getNome());
                    }
                    System.out.println("Escolha qual veiculo remover (pelo indice):");
                    opt = leitura.nextInt();
                    leitura.nextLine(); 
                    
                    Veiculo removido = veiculos.remove(opt);
                    System.out.println("Veiculo " + removido.getNome() + " removido com sucesso.");
                    opt = -1;
                    break;
                }
                case 0: {
                    System.out.println("Voltando ao menu principal");
                    break;
                }
                default: {
                    System.out.println("Opção inválida!");
                    opt = -1;
                    break;
                }
            }
        }
    }
    
    public static void menuVenda(Scanner leitura, ArrayList<Venda> vendas, 
            ArrayList<Cliente> clientes, ArrayList<Funcionario> funcionarios, ArrayList<Veiculo> veiculos) {
        
        int opt;
        opt = -1;
        while (opt != 0) {
            System.out.println("|----- Menu Vendas ------------|");
            System.out.println("|--- 1 Cadastrar Venda --------|");
            System.out.println("|--- 2 Consultar Venda --------|");
            System.out.println("|--- 3 Alterar Venda ----------|");
            System.out.println("|--- 4 Remover Venda ----------|");
            System.out.println("|--- 0 Voltar ao menu principal -|");
            opt = leitura.nextInt();
            leitura.nextLine(); 
            switch (opt) {
                case 1: {
                    System.out.print("Data da venda: ");
                    String data = leitura.nextLine();
                    System.out.print("Valor da venda: R$");
                    float valor = leitura.nextFloat();
                    leitura.nextLine(); 
                    
                    System.out.println("|---------- Clientes ------------|");
                    for (int i = 0; i < clientes.size(); i++){
                        System.out.println("  " + (i) + " - " + clientes.get(i).getNome());
                    }
                    System.out.println("Selecione o cliente (pelo indice):");
                    int clienteIndex = leitura.nextInt();
                    leitura.nextLine(); 
                    Cliente cliente = clientes.get(clienteIndex);
                    
                    System.out.println("|---------- Funcionarios ------------|");
                    for (int i = 0; i < funcionarios.size(); i++){
                        System.out.println("  " + (i) + " - " + funcionarios.get(i).getNome());
                    }
                    System.out.println("Selecione o funcionario (pelo indice):");
                    int funcIndex = leitura.nextInt();
                    leitura.nextLine(); 
                    Funcionario funcionario = funcionarios.get(funcIndex);
                    
                    System.out.println("|---------- Veiculos ------------|");
                    for (int i = 0; i < veiculos.size(); i++){
                        System.out.println("  " + (i) + " - " + veiculos.get(i).getNome());
                    }
                    System.out.println("Selecione o veiculo (pelo indice):");
                    int veicIndex = leitura.nextInt();
                    leitura.nextLine(); 
                    Veiculo veiculo = veiculos.get(veicIndex);
                    
                    Venda novaVenda = new Venda();
                    novaVenda.cadastrar(data, valor, cliente, funcionario, veiculo);
                    vendas.add(novaVenda);
                    
                    System.out.println("Venda cadastrada com sucesso!");
                    opt = -1;
                    break;
                }
                case 2: {
                    System.out.println("|---------- Vendas ------------|");
                    for (int i = 0; i < vendas.size(); i++){
                        System.out.println("  " + (i) + " - Data: " + vendas.get(i).getData() + 
                                ", Cliente: " + vendas.get(i).getCliente().getNome() + 
                                ", Veiculo: " + vendas.get(i).getVeiculo().getNome());
                    }
                    System.out.println("Escolha qual venda consultar (pelo indice):");
                    opt = leitura.nextInt();
                    leitura.nextLine();
                    
                    vendas.get(opt).consultar();
                    opt = -1;
                    break;
                }
                case 3: {
                    System.out.println("|---------- Vendas ------------|");
                    for (int i = 0; i < vendas.size(); i++){
                        System.out.println("  " + (i) + " - Data: " + vendas.get(i).getData() + 
                                ", Cliente: " + vendas.get(i).getCliente().getNome());
                    }
                    System.out.println("Escolha qual venda alterar (pelo indice):");
                    opt = leitura.nextInt();
                    leitura.nextLine();
                    
                    System.out.print("Nova data da venda: ");
                    String data = leitura.nextLine();
                    System.out.print("Novo valor da venda: R$");
                    float valor = leitura.nextFloat();
                    leitura.nextLine();
                    
                    System.out.println("|---------- Clientes ------------|");
                    for (int i = 0; i < clientes.size(); i++){
                        System.out.println("  " + (i) + " - " + clientes.get(i).getNome());
                    }
                    System.out.println("Selecione o novo cliente (pelo indice):");
                    int clienteIndex = leitura.nextInt();
                    leitura.nextLine();
                    Cliente cliente = clientes.get(clienteIndex);
                    
                    System.out.println("|---------- Funcionarios ------------|");
                    for (int i = 0; i < funcionarios.size(); i++){
                        System.out.println("  " + (i) + " - " + funcionarios.get(i).getNome());
                    }
                    System.out.println("Selecione o novo funcionario (pelo indice):");
                    int funcIndex = leitura.nextInt();
                    leitura.nextLine();
                    Funcionario funcionario = funcionarios.get(funcIndex);
                    
                    System.out.println("|---------- Veiculos ------------|");
                    for (int i = 0; i < veiculos.size(); i++){
                        System.out.println("  " + (i) + " - " + veiculos.get(i).getNome());
                    }
                    System.out.println("Selecione o novo veiculo (pelo indice):");
                    int veicIndex = leitura.nextInt();
                    leitura.nextLine();
                    Veiculo veiculo = veiculos.get(veicIndex);

                    
                    vendas.get(opt).alterar(data, valor, cliente, funcionario, veiculo);
                    System.out.println("Venda alterada com sucesso!");
                    opt = -1;
                    break;
                }
                case 4: {
                    System.out.println("|---------- Vendas ------------|");
                    for (int i = 0; i < vendas.size(); i++){
                        System.out.println("  " + (i) + " - Data: " + vendas.get(i).getData() + 
                                ", Cliente: " + vendas.get(i).getCliente().getNome());
                    }
                    System.out.println("Escolha qual venda remover (pelo indice):");
                    opt = leitura.nextInt();
                    leitura.nextLine();
                    
                    Venda removida = vendas.remove(opt);
                    System.out.println("Venda do dia " + removida.getData() + " removida com sucesso.");
                    opt = -1;
                    break;
                }
                case 0: {
                    System.out.println("Voltando ao menu principal");
                    break;
                }
                default: {
                    System.out.println("Opção inválida!");
                    opt = -1;
                    break;
                }
            }
        }
    }
    
    public static void menuRelatorio(Scanner leitura, ArrayList<Cliente> clientes, ArrayList<Funcionario> funcionarios,
        ArrayList<Venda> vendas, ArrayList<Veiculo> veiculos){
        int opt = leitura.nextInt();
        while (opt != 0){
            System.out.println("|------Menu Relatorios---------|");
            System.out.println("| 1 Relatorio de clientes -----|");
            System.out.println("| 2 Relatorio de funcionarios -|");
            System.out.println("| 3 Relatorio de veiculos -----|");
            System.out.println("| 4 Relatorio de vendas  ------|");
            System.out.println("| 0 voltar ao menu principal --|");

            leitura.nextLine();

            switch (opt){
                case 1:{
                    System.out.println("|---------- Clientes ------------|");
                    for (int i = 0; i < clientes.size(); i++){
                            clientes.get(i).consultar();
                    }
                    break;
                }
                case 2:{
                    System.out.println("|---------- Funcionarios ------------|");
                    for (int i = 0; i < funcionarios.size(); i++){
                            funcionarios.get(i).consultar();
                    }
                    break;
                }
                case 3:{
                    System.out.println("|---------- Veiculos ------------|");
                    for (int i = 0; i < funcionarios.size(); i++){
                            veiculos.get(i).consultar();
                    }
                    break;
                }
                case 4:{
                    System.out.println("|---------- Vendas ------------|");
                    for (int i = 0; i < funcionarios.size(); i++){
                            vendas.get(i).consultar();
                    }
                    break;
                }
                case 0:{
                    System.out.println("Voltando ao menu principal!");
                    break;
                }
                default: {
                    System.out.println("Opção inválida!");
                    opt = -1;
                    break;
                }
            }
        }
    }
}
