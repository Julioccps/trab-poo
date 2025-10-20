package concessionaria;

public class Pessoa implements Nomeavel{ 
    protected String nome;
    
    public Pessoa(String nome){
        this.nome = nome;
        
    }
    @Override
    public String getNome(){
        return nome;
    }
    @Override
    public void setNome(String nome){
        this.nome = nome;
    }
    public void cadastrar(String nome){
        this.nome = nome;
    }
    
    public void consultar(){
        System.out.println("Nome: " + nome);
    }
}
