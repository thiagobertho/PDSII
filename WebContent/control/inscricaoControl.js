var app = angular.module('inscricaoModule',[]);

app.controller('inscricaoControl',function($scope,$http){
	
	var url = 'http://localhost:8080/SistemaEventos/rs/inscricao';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (inscricoesRetorno) {
			$scope.inscricoes = inscricoesRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.inscricao = {};
	}

    $scope.salvar = function() {
		if ($scope.inscricao.codigo == '') {
			$http.post(url,$scope.inscricao).success(function(inscricao) {
				$scope.inscricoes.push($scope.inscricao);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.inscricao).success(function(inscricao) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.inscricao.codigo == '') {
			alert('Selecione uma inscricao');
		} else {
			urlExcluir = url+'/'+$scope.inscricao.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(inscricaoTabela) {
		$scope.inscricao = inscricaoTabela;
	}
});