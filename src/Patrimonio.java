public abstract class Patrimonio {
    private String descricao;
    private double valor;
    private String funcionarioResponsavelCPF;

    protected Patrimonio(String descricao, double valor, Funcionario funcionarioResponsavel) {
        this.descricao = descricao;
        this.valor = valor;
        this.funcionarioResponsavelCPF = funcionarioResponsavel.getCPF();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFuncionarioResponsavelCPF() {
        return funcionarioResponsavelCPF;
    }

    public void setFuncionarioResponsavelCPF(String funcionarioResponsavelCPF) {
        this.funcionarioResponsavelCPF = funcionarioResponsavelCPF;
    }
}
