package model;

public class Veiculo implements Nomeavel{ 
    private String nome;
    private String cor;
    private String num_marchas;
    private String num_portas;
    private String marca;
    private String ano;
    private String id;
    
    public Veiculo(String nome, String cor, String num_marchas, String num_portas, String marca, String ano, String id){
        this.nome = nome;
        this.cor = cor;
        this.num_marchas = num_marchas;
        this.num_portas = num_portas;
        this.marca = marca;
        this.ano = ano;
        this.id = id;
    }
    
    public void consultar() {
        System.out.println("nome: " + nome + ", cor: " + cor + ", numero de marchas" + 
                num_marchas + ", numero de marchas: " + num_marchas + ", numero de portas: " +
                num_portas + ", marca: " + marca + ", ano" + ano);
    }
    public void alterar(String novo_nome, String nova_cor, String novo_num_marchas,
            String novo_num_portas, String nova_marca, String novo_ano, String novo_id) {
        nome = novo_nome;
        cor = nova_cor;
        num_marchas = novo_num_marchas;
        num_portas = novo_num_portas;
        marca = nova_marca;
        ano = novo_ano;
        id = novo_id;
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
    
    public Veiculo(String num_marchas, String num_portas, String marca, String ano){
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

    public String getNum_marchas() {
        return num_marchas;
    }

    public void setNum_marchas(String num_marchas) {
        this.num_marchas = num_marchas;
    }

    public String getNum_portas() {
        return num_portas;
    }

    public void setNum_portas(String num_portas) {
        this.num_portas = num_portas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    } 
    
}
