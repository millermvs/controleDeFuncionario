package repositories;

import java.sql.DriverManager;

import entities.Funcionario;

public class FuncionarioRepository {
	public void inserir(Funcionario novoFuncionario) {
		try {
			var host = "jdbc:mysql://localhost:3306/bd_aula03?useSSL=false&serverTimezone=UTC";
			var user = "root";
			var pass = "coti";

			var connection = DriverManager.getConnection(host, user, pass);

			var statementEnd = connection.prepareStatement(
					"insert into endereco(id, rua, numero, complemento, bairro, cidade, estado, cep) values(?,?,?,?,?,?,?,?)");
			statementEnd.setString(1, novoFuncionario.getEndereco().getId().toString());
			statementEnd.setString(2, novoFuncionario.getEndereco().getRua());
			statementEnd.setString(3, novoFuncionario.getEndereco().getNumero());
			statementEnd.setString(4, novoFuncionario.getEndereco().getComplemento());
			statementEnd.setString(5, novoFuncionario.getEndereco().getBairro());
			statementEnd.setString(6, novoFuncionario.getEndereco().getCidade());
			statementEnd.setString(7, novoFuncionario.getEndereco().getEstado());
			statementEnd.setString(8, novoFuncionario.getEndereco().getCep());
			statementEnd.execute();

			var statementFun = connection.prepareStatement(
					"insert into funcionario(id, nome, cpf, dataadmissao, endereco_id) values(?,?,?,?,?)");
			statementFun.setString(1, novoFuncionario.getId().toString());
			statementFun.setString(2, novoFuncionario.getNome());
			statementFun.setString(3, novoFuncionario.getCpf());
			statementFun.setDate(4, java.sql.Date.valueOf(novoFuncionario.getDataAdmissao()));
			statementFun.setString(5, novoFuncionario.getEndereco().getId().toString());
			statementFun.execute();

			connection.close();

			System.out.println("Salvo");
		} catch (Exception e) {
			System.out.println("falha" + e.getMessage());
		}

	}

}
