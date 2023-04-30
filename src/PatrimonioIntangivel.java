public class PatrimonioIntangivel extends Patrimonio {
    private String tipo;

    protected PatrimonioIntangivel(String descricao, double valor, Funcionario funcionarioResponsavel, String tipo) {
        super(descricao, valor, funcionarioResponsavel);
        this.tipo = tipo;
    }
}
