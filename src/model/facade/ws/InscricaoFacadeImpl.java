package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.InscricaoDao;
import model.domain.Inscricao;
import model.facade.InscricaoFacade;

@WebService(serviceName="ws/inscricao")
public class InscricaoFacadeImpl implements InscricaoFacade {
	
	@Inject
	private InscricaoDao inscricaoDao;
			
	@WebMethod
	public List<Inscricao> getInscricoes() {
		return inscricaoDao.getInscricoes(new Inscricao());
	}
	
	@Override
	@WebMethod(operationName="getInscricaoCodigo")
	public List<Inscricao> getInscricoes(@WebParam(name="codigoInscricao") 
							Integer codigo) {
		Inscricao inscricao = new Inscricao();
		inscricao.setCodigo(codigo);
		return inscricaoDao.getInscricoes(inscricao);
	}
	
	@WebMethod
	public Inscricao salvar(@WebParam(name="inscricao") Inscricao inscricao) {
		return inscricaoDao.salvar(inscricao);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="inscricao") Inscricao inscricao) {
		inscricaoDao.atualizar(inscricao);
	}
	
	@WebMethod
	public void deletarInscricao(@WebParam(name="codigoInscricao") Integer codigo) {
		Inscricao inscricao = new Inscricao();
		inscricao.setCodigo(codigo);
		inscricaoDao.excluir(inscricao);
	}


}
