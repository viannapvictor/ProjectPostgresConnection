package br.com.victor.dao.generic;

import br.com.victor.domain.Cliente;

public interface IClienteDAO {
    public Integer cadastrar(Cliente cliente) throws Exception;

    public Cliente consultar(String codigo) throws Exception;

    public Integer excluir(Cliente clienteBD) throws Exception;
}
