package br.com.consumindowebservice.restclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import br.com.consumindowebservice.repository.PessoaRepositoryImpl;

@Configuration
public class RestClientModule {
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public PessoaRepositoryImpl pessoaRepositoryImpl(RestTemplate restTemplate){
		return new PessoaRepositoryImpl(restTemplate);
	}
	
}
