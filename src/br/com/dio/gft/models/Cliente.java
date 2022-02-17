package br.com.dio.gft.models;

import java.util.Objects;

public class Cliente {
	
	
	protected String nome;
	protected String email;
	protected String senha;
	
	ContaCorrente contaCorrente;
	ContaPoupanca contaPoupanca;
	
	public Cliente() {
	}

	public Cliente(String nome, String email, String senha, ContaCorrente cc, ContaPoupanca cp) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.contaCorrente = cc;
		this.contaPoupanca = cp;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	
	

	public ContaPoupanca getContaPoupanca() {
		return contaPoupanca;
	}

	public void setContaPoupanca(ContaPoupanca contaPoupanca) {
		this.contaPoupanca = contaPoupanca;
	}

	@Override
	public String toString() {
		return "Cliente [email=" + email + ", senha=" + senha + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(email, other.email) && Objects.equals(senha, other.senha);
	}
	
	
	
	
	
	
	
}
