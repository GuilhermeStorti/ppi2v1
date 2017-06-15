var app = angular.module("funcionarioControllers", []);

app.controller("funcionarioController", function($scope, $http) {
	
	var url = "http://localhost:8080/locacao/funcionarios";
	
	$scope.listar = function() {
		$http({
	        method : "GET",
	        url : url
	    }).then(function mySucces(response) {
	        $scope.funcionarios = response.data;
	    }, function myError(response) {
	        window.alert("Erro de GET!");
	    });
	};
	
	$scope.novo = function() {
		$scope.funcionario = "";
	};
	
	$scope.salvar = function() {
		if(!$scope.funcionario.identifier) {
			$http.post(url + "/", $scope.funcionario)
				.then(function(response) {
				$scope.listar();
				$scope.novo();
			}, function(response) {
				window.alert("Erro de POST!");
			});
		} else {	
			$http.put(url + "/" + $scope.funcionario.identifier, $scope.funcionario)
				.then(function(response) {
				$scope.listar();
				$scope.novo();
			}, function(response) {
				window.alert("Erro de PUT!");
			});
		}
	};
	
	$scope.editar = function(funcionarioSelecionado) {
		$scope.funcionario = angular.copy(funcionarioSelecionado);
	}
	
	$scope.deletar = function(funcionarioSelecionado) {
		if(window.confirm("Tem certeza?")) {
			$http.delete(url + "/" + funcionarioSelecionado.identifier, funcionarioSelecionado)
				.then(function(response) {
				$scope.listar();
			}, function(response) {
				window.alert("Erro de DELETE!");
			});
		}
		
	};
	
	$scope.ordenar = function(campo) {
        $scope.ordernarPor = campo;
    }
	
	$scope.listar();

});