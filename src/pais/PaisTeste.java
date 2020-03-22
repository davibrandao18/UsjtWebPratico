package pais;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import testesunitarios.Cliente;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTeste {
	Pais pais, paisCopia;
	static int id = 0;
	
@Before
public void inserindo() throws Exception  {
	System.out.println("Inserindo");
	pais = new Pais (id, "Japão", 126440000, 377975);
	copia = new Pais (id, "Japão", 126440000, 377975);
	System.out.println(pais);
	System.out.println(copia);
	System.out.println(id);
}

@Test
public void test00Carregar() {
	System.out.println("Carregar");
	Pais esperado = new Pais(1, "Japão", 126440000, 377975);
	Pais retorno = new Pais(1, null, null, null);
	retorno.carregarPaises();
	assertEquals("Testa Inclusão", retorno, esperado);
}
	
}
