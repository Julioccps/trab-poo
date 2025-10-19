package consessionaria;

public abstract class Funcionario extends Pessoa{
    private int num_matricula;
    private String qualificacao;
    private String descricao_qualificacao;
    private float carga_horaria_semanal;
    
    public Funcionario(int num_matricula, String qualificacao,
            String descricao_qualificacao, float carga_horaria_semanal){
        super();
        this.num_matricula = num_matricula;
        this.qualificacao = qualificacao;
        this.descricao_qualificacao = descricao_qualificacao;
        this.carga_horaria_semanal = carga_horaria_semanal;  
    }
    public void cadastrar(String nome, int num_matricula, String qualificacao,
            String descricao_qualicacao, float carga_horaria_semanal) {
        this.nome = nome;
        this.num_matricula = num_matricula;
        this.qualificacao = qualificacao;
        this.descricao_qualificacao = descricao_qualicacao;
        this.carga_horaria_semanal = carga_horaria_semanal;
    }
    public void consultar() {
        System.out.println("Nome: " + nome + ", numero da matricula: " + 
                num_matricula + ", qualificacao: " + qualificacao + 
                ", descricao da qualificacao: " + descricao_qualificacao +
                ", carga horaria: " + carga_horaria_semanal);
    }
    public void alterar(String novo_nome, int novo_num_matricula,
            String nova_qualificacao, String nova_descricao_qualificacao,
            float nova_carga_horaria_semanal) {
        this.nome = novo_nome;
        this.num_matricula = novo_num_matricula;
        this.qualificacao = nova_qualificacao;
        this.descricao_qualificacao = nova_descricao_qualificacao;
        this.carga_horaria_semanal = nova_carga_horaria_semanal;
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
    public int getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(int num_matricula) {
        this.num_matricula = num_matricula;
    }

    public String getQualificacao() {
        return qualificacao;
    }

    public void setQualificacao(String qualificacao) {
        this.qualificacao = qualificacao;
    }

    public String getDescricao_qualificacao() {
        return descricao_qualificacao;
    }

    public void setDescricao_qualificacao(String descricao_qualificacao) {
        this.descricao_qualificacao = descricao_qualificacao;
    }

    public float getCarga_horaria_semanal() {
        return carga_horaria_semanal;
    }

    public void setCarga_horaria_semanal(float carga_horaria_semanal) {
        this.carga_horaria_semanal = carga_horaria_semanal;
    }
}
