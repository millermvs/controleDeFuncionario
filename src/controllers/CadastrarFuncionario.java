package controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;

import entities.Endereco;
import entities.Funcionario;

public class CadastrarFuncionario {
	public void cadastrarFuncionario() {
		System.out.println("\n CADASTRO DE FUNCIONARIO ");

		var scanner = new Scanner(System.in);

		var novoFuncionario = new Funcionario();

		novoFuncionario.setEndereco(new Endereco());

		novoFuncionario.setId(UUID.randomUUID());
		novoFuncionario.getEndereco().setId(UUID.randomUUID());

		System.out.println("Nome.......:");
		novoFuncionario.setNome(scanner.nextLine());

		System.out.println("CPF.......:");
		novoFuncionario.setCpf(scanner.nextLine());

		System.out.println("Data de admissão.......:");
		var input = scanner.nextLine();
		var dataAdmissao = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		novoFuncionario.setDataAdmissao(dataAdmissao);

		System.out.print("Cep......:");
		novoFuncionario.getEndereco().setCep(scanner.nextLine());

		System.out.print("Rua.......:");
		novoFuncionario.getEndereco().setRua(scanner.nextLine());

		System.out.print("N°.......:");
		novoFuncionario.getEndereco().setNumero(scanner.nextLine());

		System.out.print("Complemento.......:");
		novoFuncionario.getEndereco().setComplemento(scanner.nextLine());

		System.out.print("Bairro.......:");
		novoFuncionario.getEndereco().setBairro(scanner.nextLine());

		System.out.print("Cidade.......:");
		novoFuncionario.getEndereco().setCidade(scanner.nextLine());

		System.out.print("UF.......:");
		novoFuncionario.getEndereco().setEstado(scanner.nextLine());

		scanner.close();

	}

}
