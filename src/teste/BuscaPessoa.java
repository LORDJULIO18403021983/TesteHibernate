package teste;

import bean.Pessoa;
import dao.PessoaDAO;

public class BuscaPessoa {
	public static void main(String[] args) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		try {
			Pessoa pessoa = pessoaDAO.buscarPorCodigo(3);
			System.out.println("Buscado pessoa: " + pessoa.getNome());
			pessoaDAO.excluir(pessoa);
			System.out.println("A pessoa " + pessoa.getNome() + " foi excluída.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
