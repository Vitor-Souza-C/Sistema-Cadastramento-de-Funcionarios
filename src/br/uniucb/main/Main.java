package br.uniucb.main;

import java.util.ArrayList;
import java.util.Scanner;
import br.uniucb.entidadesUni.Diretor;
import br.uniucb.entidadesUni.Funcionario;
import br.uniucb.entidadesUni.Professor;
import br.ucb.leitorDados.ScannerDados;

public class Main {
	public static void main(String[] args) {
		ArrayList<Funcionario> listaFunci = new ArrayList<>(); // Cria uma ArrayList
		ScannerDados sc = new ScannerDados(); // Cria o objeto 'sc' da classe ScannerDados
		char continuacao; // delclara variavel de continuidade
// executa a inclusão de funcionarios ate o usuario pressionar 'n' para sair e obter os outros resultados
		do {
// recebe do usuario os dados do funcionario 
			sc.mensagem("- Sistema de cadastramento de funcionários da UCB (UNIVERSIDADE CATÓLICA DE BRASILIA) -");

			String nome = sc.lerString("Ïnforme o nome:");
			String cpf = sc.lerString("Ïnforme o cpf:");
			double salario = sc.lerDouble("Ïnforme o salario:");
			int matricula = sc.lerInt("Ïnforme a matricula:");

			char cargo = sc.lerChar("Ïnforme o cargo: ('d' - diretor / 'p' - professor)");

			double tempoDeCasa = 0;
			int anoDeAdmissao = 0;

			if (cargo == 'd') {
				tempoDeCasa = sc.lerDouble("Ïnforme o tempo de casa em meses:");
			} else {
				anoDeAdmissao = sc.lerInt("Ïnforme o ano de admissão:");

			}

//valida o cargo, se o funcionario for repetido e insere no array quando as validacões estiverem corretas

			boolean cadastroRepetido = false;

			if (cargo == 'd') {
				Diretor d1 = new Diretor(nome, matricula, cpf, salario, tempoDeCasa);

				for (int i = 0; i < listaFunci.size(); i++) {// verifica se existe funcionário repetido com equals
					if (d1.equals(listaFunci.get(i))) {
						cadastroRepetido = true;
					}
				}
				if (cadastroRepetido) {
					sc.mensagem("O funcionario já está cadastrado! o cadastro não foi realizado!");
				} else {
					listaFunci.add(d1); // inclui no array um Diretor
					sc.mensagem("Cadastro realizado!");
					sc.mensagem(d1.toString()); // exibe dados do funcionario cadastrado via toString
				}

			} else if (cargo == 'p') {
				Professor p1 = new Professor(nome, matricula, cpf, salario, anoDeAdmissao);
// verifica se existe funcionario repetido com o equals
				for (int i = 0; i < listaFunci.size(); i++) {
					if (p1.equals(listaFunci.get(i))) {
						cadastroRepetido = true;
					}
				}
				if (cadastroRepetido) {// Caso for verdadeiro a proposição o funcionario não é adicionado
					sc.mensagem("Funcionario já cadastrado! o cadastro não foi realizado!");
				} else {
					listaFunci.add(p1); // inclui no array um professor
					sc.mensagem("Cadastro realizado!");
					sc.mensagem(p1.toString()); // exibe os dados do funcionario cadastrado pelo toString
				}
			} else {

				sc.mensagem("Cargo inexistente, o funcionário não foi cadastrado!"); // caso o cargo seja diferente dos valores
																						// 'd' ou 'p'
			}

			continuacao = sc.lerChar("Você deseja continuar?(Pressione 'n' para sair!)");
		} while (continuacao != 'n');
//Fim do loop
		double totalImpostoRenda = 0;
		double mediaImpostoRenda = 0;

//calcula total de imposto de renda de cada funcionário adicionado
		for (int i = 0; i < listaFunci.size(); i++) {
			totalImpostoRenda = totalImpostoRenda + listaFunci.get(i).getImpostoDeRenda();
		}
//calcula media de imposto de renda de cada funionário
		mediaImpostoRenda = totalImpostoRenda / listaFunci.size();
//exibe mensagem com os valores de imposto de renda
		sc.mensagem("O valor total do Imposto de Renda é R$: " + totalImpostoRenda);
		sc.mensagem("A média de Imposto de Renda é R$: " + mediaImpostoRenda);
//Apresenta ao usuário os funcionários adicionados!
		sc.mensagem("Lista de funcionários já adicionados:\n" + listaFunci.toString());

	}

}
