import java.util.*;
import java.util.stream.IntStream;

public class Filial {
    private String nome;
    private String endereco;
    private List<Funcionario> funcionarios;
    private List<Patrimonio> patrimonios;

    public Filial(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.funcionarios = new ArrayList<>();
        this.patrimonios = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public Optional<Funcionario> getFuncionario(String cpf) {
        return funcionarios.stream().filter(f -> Objects.equals(f.getCPF(), cpf)).findFirst();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        OptionalInt index = IntStream
                .range(0, funcionarios.size())
                .filter(i -> Objects.equals(funcionarios.get(i).getCPF(), funcionario.getCPF()))
                .findFirst();

        if (index.isEmpty())
            return;

        funcionarios.set(index.getAsInt(), funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) throws Exception {
        if (patrimonios
                .stream()
                .anyMatch(p -> Objects.equals(p.getFuncionarioResponsavelCPF(), funcionario.getCPF())))
            throw new Exception("Um funcionário com patrimônios não pode ser removido.");

        funcionarios.remove(funcionario);
    }

    public List<Patrimonio> getPatrimonios() {
        return patrimonios;
    }

    public Optional<Patrimonio> getPatrimonio(String descricao) {
        return patrimonios.stream().filter(p -> Objects.equals(p.getDescricao(), descricao)).findFirst();
    }

    public List<Patrimonio> getPatrimoniosByFuncionario(String cpf) {
        return patrimonios.stream().filter(p -> Objects.equals(p.getFuncionarioResponsavelCPF(), cpf)).toList();
    }

    public void adicionarPatrimonio(Patrimonio patrimonio) {
        patrimonios.add(patrimonio);
    }

    public void removerPatrimonio(Patrimonio patrimonio) {
        patrimonios.remove(patrimonio);
    }

    public void atualizaraPatrimonio(Patrimonio patrimonio) {
        OptionalInt index = IntStream
                .range(0, patrimonios.size())
                .filter(i -> Objects.equals(patrimonios.get(i).getDescricao(), patrimonio.getDescricao()))
                .findFirst();

        if (index.isEmpty())
            return;

        patrimonios.set(index.getAsInt(), patrimonio);
    }
}
