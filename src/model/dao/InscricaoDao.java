package model.dao;

import java.util.List;

import model.domain.Inscricao;

public interface InscricaoDao {

	List<Inscricao> getInscricoes(Inscricao inscricao);
	
	public void excluir(Inscricao inscricao);

	Inscricao salvar(Inscricao inscricao);

	void atualizar(Inscricao inscricao);

}