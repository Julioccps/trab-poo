package consessionaria;

public abstract class Veiculo implements Nomeavel{ // MUDAR PARA OUTRO NOME, SEM SER PESSOA
    private String nome;
    private String cor;
    private int num_marchas;
    private int num_portas;
    private String marca;
    private int ano;
    
    public void cadastrar(String nome, String cor, int num_marchas,
            int num_portas, String marca, int ano) {
        this.nome = nome;
        this.cor = cor;
        this.num_marchas = num_marchas;
        this.num_portas = num_portas;
        this.marca = marca;
        this.ano = ano;
    }
    
    public void consultar() {
        System.out.println("nome: " + nome + ", cor: " + cor + ", numero de marchas" + 
                num_marchas + ", numero de marchas: " + num_marchas + ", numero de portas: " +
                num_portas + ", marca: " + marca + ", ano" + ano);
    }
    public void alterar(String novo_nome, String nova_cor, int novo_num_marchas,
            int novo_num_portas, String nova_marca, int novo_ano) {
        nome = novo_nome;
        cor = nova_cor;
        num_marchas = novo_num_marchas;
        num_portas = novo_num_portas;
        marca = nova_marca;
        ano = novo_ano;
    }
    public void remover() {
        
    }
    
    @Override
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public Veiculo(int num_marchas, int num_portas, String marca, int ano){
        super();
        this.num_marchas = num_marchas;
        this.num_portas = num_portas;
        this.marca = marca;
        this.ano = ano;
    }
    
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getNum_marchas() {
        return num_marchas;
    }

    public void setNum_marchas(int num_marchas) {
        this.num_marchas = num_marchas;
    }

    public int getNum_portas() {
        return num_portas;
    }

    public void setNum_portas(int num_portas) {
        this.num_portas = num_portas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    
}
