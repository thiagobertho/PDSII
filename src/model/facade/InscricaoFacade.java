package model.facade;

import java.util.List;

import model.domain.Inscricao;

public interface InscricaoFacade {

	List<Inscricao> getInscricoes();

	List<Inscricao> getInscricoes(Integer codigo);

	Inscricao salvar(Inscricao inscricao);

	void atualizar(Inscricao inscricao);

	void deletarInscricao(Integer codigo);

}