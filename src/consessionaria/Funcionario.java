package consessionaria;

public class Funcionario extends Pessoa{
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
