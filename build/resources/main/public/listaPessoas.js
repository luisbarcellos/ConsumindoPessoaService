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