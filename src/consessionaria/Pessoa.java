package consessionaria;

public abstract class Pessoa implements Nomeavel{ // MUDAR NOME
    protected String nome;
    
    public Pessoa(){
        super();
        
    }
    @Override
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void cadastrar(String nome){
        this.nome = nome;
    }
    
    public void consultar(){
        System.out.println("Nome: " + nome);
    }
    
    public void alterar(String novo_nome){ // REFATORAR
        nome = novo_nome;
    }
    
    public void remover(){ // REFATORAR
        nome = "";
    }
}
