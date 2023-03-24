package dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import bean.Filme;
import util.HibernateUtil;

public class FilmeDAO extends GenericDAO{
	
	public Filme buscarPorCodigo (Long codigo) throws Exception{
		Session sessao = null;
		Filme filme = null;

		sessao = HibernateUtil.getSessionFactory().openSession();
		filme = (Filme) sessao.get(Filme.class, codigo);

		return filme;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Filme> buscarTodos() throws Exception{
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = sessao.createCriteria(Filme.class);
		
		criteria.addOrder (Order.asc("codigo"));
		
		listaRetorno = (ArrayList<Filme>) criteria.list();
		
		return listaRetorno;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Filme> pesquisarPorNome(String nome) throws Exception{
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = sessao.createCriteria(Filme.class);

		criteria.add(Restrictions.like("nome", "%" + nome + "%"));

		criteria.addOrder(Order.asc("nome"));
		
		listaRetorno = (ArrayList<Filme>) criteria.list();
		
		return listaRetorno;
	}
}