package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;




public class testesboletos2 {

	@Test
	public void test() {

		List <Boleto> boletos = new ArrayList <Boleto> ();
		Boleto b1 = new Boleto ();
		Boleto b2 = new Boleto ();
		Boleto b3 = new Boleto ();
		b1.setValor (1000);
		b2.setValor (500);
		b3.setValor (250);
		boletos.add(b1);
		boletos.add(b2);
		boletos.add(b3);
		Fatura  fatura = new Fatura ();
		fatura.setValor(1500.0);
		
		Util.processadorBoletos (boletos, fatura);
		Assert.assertEquals(fatura.getSituacao(), "PAGA"); 

		Pagamento pag1;
		PagamentoDAO pagDAO = new PagamentoDAO();
		pag1 = pagDAO.pesquisarPagamento(b1);
		assertNotNull(pag1);
		
		Pagamento pag2;
		pag2 = pagDAO.pesquisarPagamento(b2);
		assertNotNull(pag2);
		
		Pagamento pag3;
		pag3 = pagDAO.pesquisarPagamento(b3);
		assertNotNull(pag3);
		
		Credito credito;
		CreditoDAO credDAO  = new CreditoDAO();
		credito = credDAO.pesquisarCredito(fatura.getNomeCliente(),250.0);
		assertNotNull(credito);
	}

}
