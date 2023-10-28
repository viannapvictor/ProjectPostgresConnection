package br.com.victor;

import br.com.victor.cliente.ClienteTeste;
import br.com.victor.produto.ProdutoTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({ClienteTeste.class, ProdutoTest.class})
public class AllTests {
}
