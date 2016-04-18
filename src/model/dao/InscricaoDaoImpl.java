package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Inscricao;

public class InscricaoDaoImpl implements InscricaoDao {
	
	@PersistenceContext(unitName="SistemaEventos")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Inscricao> getInscricoes(Inscricao inscricao) {
		StringBuffer hql = new StringBuffer("from Inscricao c"
				+ " where 1 = 1");		
		if (inscricao.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (inscricao.getCodigo() != null) {
			query.setParameter("codigo",inscricao.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Inscricao inscricao) {
		inscricao = entityManager.merge(inscricao);
		entityManager.remove(inscricao);
	}

	@Override
	@Transactional
	public Inscricao salvar(Inscricao inscricao) {
		entityManager.persist(inscricao);
		return inscricao;
	}

	@Override
	@Transactional
	public void atualizar(Inscricao inscricao) {
		inscricao = entityManager.merge(inscricao);
		entityManager.persist(inscricao);		
	}
	

}
