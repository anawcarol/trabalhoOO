public class PatrimonioTangivel extends Patrimonio {
    private double altura;
    private double largura;
    private double profundidade;

    protected PatrimonioTangivel(String descricao, double valor, Funcionario funcionarioResponsavel, double altura, double largura, double profundidade) {
        super(descricao, valor, funcionarioResponsavel);
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
    }
}
