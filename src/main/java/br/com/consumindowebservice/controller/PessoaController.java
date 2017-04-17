package br.com.consumindowebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

import com.sun.jersey.spi.inject.Inject;

import br.com.consumindowebservice.model.Pessoa;
import br.com.consumindowebservice.repository.PessoaRepository;
import br.com.consumindowebservice.repository.PessoaRepositoryImpl;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@RequestMapping(value = "/listarPessoas", method = RequestMethod.GET)
	public String listaPessoas(Model model){
		List<Pessoa> listaPessoas = pessoaRepository.listaPessoas();
		if(listaPessoas != null){
			model.addAttribute("pessoas", listaPessoas);
		}
		return "listarPessoas";
	}
	@RequestMapping(value = "/listarPessoasJQuery", method = RequestMethod.GET)
	public String listaPessoasJQuery(){
		return "listarPessoasJQuery";
	}
	
	@RequestMapping(value = "/listarPessoasCRUDJQuery", method = RequestMethod.GET)
	public String listaPessoasCRUDJQuery(){
		return "listarPessoasCRUDJQuery";
	}
	
	@RequestMapping(value = "/cadastrarPessoa", method = RequestMethod.POST)
	public String cadastrarPessoa(Pessoa pessoa){
		try{
		pessoaRepository.cadastrarPessoa(pessoa);
		} catch (ResourceAccessException error) {
			System.out.println("ResourceAccessExeption: " + error.getMostSpecificCause());
		} catch (HttpClientErrorException error) {
			System.out.println("HttpClientErrorException: " + error.getMostSpecificCause());
		} catch (HttpServerErrorException error) {
			System.out.println("HttpServerErrorException: " + error.getMostSpecificCause());
		}
		return "redirect:/pessoas/listarPessoasJQuery";
	}
	
	@RequestMapping(value = "/deletarPessoa", method = RequestMethod.POST)
	public String deletarPessoa(int idPessoa){
		try{
			pessoaRepository.deletarPessoa(idPessoa);
		} catch (ResourceAccessException error) {
			System.out.println("ResourceAccessExeption: " + error.getMostSpecificCause());
		} catch (HttpClientErrorException error) {
			System.out.println("HttpClientErrorException: " + error.getMostSpecificCause());
		} catch (HttpServerErrorException error) {
			System.out.println("HttpServerErrorException: " + error.getMostSpecificCause());
		}
		return "redirect:/pessoas/listarPessoasJQuery";
	}
	
	@RequestMapping(value = "/atualizarPessoa", method = RequestMethod.POST)
	public String atualizarPessoa(Pessoa pessoa){
		try{
			pessoaRepository.atualizarPessoa(pessoa);
		} catch (ResourceAccessException error) {
			System.out.println("ResourceAccessExeption: " + error.getMostSpecificCause());
		} catch (HttpClientErrorException error) {
			System.out.println("HttpClientErrorException: " + error.getMostSpecificCause());
		} catch (HttpServerErrorException error) {
			System.out.println("HttpServerErrorException: " + error.getMostSpecificCause());
		}
		return "redirect:/pessoas/listarPessoasJQuery";
	}
}