/**
 * 
 */
package br.com.victor.dao;

import br.com.victor.dao.generic.IGenericDAO;
import br.com.victor.domain.Venda;
import br.com.victor.exceptions.DAOException;
import br.com.victor.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author victor.vianna
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
