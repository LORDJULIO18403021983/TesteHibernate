package teste;

import java.util.List;

import bean.Pessoa;
import dao.PessoaDAO;

public class BuscaTodasAsPessoa {
	public static void main(String[] args) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		try {
			List<Pessoa> listaPessoas = pessoaDAO.pesquisarPorNome("n");
			for (Pessoa pessoa : listaPessoas) {
				System.out.println("Pessoa buscada: " + pessoa.getNome() + " - " + pessoa.getCargo());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
