package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.PessoaDao;
import model.domain.Pessoa;
import model.facade.PessoaFacade;

@WebService(serviceName="ws/pessoa")
public class PessoaFacadeImpl implements PessoaFacade {
	
	@Inject
	private PessoaDao pessoaDao;
			
	@WebMethod
	public List<Pessoa> getPessoas() {
		return pessoaDao.getPessoas(new Pessoa());
	}
	
	@Override
	@WebMethod(operationName="getPessoaCodigo")
	public List<Pessoa> getPessoas(@WebParam(name="codigoPessoa") 
							Integer codigo) {
		Pessoa pessoa = new Pessoa();
		pessoa.setCodigo(codigo);
		return pessoaDao.getPessoas(pessoa);
	}
	
	@WebMethod
	public Pessoa salvar(@WebParam(name="pessoa") Pessoa pessoa) {
		return pessoaDao.salvar(pessoa);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="pessoa") Pessoa pessoa) {
		pessoaDao.atualizar(pessoa);
	}
	
	@WebMethod
	public void deletarPessoa(@WebParam(name="codigoPessoa") Integer codigo) {
		Pessoa pessoa = new Pessoa();
		pessoa.setCodigo(codigo);
		pessoaDao.excluir(pessoa);
	}


}
