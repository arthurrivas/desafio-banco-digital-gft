package br.com.dio.gft.models;

import java.math.BigDecimal;


public abstract class Conta implements IConta{
	
	protected static Integer NUMERO_CONTAS = 0;
	
	
	

	protected Integer agencia;
	protected Integer numero;
	
	protected BigDecimal saldo;


	public Conta() {
	}
	
	

	public Conta(Integer agencia) {
		this.agencia = agencia;
		this.numero = ++NUMERO_CONTAS;
		this.saldo = new BigDecimal(200);
	}
	
	
	
	
	
	public Integer getAgencia() {
		return agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	
	
	
	
	
}
