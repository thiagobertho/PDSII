package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.EventoDao;
import model.domain.Evento;
import model.facade.EventoFacade;

@Path("/evento")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class EventoFacadeImpl implements EventoFacade {

	@Inject
	private EventoDao eventoDao;
	
	@Override
	@GET
	public List<Evento> getEventos() {
		return eventoDao.getEventos(new Evento());
	}
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Evento> getEventos(@PathParam("codigo") Integer codigo) {
		Evento evento = new Evento();
		evento.setCodigo(codigo);
		return eventoDao.getEventos(evento);
	}
	
	@Override
	@POST 
	public Evento salvar(Evento evento) { 
		evento = eventoDao.salvar(evento);
	 	return evento;
	}
	
	@Override
	@PUT 
	public void atualizar(Evento evento) { 
		eventoDao.atualizar(evento);
	}
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarEvento(@PathParam("codigo") Integer codigo) {
		Evento evento = new Evento();
		evento.setCodigo(codigo);
		eventoDao.excluir(evento);
	}

}
