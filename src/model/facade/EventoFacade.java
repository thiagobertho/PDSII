package model.facade;

import java.util.List;

import model.domain.Evento;

public interface EventoFacade {

	List<Evento> getEventos();

	List<Evento> getEventos(Integer codigo);

	Evento salvar(Evento evento);

	void atualizar(Evento evento);

	void deletarEvento(Integer codigo);

}