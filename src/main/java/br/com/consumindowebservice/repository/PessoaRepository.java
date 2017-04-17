package br.com.consumindowebservice.repository;

import java.util.List;

import br.com.consumindowebservice.model.Pessoa;


public interface PessoaRepository {
	public List<Pessoa> listaPessoas();
	
	public void cadastrarPessoa(Pessoa pessoa);
	
	public void deletarPessoa(int idPessoa);
	
	public void atualizarPessoa(Pessoa pessoa);
}
