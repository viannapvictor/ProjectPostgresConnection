package br.com.victor.produto;

import br.com.victor.dao.generic.IProdutoDAO;
import br.com.victor.dao.generic.ProdutoDAO;
import br.com.victor.domain.Produto;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class ProdutoTest {
    IProdutoDAO dao = new ProdutoDAO();
    @Test
    public void cadastrarExcluirsBuscarTest() throws Exception {

        dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Jonas");
        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer qtdDel = dao.excluir(produtoBD);
        assertNotNull(qtdDel);
    }

    @Test
    public void buscarTodosTest() throws Exception {

        dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Jonas");

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produto2 = new Produto();
        produto2.setCodigo("02");
        produto2.setNome("Andre");

        Integer qtd2 = dao.cadastrar(produto);
        assertTrue(qtd2 == 1);

        List<Produto> produtoList = dao.buscarTodos();
        assertNotNull(produtoList);
        assertEquals(2, produtoList.size());

        int delQtd = 0;
        for (Produto novoProduto : produtoList) {
            dao.excluir(novoProduto);
            delQtd++;
        }
        assertEquals(produtoList.size(), delQtd);

        produtoList = dao.buscarTodos();
        assertEquals(produtoList.size(),0);

    }

    @Test
    public void atualizarTest() throws Exception {

        dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Jonas");
        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar("01");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        produtoBD.setNome("Andre");
        produtoBD.setCodigo("02");
        Integer updateQtd = dao.atualizar(produtoBD);
        assertTrue(updateQtd == 1);

        Produto produtoBD1 = dao.consultar("01");
        assertNull(produtoBD1);

        Produto produtoBD2 = dao.consultar("02");
        assertNotNull(produtoBD2);
        assertEquals(produtoBD.getId(), produtoBD2.getId());
        assertEquals(produtoBD.getCodigo(), produtoBD2.getCodigo());
        assertEquals(produtoBD.getNome(), produtoBD2.getNome());

        List<Produto> produtoList = dao.buscarTodos();
        for (Produto cli : produtoList) {
            dao.excluir(cli);
        }

    }
}
