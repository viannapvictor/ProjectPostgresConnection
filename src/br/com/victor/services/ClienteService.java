/**
 * 
 */
package br.com.victor.services;

import br.com.victor.dao.IClienteDAO;
import br.com.victor.domain.Cliente;
import br.com.victor.exceptions.DAOException;
import br.com.victor.exceptions.MaisDeUmRegistroException;
import br.com.victor.exceptions.TableException;
import br.com.victor.services.generic.GenericService;

/**
 * @author victor.vianna
 *
 */
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
