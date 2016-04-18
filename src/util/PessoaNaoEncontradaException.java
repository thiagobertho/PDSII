package util;

public class PessoaNaoEncontradaException extends Exception {
	private static final long serialVersionUID = 1L;

	public PessoaNaoEncontradaException(Integer codigo) {
		super(codigo.toString());
	}

}
