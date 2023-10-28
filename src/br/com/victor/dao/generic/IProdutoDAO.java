package br.com.victor.dao.generic;
import br.com.victor.domain.Produto;
import java.util.List;

public interface IProdutoDAO {
    Integer cadastrar(Produto produto) throws Exception;

    public Produto consultar(String codigo) throws Exception;

    Integer excluir(Produto produtoBD) throws Exception;

    public List<Produto> buscarTodos() throws Exception;

    public Integer atualizar(Produto produto) throws Exception;
}
