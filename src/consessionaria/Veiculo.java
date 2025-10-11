package consessionaria;

public class Veiculo extends Pessoa{ // MUDAR PARA OUTRO NOME, SEM SER PESSOA
    private String cor;
    private int num_marchas;
    private int num_portas;
    private String marca;
    private int ano;

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
