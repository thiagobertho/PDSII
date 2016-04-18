package model.facade;

import java.util.List;

import model.domain.Pessoa;

public interface PessoaFacade {

	List<Pessoa> getPessoas();

	List<Pessoa> getPessoas(Integer codigo);

	Pessoa salvar(Pessoa pessoa);

	void atualizar(Pessoa pessoa);

	void deletarPessoa(Integer codigo);

}