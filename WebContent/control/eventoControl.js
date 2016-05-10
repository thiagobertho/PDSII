var app = angular.module('eventoModule',[]);

app.controller('eventoControl',function($scope,$http){
	
	var url = 'http://localhost:8080/SistemaEventos/rs/evento';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (eventosRetorno) {
			$scope.eventos = eventosRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.evento = {};
	}

    $scope.salvar = function() {
		if ($scope.evento.codigo == '') {
			$http.post(url,$scope.evento).success(function(evento) {
				$scope.eventos.push($scope.evento);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.evento).success(function(evento) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.evento.codigo == '') {
			alert('Selecione um evento');
		} else {
			urlExcluir = url+'/'+$scope.evento.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(eventoTabela) {
		$scope.evento = eventoTabela;
	}
});