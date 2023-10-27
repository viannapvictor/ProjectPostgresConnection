package br.com.victor.cliente;

import br.com.victor.dao.generic.ClienteDAO;
import br.com.victor.dao.generic.IClienteDAO;
import br.com.victor.domain.Cliente;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

public class ClienteTeste {

    IClienteDAO dao = new ClienteDAO();
    @Test
    public void cadastrarExcluirsBuscarTest() throws Exception {

        dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Jonas");
        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = dao.excluir(clienteBD);
        assertNotNull(qtdDel);
    }

    @Test
    public void buscarTodosTest() throws Exception {

        dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Jonas");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("02");
        cliente2.setNome("Andre");

        Integer qtd2 = dao.cadastrar(cliente);
        assertTrue(qtd2 == 1);

        List<Cliente> clienteList = dao.buscarTodos();
        assertNotNull(clienteList);
        assertEquals(2, clienteList.size());

        int delQtd = 0;
        for (Cliente novoCliente : clienteList) {
            dao.excluir(novoCliente);
            delQtd++;
        }
        assertEquals(clienteList.size(), delQtd);

        clienteList = dao.buscarTodos();
        assertEquals(clienteList.size(),0);

    }

    @Test
    public void atualizarTest() throws Exception {

        dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Jonas");
        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar("01");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        clienteBD.setNome("Andre");
        clienteBD.setCodigo("02");
        Integer updateQtd = dao.atualizar(clienteBD);
        assertTrue(updateQtd == 1);

        Cliente clienteBD1 = dao.consultar("01");
        assertNull(clienteBD1);

        Cliente clienteBD2 = dao.consultar("02");
        assertNotNull(clienteBD2);
        assertEquals(clienteBD.getId(), clienteBD2.getId());
        assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
        assertEquals(clienteBD.getNome(), clienteBD2.getNome());

        List<Cliente> clienteList = dao.buscarTodos();
        for (Cliente cli : clienteList) {
            dao.excluir(cli);
        }

    }

}
