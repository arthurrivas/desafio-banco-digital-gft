package br.com.dio.gft.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaPoupanca extends Conta{
	
	public ContaPoupanca(){
		super(Banco.agencia);
	}
	
	// Não é cobrado nenhum juros para retirar dinheiro da conta poupança
	@Override
	public boolean sacar(BigDecimal valorSaque) {
		if (this.saldo.subtract(valorSaque).doubleValue() <= 0) {
			System.out.println("ERROR !");
			System.out.println("Saldo insuficiente!");
			return false;
	
		} else {
			
			this.saldo = saldo.subtract(valorSaque);
			System.out.println("Aprovado!");
			System.out.println("Saldo atual: " + getSaldo());
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
		boolean saqueValido = sacar(valorTransferencia.multiply(new BigDecimal(10)));
		
		if(saqueValido) {
			contaDestino.depositar(valorTransferencia);
			System.out.println("Transferencia feita com sucesso!");
		}
		
		
	}

	@Override
	public String toString() {
		return "ContaPoupanca: agencia=" + agencia + ", numero=" + numero + ", saldo=" + saldo.setScale(2,RoundingMode.CEILING) ;
	}
	
}
