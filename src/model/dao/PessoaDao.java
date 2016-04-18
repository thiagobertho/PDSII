package model.dao;

import java.util.List;

import model.domain.Pessoa;

public interface PessoaDao {

	List<Pessoa> getPessoas(Pessoa pessoa);
	
	public List<Pessoa> getPessoasInscritas(Pessoa pessoa);
	
	public void excluir(Pessoa pessoa);

	Pessoa salvar(Pessoa pessoa);

	void atualizar(Pessoa pessoa);

}