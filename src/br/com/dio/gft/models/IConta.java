package br.com.dio.gft.models;

import java.math.BigDecimal;

public interface IConta {
	
	boolean sacar(BigDecimal valorSaque);
	
	void depositar(BigDecimal valorDeposito);

	void transferir(BigDecimal valorTransferencia, Conta contaDestino);
}
