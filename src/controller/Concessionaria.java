package controller;

import model.*;
import java.util.ArrayList;
import javax.persistence.*;

public class Concessionaria {
    private final ArrayList<Cliente> clientes;
    private final ArrayList<Funcionario> funcionarios;
    private final ArrayList<Veiculo> veiculos;
    private final ArrayList<Venda> vendas;
    private EntityManager em;

    public Concessionaria(EntityManager em) {
        super();
        this.em = em;
        this.clientes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.veiculos = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }
    
    public void cadastrarCliente(String nome, String tel, String email, String rg, String cpf){
        //clientes.add(new Cliente(nome, tel, email, rg, cpf));
        Cliente t = new Cliente(nome, tel, email, rg, cpf);
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        
        System.out.println("Cliente adicionado com sucesso\n");
    }
    
    public ArrayList<Cliente> consultarCliente(){
        return new ArrayList<>(em.createQuery("SELECT c FROM Cliente c ", Cliente.class).getResultList());
    }
    
    public void alterarCliente(String nome, String tel, String email, String rg, String cpf, String cpfBusca){
        try {
            em.getTransaction().begin();
        
            Cliente t =em.createQuery("SELECT c FROM Cliente c WHERE c.cpf = :n", Cliente.class)
                    .setParameter("n", cpfBusca)
                    .getSingleResult();
            t.alterar(nome, tel, email, rg, cpf);
            
            em.getTransaction().commit();
        } catch(Exception e){
            if (em.getTransaction().isActive()){
               em.getTransaction().rollback();
            }
            System.out.println("Cliente com CPF informado nao encontrado\n");
        }
    }
    public void removerCliente(String cpfBusca) {
         try {
            em.getTransaction().begin();
        
            Cliente t =em.createQuery("SELECT c FROM Cliente c WHERE c.cpf = :n", Cliente.class)
                    .setParameter("n", cpfBusca)
                    .getSingleResult();
            em.remove(t);
            
            em.getTransaction().commit();
        } catch(Exception e){
            if (em.getTransaction().isActive()){
               em.getTransaction().rollback();
            }
            System.out.println("Cliente com CPF informado nao encontrado\n");
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
    
    private Venda buscarVendaPorId(String idBusca) {
        for (Venda venda : this.vendas) {
            if (venda.getId().equals(idBusca)) {
                return venda;
            }
        }
        return null;
    }
    
    public void cadastrarVenda(String dat, String val, Cliente cli, Funcionario func, Veiculo vei, String id) {
        vendas.add(new Venda(dat, val, cli, func, vei, id));
        System.out.println("Venda adicionado com sucesso\n");
    }
    
    public ArrayList<Venda> consultarVenda() {
        return this.vendas;
    }
    
    public void alterarVenda(String dat, String val, Cliente cli, Funcionario func, Veiculo vei, String id) {
        Venda venda = buscarVendaPorId(id);
            if (venda != null) {
                venda.alterar(dat, val, cli, func, vei, id);
                System.out.println("Venda alterado com sucesso\n");
                return;
            }
            System.out.println("Erro: O identificador do venda: " + id + " nao encontrado para alteracao.\n");
    }
    
    public void removerVenda(String idBusca) {
        Venda vendaParaRemover = buscarVendaPorId(idBusca);

        if (vendaParaRemover != null) {
            this.vendas.remove(vendaParaRemover);
            System.out.println("Venda com o identificador " + idBusca + " removido com sucesso.\n");
            return;
        }
        System.out.println("Erro: Venda com o identificador " + idBusca + " nao encontrado para remocao.\n");
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
