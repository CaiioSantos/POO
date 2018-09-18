import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int opcao;
        Scanner input = new Scanner(System.in);
        RepositorioCliente repositorioCliente = RepositorioCliente.getInstancia();

        do {
            System.out.println("1. adicionar cliente \n2.Buscar cliente \n0. Sair");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    Cliente novo = new Cliente();
                    System.out.println("Digite o nome");
                    novo.setNome(input.next());
                    System.out.println("Insira o codigo");
                    novo.setId(input.nextInt());
                    repositorioCliente.adicionarCliente(novo);
                    break;
                case 2:
                    System.out.println("Insira o codigo para pesquisa");
                    int codigo = input.nextInt();
                    Cliente pesquisado = repositorioCliente.pesquisarClienteCodigo(codigo);
                    System.out.println(pesquisado.getNome());
                    break;
                case 0:
                    break;
                default:
                    break;
            }


        } while (opcao != 0);

    }
}
