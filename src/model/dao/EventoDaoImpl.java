package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Evento;

public class EventoDaoImpl implements EventoDao {
	
	@PersistenceContext(unitName="SistemaEventos")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Evento> getEventos(Evento evento) {
		StringBuffer hql = new StringBuffer("from Evento c"
				+ " where 1 = 1");		
		if (evento.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (evento.getCodigo() != null) {
			query.setParameter("codigo",evento.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Evento evento) {
		evento = entityManager.merge(evento);
		entityManager.remove(evento);
	}

	@Override
	@Transactional
	public Evento salvar(Evento evento) {
		entityManager.persist(evento);
		return evento;
	}

	@Override
	@Transactional
	public void atualizar(Evento evento) {
		evento = entityManager.merge(evento);
		entityManager.persist(evento);		
	}
	

}
