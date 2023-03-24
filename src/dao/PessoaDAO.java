package dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import bean.Pessoa;
import util.HibernateUtil;

public class PessoaDAO extends GenericDAO {
	public Pessoa buscarPorCodigo(int codigo) throws Exception {
		Session sessao = null;
		Pessoa Pessoa = null;

		sessao = HibernateUtil.getSessionFactory().openSession();
		Pessoa = (Pessoa) sessao.get(Pessoa.class, codigo);

		return Pessoa;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Pessoa> buscarTodos() throws Exception {
		ArrayList<Pessoa> listaRetorno = new ArrayList<Pessoa>();

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = sessao.createCriteria(Pessoa.class);

		criteria.addOrder(Order.asc("codigo"));

		listaRetorno = (ArrayList<Pessoa>) criteria.list();

		return listaRetorno;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Pessoa> pesquisarPorNome(String nome) throws Exception {
		ArrayList<Pessoa> listaRetorno = new ArrayList<Pessoa>();

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = sessao.createCriteria(Pessoa.class);

		criteria.add(Restrictions.like("nome", "%" + nome + "%"));

		criteria.addOrder(Order.asc("nome"));

		listaRetorno = (ArrayList<Pessoa>) criteria.list();

		return listaRetorno;
	}
}
