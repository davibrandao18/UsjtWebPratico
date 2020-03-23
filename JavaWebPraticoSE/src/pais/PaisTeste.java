package pais;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTeste {
	Pais pais, paisCopia;
	static int id = 0;
	
@Before
public void inserindo() throws Exception  {
	System.out.println("Inserindo");
	pais = new Pais (id, "Jap�o", 126440000, 377975);
	paisCopia = new Pais (id, "Jap�o", 126440000, 377975);
	System.out.println(pais);
	System.out.println(paisCopia);
	System.out.println(id);
}

@Test
public void test00Carregar() {
	System.out.println("Carregar");
	Pais esperado = new Pais(1, "Jap�o", 126440000, 377975);
	Pais retorno = new Pais();
	retorno.carregarPaises();
	assertEquals("Testa Inclus�o", retorno, esperado);
}
	
}
