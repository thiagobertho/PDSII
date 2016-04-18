package model.dao;

import java.util.List;

import model.domain.Evento;

public interface EventoDao {

	List<Evento> getEventos(Evento evento);
	
	public void excluir(Evento evento);

	Evento salvar(Evento evento);

	void atualizar(Evento evento);

}