package concessionaria.Model;

public class Cliente extends Pessoa{
    private String telefone;
    private String email;
    private int rg;
    private String cpf;
    
    public Cliente(String nome, String telefone, String email, int rg, String cpf){
        super(nome);
        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
    }
    public void cadastrar(String nome, String telefone, String email, int rg, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
    }

    @Override
    public void consultar() {
        System.out.println("Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email 
                + ", RG: " + rg + ", CPF: " + cpf);
    }
    public void alterar(String novo_nome, String novo_telefone, String novo_email,
            int novo_rg, String novo_cpf) {
        nome = novo_nome;
        telefone = novo_telefone;
        email = novo_email;
        rg = novo_rg;
        cpf = novo_cpf;
    }
    public void remover() {
        
    }
    @Override
    public String getNome(){
        return nome;
    }
    @Override
    public void setNome(String nome){
        this.nome = nome;
    }
    

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
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
