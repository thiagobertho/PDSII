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

import model.dao.InscricaoDao;
import model.domain.Inscricao;
import model.facade.InscricaoFacade;

@Path("/inscricao")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class InscricaoFacadeImpl implements InscricaoFacade {

	@Inject
	private InscricaoDao inscricaoDao;
	
	@Override
	@GET
	public List<Inscricao> getInscricoes() {
		return inscricaoDao.getInscricoes(new Inscricao());
	}
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Inscricao> getInscricoes(@PathParam("codigo") Integer codigo) {
		Inscricao inscricao = new Inscricao();
		inscricao.setCodigo(codigo);
		return inscricaoDao.getInscricoes(inscricao);
	}
	
	@Override
	@POST 
	public Inscricao salvar(Inscricao inscricao) { 
		inscricao = inscricaoDao.salvar(inscricao);
	 	return inscricao;
	}
	
	@Override
	@PUT 
	public void atualizar(Inscricao inscricao) { 
		inscricaoDao.atualizar(inscricao);
	}
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarInscricao(@PathParam("codigo") Integer codigo) {
		Inscricao inscricao = new Inscricao();
		inscricao.setCodigo(codigo);
		inscricaoDao.excluir(inscricao);
	}

}
