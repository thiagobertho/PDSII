package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Pessoa;

public class PessoaDaoImpl implements PessoaDao {
	
	@PersistenceContext(unitName="SistemaEventos")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Pessoa> getPessoas(Pessoa pessoa) {
		StringBuffer hql = new StringBuffer("from Pessoa c"
				+ " where 1 = 1");		
		if (pessoa.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (pessoa.getCodigo() != null) {
			query.setParameter("codigo",pessoa.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Pessoa> getPessoasInscritas(Pessoa pessoa) {
		StringBuffer hql = new StringBuffer("from Pessoa c left join fetch c.inscricoes e where 1 = 1 ");		
		if (pessoa.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (pessoa.getCodigo() != null) {
			query.setParameter("codigo",pessoa.getCodigo());
		} 
		return query.getResultList();
	}
	
	
	@Override
	@Transactional
	public void excluir(Pessoa pessoa) {
		pessoa = entityManager.merge(pessoa);
		entityManager.remove(pessoa);
	}

	@Override
	@Transactional
	public Pessoa salvar(Pessoa pessoa) {
		entityManager.persist(pessoa);
		return pessoa;
	}

	@Override
	@Transactional
	public void atualizar(Pessoa pessoa) {
		pessoa = entityManager.merge(pessoa);
		entityManager.persist(pessoa);		
	}
	

}
