package br.uniucb.entidadesUni;

import java.util.Objects;

public class Funcionario {
 
//Variáveis comuns aos funcionários
	private String nome;
	private int matricula;
	private String cpf;
	private double salario;
//Contrutor de Funcionario
	public Funcionario(String nome, int matricula, String cpf, double salario) {
		this.nome = nome;
		this.matricula = matricula;
		this.cpf = cpf;
		this.salario = salario;
	}

//sobscrita do metodo equals  
	@Override
	public boolean equals(Object obj) {
//Verifica se existem funcionarios com matrículas repetidas 
		if (obj instanceof Funcionario) {
			Funcionario temp = (Funcionario) obj;
			if (getMatricula() == temp.getMatricula()) {
				return true;
			} else {
				return false;
			}
		}
		return super.equals(obj);
	}

// Getters e Setters das variáveis
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getImpostoDeRenda() {
		return 0;
	}
}