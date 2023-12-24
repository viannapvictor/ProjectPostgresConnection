/**
 * 
 */
package br.com.victor.services;

import br.com.victor.dao.IProdutoDAO;
import br.com.victor.domain.Produto;
import br.com.victor.services.generic.GenericService;

/**
 * @author victor.vianna
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
