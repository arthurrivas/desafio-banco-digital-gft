package br.com.dio.gft.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Banco {

	protected static final String nome = "Banco digital Dio";
	protected static final Integer agencia = 1234;

	Set<Cliente> listaClientes = new HashSet<>();

	public void addCliente(List<Cliente> cliente) {
		cliente.forEach(x -> {
			listaClientes.add(x);
		});
	}

	public Cliente retornaUsuarioAutenticado(String email, String senha) {
		Cliente temp = new Cliente();
		temp.setEmail(email);
		temp.setSenha(senha);
		for (Cliente cliente : this.listaClientes) {
			if(cliente.equals(temp)) {
				return cliente;
			}
		}
		return null;
	}
	
	public Conta retornClientePorNumeroConta(Integer numeroPesquisa) {

		for (Cliente cliente : this.listaClientes) {
			if(cliente.contaCorrente.getNumero().equals(numeroPesquisa)) {
				return cliente.getContaCorrente();
			} else if(cliente.getContaPoupanca().getNumero().equals(numeroPesquisa)) {
				return cliente.getContaPoupanca(); 
			}
		}
		return null;
	}
	
	
	
	public void mostraLogin(Scanner scan, Banco banco) {
		boolean menuLogin = true;
		
		Cliente clienteAutenticado = new Cliente();
		
		while (menuLogin) {

			System.out.println("0 - Encerrar o programa;");
			System.out.println("1 - Login");

			String escolhaLogin = scan.next();

			switch (escolhaLogin) {
			case "0":
				menuLogin = false;
				break;

			case "1":
				System.out.print("Email: ");
				String email = scan.next();
				System.out.print("Senha: ");
				String senha = scan.next();

				clienteAutenticado = banco.retornaUsuarioAutenticado(email, senha);

				if (clienteAutenticado == null) {
					System.out.println("Login invalido");

				} else {
					mostraMenu(scan, clienteAutenticado,banco);
				}

				break;
			default:
				System.out.println("Opção invalida");
				break;
			}

		}
	}

	public void mostraMenu(Scanner scan, Cliente clienteAutenticado, Banco banco) {
		boolean menuOpcoes = true;

		while (menuOpcoes) {

			System.out.println("0 - Logout");
			System.out.println("1 - Sacar");
			System.out.println("2 - Depositar ");
			System.out.println("3 - Transferir");
			System.out.println("4 - Info Contas");

			System.out.print("Sua escolha :");
			String escolha = scan.next();

			switch (escolha) {
			case "0":
				menuOpcoes = false;
				break;
			case "1":
				mostraOpcoesSaque(scan, clienteAutenticado);
				break;
			case "2":
				mostraOpcoesDeposito(scan, clienteAutenticado);
			case "3":
				mostraOpcoesTransferencia(scan, clienteAutenticado, banco);
			case "4":
				mostraInfoContas(clienteAutenticado);
			default:
				break;
			}

		}
	}
	
	public void mostraOpcoesSaque(Scanner scan, Cliente cliente) {
		
		System.out.println("0 - Cancelar saque;");
		System.out.println("1 - Sacar da conta corrente;");
		System.out.println("2 - Sacar da conta poupança;");
		
		boolean menuOpções = true;
		
		while(menuOpções) {
			
			String escolha = scan.next();
			
			switch (escolha) {
			case "0":
				menuOpções = false;
				break;
			case "1":
				System.out.println("Digite o valor que deseja sacar ");
				System.out.print("Saldo: R$" + cliente.getContaCorrente().getSaldo().setScale(2,RoundingMode.CEILING));
				BigDecimal valorSaqueCC = scan.nextBigDecimal();
				
				cliente.getContaCorrente().sacar(valorSaqueCC);
				menuOpções = false;
				break;
			case "2":
				System.out.print("Digite o valor que deseja sacar ");
				System.out.print("Saldo: R$" + cliente.getContaPoupanca().getSaldo().setScale(2,RoundingMode.CEILING));
				BigDecimal valorSaqueCP = scan.nextBigDecimal();
				
				cliente.getContaPoupanca().sacar(valorSaqueCP);
				menuOpções = false;
			default:
				System.out.println("Opção invalida");
				break;
			}
		}
		
	}

	public void mostraOpcoesDeposito(Scanner scan, Cliente cliente){
		
		System.out.println("0 - Cancelar deposito;");
		System.out.println("1 - depositar na conta corrente;");
		System.out.println("2 - Depositar na conta poupança;");
		
		boolean menuOpções = true;
		
		while(menuOpções) {
			
			String escolha = scan.next();
			
			switch (escolha) {
			case "0":
				menuOpções = false;
				break;
			case "1":
				System.out.print("Digite o valor que deseja depositar ");
				BigDecimal valorDepositoCC = scan.nextBigDecimal();
				
				cliente.getContaCorrente().sacar(valorDepositoCC);
				menuOpções = false;
				break;
			case "2":
				System.out.print("Digite o valor que deseja sacar ");
				
				BigDecimal valorDepositoCP = scan.nextBigDecimal();
				
				cliente.getContaCorrente().sacar(valorDepositoCP);
				menuOpções = false;
			default:
				System.out.println("Opção invalida");
				break;
			}
		}
	}
	
	public void mostraOpcoesTransferencia(Scanner scan, Cliente clienteAuth, Banco banco) {
		System.out.println("0 - Cancelar transferencia;");
		System.out.println("1 - Transferir da conta corrente;");
		System.out.println("2 - Transferir da conta poupança;");
		
		boolean menuOpções = true;
		
		while(menuOpções) {
			
			String escolha = scan.next();
			
			switch (escolha) {
			case "0":
				menuOpções = false;
				break;
			case "1":
				System.out.print("Digite o valor que deseja transferir ");
				BigDecimal valorDepositoCC = scan.nextBigDecimal();
				
				System.out.println("Digite o numero da conta de destino");
				Integer numeroConta = scan.nextInt();
				
				Conta contaDestino = banco.retornClientePorNumeroConta(numeroConta);
				
				clienteAuth.contaCorrente.transferir(valorDepositoCC, contaDestino);
				menuOpções = false;
				break;
			case "2":
				System.out.print("Digite o valor que deseja transferir ");
				BigDecimal valorDepositoCP = scan.nextBigDecimal();
				
				System.out.println("Digite o numero da conta de destino");
				Integer numeroContaPesquisa = scan.nextInt();
				
				Conta contaDestinoDeposito = banco.retornClientePorNumeroConta(numeroContaPesquisa);
				
				clienteAuth.contaCorrente.transferir(valorDepositoCP, contaDestinoDeposito);
				menuOpções = false;
			default:
				System.out.println("Opção invalida");
				break;
			}
		}
	}

	public void mostraInfoContas(Cliente cliente) {
		
		System.out.println("********CONTA CORRENTE***************");
		System.out.println(cliente.getContaCorrente());
		System.out.println("*************************************");
		System.out.println("********CONTA POUPANCA***************");
		System.out.println(cliente.getContaPoupanca());
		
	}

	
}
