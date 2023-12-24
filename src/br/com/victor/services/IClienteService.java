/**
 * 
 */
package br.com.victor.services;

import br.com.victor.domain.Cliente;
import br.com.victor.exceptions.DAOException;
import br.com.victor.services.generic.IGenericService;

/**
 * @author victor.vianna
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

}
