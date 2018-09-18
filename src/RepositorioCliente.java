import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {
    private List<Cliente> repositorioCliente = new ArrayList<>();
    private static RepositorioCliente instancia;

    private RepositorioCliente() {
    }

    public static RepositorioCliente getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioCliente();
        }
        return instancia;
    }

    public boolean adicionarCliente(Cliente cliente) {
        if (cliente != null) {
            for (int i = 0; i < repositorioCliente.size(); i++) {
                if (cliente.getCpf().equals(repositorioCliente.get(i).getCpf()) && cliente.getId() == repositorioCliente.get(i).getId()) {
                    return false;
                }
            }
            repositorioCliente.add(cliente);
            return true;
        }
        return false;
    }

    public boolean removerClienteCodigo(int codigo) {
        for (int i = 0; i < repositorioCliente.size(); i++) {
            if (codigo == repositorioCliente.get(i).getId()) {
                repositorioCliente.remove(i);
                return true;
            }
        }
        return false;
    }

    public int removerClienteNome(String nome) {
        int cont = 0;
        for (int i = 0; i < repositorioCliente.size(); i++) {
            if (nome.equals(repositorioCliente.get(i).getNome())) {
                repositorioCliente.remove(i);
                cont++;
            }
        }
        return cont;
    }

    public Cliente pesquisarClienteCodigo(int codigo) {
        for (int i = 0; i < repositorioCliente.size(); i++) {
            if (codigo == repositorioCliente.get(i).getId()) {
                return repositorioCliente.get(i);

            }
        }
        return null;
    }

    public ArrayList pesquisarClienteBairro(String bairro) {

        ArrayList<Cliente> retorno = null;
        for (int i = 0; i < repositorioCliente.size(); i++) {
            if (bairro.equals(repositorioCliente.get(i).getEndereco().getBairro())) {
                if (retorno == null) {
                    retorno = new ArrayList<>();
                }
                retorno.add(repositorioCliente.get(i));
            }
        }
        return retorno;
    }


}
