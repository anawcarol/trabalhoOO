import java.util.*;
import java.util.stream.IntStream;

public class Empresa {
    String nome;
    List<Filial> filiais;

    public Empresa(String nome, Filial sede) {
        this.nome = nome;
        this.filiais = new ArrayList<>();
        filiais.add(sede);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Filial> getFiliais() {
        return filiais;
    }

    public Optional<Filial> getFilial(String nome) {
        return filiais
                .stream()
                .filter(f -> Objects.equals(f.getNome(), nome))
                .findFirst();
    }

    public void adicionarFilial(Filial filial) {
        filiais.add(filial);
    }

    public void removerFilial(Filial filial) throws Exception {
        if (filial.getPatrimonios().size() > 0)
            throw new Exception("Filial não pode ser excluída com patrimônios atribuídos à ela.");

        filiais.remove(filial);
    }

    public void atualizarFilial(Filial filial) {
        OptionalInt index = IntStream
                .range(0, filiais.size())
                .filter(i -> Objects.equals(filiais.get(i).getNome(), filial.getNome()))
                .findFirst();

        if (index.isEmpty())
            return;

        filiais.set(index.getAsInt(), filial);
    }

    public List<Patrimonio> getPatrimonios() {
        ArrayList<Patrimonio> patrimonios = new ArrayList<>();

        for (Filial filial : filiais) {
            patrimonios.addAll(filial.getPatrimonios());
        }

        return patrimonios;
    }
}
