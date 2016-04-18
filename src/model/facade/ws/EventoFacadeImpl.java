package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.EventoDao;
import model.domain.Evento;
import model.facade.EventoFacade;

@WebService(serviceName="ws/evento")
public class EventoFacadeImpl implements EventoFacade {
	
	@Inject
	private EventoDao eventoDao;
			
	@WebMethod
	public List<Evento> getEventos() {
		return eventoDao.getEventos(new Evento());
	}
	
	@Override
	@WebMethod(operationName="getEventoCodigo")
	public List<Evento> getEventos(@WebParam(name="codigoEvento") 
							Integer codigo) {
		Evento evento = new Evento();
		evento.setCodigo(codigo);
		return eventoDao.getEventos(evento);
	}
	
	@WebMethod
	public Evento salvar(@WebParam(name="evento") Evento evento) {
		return eventoDao.salvar(evento);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="evento") Evento evento) {
		eventoDao.atualizar(evento);
	}
	
	@WebMethod
	public void deletarEvento(@WebParam(name="codigoEvento") Integer codigo) {
		Evento evento = new Evento();
		evento.setCodigo(codigo);
		eventoDao.excluir(evento);
	}


}
