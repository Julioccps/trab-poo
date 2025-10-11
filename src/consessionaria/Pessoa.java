package consessionaria;

public class Pessoa { // MUDAR NOME
    protected String nome;
    
    public Pessoa(){
        super();
        
    }
    
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
    
    public void alterar(String novo_nome){
        nome = novo_nome;
    }
    
    public void remover(){
        nome = "";
    }
}
