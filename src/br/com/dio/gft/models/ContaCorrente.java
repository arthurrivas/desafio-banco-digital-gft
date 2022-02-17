package br.com.dio.gft.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaCorrente extends Conta {
	
	Double porcentagemJuros = 0.10;

	public ContaCorrente() {
		super(Banco.agencia);
	}

	@Override
	public boolean sacar(BigDecimal valorSaque) {

		if (this.saldo.subtract(valorSaque).doubleValue() < -200) {
			
			System.out.println("ERROR !");
			System.out.println("Saldo insuficiente!");
			return false;
		
		} else if (this.saldo.subtract(valorSaque).doubleValue() > -200	&& this.saldo.subtract(valorSaque).doubleValue() < 0) {
			
			Double porcentagemJuros = 0.10;
			BigDecimal jurosSaque = valorSaque.multiply(new BigDecimal(porcentagemJuros));

			this.saldo = saldo.subtract(valorSaque.add(jurosSaque));

			System.out.println("Aprovado!");
			System.out.println("Você entrou no cheque especial");
			System.out.println("Saldo atual: " + getSaldo().setScale(2, RoundingMode.CEILING));
			return true;
		} else {
			
			BigDecimal jurosSaque = valorSaque.multiply(new BigDecimal(porcentagemJuros));

			this.saldo = saldo.subtract(valorSaque.add(jurosSaque));
			System.out.println("Aprovado!");
			System.out.println("Saldo atual: " + getSaldo().setScale(2, RoundingMode.CEILING));
			return true;
		}
	}

	@Override
	public void depositar(BigDecimal valorDeposito) {

		if (valorDeposito.doubleValue() <= 0) {
			
			System.out.println("Error");
			System.out.println("O valor de deposito tem que ser maior que 0!");
		
		} else {

			this.saldo.add(valorDeposito);
		}
	}

	@Override
	public void transferir(BigDecimal valorTransferencia, Conta contaDestino) {
		
		sacar(valorTransferencia);
		contaDestino.depositar(valorTransferencia);
		System.out.println("Transferencia feita com sucesso!");

	}

	@Override
	public String toString() {
		return "ContaCorrente : agencia=" + agencia + ", numero=" + numero
				+ ", saldo=" + saldo.setScale(2,RoundingMode.CEILING) ;
	}
	
	
	
}
