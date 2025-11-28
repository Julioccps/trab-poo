package model;

public class Venda {
    private String data;
    private float valor;
    private Cliente cliente;
    private Funcionario funcionario;
    private Veiculo veiculo;
    
    public Venda(){
        super();
    }
    
    public void cadastrar(String data, float valor, Cliente cliente, Funcionario funcionario, Veiculo veiculo){
        this.data = data;
        this.valor = valor;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.veiculo = veiculo;
    }
    public void consultar(){
        System.out.println("Data:" + data + ", Valor: " + valor + ", Cliente" + cliente.getNome() +
                ", Funcionario: " + funcionario.getNome() + ", Veiculo: " + veiculo.getNome());        
    }
    
    public void alterar(String nova_data, float novo_valor, 
            Cliente novo_cliente, Funcionario novo_funcionario, Veiculo novo_veiculo){ // REFATORAR
        data = nova_data;
        valor = novo_valor;
        cliente = novo_cliente;
        funcionario = novo_funcionario;
        veiculo = novo_veiculo;
    }
    
    public void remover(){ // REFATORAR
        data = "";
        valor = -1.0f;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    
}
