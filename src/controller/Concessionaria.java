package controller;

import model.Venda;
import model.Veiculo;
import model.Funcionario;
import model.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

public class Concessionaria {

    private final ArrayList<Cliente> clientes;
    private final ArrayList<Funcionario> funcionarios;
    private final ArrayList<Veiculo> veiculos;
    private final ArrayList<Venda> vendas;
    
    public Concessionaria() {
        super();
        this.clientes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.veiculos = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }
    
    public void cadastrarCliente(String nome, String tel, String email, String rg, String cpf){
        clientes.add(new Cliente(nome, tel, email, rg, cpf));
        System.out.println("Cliente adicionado com sucesso\n");
    }
    
    public ArrayList<Cliente> consultarCliente(){
        return this.clientes;
    }
    
    public void alterarCliente(String nome, String tel, String email, String rg, String cpf, String cpfBusca){
        for (Cliente cliente : this.clientes) {
            if (cliente.getCpf().equals(cpfBusca)) {
                cliente.alterar(nome, tel, email, rg, cpf); // Usa o CPF para a busca do cliente, talvez mudar a logica disso.
                System.out.println("Cliente alterado com sucesso\n");
                return;
            }
        }
        System.out.println("\nErro: Cliente com CPF " + cpfBusca + " nao encontrado para alteracao.\n");
    }
    public void removerCliente(String cpfBusca) {
        for (int i = 0; i < this.clientes.size(); i++) {
            Cliente cliente = this.clientes.get(i);
            if (cliente.getCpf().equals(cpfBusca)) {
                this.clientes.remove(i);
                System.out.println("Cliente com CPF " + cpfBusca + " removido com sucesso.\n");
                return;
            }
            System.out.println("Erro: Cliente com CPF " + cpfBusca + " nao encontrado para remocao.\n");
        }
    }
    
    public void cadastrarFuncionario(String nome, String mat, String qual, String desc, String carga) {
        funcionarios.add(new Funcionario(nome, mat, qual, desc, carga));
        System.out.println("Funcionario adicionado com sucesso\n");
    }
    
    public ArrayList<Funcionario> consultarFuncionario() {
        return this.funcionarios;
    }
    
    public void alterarFuncionario(String nome, String mat, String qual, String desc, String carga, String matBusca) {
        for (Funcionario funcionario : this.funcionarios) {
            if (funcionario.getNum_matricula().equals(matBusca)) {
                funcionario.alterar(nome, mat, qual, desc, carga);
                System.out.println("Funcionario alterado com sucesso\n");
                return;
            }
        }
        System.out.println("\nErro: Numero de matricula do funcionario " + matBusca + " nao encontrado para alteracao.\n");
    }
    
    public void removerFuncionario(String matBusca) {
        for (int i = 0; i < this.funcionarios.size(); i++) {
            Funcionario funcionario = this.funcionarios.get(i);
            if (funcionario.getNum_matricula().equals(matBusca)) {
                this.funcionarios.remove(i);
                System.out.println("Funcionario com o numero de matricula " + matBusca + " removido com sucesso.\n");
                return;
            }
            System.out.println("Erro: Funcionario com o numero de matricula " + matBusca + " nao encontrado para remocao.\n");
        }
    }
    
    private Veiculo buscarVeiculoPorId(String idBusca) {
        for (Veiculo veiculo : this.veiculos) {
            if (veiculo.getId().equals(idBusca)) {
                return veiculo;
            }
        }
        return null;
    }
    
    public void cadastrarVeiculo(String nome, String cor, String numMarchas, String numPortas, String marca, String ano, String id) {
        if (buscarVeiculoPorId(id) != null) {
            System.out.println("Erro: Veiculo com o identificador " + id + " ja cadastrado.\n");
            return;
        }   
        else{
            veiculos.add(new Veiculo(nome, cor, numMarchas, numPortas, marca, ano, id));
            System.out.println("Veiculo adicionado com sucesso\n");
        }
    }
    
    public ArrayList<Veiculo> consultarVeiculo() {
        return this.veiculos;
    }
    
    public void alterarVeiculo(String nome, String cor, String numMarchas, String numPortas, String marca, String ano, String id) {
        Veiculo veiculo = buscarVeiculoPorId(id);
            if (veiculo != null) {
                veiculo.alterar(nome, cor, numMarchas, numPortas, marca, ano, id);
                System.out.println("Veiculo alterado com sucesso\n");
                return;
            }

            System.out.println("Erro: O identificador do veiculo: " + id + " nao encontrado para alteracao.\n");
    }
    
    public void removerVeiculo(String idBusca) {
        Veiculo veiculoParaRemover = buscarVeiculoPorId(idBusca);

        if (veiculoParaRemover != null) {
            this.veiculos.remove(veiculoParaRemover);
            System.out.println("Veiculo com o identificador " + idBusca + " removido com sucesso.\n");
            return;
        }
        System.out.println("Erro: Veiculo com o identificador " + idBusca + " nao encontrado para remocao.\n");
    }
    
    public void cadastrarVenda(String dat, String val, Cliente cli, Funcionario func, Veiculo vei) {
        vendas.add(new Venda(dat, val, cli, func, vei));
        System.out.println("Venda adicionado com sucesso\n");
    }
    
    public ArrayList<Venda> consultarVenda() {
        return this.vendas;
    }
    
    public void alterarVenda(int indiceVenda, String novaData, String novoValor, Cliente novoCli, Funcionario novoFunc, Veiculo novoVei) {
        if (indiceVenda >= 0 && indiceVenda < this.vendas.size()) {
            Venda vendaParaAlterar = this.vendas.get(indiceVenda);
            vendaParaAlterar.alterar(novaData, novoValor, novoCli, novoFunc, novoVei); 
            System.out.println("Venda alterada com sucesso\n");
        }
        else {
            System.out.println("Erro: Indice de venda: " + indiceVenda + " invalido para alteracao.\n");
        }
    }
    
    public void removerVenda(int indiceVenda) {
        if (indiceVenda >= 0 && indiceVenda < this.vendas.size()) {
            Venda vendaRemovida = this.vendas.remove(indiceVenda);
            System.out.println("Venda do dia " + vendaRemovida.getData() + " removida com sucesso.\n");
        } 
        else {
            System.out.println("Erro: Indice de venda: " + indiceVenda + " invalido para remocao.\n");
        }
    }
    
    public void clienteRelatorio() {
        for (int i = 0; i < clientes.size(); i++){
            clientes.get(i).consultar();
        }
    }
    
    public void funcionarioRelatorio() {
        for (int i = 0; i < funcionarios.size(); i++){
            funcionarios.get(i).consultar();
        }
    }
    
    public void veiculoRelatorio() {
        for (int i = 0; i < veiculos.size(); i++){
            vendas.get(i).consultar();
        }
    }
    
    public void vendaRelatorio() {
        for (int i = 0; i < vendas.size(); i++){
            vendas.get(i).consultar();
        }
    }
}
