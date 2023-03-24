package teste;

import bean.Contato;
import bean.Endereco;
import bean.Pessoa;
import dao.ContatoDAO;
import dao.EnderecoDAO;
import dao.PessoaDAO;

public class InsertPessoa {
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		pessoa.setCargo("Chefe");
		pessoa.setNome("Carlos");
		pessoa.setSalario(21000);

		Endereco endereco = new Endereco();
		endereco.setBairro("Vila do Conde");
		endereco.setCidade("Barueri");
		endereco.setEstado("SP");
		endereco.setLogradouro("Rua Duq. de Barcellos");
		endereco.setNumero("333");

		EnderecoDAO endDAO = new EnderecoDAO();
		endDAO.salvar(endereco);

		pessoa.setEndereco(endereco);

		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);

		Contato c = new Contato();
		c.setEmail("email@gmail.com");
		c.setTelefone("11 9999-7777");
		c.setPessoa(pessoa);

		Contato c2 = new Contato();
		c2.setEmail("email@gmail.com");
		c2.setTelefone("11 9999-7777");
		c2.setPessoa(pessoa);

		Contato c3 = new Contato();
		c3.setEmail("email@gmail.com");
		c3.setTelefone("11 9999-7777");
		c3.setPessoa(pessoa);

		ContatoDAO cDAO = new ContatoDAO();
		cDAO.salvar(c);
		cDAO.salvar(c2);
		cDAO.salvar(c3);
	}
}
