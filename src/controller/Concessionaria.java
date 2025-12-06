package controller;

import model.*;
import java.util.ArrayList;
import javax.persistence.*;

public class Concessionaria {
    private EntityManager em;

    public Concessionaria(EntityManager em) {
        super();
        this.em = em;
    }
    
    public void cadastrarCliente(String nome, String tel, String email, String rg, String cpf){
        // TODO: Tornar CPF unique e NOT NULL
        
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
        Funcionario t = new Funcionario(nome, mat, qual, desc, carga);
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        
        System.out.println("Funcionario adicionado com sucesso\n");
    }
    
    public ArrayList<Funcionario> consultarFuncionario() {
        return new ArrayList<>(em.createQuery("SELECT f FROM Funcionario f ", Funcionario.class).getResultList());
    }
    
    public void alterarFuncionario(String nome, String mat, String qual, String desc, String carga, String matBusca) {
        try {
            em.getTransaction().begin();
        
            Funcionario t = em.createQuery("SELECT f FROM Funcionario f WHERE f.num_matricula = :n", Funcionario.class)
                    .setParameter("n", matBusca)
                    .getSingleResult();
            t.alterar(nome, mat, qual, desc, carga);
            
            em.getTransaction().commit();
        } catch(Exception e){
            if (em.getTransaction().isActive()){
               em.getTransaction().rollback();
            }
            System.out.println("Funcionario com numero de matricula informado nao encontrado\n");
        }
    }
    
    public void removerFuncionario(String matBusca) {
        try {
            em.getTransaction().begin();
        
            Funcionario t = em.createQuery("SELECT f FROM Funcionario f WHERE f.num_matricula = :n", Funcionario.class)
                    .setParameter("n", matBusca)
                    .getSingleResult();
            em.remove(t);
            
            em.getTransaction().commit();
        } catch(Exception e){
            if (em.getTransaction().isActive()){
               em.getTransaction().rollback();
            }
            System.out.println("Funcionario com numero de matricula informado nao encontrado\n");
        }
    }
    
    public void cadastrarVeiculo(String nome, String cor, String numMarchas, String numPortas, String marca, String ano, String id) {
        Veiculo t = new Veiculo(nome, cor, numMarchas, numPortas, marca, ano, id);
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        
        System.out.println("Veiculo adicionado com sucesso\n");
    }
    
    public ArrayList<Veiculo> consultarVeiculo() {
        return new ArrayList<>(em.createQuery("SELECT v FROM Veiculo v ", Veiculo.class).getResultList());
    }
    
    public void alterarVeiculo(String nome, String cor, String numMarchas, String numPortas, String marca, String ano, String id) {
        try {
            em.getTransaction().begin();
        
            Veiculo t = em.createQuery("SELECT v FROM Veiculo v WHERE v.id = :n", Veiculo.class)
                    .setParameter("n", id)
                    .getSingleResult();
            t.alterar(nome, cor, numMarchas, numPortas, marca, ano, id);
            
            em.getTransaction().commit();
        } catch(Exception e){
            if (em.getTransaction().isActive()){
               em.getTransaction().rollback();
            }
            System.out.println("Veiculo com identificador informado nao encontrado\n");
        }
    }
    
    public void removerVeiculo(String idBusca) {
        try {
            em.getTransaction().begin();
        
            Veiculo t = em.createQuery("SELECT v FROM Veiculo v WHERE v.id = :n", Veiculo.class)
                    .setParameter("n", idBusca)
                    .getSingleResult();
            em.remove(t);
            
            em.getTransaction().commit();
        } catch(Exception e){
            if (em.getTransaction().isActive()){
               em.getTransaction().rollback();
            }
            System.out.println("Veiculo com identificador informado nao encontrado\n");
        }
    }
    
    public void cadastrarVenda(String dat, String val, Cliente cli, Funcionario func, Veiculo vei, String id) {
        Venda t = new Venda(dat, val, cli, func, vei, id);
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        
        System.out.println("Venda adicionado com sucesso\n");
    }
    
    public ArrayList<Venda> consultarVenda() {
        return new ArrayList<>(em.createQuery("SELECT v FROM Venda v ", Venda.class).getResultList());
    }
    
    public void alterarVenda(String dat, String val, Cliente cli, Funcionario func, Veiculo vei, String id) {
        try {
            em.getTransaction().begin();
        
            Venda t = em.createQuery("SELECT v FROM Venda v WHERE v.id = :n", Venda.class)
                    .setParameter("n", id)
                    .getSingleResult();
            t.alterar(dat, val, cli, func, vei, id);
            
            em.getTransaction().commit();
        } catch(Exception e){
            if (em.getTransaction().isActive()){
               em.getTransaction().rollback();
            }
            System.out.println("Venda com identificador informado nao encontrado\n");
        }
    }
    
    public void removerVenda(String idBusca) {
        try {
            em.getTransaction().begin();
        
            Venda t = em.createQuery("SELECT v FROM Venda v WHERE v.id = :n", Venda.class)
                    .setParameter("n", idBusca)
                    .getSingleResult();
            em.remove(t);
            
            em.getTransaction().commit();
        } catch(Exception e){
            if (em.getTransaction().isActive()){
               em.getTransaction().rollback();
            }
            System.out.println("Venda com identificador informado nao encontrado\n");
        }
    }
    
    public void clienteRelatorio() {
        ArrayList<Cliente> clientes = consultarCliente();
        for (Cliente cliente : clientes){
            cliente.consultar();
        }
    }
    
    public void funcionarioRelatorio() {
        ArrayList<Funcionario> funcionarios = consultarFuncionario();
        for (Funcionario funcionario : funcionarios){
            funcionario.consultar();
        }
    }
    
    public void veiculoRelatorio() {
        ArrayList<Veiculo> veiculos = consultarVeiculo();
        for (Veiculo veiculo : veiculos){
            veiculo.consultar();
        }
    }
    
    public void vendaRelatorio() {
        ArrayList<Venda> vendas = consultarVenda();
        for (Venda venda : vendas){
            venda.consultar();
        }
    }
}
