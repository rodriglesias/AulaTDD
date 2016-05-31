package testes;

import java.util.List;

public class Util {

	public static void processadorBoletos(List<Boleto> boletos, Fatura fatura) {
		double soma = 0;
		for(Boleto b:boletos){
			soma+=b.getValor();
		}
		if(soma>=fatura.getValor()){
			fatura.setSituacao("PAGA");
		}
	}

}
