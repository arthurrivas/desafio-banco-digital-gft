package br.com.dio.gft;

import java.util.Arrays;
import java.util.Scanner;

import br.com.dio.gft.models.Banco;
import br.com.dio.gft.models.Cliente;
import br.com.dio.gft.models.ContaCorrente;
import br.com.dio.gft.models.ContaPoupanca;

public class ProgramMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Criaçao de todas as entidades para teste
		Banco banco = new Banco();

		ContaCorrente cc1 = new ContaCorrente();
		ContaCorrente cc2 = new ContaCorrente();
		ContaCorrente cc3 = new ContaCorrente();
		
		ContaPoupanca cp1 = new ContaPoupanca();
		ContaPoupanca cp2 = new ContaPoupanca();
		ContaPoupanca cp3 = new ContaPoupanca();
		
		Cliente cliente1 = new Cliente("Arthur", "arthurrivas1@gmail.com", "1234", cc1, cp1);
		Cliente cliente2 = new Cliente("perola", "perola@gmail.com", "1234", cc2, cp2);
		Cliente cliente3 = new Cliente("joao", "joao@gmail.com", "1234", cc3, cp3);

		banco.addCliente(Arrays.asList(cliente1, cliente2, cliente3));
		
		//inicializa os menus 
		banco.mostraLogin(scan, banco);

	}

	

}






















