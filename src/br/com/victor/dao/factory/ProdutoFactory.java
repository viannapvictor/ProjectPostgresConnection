/**
 * 
 */
package br.com.victor.dao.factory;

import br.com.victor.domain.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author victor.vianna
 *
 */
public class ProdutoFactory {

	
	public static Produto convert(ResultSet rs) throws SQLException {
		Produto prod = new Produto();
		prod.setId(rs.getLong("ID_PRODUTO"));
		prod.setCodigo(rs.getString("CODIGO"));
		prod.setCor(rs.getString("COR"));
		prod.setNome(rs.getString("NOME"));
		prod.setDescricao(rs.getString("DESCRICAO"));
		prod.setValor(rs.getBigDecimal("VALOR"));
		return prod;
	}
}
