function listarPessoas(){
	$(document).ready(function() {
			    $.ajax({
			    	url:'http://localhost:8080/pessoa/listarPessoasJSON'
			    }).then(function(data) {
			    	$('#tabelaPessoa tbody').html('');
			    	
			    	var newData=[];
			    	newData.push(
					    $('<tr>').append(
				    		$('<td>').text('Id'),
				    		$('<td>').text('Nome'),
				    		$('<td>').text('Idade')
					    )
					);
					    
			    	$.each(data, function(i,item){
			    		newData.push(
						    $('<tr>').append(
					    		$('<td>').text(item.idPessoa),
					    		$('<td>').text(item.nome),
					    		$('<td>').text(item.idade)
						    )
						);
			    	});
			    	$('#tabelaPessoa tbody').html(newData);
			    });
			});
}

function cadastrarPessoa(){
	$.ajax({
    url: 'http://localhost:8080/pessoa/cadastrarPessoa',
    type: 'POST',
    contentType: 'application/json',        
    dataType: 'json',
    data: JSON.stringify(getDadosCadastroPessoa()), //Fazer uma String de JSON do formulário
    success: function(data){
    	alert('Pessoa cadastrada com sucesso!');
    	listarPessoas();
        }    
    });
}

function atualizarPessoa(){
	$.ajax({
    url: 'http://localhost:8080/pessoa/atualizarPessoa',
    type: 'PUT',
    contentType: 'application/json',        
    dataType: 'json',
    data: JSON.stringify(getDadosAtualizarPessoa()), //Fazer uma String de JSON do formulário
    success: function(data){
    	alert('Pessoa atualizada com sucesso!');
    	listarPessoas();
        }    
    });
}

function deletarPessoa(){
	$.ajax({
    url: 'http://localhost:8080/pessoa/deletarPessoa/' + getDadosDeletarPessoa() ,
    type: 'DELETE',
    success: function(data){
    	alert('Pessoa deletada com sucesso!');
    	listarPessoas();
        }    
    });	
}

function getDadosCadastroPessoa(){
	var formData = {
			nome: '',
			idade: 0
	};
	formData.nome = $('#nomeCadastro').val();
	formData.idade = $('#idadeCadastro').val();
	return formData;
}

function getDadosAtualizarPessoa(){
	var formData = {
			idPessoa: 0,
			nome: '',
			idade: 0
	};
	formData.idPessoa = $('#idPessoaAtualizar').val();
	formData.nome = $('#nomeAtualizar').val();
	formData.idade = $('#idadeAtualizar').val();
	return formData;
}

function getDadosDeletarPessoa(){
	return $('#idPessoaDeletar').val();
}