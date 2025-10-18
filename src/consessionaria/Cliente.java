package consessionaria;

public abstract class Cliente extends Pessoa{
    private int telefone;
    private String email;
    private int rg;
    private String cpf;
    
    public Cliente(int telefone, String email, int rg, String cpf){
        super();
        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
    }
    @Override
    public String getNome(){
        return nome;
    }
    @Override
    public void setNome(String nome){
        this.nome = nome;
    }
    

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
