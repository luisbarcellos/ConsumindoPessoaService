package br.com.consumindowebservice.repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.consumindowebservice.model.Pessoa;

public class PessoaRepositoryImpl implements PessoaRepository {
	
	private RestTemplate restTemplate;
	
	public PessoaRepositoryImpl(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	public List<Pessoa> listaPessoas() {
		Pessoa[] listaPessoa = restTemplate.getForObject("http://localhost:8080/pessoa/listarPessoasJSON", Pessoa[].class);
		return Arrays.asList(listaPessoa);
	}
	
	public void cadastrarPessoa(Pessoa pessoa) {
		restTemplate.postForObject("http://localhost:8080/pessoa/cadastrarPessoa", pessoa, Pessoa.class);		
	}
	
	public void deletarPessoa(int idPessoa) {
		restTemplate.delete("http://localhost:8080/pessoa/deletarPessoa/" + idPessoa);
	}
	
	public void atualizarPessoa(Pessoa pessoa) {
		restTemplate.put("http://localhost:8080/pessoa/atualizarPessoa", pessoa);
	}
}