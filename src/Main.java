public class Main {
    public static void main(String[] args) {
        Filial filialPrincipal = new Filial("filial goiânia", "algum lugar");

        Funcionario bento = new Funcionario("bento", "diretor", "123123");
        filialPrincipal.adicionarFuncionario(bento);

        Funcionario carol = new Funcionario("carol", "diretora", "545");
        filialPrincipal.adicionarFuncionario(carol);

        PatrimonioTangivel casa = new PatrimonioTangivel("casa na praia", 5_000_000, carol, 15, 15, 15);

        filialPrincipal.adicionarPatrimonio(casa);

        PatrimonioIntangivel direitoAutoral = new PatrimonioIntangivel("livro da empresa", 100_000, bento, "direito_autoral_livro");

        filialPrincipal.adicionarPatrimonio(direitoAutoral);

        System.out.println(filialPrincipal.getFuncionarios().size());
        System.out.println(filialPrincipal.getFuncionarios().get(0).getCargo());
    }
}
