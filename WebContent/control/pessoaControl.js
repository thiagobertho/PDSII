var app = angular.module('pessoaModule',[]);

app.controller('pessoaControl',function($scope,$http){
	
	var url = 'http://localhost:8080/SistemaEventos/rs/pessoa';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (pessoasRetorno) {
			$scope.pessoas = pessoasRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.pessoa = {};
	}

    $scope.salvar = function() {
		if ($scope.pessoa.codigo == '') {
			$http.post(url,$scope.pessoa).success(function(pessoa) {
				$scope.pessoas.push($scope.pessoa);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.pessoa).success(function(pessoa) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.pessoa.codigo == '') {
			alert('Selecione um pessoa');
		} else {
			urlExcluir = url+'/'+$scope.pessoa.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(pessoaTabela) {
		$scope.pessoa = pessoaTabela;
	}
});